

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
Roll NVARCHAR(255) NOT NULL,
Username NVARCHAR(255) NOT NULL,
Password NVARCHAR(255) NOT NULL,
IsDelete Int NOT NULL,
)

-- Insert data into NhanVien table
INSERT INTO NhanVien (MaNV, Ten, Tuoi, SDT, Email, GioiTinh, DiaChi,TenVT,Username,Password,IsDelete  ) VALUES
('nv001',  N'Nguyễn Phan Anh Tuấn', '30', '0906765871', 'Tuan2454@gmail.com', N'Nam', N'Gò Vấp thành Phố Hồ Chí Minh', N'Admin', 'admin', '123123',1),
('nv002',  N'Vũ Nương', '28', '0931265687', 'Vunuong255@gmail.com',N'Nữ', 'Quận 4 thành phố Hồ Chí Minh ', N'Nhân viên ', 'nhanvien', '123456',1);
go

-- 2 t?o b?ng khách hàng
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

-- 3 t?o b?ng thu?c 
CREATE TABLE Thuoc (
    MaThuoc NVARCHAR(10) NOT NULL PRIMARY KEY,
    TenThuoc NVARCHAR(255) NOT NULL,
    SoLuong NVARCHAR(50),
    HinhAnh nvarchar(50) not null,
    ThanhPhan NVARCHAR(255),
	SoLuongTon INT NOT NULL,
	giaNhap FLOAT NOT NULL,
	DonGia FLOAT NOT NULL,
	NgaySanXuat Date Not NUll,
	HanSuDung DATE NOT NULL,
	DonViTinh NVARCHAR(50),
	LoaiThuoc NVARCHAR(50),
	XuatXu NVARCHAR(50) ,
    IsDelete Int NOT NULL,
)
go

INSERT INTO Thuoc(MaThuoc, TenThuoc, SoLuong, HinhAnh, ThanhPhan, SoLuongTon, giaNhap, DonGia, NgaySanXuat, HanSuDung, DonViTinh, LoaiThuoc, XuatXu, IsDelete)
VALUES
    ('X12IFO4BZ', N'Hapacol 650 DHG', 24, 'thuocHapacol.png', N'Paracetamol', 1021, 20000, 25000, '2024-02-15', '2026-02-15', N'Viên', N'Hệ tim mạch & tạo máu', N'Việt Nam', 1),
    ('XRZXFO4BZ', N'Bột pha hỗn dịch uống Smecta vị cam', 12, 'botphatieuchay.jpg', N'Diosmectite', 1021, 3000, 4000, '2024-05-21', '2026-05-21', N'Gói', N'Tiêu hóa', N'Pháp', 1),
    ('XRBIFO4BZ', N'Siro C.C Life 100mg/5ml Foripharm', 30, 'sirocam.jpg', N'Vitamin C', 1032, 25000, 30000, '2024-03-01', '2026-03-01', N'Chai', N'Tăng cường sức đề kháng', N'Việt Nam', 1),
    ('VFZCHLHIE', N'Panadol Extra đỏ', 64, 'Panadol-Extra.png', N'Caffeine, Paracetamol', 1034, 235000, 250000, '2024-08-07', '2026-08-07', N'Viên', N'Giảm đau, hạ sốt', N'Anh', 1),
    ('MJ9AB7J1I', N'Viên sủi Vitatrum C BRV', 9, 'vitaminc.png', N'Vitamin C', 1076, 20000, 24000, '2024-12-31', '2027-12-31', N'Viên sủi', N'Tăng cường sức đề kháng', N'Việt Nam', 1),
    ('ESMJMM7T1', N'Bổ Gan Trường Phúc', 50, 'Bogantruongphu.jpg', N'Diệp hạ châu, Đảng Sâm, Bạch truật, Cam thảo, Phục Linh, Nhân trần, Trần bì', 1034, 85000, 95000, '2024-02-15', '2026-02-15', N'Viên', N'Bổ gan', N'Việt Nam', 1),
    ('BV07519DS', N'Bài Thạch Trường Phúc', 6, 'bothantruongphuc.jpg', N'Xa tiền tử, Bạch mao căn, Sinh Địa, Ý Dĩ, Kim tiền thảo', 1076, 85000, 95000, '2024-02-10', '2026-02-10', N'Viên', N'Thận', N'Việt Nam', 1),
    ('798E63U16', N'Đại Tràng Trường Phúc', 32, 'Daitrangtruongphuc.jpg', N'Hoàng liên, Mộc hương, Bạch truật, Bạch thược, Ngũ bội tử, Hậu phác, Cam thảo, Xa tiền tử, Hoạt thạch', 1021, 90000, 105000, '2024-09-03', '2026-09-03', N'Viên', N'Đại tràng', N'Việt Nam', 1),
    ('745KCI1KX', N'Ninh Tâm Vương Hồng Bàng', 46, 'Ninhtamvuong.png', N'L-Carnitine, Taurine, Đan sâm, Khổ sâm bắc, Nattokinase, Hoàng đằng, Magie, Tá dược vừa đủ', 1054, 165000, 180000, '2024-08-15', '2026-08-15', N'Viên', N'Tim mạch', N'Việt Nam', 1);
