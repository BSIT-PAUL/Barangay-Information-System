package barangay.information.system;

import com.mysql.jdbc.Connection;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.TableColumn;

public class MemberTable1 extends JFrame implements ActionListener {
    private JLabel label;
    private JTextField textField;
    private JButton button;
    private JTable table;
    private JButton submitButton;
    
    java.sql.Connection Con = null;
Statement St = null;
ResultSet Rs= null;

    public MemberTable1() {
        
        
      
         // textField = new JTextField(), 10);
         // JTextField textField = new JTextField(20);
          //textField.setText("");
        //textField.setEditable(true); // disable editing
        button = new JButton("Create table");
        button.addActionListener(this);
        submitButton = new JButton("Submit");
        submitButton.setVisible(false);
        submitButton.addActionListener(this);
        JPanel inputPanel = new JPanel();
        //inputPanel.add(label);
       //inputPanel.add(textField);       
        inputPanel.add(button);
        inputPanel.add(submitButton);
        
        

        add(inputPanel, "North");

        pack();
           setSize(700, 500);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        
    }


    public static void main(String[] args) {
        new MemberTable1();
        
        
    }

    @Override
   public void actionPerformed(ActionEvent e) {
       
       
    if (e.getSource() == button) {
        // Create the table
        String numMemberss = JOptionPane.showInputDialog("Enter Number of Members");
       
       //String text = textField.getText();
        int numMembers = Integer.parseInt(numMemberss);
        String[] columnNames = {"LastName", "FirstName", "MiddleName", "Suffix", "Age", "Sex", "Status", "BirthDate", "Relationship", "Religion", "PhoneNumber", "Email", "Educational", "Housenumber"};
        Object[][] data = new Object[numMembers][14];
        String[] sexOptions = {"Male", "Female"};
        String[] suffixOptions = {" ", "Jr.", "Sr.", " I", " II", "III", "IV" };
        String[] statusOptions = {"Single ", "Married", "Divorced ", "Widowed ", "Separated " };
        String[] educationalOptions = {"College Graduate", "College Undergraduate", "High School Graduate", "High School Undergraduate", "Elementary Graduate", "Elementary Graduate", "Elementary Undergraduate", "None"};
        
        for (int i = 0; i < numMembers; i++) {  
            data[i][0] = "";
            data[i][1] = "";
            data[i][2] = "";
            data[i][3] = new JComboBox<>(suffixOptions);
            data[i][4] = "";
            data[i][5] = new JComboBox<>(sexOptions);
            data[i][6] = new JComboBox<>(statusOptions);
            data[i][7] = "";
            data[i][8] = "";
            data[i][9] = "";
            data[i][10] = "";
            data[i][11] = "";
            data[i][12] = new JComboBox<>(educationalOptions);
            data[i][13] = "";

        }

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        table = new JTable(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
         // Set the cell editor for the "Sex" column to the JComboBox
        int sexColumnIndex = model.findColumn("Sex");
        TableColumn sexColumn = table.getColumnModel().getColumn(sexColumnIndex);
        sexColumn.setCellEditor(new DefaultCellEditor(new JComboBox<>(sexOptions)));
        
        int suffixColumnIndex = model.findColumn("Suffix");
        TableColumn suffixColumn = table.getColumnModel().getColumn(suffixColumnIndex);
        suffixColumn.setCellEditor(new DefaultCellEditor(new JComboBox<>(suffixOptions)));
        
        int statusColumnIndex = model.findColumn("Status");
        TableColumn statusColumn = table.getColumnModel().getColumn(statusColumnIndex);
        statusColumn.setCellEditor(new DefaultCellEditor(new JComboBox<>(statusOptions)));
        
        int educationalColumnIndex = model.findColumn("Educational");
        TableColumn educationalColumn = table.getColumnModel().getColumn(educationalColumnIndex);
        educationalColumn.setCellEditor(new DefaultCellEditor(new JComboBox<>(educationalOptions)));
        
        
        
         if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setResizable(false);
            table.getColumnModel().getColumn(0).setPreferredWidth(100);
            table.getColumnModel().getColumn(1).setResizable(false);
            table.getColumnModel().getColumn(1).setPreferredWidth(100);
            table.getColumnModel().getColumn(2).setResizable(false);
            table.getColumnModel().getColumn(2).setPreferredWidth(100);
            table.getColumnModel().getColumn(3).setResizable(false);
            table.getColumnModel().getColumn(3).setPreferredWidth(100);
            table.getColumnModel().getColumn(4).setResizable(false);
            table.getColumnModel().getColumn(4).setPreferredWidth(100);
            table.getColumnModel().getColumn(5).setResizable(false);
            table.getColumnModel().getColumn(5).setPreferredWidth(100);
            table.getColumnModel().getColumn(6).setResizable(false);
            table.getColumnModel().getColumn(6).setPreferredWidth(100);
            table.getColumnModel().getColumn(7).setResizable(false);
            table.getColumnModel().getColumn(7).setPreferredWidth(100);
            table.getColumnModel().getColumn(8).setResizable(false);
            table.getColumnModel().getColumn(8).setPreferredWidth(100);
            table.getColumnModel().getColumn(9).setResizable(false);
            table.getColumnModel().getColumn(9).setPreferredWidth(100);
            table.getColumnModel().getColumn(10).setResizable(false);
            table.getColumnModel().getColumn(10).setPreferredWidth(100);
            table.getColumnModel().getColumn(11).setResizable(false);
            table.getColumnModel().getColumn(11).setPreferredWidth(100);
            table.getColumnModel().getColumn(12).setResizable(false);
            table.getColumnModel().getColumn(12).setPreferredWidth(150);
         
        }

        
        
       
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(700, 500));
        add(scrollPane, BorderLayout.CENTER);

        submitButton.setVisible(true);
        pack();
    } else if (e.getSource() == submitButton) {
        // Save the data to the database
        try {
            // Connect to the database
              Con= DriverManager.getConnection("jdbc:mysql://localhost:3307/brgydata","root","");
              //String text = FamilyHeads.member_no.getText();
       
            // Get the data from the table
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            int numRows = model.getRowCount();
            for (int i = 0; i < numRows; i++) {
               String LastName =  model.getValueAt(i, 0).toString();
                String FirstName = model.getValueAt(i, 1).toString();
                String MiddleName =  model.getValueAt(i, 2).toString();
                String Suffix =  model.getValueAt(i, 3).toString();
                //String Suffix = ((JComboBox<String>)model.getValueAt(i, 3)).getSelectedItem().toString();
                int Age = Integer.parseInt(model.getValueAt(i, 4).toString());
                String Sex = model.getValueAt(i, 5).toString();
               //String Sex = ((JComboBox<String>)model.getValueAt(i, 5)).getSelectedItem().toString();
               String Status = model.getValueAt(i, 6).toString();
               // String Status = ((JComboBox<String>)model.getValueAt(i, 6)).getSelectedItem().toString();
                String BirthDate = model.getValueAt(i, 7).toString();
                String Relationship = model.getValueAt(i, 8).toString();
                String Religion =  model.getValueAt(i, 9).toString();
                int PhoneNumber = Integer.parseInt(model.getValueAt(i, 10).toString());
                String Email = model.getValueAt(i, 11).toString();
                String Educational = model.getValueAt(i, 12).toString();
                int Housenumber = Integer.parseInt(model.getValueAt(i, 13).toString());
             
                //String Educational = ((JComboBox<String>)model.getValueAt(i, 12)).getSelectedItem().toString();
               
                
                
                // Insert the data into the database
                String query = "INSERT INTO familymembers(LastName,FirstName,MiddleName,Suffix,Age,Sex,BirthDate, Status,Relationship,Religion,PhoneNumber,Email,Educational,homeID_fk) Values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement stmt = Con.prepareStatement(query);
                stmt.setString(1, LastName);
                stmt.setString(2, FirstName);
                stmt.setString(3, MiddleName);
                stmt.setString(4, Suffix);
                stmt.setInt(5, Age);
                stmt.setString(6, Sex);
                stmt.setString(7, BirthDate);
                stmt.setString(8, Status);
                stmt.setString(9, Relationship);
                stmt.setString(10, Religion);
                stmt.setInt(11, PhoneNumber);
                stmt.setString(12, Email);
                stmt.setString(13, Educational);
                stmt.setInt(14, Housenumber);
                stmt.executeUpdate();
            }
                
            // Close the database connection
            Con.close();

            // Show a message to confirm that the data has been saved
            JOptionPane.showMessageDialog(this, "Data has been saved to the database.");
            this.dispose();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }
   }}