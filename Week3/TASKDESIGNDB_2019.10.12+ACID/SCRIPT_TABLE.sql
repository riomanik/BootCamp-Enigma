create schema Tugas;
use Tugas;
-- drop schema Tugas;

CREATE TABLE BATCH (
  ID_BATCH INT(11) PRIMARY KEY,
  NAMA_BATCH VARCHAR(45),
  TANGGAL_MULAI DATE,
  TANGGAL_BERAKHIR DATE
  );
  
  CREATE TABLE KELAS (
  ID_KELAS INT(11) PRIMARY KEY,
  NAMA_KELAS VARCHAR(45)
  );
  
  CREATE TABLE materi  (
  ID_MATERI INT(11) PRIMARY KEY ,
  NAMA_MATERI VARCHAR(45)
  );
  
  CREATE TABLE nilai (
  ID_NILAI INT(11) PRIMARY KEY,
  NILAI_TRAINEE INT(11)
  );
  
  CREATE TABLE TRAINEE (
  ID_TRAINEE INT primary key ,
  NAME_TRAINEE VARCHAR(45),
  ASAL_TRAINEE VARCHAR(45),
  GENDER VARCHAR(45)
  );
  
  CREATE TABLE IF NOT EXISTS RELASI_MATERI (
  ID_RELASI_MATERI INT ,
  ID_MATERI INT(11) ,
  ID_NILAI INT(11) ,
  PRIMARY KEY (ID_RELASI_MATERI),
    FOREIGN KEY (ID_MATERI) REFERENCES materi(ID_MATERI),
    FOREIGN KEY (ID_NILAI) REFERENCES nilai (ID_NILAI)
    );


CREATE TABLE RELASI_BATCH_KELAS (
  ID_RELASI_BATCH INT,
  ID_TRAINEE INT ,
  ID_BATCH INT(11) ,
  ID_KELAS INT(11) ,
  ID_RELASI_MATERI INT(11) ,
  PRIMARY KEY (ID_RELASI_BATCH),
    FOREIGN KEY (ID_TRAINEE)REFERENCES TRAINEE (ID_TRAINEE),
    FOREIGN KEY (ID_BATCH)REFERENCES batch(ID_BATCH),
    FOREIGN KEY (ID_KELAS)REFERENCES kelas (ID_KELAS),
    FOREIGN KEY (ID_RELASI_MATERI)REFERENCES RELASI_MATERI (ID_RELASI_MATERI)
    );
    
INSERT INTO BATCH (ID_BATCH, NAMA_BATCH, TANGGAL_MULAI, TANGGAL_BERAKHIR) VALUES (1, 'BATCH 01', '2018-06-01', '2018-09-01');
INSERT INTO BATCH (ID_BATCH, NAMA_BATCH, TANGGAL_MULAI, TANGGAL_BERAKHIR) VALUES (2, 'BATCH 02', '2018-09-01', '2018-12-01');
INSERT INTO BATCH (ID_BATCH, NAMA_BATCH, TANGGAL_MULAI, TANGGAL_BERAKHIR) VALUES (3, 'BATCH 03', '2018-12-01', '2019-03-01');
INSERT INTO BATCH (ID_BATCH, NAMA_BATCH, TANGGAL_MULAI, TANGGAL_BERAKHIR) VALUES (4, 'BATCH 04', '2019-03-01', '2019-06-01');
INSERT INTO BATCH (ID_BATCH, NAMA_BATCH, TANGGAL_MULAI, TANGGAL_BERAKHIR) VALUES (5, 'BATCH 05', '2019-06-01', '2019-09-01');


INSERT INTO KELAS (ID_KELAS, NAMA_KELAS) VALUES (1101, 'KELAS PASCAL');
INSERT INTO KELAS (ID_KELAS, NAMA_KELAS) VALUES (1102, 'KELAS TURING');
INSERT INTO KELAS (ID_KELAS, NAMA_KELAS) VALUES (1103, 'KELAS BOOLEAN');
INSERT INTO KELAS (ID_KELAS, NAMA_KELAS) VALUES (1104, 'KELAS CASE');
INSERT INTO KELAS (ID_KELAS, NAMA_KELAS) VALUES (1105, 'KELAS IF');
INSERT INTO KELAS (ID_KELAS, NAMA_KELAS) VALUES (1106, 'KELAS MERGE');
INSERT INTO KELAS (ID_KELAS, NAMA_KELAS) VALUES (1107, 'KELAS JAVA');
INSERT INTO KELAS (ID_KELAS, NAMA_KELAS) VALUES (1108, 'KELAS MICROSOFT');
INSERT INTO KELAS (ID_KELAS, NAMA_KELAS) VALUES (1109, 'KELAS APPLE');
INSERT INTO KELAS (ID_KELAS, NAMA_KELAS) VALUES (1110, 'KELAS ANDROID');

INSERT INTO MATERI (ID_MATERI, NAMA_MATERI) VALUES (9901, 'JAVA');
INSERT INTO MATERI (ID_MATERI, NAMA_MATERI) VALUES (9902, 'DATABASE');
INSERT INTO MATERI (ID_MATERI, NAMA_MATERI) VALUES (9903, 'NODE JS');
INSERT INTO MATERI (ID_MATERI, NAMA_MATERI) VALUES (9904, 'REACT JS');
INSERT INTO MATERI (ID_MATERI, NAMA_MATERI) VALUES (9905, 'SPRING JAVA');

