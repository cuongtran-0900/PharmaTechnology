
create database QuanLyThuoc;

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
go

-- 2 t?o b?ng vai trò 
CREATE TABLE VaiTro (
    MaVT NVARCHAR(10) NOT NULL PRIMARY KEY,
    Ten NVARCHAR(255) NOT NULL,
)
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

-- 5t?o b?ng ??n v? tính 
CREATE TABLE DonViTinh (
    MaDVT NVARCHAR(10) NOT NULL PRIMARY KEY,
    tenDVT NVARCHAR(255) NOT NULL,
)
go

-- 6t?o b?ng xu?t x? 
CREATE TABLE XuatXu (
    MaXX NVARCHAR(10) NOT NULL PRIMARY KEY,
    TenXX NVARCHAR(255) NOT NULL,
)
go

-- 7t?o b?ng danh m?c 
CREATE TABLE DanhMuc (
    MaDM NVARCHAR(10) NOT NULL PRIMARY KEY,
    TenDM NVARCHAR(255) NOT NULL,
)
go
INSERT INTO DanhMuc (MaDM, tenDM)
VALUES
	('ZXC311QWE', N'Hệ tim mạch & tạo máu'),
	('ZXC321QWE', N'Hệ tiêu hóa & gan mật'),
	('ZAQ321QWE', N'Thuốc giảm đau');
go




-- 8 t?o b?ng thu?c 
CREATE TABLE Thuoc (
    MaThuoc NVARCHAR(10) NOT NULL PRIMARY KEY,
    TenThuoc NVARCHAR(255) NOT NULL,
    SoLuong NVARCHAR(50) NOT NULL,
    HinhAnh VARBINARY(MAX) NOT NULL,
    ThanhPhan NVARCHAR(255) NOT NULL,
	MaDVT NVARCHAR(10) NOT NULL FOREIGN KEY REFERENCES DonViTinh(MaDVT),
	MADM NVARCHAR(10) NOT NULL FOREIGN KEY REFERENCES DanhMuc(MaDM),
	MaXX NVARCHAR(10) NOT NULL FOREIGN KEY REFERENCES XuatXu(MaXX),
	MaLoai nvarchar(10) Not NUll FOREIGN KEY REFERENCES LoaiThuoc(MaLoai),
	SoLuongTon INT NOT NULL,
	giaNhap FLOAT NOT NULL,
	DonGia FLOAT NOT NULL,
	HanSuDung DATE NOT NULL,
)
go
INSERT INTO Thuoc(MaThuoc, tenThuoc,soLuong, hinhAnh, thanhPhan, MaDVT, MaDM, MaXX, soLuongTon, giaNhap, DonGia, hanSuDung)
VALUES
	('X12IFO4BZ', N'Hapacol 650 DHG',24, (SELECT BulkColumn FROM Openrowset(BULK 'D:\IUH\QuanLyThuocTay\src\product-image\hapacol_650_extra_dhg.png', SINGLE_BLOB) as image), N'Paracetamol', 'CVB123ERT', 'ZAQ321QWE', 'XCVSDF123', 1021, 20000, 25000, '2026-02-15'),
	('XRZXFO4BZ', N'Bột pha hỗn dịch uống Smecta vị cam',12, (SELECT BulkColumn FROM Openrowset(BULK 'D:\IUH\QuanLyThuocTay\src\product-image\bot-pha-hon-dich-uong-smecta.jpg', SINGLE_BLOB) as image), N'Diosmectite', 'CVB141ERT', 'ZXC321QWE', 'XCVSDF125', 1021, 3000, 4000, '2026-05-21'),
	('XRBIFO4BZ', N'Siro C.C Life 100mg/5ml Foripharm',30, (SELECT BulkColumn FROM Openrowset(BULK 'D:\IUH\QuanLyThuocTay\src\product-image\C.c-Life-100MgChai.jpg', SINGLE_BLOB) as image), N'Vitamin C', 'CV123GERT', 'ZXC321QWE', 'XCVSDF123', 1032, 25000, 30000, '2026-03-01'),
	('VFZCHLHIE', N'Panadol Extra đỏ',64, (SELECT BulkColumn FROM Openrowset(BULK 'D:\IUH\QuanLyThuocTay\src\product-image\Panadol-Extra.png', SINGLE_BLOB) as image), N'Caffeine, Paracetamol', 'CVB123ERT', 'ZAQ321QWE', 'XCVSDF122', 1034, 235000, 250000, '2026-08-07'),
	('MJ9AB7J1I', N'Viên sủi Vitatrum C BRV',9, (SELECT BulkColumn FROM Openrowset(BULK 'D:\IUH\QuanLyThuocTay\src\product-image\vitatrum-c-brv.png', SINGLE_BLOB) as image), N'Sỏi thận, Rối loạn chuyển hoá fructose, Bệnh Thalassemia, Tăng oxalat niệu, Rối loạn chuyển hoá oxalat', 'CVB123ERT', 'ZXC321QWE', 'XCVSDF122', 1076, 20000, 24000, '2027-12-31'),
	('ESMJMM7T1', N'Bổ Gan Trường Phúc',50, (SELECT BulkColumn FROM Openrowset(BULK 'D:\IUH\QuanLyThuocTay\src\product-image\bo-gan-tuong-phu.jpg', SINGLE_BLOB) as image), N'Diệp hạ châu, Đảng Sâm, Bạch truật, Cam thảo, Phục Linh, Nhân trần, Trần bì', 'CVB123ERT', 'ZXC321QWE', 'XCVSDF123', 1034, 85000, 95000, '2026-02-15'),
	('BV07519DS', N'Bài Thạch Trường Phúc',6, (SELECT BulkColumn FROM Openrowset(BULK 'D:\IUH\QuanLyThuocTay\src\product-image\bai-trang-truong-phuc.jpg', SINGLE_BLOB) as image), N'Xa tiền tử, Bạch mao căn, Sinh Địa, Ý Dĩ, Kim tiền thảo', 'CVB123ERT', 'ZXC321QWE', 'XCVSDF123', 1076, 85000, 95000, '2026-02-10'),
	('798E63U16', N'Đại Tràng Trường Phúc',32, (SELECT BulkColumn FROM Openrowset(BULK 'D:\IUH\QuanLyThuocTay\src\product-image\dai-trang-truong-phuc.jpg', SINGLE_BLOB) as image), N'Hoàng liên, Mộc hương, Bạch truật, Bạch thược, Ngũ bội tử, Hậu phác, Cam thảo, Xa tiền tử, Hoạt thạch', 'CVB123ERT', 'ZXC321QWE', 'XCVSDF123', 1021, 90, 105000, '2026-09-03'),
	('745KCI1KX', N'Ninh Tâm Vương Hồng Bàng',46, (SELECT BulkColumn FROM Openrowset(BULK 'D:\IUH\QuanLyThuocTay\src\product-image\ninh-tam-vuong-hong-bang.png', SINGLE_BLOB) as image), N'L-Carnitine, Taurine, Đan sâm, Khổ sâm bắc, Nattokinase, Hoàng đằng, Magie, Tá dược vừa đủ', 'CVB123ERT', 'ZXC311QWE', 'XCVSDF124', 1054, 165000, 180000, '2026-08-15');
