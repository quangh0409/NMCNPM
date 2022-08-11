drop database if exists `nmcnpm`;
create database `nmcnpm`;
use `nmcnpm`;
 
drop table if exists `NhanKhau`;
create table `NhanKhau` (
`id` int not null primary key,
`fullName` nvarchar(100) not null,
`biDanh` nvarchar(100) not null,
`birthday` date not null ,
`placeOfBirth` nvarchar(100) not null,
`domicile` nvarchar(100) not null,
`job` nvarchar(100) not null,
`workingPlace` nvarchar(100) not null,
`dayForIdCard` date not null,
`placeForIdCard` nvarchar(100) not null,
`dateOfRegistration` date not null,
`relationship` nvarchar(100) not null,
`IdHoKhau` int not null  );
insert into `NhanKhau` values (1,'Vũ Trọng Quảng','Quảng','2001-09-29','SIE','hello','sinh vien','DH BKHN','2016-04-16','SIE','2011-10-13','chu ho',1),
							   (2,'Nguyễn Đăng Khánh','Khánh','2001-11-04','SIE','hello','sinh vien','DH BKHN','2016-04-16','SIE','2011-10-13','thanh vien',1),
                               (3,'Trần Vũ Nhân','Nhân','2002-05-05','SIE','hello','sinh vien','DH BKHN','2016-04-16','SIE','2011-10-13','thanh vien',1),
                               (4,'Trần Quang Tình','Tình','2002-02-07','SIE','hello','sinh vien','DH BKHN','2016-04-16','SIE','2011-10-13','thanh vien',1),
                               (5,'Nguyễn Trường Kỳ','Kỳ','2001-01-24','SIE','hello','sinh vien','DH BKHN','2016-04-16','SIE','2011-10-13','thanh vien',1),
                               (6,'Nguyễn Đại Tài','Tài','2001-09-29','ĐHNT','hello','sinh vien','DH BKHN','2016-04-16','ĐHNT','2011-10-13','chu ho',2),
                               (7,'Nguyễn Mạnh Hùng','Hùng','2001-09-29','ĐHNT','hello','sinh vien','DH BKHN','2016-04-16','ĐHNT','2011-10-13','chu ho',2),
                               (8,'Phan Nguyễn Tú Chi','Chi','2001-09-29','ĐHNT','hello','sinh vien','DH BKHN','2016-04-16','ĐHNT','2011-10-13','chu ho',2),
                               (9,'Nguyễn Minh Gia Bảo','Bảo','2001-09-29','ĐHNT','hello','sinh vien','DH BKHN','2016-04-16','ĐHNT','2011-10-13','chu ho',2),
                               (10,'Lâm Thành Vinh','Vinh','2001-09-29','CTES','hello','sinh vien','DH BKHN','2016-04-16','CTES','2011-10-13','chu ho',3),
                               (11,'Nguyễn Viết Long','Long','2001-09-29','CTES','hello','sinh vien','DH BKHN','2016-04-16','CTES','2011-10-13','chu ho',3),
                               (12,'Lê Thị Trang','Trang','2001-09-29','CTES','hello','sinh vien','DH BKHN','2016-04-16','CTES','2011-10-13','chu ho',3),
                               (13,'Phạm Trí Linh','Linh','2001-09-29','CTES','hello','sinh vien','DH BKHN','2016-04-16','CTES','2011-10-13','chu ho',3),
                               (14,'Lê Ngọc Tân','Tân','2001-09-29','BLLSVTH','hello','sinh vien','DH BKHN','2016-04-16','BLLSVTH','2011-10-13','chu ho',4),
                               (15,'Nguyễn Văn Thương','Thương','2001-09-29','BLLSVTH','hello','sinh vien','DH BKHN','2016-04-16','BLLSVTH','2011-10-13','chu ho',4),
                               (16,'Nguyễn Văn Hiếu','Hiếu','2001-09-29','BLLSVTH','hello','sinh vien','DH BKHN','2016-04-16','BLLSVTH','2011-10-13','chu ho',4);
                               
 drop table if exists `HoKhau`;
create table `HoKhau` (
`id` int not null primary key,
 `nameOwner` nvarchar (100) not null,
 `houseNumber` nvarchar(100) not null,
`street` nvarchar(100) not null,
`ward` nvarchar(100) not null,
`district` nvarchar(100) not null

);
insert into `HoKhau` values (1,'Vũ Trọng Quảng',1,'D7','D7','DH BKHN'),
							(2,'Nguyễn Đại Tài',1,'D8','D8','DH BKHN'),
							(3,'Lâm Thành Vinh',1,'D9','D9','DH BKHN'),
							(4,'Lê Ngọc Tân',1,'D10','D10','DH BKHN');

drop table if exists `Lists`;
create table `Lists` (
`id` int not null primary key,
`names` nvarchar (100) not null,
`money` int not null,
`type` nvarchar (100) not null 
);
insert into `Lists` values (1,'Ủng hộ ngày thương binh-liệt sỹ 27/07',9999,'ủng hộ'),
							(2,'Ủng hộ ngày tết thiếu nhi',9999,'ủng hộ'),
                            (3,'Ủng hộ vì người nghèo',9999,'ủng hộ'),
                            (4,'Trợ giúp đồng bào bị ảnh hưởng bão lụt',9999,'ủng hộ'),
                             (5,'Phí vệ sinh',9999,'bắt buộc');
drop table if exists `Supply`;
create table `Supply` (
`idHk` int not null,
`idList` int not null,
`NgayNop` date not null,
`SoTien` int not null,
`NguoiThu` nvarchar(100) not null,
`NguoiNop` nvarchar(100) not null,
`status` nvarchar (100)
); 
insert into `Supply` values (1,1,'2001-09-29','9999','Quang','Quang','đã nộp'),
							(1,2,'2001-09-29','9999','Quang','Quang','đã nộp'),
                            (1,3,'2001-09-29','9999','Quang','Quang','đã nộp'),
                            (1,4,'2001-09-29','9999','Quang','Quang','đã nộp'),
                            (1,5,'2001-09-29','9999','Quang','Quang','đã nộp'),
                            (2,1,'2001-09-29','9999','Quang','Quang','đã nộp'),
							(2,2,'2001-09-29','9999','Quang','Quang','đã nộp'),
                            (2,3,'2001-09-29','9999','Quang','Quang','đã nộp'),
                            (2,4,'2001-09-29','9999','Quang','Quang','đã nộp'),
                            (2,5,'2001-09-29','9999','Quang','Quang','đã nộp'),
                            (3,1,'2001-09-29','9999','Quang','Quang','đã nộp'),
							(3,2,'2001-09-29','9999','Quang','Quang','đã nộp'),
                            (3,4,'2001-09-29','9999','Quang','Quang','đã nộp'),
                            (3,5,'2001-09-29','9999','Quang','Quang','đã nộp'),
                            (4,1,'2001-09-29','9999','Quang','Quang','đã nộp'),
							(4,2,'2001-09-29','9999','Quang','Quang','đã nộp'),
                            (4,3,'2001-09-29','9999','Quang','Quang','đã nộp'),
                            (4,4,'2001-09-29','9999','Quang','Quang','đã nộp'),
                            (4,5,'2001-09-29','9999','Quang','Quang','đã nộp');
select count(*) from`Supply`, `NhanKhau`  where `Supply`.idList = 1 and `NhanKhau`.IdHoKhau = `Supply`.idHk and `Supply`.idHk  = 1 ;
                            

                            