INSERT INTO TRAINEE(ID_TRAINEE, NAME_TRAINEE, ASAL_TRAINEE, GENDER) 
VALUES 
(1, 'Junifer Rionaldi Manik', 'IE MEUDAMA', 'Male'),
(2, 'Karen Vivi Prastuti', 'UJONG TAN0H', 'Female'),
(3, 'Cemeti Siregar', 'KEUDE TRUMON', 'Female'),
(4, 'Zamira Hamima Wulandari M.M.', 'KUTA BARU', 'Male'),
(5, 'Eman Saefullah S.E.I', 'SINGLENG', 'Male'),
(6, 'Tari Andriani M.Pd', 'PANTON BILI', 'Female'),
(7, 'Paiman Estiawan Tampubolon S.Farm', 'UPT II PD HARAPAN', 'Male'),
(8, 'Asmuni Gilang Prakasa S.H.', 'SEUNABOK JAYA (EX UPT V)', 'Female'),
(9, 'Ilyas Putra', 'TITI POBEN', 'Male'),
(10, 'Raditya Sihombing', 'ALUR BUJOK', 'Male'),
(11, 'Radit Mahendra', 'SEUNEUBOK PUNTHO', 'Male'),
(12, 'Gilda Suartini', 'PINTO RIMBA', 'Male'),
(13, 'Putri Rika Mardhiyah', 'KRUNG LUAS', 'Female'),
(14, 'Tania Rahmawati', 'JAMBO DALEM', 'Female'),
(15, 'Titi Dina Hassanah M.M.', 'KAPAI SEUSAK', 'Female'),
(16, 'Sari Namaga', 'UPT I SNB PUSAKA', 'Female'),
(17, 'Intan Anggraini', 'LHOK RAYA', 'Female'),
(18, 'Kayun Panca Pratama', 'IE JEUREUNEH', 'Female'),
(19, 'Nardi Respati Hidayanto S.Sos', 'NACA', 'Male'),
(20, 'Kartika Farida', 'COT BAYU', 'Female'),
(21, 'Umar Kasusra Nainggolan S.Pt', 'JAMBO PAPEUN', 'Male'),
(22, 'Yance Mandasari S.Pt', 'LADANG RIMBA', 'Female'),
(23, 'Warsa Xanana Tarihoran M.Ak', 'PULO PAYA', 'Female'),
(24, 'Carub Mahdi Gunarto M.Farm', 'KRUENG BATEE', 'Male'),
(25, 'Yance Lestari M.TI.', 'KAMPONG TEUNGOH', 'Female'),
(26, 'Asmadi Panji Najmudin', 'GUNONG KAPHO', 'Male'),
(27, 'Elma Tantri Utami S.E.', 'UJUNG MANGKI', 'Male'),
(28, 'Dono Warji Wasita', 'KEUDE BAKONGAN', 'Male'),
(29, 'Kajen Ganda Irawan S.T.', 'KAMPUNG BARU', 'Male'),
(30, 'Gandi Prasasta', 'UJUNG PADANG', 'Male'),
(31, 'Danuja Elvin Halim', 'KMP DRIEN', 'Female'),
(32, 'Kasiyah Anggraini', 'DAHRUL IHSAN', 'Female'),
(33, 'Harto Rahman Gunarto', 'PADANG BEURAHAN', 'Male'),
(34, 'Hasan Utama', 'UJUNG PULO CUT', 'Male'),
(35, 'Samiah Usamah', 'UJUNG PULO RAYEUK', 'Male'),
(36, 'Carla Syahrini Permata', 'PASI SEUBADEH', 'Female'),
(37, 'Galuh Situmorang M.Kom.', 'LADANG RIMBA', 'Male'),
(38, 'Gilang Samosir', 'SIMPANG', 'Male'),
(39, 'Rika Laila Pudjiastuti', 'SAWAH TINGKEUM', 'Male'),
(40, 'Mursinin Prasasta', 'SEULEUKAT', 'Male'),
(41, 'Balangga Marbun S.Psi', 'SENEUBOK ALUR BULAH', 'Male'),
(42, 'Maryadi Nasrullah Prabowo', 'ALURDUAMAS', 'Male'),
(43, 'Kala Nainggolan', 'JAMBO KEUPOK', 'Male'),
(44, 'Laras Novi Zulaika', 'UJUNG TANOH', 'Female'),
(45, 'Amelia Ira Prastuti S.Pd', 'BEUTONG', 'Female'),
(46, 'Bagiya Najmudin S.Gz', 'UJUNG GUNONG RAYEK', 'Male'),
(47, 'Kania Andriani S.Psi', 'UJUNG GUNUNG CUT', 'Female'),
(48, 'Ajiono Cawuk Tampubolon', 'RAMBONG', 'Male'),
(49, 'Lukita Nyoman Napitupulu M.TI.', 'SEUNEUBOK KEURANJI', 'Female'),
(50, 'Nyana Maheswara', 'BUKIT GADING', 'Female'),
(51, 'Ivan Januar', 'PASI LEMBANG', 'Male'),
(52, 'Kani Laksita', 'UJUNG PADANG', 'Male'),
(53, 'Fitriani Restu Yuliarti', 'INDRA DAMAI', 'Female'),
(54, 'Shania Hasanah', 'SUAQ BAKONG', 'Female'),
(55, 'Intan Riyanti', 'BARAT DAYA', 'Female'),
(56, 'Halima Yolanda', 'SIALANG', 'Female'),
(57, 'Yessi Nilam Kusmawati S.Psi', 'KAPEH', 'Female'),
(58, 'Ikin Daryani Narpati M.Kom.', 'PULO IE', 'Female'),
(59, 'Soleh Wijaya', 'JUA', 'Male'),
(60, 'Amalia Usada', 'PASI MERAPAT', 'Male'),
(61, 'Vanesa Novitasari', 'UJUNG', 'Female'),
(62, 'Ade Maryadi S.Gz', 'LUAR', 'Male'),
(63, 'Rosman Dimaz Siregar', 'KEDAI KANDANG', 'Female'),
(64, 'Ika Usada', 'RANTAU BINUANG', 'Male'),
(65, 'Intan Hasanah', 'UJUNG PASIR', 'Female'),
(66, 'Tari Elvina Suryatmi', 'GELUMBUK', 'Female'),
(67, 'Usman Hardiansyah', 'KEDAI RUNDING', 'Female'),
(68, 'Hafshah Mulyani', 'SAPIK', 'Male'),
(69, 'Maimunah Susanti S.H.', 'DURIAN KAWAN', 'Male'),
(70, 'Artawan Raihan Waskita', 'ALAI', 'Female'),
(71, 'Zelda Septi Haryanti S.Pd', 'PAYA DAPUR', 'Male'),
(72, 'Yono Saefullah', 'PUCUK LEMBANG', 'Female'),
(73, 'Zalindra Usamah', 'LAWE BULUH DIDI', 'Male'),
(74, 'Bakijan Daru Prakasa M.TI.', 'LAWE SAWAH', 'Female'),
(75, 'Carla Vicky Permata', 'PAYA LABA', 'Male'),
(76, 'Mitra Hutagalung', 'LAWE CIMANOK', 'Male'),
(77, 'Kamal Latupono S.Kom', 'KEDAI PADANG', 'Female'),
(78, 'Nyoman Kurniawan', 'PASI KUALA BAU', 'Male'),
(79, 'Purwadi Saptono', 'SUAQ GERINGGENG', 'Male'),
(80, 'Ilsa Kusmawati', 'SIMPANG LHEE', 'Male'),
(81, 'Rika Astuti', 'SIMPANG EMPAT', 'Male'),
(82, 'Maryanto Hartana Nugroho', 'JAMBO MANYANG', 'Female'),
(83, 'Eka Winda Mayasari', 'LIMAU PURUT', 'Male'),
(84, 'Zulfa Novi Mulyani M.Pd', 'PULO KAMBING', 'Female'),
(85, 'Ida Lestari', 'KAMPUNG PAYA', 'Female'),
(86, 'Lanang Hidayat', 'KRUENG BATU', 'Male'),
(87, 'Lala Riyanti S.Farm', 'GUNONG PULO', 'Male'),
(88, 'Ikhsan Narji Anggriawan', 'PULO IE I', 'Male'),
(89, 'Balijan Nyoman Haryanto M.Farm', 'KRUENG BATEE', 'Male'),
(90, 'Jarwa Wasita S.Pd', 'PASI KUALA ASAHAN', 'Male'),
(91, 'Kadir Garang Sinaga S.Farm', 'FAJAR HARAPAN', 'Female'),
(92, 'Kania Nasyiah S.IP', 'KRUENG KLUET', 'Female'),
(93, 'Zulfa Yuliana Prastuti', 'ALUR MAS', 'Female'),
(94, 'Laras Palastri S.E.', 'KAMPUNG TINGGI', 'Female'),
(95, 'Febi Hasanah', 'KAMPUNG RUAK', 'Female'),
(96, 'Tari Eva Laksita', 'KOTA FAJAR', 'Female'),
(97, 'Aswani Kuswoyo', 'GUNUNG PUDUNG', 'Male'),
(98, 'Paiman Luthfi Tampubolon S.T.', 'UJUNG PADANG ASAHAN', 'Male'),
(99, 'Ami Kusmawati', 'PULO IE II', 'Male'),
(100, 'Melinda Mayasari', 'IE MIRAH', 'Male');

INSERT INTO nilai(ID_NILAI, NILAI_TRAINEE) 
VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(10, 10),
(11, 11),
(12, 12),
(13, 13),
(14, 14),
(15, 15),
(16, 16),
(17, 17),
(18, 18),
(19, 19),
(20, 20),
(21, 21),
(22, 22),
(23, 23),
(24, 24),
(25, 25),
(26, 26),
(27, 27),
(28, 28),
(29, 29),
(30, 30),
(31, 31),
(32, 32),
(33, 33),
(34, 34),
(35, 35),
(36, 36),
(37, 37),
(38, 38),
(39, 39),
(40, 40),
(41, 41),
(42, 42),
(43, 43),
(44, 44),
(45, 45),
(46, 46),
(47, 47),
(48, 48),
(49, 49),
(50, 50),
(51, 51),
(52, 52),
(53, 53),
(54, 54),
(55, 55),
(56, 56),
(57, 57),
(58, 58),
(59, 59),
(60, 60),
(61, 61),
(62, 62),
(63, 63),
(64, 64),
(65, 65),
(66, 66),
(67, 67),
(68, 68),
(69, 69),
(70, 70),
(71, 71),
(72, 72),
(73, 73),
(74, 74),
(75, 75),
(76, 76),
(77, 77),
(78, 78),
(79, 79),
(80, 80),
(81, 81),
(82, 82),
(83, 83),
(84, 84),
(85, 85),
(86, 86),
(87, 87),
(88, 88),
(89, 89),
(90, 90),
(91, 91),
(92, 92),
(93, 93),
(94, 94),
(95, 95),
(96, 96),
(97, 97),
(98, 98),
(99, 99),
(100, 100);


