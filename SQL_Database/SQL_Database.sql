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

-- SQL TU
create table taikhoan(
MaTK int primary key ,
username nvarchar(50) not null,
password nvarchar(50) not null,
MaNV int ,
MaVT int
);

create table khachhang(
MaKH int primary key ,
TenKH nvarchar(50) not null,
Tuoi int not null,
SDT int ,
Email nvarchar(55),
Gioitinh bit ,
Diachi nvarchar(200),
ngaythamgia date
);


create table NhanVien (
manhanvien nvarchar(20) primary key,
Ten nvarchar (50),
Tuoi int, 
SDT nvarchar(12),
Email nvarchar(50),
GioiTinh nvarchar(20),
DiaChi nvarchar(200),
Luong int,
CCCD int,
)
create table VaiTro(
Mavaitro nvarchar(10) primary key,
Ten nvarchar(255),
)

