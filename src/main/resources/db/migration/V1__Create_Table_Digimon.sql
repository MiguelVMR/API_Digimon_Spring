
CREATE TABLE `digimons` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `digimon_level` varchar(80) NOT NULL,
  `digimon_name` varchar(80) NOT NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO `digimons` VALUES (1,'In Training','Koromon');