INSERT INTO RELASI_MATERI(ID_RELASI_MATERI, ID_MATERI, ID_NILAI) 
VALUES
(101, 9901, 78),
(102, 9902, 78),
(103, 9903, 87),
(104, 9904, 97),
(105, 9905, 78),
(106, 9901, 89),
(107, 9902, 79),
(108, 9903, 98),
(109, 9904, 78),
(110, 9905, 98),
(111, 9901, 67),
(112, 9902, 87),
(113, 9903, 97),
(114, 9904, 97),
(115, 9905, 87),
(116, 9901, 87),
(117, 9902, 87),
(118, 9903, 67),
(119, 9904, 85),
(120, 9905, 86),
(121, 9901, 76),
(122, 9902, 89),
(123, 9903, 97),
(124, 9904, 67),
(125, 9905, 67),
(126, 9901, 87),
(127, 9902, 97),
(128, 9903, 67),
(129, 9904, 67),
(130, 9905, 67),
(131, 9901, 87),
(132, 9902, 67),
(133, 9903, 97),
(134, 9904, 67),
(135, 9905, 98),
(136, 9901, 67),
(137, 9902, 67),
(138, 9903, 87),
(139, 9904, 67),
(140, 9905, 98),
(141, 9901, 76),
(142, 9902, 67),
(143, 9903, 89),
(144, 9904, 76),
(145, 9905, 78),
(146, 9901, 98),
(147, 9902, 78),
(148, 9903, 67),
(149, 9904, 87),
(150, 9905, 67),
(151, 9901, 87),
(152, 9902, 67),
(153, 9903, 98),
(154, 9904, 67),
(155, 9905, 98),
(156, 9901, 67),
(157, 9902, 98),
(158, 9903, 67),
(159, 9904, 98),
(160, 9905, 67),
(161, 9901, 98),
(162, 9902, 67),
(163, 9903, 97),
(164, 9904, 67),
(165, 9905, 88),
(166, 9901, 76),
(167, 9902, 98),
(168, 9903, 76),
(169, 9904, 76),
(170, 9905, 76),
(171, 9901, 76),
(172, 9902, 87),
(173, 9903, 98),
(174, 9904, 67),
(175, 9905, 87),
(176, 9901, 67),
(177, 9902, 76),
(178, 9903, 85),
(179, 9904, 71),
(180, 9905, 72),
(181, 9901, 73),
(182, 9902, 85),
(183, 9903, 84),
(184, 9904, 93),
(185, 9905, 75),
(186, 9901, 82),
(187, 9902, 73),
(188, 9903, 72),
(189, 9904, 83),
(190, 9905, 83),
(191, 9901, 86),
(192, 9902, 75),
(193, 9903, 65),
(194, 9904, 86),
(195, 9905, 97),
(196, 9901, 75),
(197, 9902, 87),
(198, 9903, 97),
(199, 9904, 86),
(200, 9905, 57),
(201, 9901, 86),
(202, 9902, 97),
(203, 9903, 76),
(204, 9904, 79),
(205, 9905, 87),
(206, 9901, 96),
(207, 9902, 97),
(208, 9903, 77),
(209, 9904, 92),
(210, 9905, 80),
(211, 9901, 87),
(212, 9902, 80),
(213, 9903, 83),
(214, 9904, 89),
(215, 9905, 90),
(216, 9901, 61),
(217, 9902, 72),
(218, 9903, 80),
(219, 9904, 98),
(220, 9905, 70),
(221, 9901, 79),
(222, 9902, 68),
(223, 9903, 91),
(224, 9904, 77),
(225, 9905, 82),
(226, 9901, 83),
(227, 9902, 94),
(228, 9903, 92),
(229, 9904, 79),
(230, 9905, 69),
(231, 9901, 61),
(232, 9902, 71),
(233, 9903, 64),
(234, 9904, 91),
(235, 9905, 78),
(236, 9901, 81),
(237, 9902, 92),
(238, 9903, 81),
(239, 9904, 83),
(240, 9905, 64),
(241, 9901, 78),
(242, 9902, 67),
(243, 9903, 83),
(244, 9904, 88),
(245, 9905, 91),
(246, 9901, 65),
(247, 9902, 67),
(248, 9903, 84),
(249, 9904, 70),
(250, 9905, 97),
(251, 9901, 70),
(252, 9902, 100),
(253, 9903, 81),
(254, 9904, 66),
(255, 9905, 92),
(256, 9901, 62),
(257, 9902, 68),
(258, 9903, 83),
(259, 9904, 67),
(260, 9905, 93),
(261, 9901, 84),
(262, 9902, 70),
(263, 9903, 78),
(264, 9904, 74),
(265, 9905, 89),
(266, 9901, 77),
(267, 9902, 75),
(268, 9903, 95),
(269, 9904, 94),
(270, 9905, 78),
(271, 9901, 68),
(272, 9902, 100),
(273, 9903, 98),
(274, 9904, 80),
(275, 9905, 83),
(276, 9901, 71),
(277, 9902, 100),
(278, 9903, 73),
(279, 9904, 86),
(280, 9905, 77),
(281, 9901, 61),
(282, 9902, 83),
(283, 9903, 68),
(284, 9904, 65),
(285, 9905, 69),
(286, 9901, 92),
(287, 9902, 87),
(288, 9903, 73),
(289, 9904, 87),
(290, 9905, 88),
(291, 9901, 74),
(292, 9902, 78),
(293, 9903, 100),
(294, 9904, 75),
(295, 9905, 81),
(296, 9901, 92),
(297, 9902, 96),
(298, 9903, 62),
(299, 9904, 70),
(300, 9905, 100),
(301, 9901, 82),
(302, 9902, 88),
(303, 9903, 92),
(304, 9904, 77),
(305, 9905, 70),
(306, 9901, 69),
(307, 9902, 76),
(308, 9903, 92),
(309, 9904, 88),
(310, 9905, 97),
(311, 9901, 76),
(312, 9902, 73),
(313, 9903, 65),
(314, 9904, 87),
(315, 9905, 88),
(316, 9901, 72),
(317, 9902, 69),
(318, 9903, 75),
(319, 9904, 73),
(320, 9905, 87),
(321, 9901, 74),
(322, 9902, 78),
(323, 9903, 91),
(324, 9904, 64),
(325, 9905, 88),
(326, 9901, 91),
(327, 9902, 66),
(328, 9903, 100),
(329, 9904, 99),
(330, 9905, 91),
(331, 9901, 98),
(332, 9902, 79),
(333, 9903, 81),
(334, 9904, 86),
(335, 9905, 87),
(336, 9901, 90),
(337, 9902, 90),
(338, 9903, 75),
(339, 9904, 95),
(340, 9905, 73),
(341, 9901, 88),
(342, 9902, 87),
(343, 9903, 62),
(344, 9904, 84),
(345, 9905, 65),
(346, 9901, 68),
(347, 9902, 87),
(348, 9903, 77),
(349, 9904, 80),
(350, 9905, 78),
(351, 9901, 65),
(352, 9902, 60),
(353, 9903, 82),
(354, 9904, 86),
(355, 9905, 67),
(356, 9901, 60),
(357, 9902, 81),
(358, 9903, 84),
(359, 9904, 74),
(360, 9905, 87),
(361, 9901, 93),
(362, 9902, 74),
(363, 9903, 89),
(364, 9904, 82),
(365, 9905, 95),
(366, 9901, 63),
(367, 9902, 86),
(368, 9903, 60),
(369, 9904, 85),
(370, 9905, 76),
(371, 9901, 83),
(372, 9902, 78),
(373, 9903, 64),
(374, 9904, 97),
(375, 9905, 89),
(376, 9901, 64),
(377, 9902, 67),
(378, 9903, 62),
(379, 9904, 76),
(380, 9905, 75),
(381, 9901, 93),
(382, 9902, 73),
(383, 9903, 89),
(384, 9904, 62),
(385, 9905, 89),
(386, 9901, 64),
(387, 9902, 61),
(388, 9903, 75),
(389, 9904, 76),
(390, 9905, 100),
(391, 9901, 88),
(392, 9902, 86),
(393, 9903, 83),
(394, 9904, 60),
(395, 9905, 92),
(396, 9901, 78),
(397, 9902, 69),
(398, 9903, 68),
(399, 9904, 69),
(400, 9905, 90),
(401, 9901, 81),
(402, 9902, 97),
(403, 9903, 77),
(404, 9904, 70),
(405, 9905, 81),
(406, 9901, 65),
(407, 9902, 84),
(408, 9903, 85),
(409, 9904, 75),
(410, 9905, 80),
(411, 9901, 71),
(412, 9902, 91),
(413, 9903, 90),
(414, 9904, 88),
(415, 9905, 76),
(416, 9901, 76),
(417, 9902, 75),
(418, 9903, 81),
(419, 9904, 75),
(420, 9905, 60),
(421, 9901, 90),
(422, 9902, 61),
(423, 9903, 95),
(424, 9904, 63),
(425, 9905, 72),
(426, 9901, 61),
(427, 9902, 80),
(428, 9903, 81),
(429, 9904, 72),
(430, 9905, 67),
(431, 9901, 69),
(432, 9902, 99),
(433, 9903, 72),
(434, 9904, 63),
(435, 9905, 60),
(436, 9901, 64),
(437, 9902, 87),
(438, 9903, 97),
(439, 9904, 73),
(440, 9905, 96),
(441, 9901, 71),
(442, 9902, 95),
(443, 9903, 93),
(444, 9904, 71),
(445, 9905, 73),
(446, 9901, 84),
(447, 9902, 87),
(448, 9903, 79),
(449, 9904, 76),
(450, 9905, 82),
(451, 9901, 77),
(452, 9902, 84),
(453, 9903, 75),
(454, 9904, 81),
(455, 9905, 100),
(456, 9901, 86),
(457, 9902, 99),
(458, 9903, 92),
(459, 9904, 82),
(460, 9905, 62),
(461, 9901, 91),
(462, 9902, 96),
(463, 9903, 66),
(464, 9904, 73),
(465, 9905, 90),
(466, 9901, 96),
(467, 9902, 66),
(468, 9903, 65),
(469, 9904, 96),
(470, 9905, 73),
(471, 9901, 76),
(472, 9902, 67),
(473, 9903, 91),
(474, 9904, 77),
(475, 9905, 93),
(476, 9901, 61),
(477, 9902, 71),
(478, 9903, 65),
(479, 9904, 97),
(480, 9905, 69),
(481, 9901, 87),
(482, 9902, 89),
(483, 9903, 85),
(484, 9904, 72),
(485, 9905, 84),
(486, 9901, 84),
(487, 9902, 61),
(488, 9903, 83),
(489, 9904, 82),
(490, 9905, 72),
(491, 9901, 67),
(492, 9902, 95),
(493, 9903, 75),
(494, 9904, 87),
(495, 9905, 92),
(496, 9901, 67),
(497, 9902, 92),
(498, 9903, 66),
(499, 9904, 60),
(500, 9905, 94),
(501, 9901, 63),
(502, 9902, 82),
(503, 9903, 67),
(504, 9904, 91),
(505, 9905, 60),
(506, 9901, 80),
(507, 9902, 92),
(508, 9903, 74),
(509, 9904, 61),
(510, 9905, 98),
(511, 9901, 97),
(512, 9902, 99),
(513, 9903, 92),
(514, 9904, 69),
(515, 9905, 98),
(516, 9901, 73),
(517, 9902, 61),
(518, 9903, 64),
(519, 9904, 75),
(520, 9905, 96),
(521, 9901, 77),
(522, 9902, 96),
(523, 9903, 96),
(524, 9904, 94),
(525, 9905, 70),
(526, 9901, 77),
(527, 9902, 95),
(528, 9903, 65),
(529, 9904, 82),
(530, 9905, 89),
(531, 9901, 64),
(532, 9902, 71),
(533, 9903, 77),
(534, 9904, 71),
(535, 9905, 90),
(536, 9901, 83),
(537, 9902, 88),
(538, 9903, 88),
(539, 9904, 98),
(540, 9905, 83),
(541, 9901, 73),
(542, 9902, 78),
(543, 9903, 68),
(544, 9904, 83),
(545, 9905, 80),
(546, 9901, 66),
(547, 9902, 78),
(548, 9903, 84),
(549, 9904, 99),
(550, 9905, 76),
(551, 9901, 86),
(552, 9902, 85),
(553, 9903, 77),
(554, 9904, 87),
(555, 9905, 94),
(556, 9901, 79),
(557, 9902, 88),
(558, 9903, 75),
(559, 9904, 83),
(560, 9905, 67),
(561, 9901, 75),
(562, 9902, 74),
(563, 9903, 100),
(564, 9904, 61),
(565, 9905, 79),
(566, 9901, 92),
(567, 9902, 63),
(568, 9903, 97),
(569, 9904, 67),
(570, 9905, 91),
(571, 9901, 83),
(572, 9902, 67),
(573, 9903, 66),
(574, 9904, 60),
(575, 9905, 97),
(576, 9901, 83),
(577, 9902, 67),
(578, 9903, 99),
(579, 9904, 90),
(580, 9905, 81),
(581, 9901, 64),
(582, 9902, 60),
(583, 9903, 82),
(584, 9904, 100),
(585, 9905, 61),
(586, 9901, 96),
(587, 9902, 90),
(588, 9903, 79),
(589, 9904, 91),
(590, 9905, 94),
(591, 9901, 62),
(592, 9902, 85),
(593, 9903, 80),
(594, 9904, 93),
(595, 9905, 61),
(596, 9901, 89),
(597, 9902, 67),
(598, 9903, 89),
(599, 9904, 72),
(600, 9905, 90),
(601, 9901, 95),
(602, 9902, 93),
(603, 9903, 72),
(604, 9904, 65),
(605, 9905, 92),
(606, 9901, 73),
(607, 9902, 61),
(608, 9903, 64),
(609, 9904, 75),
(610, 9905, 96),
(611, 9901, 77),
(612, 9902, 96),
(613, 9903, 96),
(614, 9904, 94),
(615, 9905, 70),
(616, 9901, 77),
(617, 9902, 95),
(618, 9903, 65),
(619, 9904, 82),
(620, 9905, 89),
(621, 9901, 64),
(622, 9902, 71),
(623, 9903, 77),
(624, 9904, 71),
(625, 9905, 90),
(626, 9901, 83),
(627, 9902, 88),
(628, 9903, 88),
(629, 9904, 98),
(630, 9905, 83),
(631, 9901, 73),
(632, 9902, 78),
(633, 9903, 68),
(634, 9904, 83),
(635, 9905, 80),
(636, 9901, 66),
(637, 9902, 78),
(638, 9903, 84),
(639, 9904, 99),
(640, 9905, 76),
(641, 9901, 86),
(642, 9902, 85),
(643, 9903, 77),
(644, 9904, 87),
(645, 9905, 94),
(646, 9901, 79),
(647, 9902, 88),
(648, 9903, 75),
(649, 9904, 83),
(650, 9905, 67),
(651, 9901, 75),
(652, 9902, 74),
(653, 9903, 100),
(654, 9904, 61),
(655, 9905, 79),
(656, 9901, 92),
(657, 9902, 63),
(658, 9903, 97),
(659, 9904, 67),
(660, 9905, 91),
(661, 9901, 83),
(662, 9902, 67),
(663, 9903, 66),
(664, 9904, 60),
(665, 9905, 97),
(666, 9901, 83),
(667, 9902, 67),
(668, 9903, 99),
(669, 9904, 90),
(670, 9905, 81),
(671, 9901, 64),
(672, 9902, 60),
(673, 9903, 82),
(674, 9904, 100),
(675, 9905, 61),
(676, 9901, 96),
(677, 9902, 90),
(678, 9903, 79),
(679, 9904, 91),
(680, 9905, 94),
(681, 9901, 62),
(682, 9902, 85),
(683, 9903, 80),
(684, 9904, 93),
(685, 9905, 61),
(686, 9901, 89),
(687, 9902, 67),
(688, 9903, 89),
(689, 9904, 72),
(690, 9905, 73),
(691, 9901, 61),
(692, 9902, 64),
(693, 9903, 75),
(694, 9904, 96),
(695, 9905, 77),
(696, 9901, 96),
(697, 9902, 96),
(698, 9903, 94),
(699, 9904, 70),
(700, 9905, 77);