go



--13 t?o b?ng nhà phân ph?i 
create table nhaPhanPhoi(
MaNPP nvarchar (10) primary key,
TenNPP Nvarchar (100) NOT NULL,
DienThoai varchar(13) NOT NULL,
DiaChi nvarchar (200)NOT NULL,
)

go
INSERT INTO nhaPhanPhoi (MaNPP, tenNPP, DienThoai, diaChi)
VALUES
  ('XCZXWE123', N'Công ty Cổ phần Dược phẩm An Khang', '0283820618', N'282-284 Trần Hưng Đạo, Phường Nguyễn Cư Trinh, Quận 1, TP.HCM'),
  ('23HUSZ173', N'Công ty Cổ phần Dược phẩm Pharmacity', '0243825353', N'426 Võ Văn Ngân, Phường Bình Thọ, Quận Thủ Đức, TP.HCM'),
  ('ZXHUWE12S', N'Hệ thống nhà thuốc ECO', '0283689339', N'336 Phan Văn Trị, Phường 11, Quận Bình Thạnh, TP.HCM'),
  ('N4M35KL1B', N'Công ty Dược phẩm Phano', '0243574133', N'286 P. Xã Đàn, Đống Đa, Hà Nội'),
  ('XCHUWE123', N'Công ty Dược phẩm Trung ương 2', '0243825535', '138B Đội Cấn, Ba Đình, Hà Nội'),
  ('2B32N31B2', N'Công ty Dược phẩm VCP', '0285413833', N'780 Đường Nguyễn Văn Linh, Phường Tân Phong, Quận 7, TP. Hồ Chí Minh');
go

-- 11 t?o b?ng  hóa ??n nh?p 
create table HoaDonNhap(
MaHDN nvarchar(10) primary key,
NgayNhap DateTime NOT NULL,
MaNPP nvarchar (10) NOT NULL,
TongTien float NOT NULL,
FOREIGN KEY (MaNV) REFERENCES NhanVien(MANV)
FOREIGN KEY (MaNPP) REFERENCES nhaPhanPhoi(MANPP)
)
go
INSERT INTO HoaDonNhap(MaHDN, ThoiGian, MaNV, MaNPP, tongTien)
VALUES
    ('PPJ9DNBL7', '2024-03-04 13:12:42', 'DKJFJO1K2', 'XCZXWE123', 10500000),
    ('RXPXRWR36', '2024-03-05 11:31:26', 'ADMIN', '23HUSZ173', 19800000),
    ('ZQKV59121', '2024-03-06 07:18:32', 'LKD2SFSL1', 'ZXHUWE12S', 6000000),
    ('C45PX5VYN', '2024-03-07 10:26:21', 'IU42JDKJ2', 'XCHUWE123', 77000000),
    ('A4B3VKX8V', '2024-03-11 08:35:37', 'IU42JDKJ2', 'XCHUWE123', 9500000);
