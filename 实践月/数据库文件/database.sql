
USE jizhang;

/*Table structure for table admin */

DROP TABLE IF EXISTS admin;

CREATE TABLE admin (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(20) DEFAULT NULL,
  pass varchar(20) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table admin */

insert  into admin(id,name,pass) values (1,'admin','123');

/*Table structure for table tong */

DROP TABLE IF EXISTS tong;

CREATE TABLE tong (
  id int(11) NOT NULL AUTO_INCREMENT,
  user varchar(200) DEFAULT NULL,
  type varchar(200) DEFAULT NULL,
  kind varchar(200) DEFAULT NULL,
  date varchar(100) DEFAULT NULL,
  year varchar(200) DEFAULT NULL,
  month varchar(200) DEFAULT NULL,
  shou int(11) DEFAULT NULL,
  zhi int(11) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table tong */

insert  into tong(id,user,type,kind,date,year,month,shou,zhi) values (1,'zs','出账','公费','2016-01-13','2016','01',1200,4020),(2,'zs','出账','公费','2016-01-13','2016','01',1200,4020),(3,'zs','出账','公费','2016-01-13','2016','01',1200,4020),(4,'zs','出账','公费','2018-05-09','2018','05',0,6000);

/*Table structure for table user */

DROP TABLE IF EXISTS user;

CREATE TABLE user (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(20) DEFAULT NULL,
  sex varchar(20) DEFAULT NULL,
  age varchar(20) DEFAULT NULL,
  pass varchar(200) DEFAULT NULL,
  tel varchar(200) DEFAULT NULL,
  rname varchar(20) DEFAULT NULL,
  adddate varchar(300) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table user */

insert  into user(id,name,sex,age,pass,tel,rname,adddate) values (1,'zs','男','22','1','18045601230','张三','2018-05-09'),(2,'admin','男','120','111','123456','葫芦娃','2018-5-9 22:33:57');

/*Table structure for table zhang */

DROP TABLE IF EXISTS zhang;

CREATE TABLE zhang (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(20) DEFAULT NULL,
  user varchar(20) DEFAULT NULL,
  rname varchar(20) DEFAULT NULL,
  type varchar(50) DEFAULT NULL,
  kind varchar(50) DEFAULT NULL,
  date varchar(100) DEFAULT NULL,
  count int(11) DEFAULT NULL,
  yong varchar(100) DEFAULT NULL,
  info varchar(200) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table zhang */

insert  into zhang(id,name,user,rname,type,kind,date,count,yong,info) values (1,'开会','zs','张三','出账','公费','2015-01-13',200,'开会','会议开销'),(2,'购买耗材','zs','张三','出账','公费','2015-01-13',320,'耗材','购买耗材'),(3,'北京项目','zs','张三','入账','公费','2015-01-13',1200,'北京项目','北京项目'),(4,'上海项目','zs','张三','入账','公费','2014-12-13',3000,'上海项目','上海项目'),(5,'买耗材','zs','张三','出账','公费','2014-12-18',300,'买耗材','打印机墨盒'),(6,'南京项目','zs','张三','出账','公费','2014-11-13',2000,'南京项目','南京项目'),(7,'广告','zs','张三','入账','公费','2014-11-19',450,'广告','广告'),(8,'购买电脑','zs','张三','出账','公费','2015-01-14',3500,'购买电脑','购买电脑'),(12,'测试','zs','张三','出账','公费','2018-05-09',3000,'吃喝玩乐','');