INSERT INTO RELASI_BATCH_KELAS (ID_RELASI_BATCH, ID_TRAINEE, ID_BATCH, ID_KELAS, ID_RELASI_MATERI) 
VALUES 
(1, 1, 1, 1101, 101),
(2, 1, 1, 1101, 102),
(3, 1, 1, 1101, 103),
(4, 1, 1, 1101, 104),
(5, 1, 1, 1101, 105),
(6, 2, 1, 1101, 106),
(7, 2, 1, 1101, 107),
(8, 2, 1, 1101, 108),
(9, 2, 1, 1101, 109),
(10, 2, 1, 1101, 110),
(11, 3, 1, 1101, 111),
(12, 3, 1, 1101, 112),
(13, 3, 1, 1101, 113),
(14, 3, 1, 1101, 114),
(15, 3, 1, 1101, 115),
(16, 4, 1, 1101, 116),
(17, 4, 1, 1101, 117),
(18, 4, 1, 1101, 118),
(19, 4, 1, 1101, 119),
(20, 4, 1, 1101, 120),
(21, 5, 1, 1101, 121),
(22, 5, 1, 1101, 122),
(23, 5, 1, 1101, 123),
(24, 5, 1, 1101, 124),
(25, 5, 1, 1101, 125),
(26, 6, 1, 1101, 126),
(27, 6, 1, 1101, 127),
(28, 6, 1, 1101, 128),
(29, 6, 1, 1101, 129),
(30, 6, 1, 1101, 130),
(31, 7, 1, 1101, 131),
(32, 7, 1, 1101, 132),
(33, 7, 1, 1101, 133),
(34, 7, 1, 1101, 134),
(35, 7, 1, 1101, 135),
(36, 8, 1, 1101, 136),
(37, 8, 1, 1101, 137),
(38, 8, 1, 1101, 138),
(39, 8, 1, 1101, 139),
(40, 8, 1, 1101, 140),
(41, 9, 1, 1101, 141),
(42, 9, 1, 1101, 142),
(43, 9, 1, 1101, 143),
(44, 9, 1, 1101, 144),
(45, 9, 1, 1101, 145),
(46, 10, 1, 1101, 146),
(47, 10, 1, 1101, 147),
(48, 10, 1, 1101, 148),
(49, 10, 1, 1101, 149),
(50, 10, 1, 1101, 150),
(51, 11, 1, 1102, 151),
(52, 11, 1, 1102, 152),
(53, 11, 1, 1102, 153),
(54, 11, 1, 1102, 154),
(55, 11, 1, 1102, 155),
(56, 12, 1, 1102, 156),
(57, 12, 1, 1102, 157),
(58, 12, 1, 1102, 158),
(59, 12, 1, 1102, 159),
(60, 12, 1, 1102, 160),
(61, 13, 1, 1102, 161),
(62, 13, 1, 1102, 162),
(63, 13, 1, 1102, 163),
(64, 13, 1, 1102, 164),
(65, 13, 1, 1102, 165),
(66, 14, 1, 1102, 166),
(67, 14, 1, 1102, 167),
(68, 14, 1, 1102, 168),
(69, 14, 1, 1102, 169),
(70, 14, 1, 1102, 170),
(71, 15, 1, 1102, 171),
(72, 15, 1, 1102, 172),
(73, 15, 1, 1102, 173),
(74, 15, 1, 1102, 174),
(75, 15, 1, 1102, 175),
(76, 16, 1, 1102, 176),
(77, 16, 1, 1102, 177),
(78, 16, 1, 1102, 178),
(79, 16, 1, 1102, 179),
(80, 16, 1, 1102, 180),
(81, 17, 1, 1102, 181),
(82, 17, 1, 1102, 182),
(83, 17, 1, 1102, 183),
(84, 17, 1, 1102, 184),
(85, 17, 1, 1102, 185),
(86, 18, 1, 1102, 186),
(87, 18, 1, 1102, 187),
(88, 18, 1, 1102, 188),
(89, 18, 1, 1102, 189),
(90, 18, 1, 1102, 190),
(91, 19, 1, 1102, 191),
(92, 19, 1, 1102, 192),
(93, 19, 1, 1102, 193),
(94, 19, 1, 1102, 194),
(95, 19, 1, 1102, 195),
(96, 20, 1, 1102, 196),
(97, 20, 1, 1102, 197),
(98, 20, 1, 1102, 198),
(99, 20, 1, 1102, 199),
(100, 20, 1, 1102, 200),
(101, 21, 2, 1103, 201),
(102, 21, 2, 1103, 202),
(103, 21, 2, 1103, 203),
(104, 21, 2, 1103, 204),
(105, 21, 2, 1103, 205),
(106, 22, 2, 1103, 206),
(107, 22, 2, 1103, 207),
(108, 22, 2, 1103, 208),
(109, 22, 2, 1103, 209),
(110, 22, 2, 1103, 210),
(111, 23, 2, 1103, 211),
(112, 23, 2, 1103, 212),
(113, 23, 2, 1103, 213),
(114, 23, 2, 1103, 214),
(115, 23, 2, 1103, 215),
(116, 24, 2, 1103, 216),
(117, 24, 2, 1103, 217),
(118, 24, 2, 1103, 218),
(119, 24, 2, 1103, 219),
(120, 24, 2, 1103, 220),
(121, 25, 2, 1103, 221),
(122, 25, 2, 1103, 222),
(123, 25, 2, 1103, 223),
(124, 25, 2, 1103, 224),
(125, 25, 2, 1103, 225),
(126, 26, 2, 1103, 226),
(127, 26, 2, 1103, 227),
(128, 26, 2, 1103, 228),
(129, 26, 2, 1103, 229),
(130, 26, 2, 1103, 230),
(131, 27, 2, 1103, 231),
(132, 27, 2, 1103, 232),
(133, 27, 2, 1103, 233),
(134, 27, 2, 1103, 234),
(135, 27, 2, 1103, 235),
(136, 28, 2, 1103, 236),
(137, 28, 2, 1103, 237),
(138, 28, 2, 1103, 238),
(139, 28, 2, 1103, 239),
(140, 28, 2, 1103, 240),
(141, 29, 2, 1103, 241),
(142, 29, 2, 1103, 242),
(143, 29, 2, 1103, 243),
(144, 29, 2, 1103, 244),
(145, 29, 2, 1103, 245),
(146, 30, 2, 1103, 246),
(147, 30, 2, 1103, 247),
(148, 30, 2, 1103, 248),
(149, 30, 2, 1103, 249),
(150, 30, 2, 1103, 250),
(151, 31, 2, 1104, 251),
(152, 31, 2, 1104, 252),
(153, 31, 2, 1104, 253),
(154, 31, 2, 1104, 254),
(155, 31, 2, 1104, 255),
(156, 32, 2, 1104, 256),
(157, 32, 2, 1104, 257),
(158, 32, 2, 1104, 258),
(159, 32, 2, 1104, 259),
(160, 32, 2, 1104, 260),
(161, 33, 2, 1104, 261),
(162, 33, 2, 1104, 262),
(163, 33, 2, 1104, 263),
(164, 33, 2, 1104, 264),
(165, 33, 2, 1104, 265),
(166, 34, 2, 1104, 266),
(167, 34, 2, 1104, 267),
(168, 34, 2, 1104, 268),
(169, 34, 2, 1104, 269),
(170, 34, 2, 1104, 270),
(171, 35, 2, 1104, 271),
(172, 35, 2, 1104, 272),
(173, 35, 2, 1104, 273),
(174, 35, 2, 1104, 274),
(175, 35, 2, 1104, 275),
(176, 36, 2, 1104, 276),
(177, 36, 2, 1104, 277),
(178, 36, 2, 1104, 278),
(179, 36, 2, 1104, 279),
(180, 36, 2, 1104, 280),
(181, 37, 2, 1104, 281),
(182, 37, 2, 1104, 282),
(183, 37, 2, 1104, 283),
(184, 37, 2, 1104, 284),
(185, 37, 2, 1104, 285),
(186, 38, 2, 1104, 286),
(187, 38, 2, 1104, 287),
(188, 38, 2, 1104, 288),
(189, 38, 2, 1104, 289),
(190, 38, 2, 1104, 290),
(191, 39, 2, 1104, 291),
(192, 39, 2, 1104, 292),
(193, 39, 2, 1104, 293),
(194, 39, 2, 1104, 294),
(195, 39, 2, 1104, 295),
(196, 40, 2, 1104, 296),
(197, 40, 2, 1104, 297),
(198, 40, 2, 1104, 298),
(199, 40, 2, 1104, 299),
(200, 40, 2, 1104, 300),
(201, 41, 3, 1105, 301),
(202, 41, 3, 1105, 302),
(203, 41, 3, 1105, 303),
(204, 41, 3, 1105, 304),
(205, 41, 3, 1105, 305),
(206, 42, 3, 1105, 306),
(207, 42, 3, 1105, 307),
(208, 42, 3, 1105, 308),
(209, 42, 3, 1105, 309),
(210, 42, 3, 1105, 310),
(211, 43, 3, 1105, 311),
(212, 43, 3, 1105, 312),
(213, 43, 3, 1105, 313),
(214, 43, 3, 1105, 314),
(215, 43, 3, 1105, 315),
(216, 44, 3, 1105, 316),
(217, 44, 3, 1105, 317),
(218, 44, 3, 1105, 318),
(219, 44, 3, 1105, 319),
(220, 44, 3, 1105, 320),
(221, 45, 3, 1105, 321),
(222, 45, 3, 1105, 322),
(223, 45, 3, 1105, 323),
(224, 45, 3, 1105, 324),
(225, 45, 3, 1105, 325),
(226, 46, 3, 1105, 326),
(227, 46, 3, 1105, 327),
(228, 46, 3, 1105, 328),
(229, 46, 3, 1105, 329),
(230, 46, 3, 1105, 330),
(231, 47, 3, 1105, 331),
(232, 47, 3, 1105, 332),
(233, 47, 3, 1105, 333),
(234, 47, 3, 1105, 334),
(235, 47, 3, 1105, 335),
(236, 48, 3, 1105, 336),
(237, 48, 3, 1105, 337),
(238, 48, 3, 1105, 338),
(239, 48, 3, 1105, 339),
(240, 48, 3, 1105, 340),
(241, 49, 3, 1105, 341),
(242, 49, 3, 1105, 342),
(243, 49, 3, 1105, 343),
(244, 49, 3, 1105, 344),
(245, 49, 3, 1105, 345),
(246, 50, 3, 1105, 346),
(247, 50, 3, 1105, 347),
(248, 50, 3, 1105, 348),
(249, 50, 3, 1105, 349),
(250, 50, 3, 1105, 350),
(251, 51, 3, 1106, 351),
(252, 51, 3, 1106, 352),
(253, 51, 3, 1106, 353),
(254, 51, 3, 1106, 354),
(255, 51, 3, 1106, 355),
(256, 52, 3, 1106, 356),
(257, 52, 3, 1106, 357),
(258, 52, 3, 1106, 358),
(259, 52, 3, 1106, 359),
(260, 52, 3, 1106, 360),
(261, 53, 3, 1106, 361),
(262, 53, 3, 1106, 362),
(263, 53, 3, 1106, 363),
(264, 53, 3, 1106, 364),
(265, 53, 3, 1106, 365),
(266, 54, 3, 1106, 366),
(267, 54, 3, 1106, 367),
(268, 54, 3, 1106, 368),
(269, 54, 3, 1106, 369),
(270, 54, 3, 1106, 370),
(271, 55, 3, 1106, 371),
(272, 55, 3, 1106, 372),
(273, 55, 3, 1106, 373),
(274, 55, 3, 1106, 374),
(275, 55, 3, 1106, 375),
(276, 56, 3, 1106, 376),
(277, 56, 3, 1106, 377),
(278, 56, 3, 1106, 378),
(279, 56, 3, 1106, 379),
(280, 56, 3, 1106, 380),
(281, 57, 3, 1106, 381),
(282, 57, 3, 1106, 382),
(283, 57, 3, 1106, 383),
(284, 57, 3, 1106, 384),
(285, 57, 3, 1106, 385),
(286, 58, 3, 1106, 386),
(287, 58, 3, 1106, 387),
(288, 58, 3, 1106, 388),
(289, 58, 3, 1106, 389),
(290, 58, 3, 1106, 390),
(291, 59, 3, 1106, 391),
(292, 59, 3, 1106, 392),
(293, 59, 3, 1106, 393),
(294, 59, 3, 1106, 394),
(295, 59, 3, 1106, 395),
(296, 60, 3, 1106, 396),
(297, 60, 3, 1106, 397),
(298, 60, 3, 1106, 398),
(299, 60, 3, 1106, 399),
(300, 60, 3, 1106, 400),
(301, 61, 4, 1107, 401),
(302, 61, 4, 1107, 402),
(303, 61, 4, 1107, 403),
(304, 61, 4, 1107, 404),
(305, 61, 4, 1107, 405),
(306, 62, 4, 1107, 406),
(307, 62, 4, 1107, 407),
(308, 62, 4, 1107, 408),
(309, 62, 4, 1107, 409),
(310, 62, 4, 1107, 410),
(311, 63, 4, 1107, 411),
(312, 63, 4, 1107, 412),
(313, 63, 4, 1107, 413),
(314, 63, 4, 1107, 414),
(315, 63, 4, 1107, 415),
(316, 64, 4, 1107, 416),
(317, 64, 4, 1107, 417),
(318, 64, 4, 1107, 418),
(319, 64, 4, 1107, 419),
(320, 64, 4, 1107, 420),
(321, 65, 4, 1107, 421),
(322, 65, 4, 1107, 422),
(323, 65, 4, 1107, 423),
(324, 65, 4, 1107, 424),
(325, 65, 4, 1107, 425),
(326, 66, 4, 1107, 426),
(327, 66, 4, 1107, 427),
(328, 66, 4, 1107, 428),
(329, 66, 4, 1107, 429),
(330, 66, 4, 1107, 430),
(331, 67, 4, 1107, 431),
(332, 67, 4, 1107, 432),
(333, 67, 4, 1107, 433),
(334, 67, 4, 1107, 434),
(335, 67, 4, 1107, 435),
(336, 68, 4, 1107, 436),
(337, 68, 4, 1107, 437),
(338, 68, 4, 1107, 438),
(339, 68, 4, 1107, 439),
(340, 68, 4, 1107, 440),
(341, 69, 4, 1107, 441),
(342, 69, 4, 1107, 442),
(343, 69, 4, 1107, 443),
(344, 69, 4, 1107, 444),
(345, 69, 4, 1107, 445),
(346, 70, 4, 1107, 446),
(347, 70, 4, 1107, 447),
(348, 70, 4, 1107, 448),
(349, 70, 4, 1107, 449),
(350, 70, 4, 1107, 450),
(351, 71, 4, 1108, 451),
(352, 71, 4, 1108, 452),
(353, 71, 4, 1108, 453),
(354, 71, 4, 1108, 454),
(355, 71, 4, 1108, 455),
(356, 72, 4, 1108, 456),
(357, 72, 4, 1108, 457),
(358, 72, 4, 1108, 458),
(359, 72, 4, 1108, 459),
(360, 72, 4, 1108, 460),
(361, 73, 4, 1108, 461),
(362, 73, 4, 1108, 462),
(363, 73, 4, 1108, 463),
(364, 73, 4, 1108, 464),
(365, 73, 4, 1108, 465),
(366, 74, 4, 1108, 466),
(367, 74, 4, 1108, 467),
(368, 74, 4, 1108, 468),
(369, 74, 4, 1108, 469),
(370, 74, 4, 1108, 470),
(371, 75, 4, 1108, 471),
(372, 75, 4, 1108, 472),
(373, 75, 4, 1108, 473),
(374, 75, 4, 1108, 474),
(375, 75, 4, 1108, 475),
(376, 76, 4, 1108, 476),
(377, 76, 4, 1108, 477),
(378, 76, 4, 1108, 478),
(379, 76, 4, 1108, 479),
(380, 76, 4, 1108, 480),
(381, 77, 4, 1108, 481),
(382, 77, 4, 1108, 482),
(383, 77, 4, 1108, 483),
(384, 77, 4, 1108, 484),
(385, 77, 4, 1108, 485),
(386, 78, 4, 1108, 486),
(387, 78, 4, 1108, 487),
(388, 78, 4, 1108, 488),
(389, 78, 4, 1108, 489),
(390, 78, 4, 1108, 490),
(391, 79, 4, 1108, 491),
(392, 79, 4, 1108, 492),
(393, 79, 4, 1108, 493),
(394, 79, 4, 1108, 494),
(395, 79, 4, 1108, 495),
(396, 80, 4, 1108, 496),
(397, 80, 4, 1108, 497),
(398, 80, 4, 1108, 498),
(399, 80, 4, 1108, 499),
(400, 80, 4, 1108, 500),
(401, 81, 5, 1109, 501),
(402, 81, 5, 1109, 502),
(403, 81, 5, 1109, 503),
(404, 81, 5, 1109, 504),
(405, 81, 5, 1109, 505),
(406, 82, 5, 1109, 506),
(407, 82, 5, 1109, 507),
(408, 82, 5, 1109, 508),
(409, 82, 5, 1109, 509),
(410, 82, 5, 1109, 510),
(411, 83, 5, 1109, 511),
(412, 83, 5, 1109, 512),
(413, 83, 5, 1109, 513),
(414, 83, 5, 1109, 514),
(415, 83, 5, 1109, 515),
(416, 84, 5, 1109, 516),
(417, 84, 5, 1109, 517),
(418, 84, 5, 1109, 518),
(419, 84, 5, 1109, 519),
(420, 84, 5, 1109, 520),
(421, 85, 5, 1109, 521),
(422, 85, 5, 1109, 522),
(423, 85, 5, 1109, 523),
(424, 85, 5, 1109, 524),
(425, 85, 5, 1109, 525),
(426, 86, 5, 1109, 526),
(427, 86, 5, 1109, 527),
(428, 86, 5, 1109, 528),
(429, 86, 5, 1109, 529),
(430, 86, 5, 1109, 530),
(431, 87, 5, 1109, 531),
(432, 87, 5, 1109, 532),
(433, 87, 5, 1109, 533),
(434, 87, 5, 1109, 534),
(435, 87, 5, 1109, 535),
(436, 88, 5, 1109, 536),
(437, 88, 5, 1109, 537),
(438, 88, 5, 1109, 538),
(439, 88, 5, 1109, 539),
(440, 88, 5, 1109, 540),
(441, 89, 5, 1109, 541),
(442, 89, 5, 1109, 542),
(443, 89, 5, 1109, 543),
(444, 89, 5, 1109, 544),
(445, 89, 5, 1109, 545),
(446, 90, 5, 1109, 546),
(447, 90, 5, 1109, 547),
(448, 90, 5, 1109, 548),
(449, 90, 5, 1109, 549),
(450, 90, 5, 1109, 550),
(451, 91, 5, 1110, 551),
(452, 91, 5, 1110, 552),
(453, 91, 5, 1110, 553),
(454, 91, 5, 1110, 554),
(455, 91, 5, 1110, 555),
(456, 92, 5, 1110, 556),
(457, 92, 5, 1110, 557),
(458, 92, 5, 1110, 558),
(459, 92, 5, 1110, 559),
(460, 92, 5, 1110, 560),
(461, 93, 5, 1110, 561),
(462, 93, 5, 1110, 562),
(463, 93, 5, 1110, 563),
(464, 93, 5, 1110, 564),
(465, 93, 5, 1110, 565),
(466, 94, 5, 1110, 566),
(467, 94, 5, 1110, 567),
(468, 94, 5, 1110, 568),
(469, 94, 5, 1110, 569),
(470, 94, 5, 1110, 570),
(471, 95, 5, 1110, 571),
(472, 95, 5, 1110, 572),
(473, 95, 5, 1110, 573),
(474, 95, 5, 1110, 574),
(475, 95, 5, 1110, 575),
(476, 96, 5, 1110, 576),
(477, 96, 5, 1110, 577),
(478, 96, 5, 1110, 578),
(479, 96, 5, 1110, 579),
(480, 96, 5, 1110, 580),
(481, 97, 5, 1110, 581),
(482, 97, 5, 1110, 582),
(483, 97, 5, 1110, 583),
(484, 97, 5, 1110, 584),
(485, 97, 5, 1110, 585),
(486, 98, 5, 1110, 586),
(487, 98, 5, 1110, 587),
(488, 98, 5, 1110, 588),
(489, 98, 5, 1110, 589),
(490, 98, 5, 1110, 590),
(491, 99, 5, 1110, 591),
(492, 99, 5, 1110, 592),
(493, 99, 5, 1110, 593),
(494, 99, 5, 1110, 594),
(495, 99, 5, 1110, 595),
(496, 100, 5, 1110, 596),
(497, 100, 5, 1110, 597),
(498, 100, 5, 1110, 598),
(499, 100, 5, 1110, 599),
(500, 100, 5, 1110, 600);

