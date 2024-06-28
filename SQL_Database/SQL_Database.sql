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
