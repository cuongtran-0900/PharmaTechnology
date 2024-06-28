create table DanhMuc 
(
MaDM Nvarchar,
TenDM nvarchar
);

create table Thuoc
(
MaThuoc nvarchar,
TenThuoc nvarchar,
HinhAnh nvarchar,
SoLuongMua int,
DonViTinh nvarchar,
ThanhPhan nvarchar,
GiaNhap float,
DonGiaBanRa float,
TonKho int,
NhaPhanPhoi nvarchar,
XuatXu nvarchar,
HanSuDung date
);

create table LoaiThuoc
(
MaLT nvarchar,
TenLT nvarchar,
GhiChu nvarchar
);

-- SQL Thang
CREATE TABLE NhaPhanPhoi (
	MaNPP NVARCHAR(50) PRIMARY KEY,
    Ten NVARCHAR(50) NOT NULL,
    DiaChi NVARCHAR(50) NOT NULL,
    Email NVARCHAR(50) NOT NULL,
    SDT NVARCHAR(10) NOT NULL
);

CREATE TABLE HoaDon (
    MaHD NVARCHAR(50) PRIMARY KEY,
    SoLuong INT NOT NULL,
    ThanhTien FLOAT NOT NULL,
    NgayThang DATETIME NOT NULL,
    MaNV NVARCHAR(50) NOT NULL,
    MaKH NVARCHAR(50) NOT NULL
);