select * from batch;
select * from kelas;
select * from materi;
select * from nilai;
select * from trainee;
select * from relasi_batch_kelas;
select * from relasi_materi;

-- 1.TAMPILKAN DATA TRAINEE DENGAN INFORMASI KELAS DAN BATCH

select  tr.ID_TRAINEE,tr.NAME_TRAINEE,tr.ASAL_TRAINEE,tr.GENDER,k.NAMA_KELAS,b.NAMA_BATCH 
	from 
		relasi_batch_kelas rbk
			INNER JOIN trainee tr
				on tr.ID_TRAINEE =  rbk.ID_TRAINEE
			INNER JOIN batch b
				on b.ID_BATCH = rbk.ID_BATCH
			INNER JOIN kelas k
				on k.ID_KELAS = rbk.ID_KELAS
			group by NAME_TRAINEE
            order by ID_TRAINEE
			;
    
    
-- 2.LIST MATERI PADA BATCH     
select  m.NAMA_MATERI,b.NAMA_BATCH 
	from 
		relasi_batch_kelas rbk
			INNER JOIN trainee tr
				on tr.ID_TRAINEE =  rbk.ID_TRAINEE
			INNER JOIN batch b
				on b.ID_BATCH = rbk.ID_BATCH
			INNER JOIN kelas k
				on k.ID_KELAS = rbk.ID_KELAS
			INNER JOIN relasi_materi rm
				on rm.ID_RELASI_MATERI = rbk.ID_RELASI_MATERI
			INNER JOIN materi m
				on m.ID_MATERI = rm.ID_MATERI          
			group by NAMA_MATERI,NAMA_BATCH
            order by NAMA_MATERI,NAMA_BATCH 
			;
            
            
