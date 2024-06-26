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