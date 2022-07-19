
<!--회원관리-->
create table member (
    uid INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    email01 varchar(30) NOT NULL,
    id01 varchar(15) NOT NULL,
    pwd01 varchar(20) NOT NULL,
    name01 varchar(20) NOT NULL,
    n_name varchar(20) NOT NULL,
    addr01 varchar(10) NOT NULL,
    addr02 varchar(20) NOT NULL,
    addr03 varchar(50) NOT NULL,
    r_date01 date NOT NULL,
    p_time timestamp not null default current_timestamp,
);

<!--주문관리-->
create table order (
    uid INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    email01 varchar(30) NOT NULL,
    id01 varchar(15) NOT NULL,
    pwd01 varchar(20) NOT NULL,
    name01 varchar(20) NOT NULL,
    n_name varchar(20) NOT NULL,
    addr01 varchar(10) NOT NULL,
    addr02 varchar(20) NOT NULL,
    addr03 varchar(50) NOT NULL,
    r_date01 date NOT NULL,
    p_time timestamp not null default current_timestamp,
);