GO
--4t?o b?ng nhà phân ph?i 
create table nhaPhanPhoi
(
MaNPP nvarchar (10) primary key,
TenNPP Nvarchar (100),
DienThoai varchar(13),
DiaChi nvarchar (200),
Email nvarchar(50),
IsDelete Int NOT NULL,
)
go

INSERT INTO nhaPhanPhoi (MaNPP, tenNPP, DienThoai, diaChi,Email,IsDelete )
VALUES
  ('XCZXWE123', N'Công ty Cổ phần Dược phẩm An Khang', '0283820618', N'282-284 Trần Hưng Đạo, Phường Nguyễn Cư Trinh, Quận 1, TP.HCM','nhathuocankhang@gmail.com',1),
  ('23HUSZ173', N'Công ty Cổ phần Dược phẩm Pharmacity', '0243825353', N'426 Võ Văn Ngân, Phường Bình Thọ, Quận Thủ Đức, TP.HCM','cskh@pharmacity.vn',1),
  ('ZXHUWE12S', N'Hệ thống nhà thuốc ECO', '0283689339', N'336 Phan Văn Trị, Phường 11, Quận Bình Thạnh, TP.HCM','eco@ecopharma.com.vn',1),
  ('N4M35KL1B', N'Công ty Dược phẩm Phano', '0243574133', N'286 P. Xã Đàn, Đống Đa, Hà Nội','contact@phanopharmacy.com',1),
  ('XCHUWE123', N'Công ty Dược phẩm Trung ương 2', '0243825535', '138B Đội Cấn, Ba Đình, Hà Nội','	info@phytopharma.vn',1),
  ('2B32N31B2', N'Công ty Dược phẩm VCP', '0285413833', N'780 Đường Nguyễn Văn Linh, Phường Tân Phong, Quận 7, TP. Hồ Chí Minh','sale.online@vcp.com.vn',1);
go



-- 5 t?o b?ng  hóa ??n nh?p 
create table hoadonnhap
(
maHDN nvarchar(10) primary key,
MaNPP nvarchar (10),
NguoiGiao nvarchar (50),
NguoiNhan nvarchar (50),
NgayViet DateTime,
NgayNhap DateTime,
TongTien float,
IsDelete Int NOT NULL,
FOREIGN KEY (MaNPP) REFERENCES nhaPhanPhoi(MANPP)
)
go


INSERT INTO HoaDonNhap (MaHDN, MaNPP, NguoiGiao, NguoiNhan, NgayViet, NgayNhap, TongTien,IsDelete )
VALUES
    ('PPJ9DNBL7', 'XCZXWE123', N'Nguyễn văn Trường', N'Trần thị Kim', '2024-03-04 10:00:00', '2024-03-04 13:12:42', 10500000,1),
    ('RXPXRWR36', '23HUSZ173', N'Bùi Văn Nam', 'Phạm Thị Dương', '2024-03-05 09:00:00', '2024-03-05 11:31:26', 19800000,1),
    ('ZQKV59121', 'ZXHUWE12S', N'Hoàng Văn Tùng', N'Nguyễn Thị Thảo', '2024-03-06 06:00:00', '2024-03-06 07:18:32', 6000000,1),
    ('C45PX5VYN', 'XCHUWE123', N'Hoàng Trung Khánh ', N'Trần Văn Hùng', '2024-03-07 08:00:00', '2024-03-07 10:26:21', 77000000,1),
    ('A4B3VKX8V', 'XCHUWE123', N'Mai Thành Vũ ', N'Phạm Kim Hồng', '2024-03-11 07:00:00', '2024-03-11 08:35:37', 9500000,1);
