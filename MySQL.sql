-- phpMyAdmin SQL Dump
-- version 3.4.5
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 03-11-2012 a las 04:43:52
-- Versión del servidor: 5.5.16
-- Versión de PHP: 5.3.8

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `avicola`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compra`
--

CREATE TABLE IF NOT EXISTS `compra` (
  `num` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `total` double NOT NULL,
  `cedula` char(12) COLLATE utf8_unicode_ci NOT NULL,
  `NIT` char(15) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`num`),
  KEY `proveedor_compra_fk` (`cedula`) USING BTREE,
  KEY `empresa_proveedor_compra_fk` (`NIT`,`cedula`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=7 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `departamento`
--

CREATE TABLE IF NOT EXISTS `departamento` (
  `cod` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`cod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_compra`
--

CREATE TABLE IF NOT EXISTS `detalle_compra` (
  `num` int(11) NOT NULL,
  `id` char(3) COLLATE utf8_unicode_ci NOT NULL,
  `cantidad` int(11) NOT NULL,
  `precio` double NOT NULL,
  PRIMARY KEY (`num`,`id`),
  KEY `insumo_detalle_compra_fk` (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empresa`
--

CREATE TABLE IF NOT EXISTS `empresa` (
  `NIT` char(15) COLLATE utf8_unicode_ci NOT NULL,
  `razon_social` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `telefono` char(10) COLLATE utf8_unicode_ci NOT NULL,
  `direccion` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`NIT`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empresa_proveedor`
--

CREATE TABLE IF NOT EXISTS `empresa_proveedor` (
  `NIT` char(15) COLLATE utf8_unicode_ci NOT NULL,
  `cedula` char(12) COLLATE utf8_unicode_ci NOT NULL,
  `estado` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`NIT`,`cedula`),
  KEY `persona_empresa_proveedor_fk` (`cedula`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `engorde`
--

CREATE TABLE IF NOT EXISTS `engorde` (
  `fecha_reg` date NOT NULL,
  `cod_lote` int(11) NOT NULL,
  `cod_granja` int(11) NOT NULL,
  `peso_hem` double NOT NULL,
  `peso_mac` double NOT NULL,
  `mortalidad` int(11) NOT NULL,
  PRIMARY KEY (`fecha_reg`,`cod_lote`,`cod_granja`),
  KEY `lote_engorde_fk` (`cod_lote`,`cod_granja`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `galpon`
--

CREATE TABLE IF NOT EXISTS `galpon` (
  `cod_galpon` int(11) NOT NULL AUTO_INCREMENT,
  `cod_granja` int(11) NOT NULL,
  `area` double NOT NULL,
  PRIMARY KEY (`cod_galpon`,`cod_granja`),
  KEY `granja_galpon_fk` (`cod_granja`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `granja`
--

CREATE TABLE IF NOT EXISTS `granja` (
  `cod_granja` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `direccion` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `area` double NOT NULL,
  `tipo` char(1) COLLATE utf8_unicode_ci NOT NULL,
  `usuario` varchar(60) COLLATE utf8_unicode_ci NOT NULL,
  `cod_mun` int(11) NOT NULL,
  `cod_dep` int(11) NOT NULL,
  `ced_propietario` char(12) COLLATE utf8_unicode_ci NOT NULL,
  `tipo_1` char(7) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`cod_granja`),
  KEY `usuario_granja_fk` (`usuario`) USING BTREE,
  KEY `persona_granja_fk` (`ced_propietario`) USING BTREE,
  KEY `municipio_granja_fk` (`cod_mun`,`cod_dep`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `insumo`
--

CREATE TABLE IF NOT EXISTS `insumo` (
  `id` char(3) COLLATE utf8_unicode_ci NOT NULL,
  `nombre` varchar(60) COLLATE utf8_unicode_ci NOT NULL,
  `tipo` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `cantidad` int(11) NOT NULL,
  `medida` char(5) COLLATE utf8_unicode_ci NOT NULL,
  `estado` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lote`
--

CREATE TABLE IF NOT EXISTS `lote` (
  `cod_lote` int(11) NOT NULL AUTO_INCREMENT,
  `cod_granja` int(11) NOT NULL,
  `num_init` int(11) NOT NULL,
  `fecha_ing` date NOT NULL,
  `cod_galpon` int(11) NOT NULL,
  `tipo_criadoras` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `tipo_bebederos` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `tipo_comederos` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `tipo_ventiladores` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `cant_criadoras` int(11) NOT NULL,
  `cant_bebederos` int(11) NOT NULL,
  `cant_bandejas` int(11) NOT NULL,
  `cant_comederos` int(11) NOT NULL,
  `cant_ventiladores` int(11) NOT NULL,
  `cant_bombillos` int(11) NOT NULL,
  `semana` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`cod_lote`,`cod_granja`),
  KEY `galpon_grupo_ave_fk` (`cod_galpon`,`cod_granja`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `municipio`
--

CREATE TABLE IF NOT EXISTS `municipio` (
  `cod_mun` int(11) NOT NULL AUTO_INCREMENT,
  `cod_dep` int(11) NOT NULL,
  `nombre` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `clima` tinyint(4) NOT NULL,
  PRIMARY KEY (`cod_mun`,`cod_dep`),
  KEY `departamento_municipio_fk` (`cod_dep`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `parametros`
--

CREATE TABLE IF NOT EXISTS `parametros` (
  `email` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `clave_email` varchar(64) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE IF NOT EXISTS `persona` (
  `cedula` char(12) COLLATE utf8_unicode_ci NOT NULL,
  `nombres` varchar(80) COLLATE utf8_unicode_ci NOT NULL,
  `apellidos` varchar(80) COLLATE utf8_unicode_ci NOT NULL,
  `telefono` char(10) COLLATE utf8_unicode_ci NOT NULL,
  `direccion` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`cedula`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ponedor`
--

CREATE TABLE IF NOT EXISTS `ponedor` (
  `fecha_reg` date NOT NULL,
  `cod_lote` int(11) NOT NULL,
  `cod_granja` int(11) NOT NULL,
  `produccion` int(11) NOT NULL,
  `mortalidad` int(11) NOT NULL,
  PRIMARY KEY (`fecha_reg`,`cod_lote`,`cod_granja`),
  KEY `lote_ponedor_fk` (`cod_lote`,`cod_granja`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `recurso`
--

CREATE TABLE IF NOT EXISTS `recurso` (
  `id` char(3) COLLATE utf8_unicode_ci NOT NULL,
  `fecha_reg` date NOT NULL,
  `cod_lote` int(11) NOT NULL,
  `cod_granja` int(11) NOT NULL,
  `cantidad` double NOT NULL,
  PRIMARY KEY (`id`,`fecha_reg`,`cod_lote`,`cod_granja`),
  KEY `ponedor_recurso_fk` (`fecha_reg`,`cod_lote`,`cod_granja`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `nombre` varchar(60) COLLATE utf8_unicode_ci NOT NULL,
  `clave` char(64) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`nombre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `compra`
--
ALTER TABLE `compra`
  ADD CONSTRAINT `empresa_proveedor_compra_fk` FOREIGN KEY (`NIT`, `cedula`) REFERENCES `empresa_proveedor` (`NIT`, `cedula`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `detalle_compra`
--
ALTER TABLE `detalle_compra`
  ADD CONSTRAINT `compra_detalle_compra_fk` FOREIGN KEY (`num`) REFERENCES `compra` (`num`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `insumo_detalle_compra_fk` FOREIGN KEY (`id`) REFERENCES `insumo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `empresa_proveedor`
--
ALTER TABLE `empresa_proveedor`
  ADD CONSTRAINT `empresa_empresa_proveedor_fk` FOREIGN KEY (`NIT`) REFERENCES `empresa` (`NIT`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `persona_empresa_proveedor_fk` FOREIGN KEY (`cedula`) REFERENCES `persona` (`cedula`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `engorde`
--
ALTER TABLE `engorde`
  ADD CONSTRAINT `lote_engorde_fk` FOREIGN KEY (`cod_lote`, `cod_granja`) REFERENCES `lote` (`cod_lote`, `cod_granja`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `galpon`
--
ALTER TABLE `galpon`
  ADD CONSTRAINT `granja_galpon_fk` FOREIGN KEY (`cod_granja`) REFERENCES `granja` (`cod_granja`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `granja`
--
ALTER TABLE `granja`
  ADD CONSTRAINT `municipio_granja_fk` FOREIGN KEY (`cod_mun`, `cod_dep`) REFERENCES `municipio` (`cod_mun`, `cod_dep`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `persona_granja_fk` FOREIGN KEY (`ced_propietario`) REFERENCES `persona` (`cedula`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `usuario_granja_fk` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`nombre`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `lote`
--
ALTER TABLE `lote`
  ADD CONSTRAINT `galpon_grupo_ave_fk` FOREIGN KEY (`cod_galpon`, `cod_granja`) REFERENCES `galpon` (`cod_galpon`, `cod_granja`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `municipio`
--
ALTER TABLE `municipio`
  ADD CONSTRAINT `departamento_municipio_fk` FOREIGN KEY (`cod_dep`) REFERENCES `departamento` (`cod`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `ponedor`
--
ALTER TABLE `ponedor`
  ADD CONSTRAINT `lote_ponedor_fk` FOREIGN KEY (`cod_lote`, `cod_granja`) REFERENCES `lote` (`cod_lote`, `cod_granja`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `recurso`
--
ALTER TABLE `recurso`
  ADD CONSTRAINT `engorde_recurso_fk` FOREIGN KEY (`fecha_reg`, `cod_lote`, `cod_granja`) REFERENCES `engorde` (`fecha_reg`, `cod_lote`, `cod_granja`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `insumo_recurso_fk` FOREIGN KEY (`id`) REFERENCES `insumo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `ponedor_recurso_fk` FOREIGN KEY (`fecha_reg`, `cod_lote`, `cod_granja`) REFERENCES `ponedor` (`fecha_reg`, `cod_lote`, `cod_granja`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
