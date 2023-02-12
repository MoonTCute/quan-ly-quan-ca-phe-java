create database QL_QuanCafe
go
use QL_QuanCafe
go
set dateformat dmy
create table LoaiSanPham
(
	MaLSP char(10) primary key not null,
	TenLSP nvarchar(50),
)

create table SanPham
(
	MaSP char(10) primary key not null,
	TenSP nvarchar(50),
	GiaTien money,
	DVT nvarchar(20),
	MaLSP char(10),
	constraint fk_sp_lsp foreign key (MaLSP) references LoaiSanPham(MaLSP)
)

create table Ban
(
	MaBan char(10) primary key not null,
	TenBan nvarchar(50),
	TrangThai nvarchar(50) default N'Còn trống',
)

create table NhanVien
(
	MaNV char(10) primary key not null,
	TenNV nvarchar(50),
	Chucvu nvarchar(50),
	NgaySinh date,
	GioiTinh nvarchar(10),
	DiaChi nvarchar(100),
	SDT char(11),
	Email char(100),
	TaiKhoan char(100),
	MatKhau char(100),
)

create table HoaDon
(
	MaHD char(10) primary key not null,
	MaNV char(10) not null,
	MaBan char(10) not null,
	NgayLapHD date not null,
	TongTien money,
	TinhTrang nvarchar(50) default N'Chưa thanh toán',
	constraint fk_hd_nv foreign key (MaNV) references NhanVien(MaNV),
	constraint fk_hd_maban foreign key (MaBan) references Ban(MaBan),
)

create table ChiTietHoaDon
(
	MaHD char(10) not null,
	MaSP char(10) not null,
	SoLuong int,
	ThanhTien bigint,
	primary key(MaHD, MaSP),
	constraint fk_cthd_hd foreign key (MaHD) references HoaDon(MaHD),
	constraint fk_cthd_sp foreign key (MaSP) references SanPham(MaSP),
)
-------------------------------------------------------------------------------------------------------------------------------------------

---------------------------------------------------------------------------------------------------------------------------------------------

update ban set trangthai = N'Còn trống' where tenban ='Bàn 1'
update ban set trangthai = N'Còn trống' where tenban ='Bàn 2'
update ban set trangthai = N'Còn trống' where tenban ='Bàn 3'
update ban set trangthai = N'Còn trống' where tenban ='Bàn 4'
update ban set trangthai = N'Còn trống' where tenban ='Bàn 5'
update ban set trangthai = N'Còn trống' where tenban ='Bàn 6'
update ban set trangthai = N'Còn trống' where tenban ='Bàn 7'
update ban set trangthai = N'Còn trống' where tenban ='Bàn 8'


--------------------------------------------------------------------------------------------------------------------------------------------
insert into LoaiSanPham(MaLSP, TenLSP) values ('LSP001', N'Cà phê')
insert into LoaiSanPham(MaLSP, TenLSP) values ('LSP002', N'Nước trái cây')
insert into LoaiSanPham(MaLSP, TenLSP) values ('LSP003', N'Nước ngọt')
insert into LoaiSanPham(MaLSP, TenLSP) values ('LSP004', N'Nước khoáng')

insert into SanPham(MaSP, TenSP, GiaTien, DVT, MaLSP) values ('SP001', N'Cà phê đá', 20000, N'Ly', 'LSP001')
insert into SanPham(MaSP, TenSP, GiaTien, DVT, MaLSP) values ('SP002', N'Cà phê sữa', 25000, N'Ly', 'LSP001')
insert into SanPham(MaSP, TenSP, GiaTien, DVT, MaLSP) values ('SP003', N'Nước cam', 15000, N'Ly', 'LSP002')
insert into SanPham(MaSP, TenSP, GiaTien, DVT, MaLSP) values ('SP004', N'Sting', 10000, N'Lon', 'LSP003')
insert into SanPham(MaSP, TenSP, GiaTien, DVT, MaLSP) values ('SP005', N'Aquafina', 7000, N'Chai', 'LSP004')

insert into Ban(MaBan, TenBan, TrangThai) values ('B001', N'Bàn 1', default)
insert into Ban(MaBan, TenBan, TrangThai) values ('B002', N'Bàn 2', default)
insert into Ban(MaBan, TenBan, TrangThai) values ('B003', N'Bàn 3', default)
insert into Ban(MaBan, TenBan, TrangThai) values ('B004', N'Bàn 4', default)
insert into Ban(MaBan, TenBan, TrangThai) values ('B005', N'Bàn 5', default)

insert into NhanVien(MaNV, TenNV, Chucvu, NgaySinh, GioiTinh, DiaChi, SDT, Email, TaiKhoan, MatKhau) 
values  ('NV005', N'Nguyễn Đức Trung', N'Quản Lý','20-12-2001', N'Nam', N'Tây Ninh', '0123465789', 'tmoonpts@gmail.com', 'nguyentrung', '123456'),
		('NV002', N'Nguyễn Quỳnh Gia Bảo', N'Nhân viên', '20-10-2001', N'Nam', N'Hồ Chí Minh', '0123456789', 'giaobao@gmail.com', 'giabao', '123456'),
		('NV003', N'Nguyễn Cao Trường', N'Nhân viên', '01-01-2001', N'Nam', N'Hồ Chí Minh', '0436823862', 'caotruong@gmail.com', 'caotruong', '123456')

insert into HoaDon(MaHD,MaNV,MaBan,NgayLapHD,TongTien,TinhTrang)
values ('HD5','NV001','B008','2021-8-25',NULL,N'Đã thanh toán')

insert into HoaDon(MaHD,MaNV,MaBan,NgayLapHD,TongTien,TinhTrang)
values ('HD3','NV004','B001','2021-8-3',NULL,default)

insert into ChiTietHoaDon(MaHD,MaSP,SoLuong,ThanhTien)
values ('HD1','SP002',1,NULL)

insert into Ban(MaBan, TenBan, TrangThai) values ('B008', N'Bàn 8', N'Đang phục vụ')
go

