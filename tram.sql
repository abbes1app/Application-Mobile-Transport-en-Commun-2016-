-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Mar 07 Juin 2016 à 12:51
-- Version du serveur :  5.7.9
-- Version de PHP :  5.6.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `tram`
--

-- --------------------------------------------------------

--
-- Structure de la table `infotrafic`
--

DROP TABLE IF EXISTS `infotrafic`;
CREATE TABLE IF NOT EXISTS `infotrafic` (
  `id` int(100) NOT NULL,
  `Nom` varchar(200) NOT NULL,
  `type` varchar(200) NOT NULL,
  `contenu` text NOT NULL,
  `heured` datetime NOT NULL,
  `heuref` datetime NOT NULL,
  `etat` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `markers`
--

DROP TABLE IF EXISTS `markers`;
CREATE TABLE IF NOT EXISTS `markers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(100) NOT NULL,
  `lat` text NOT NULL,
  `lng` text NOT NULL,
  `etatS` varchar(100) NOT NULL,
  `type` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=27 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `markers`
--

INSERT INTO `markers` (`id`, `Nom`, `lat`, `lng`, `etatS`, `type`) VALUES
(1, 'Le Rocher', '-0.6092131', '35.2236078', 'off', 'tram'),
(2, '4horloges', '-0.6340827', '35.1907590', 'off', 'tram'),
(3, 'petit Vichy', '-0.6292730', '35.1914282', 'off', 'tram'),
(4, 'Cascade', '-0.6292730', '35.2102234', 'off', 'tram'),
(5, 'Gare Routiere', '-0.6139107 ', '35.2128532', 'off', 'tram'),
(6, 'Cite Aadl Benhamouda', '-0.6239696', '35.2201147', 'off', 'tram'),
(7, 'Benhamouda', '-0.6230255', '35.2174852', 'On', 'tram'),
(8, 'Gare Routiere Nord\r\n', '-0.6296344', '35.2231999', 'On', 'tram'),
(9, 'GareFerroviaire', '-0.6305786', '35.2246723', 'On', 'tram'),
(10, 'Campus', '-0.6423803', '35.2206756', 'On', 'tram'),
(11, 'Faculte de Droit\r\n', '-0.6330677', '35.2163282', 'On', 'tram'),
(12, 'Sidi Djilali', '-0.6243836', '35.2161752', 'On', 'tram'),
(13, 'Wiaam', '-0.6272590', '35.2102847', 'On', 'tram'),
(14, 'Azzouz', '-0.6254565', '35.2031314', 'On', 'tram'),
(15, 'HBoumedienne', '-0.6191050', '35.2011677', 'On', 'tram'),
(16, 'Sbyka', '-0.6125390', '35.1946448', 'On', 'tram'),
(17, 'Maternite', '-0.6149852', '35.1927510', 'On', 'tram'),
(18, 'Sidi Yacine', '-0.6187617', '35.1926107', 'On', 'tram'),
(19, 'Jardin', '-0.6422793', '35.1904012', 'On', 'tram'),
(20, 'Gare Routiere Sud\r\n', '-0.6495749', '35.1859469', 'On', 'tram'),
(21, 'Rectorat', '-0.6600892', '35.1788616', 'On', 'tram'),
(22, 'Institut Science Medicale', '-0.6449401', '35.1798438', 'On', 'tram'),
(23, 'BD.Amara', '-0.6352412', '35.1802647', 'On', 'tram'),
(24, 'Cite 20 AOUT\r\n', '-0.6267440', '35.1816327', 'On', 'tram'),
(25, 'Mexique', '-0.6394620', '35.2172748 ', 'On', 'tram'),
(26, 'Gare feroviere T', '-0.638310', '35.199187', 'on', 'train');

-- --------------------------------------------------------

--
-- Structure de la table `trainhor`
--

DROP TABLE IF EXISTS `trainhor`;
CREATE TABLE IF NOT EXISTS `trainhor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(200) NOT NULL,
  `Direction` varchar(200) NOT NULL,
  `HeureC` datetime NOT NULL,
  `HeureA` datetime NOT NULL,
  `etat` varchar(200) NOT NULL,
  `HeureAR` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `trainhor`
--

INSERT INTO `trainhor` (`id`, `Nom`, `Direction`, `HeureC`, `HeureA`, `etat`, `HeureAR`) VALUES
(1, 'Gare feroviere T', 'Oran', '2016-05-24 18:00:00', '2016-05-24 19:46:00', 'on', '2016-05-26 05:00:00'),
(2, 'Gare feroviere T', 'Oran', '2016-05-24 19:26:00', '2016-05-24 19:26:00', 'on', '2016-05-26 00:00:00'),
(3, 'Gare feroviere T', 'Oran', '2016-05-24 23:59:00', '2016-05-24 23:59:00', 'off', '2016-05-26 00:00:00'),
(4, 'Gare feroviere T', 'Oran', '2016-05-24 20:16:00', '2016-05-24 20:16:00', 'on', '2016-05-26 00:00:00'),
(5, 'Gare feroviere T', 'Oran', '2016-05-24 11:00:00', '2016-05-24 11:00:00', 'off', '2016-05-26 00:00:00'),
(6, 'Gare feroviere T', 'Oran', '2016-05-24 18:00:00', '2016-05-24 19:00:00', 'on', '2016-05-26 00:00:00');

-- --------------------------------------------------------

--
-- Structure de la table `tramhor`
--

DROP TABLE IF EXISTS `tramhor`;
CREATE TABLE IF NOT EXISTS `tramhor` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(200) NOT NULL DEFAULT '',
  `Direction` varchar(200) NOT NULL,
  `HeureC` datetime NOT NULL,
  `HeureA` datetime NOT NULL,
  `etat` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `tramhor`
--

INSERT INTO `tramhor` (`id`, `Nom`, `Direction`, `HeureC`, `HeureA`, `etat`) VALUES
(18, 'Campus', 'Cascade1', '2016-06-07 14:00:00', '2016-06-07 14:00:00', 'on'),
(14, 'Le Rocher', 'Cascade1', '2016-06-06 20:30:00', '2016-06-06 20:30:00', 'on'),
(15, 'Le Rocher', 'Sidi Djilali', '2016-06-06 20:50:00', '2016-06-06 20:50:00', 'on'),
(16, 'Le Rocher', 'Cascade1', '2016-06-06 21:00:00', '2016-06-06 21:00:00', 'on'),
(17, 'Le Rocher', 'Sidi Djilali', '2016-06-06 21:11:00', '2016-06-06 21:11:00', 'on');

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `unique_id` varchar(23) NOT NULL,
  `name` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `encrypted_password` varchar(80) NOT NULL,
  `salt` varchar(10) NOT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_id` (`unique_id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `users`
--

INSERT INTO `users` (`id`, `unique_id`, `name`, `email`, `encrypted_password`, `salt`, `created_at`, `updated_at`) VALUES
(1, '571a808ad499a0.82378129', 'Abbes', 'abbes713@gmail.com', 'YACSkcy0HwTVY4sACsv0YweqPXc5MWM1YjU1ZmRh', '91c5b55fda', '2016-04-22 21:50:34', NULL);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
