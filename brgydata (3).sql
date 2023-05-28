-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3307
-- Generation Time: May 28, 2023 at 01:18 PM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `brgydata`
--

-- --------------------------------------------------------

--
-- Table structure for table `familyhead`
--

CREATE TABLE `familyhead` (
  `Head_ID` int(11) NOT NULL,
  `Family_Heads` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `familyhead`
--

INSERT INTO `familyhead` (`Head_ID`, `Family_Heads`) VALUES
(1, 'Bayoneto Nestor'),
(2, 'Adams John'),
(3, 'Nasol Maria'),
(4, 'Bans Adamsa'),
(5, 'Smith John'),
(7, 'asfasfas asdasd');

-- --------------------------------------------------------

--
-- Table structure for table `familyhome`
--

CREATE TABLE `familyhome` (
  `Home_ID` int(11) NOT NULL,
  `Family_Name` varchar(100) NOT NULL,
  `Family_Address` varchar(255) NOT NULL,
  `House_number` int(11) NOT NULL,
  `headID_fk` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `familyhome`
--

INSERT INTO `familyhome` (`Home_ID`, `Family_Name`, `Family_Address`, `House_number`, `headID_fk`) VALUES
(1, 'Bayoneto', 'Uno, Calatagan, Batangas', 1, 1),
(2, 'Adams', 'Nasugbu, Batangas', 2, 2),
(3, 'Nasol', 'Balitoc,Calatagan,Batangas', 3, 3),
(7, 'asfasfas', 'sa aknto lang', 7, 7),
(35, 'Smith', 'Nasugbu Batangas', 35, 5),
(54, 'Bans', 'Bucana Nasugbu Batangas', 54, 4);

-- --------------------------------------------------------

--
-- Table structure for table `familymembers`
--

CREATE TABLE `familymembers` (
  `Member_ID` int(11) NOT NULL,
  `LastName` varchar(100) NOT NULL,
  `FirstName` varchar(100) NOT NULL,
  `MiddleName` varchar(100) NOT NULL,
  `Suffix` varchar(10) NOT NULL,
  `Age` int(11) NOT NULL,
  `Sex` varchar(100) NOT NULL,
  `BirthDate` date NOT NULL,
  `Status` varchar(100) NOT NULL,
  `Relationship` varchar(50) NOT NULL,
  `Religion` varchar(100) NOT NULL,
  `PhoneNumber` int(11) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `Educational` varchar(150) NOT NULL,
  `homeID_fk` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `familymembers`
--

INSERT INTO `familymembers` (`Member_ID`, `LastName`, `FirstName`, `MiddleName`, `Suffix`, `Age`, `Sex`, `BirthDate`, `Status`, `Relationship`, `Religion`, `PhoneNumber`, `Email`, `Educational`, `homeID_fk`) VALUES
(1, 'Bayoneto', 'Nestor', 'Villaruel', ' ', 54, 'Male', '1970-02-27', 'Married', 'Head', 'Catholic', 1232123, 'nestor@gmail.com', 'High School Graduate', 1),
(2, 'Adams', 'John', 'Mas', ' ', 53, 'Male', '1970-03-06', 'Single ', 'Head', 'Catholic', 1231231421, 'John@gmail.com', 'College Graduate', 2),
(3, 'Nasol', 'Maria', 'Forbes', ' ', 45, 'Female', '1977-07-17', 'Separated ', 'Head', 'Catholic', 98643773, 'nasol@gmail.com', 'High School Graduate', 3),
(4, 'Bans', 'Adamsa', 'des', ' ', 42, 'Male', '1970-10-12', 'Married', 'Head', 'Catholic', 535453, 'asd@gmail.com', 'College Undergraduate', 54),
(5, 'Smith', 'John', 'Let', ' ', 45, 'Male', '1970-10-30', 'Married', 'Head', 'Catholic', 435345, 'john@gmail.com', 'College Graduate', 35),
(7, 'asfasfas', 'asdasd', 'asd', ' ', 12, 'Male', '1970-10-17', 'Single ', 'Head', 'CAtg', 5464564, 'asd@gmail.com', 'Elementary Graduate', 7),
(90, 'Bayoneto', 'John Paul', 'Delayola', ' ', 20, 'Male', '2002-10-17', 'Single ', 'Son', 'Catholic', 23423423, 'Johnpaul@gmail.com', 'College Undergraduate', 1),
(92, 'Bayoneto', 'Maria Angela', 'Delayola', ' ', 22, 'Female', '2000-11-30', 'Single ', 'Daughter', 'Catholic', 2423424, 'angela@gmail.com', 'College Undergraduate', 1),
(93, 'Adams', 'Jane', 'Mas', ' ', 50, 'Female', '1974-05-14', 'Married', 'Spouse', 'Catholic', 12312312, 'Jane@gmail.com', 'College Graduate', 2),
(94, 'Adams', 'John Joe', 'Mas', ' ', 12, 'Male', '2011-03-06', 'Single ', 'Son', 'Catholic', 124123123, 'jj@gmail.com', 'Elementary Undergraduate', 2),
(97, 'Adams', 'Sarah', 'Mas', ' ', 8, 'Female', '2015-09-20', 'Married', 'Daughter', 'Catholic', 123123123, 'sarah@gmail.com', 'Elementary Undergraduate', 2),
(98, 'Nasol', 'Lovely', 'Forbes', ' ', 20, 'Male', '2002-11-02', 'Single ', 'Daughter', 'Christian', 8787845, 'lovely@gmail.com', 'College Undergraduate', 3);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `Uname` varchar(20) NOT NULL,
  `Upass` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`Uname`, `Upass`) VALUES
('Admin', '123');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `familyhead`
--
ALTER TABLE `familyhead`
  ADD PRIMARY KEY (`Head_ID`),
  ADD UNIQUE KEY `unique_family_head` (`Head_ID`);

--
-- Indexes for table `familyhome`
--
ALTER TABLE `familyhome`
  ADD PRIMARY KEY (`Home_ID`),
  ADD KEY `headID_fk` (`headID_fk`);

--
-- Indexes for table `familymembers`
--
ALTER TABLE `familymembers`
  ADD PRIMARY KEY (`Member_ID`),
  ADD KEY `homeID_fk` (`homeID_fk`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `familymembers`
--
ALTER TABLE `familymembers`
  MODIFY `Member_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=101;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `familyhome`
--
ALTER TABLE `familyhome`
  ADD CONSTRAINT `headID_fk` FOREIGN KEY (`headID_fk`) REFERENCES `familyhead` (`Head_ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `familymembers`
--
ALTER TABLE `familymembers`
  ADD CONSTRAINT `homeID_fk` FOREIGN KEY (`homeID_fk`) REFERENCES `familyhome` (`Home_ID`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
