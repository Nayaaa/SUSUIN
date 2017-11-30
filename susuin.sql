-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 30 Nov 2017 pada 06.10
-- Versi Server: 10.1.13-MariaDB
-- PHP Version: 5.5.35

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `susuin`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `nota`
--

CREATE TABLE `nota` (
  `id_nota` int(11) NOT NULL,
  `nama` varchar(200) NOT NULL,
  `telepon` varchar(20) NOT NULL,
  `alamat` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `nota`
--

INSERT INTO `nota` (`id_nota`, `nama`, `telepon`, `alamat`) VALUES
(1, 'naya', '124', 'malang'),
(2, 'Yasinta', '0987654321', 'Tulungagung'),
(3, 'Yasinta', '081249674306', 'Tulungagung');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pesanan`
--

CREATE TABLE `pesanan` (
  `id_pesanan` int(11) NOT NULL,
  `tanggal` date NOT NULL,
  `totalbiaya` varchar(200) NOT NULL,
  `jumlahsusu` varchar(200) NOT NULL,
  `jumlahyogurt` varchar(200) NOT NULL,
  `jumlahpuding` varchar(200) NOT NULL,
  `jumlahicecream` varchar(200) NOT NULL,
  `jumlahmilkshake` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `pesanan`
--

INSERT INTO `pesanan` (`id_pesanan`, `tanggal`, `totalbiaya`, `jumlahsusu`, `jumlahyogurt`, `jumlahpuding`, `jumlahicecream`, `jumlahmilkshake`) VALUES
(1, '0000-00-00', '25000', '5', '0', '0', '0', '0'),
(2, '2017-11-03', '315000', '0', '45', '0', '0', '0'),
(3, '2017-11-24', '2146000', '12', '34', '56', '78', '90'),
(4, '2017-11-16', '2146000', '12', '34', '56', '78', '90');

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE `user` (
  `id_user` int(11) NOT NULL,
  `nama` varchar(20) NOT NULL,
  `telepon` varchar(20) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `user`
--

INSERT INTO `user` (`id_user`, `nama`, `telepon`, `username`, `password`) VALUES
(1, 'Naya', '12345', 'Inayah', '1234567890'),
(2, 'Inayah', '1234567890', 'naya', '12345'),
(3, '12345', '12345', '12345', '12345'),
(4, '12', '34', '56', '78'),
(5, 'asd', '123', 'as', 'as'),
(6, '', '3', '2', '2'),
(7, '12', '', '12', '12'),
(8, 'Inayah Dwi Utari', '081249674306', 'Naya', 'inayah'),
(9, 'Yasinta', '0987654321', 'ozawa', 'ozawa'),
(10, '', '', '', ''),
(11, '', '1', '', '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `nota`
--
ALTER TABLE `nota`
  ADD PRIMARY KEY (`id_nota`);

--
-- Indexes for table `pesanan`
--
ALTER TABLE `pesanan`
  ADD PRIMARY KEY (`id_pesanan`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `nota`
--
ALTER TABLE `nota`
  MODIFY `id_nota` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `pesanan`
--
ALTER TABLE `pesanan`
  MODIFY `id_pesanan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
