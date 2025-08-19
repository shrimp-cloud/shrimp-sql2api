CREATE TABLE `api_definition_param` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `api_code` varchar(31) NOT NULL DEFAULT '' COMMENT 'API 编码',
  `field_name` varchar(31) NOT NULL DEFAULT '' COMMENT '字段名称',
  `field_form_type` varchar(31) NOT NULL DEFAULT '' COMMENT '字段表单类型',
  `placeholder` varchar(255) DEFAULT NULL COMMENT 'Placeholder',
  `required` int NOT NULL DEFAULT 0 COMMENT '必填',
  `dict_type` varchar(31) DEFAULT NULL COMMENT '校验字典项',
  `sort` int NOT NULL DEFAULT 0 COMMENT '排序',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_by` varchar(31) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `update_by` varchar(31) DEFAULT NULL COMMENT '更新人',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `version` int NOT NULL DEFAULT 0 COMMENT '版本号',
  `status` bigint unsigned NOT NULL DEFAULT 1 COMMENT 'status',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `api_code` (`api_code`) USING BTREE
) ENGINE=InnoDB COMMENT='API 参数';
