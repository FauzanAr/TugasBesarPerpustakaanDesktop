-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 18, 2018 at 03:07 AM
-- Server version: 5.6.21
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `perpustakaan_tubes`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--
-- Creation: Dec 05, 2018 at 01:00 AM
--

CREATE TABLE IF NOT EXISTS `admin` (
`id_admin` int(11) NOT NULL,
  `password_admin` varchar(30) NOT NULL,
  `nik_admin` varchar(30) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id_admin`, `password_admin`, `nik_admin`) VALUES
(1, 'admin', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `buku`
--
-- Creation: Dec 05, 2018 at 01:07 AM
--

CREATE TABLE IF NOT EXISTS `buku` (
`id_buku` int(11) NOT NULL,
  `judul_buku` varchar(100) NOT NULL,
  `pengarang_buku` varchar(50) NOT NULL,
  `id_category_buku` int(11) NOT NULL,
  `jumlah_buku` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `buku`:
--   `id_category_buku`
--       `kategori` -> `id_category_buku`
--

--
-- Dumping data for table `buku`
--

INSERT INTO `buku` (`id_buku`, `judul_buku`, `pengarang_buku`, `id_category_buku`, `jumlah_buku`) VALUES
(1, 'Java 5', 'Oracle', 0, 4),
(2, 'WAD', 'awd', 0, 12),
(3, 'Ffffff', 'wwwwww', 7, 1);

-- --------------------------------------------------------

--
-- Table structure for table `kategori`
--
-- Creation: Dec 05, 2018 at 01:09 AM
--

CREATE TABLE IF NOT EXISTS `kategori` (
  `id_category_buku` int(11) NOT NULL,
  `nama_kategori` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kategori`
--

INSERT INTO `kategori` (`id_category_buku`, `nama_kategori`) VALUES
(1, 'Agama'),
(2, 'Sejarah'),
(3, 'Bahasa Indonesia'),
(4, 'Teknologi'),
(5, 'Ilmu Pengetahuan Alam'),
(6, 'Bahasa Inggris'),
(7, 'Matematika'),
(8, 'Biografi'),
(9, 'Hukum'),
(10, 'Geografi');

-- --------------------------------------------------------

--
-- Table structure for table `pelanggaran`
--
-- Creation: Dec 05, 2018 at 01:14 AM
--

CREATE TABLE IF NOT EXISTS `pelanggaran` (
`id_pelanggaran` int(11) NOT NULL,
  `id_peminjaman_buku` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `denda_pelanggaran` int(11) NOT NULL,
  `nama_pelanggaran` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `pelanggaran`:
--   `id_peminjaman_buku`
--       `peminjaman` -> `id_peminjaman`
--   `id_user`
--       `user` -> `id_user_perpus`
--

-- --------------------------------------------------------

--
-- Table structure for table `peminjaman`
--
-- Creation: Dec 05, 2018 at 01:04 AM
--

CREATE TABLE IF NOT EXISTS `peminjaman` (
`id_peminjaman` int(11) NOT NULL,
  `id_user_perpustakaan` int(11) NOT NULL,
  `id_buku` int(11) NOT NULL,
  `tanggal_pinjam` date NOT NULL,
  `tanggal_kembali` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- RELATIONS FOR TABLE `peminjaman`:
--   `id_buku`
--       `buku` -> `id_buku`
--   `id_user_perpustakaan`
--       `user` -> `id_user_perpus`
--

-- --------------------------------------------------------

--
-- Table structure for table `user`
--
-- Creation: Dec 10, 2018 at 10:30 AM
--

CREATE TABLE IF NOT EXISTS `user` (
`id_user_perpus` int(11) NOT NULL,
  `nim_user_perpus` varchar(10) NOT NULL,
  `nama_user_perpus` varchar(30) NOT NULL,
  `prodi_user_perpus` varchar(30) NOT NULL,
  `user_pinjam` int(11) DEFAULT '0',
  `password_user_perpus` varchar(50) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id_user_perpus`, `nim_user_perpus`, `nama_user_perpus`, `prodi_user_perpus`, `user_pinjam`, `password_user_perpus`) VALUES
(1, '1741720212', 'Fauzan', 'Teknologi Informasi', 1, '1741720212'),
(2, '174172222', 'Khosy', 'Manajemen Informatika', 0, '174172222');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
 ADD PRIMARY KEY (`id_admin`);

--
-- Indexes for table `buku`
--
ALTER TABLE `buku`
 ADD PRIMARY KEY (`id_buku`);

--
-- Indexes for table `kategori`
--
ALTER TABLE `kategori`
 ADD PRIMARY KEY (`id_category_buku`);

--
-- Indexes for table `pelanggaran`
--
ALTER TABLE `pelanggaran`
 ADD PRIMARY KEY (`id_pelanggaran`);

--
-- Indexes for table `peminjaman`
--
ALTER TABLE `peminjaman`
 ADD PRIMARY KEY (`id_peminjaman`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
 ADD PRIMARY KEY (`id_user_perpus`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
MODIFY `id_admin` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `buku`
--
ALTER TABLE `buku`
MODIFY `id_buku` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `pelanggaran`
--
ALTER TABLE `pelanggaran`
MODIFY `id_pelanggaran` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `peminjaman`
--
ALTER TABLE `peminjaman`
MODIFY `id_peminjaman` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
MODIFY `id_user_perpus` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
