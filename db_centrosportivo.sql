-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Mag 14, 2025 alle 10:09
-- Versione del server: 10.4.32-MariaDB
-- Versione PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_centrosportivo`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `username` varchar(30) NOT NULL,
  `psw` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `admin`
--

INSERT INTO `admin` (`id`, `username`, `psw`) VALUES
(1, 'admin', 'admin');

-- --------------------------------------------------------

--
-- Struttura della tabella `evento`
--

CREATE TABLE `evento` (
  `id` int(11) NOT NULL,
  `foto` longtext DEFAULT NULL,
  `nome` varchar(50) NOT NULL,
  `ricezione` datetime NOT NULL,
  `costo` int(11) NOT NULL,
  `campo` varchar(10) NOT NULL,
  `descrizione` varchar(255) NOT NULL,
  `partecipanti` int(11) NOT NULL,
  `id_indirizzo` int(11) NOT NULL,
  `id_sport` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `evento`
--

INSERT INTO `evento` (`id`, `foto`, `nome`, `ricezione`, `costo`, `campo`, `descrizione`, `partecipanti`, `id_indirizzo`, `id_sport`) VALUES
(1, 'foto1.jpg', 'Torneo di Calcio', '2025-06-15 10:00:00', 20, 'Campo A', 'Torneo amatoriale di calcio a 5.', 10, 1, 1),
(2, 'foto2.jpg', 'Open Tennis', '2025-06-20 14:00:00', 15, 'Campo B', 'Incontro di tennis per dilettanti.', 4, 1, 2),
(3, 'foto3.jpg', 'Basket Night', '2025-06-25 18:00:00', 10, 'Campo C', 'Sfida serale di basket 3 vs 3.', 6, 1, 3),
(6, '', 'fwa', '2025-05-07 10:50:00', 3, '3', 'fwa', 1, 1, 3);

-- --------------------------------------------------------

--
-- Struttura della tabella `indirizzo`
--

CREATE TABLE `indirizzo` (
  `id` int(11) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `cap` varchar(5) NOT NULL,
  `provincia` varchar(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `indirizzo`
--

INSERT INTO `indirizzo` (`id`, `nome`, `cap`, `provincia`) VALUES
(1, 'Via dello Sport 10', '00100', 'RM');

-- --------------------------------------------------------

--
-- Struttura della tabella `sport`
--

CREATE TABLE `sport` (
  `id` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dump dei dati per la tabella `sport`
--

INSERT INTO `sport` (`id`, `nome`) VALUES
(1, 'Calcio'),
(2, 'Tennis'),
(3, 'Basket');

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `evento`
--
ALTER TABLE `evento`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_indirizzo` (`id_indirizzo`),
  ADD KEY `id_sport` (`id_sport`);

--
-- Indici per le tabelle `indirizzo`
--
ALTER TABLE `indirizzo`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `sport`
--
ALTER TABLE `sport`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT per la tabella `evento`
--
ALTER TABLE `evento`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT per la tabella `indirizzo`
--
ALTER TABLE `indirizzo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT per la tabella `sport`
--
ALTER TABLE `sport`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `evento`
--
ALTER TABLE `evento`
  ADD CONSTRAINT `evento_ibfk_1` FOREIGN KEY (`id_indirizzo`) REFERENCES `indirizzo` (`id`),
  ADD CONSTRAINT `evento_ibfk_2` FOREIGN KEY (`id_sport`) REFERENCES `sport` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
