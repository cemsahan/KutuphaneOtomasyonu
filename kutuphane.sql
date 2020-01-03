-- phpMyAdmin SQL Dump
-- version 4.8.0
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 21 May 2018, 04:02:39
-- Sunucu sürümü: 10.1.31-MariaDB
-- PHP Sürümü: 7.0.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `kutuphane`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `admin`
--

CREATE TABLE `admin` (
  `yoneticiID` varchar(20) COLLATE utf8mb4_turkish_ci NOT NULL,
  `yoneticiAd` varchar(20) COLLATE utf8mb4_turkish_ci NOT NULL,
  `yoneticiSoyad` varchar(20) COLLATE utf8mb4_turkish_ci NOT NULL,
  `yoneticiEmail` varchar(50) COLLATE utf8mb4_turkish_ci NOT NULL,
  `parola` varchar(20) COLLATE utf8mb4_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_turkish_ci;

--
-- Tablo döküm verisi `admin`
--

INSERT INTO `admin` (`yoneticiID`, `yoneticiAd`, `yoneticiSoyad`, `yoneticiEmail`, `parola`) VALUES
('1', 'Cem', 'Şahan', 'cem.sahan@hotmail.com', '1234');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `adresler`
--

CREATE TABLE `adresler` (
  `adresNo` int(11) NOT NULL,
  `ulke` varchar(10) COLLATE utf8mb4_turkish_ci DEFAULT 'Türkiye',
  `sehir` varchar(15) COLLATE utf8mb4_turkish_ci NOT NULL,
  `ilce` varchar(20) COLLATE utf8mb4_turkish_ci DEFAULT NULL,
  `mahalle` varchar(50) COLLATE utf8mb4_turkish_ci NOT NULL,
  `sokak` varchar(50) COLLATE utf8mb4_turkish_ci DEFAULT NULL,
  `binaNo` varchar(10) COLLATE utf8mb4_turkish_ci NOT NULL,
  `daireNo` varchar(10) COLLATE utf8mb4_turkish_ci NOT NULL,
  `postaKodu` varchar(10) COLLATE utf8mb4_turkish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_turkish_ci;

--
-- Tablo döküm verisi `adresler`
--

INSERT INTO `adresler` (`adresNo`, `ulke`, `sehir`, `ilce`, `mahalle`, `sokak`, `binaNo`, `daireNo`, `postaKodu`) VALUES
(40, 'Türkiye', 'Ankara', 'MAMAK', 'g.z.d.', '563.', '12', '12', '06100'),
(41, 'Türkiye', 'Mersin', 'talas', 'anayurt', 'batuhan ', '20', '6', '38000'),
(42, 'Türkiye', 'Kayseri', 'talas', 'erenköy', 'batuhan ', '20', '6', '38000'),
(46, 'Türkiye', 'kayseri', 'kocasinan', 'anayurt', 'yucel', '12', '11', '38'),
(47, 'Türkiye', 'kayseri', 'kocasinan', 'anayurt', 'yucel', '12', '11', '38');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `emanet`
--

CREATE TABLE `emanet` (
  `emanetNo` int(11) NOT NULL,
  `emanetTarihi` varchar(20) COLLATE utf8mb4_turkish_ci NOT NULL,
  `zorunluTeslimTarihi` varchar(30) COLLATE utf8mb4_turkish_ci DEFAULT NULL,
  `teslimTarihi` varchar(20) COLLATE utf8mb4_turkish_ci NOT NULL DEFAULT 'null',
  `kitapID` int(11) NOT NULL,
  `uyeNo` int(11) NOT NULL,
  `cezaDurumu` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_turkish_ci;

--
-- Tablo döküm verisi `emanet`
--

INSERT INTO `emanet` (`emanetNo`, `emanetTarihi`, `zorunluTeslimTarihi`, `teslimTarihi`, `kitapID`, `uyeNo`, `cezaDurumu`) VALUES
(43, '2018.05.21', '2018.05.22', 'null', 173, 4, 0),
(44, '2018.05.21', '2018.05.19', 'null', 184, 5, 20),
(45, '2018.05.21', '2018.05.19', 'null', 194, 10, 20);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `kategori`
--

CREATE TABLE `kategori` (
  `kategoriID` int(11) NOT NULL,
  `kategoriAdi` varchar(30) COLLATE utf8mb4_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_turkish_ci;

--
-- Tablo döküm verisi `kategori`
--

INSERT INTO `kategori` (`kategoriID`, `kategoriAdi`) VALUES
(51, 'tarih'),
(52, 'macera'),
(53, 'bnmo'),
(54, 'ghjk'),
(55, 'asdf');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `kitaplar`
--

CREATE TABLE `kitaplar` (
  `kitapID` int(11) NOT NULL,
  `kitapAdi` varchar(20) COLLATE utf8mb4_turkish_ci NOT NULL,
  `yayinTarihi` varchar(20) COLLATE utf8mb4_turkish_ci DEFAULT NULL,
  `SayfaSayisi` varchar(5) COLLATE utf8mb4_turkish_ci DEFAULT NULL,
  `varmi` varchar(5) COLLATE utf8mb4_turkish_ci NOT NULL DEFAULT 'true'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_turkish_ci;

--
-- Tablo döküm verisi `kitaplar`
--

INSERT INTO `kitaplar` (`kitapID`, `kitapAdi`, `yayinTarihi`, `SayfaSayisi`, `varmi`) VALUES
(173, 'nutuk', '1927', '640', 'false'),
(174, 'nutuk', '1927', '640', 'true'),
(175, 'nutuk', '1927', '640', 'true'),
(176, 'nutuk', '1927', '640', 'true'),
(177, 'nutuk', '1927', '640', 'true'),
(178, 'nutuk', '1927', '640', 'true'),
(179, 'nutuk', '1927', '640', 'true'),
(180, 'nutuk', '1927', '640', 'true'),
(181, 'nutuk', '1927', '640', 'true'),
(182, 'nutuk', '1927', '640', 'true'),
(183, 'mavisaclıkız', '1927', '640', 'true'),
(184, 'mavisaclıkız', '1927', '640', 'false'),
(185, 'mavisaclıkız', '1927', '640', 'true'),
(186, 'mavisaclıkız', '1927', '640', 'true'),
(187, 'mavisaclıkız', '1927', '640', 'true'),
(188, 'mavisaclıkız', '1927', '640', 'true'),
(189, 'mavisaclıkız', '1927', '640', 'true'),
(190, 'mavisaclıkız', '1927', '640', 'true'),
(191, 'mavisaclıkız', '1927', '640', 'true'),
(192, 'mavisaclıkız', '1927', '640', 'true'),
(193, 'Leyla ile Mecnun', '2003', '200', 'true'),
(194, '\nPembe FiliDusunme', '2011', '150', 'false'),
(195, '\nSanma ki Yalnizsin', '2001', '300', 'true');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `kitap_kategori`
--

CREATE TABLE `kitap_kategori` (
  `kitapID` int(11) NOT NULL,
  `kategoriID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_turkish_ci;

--
-- Tablo döküm verisi `kitap_kategori`
--

INSERT INTO `kitap_kategori` (`kitapID`, `kategoriID`) VALUES
(173, 51),
(174, 51),
(175, 51),
(176, 51),
(177, 51),
(178, 51),
(179, 51),
(180, 51),
(181, 51),
(182, 51),
(183, 52),
(184, 52),
(185, 52),
(186, 52),
(187, 52),
(188, 52),
(189, 52),
(190, 52),
(191, 52),
(192, 52),
(193, 53),
(194, 54),
(195, 55);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `kitap_yazar`
--

CREATE TABLE `kitap_yazar` (
  `yazarID` int(11) NOT NULL,
  `kitapID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_turkish_ci;

--
-- Tablo döküm verisi `kitap_yazar`
--

INSERT INTO `kitap_yazar` (`yazarID`, `kitapID`) VALUES
(157, 173),
(157, 174),
(157, 175),
(157, 176),
(157, 177),
(157, 178),
(157, 179),
(157, 180),
(157, 181),
(157, 182),
(158, 183),
(158, 184),
(158, 185),
(158, 186),
(158, 187),
(158, 188),
(158, 189),
(158, 190),
(158, 191),
(158, 192),
(159, 193),
(160, 194),
(161, 195);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `memur`
--

CREATE TABLE `memur` (
  `memurID` int(10) NOT NULL,
  `memurAd` varchar(15) COLLATE utf8mb4_turkish_ci NOT NULL,
  `memurSoyad` varchar(20) COLLATE utf8mb4_turkish_ci NOT NULL,
  `email` varchar(30) COLLATE utf8mb4_turkish_ci NOT NULL,
  `parola` varchar(20) COLLATE utf8mb4_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_turkish_ci;

--
-- Tablo döküm verisi `memur`
--

INSERT INTO `memur` (`memurID`, `memurAd`, `memurSoyad`, `email`, `parola`) VALUES
(4, 'Enes', 'güven', 'enes.guven', '1234'),
(6, 'Cem', 'Şahan', 'cem.sahan@hotmail.com', '4321'),
(7, 'Emre', 'Aslan', 'emre.aslan', '1234'),
(8, 'Hazim', 'Kayapınar', 'hazim.kayapinar', '1234');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `uyeler`
--

CREATE TABLE `uyeler` (
  `uyeNo` int(11) NOT NULL,
  `uyeAdi` varchar(15) COLLATE utf8mb4_turkish_ci NOT NULL,
  `uyeSoyadi` varchar(15) COLLATE utf8mb4_turkish_ci NOT NULL,
  `tel` varchar(15) COLLATE utf8mb4_turkish_ci NOT NULL,
  `email` varchar(25) COLLATE utf8mb4_turkish_ci NOT NULL,
  `cinsiyet` varchar(20) COLLATE utf8mb4_turkish_ci NOT NULL,
  `adresNo` int(11) NOT NULL,
  `parola` varchar(20) COLLATE utf8mb4_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_turkish_ci;

--
-- Tablo döküm verisi `uyeler`
--

INSERT INTO `uyeler` (`uyeNo`, `uyeAdi`, `uyeSoyadi`, `tel`, `email`, `cinsiyet`, `adresNo`, `parola`) VALUES
(4, 'Cem', 'Sahan', '05443197258', 'cem.sahan@hotmail.com', 'erkek', 40, '1234'),
(5, 'enes', 'Güven', '12344', 'enes.guven@hotmail.com', 'erkek', 41, '12355'),
(10, 'hazim', 'kayapınar', '1234325434', 'hazimkayapinar@gmail.com', 'erkek', 46, '1234'),
(11, 'emre', 'aslan', '1234325434', 'emre.aslan@gmail.com', 'erkek', 47, '1234');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `yazarlar`
--

CREATE TABLE `yazarlar` (
  `yazarID` int(11) NOT NULL,
  `yazarAdSoyad` varchar(50) COLLATE utf8mb4_turkish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_turkish_ci;

--
-- Tablo döküm verisi `yazarlar`
--

INSERT INTO `yazarlar` (`yazarID`, `yazarAdSoyad`) VALUES
(157, 'Mustafa KemalAtatürk'),
(158, 'burcak cerezcioglu'),
(159, 'Burak Aksak'),
(160, ' Mustafa '),
(161, 'Elif Safak\n');

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`yoneticiID`);

--
-- Tablo için indeksler `adresler`
--
ALTER TABLE `adresler`
  ADD PRIMARY KEY (`adresNo`);

--
-- Tablo için indeksler `emanet`
--
ALTER TABLE `emanet`
  ADD PRIMARY KEY (`emanetNo`),
  ADD KEY `kitapID` (`kitapID`),
  ADD KEY `uyeNo` (`uyeNo`);

--
-- Tablo için indeksler `kategori`
--
ALTER TABLE `kategori`
  ADD PRIMARY KEY (`kategoriID`);

--
-- Tablo için indeksler `kitaplar`
--
ALTER TABLE `kitaplar`
  ADD PRIMARY KEY (`kitapID`);

--
-- Tablo için indeksler `kitap_kategori`
--
ALTER TABLE `kitap_kategori`
  ADD KEY `kitapID` (`kitapID`);

--
-- Tablo için indeksler `memur`
--
ALTER TABLE `memur`
  ADD PRIMARY KEY (`memurID`);

--
-- Tablo için indeksler `uyeler`
--
ALTER TABLE `uyeler`
  ADD PRIMARY KEY (`uyeNo`),
  ADD KEY `adresNo` (`adresNo`);

--
-- Tablo için indeksler `yazarlar`
--
ALTER TABLE `yazarlar`
  ADD PRIMARY KEY (`yazarID`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `adresler`
--
ALTER TABLE `adresler`
  MODIFY `adresNo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=48;

--
-- Tablo için AUTO_INCREMENT değeri `emanet`
--
ALTER TABLE `emanet`
  MODIFY `emanetNo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=46;

--
-- Tablo için AUTO_INCREMENT değeri `kategori`
--
ALTER TABLE `kategori`
  MODIFY `kategoriID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=56;

--
-- Tablo için AUTO_INCREMENT değeri `kitaplar`
--
ALTER TABLE `kitaplar`
  MODIFY `kitapID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=196;

--
-- Tablo için AUTO_INCREMENT değeri `memur`
--
ALTER TABLE `memur`
  MODIFY `memurID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Tablo için AUTO_INCREMENT değeri `uyeler`
--
ALTER TABLE `uyeler`
  MODIFY `uyeNo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Tablo için AUTO_INCREMENT değeri `yazarlar`
--
ALTER TABLE `yazarlar`
  MODIFY `yazarID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=162;

--
-- Dökümü yapılmış tablolar için kısıtlamalar
--

--
-- Tablo kısıtlamaları `emanet`
--
ALTER TABLE `emanet`
  ADD CONSTRAINT `emanet_ibfk_1` FOREIGN KEY (`kitapID`) REFERENCES `kitaplar` (`kitapID`),
  ADD CONSTRAINT `emanet_ibfk_2` FOREIGN KEY (`uyeNo`) REFERENCES `uyeler` (`uyeNo`);

--
-- Tablo kısıtlamaları `uyeler`
--
ALTER TABLE `uyeler`
  ADD CONSTRAINT `uyeler_ibfk_1` FOREIGN KEY (`adresNo`) REFERENCES `adresler` (`adresNo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
