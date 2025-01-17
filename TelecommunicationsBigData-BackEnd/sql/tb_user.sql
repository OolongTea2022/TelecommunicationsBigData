
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` int(9) NOT NULL AUTO_INCREMENT,
  `uname` varchar(20) NOT NULL,
  `upassword` varchar(20) NOT NULL,
  `role` varchar(20) NOT NULL,
  `NWOperator` varchar(20) DEFAULT NULL,
  `region` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uname` (`uname`),
  UNIQUE KEY `uname_2` (`uname`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', 'admin', '123456', 'admin', 'admin', 'beijing');
INSERT INTO `tb_user` VALUES ('2', 'admin1', '123456', 'admin', 'admin', 'beijing');
INSERT INTO `tb_user` VALUES ('3', 'admin2', '123456', 'admin', 'admin', 'beijing');
INSERT INTO `tb_user` VALUES ('5', 'admin3', '123456', 'operator', 'CMCC', 'beijing');
INSERT INTO `tb_user` VALUES ('8', 'root', 'root', 'root', 'root', 'beijing');