go

-- 12 t?o b?ng chi ti?t hóa ??n nh?p 
CREATE TABLE chitiethoadonnhap (
	MaHDN NVARCHAR(10) NOT NULL,
    MaThuoc NVARCHAR(10) NOT NULL,
    soLuong INT NOT NULL,
	donGia FLOAT NOT NULL,
	CONSTRAINT MaCTPN PRIMARY KEY (MaHDN,MaThuoc),
	FOREIGN KEY(MaHDN) REFERENCES HoaDonNhap(MaHDN),
	FOREIGN KEY(MaThuoc) REFERENCES Thuoc(MaThuoc),
);
go
INSERT INTO ChiTietPhieuNhap(MaHDN, MaThuoc, soLuong, donGia)
VALUES
	('PPJ9DNBL7', '798E63U16', 100, 105000),
	('RXPXRWR36', '745KCI1KX', 110, 180000),
	('ZQKV59121', 'XRBIFO4BZ', 200, 30000),
	('C45PX5VYN', 'XRZXFO4BZ', 500, 4000),
	('C45PX5VYN', 'VFZCHLHIE', 300, 250000),
	('A4B3VKX8V', 'ESMJMM7T1', 100, 95000);
go

-- 15 t?o b?ng hóa ??n
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
INSERT INTO HoaDon (MaHD, thoiGian, MaNV, MaKH, tongTien)
VALUES
    ('V1DFWISZ0', '2024-04-01 14:21:13', 'DKJFJO1K2', 'ABCD12345', 105000),
    ('MNS6VLQ9F', '2024-04-02 16:12:51', 'ADMIN', 'XYZ98765Z', 180000),
    ('3P06S5KGG', '2024-04-03 08:31:31', 'LKD2SFSL1', 'KLM45678X', 90000),
    ('R4DDC67Q0', '2024-04-04 10:12:41', 'IU42JDKJ2', 'PQR23456V', 270000),
    ('SKUQJUB5Z', '2024-04-05 12:31:36', 'DKJFJO1K2', '789ABCDEF', 30000),
    ('F8BARB18Z', '2024-03-09 14:12:11', 'ADMIN', '456ZYXWVQ', 105000),
    ('8XBLQZV9B', '2024-03-10 16:03:43', 'LKD2SFSL1', 'QWE78901S', 345000),
    ('914KKABW3', '2024-03-11 08:07:32', 'IU42JDKJ2', 'ASDASN131', 95000),
    ('TJ6QM5STW', '2024-03-12 10:45:11', 'DKJFJO1K2', '12ZAS1SX1', 400000),
    ('B42SJZNIM', '2024-03-13 12:54:22', 'ADMIN', 'SDF3F13DZ', 30000),
    ('41C5TNFGE', '2024-02-14 14:14:30', 'LKD2SFSL1', 'ABCD12345', 280000),
    ('ME9CL5ER6', '2024-02-15 16:15:13', 'IU42JDKJ2', 'XYZ98765Z', 280000),
    ('WXOX8PE0Q', '2024-02-16 08:56:11', 'DKJFJO1K2', 'KLM45678X', 500000),
    ('63V7R8RBE', '2024-02-17 10:18:53', 'ADMIN', 'PQR23456V', 250000),
    ('1B78SGIZV', '2024-02-18 12:28:06', 'LKD2SFSL1', '789ABCDEF', 105000),
    ('VBA5E001G', '2024-02-19 14:38:28', 'IU42JDKJ2', '456ZYXWVQ', 200000),
    ('HAT7YG1MK', '2024-02-20 16:16:29', 'DKJFJO1K2', 'QWE78901S', 240000),
	('ASZS32JZX', '2024-02-21 16:16:29', 'DKJFJO1K2', N'12ZAS1SX1', 135000),
	('MNXS72JXA', '2024-02-22 16:16:29', 'IU42JDKJ2', N'ASDASN131', 465000);
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

-- select * from ChiTietHoaDon,chitiethoadonnhap,chitiethoadonxuat,DanhMuc,DonViTinh,HoaDon,hoadonnhap,HoaDonXuat,KhachHang,LoaiThuoc,NhanVien,nhaPhanPhoi,TaiKhoan,Thuoc,VaiTro,XuatXu;
