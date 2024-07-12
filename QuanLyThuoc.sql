
create database QuanLiThuoc;

Use QuanLiThuoc;
go

-- 1 t?o b?ng nhân viên 
create table NhanVien(
MaNV nvarchar(10) NOT NULL primary key,
Ten nvarchar (100) NOT NULL,
Tuoi nvarchar(20)NOT NULL,
SDT nvarchar (15)NOT NULL,
Email nvarchar (50)NOT NULL,
GioiTinh nvarchar(50)NOT NULL,
DiaChi nvarchar (255)NOT NULL,
TenVT NVARCHAR(255) NOT NULL,
Username NVARCHAR(255) NOT NULL,
Password NVARCHAR(255) NOT NULL,
)
go

-- 4 t?o b?ng khách hàng
CREATE TABLE KhachHang (
    MaKH NVARCHAR(10) NOT NULL PRIMARY KEY,
    TenKH NVARCHAR(255) NOT NULL,
	Tuoi Nvarchar(10)NOT NUll,
    sdt NVARCHAR(10) NOT NULL,
	Email nvarchar (50)NOT NULL,
    gioiTinh NVARCHAR(10) NOT NULL,
	DiaChi nvarchar (255)NOT NULL,
	ngayThamGia DATE NOT NULL,
    IsDelete Int NOT NULL,
)
go

INSERT INTO KhachHang (MaKH, TenKH, Tuoi, SDT, Email, GioiTinh, DiaChi, NgayThamGia,IsDelete) VALUES
('KH001', N'Lê Văn An', '35', '0123456788', 'Anln2112@gmail.com', N'Nam', N'Trung Mỹ Tây Quận 12 TP.HCM', '2023-01-01',1),
('KH002', N'Phạm Thị Duyên', '32', '0987654322', 'Duyen2422@gmail.com', N'Nữ', N'Gò vấp 322 Thành phố Hồ Chí Minh', '2023-02-01',1),
('KH003', N'Hoàng Kim Khánh ', '35', '0854372121', 'khanh2411@gmail.com', N'Nam', N'Bình thạnh thành phố HCM VN','2024-01-02',1),
('KH004', N'Ngô Hoàng Long', '20', '0212252417', 'Long2154@gmail.com', N'Nam', N'Bình thạnh thành phố HCM VN','2022-08-02',1),
('KH005', N'Nuyễn Xuân Hồng', '27', '0387521756', 'Hong2777@gmail.com', N'Nu', N'Quận 2 thành phố Hồ Chí Minh','2023-05-20',1),
('KH006', N'Phạm Xuân Phong', '25', '0285431252', 'Phong2541@gmail.com', N'Nam', N'Bình thạnh thành phố HCM VN','2023-06-18',1),
('KH007', N'Lê Thị Linh', '27', '0123456789', 'Linh2217@gmail.com', N'Nữ', N'gò vấp thành phố hồ chí minh ','2023-08-10',1),
('KH008', N'Phạm Thị Anh', '18', '052173241', 'Anh2006@gmail.com', N'Nữ', N'Quận 12 thành phố hồ chí minh ','2023-05-25',1),
('KH009', N'Hoàng Hữu Đức', '28', '0987654321', 'Duc1999@gmail.com', N'Nam', N'Quận 8 thành phố hồ chí minh ','2021-08-25',1),
('KH010', N'Nguyễn Văn Hùng', '29', '0369258741', 'Hung1777@gmail.com', N'Nam', N'Quận 7 thành phố hồ chí minh ','2021-08-25',1);
-- 5t?o b?ng ??n v? tính 
CREATE TABLE DonViTinh (
    MaDVT NVARCHAR(10) NOT NULL PRIMARY KEY,
    tenDVT NVARCHAR(255) NOT NULL,
)
go
INSERT INTO DonViTinh (MaDVT, tenDVT) 
VALUES
	('CVBDF123T', N'Viên'),
	('CV123GERT', N'Chai'),
	('CVB123ERT', N'Hộp'),
	('CVB141ERT', N'Gói'),
	('CV1223ERT', N'Vỉ');
go
-- 6t?o b?ng xu?t x? 
CREATE TABLE XuatXu (
    MaXX NVARCHAR(10) NOT NULL PRIMARY KEY,
    TenXX NVARCHAR(255) NOT NULL,
)
go

INSERT INTO XuatXu (MaXX, TenXX)
VALUES
	('XCVSDF123', N'Việt Nam'),
	('XCVSDF122', N'Mỹ'),
	('XCVSDF125', N'Pháp'),
	('XCVSDF124', N'Nhật Bản');
go

-- 7t?o b?ng danh m?c 
CREATE TABLE DanhMuc (
    MaDM NVARCHAR(10) NOT NULL PRIMARY KEY,
    TenDM NVARCHAR(255) NOT NULL,
)
go

-- 14t?o b?ng lo?i thu?c 
-- create table LoaiThuoc
-- (
-- MaLoai nvarchar(10) primary key,
-- TenLoai Nvarchar(100),
-- GhiChu Nvarchar(100)
-- )
-- go

