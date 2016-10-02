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
role_id varchar2(20),
userid varchar2(15),
role varchar2(15),
constraint pk_roleid_userrole primary key(role_id),
constraint fk_userid_userrole foreign key(userid) references userinfo(userid)
);

create table user_role(
role_id varchar2(20),
userid varchar2(20),
role varchar2(20),
constraint pk_roleid_userrole primary key(role_id);
constraint fk_userid_userrole foreign key(userid) references userinfo(userid)
);

create table blogcomment(
blogcomment_id varchar2(20),
userid varchar2(20),
description varchar2(200),
time_commented Timestamp,
blog_id varchar2(20),
CONSTRAINT pk_blogcommentid_BlogComment PRIMARY KEY (blogcomment_id),
constraint fk_blogcommentId_BlogComment FOREIGN KEY(blog_id) REFERENCES blog(blog_id),
constraint fk_blogcommentId2_BlogComment FOREIGN KEY(userid) REFERENCES userinfo(userid)
);

create table forum(
forum_id varchar2(20),
forum_title varchar2(40),
forum_description varchar2(300),
userid varchar2(20),
date_created date,
time_modified Timestamp,
status char(3),
CONSTRAINT pk_forumid_Forum PRIMARY KEY (forum_id),
constraint fk_userid_Forum FOREIGN KEY(userid) REFERENCES userinfo(userid)
);

create table forumpost(
forumpostid varchar2(20),
userid varchar2(20),
time_created Timestamp,
post_content varchar2(300),
forum_id varchar2(20),
CONSTRAINT pk_forumpostid_ForumPost PRIMARY KEY (forumpostid),
constraint fk_userid_ForumPost FOREIGN KEY(userid) REFERENCES userinfo(userid),
constraint fk_forumid_ForumPost FOREIGN KEY(forum_id) REFERENCES forum(forum_id)
);