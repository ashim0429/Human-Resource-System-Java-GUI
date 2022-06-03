-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 08, 2022 at 09:23 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hrm`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `Uname` varchar(50) DEFAULT NULL,
  `pass` varchar(150) DEFAULT NULL,
  `Role` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`Uname`, `pass`, `Role`) VALUES
('admin', 'admin', 'Admin');

-- --------------------------------------------------------

--
-- Table structure for table `employeelogin`
--

CREATE TABLE `employeelogin` (
  `name` varchar(100) DEFAULT NULL,
  `email` varchar(150) DEFAULT NULL,
  `username` varchar(100) DEFAULT NULL,
  `pass` varchar(50) DEFAULT NULL,
  `role` varchar(50) DEFAULT NULL,
  `ID` int(11) DEFAULT NULL,
  `post` varchar(10) DEFAULT NULL,
  `salary` int(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `employeelogin`
--

INSERT INTO `employeelogin` (`name`, `email`, `username`, `pass`, `role`, `ID`, `post`, `salary`) VALUES
('Prerana', 'prerana@hrm.com', 'prerana', 'asd', 'Employee', 656, 'CEO', 100000);

-- --------------------------------------------------------

--
-- Table structure for table `leave_employee`
--

CREATE TABLE `leave_employee` (
  `name` varchar(150) NOT NULL,
  `date` varchar(10) NOT NULL,
  `Reason` varchar(150) NOT NULL,
  `Status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `leave_employee`
--

INSERT INTO `leave_employee` (`name`, `date`, `Reason`, `Status`) VALUES
('Rachna', '2022/05/10', 'Family Stuff', 1);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
