
Use QuanLyThuoc;
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
)

-- Insert data into NhanVien table
INSERT INTO NhanVien (MaNV, Ten, Tuoi, SDT, Email, GioiTinh, DiaChi) VALUES
('NV001',  N'Nguyễn Phan Anh Tuấn', '30', '0906765871', 'Tuan2454@gmail.com', N'Nam', N'Gò Vấp thành Phố Hồ Chí Minh'),
('NV002',  N'Vũ Nương', '28', '0931265687', 'Vunuong255@gmail.com',N'Nữ', 'Quận 4 thành phố Hồ Chí Minh ');
go

-- 2 t?o b?ng vai trò 
CREATE TABLE VaiTro (
    MaVT NVARCHAR(10) NOT NULL PRIMARY KEY,
    Ten NVARCHAR(255) NOT NULL,
)
go

INSERT INTO VaiTro (MaVT, Ten)
VALUES
	('admin', N'Admin'),
    ('nvql', N'Nhân viên ')
go


-- 3 t?o b?ng tài kho?n 
CREATE TABLE TaiKhoan (
	MaTK NVARCHAR(10) NOT NULL PRIMARY KEY,
    Username NVARCHAR(255) NOT NULL,
    password NVARCHAR(255) NOT NULL,
    MaNV NVARCHAR(10) NOT NULL FOREIGN KEY REFERENCES NhanVien(MaNV),
	MaVT NVARCHAR(10) NOT NULL FOREIGN KEY REFERENCES VaiTro(MaVT),
)
go

INSERT INTO TaiKhoan (MaTK, Username, Password, MaNV, MaVT) VALUES
('TK001', 'admin', '123123', 'ADMIN', 'admin'),
('TK002', 'nhanvien', '123456', 'NHANVIEN', 'nhanvien');

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
)
go

INSERT INTO KhachHang (MaKH, TenKH, Tuoi, SDT, Email, GioiTinh, DiaChi, NgayThamGia) VALUES
('KH001', N'Lê Văn An', '35', '0123456788', 'Anln2112@gmail.com', N'Nam', N'Trung Mỹ Tây Quận 12 TP.HCM', '2023-01-01'),
('KH002', N'Phạm Thị Duyên', '32', '0987654322', 'Duyen2422@gmail.com', N'Nữ', N'Gò vấp 322 Thành phố Hồ Chí Minh', '2023-02-01'),
('KH003', N'Hoàng Kim Khánh ', '35', '0854372121', 'khanh2411@gmail.com', N'Nam', N'Bình thạnh thành phố HCM VN','2024-01-02'),
('KH004', N'Ngô Hoàng Long', '20', '0212252417', 'Long2154@gmail.com', N'Nam', N'Bình thạnh thành phố HCM VN','2022-08-02'),
('KH005', N'Nuyễn Xuân Hồng', '27', '0387521756', 'Hong2777@gmail.com', N'Nu', N'Quận 2 thành phố Hồ Chí Minh','2023-05-20'),
('KH006', N'Phạm Xuân Phong', '25', '0285431252', 'Phong2541@gmail.com', N'Nam', 'Bình thạnh thành phố HCM VN','2023-06-18'),
('KH007', N'Lê Thị Linh', '27', '01234567891', 'Linh2217@gmail.com', N'Nữ', 'gò vấp thành phố hồ chí minh ','2023-08-10'),
('KH008', N'Phạm Thị Anh', '18', '052173241', 'Anh2006@gmail.com', N'Nữ', 'Quận 12 thành phố hồ chí minh ','2023-05-25'),
('KH009', N'Hoàng Hữu Đức', '28', '0987654321', 'Duc1999@gmail.com', N'Nam', 'Quận 8 thành phố hồ chí minh ','2021-08-25'),
('KH010', N'Nguyễn Văn Hùng', '29', '0369258741', 'Hung1777@gmail.com', N'Nam', 'Quận 7 thành phố hồ chí minh ','2021-08-25')
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

INSERT INTO DanhMuc (MaDM, TenDM)
VALUES
	('ZXC311QWE', N'Hệ tim mạch & tạo máu'),
	('ZXC321QWE', N'Hệ tiêu hóa & gan mật'),
	('ZAQ321QWE', N'Thuốc giảm đau');
go

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
)
go



--9 t?o b?ng nhà phân ph?i 
create table nhaPhanPhoi
(
MaNPP nvarchar (10) primary key,
TenNPP Nvarchar (100),
DiaChi nvarchar (200),
DienThoai varchar(13),
Email nvarchar(50),
)
go

-- 10 t?o b?ng  hóa ??n nh?p 
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

-- 11 t?o b?ng chi ti?t hóa ??n nh?p 
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
    FOREIGN KEY (MaNV) REFERENCES NhanVien(MaNV),
    FOREIGN KEY (MAKH) REFERENCES KhachHang(MaKH)
)
go

-- 13 t?o b?ng chi ti?t hóa ??n
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
