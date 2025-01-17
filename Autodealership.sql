-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Φιλοξενητής: 127.0.0.1
-- Χρόνος δημιουργίας: 30 Νοε 2022 στις 21:39:44
-- Έκδοση διακομιστή: 10.4.14-MariaDB
-- Έκδοση PHP: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Βάση δεδομένων: `Autodealership`
--

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `costumer`
--

CREATE TABLE `customer` (
  `id` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `lastname` varchar(100) NOT NULL,
   `Email` varchar(100) NOT NULL, 
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4; 

CREATE TABLE `dealership` (
  `id` varchar(100) NOT NULL,
  `dname` varchar(100) NOT NULL,
   `owner` varchar(100) NOT NULL, 
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4; 

CREATE TABLE `Car` (
  `id` varchar(100) NOT NULL,
  `Brand` varchar(100) NOT NULL,
  `model` varchar(100) NOT NULL,
   `fuel` varchar(100) NOT NULL, 
  `engine` varchar(100) NOT NULL,
  `seats` int(11) NOT NULL, 
  `price` int(11) NOT NULL, 
  `moreinfo` varchar(100) NOT NULL, 
  `Numofcars` int(11) NOT NULL, 
  `dealership_id` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4; 

CREATE TABLE `Bookings` (
  `costumer_id` varchar(100) NOT NULL,
  `car_id` varchar(100) NOT NULL,
   `booking_date` DATE NOT NULL,
    `booking_time` TIME(6) NOT NULL 
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4; 

--
-- Άδειασμα δεδομένων του πίνακα `students`
--

/*INSERT INTO `student` (`name`, `age`, `location`) VALUES
('Alex', 48, 'Salonica'),
('Apostolis', 43, 'Thessaloniki'),
('Daniel', 35, 'Groningen');
*/
--
-- Ευρετήρια για άχρηστους πίνακες
--

--
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`);
ALTER TABLE `dealership`
  ADD PRIMARY KEY (`id`); 
ALTER TABLE `Car`
  ADD PRIMARY KEY (`id`);
ALTER TABLE `Bookings`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