GO

-- 6 t?o b?ng chi ti?t hóa ??n nh?p 
create table chitiethoadonnhap
(
MaHDN nvarchar (10),
MaThuoc nvarchar(10),
Soluong int,
GiaNhap float,
CONSTRAINT MaCTHDN PRIMARY KEY (MaHDN,MaThuoc),
FOREIGN KEY (MaHDN) REFERENCES hoadonnhap(MAHDN),
FOREIGN KEY (Mathuoc) REFERENCES thuoc(MAthuoc)
)
go

INSERT INTO chitiethoadonnhap(MaHDN, MaThuoc, soLuong, GiaNhap)
VALUES
	('PPJ9DNBL7', '798E63U16', 100, 105000),
	('RXPXRWR36', '745KCI1KX', 110, 180000),
	('ZQKV59121', 'XRBIFO4BZ', 200, 30000),
	('C45PX5VYN', 'XRZXFO4BZ', 500, 4000),
	('C45PX5VYN', 'VFZCHLHIE', 300, 250000),
	('A4B3VKX8V', 'ESMJMM7T1', 100, 95000);
go



-- 7 t?o b?ng hóa ??n
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

INSERT INTO HoaDon (MaHD, thoiGian, MaNV, MaKH, tongTien,IsDelete )
VALUES
    ('V1DFWISZ0', '2024-04-01 14:21:13', 'nv001', 'KH001', 105000,1),
    ('MNS6VLQ9F', '2024-04-02 16:12:51', 'nv002', 'KH002', 180000,1),
    ('3P06S5KGG', '2024-04-03 08:31:31', 'nv001', 'KH003', 90000,1),
    ('R4DDC67Q0', '2024-04-04 10:12:41', 'nv002', 'KH004', 270000,1),
    ('SKUQJUB5Z', '2024-04-05 12:31:36', 'nv001', 'KH005', 30000,1),
    ('F8BARB18Z', '2024-03-09 14:12:11', 'nv002', 'KH006', 105000,1),
    ('8XBLQZV9B', '2024-03-10 16:03:43', 'nv002', 'KH007', 345000,1),
    ('914KKABW3', '2024-03-11 08:07:32', 'nv002', 'KH008', 95000,1),
    ('TJ6QM5STW', '2024-03-12 10:45:11', 'nv002', 'KH009', 400000,1),
    ('B42SJZNIM', '2024-03-13 12:54:22', 'nv002', 'KH010', 30000,1),
    ('41C5TNFGE', '2024-02-14 14:14:30', 'nv002', 'KH005', 280000,1),
    ('ME9CL5ER6', '2024-02-15 16:15:13', 'nv002', 'KH006', 280000,1),
    ('WXOX8PE0Q', '2024-02-16 08:56:11', 'nv002', 'KH007', 500000,1),
    ('63V7R8RBE', '2024-02-17 10:18:53', 'nv001', 'KH002', 250000,1),
    ('1B78SGIZV', '2024-02-18 12:28:06', 'nv002', 'KH008', 105000,1),
    ('VBA5E001G', '2024-02-19 14:38:28', 'nv002', 'KH006', 200000,1),
    ('HAT7YG1MK', '2024-02-20 16:16:29', 'nv002', 'KH005', 240000,1),
	('ASZS32JZX', '2024-02-21 16:16:29', 'nv002', N'KH004', 135000,1),
	('MNXS72JXA', '2024-02-22 16:16:29', 'nv002', N'KH005', 465000,1);
go



