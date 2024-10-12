create database ASMJ5;
use ASMJ5;
go
create table SanPham(
Id int identity(1,1) primary key,
MaSanPham varchar(10),
TenSanPham nvarchar(50),
TrangThai bit
)
go
create table KhachHang(
Id int identity(1,1) primary key,
MaKhachHang varchar(50),
TenKhachHang nvarchar(50),
SDT varchar(10),
TrangThai bit
)
go
create table NhanVien(
Id int identity(1,1) primary key,
MaNhanVien varchar(10),
TenNhanVien nvarchar(50),
TenDangNhap varchar(50),
MatKhau nvarchar(50),
TrangThai bit
)
go
create table SanPhamChiTiet(
Id int identity(1,1) primary key,
IdMauSac int foreign key references MauSac(Id),
IdKichThuoc int foreign key references KichThuoc(Id),
IdSanPham int foreign key references SanPham(Id),
MaSanPhamChiTiet varchar(10),
SoLuong int,
DonGia float,
TrangThai bit
)
go
create table HoaDon(
Id int identity(1,1) primary key,
IdKhachHang int foreign key references KhachHang(Id),
IdNhanVien int foreign key references NhanVien(Id),
NgayMuaHang date,
TrangThai bit
)
go
create table MauSac(
Id int identity(1,1) primary key,
MaMau varchar(10),
TenMau nvarchar(50),
TrangThai bit
)
go
create table KichThuoc(
Id int identity(1,1) primary key,
MaKichThuoc varchar(10),
TenKichThuoc nvarchar(50),
TrangThai bit
)
go
create table HoaDonChiTiet(
Id int identity(1,1) primary key,
IdSanPhamChiTiet int foreign key references SanPhamChiTiet(Id),
IdHoaDon int foreign key references HoaDon(Id),
SoLuong int,
DonGia float
)
select * from HoaDonChiTiet
select * from HoaDon