-- 8 t?o b?ng thu?c 
CREATE TABLE Thuoc (
    MaThuoc NVARCHAR(10) NOT NULL PRIMARY KEY,
    TenThuoc NVARCHAR(255) NOT NULL,
    HinhAnh VARBINARY(MAX),
    ThanhPhan NVARCHAR(255),
    SoLuong NVARCHAR(50),
	MaDVT NVARCHAR(10) NOT NULL FOREIGN KEY REFERENCES DonViTinh(MaDVT),
	MADM NVARCHAR(10) NOT NULL FOREIGN KEY REFERENCES DanhMuc(MaDM),
	MaXX NVARCHAR(10) NOT NULL FOREIGN KEY REFERENCES XuatXu(MaXX),
	SoLuongTon INT NOT NULL,
	giaNhap FLOAT NOT NULL,
	DonGia FLOAT NOT NULL,
	HanSuDung DATE NOT NULL,
    IsDelete Int NOT NULL,
)
go

--9 t?o b?ng hóa ??n xu?
-- CREATE TABLE HoaDonXuat (
--     MaHDX NVARCHAR(10) NOT NULL PRIMARY KEY,
--     NgayThang DATE NOT NULL,
-- 	tongTien FLOAT NOT NULL,
--     MaNV nvarchar(10) NOT NULL FOREIGN KEY REFERENCES NhanVien(MaNV),	
-- )
-- go

--13 t?o b?ng nhà phân ph?i 
create table nhaPhanPhoi
(
MaNPP nvarchar (10) primary key,
TenNPP Nvarchar (100),
DiaChi nvarchar (200),
DienThoai varchar(13),
Email nvarchar(50),
)
go

-- 10 t?o b?ng chi ti?t hóa ??n xu?t 
-- create table chitiethoadonxuat
-- (
-- MaCTHDX nvarchar(10)primary key,
-- MaHDX  nvarchar (10),
-- Mathuoc nvarchar(10),
-- soluong nvarchar (500),
-- giaban float,
-- FOREIGN KEY (MaHDX) REFERENCES Hoadonxuat(MaHDX),
-- FOREIGN KEY (MAthuoc) REFERENCES Thuoc(Mathuoc),
-- )
-- go

-- 11 t?o b?ng  hóa ??n nh?p 
create table hoadonnhap
(
maHDN nvarchar(10) primary key,
MaNPP nvarchar (10),
NguoiGiao nvarchar (50),
NguoiNhan nvarchar (50),
NgayViet DateTime,
NgayNhap DateTime,
TongTien float,
FOREIGN KEY (MaNPP) REFERENCES nhaPhanPhoi(MANPP)
)
go

-- 12 t?o b?ng chi ti?t hóa ??n nh?p 
create table chitiethoadonnhap
(
MaCTHDN nvarchar(10) primary key,
MaHDN nvarchar (10),
MaThuoc nvarchar(10),
Soluong int,
GiaNhap float,
FOREIGN KEY (MaHDN) REFERENCES hoadonnhap(MAHDN),
FOREIGN KEY (Mathuoc) REFERENCES thuoc(MAthuoc)
)
go



-- 12 t?o b?ng hóa ??n
CREATE TABLE HoaDon (
    MaHD NVARCHAR(10) NOT NULL PRIMARY KEY,
    thoiGian DATETIME NOT NULL,
    MaNV NVARCHAR(10) NOT NULL,
    MaKH NVARCHAR(10) NOT NULL,
	tongTien FLOAT NOT NULL,
    IsDelete Int NOT NULL,
    FOREIGN KEY (MaNV) REFERENCES NhanVien(MaNV),
    FOREIGN KEY (MAKH) REFERENCES KhachHang(MaKH)
)
go

-- 16 t?o b?ng chi ti?t hóa ??n
CREATE TABLE ChiTietHoaDon (
    MaHD NVARCHAR(10) NOT NULL,
    MaThuoc NVARCHAR(10) NOT NULL,
    soLuong INT NOT NULL,
	donGia FLOAT NOT NULL,
	CONSTRAINT MaCTHD PRIMARY KEY (MaHD,MaThuoc),
	FOREIGN KEY(maHD) REFERENCES HoaDon(MaHD),
	FOREIGN KEY(MaThuoc) REFERENCES Thuoc(MAThuoc),
)
go


-- Insert data into NhanVien table
INSERT INTO NhanVien (MaNV, Ten, Tuoi, SDT, Email, GioiTinh, DiaChi) VALUES
('NV001', 'Nguyen Van A', '30', '0123456789', 'a@gmail.com', 'Nam', '123 ABC St.'),
('NV002', 'Tran Thi B', '28', '0987654321', 'b@gmail.com', 'Nu', '456 DEF St.');

-- Insert data into VaiTro table
INSERT INTO VaiTro (MaVT, Ten) VALUES
('VT001', 'Admin'),
('VT002', 'NhanVien');