-- 8 t?o b?ng chi ti?t hóa ??n
CREATE TABLE ChiTietHoaDon (
    MaHD NVARCHAR(10) NOT NULL,
    MaThuoc NVARCHAR(10) NOT NULL,
    SoLuong INT NOT NULL,
    DonGia FLOAT NOT NULL,
    CONSTRAINT MaCTHD PRIMARY KEY (MaHD, MaThuoc),
    FOREIGN KEY (MaHD) REFERENCES HoaDon(MaHD),
    FOREIGN KEY (MaThuoc) REFERENCES Thuoc(MaThuoc)
);
GO
INSERT INTO ChiTietHoaDon(MaHD, MaThuoc, soLuong, donGia)
VALUES
	('V1DFWISZ0', '798E63U16', 1, 105000),
	('MNS6VLQ9F', '745KCI1KX', 1, 180000),
	('3P06S5KGG', 'XRBIFO4BZ', 3, 30000),
	('R4DDC67Q0', 'XRZXFO4BZ', 5, 4000),
	('R4DDC67Q0', 'VFZCHLHIE', 1, 250000),
	('SKUQJUB5Z', 'XRBIFO4BZ', 1, 30000),
	('F8BARB18Z', '798E63U16', 1, 105000),
	('8XBLQZV9B', 'ESMJMM7T1', 1, 95000),
	('8XBLQZV9B', 'VFZCHLHIE', 1, 250000),
	('914KKABW3', 'ESMJMM7T1', 1, 95000),
	('TJ6QM5STW', 'XRBIFO4BZ', 1, 30000),
	('TJ6QM5STW', 'VFZCHLHIE', 1, 250000),
	('TJ6QM5STW', 'X12IFO4BZ', 1, 120000),
	('B42SJZNIM', 'XRBIFO4BZ', 1, 30000),
	('41C5TNFGE', 'XRBIFO4BZ', 1, 30000),
	('41C5TNFGE', 'VFZCHLHIE', 1, 250000),
	('ME9CL5ER6', 'XRBIFO4BZ', 1, 30000),
	('ME9CL5ER6', 'VFZCHLHIE', 1, 250000),
	('WXOX8PE0Q', 'VFZCHLHIE', 2, 250000),
	('63V7R8RBE', 'VFZCHLHIE', 1, 250000),
	('1B78SGIZV', '798E63U16', 1, 105000),
	('VBA5E001G', '798E63U16', 1, 105000),
	('VBA5E001G', 'ESMJMM7T1', 1, 95000),
	('HAT7YG1MK', 'X12IFO4BZ', 2, 120000),
	('ASZS32JZX', 'X12IFO4BZ', 3, 25000),
	('ASZS32JZX', 'XRZXFO4BZ', 2, 30000),
	('MNXS72JXA', 'ESMJMM7T1', 2, 95000),
	('MNXS72JXA', 'VFZCHLHIE', 1, 250000),
	('MNXS72JXA', 'X12IFO4BZ', 1, 25000);
go
-- 1. Procedure: Lấy thông tin nhân viên theo mã nhân viên
CREATE PROCEDURE laythongtinNhanVien
    @MaNV NVARCHAR(10)
AS
BEGIN
    SELECT * 
    FROM NhanVien 
    WHERE MaNV = @MaNV;
END;
GO
-- 2. Procedure: Lấy thông tin thuốc theo mã thuốc

CREATE PROCEDURE Laythongtinthuoc
    @MaThuoc NVARCHAR(10)
AS
BEGIN
    SELECT * 
    FROM Thuoc 
    WHERE MaThuoc = @MaThuoc;
END;
GO
--3. Procedure: Lấy thông tin hóa đơn theo mã hóa đơn
CREATE PROCEDURE LaythongtinHoaDon
    @MaHD NVARCHAR(10)
AS
BEGIN
    SELECT * 
    FROM HoaDon 
    WHERE MaHD = @MaHD;
END;
GO
-- 4. Procedure: Lấy danh sách khách hàng tham gia trong một khoảng thời gian
CREATE PROCEDURE KhachhangThamgia
    @StartDate DATE,
    @EndDate DATE
AS
BEGIN
    SELECT * 
    FROM KhachHang 
    WHERE NgayThamGia BETWEEN @StartDate AND @EndDate;
END;
GO
-- 5. Procedure: Lấy thông tin hóa đơn nhập theo mã nhà phân phối
CREATE PROCEDURE thongtinhoadonnhap
    @MaNPP NVARCHAR(10)
AS
BEGIN
    SELECT * 
    FROM HoaDonNhap 
    WHERE MaNPP = @MaNPP;
END;
GO