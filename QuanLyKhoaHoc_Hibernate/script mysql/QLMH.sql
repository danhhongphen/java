


CREATE TABLE GiaoVien
(
	MaGiaoVien int NOT NULL,
	TenGiaoVien NVARCHAR(50) NOT NULL,
	MatKhau VARCHAR(50) NOT NULL,
	PRIMARY KEY(MaGiaoVien)
);

CREATE TABLE SinhVien
(
	MaSinhVien int NOT NULL,
	TenSinhVien NVARCHAR(50) NOT NULL,
	MatKhau VARCHAR(50) NOT NULL,
	PRIMARY KEY(MaSinhVien)
);

CREATE TABLE LopHoc
(
	MaLopHoc VARCHAR(50) NOT NULL,
	TenLopHoc NVARCHAR(50) NOT NULL,
	PhongHoc NVARCHAR(50) NOT NULL,
	NgayBatDau DATE NOT NULL,
	NgayKetThuc DATE NOT NULL,
	GioBatDau TIME NOT NULL,
	GioKetThuc TIME NOT NULL,
	Thu VARCHAR(50) NOT NULL,

	PRIMARY KEY (MaLopHoc)
);

CREATE TABLE GiaoVien_LopHoc
(
	MaGiaoVien int NOT NULL,
	MaLopHoc VARCHAR(50) NOT NULL,
	PRIMARY KEY (MaGiaoVien, MaLopHoc)
);

CREATE TABLE SinhVien_LopHoc
(
	MaSinhVien int NOT NULL,
	MaLopHoc VARCHAR(50) NOT NULL,
    Tuan1 INT NOT NULL,
    Tuan2 INT NOT NULL,
    Tuan3 INT NOT NULL,
    Tuan4 INT NOT NULL,
    Tuan5 INT NOT NULL,
    Tuan6 INT NOT NULL,
    Tuan7 INT NOT NULL,
    Tuan8 INT NOT NULL,
    Tuan9 INT NOT NULL,
    Tuan10 INT NOT NULL,
    Tuan11 INT NOT NULL,
    Tuan12 INT NOT NULL,
    Tuan13 INT NOT NULL,
    Tuan14 INT NOT NULL,
    Tuan15 INT NOT NULL,
	PRIMARY KEY (MaSinhVien, MaLopHoc)
);

INSERT INTO GiaoVien
VALUES (312055, N'Cao Xuân Nam', '312055'), (312078, N'Hoàng Minh Châu', '312078'), (312079, N'Hoàng vũ Tuấn', '312079'), (312137, N'Lê Hoài Tâm', '312137'), (312143, N'Nguyễn Hoàng Anh', '312143');

INSERT INTO SinhVien
VALUES (1312426, N'Danh Hồng Phến', '1312426'), (1312423, N'Phan Tấn Phát', '1312423'), (1312399, N'Nguyễn Trọng Nhân', '1312399'), (1312398, N'Nguyễn Thành Nhân', '1312398'), (1312318, N'Bùi Hữu Lễ', '1312318');

INSERT INTO LopHoc
VALUES ('KHJAVA', 'J2EE', 'C1', '2017/01/11', '2017/11/02', '16:00', '17:00', 'Monday'),
('KHNET', '.NET 3.5', 'C42', '2017/10/05', '2017/11/06', '13:00', '17:00', 'Tuesday'),
('KHPHP', 'PHP', 'E305', '2017/03/01', '2017/04/02', '8:00', '12:00', 'Sunday');

INSERT INTO GiaoVien_LopHoc
VALUES (312055, 'KHJAVA'), (312055, 'KHNET'), (312078, 'KHJAVA'), (312078, 'KHPHP'), (312079, 'KHJAVA'), (312137, 'KHNET'), (312143, 'KHPHP');

INSERT INTO SinhVien_LopHoc
VALUES (1312426, 'KHJAVA', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), (1312426, 'KHNET', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), (1312426, 'KHPHP', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), (1312423, 'KHNET', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), (1312423, 'KHJAVA', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), (1312399, 'KHJAVA', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), (1312398, 'KHJAVA', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0), (1312318, 'KHPHP', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);