--  3.LIST TRAINEE DARI KELAS DAN BATCH            
 select  tr.NAME_TRAINEE,k.NAMA_KELAS,b.NAMA_BATCH
	from 
		relasi_batch_kelas rbk
			INNER JOIN trainee tr
				on tr.ID_TRAINEE =  rbk.ID_TRAINEE
			INNER JOIN batch b
				on b.ID_BATCH = rbk.ID_BATCH
			INNER JOIN kelas k
				on k.ID_KELAS = rbk.ID_KELAS
			INNER JOIN relasi_materi rm
				on rm.ID_RELASI_MATERI = rbk.ID_RELASI_MATERI
			INNER JOIN materi m
				on m.ID_MATERI = rm.ID_MATERI    
			group by NAME_TRAINEE,NAMA_KELAS,NAMA_BATCH
			;           
            
            
-- 4.LIST NILAI DARI SEORANG TRAINEE
select  tr.ID_TRAINEE,tr.NAME_TRAINEE,n.NILAI_TRAINEE
	from 
		relasi_batch_kelas rbk
			INNER JOIN trainee tr
				on tr.ID_TRAINEE =  rbk.ID_TRAINEE
			INNER JOIN batch b
				on b.ID_BATCH = rbk.ID_BATCH
			INNER JOIN kelas k
				on k.ID_KELAS = rbk.ID_KELAS
			INNER JOIN relasi_materi rm
				on rm.ID_RELASI_MATERI = rbk.ID_RELASI_MATERI
			INNER JOIN materi m
				on m.ID_MATERI = rm.ID_MATERI
			INNER JOIN nilai n
				on n.ID_NILAI = rm.ID_NILAI
			group by NAME_TRAINEE
            order by ID_TRAINEE
			;           
            
