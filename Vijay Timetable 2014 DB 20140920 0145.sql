-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.89-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema timetable11
--

CREATE DATABASE IF NOT EXISTS timetable11;
USE timetable11;

--
-- Definition of table `facultyinfo`
--

DROP TABLE IF EXISTS `facultyinfo`;
CREATE TABLE `facultyinfo` (
  `FacultyID` varchar(30) NOT NULL,
  `FacultyName` varchar(100) default NULL,
  `EmailID` varchar(100) default NULL,
  PRIMARY KEY  (`FacultyID`),
  UNIQUE KEY `EmailID` (`EmailID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `facultyinfo`
--

/*!40000 ALTER TABLE `facultyinfo` DISABLE KEYS */;
INSERT INTO `facultyinfo` (`FacultyID`,`FacultyName`,`EmailID`) VALUES 
 ('Ankita S123','Ankita Sharma','ankitasharma@hec.edu.in'),
 ('Rooz M123','Rooz Munjal','roozmunjal@hec.edu.in');
/*!40000 ALTER TABLE `facultyinfo` ENABLE KEYS */;


--
-- Definition of table `facultysubject`
--

DROP TABLE IF EXISTS `facultysubject`;
CREATE TABLE `facultysubject` (
  `SrNo` int(11) NOT NULL auto_increment,
  `FacultyID` varchar(30) default NULL,
  `SubjectID` varchar(30) default NULL,
  `Iscurrent` enum('yes','no') default NULL,
  PRIMARY KEY  (`SrNo`),
  KEY `FacultyID` (`FacultyID`),
  KEY `SubjectID` (`SubjectID`),
  CONSTRAINT `facultysubject_ibfk_1` FOREIGN KEY (`FacultyID`) REFERENCES `facultyinfo` (`FacultyID`),
  CONSTRAINT `facultysubject_ibfk_2` FOREIGN KEY (`SubjectID`) REFERENCES `subjectinfo` (`SubjectID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `facultysubject`
--

/*!40000 ALTER TABLE `facultysubject` DISABLE KEYS */;
INSERT INTO `facultysubject` (`SrNo`,`FacultyID`,`SubjectID`,`Iscurrent`) VALUES 
 (5,'Ankita S123','CSE 207 E','no'),
 (6,'Rooz M123','CSE 201 E','yes');
/*!40000 ALTER TABLE `facultysubject` ENABLE KEYS */;


--
-- Definition of table `logininfo`
--

DROP TABLE IF EXISTS `logininfo`;
CREATE TABLE `logininfo` (
  `UserName` varchar(100) NOT NULL,
  `Password` varchar(100) default NULL,
  `RoleName` varchar(100) default NULL,
  PRIMARY KEY  (`UserName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `logininfo`
--

/*!40000 ALTER TABLE `logininfo` DISABLE KEYS */;
INSERT INTO `logininfo` (`UserName`,`Password`,`RoleName`) VALUES 
 ('Admin','1812390','Admin'),
 ('vijay','390','User');
/*!40000 ALTER TABLE `logininfo` ENABLE KEYS */;


--
-- Definition of table `roomallocation`
--

DROP TABLE IF EXISTS `roomallocation`;
CREATE TABLE `roomallocation` (
  `SrNo` int(11) NOT NULL auto_increment,
  `FacultyID` varchar(30) default NULL,
  `SubjectID` varchar(30) default NULL,
  `RoomID` varchar(30) default NULL,
  `DayName` varchar(30) default NULL,
  `LectureTime` time default NULL,
  `IsActive` enum('yes','no') default NULL,
  PRIMARY KEY  (`SrNo`),
  KEY `FacultyID` (`FacultyID`),
  KEY `SubjectID` (`SubjectID`),
  KEY `RoomID` (`RoomID`),
  CONSTRAINT `roomallocation_ibfk_1` FOREIGN KEY (`FacultyID`) REFERENCES `facultyinfo` (`FacultyID`),
  CONSTRAINT `roomallocation_ibfk_2` FOREIGN KEY (`SubjectID`) REFERENCES `subjectinfo` (`SubjectID`),
  CONSTRAINT `roomallocation_ibfk_3` FOREIGN KEY (`RoomID`) REFERENCES `roominfo` (`RoomID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `roomallocation`
--

/*!40000 ALTER TABLE `roomallocation` DISABLE KEYS */;
INSERT INTO `roomallocation` (`SrNo`,`FacultyID`,`SubjectID`,`RoomID`,`DayName`,`LectureTime`,`IsActive`) VALUES 
 (1,'Rooz M123','CSE 201 E','E 401','Monday','08:50:00','yes');
/*!40000 ALTER TABLE `roomallocation` ENABLE KEYS */;


--
-- Definition of table `roominfo`
--

DROP TABLE IF EXISTS `roominfo`;
CREATE TABLE `roominfo` (
  `RoomID` varchar(30) NOT NULL,
  `RoomName` varchar(100) default NULL,
  `NoofChair` int(11) default NULL,
  PRIMARY KEY  (`RoomID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `roominfo`
--

/*!40000 ALTER TABLE `roominfo` DISABLE KEYS */;
INSERT INTO `roominfo` (`RoomID`,`RoomName`,`NoofChair`) VALUES 
 ('E 401','CSE ROOM',30);
/*!40000 ALTER TABLE `roominfo` ENABLE KEYS */;


--
-- Definition of table `subjectinfo`
--

DROP TABLE IF EXISTS `subjectinfo`;
CREATE TABLE `subjectinfo` (
  `SubjectID` varchar(30) NOT NULL,
  `Description` varchar(2000) default NULL,
  `SubjectName` varchar(100) default NULL,
  PRIMARY KEY  (`SubjectID`),
  UNIQUE KEY `SubjectName` (`SubjectName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `subjectinfo`
--

/*!40000 ALTER TABLE `subjectinfo` DISABLE KEYS */;
INSERT INTO `subjectinfo` (`SubjectID`,`Description`,`SubjectName`) VALUES 
 ('CSE 201 E','Computer Architecture & Organisations','COA'),
 ('CSE 207 E','Fundamentals of Management','FOM');
/*!40000 ALTER TABLE `subjectinfo` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
