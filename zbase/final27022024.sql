-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 27-02-2024 a las 18:50:26
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `final27022024`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tcandidato`
--

CREATE TABLE `tcandidato` (
  `ID_CAN` int(9) NOT NULL,
  `DU_PER` int(9) NOT NULL,
  `PARTIDO` varchar(50) NOT NULL,
  `LEMA` varchar(50) NOT NULL,
  `CVOTO` int(9) NOT NULL,
  `ID_ELEC` int(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `teleccion`
--

CREATE TABLE `teleccion` (
  `ID_ELEC` int(9) NOT NULL,
  `DIA` int(2) NOT NULL,
  `MES` int(2) NOT NULL,
  `ANIO` int(4) NOT NULL,
  `DETALLE` varchar(50) NOT NULL,
  `STATUS` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `teleccion`
--

INSERT INTO `teleccion` (`ID_ELEC`, `DIA`, `MES`, `ANIO`, `DETALLE`, `STATUS`) VALUES
(1, 27, 2, 2024, 'FINAL', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tpersona`
--

CREATE TABLE `tpersona` (
  `DU` int(9) NOT NULL,
  `NOMBRE` varchar(15) NOT NULL,
  `APELLIDO` varchar(15) NOT NULL,
  `EDAD` int(2) NOT NULL,
  `GENERO` varchar(10) NOT NULL,
  `DOMICILIO` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tresultados`
--

CREATE TABLE `tresultados` (
  `ID_RES` int(9) NOT NULL,
  `ID_CAN` int(9) NOT NULL,
  `DU_PER` int(9) NOT NULL,
  `PARTIDO` varchar(50) NOT NULL,
  `LEMA` varchar(50) NOT NULL,
  `CANT_VOTO` int(9) NOT NULL,
  `ID_ELEC` int(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tsufragante`
--

CREATE TABLE `tsufragante` (
  `ID_SUF` int(9) NOT NULL,
  `DU_PER` int(9) NOT NULL,
  `STATUS` int(1) NOT NULL,
  `ID_ELEC` int(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tvalvoto`
--

CREATE TABLE `tvalvoto` (
  `ID_VAL` int(9) NOT NULL,
  `ID_ELEC` int(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tvotosincan`
--

CREATE TABLE `tvotosincan` (
  `ID_TVSINCAN` int(9) NOT NULL,
  `BLANCO` int(9) NOT NULL,
  `NULO` int(9) NOT NULL,
  `ID_ELEC` int(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `tcandidato`
--
ALTER TABLE `tcandidato`
  ADD PRIMARY KEY (`ID_CAN`);

--
-- Indices de la tabla `teleccion`
--
ALTER TABLE `teleccion`
  ADD PRIMARY KEY (`ID_ELEC`);

--
-- Indices de la tabla `tresultados`
--
ALTER TABLE `tresultados`
  ADD PRIMARY KEY (`ID_RES`);

--
-- Indices de la tabla `tsufragante`
--
ALTER TABLE `tsufragante`
  ADD PRIMARY KEY (`ID_SUF`);

--
-- Indices de la tabla `tvalvoto`
--
ALTER TABLE `tvalvoto`
  ADD PRIMARY KEY (`ID_VAL`);

--
-- Indices de la tabla `tvotosincan`
--
ALTER TABLE `tvotosincan`
  ADD PRIMARY KEY (`ID_TVSINCAN`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tcandidato`
--
ALTER TABLE `tcandidato`
  MODIFY `ID_CAN` int(9) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `teleccion`
--
ALTER TABLE `teleccion`
  MODIFY `ID_ELEC` int(9) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `tresultados`
--
ALTER TABLE `tresultados`
  MODIFY `ID_RES` int(9) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tsufragante`
--
ALTER TABLE `tsufragante`
  MODIFY `ID_SUF` int(9) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tvalvoto`
--
ALTER TABLE `tvalvoto`
  MODIFY `ID_VAL` int(9) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tvotosincan`
--
ALTER TABLE `tvotosincan`
  MODIFY `ID_TVSINCAN` int(9) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