-- 5.RATA RATA NILAI TRAINEE BERDASARKAN KELAS

select  k.NAMA_KELAS,avg(NILAI_TRAINEE) as RATA_RATA
	from 
		relasi_batch_kelas rbk
			INNER JOIN trainee tr
				on tr.ID_TRAINEE =  rbk.ID_TRAINEE
			INNER JOIN batch b
				on b.ID_BATCH = rbk.ID_BATCH
			INNER JOIN kelas k
				on k.ID_KELAS = rbk.ID_KELAS
			INNER JOIN relasi_materi rm
				on rm.ID_RELASI_MATERI = rbk.ID_RELASI_MATERI
			INNER JOIN materi m
				on m.ID_MATERI = rm.ID_MATERI
			INNER JOIN nilai n
				on n.ID_NILAI = rm.ID_NILAI
			group by NAMA_KELAS
            order by NAMA_KELAS
			;
            
            
-- 6.NILAI TERTINGGI DARI MATERI TERTENTU PER KELAS

select  m.NAMA_MATERI,k.NAMA_KELAS,max(NILAI_TRAINEE) as NILAI_MAKSIMUM
	from 
		relasi_batch_kelas rbk
			INNER JOIN trainee tr
				on tr.ID_TRAINEE =  rbk.ID_TRAINEE
			INNER JOIN batch b
				on b.ID_BATCH = rbk.ID_BATCH
			INNER JOIN kelas k
				on k.ID_KELAS = rbk.ID_KELAS
			INNER JOIN relasi_materi rm
				on rm.ID_RELASI_MATERI = rbk.ID_RELASI_MATERI
			INNER JOIN materi m
				on m.ID_MATERI = rm.ID_MATERI
			INNER JOIN nilai n
				on n.ID_NILAI = rm.ID_NILAI
                group by NAMA_MATERI,NAMA_KELAS
                order by NAMA_MATERI
			;
            
            
