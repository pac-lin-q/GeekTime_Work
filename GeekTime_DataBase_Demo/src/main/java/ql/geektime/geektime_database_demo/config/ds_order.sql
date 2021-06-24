DROP DATABASE IF EXISTS ds_0;
DROP DATABASE IF EXISTS ds_1;
create schema ds_0;
create schema ds_1;

DROP TABLE IF EXISTS `ds_order_0`;
CREATE TABLE `ds_order_0` (
  `order_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `order_userid` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `order_proid` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `order_pronum` int DEFAULT NULL,
  `order_amount` decimal(10,2) NOT NULL,
  `order_createtime` datetime DEFAULT NULL,
  `order_endtime` datetime DEFAULT NULL,
  `order_paytime` datetime DEFAULT NULL,
  `order_remark01` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `order_remark02` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `order_remark03` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `ds_order_1`;
create table ds_order_1 like ds_order_0;

DROP TABLE IF EXISTS `ds_order_2`;
create table ds_order_2 like ds_order_0;

DROP TABLE IF EXISTS `ds_order_3`;
create table ds_order_3 like ds_order_0;

DROP TABLE IF EXISTS `ds_order_4`;
create table ds_order_4 like ds_order_0;

DROP TABLE IF EXISTS `ds_order_5`;
create table ds_order_5 like ds_order_0;

DROP TABLE IF EXISTS `ds_order_6`;
create table ds_order_6 like ds_order_0;

DROP TABLE IF EXISTS `ds_order_7`;
create table ds_order_7 like ds_order_0;

DROP TABLE IF EXISTS `ds_order_8`;
create table ds_order_8 like ds_order_0;

DROP TABLE IF EXISTS `ds_order_9`;
create table ds_order_9 like ds_order_0;

DROP TABLE IF EXISTS `ds_order_10`;
create table ds_order_10 like ds_order_0;

DROP TABLE IF EXISTS `ds_order_11`;
create table ds_order_11 like ds_order_0;

DROP TABLE IF EXISTS `ds_order_12`;
create table ds_order_12 like ds_order_0;

DROP TABLE IF EXISTS `ds_order_13`;
create table ds_order_13 like ds_order_0;

DROP TABLE IF EXISTS `ds_order_14`;
create table ds_order_14 like ds_order_0;

DROP TABLE IF EXISTS `ds_order_15`;
create table ds_order_15 like ds_order_0;