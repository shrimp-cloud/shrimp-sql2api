
CREATE TABLE `api_group` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `group_code` varchar(31) NOT NULL DEFAULT '' COMMENT '分组 编码',
  `group_name` varchar(255) DEFAULT NULL COMMENT '分组 名称',
  `sort` int NOT NULL DEFAULT '0' COMMENT '排序',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` varchar(31) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `update_by` varchar(31) DEFAULT NULL COMMENT '更新人',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `version` int NOT NULL DEFAULT '0' COMMENT '版本号',
  `status` bigint unsigned NOT NULL DEFAULT '1' COMMENT 'status',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `group_code` (`group_code`) USING BTREE
) ENGINE=InnoDB COMMENT='API 分组';
