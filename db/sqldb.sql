--data base tables examples
create table users(
    id bigint(20) primary key auto_increment,
    first_name varchar(255)  null,
    second_name varchar(255)  null,
    username varchar(255)  null,
    phone varchar(255)  null,
    address varchar(255)  null
)
create table notices(
      id bigint(20) primary key auto_increment,
      id_users  bigint(20),
      description varchar(500) null,
      FOREIGN KEY (id_users) REFERENCES users(id)
)

--test json
{
    "id":"",
	"first_name":"Alex",
	"second_name":"Yungan",
	"username":"ayungan",
	"phone":"0994276157",
	"address":"roma y viena"
}
