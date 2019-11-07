#建立项目数据库的表

#Module One  权限模块 [RBAC设计模式去设计表，非常灵活，扩展性好]
#airsys_user  
#airsys_role  
#airsys_resource

#Module Two  人资模块 [其实并没有统一的标准，就是根据实际情况设置表]
#...

#Module Tree  行政模块 [考勤管理 车辆管理 办公用品管理 ]  
#...

#例子模块
create table if not exists account(
	id int primary key auto_increment,
	name varchar(50) not null,
	balance double
)

create table if not exists t_user(
	id int primary key auto_increment,
	name varchar(50) not null,
	age int
);


