create table userinfo(
userid varchar2(15),
first_name varchar2(30),
last_name varchar2(30),
email varchar2(100),
contact_no varchar2(200),
enabled number(1),
userType char(3),
gender varchar2(20),
CONSTRAINT pk_userId_userInfo primary key(userid)
);


create table blog(
blog_id varchar2(15), 
userid varchar2(15), 
blog_title varchar2(100), 
blog_description varchar2(1000),
status char(1),
date_created date,
date_modified date,
CONSTRAINT pk_blogId_Blog PRIMARY KEY (blog_id),
constraint fk_userId_Blog FOREIGN KEY(userid) REFERENCES userinfo(userid)
);

create table role(
role_id varchar2(15),
role_name varchar2(30)
);

create table userrole(
id varchar2(15),
role_id varchar2(15),
userid varchar2(15)
);

create table user_role(
role_id varchar2(15),
userid varchar2(15),
role varchar2(15)
);