-- 7.NILAI TERTINGGI DARI MATERI TERNTENTU PER BATCH

select  m.NAMA_MATERI,b.NAMA_BATCH,max(NILAI_TRAINEE) as NILAI_MAKSIMUM
	from 
		relasi_batch_kelas rbk
			INNER JOIN trainee tr
				on tr.ID_TRAINEE =  rbk.ID_TRAINEE
			INNER JOIN batch b
				on b.ID_BATCH = rbk.ID_BATCH
			INNER JOIN kelas k
				on k.ID_KELAS = rbk.ID_KELAS
			INNER JOIN relasi_materi rm
				on rm.ID_RELASI_MATERI = rbk.ID_RELASI_MATERI
			INNER JOIN materi m
				on m.ID_MATERI = rm.ID_MATERI
			INNER JOIN nilai n
				on n.ID_NILAI = rm.ID_NILAI
                group by NAMA_MATERI,NAMA_BATCH
                order by NAMA_BATCH
			;
            
            
-- 8.NILAI RATA RATA PERKELAS

select  k.NAMA_KELAS,avg(NILAI_TRAINEE) as NILAI_RATA_RATA
	from 
		relasi_batch_kelas rbk
			INNER JOIN trainee tr
				on tr.ID_TRAINEE =  rbk.ID_TRAINEE
			INNER JOIN batch b
				on b.ID_BATCH = rbk.ID_BATCH
			INNER JOIN kelas k
				on k.ID_KELAS = rbk.ID_KELAS
			INNER JOIN relasi_materi rm
				on rm.ID_RELASI_MATERI = rbk.ID_RELASI_MATERI
			INNER JOIN materi m
				on m.ID_MATERI = rm.ID_MATERI
			INNER JOIN nilai n
				on n.ID_NILAI = rm.ID_NILAI
                group by NAMA_KELAS
                order by NAMA_KELAS
			;
            
            
            
-- 9.NILAI RATA RATA PER BATCH

select  b.NAMA_BATCH,avg(NILAI_TRAINEE) as NILAI_RATA_RATA
	from 
		relasi_batch_kelas rbk
			INNER JOIN trainee tr
				on tr.ID_TRAINEE =  rbk.ID_TRAINEE
			INNER JOIN batch b
				on b.ID_BATCH = rbk.ID_BATCH
			INNER JOIN kelas k
				on k.ID_KELAS = rbk.ID_KELAS
			INNER JOIN relasi_materi rm
				on rm.ID_RELASI_MATERI = rbk.ID_RELASI_MATERI
			INNER JOIN materi m
				on m.ID_MATERI = rm.ID_MATERI
			INNER JOIN nilai n
				on n.ID_NILAI = rm.ID_NILAI
                group by NAMA_BATCH
                order by NAMA_BATCH
			;
            
            
-- 10. 5 NILAI TERTINGGI DARI SATU BATCH UNTUK MATERI TERTENTU

select  b.NAMA_BATCH,m.NAMA_MATERI,n.NILAI_TRAINEE 
	from 
		relasi_batch_kelas rbk
			INNER JOIN trainee tr
				on tr.ID_TRAINEE =  rbk.ID_TRAINEE
			INNER JOIN batch b
				on b.ID_BATCH = rbk.ID_BATCH
			INNER JOIN kelas k
				on k.ID_KELAS = rbk.ID_KELAS
			INNER JOIN relasi_materi rm
				on rm.ID_RELASI_MATERI = rbk.ID_RELASI_MATERI
			INNER JOIN materi m
				on m.ID_MATERI = rm.ID_MATERI
			INNER JOIN nilai n
				on n.ID_NILAI = rm.ID_NILAI
			where NAMA_MATERI = 'DATABASE' AND NAMA_BATCH = 'BATCH 01'
			order by NILAI_TRAINEE desc
            limit 5
			;
            
    
--     11.5 NILAI RATA RATA TERTINGGI DARI SATU BATCH
	select  b.NAMA_BATCH,AVG(NILAI_TRAINEE)  as NILAI_RATA_RATA_TERTINGGI
	from 
		relasi_batch_kelas rbk
			INNER JOIN trainee tr
				on tr.ID_TRAINEE =  rbk.ID_TRAINEE
			INNER JOIN batch b
				on b.ID_BATCH = rbk.ID_BATCH
			INNER JOIN kelas k
				on k.ID_KELAS = rbk.ID_KELAS
			INNER JOIN relasi_materi rm
				on rm.ID_RELASI_MATERI = rbk.ID_RELASI_MATERI
			INNER JOIN materi m
				on m.ID_MATERI = rm.ID_MATERI
			INNER JOIN nilai n
				on n.ID_NILAI = rm.ID_NILAI
			where NAMA_MATERI = 'DATABASE' AND NAMA_BATCH = 'BATCH 01'
            group by NILAI_TRAINEE
			order by NILAI_TRAINEE desc
            limit 5
			;
            
            
-- 	12. list materi dari batch tertentu beserta dengan nilai rata ratanya
    
    select  m.NAMA_MATERI,b.NAMA_BATCH,AVG(NILAI_TRAINEE) as rata_rata
	from 
		relasi_batch_kelas rbk
			INNER JOIN trainee tr
				on tr.ID_TRAINEE =  rbk.ID_TRAINEE
			INNER JOIN batch b
				on b.ID_BATCH = rbk.ID_BATCH
			INNER JOIN kelas k
				on k.ID_KELAS = rbk.ID_KELAS
			INNER JOIN relasi_materi rm
				on rm.ID_RELASI_MATERI = rbk.ID_RELASI_MATERI
			INNER JOIN materi m
				on m.ID_MATERI = rm.ID_MATERI
			INNER JOIN nilai n
				on n.ID_NILAI = rm.ID_NILAI
			where NAMA_BATCH = 'BATCH 01'
            group by NAMA_MATERI
            order by NAMA_MATERI,NAMA_BATCH
			;
            
            
            
	



