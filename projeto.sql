-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 20-Jun-2016 às 22:15
-- Versão do servidor: 10.1.13-MariaDB
-- PHP Version: 5.6.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `projeto`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `area`
--

CREATE TABLE `area` (
  `id` int(11) NOT NULL,
  `latitude` double DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `area`
--

INSERT INTO `area` (`id`, `latitude`, `longitude`, `nome`) VALUES
(1, 123123, 321321, 'Prefeituras'),
(2, 234234, 432423, 'Estados'),
(3, 345345, 543543, 'Internacional'),
(4, 456456, 654654, 'Oficinas'),
(5, 567567, 765765, 'Praça de Eventos');

-- --------------------------------------------------------

--
-- Estrutura da tabela `estande`
--

CREATE TABLE `estande` (
  `id` int(11) NOT NULL,
  `categoria` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `estande`
--

INSERT INTO `estande` (`id`, `categoria`, `nome`) VALUES
(2, 'Prefeituras', 'Olinda'),
(4, 'Prefeituras', 'Surubim'),
(5, 'Prefeituras', 'Caruaru'),
(6, 'Prefeituras', 'Garanhuns'),
(7, 'Prefeituras', 'Petrolina'),
(10, 'Estados', 'Paraíba'),
(12, 'Estados', 'Maranhão'),
(13, 'Estados', 'Pará'),
(15, 'Estados', 'Mato Grosso'),
(16, 'Estados', 'São Paulo'),
(20, 'Internacional', 'Bolívia'),
(21, 'Internacional', 'Colômbia'),
(22, 'Internacional', 'Chile'),
(23, 'Internacional', 'Uruguai'),
(24, 'Internacional', 'Argentina');

-- --------------------------------------------------------

--
-- Estrutura da tabela `expositor`
--

CREATE TABLE `expositor` (
  `id` int(11) NOT NULL,
  `cep` varchar(255) DEFAULT NULL,
  `cnpj` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `endereco` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `telefone` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `expositor`
--

INSERT INTO `expositor` (`id`, `cep`, `cnpj`, `email`, `endereco`, `nome`, `telefone`) VALUES
(1, '53330551', '75112162000110', 'fulano@mail.com', 'Rua Ouro Preto', 'Fulano da Silva', '081984488448'),
(2, '40276052', '97944235000173', 'aa@mail.com', 'Avenida Ipiranga', 'Associacao de Artesaos', '081994499449');

-- --------------------------------------------------------

--
-- Estrutura da tabela `horario`
--

CREATE TABLE `horario` (
  `id` int(11) NOT NULL,
  `data` date DEFAULT NULL,
  `evento` varchar(255) DEFAULT NULL,
  `hora` time DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `horario`
--

INSERT INTO `horario` (`id`, `data`, `evento`, `hora`) VALUES
(1, '2016-08-19', 'Ofina de escultura no barro', '05:30:00'),
(2, '2016-08-19', 'Ofina de tapeçaria', '11:30:00'),
(3, '2016-08-20', 'Apresentação de dança', '07:00:00'),
(4, '2016-08-20', 'Peça teatral shakespeare', '13:00:00'),
(5, '2016-08-20', 'Palestra Nosso Valor Cultural', '17:00:00');

-- --------------------------------------------------------

--
-- Estrutura da tabela `palco`
--

CREATE TABLE `palco` (
  `id` int(11) NOT NULL,
  `categoria` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `palco`
--

INSERT INTO `palco` (`id`, `categoria`, `nome`) VALUES
(1, 'Praça de Eventos', 'Palco central'),
(2, 'Praça de Eventos', 'Mini Palco');

-- --------------------------------------------------------

--
-- Estrutura da tabela `palestra`
--

CREATE TABLE `palestra` (
  `informacoes` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `preco` varchar(255) DEFAULT NULL,
  `palco_id` int(11) NOT NULL,
  `id` int(11) NOT NULL,
  `palestrante_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `palestra`
--

INSERT INTO `palestra` (`informacoes`, `nome`, `preco`, `palco_id`, `id`, `palestrante_id`) VALUES
('Dicas de como inovar num negocio', 'Como ser um Empreededor', '2.0', 1, 1, 1),
('Tecnicas de gerenciamento orçamentario', 'Investindo em pequenos negocios', '4.0', 2, 2, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `palestrante`
--

CREATE TABLE `palestrante` (
  `id` int(11) NOT NULL,
  `agencia_banco` varchar(255) DEFAULT NULL,
  `conta_banco` varchar(255) DEFAULT NULL,
  `cpf` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `nome_banco` varchar(255) DEFAULT NULL,
  `telefone` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `palestrante`
--

INSERT INTO `palestrante` (`id`, `agencia_banco`, `conta_banco`, `cpf`, `email`, `nome`, `nome_banco`, `telefone`) VALUES
(1, '45656', '54654765', '97657278102', 'joao@mail.com', 'João José', 'Itau', '011977667766');

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto`
--

CREATE TABLE `produto` (
  `categoria` varchar(255) DEFAULT NULL,
  `informacoes` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `preco` double DEFAULT NULL,
  `expositor_id` int(11) NOT NULL,
  `estande_id` int(11) NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `produto`
--

INSERT INTO `produto` (`categoria`, `informacoes`, `nome`, `preco`, `expositor_id`, `estande_id`, `id`) VALUES
('Pintura à óleo', 'Tamanho 200x100cm', 'Paisagem do Agreste', 399.99, 1, 6, 0);

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `login` varchar(255) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL,
  `tipo` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`id`, `login`, `senha`, `tipo`) VALUES
(1, 'eric', 'eric', 'o');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `area`
--
ALTER TABLE `area`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `estande`
--
ALTER TABLE `estande`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `expositor`
--
ALTER TABLE `expositor`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `horario`
--
ALTER TABLE `horario`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `palco`
--
ALTER TABLE `palco`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `palestra`
--
ALTER TABLE `palestra`
  ADD PRIMARY KEY (`palco_id`,`id`,`palestrante_id`),
  ADD KEY `FK_palestra_palestrante_id` (`palestrante_id`);

--
-- Indexes for table `palestrante`
--
ALTER TABLE `palestrante`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `produto`
--
ALTER TABLE `produto`
  ADD PRIMARY KEY (`expositor_id`,`estande_id`,`id`),
  ADD KEY `FK_produto_estande_id` (`estande_id`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `area`
--
ALTER TABLE `area`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `estande`
--
ALTER TABLE `estande`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;
--
-- AUTO_INCREMENT for table `palco`
--
ALTER TABLE `palco`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `palestra`
--
ALTER TABLE `palestra`
  ADD CONSTRAINT `FK_palestra_palco_id` FOREIGN KEY (`palco_id`) REFERENCES `palco` (`id`),
  ADD CONSTRAINT `FK_palestra_palestrante_id` FOREIGN KEY (`palestrante_id`) REFERENCES `palestrante` (`id`);

--
-- Limitadores para a tabela `produto`
--
ALTER TABLE `produto`
  ADD CONSTRAINT `FK_produto_estande_id` FOREIGN KEY (`estande_id`) REFERENCES `estande` (`id`),
  ADD CONSTRAINT `FK_produto_expositor_id` FOREIGN KEY (`expositor_id`) REFERENCES `expositor` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
