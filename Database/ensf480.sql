-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: ensf480
-- ------------------------------------------------------
-- Server version	8.0.28


DROP DATABASE IF EXISTS `ENSF480`;
CREATE DATABASE `ENSF480` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `ENSF480`;

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `firstName` varchar(20) DEFAULT NULL,
  `lastName` varchar(20) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `cardNumber` varchar(20) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`firstName`, `lastName`, `address`, `cardNumber`, `email`, `username`, `password`) VALUES
('Rachel', 'Dalton', '14 Edgeridge Drive NW', '1234567891011121', 'rachel.dalton@ucalgary.ca', 'rdalton', 'ensf');

-- --------------------------------------------------------

--
-- Table structure for table `movie`
--

CREATE TABLE `movie` (
  `movieID` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `movie`
--

INSERT INTO `movie` (`movieID`, `name`) VALUES
(0, 'Rio');

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `fName` varchar(30) DEFAULT NULL,
  `lName` varchar(30) DEFAULT NULL,
  `cardNumber` varchar(30) DEFAULT NULL,
  `amount` double DEFAULT NULL,
  `date` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `seat`
--

CREATE TABLE `seat` (
  `seatID` int(11) NOT NULL,
  `showtimeID` int(11) DEFAULT NULL,
  `vacant` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `seat`
--

INSERT INTO `seat` (`seatID`, `showtimeID`, `vacant`) VALUES
(0, 0, 1),
(1, 0, 1),
(2, 0, 1),
(3, 0, 1),
(4, 0, 1),
(5, 1, 1),
(6, 1, 1),
(7, 1, 1),
(8, 1, 1),
(9, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `showtime`
--

CREATE TABLE `showtime` (
  `showtimeID` int(11) NOT NULL,
  `time` datetime DEFAULT NULL,
  `movieID` int(11) DEFAULT NULL,
  `theatreID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `showtime`
--

INSERT INTO `showtime` (`showtimeID`, `time`, `movieID`, `theatreID`) VALUES
(0, '2022-12-19 15:30:00', 0, 0),
(1, '2022-12-22 17:15:00', 0, 1);

-- --------------------------------------------------------

--
-- Table structure for table `theatre`
--

CREATE TABLE `theatre` (
  `theatreID` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `theatre`
--

INSERT INTO `theatre` (`theatreID`, `name`) VALUES
(0, 'Chinook'),
(1, 'Westhills');

-- --------------------------------------------------------

--
-- Table structure for table `ticket`
--

CREATE TABLE `ticket` (
  `ticketID` int(11) NOT NULL,
  `seatID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `movie`
--
ALTER TABLE `movie`
  ADD PRIMARY KEY (`movieID`);

--
-- Indexes for table `seat`
--
ALTER TABLE `seat`
  ADD PRIMARY KEY (`seatID`),
  ADD KEY `showtimeID_idx` (`showtimeID`);

--
-- Indexes for table `showtime`
--
ALTER TABLE `showtime`
  ADD PRIMARY KEY (`showtimeID`),
  ADD KEY `movieID_idx` (`movieID`),
  ADD KEY `theatreID_idx` (`theatreID`);

--
-- Indexes for table `theatre`
--
ALTER TABLE `theatre`
  ADD PRIMARY KEY (`theatreID`);

--
-- Indexes for table `ticket`
--
ALTER TABLE `ticket`
  ADD PRIMARY KEY (`ticketID`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `seat`
--
ALTER TABLE `seat`
  ADD CONSTRAINT `showtimeID` FOREIGN KEY (`showtimeID`) REFERENCES `showtime` (`showtimeID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `showtime`
--
ALTER TABLE `showtime`
  ADD CONSTRAINT `movieID` FOREIGN KEY (`movieID`) REFERENCES `movie` (`movieID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `theatreID` FOREIGN KEY (`theatreID`) REFERENCES `theatre` (`theatreID`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

