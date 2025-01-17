
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_counts
-- ----------------------------
DROP TABLE IF EXISTS `tb_counts`;
CREATE TABLE `tb_counts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `NWQuality_count` int(11) DEFAULT NULL,
  `Signal_Strength_count` int(11) DEFAULT NULL,
  `DataConnection_count` int(11) DEFAULT NULL,
  `dateTime` int(11) DEFAULT NULL,
  `NWOperator` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;