-- Insert data into TaiKhoan table
INSERT INTO TaiKhoan (MaTK, Username, Password, MaNV, MaVT) VALUES
('TK001', 'admin', 'adminpass', 'NV001', 'VT001'),
('TK002', 'user1', 'user1pass', 'NV002', 'VT002');

-- Insert data into KhachHang table
INSERT INTO KhachHang (MaKH, TenKH, Tuoi, SDT, Email, GioiTinh, DiaChi, NgayThamGia) VALUES
('KH001', 'Le Van C', '35', '0123456788', 'c@gmail.com', 'Nam', '789 GHI St.', '2023-01-01'),
('KH002', 'Pham Thi D', '32', '0987654322', 'd@gmail.com', 'Nu', '101 JKL St.', '2023-02-01');

-- Insert data into DonViTinh table
INSERT INTO DonViTinh (MaDVT, TenDVT) VALUES
('DVT001', 'Hop'),
('DVT002', 'Vien');

-- Insert data into XuatXu table
INSERT INTO XuatXu (MaXX, TenXX) VALUES
('XX001', 'Viet Nam'),
('XX002', 'USA');

-- Insert data into DanhMuc table
INSERT INTO DanhMuc (MaDM, TenDM) VALUES
('DM001', 'Thuoc Bo'),
('DM002', 'Thuoc Giam Dau');

-- Insert data into LoaiThuoc table
INSERT INTO LoaiThuoc (MaLoai, TenLoai, GhiChu) VALUES
('LT001', 'Thuoc Khang Sinh', 'Khang sinh'),
('LT002', 'Thuoc Chua Benh', 'Chua benh');

-- Insert data into Thuoc table
INSERT INTO Thuoc (MaThuoc, TenThuoc, HinhAnh, ThanhPhan, SoLuong, MaDVT, MaDM, MaXX, MaLoai, SoLuongTon, GiaNhap, DonGia, HanSuDung) VALUES
('T001', 'Paracetamol', NULL, 'Acetaminophen', '100', 'DVT002', 'DM002', 'XX001', 'LT002', 100, 10000, 12000, '2024-12-31'),
('T002', 'Amoxicillin', NULL, 'Amoxicillin', '200', 'DVT002', 'DM001', 'XX002', 'LT001', 200, 15000, 18000, '2024-12-31');

-- Insert data into HoaDonXuat table
INSERT INTO HoaDonXuat (MaHDX, NgayThang, TongTien, MaNV) VALUES
('HDX001', '2023-03-01', 24000, 'NV002'),
('HDX002', '2023-03-02', 36000, 'NV002');

-- Insert data into NhaPhanPhoi table
INSERT INTO NhaPhanPhoi (MaNPP, TenNPP, DiaChi, DienThoai, Email) VALUES
('NPP001', 'Cong ty ABC', '123 ABC St.', '0123456789', 'abc@gmail.com'),
('NPP002', 'Cong ty DEF', '456 DEF St.', '0987654321', 'def@gmail.com');

-- Insert data into ChiTietHoaDonXuat table
INSERT INTO ChiTietHoaDonXuat (MaCTHDX, MaHDX, MaThuoc, SoLuong, GiaBan) VALUES
('CTHDX001', 'HDX001', 'T001', '2', 12000),
('CTHDX002', 'HDX002', 'T002', '2', 18000);

-- Insert data into HoaDonNhap table
INSERT INTO HoaDonNhap (MaHDN, MaNPP, NguoiGiao, NguoiNhan, NgayViet, NgayNhap, TongTien) VALUES
('HDN001', 'NPP001', 'Nguyen Van E', 'Nguyen Van A', '2023-03-01', '2023-03-02', 20000),
('HDN002', 'NPP002', 'Tran Thi F', 'Tran Thi B', '2023-03-03', '2023-03-04', 30000);

-- Insert data into ChiTietHoaDonNhap table
INSERT INTO ChiTietHoaDonNhap (MaCTHDN, MaHDN, MaThuoc, SoLuong, GiaNhap) VALUES
('CTHDN001', 'HDN001', 'T001', 100, 10000),
('CTHDN002', 'HDN002', 'T002', 150, 15000);

-- Insert data into HoaDon table
INSERT INTO HoaDon (MaHD, ThoiGian, MaNV, MaKH, TongTien) VALUES
('HD001', '2023-03-05 10:00:00', 'NV001', 'KH001', 24000),
('HD002', '2023-03-06 11:00:00', 'NV002', 'KH002', 36000);

-- Insert data into ChiTietHoaDon table
INSERT INTO ChiTietHoaDon (MaHD, MaThuoc, SoLuong, DonGia) VALUES
('HD001', 'T001', 2, 12000),
('HD002', 'T002', 2, 18000);
GO


select * from ChiTietHoaDon,chitiethoadonnhap,chitiethoadonxuat,DanhMuc,DonViTinh,HoaDon,hoadonnhap,HoaDonXuat,KhachHang,LoaiThuoc,NhanVien,nhaPhanPhoi,TaiKhoan,Thuoc,VaiTro,XuatXu;
