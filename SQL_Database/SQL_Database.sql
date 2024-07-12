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
