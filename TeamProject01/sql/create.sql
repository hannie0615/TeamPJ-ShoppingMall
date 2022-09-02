# <!--회원관리 -->
CREATE TABLE `shoppingmall`.`member` (
                                         `uid` BIGINT NOT NULL AUTO_INCREMENT,
                                         `email01` VARCHAR(30) NOT NULL,
                                         `id01` VARCHAR(15) NOT NULL,
                                         `pwd01` VARCHAR(100) NOT NULL,
                                         `name01` VARCHAR(20) NOT NULL,
                                         `n_name` VARCHAR(20) NOT NULL,
                                         `addr01` VARCHAR(10) NOT NULL,
                                         `addr02` VARCHAR(50) NOT NULL,
                                         `addr03` VARCHAR(50) NOT NULL,
                                         `r_date01` DATE NOT NULL,
                                         `p_time` BIGINT NOT NULL,
                                         `enabled` BIT(1) NOT NULL,
                                         PRIMARY KEY (`uid`),
                                         UNIQUE INDEX `id01_UNIQUE` (`id01` ASC) VISIBLE
);

# <!-- 권한 테이블 -->
CREATE TABLE `shoppingmall`.`role` (
                                       `id` BIGINT NOT NULL AUTO_INCREMENT,
                                       `name` VARCHAR(50) NOT NULL,
                                       PRIMARY KEY (`id`)
);

# <!-- Many to Many Mapping / 회원테이블, 권한테이블 -->
CREATE TABLE `shoppingmall`.`member_role` (
                                              `member_id` BIGINT NOT NULL,
                                              `role_id` BIGINT NOT NULL,
                                              PRIMARY KEY (`member_id`, `role_id`),
                                              INDEX `FK_member_role_role_idx` (`role_id` ASC) VISIBLE,
                                              CONSTRAINT `FK_member_role_member`
                                                  FOREIGN KEY (`member_id`)
                                                      REFERENCES `shoppingmall`.`member` (`uid`)
                                                      ON DELETE RESTRICT
                                                      ON UPDATE RESTRICT,
                                              CONSTRAINT `FK_member_role_role`
                                                  FOREIGN KEY (`role_id`)
                                                      REFERENCES `shoppingmall`.`role` (`id`)
                                                      ON DELETE RESTRICT
                                                      ON UPDATE RESTRICT
);

# <!-- 초기 권한 설정 -->
INSERT INTO `shoppingmall`.`role` (`name`) VALUES ('ROLE_USER');

# <!--후기게시판-->
create table prd_rev (
                         uid INT AUTO_INCREMENT PRIMARY KEY,
                         fk_member varchar(15) NOT NULL,
                         prd_id varchar(30) NOT NULL,
                         b_writer varchar(30) NOT NULL,
                         ment varchar(300) NOT NULL,
                         img_file varchar(30) NOT NULL,
                         realfile varchar(30) NOT NULL,
                         b_date date NOT NULL,
                         p_time timestamp not null default current_timestamp,
                         FOREIGN KEY(fk_member) REFERENCES member(uid)
);


# <!--주문관리-->
create table order (
                       uid INT AUTO_INCREMENT PRIMARY KEY,
                       fk_num varchar(15) NOT NULL,
                       deliv_num varchar(30) NOT NULL,
                       res_nm varchar(20) NOT NULL,
                       res_addr01 varchar(30) NOT NULL,
                       res_addr02 varchar(30) NOT NULL,
                       res_addr03 varchar(30) NOT NULL,
                       res_tel varchar(12) NOT NULL,
                       res_hp varchar(13) NOT NULL,
                       deliv_req varchar(40) NOT NULL,
                       ord_date date NOT NULL,
                       p_time timestamp not null default current_timestamp,
                       FOREIGN KEY(fk_num) REFERENCES member(uid)
                           FOREIGN KEY(deliv_num) REFERENCES delivery(uid)
);

# <!--주문상품-->
create table ord_prd (
                         uid INT AUTO_INCREMENT PRIMARY KEY,
                         fk_num varchar(15) NOT NULL,
                         fk_ord_num INT NOT NULL,
                         fk_adm INT NOT NULL,
                         FOREIGN KEY(fk_num) REFERENCES member(fk_num)
                             FOREIGN KEY(fk_ord_num) REFERENCES member(fk_ord_num)
                             FOREIGN KEY(fk_adm) REFERENCES member(fk_adm)
);

# <!--상품관리-->
create table product (
                         uid INT AUTO_INCREMENT PRIMARY KEY,
                         fk_ord_num INT NOT NULL,
                         fk_adm INT NOT NULL,
                         fk_cate varchar(30) NOT NULL,
                         prd_price varchar(15) NOT NULL,
                         prd_cmp varchar(30) NOT NULL,
                         prd_type varchar(30) NOT NULL,
                         prd_img varchar(30) NOT NULL,
                         realfile varchar(30) NOT NULL,
                         prd_ment varchar(50) NOT NULL,
                         prd_stock INT(15) NOT NULL,
                         prd_sales INT(15) NOT NULL,
                         FOREIGN KEY(fk_ord_num) REFERENCES ord_prd(fk_ord_num)
                             FOREIGN KEY(fk_adm) REFERENCES admin(uid)
                             FOREIGN KEY(fk_cate) REFERENCES ctgprd(uid)
);

# <!--카테고리별 상품관리-->
create table ctgprd (
                        uid INT AUTO_INCREMENT PRIMARY KEY,
                        c_name varchar(30) NOT NULL,
);

# <!--문의게시판-->
create table inquire_board (
                               uid INT AUTO_INCREMENT PRIMARY KEY,
                               fk_deliv varchar(15) NOT NULL,
                               b_title varchar(50) NOT NULL,
                               b_pwd varchar(20) NOT NULL,
                               b_writer varchar(15) NOT NULL,
                               ment varchar(300) NOT NULL,
                               b_date date NOT NULL,
                               b_cnt INT NOT NULL,
                               b_category varchar(50) NOT NULL,
                               b_lock char(3) NOT NULL,
                               FOREIGN KEY(fk_deliv) REFERENCES order(uid)
);

# <!--장바구니-->
create table cart_prd (
                          uid INT AUTO_INCREMENT PRIMARY KEY,
                          fk_member INT NOT NULL,
                          fk_ord INT NOT NULL,
                          amount INT(20) NOT NULL,
                          cart_chk INT(10) NOT NULL,
                          cart_pay INT(20) NOT NULL,
                          FOREIGN KEY(fk_member) REFERENCES member(uid)
                              FOREIGN KEY(fk_ord) REFERENCES product(uid)
);