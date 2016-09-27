-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Erstellungszeit: 27. Sep 2016 um 20:27
-- Server-Version: 10.1.16-MariaDB
-- PHP-Version: 7.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `pizzacontrol`
--
CREATE DATABASE IF NOT EXISTS `pizzacontrol` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `pizzacontrol`;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `cities`
--

DROP TABLE IF EXISTS `cities`;
CREATE TABLE `cities` (
  `zip` varchar(8) NOT NULL,
  `name` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Daten für Tabelle `cities`
--

INSERT INTO `cities` (`zip`, `name`) VALUES
('28201', 'Bremen'),
('28259', 'Bremen');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `customers`
--

DROP TABLE IF EXISTS `customers`;
CREATE TABLE `customers` (
  `id` int(3) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `firstname` varchar(50) DEFAULT NULL,
  `username` varchar(30) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `street` varchar(80) DEFAULT NULL,
  `housenumber` varchar(4) DEFAULT NULL,
  `zip` varchar(8) DEFAULT NULL,
  `phone` varchar(30) DEFAULT NULL,
  `mobile` varchar(30) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Daten für Tabelle `customers`
--

INSERT INTO `customers` (`id`, `name`, `firstname`, `username`, `password`, `street`, `housenumber`, `zip`, `phone`, `mobile`, `email`) VALUES
(1, 'Maier', 'Harry', 'harrym', '081500', 'Kornstraße', '600', '28201', NULL, NULL, 'harry@gmx.de');

-- --------------------------------------------------------

--
-- Stellvertreter-Struktur des Views `custwithcity`
--
DROP VIEW IF EXISTS `custwithcity`;
CREATE TABLE `custwithcity` (
`id` int(3)
,`name` varchar(50)
,`firstname` varchar(50)
,`username` varchar(30)
,`password` varchar(50)
,`street` varchar(80)
,`houseNumber` varchar(4)
,`zip` varchar(8)
,`phone` varchar(30)
,`mobile` varchar(30)
,`email` varchar(50)
,`city` varchar(30)
);

-- --------------------------------------------------------

--
-- Struktur des Views `custwithcity`
--
DROP TABLE IF EXISTS `custwithcity`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `custwithcity`  AS  select `cu`.`id` AS `id`,`cu`.`name` AS `name`,`cu`.`firstname` AS `firstname`,`cu`.`username` AS `username`,`cu`.`password` AS `password`,`cu`.`street` AS `street`,`cu`.`housenumber` AS `houseNumber`,`cu`.`zip` AS `zip`,`cu`.`phone` AS `phone`,`cu`.`mobile` AS `mobile`,`cu`.`email` AS `email`,`ci`.`name` AS `city` from (`customers` `cu` left join `cities` `ci` on((`cu`.`zip` = `ci`.`zip`))) ;

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `cities`
--
ALTER TABLE `cities`
  ADD PRIMARY KEY (`zip`);

--
-- Indizes für die Tabelle `customers`
--
ALTER TABLE `customers`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT für exportierte Tabellen
--

--
-- AUTO_INCREMENT für Tabelle `customers`
--
ALTER TABLE `customers`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
