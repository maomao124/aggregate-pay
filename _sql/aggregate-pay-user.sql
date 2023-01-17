# Create Database
# ------------------------------------------------------------
CREATE DATABASE IF NOT EXISTS aggregate_pay_user DEFAULT CHARACTER SET = utf8mb4;

Use aggregate_pay_user;


# Dump of table account
# ------------------------------------------------------------

DROP TABLE IF EXISTS `account`;

CREATE TABLE `account`
(
    `ID`       bigint(20)  NOT NULL AUTO_INCREMENT,
    `USERNAME` varchar(50) DEFAULT NULL COMMENT '用户名',
    `MOBILE`   varchar(50) NOT NULL COMMENT '手机号',
    `PASSWORD` varchar(50) DEFAULT NULL COMMENT '密码',
    `SALT`     varchar(50) DEFAULT NULL COMMENT '盐',
    PRIMARY KEY (`ID`) USING BTREE,
    UNIQUE KEY `mobile_idx` (`MOBILE`),
    UNIQUE KEY `username_idx` (`USERNAME`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  ROW_FORMAT = DYNAMIC;



# Dump of table account_role
# ------------------------------------------------------------

DROP TABLE IF EXISTS `account_role`;

CREATE TABLE `account_role`
(
    `ID`        bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `USERNAME`  varchar(50) DEFAULT NULL COMMENT '用户名',
    `ROLE_CODE` varchar(50) DEFAULT NULL COMMENT '角色编码',
    `TENANT_ID` bigint(20)  DEFAULT NULL COMMENT '租户id',
    PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  ROW_FORMAT = DYNAMIC COMMENT ='账号-角色关系';



# Dump of table authorization_privilege
# ------------------------------------------------------------

DROP TABLE IF EXISTS `authorization_privilege`;

CREATE TABLE `authorization_privilege`
(
    `ID`                 bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `NAME`               varchar(50) DEFAULT NULL COMMENT '权限名称',
    `CODE`               varchar(50) DEFAULT NULL COMMENT '权限编码',
    `PRIVILEGE_GROUP_ID` bigint(20)  DEFAULT NULL COMMENT '所属权限组id',
    PRIMARY KEY (`ID`) USING BTREE,
    UNIQUE KEY `priv_unq_code` (`CODE`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  ROW_FORMAT = DYNAMIC COMMENT ='权限';

LOCK TABLES `authorization_privilege` WRITE;
/*!40000 ALTER TABLE `authorization_privilege`
    DISABLE KEYS */;

INSERT INTO `authorization_privilege` (`ID`, `NAME`, `CODE`, `PRIVILEGE_GROUP_ID`)
VALUES (1, '工作台', 'sj_m_console', 1),
       (2, '应用管理', 'sj_m_app_list', 4),
       (3, '应用交易总览', 'sj_m_transaction_list', 4),
       (4, '应用财务对账', 'sj_m_account_check', 4),
       (5, '开始支付', 'sj_m_payment', 4),
       (6, '账户中心', 'sj_m_account_list', 5),
       (7, '企业认证', 'sj_m_enterprise_auth', 5),
       (8, '门店管理', 'sj_m_store_list', 6),
       (9, '成员管理', 'sj_m_staff_list', 6),
       (10, '会员管理', 'sj_o_member_list', 7),
       (11, '企业管理', 'sj_o_entreprise_list', 7),
       (12, '审核管理', 'sj_o_audit', 7),
       (13, '服务类型管理', 'sj_o_service_type', 8),
       (14, '往来对账', 'sj_o_account_check', 9),
       (15, '管理员管理', 'sj_o_admin_list', 10),
       (16, '角色管理', 'sj_o_role_list', 10),
       (17, '应用创建', 'sj_m_app_create', 4),
       (18, '设置默认支付', 'sj_m_payment_set', 4),
       (19, '门店新增', 'sj_m_store_create', 6),
       (20, '门店查询', 'sj_m_store_query', 6),
       (21, '成员新增', 'sj_m_staff_create', 6),
       (22, '成员查询', 'sj_m_staff_query', 6),
       (23, '会员查询', 'sj_o_member_query', 7),
       (24, '企业查询', 'sj_o_enterprise_query', 7),
       (25, '企业新建', 'sj_o_enterprise_create', 7),
       (26, '服务类型新建', 'sj_o_service_create', 8),
       (27, '服务类型查询', 'sj_o_service_query', 8),
       (28, '管理员新建', 'sj_o_admin_create', 10),
       (29, '管理员查询', 'sj_o_admin_query', 10),
       (30, '角色新建', 'sj_o_role_create', 10),
       (31, '课程列表', 'xc_course_base_list', 17),
       (32, '课程保存', 'xc_course_base_save', 17),
       (33, '课程修改', 'xc_course_base_edit', 17),
       (34, '课程删除', 'xc_course_base_del', 17),
       (38, '课程详情', 'xc_course_base_view', 17),
       (39, '课程计划详情', 'xc_teachplan_view', 17),
       (40, '操作课程计划', 'xc_teachplan_save_modify', 17),
       (41, '删除课程计划', 'xc_teachplan_del', 17),
       (42, '操作课程营销', 'xc_market_save_modify', 17),
       (43, '课程营销详情', 'xc_market_view', 17),
       (44, '发布课程', 'xc_course_publish', 17),
       (45, '媒资列表', 'xc_media_list', 18),
       (46, '媒资保存', 'xc_media_save', 18),
       (47, '媒资（视频）预览', 'xc_media_preview', 18),
       (48, '媒资删除', 'xc_media_del', 18),
       (49, '机构修改', 'xc_company_modify', 19),
       (50, '机构详情', 'xc_company_view', 19),
       (51, '教师列表', 'xc_teacher_list', 19),
       (52, '保存教师信息', 'xc_teacher_save', 19),
       (53, '修改教师信息', 'xc_teacher_modify', 19),
       (54, '作业列表', 'xc_teachplanwork_list', 19),
       (55, '操作课程作业', 'xc_teachplanwork_save_modify', 19),
       (56, '删除课程作业', 'xc_teachplanwork_del', 19),
       (57, '作业记录列表', 'xc_workrecord_list', 19),
       (58, '作业记录批改', 'xc_workrecord_correction', 19),
       (59, '角色查询', 'sj_o_role_query', 10),
       (60, '角色权限保存', 'sj_o_role_save', 10),
       (61, '企业认证的申请', 'sj_m_auth_apply', 7),
       (62, '工作台续费', 'sj_m_console_renew', 1),
       (63, '工作台升级', 'sj_m_console_upgrade', 1),
       (64, '应用保存', 'sj_m_app_save', 4),
       (65, '应用编辑', 'sj_m_app_modify', 4),
       (66, '支付参数保存', 'sj_m_payparam_save', 4),
       (67, '设置默认支付', 'sj_m_pay_set', 4),
       (68, '默认支付保存', 'sj_m_pay_save', 4),
       (69, 'C扫B二维码生成', 'sj_m_c2b_qrcode', 4),
       (70, 'B扫C订单生成', 'sj_m_b2c_order', 4),
       (71, '线上支付参数展示', 'sj_m_h5_view', 4),
       (72, '购买套餐', 'sj_m_bundle_buy', 5),
       (73, '企业认证资料提交', 'sj_m_enterprise_info_submit', 5),
       (74, '企业认证资料取消', 'sj_m_enterprise_info_cancel', 5),
       (76, '通过企业认证', 'sj_o_enterprise_auth_pass', 7),
       (77, '驳回企业认证', 'sj_o_enterprise_auth_rejection', 7),
       (81, '门店管理-编辑', 'sj_m_store_edit', 6),
       (82, '成员管理-编辑', 'sj_m_staff_edit', 6),
       (83, '管理员管理-编辑', 'sj_o_admin_edit', 10),
       (84, '角色管理-编辑', 'sj_o_role_edit', 10),
       (85, '门店管理-保存', 'sj_m_store_save', 6),
       (86, '门店管理-删除', 'sj_m_store_del', 6),
       (87, '成员管理-保存', 'sj_m_staff_save', 6),
       (88, '成员管理-删除', 'sj_m_staff_del', 6);

/*!40000 ALTER TABLE `authorization_privilege`
    ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table authorization_privilege_group
# ------------------------------------------------------------

DROP TABLE IF EXISTS `authorization_privilege_group`;

CREATE TABLE `authorization_privilege_group`
(
    `ID`        bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `PARENT_ID` bigint(20)  DEFAULT NULL COMMENT '父id',
    `NAME`      varchar(50) DEFAULT NULL COMMENT '权限组名称',
    PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  ROW_FORMAT = DYNAMIC COMMENT ='权限组';

LOCK TABLES `authorization_privilege_group` WRITE;
/*!40000 ALTER TABLE `authorization_privilege_group`
    DISABLE KEYS */;

INSERT INTO `authorization_privilege_group` (`ID`, `PARENT_ID`, `NAME`)
VALUES (1, NULL, '商户平台'),
       (2, NULL, '运营平台'),
       (3, NULL, '门户网站'),
       (4, 1, '应用管理'),
       (5, 1, '账户管理'),
       (6, 1, '组织管理'),
       (7, 2, '企业管理'),
       (8, 2, '服务类型管理'),
       (9, 2, '账单管理'),
       (10, 2, '系统管理'),
       (12, NULL, '商户平台app端');

/*!40000 ALTER TABLE `authorization_privilege_group`
    ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table authorization_role
# ------------------------------------------------------------

DROP TABLE IF EXISTS `authorization_role`;

CREATE TABLE `authorization_role`
(
    `ID`        bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `NAME`      varchar(50) DEFAULT NULL COMMENT '角色名称',
    `CODE`      varchar(50) DEFAULT NULL COMMENT '角色编码',
    `TENANT_ID` bigint(20)  DEFAULT NULL COMMENT '租户id',
    PRIMARY KEY (`ID`) USING BTREE,
    UNIQUE KEY `tenant_id_code_unique` (`CODE`, `TENANT_ID`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  ROW_FORMAT = DYNAMIC COMMENT ='角色信息';

LOCK TABLES `authorization_role` WRITE;
/*!40000 ALTER TABLE `authorization_role`
    DISABLE KEYS */;

INSERT INTO `authorization_role` (`ID`, `NAME`, `CODE`, `TENANT_ID`)
VALUES (1, '商户管理员', 'r_001', 1177111672565059586),
       (2, '商户门店收银员', 'r_002', 1177111672565059586),
       (11, '商户管理员', 'r_001', 1177112064011063298),
       (12, '商户门店收银员', 'r_002', 1177112064011063298),
       (13, '商户管理员', 'r_001', 1177140318218563585),
       (14, '商户门店收银员', 'r_002', 1177140318218563585),
       (15, '商户管理员', 'r_001', 1177141851660300290),
       (16, '商户门店收银员', 'r_002', 1177141851660300290),
       (17, '商户管理员', 'r_001', 1177142745177075713),
       (18, '商户门店收银员', 'r_002', 1177142745177075713),
       (19, '商户管理员', 'r_001', 1177144209463128065),
       (20, '商户门店收银员', 'r_002', 1177144209463128065),
       (23, '商户管理员', 'r_001', 1186165689237438465),
       (24, '商户门店收银员', 'r_002', 1186165689237438465),
       (25, '商户管理员', 'r_001', 1186168085229404161),
       (26, '商户门店收银员', 'r_002', 1186168085229404161),
       (27, '商户管理员', 'r_001', 1186170919618412546),
       (28, '商户门店收银员', 'r_002', 1186170919618412546),
       (29, '商户管理员', 'r_001', 1186171861839446018),
       (30, '商户门店收银员', 'r_002', 1186171861839446018),
       (31, '商户管理员', 'r_001', 1186172654604845058),
       (32, '商户门店收银员', 'r_002', 1186172654604845058),
       (33, '商户管理员', 'r_001', 1186173819157544962),
       (34, '商户门店收银员', 'r_002', 1186173819157544962),
       (35, '商户管理员', 'r_001', 1186855107896029186),
       (36, '商户门店收银员', 'r_002', 1186855107896029186),
       (38, '商户管理员', 'r_001', 1194527284107677698),
       (39, '商户门店收银员', 'r_002', 1194527284107677698),
       (40, '商户管理员', 'r_001', 1194528354401783809),
       (41, '商户门店收银员', 'r_002', 1194528354401783809),
       (46, '商户管理员', 'r_001', 1199893397776707585),
       (47, '商户门店收银员', 'r_002', 1199893397776707585),
       (48, '商户管理员', 'r_001', 1199981635597017089),
       (49, '商户门店收银员', 'r_002', 1199981635597017089);

/*!40000 ALTER TABLE `authorization_role`
    ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table authorization_role_privilege
# ------------------------------------------------------------

DROP TABLE IF EXISTS `authorization_role_privilege`;

CREATE TABLE `authorization_role_privilege`
(
    `ID`           bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `ROLE_ID`      bigint(20) DEFAULT NULL COMMENT '角色id',
    `PRIVILEGE_ID` bigint(20) DEFAULT NULL COMMENT '权限id',
    PRIMARY KEY (`ID`) USING BTREE,
    UNIQUE KEY `role_priv_unique` (`ROLE_ID`, `PRIVILEGE_ID`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  ROW_FORMAT = DYNAMIC COMMENT ='角色-权限关系';

LOCK TABLES `authorization_role_privilege` WRITE;
/*!40000 ALTER TABLE `authorization_role_privilege`
    DISABLE KEYS */;

INSERT INTO `authorization_role_privilege` (`ID`, `ROLE_ID`, `PRIVILEGE_ID`)
VALUES (1, 1, 1),
       (2, 1, 2),
       (3, 1, 3),
       (4, 1, 4),
       (5, 1, 5),
       (6, 1, 6),
       (7, 1, 7),
       (8, 1, 8),
       (9, 1, 9),
       (10, 1, 10),
       (11, 1, 11),
       (12, 1, 12),
       (13, 1, 13),
       (14, 2, 14),
       (15, 11, 1),
       (16, 11, 2),
       (17, 11, 3),
       (18, 11, 4),
       (19, 11, 5),
       (20, 11, 6),
       (21, 11, 7),
       (22, 11, 8),
       (23, 11, 9),
       (24, 11, 10),
       (25, 11, 11),
       (26, 11, 12),
       (27, 11, 13),
       (28, 12, 14),
       (29, 13, 1),
       (30, 13, 2),
       (31, 13, 3),
       (32, 13, 4),
       (33, 13, 5),
       (34, 13, 6),
       (35, 13, 7),
       (36, 13, 8),
       (37, 13, 9),
       (38, 13, 10),
       (39, 13, 11),
       (40, 13, 12),
       (41, 13, 13),
       (42, 14, 23),
       (43, 15, 1),
       (44, 15, 2),
       (45, 15, 3),
       (46, 15, 4),
       (47, 15, 5),
       (48, 15, 6),
       (49, 15, 7),
       (50, 15, 8),
       (51, 15, 9),
       (52, 15, 10),
       (53, 15, 11),
       (54, 15, 12),
       (55, 15, 13),
       (56, 16, 23),
       (57, 17, 1),
       (58, 17, 2),
       (59, 17, 3),
       (60, 17, 4),
       (61, 17, 5),
       (62, 17, 6),
       (63, 17, 7),
       (64, 17, 8),
       (65, 17, 9),
       (66, 17, 10),
       (67, 17, 11),
       (68, 17, 12),
       (69, 17, 13),
       (70, 18, 23),
       (71, 19, 1),
       (72, 19, 2),
       (73, 19, 3),
       (74, 19, 4),
       (75, 19, 5),
       (76, 19, 6),
       (77, 19, 7),
       (78, 19, 8),
       (79, 19, 9),
       (80, 19, 10),
       (81, 19, 11),
       (82, 19, 12),
       (83, 19, 13),
       (84, 20, 23),
       (86, 22, 31),
       (196, 22, 32),
       (194, 22, 33),
       (193, 22, 34),
       (197, 22, 38),
       (215, 22, 39),
       (214, 22, 40),
       (213, 22, 41),
       (199, 22, 42),
       (200, 22, 43),
       (198, 22, 44),
       (202, 22, 45),
       (204, 22, 46),
       (203, 22, 47),
       (201, 22, 48),
       (191, 22, 49),
       (192, 22, 50),
       (205, 22, 51),
       (207, 22, 52),
       (206, 22, 53),
       (211, 22, 54),
       (212, 22, 55),
       (210, 22, 56),
       (209, 22, 57),
       (208, 22, 58),
       (89, 23, 1),
       (90, 23, 2),
       (91, 23, 3),
       (92, 23, 4),
       (93, 23, 5),
       (94, 23, 6),
       (95, 23, 7),
       (96, 23, 8),
       (97, 23, 9),
       (98, 23, 10),
       (99, 23, 11),
       (100, 23, 12),
       (101, 23, 13),
       (102, 24, 23),
       (103, 25, 1),
       (104, 25, 2),
       (105, 25, 3),
       (106, 25, 4),
       (107, 25, 5),
       (108, 25, 6),
       (109, 25, 7),
       (110, 25, 8),
       (111, 25, 9),
       (112, 25, 10),
       (113, 25, 11),
       (114, 25, 12),
       (115, 25, 13),
       (116, 26, 23),
       (117, 27, 1),
       (118, 27, 2),
       (119, 27, 3),
       (120, 27, 4),
       (121, 27, 5),
       (122, 27, 6),
       (123, 27, 7),
       (124, 27, 8),
       (125, 27, 9),
       (126, 27, 10),
       (127, 27, 11),
       (128, 27, 12),
       (129, 27, 13),
       (130, 28, 23),
       (131, 29, 1),
       (132, 29, 2),
       (133, 29, 3),
       (134, 29, 4),
       (135, 29, 5),
       (136, 29, 6),
       (137, 29, 7),
       (138, 29, 8),
       (139, 29, 9),
       (140, 29, 10),
       (141, 29, 11),
       (142, 29, 12),
       (143, 29, 13),
       (144, 30, 23),
       (145, 31, 1),
       (146, 31, 2),
       (147, 31, 3),
       (148, 31, 4),
       (149, 31, 5),
       (150, 31, 6),
       (151, 31, 7),
       (152, 31, 8),
       (153, 31, 9),
       (154, 31, 10),
       (155, 31, 11),
       (156, 31, 12),
       (157, 31, 13),
       (158, 32, 23),
       (159, 33, 1),
       (160, 33, 2),
       (161, 33, 3),
       (162, 33, 4),
       (163, 33, 5),
       (164, 33, 6),
       (165, 33, 7),
       (166, 33, 8),
       (167, 33, 9),
       (168, 33, 10),
       (169, 33, 11),
       (170, 33, 12),
       (171, 33, 13),
       (172, 34, 23),
       (173, 35, 1),
       (174, 35, 2),
       (175, 35, 3),
       (176, 35, 4),
       (177, 35, 5),
       (178, 35, 6),
       (179, 35, 7),
       (180, 35, 8),
       (181, 35, 9),
       (182, 35, 10),
       (183, 35, 11),
       (184, 35, 12),
       (185, 35, 13),
       (186, 36, 23),
       (216, 38, 1),
       (217, 38, 2),
       (218, 38, 3),
       (219, 38, 4),
       (220, 38, 5),
       (221, 38, 6),
       (222, 38, 7),
       (223, 38, 8),
       (224, 38, 9),
       (225, 38, 10),
       (226, 38, 11),
       (227, 38, 12),
       (228, 38, 13),
       (229, 38, 14),
       (230, 38, 15),
       (231, 38, 16),
       (232, 38, 17),
       (233, 38, 18),
       (234, 38, 19),
       (235, 38, 20),
       (236, 38, 21),
       (237, 38, 22),
       (238, 38, 23),
       (239, 38, 24),
       (240, 38, 25),
       (241, 38, 26),
       (242, 38, 27),
       (243, 38, 28),
       (244, 38, 29),
       (245, 38, 30),
       (246, 38, 59),
       (247, 38, 60),
       (248, 38, 61),
       (249, 38, 62),
       (250, 38, 63),
       (251, 38, 64),
       (252, 38, 65),
       (253, 38, 66),
       (254, 38, 67),
       (255, 38, 68),
       (256, 38, 69),
       (257, 38, 70),
       (258, 38, 71),
       (259, 38, 72),
       (260, 38, 73),
       (261, 38, 74),
       (262, 38, 76),
       (263, 38, 77),
       (264, 38, 81),
       (265, 38, 82),
       (266, 38, 83),
       (267, 38, 84),
       (268, 38, 85),
       (269, 38, 86),
       (270, 38, 87),
       (272, 39, 3),
       (271, 39, 4),
       (273, 40, 1),
       (274, 40, 2),
       (275, 40, 3),
       (276, 40, 4),
       (277, 40, 5),
       (278, 40, 6),
       (279, 40, 7),
       (280, 40, 8),
       (281, 40, 9),
       (282, 40, 10),
       (283, 40, 11),
       (284, 40, 12),
       (285, 40, 13),
       (286, 40, 14),
       (287, 40, 15),
       (288, 40, 16),
       (289, 40, 17),
       (290, 40, 18),
       (291, 40, 19),
       (292, 40, 20),
       (293, 40, 21),
       (294, 40, 22),
       (295, 40, 23),
       (296, 40, 24),
       (297, 40, 25),
       (298, 40, 26),
       (299, 40, 27),
       (300, 40, 28),
       (301, 40, 29),
       (302, 40, 30),
       (303, 40, 59),
       (304, 40, 60),
       (305, 40, 61),
       (306, 40, 62),
       (307, 40, 63),
       (308, 40, 64),
       (309, 40, 65),
       (310, 40, 66),
       (311, 40, 67),
       (312, 40, 68),
       (313, 40, 69),
       (314, 40, 70),
       (315, 40, 71),
       (316, 40, 72),
       (317, 40, 73),
       (318, 40, 74),
       (319, 40, 76),
       (320, 40, 77),
       (321, 40, 81),
       (322, 40, 82),
       (323, 40, 83),
       (324, 40, 84),
       (325, 40, 85),
       (326, 40, 86),
       (327, 40, 87),
       (329, 41, 3),
       (328, 41, 4),
       (330, 46, 1),
       (331, 46, 2),
       (332, 46, 3),
       (333, 46, 4),
       (334, 46, 5),
       (335, 46, 6),
       (336, 46, 7),
       (337, 46, 8),
       (338, 46, 9),
       (339, 46, 10),
       (340, 46, 11),
       (341, 46, 12),
       (342, 46, 13),
       (343, 46, 14),
       (344, 46, 15),
       (345, 46, 16),
       (346, 46, 17),
       (347, 46, 18),
       (348, 46, 19),
       (349, 46, 20),
       (350, 46, 21),
       (351, 46, 22),
       (352, 46, 23),
       (353, 46, 24),
       (354, 46, 25),
       (355, 46, 26),
       (356, 46, 27),
       (357, 46, 28),
       (358, 46, 29),
       (359, 46, 30),
       (360, 46, 59),
       (361, 46, 60),
       (362, 46, 61),
       (363, 46, 62),
       (364, 46, 63),
       (365, 46, 64),
       (366, 46, 65),
       (367, 46, 66),
       (368, 46, 67),
       (369, 46, 68),
       (370, 46, 69),
       (371, 46, 70),
       (372, 46, 71),
       (373, 46, 72),
       (374, 46, 73),
       (375, 46, 74),
       (376, 46, 76),
       (377, 46, 77),
       (378, 46, 81),
       (379, 46, 82),
       (380, 46, 83),
       (381, 46, 84),
       (382, 46, 85),
       (383, 46, 86),
       (384, 46, 87),
       (386, 47, 3),
       (385, 47, 4),
       (387, 48, 1),
       (388, 48, 2),
       (389, 48, 3),
       (390, 48, 4),
       (391, 48, 5),
       (392, 48, 6),
       (393, 48, 7),
       (394, 48, 8),
       (395, 48, 9),
       (396, 48, 10),
       (397, 48, 11),
       (398, 48, 12),
       (399, 48, 13),
       (400, 48, 14),
       (401, 48, 15),
       (402, 48, 16),
       (403, 48, 17),
       (404, 48, 18),
       (405, 48, 19),
       (406, 48, 20),
       (407, 48, 21),
       (408, 48, 22),
       (409, 48, 23),
       (410, 48, 24),
       (411, 48, 25),
       (412, 48, 26),
       (413, 48, 27),
       (414, 48, 28),
       (415, 48, 29),
       (416, 48, 30),
       (417, 48, 59),
       (418, 48, 60),
       (419, 48, 61),
       (420, 48, 62),
       (421, 48, 63),
       (422, 48, 64),
       (423, 48, 65),
       (424, 48, 66),
       (425, 48, 67),
       (426, 48, 68),
       (427, 48, 69),
       (428, 48, 70),
       (429, 48, 71),
       (430, 48, 72),
       (431, 48, 73),
       (432, 48, 74),
       (433, 48, 76),
       (434, 48, 77),
       (435, 48, 81),
       (436, 48, 82),
       (437, 48, 83),
       (438, 48, 84),
       (439, 48, 85),
       (440, 48, 86),
       (441, 48, 87),
       (443, 49, 3),
       (442, 49, 4);

/*!40000 ALTER TABLE `authorization_role_privilege`
    ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table bundle
# ------------------------------------------------------------

DROP TABLE IF EXISTS `bundle`;

CREATE TABLE `bundle`
(
    `ID`                   bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `NAME`                 varchar(50)  DEFAULT NULL COMMENT '套餐名称',
    `CODE`                 varchar(50)  DEFAULT NULL COMMENT '套餐编码',
    `TENANT_TYPE_CODE`     varchar(50)  DEFAULT NULL COMMENT '租户类型编码',
    `ABILITY`              longtext COMMENT '套餐包含功能描述,JSON格式的角色与权限',
    `NUMBER_OF_INVOCATION` int(11)    NOT NULL COMMENT 'API调用次数/月',
    `NUMBER_OF_CONCURRENT` int(11)    NOT NULL COMMENT '并发数/秒',
    `NUMBER_OF_APP`        int(11)    NOT NULL COMMENT '允许创建应用数量',
    `COMMENT`              varchar(200) DEFAULT NULL COMMENT '套餐说明',
    `INITIALIZE`           int(1)       DEFAULT NULL COMMENT '是否为初始化套餐',
    PRIMARY KEY (`ID`) USING BTREE,
    UNIQUE KEY `bundle_unq_code` (`CODE`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  ROW_FORMAT = DYNAMIC;

LOCK TABLES `bundle` WRITE;
/*!40000 ALTER TABLE `bundle`
    DISABLE KEYS */;

INSERT INTO `bundle` (`ID`, `NAME`, `CODE`, `TENANT_TYPE_CODE`, `ABILITY`, `NUMBER_OF_INVOCATION`,
                      `NUMBER_OF_CONCURRENT`, `NUMBER_OF_APP`, `COMMENT`, `INITIALIZE`)
VALUES (1, '系统管理根租户初始化套餐', 'admin', 'admin', NULL, 0, 0, 0, NULL, 1),
       (2, '聚合支付-商户初始化版', 'aggregate-pay-merchant', 'aggregate-pay-merchant',
        '[{\"name\":\"商户管理员\",\"code\": \"r_001\",\"privilegeCodes\": [\"sj_m_console\",\"sj_m_app_list\",\"sj_m_transaction_list\",\"sj_m_account_check\",\"sj_m_payment\",\"sj_m_account_list\",\"sj_m_enterprise_auth\",\"sj_m_store_list\",\"sj_m_staff_list\",\"sj_o_member_list\",\"sj_o_entreprise_list\",\"sj_o_audit\",\"sj_o_service_type\",\"sj_o_account_check\",\"sj_o_admin_list\",\"sj_o_role_list\",\"sj_m_app_create\",\"sj_m_payment_set\",\"sj_m_store_create\",\"sj_m_store_query\",\"sj_m_staff_create\",\"sj_m_staff_query\",\"sj_o_member_query\",\"sj_o_enterprise_query\",\"sj_o_enterprise_create\",\"sj_o_service_create\",\"sj_o_service_query\",\"sj_o_admin_create\",\"sj_o_admin_query\",\"sj_o_role_create\",\"sj_o_role_query\",\"sj_o_role_save\",\"sj_m_auth_apply\",\"sj_m_console_renew\",\"sj_m_console_upgrade\",\"sj_m_app_save\",\"sj_m_app_modify\",\"sj_m_payparam_save\",\"sj_m_pay_set\",\"sj_m_pay_save\",\"sj_m_c2b_qrcode\",\"sj_m_b2c_order\",\"sj_m_h5_view\",\"sj_m_bundle_buy\",\"sj_m_enterprise_info_submit\",\"sj_m_enterprise_info_cancel\",\"sj_o_enterprise_auth_pass\",\"sj_o_enterprise_auth_rejection\",\"sj_m_store_edit\",\"sj_m_staff_edit\",\"sj_o_admin_edit\",\"sj_o_role_edit\",\"sj_m_store_save\",\"sj_m_store_del\",\"sj_m_staff_save\"]},{\"name\": \"商户门店收银员\",\"code\": \"r_002\",\"privilegeCodes\": [\"sj_m_account_check\",\"sj_m_transaction_list\"]}]',
        1000, 10, 1, NULL, 1);

/*!40000 ALTER TABLE `bundle`
    ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table resource_application
# ------------------------------------------------------------

DROP TABLE IF EXISTS `resource_application`;

CREATE TABLE `resource_application`
(
    `ID`        bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `NAME`      varchar(50) DEFAULT NULL COMMENT '应用名称',
    `CODE`      varchar(50) DEFAULT NULL COMMENT '应用编码',
    `TENANT_ID` bigint(20)  DEFAULT NULL COMMENT '租户id',
    PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  ROW_FORMAT = DYNAMIC COMMENT ='应用信息';

LOCK TABLES `resource_application` WRITE;
/*!40000 ALTER TABLE `resource_application`
    DISABLE KEYS */;

INSERT INTO `resource_application` (`ID`, `NAME`, `CODE`, `TENANT_ID`)
VALUES (1, '聚合支付-商户平台', 'merchant-platform', 1),
       (2, '聚合支付-运营平台', 'operation-platform', 1),
       (3, '门户', 'portal-site', 1),
       (4, '商户平台app版', 'merchant-platform-app', 1);

/*!40000 ALTER TABLE `resource_application`
    ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table resource_button
# ------------------------------------------------------------

DROP TABLE IF EXISTS `resource_button`;

CREATE TABLE `resource_button`
(
    `ID`               bigint(20)  NOT NULL AUTO_INCREMENT COMMENT '主键',
    `PARENT_ID`        bigint(20)   DEFAULT NULL COMMENT '父id',
    `TITLE`            varchar(50) NOT NULL COMMENT '按钮标题',
    `URL`              varchar(200) DEFAULT NULL COMMENT '链接url',
    `ICON`             varchar(50)  DEFAULT NULL COMMENT '图标',
    `SORT`             int(11)     NOT NULL COMMENT '排序',
    `COMMENT`          varchar(200) DEFAULT NULL COMMENT '说明',
    `STATUS`           int(11)     NOT NULL COMMENT '状态',
    `APPLICATION_CODE` varchar(50)  DEFAULT NULL COMMENT '所属应用编码',
    `PRIVILEGE_CODE`   varchar(50)  DEFAULT NULL COMMENT '绑定权限',
    `PCODE`            varchar(200) DEFAULT NULL COMMENT '用于鉴权',
    PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  ROW_FORMAT = DYNAMIC COMMENT ='按钮资源';

LOCK TABLES `resource_button` WRITE;
/*!40000 ALTER TABLE `resource_button`
    DISABLE KEYS */;

INSERT INTO `resource_button` (`ID`, `PARENT_ID`, `TITLE`, `URL`, `ICON`, `SORT`, `COMMENT`, `STATUS`,
                               `APPLICATION_CODE`, `PRIVILEGE_CODE`, `PCODE`)
VALUES (1241761810982985001, NULL, '工作台-升级', NULL, NULL, 2, NULL, 1, 'merchant-platform', 'sj_m_console_upgrade',
        'sj_m_console_upgrade'),
       (1241761810982985002, NULL, '工作台-续费', NULL, NULL, 1, NULL, 1, 'merchant-platform', 'sj_m_console_renew',
        'sj_m_console_renew'),
       (1241761810982985003, NULL, '创建应用', NULL, NULL, 1, NULL, 1, 'merchant-platform', 'sj_m_app_create',
        'sj_m_app_create'),
       (1241761810982985004, NULL, '保存应用', NULL, NULL, 1, NULL, 1, 'merchant-platform', 'sj_m_app_save',
        'sj_m_app_save'),
       (1241761810982985005, NULL, '编辑应用', NULL, NULL, 1, NULL, 1, 'merchant-platform', 'sj_m_app_edit',
        'sj_m_app_edit'),
       (1241761810982985010, NULL, '支付参数保存', NULL, NULL, 1, NULL, 1, 'merchant-platform', 'sj_m_payparam_save',
        'sj_m_payparam_save'),
       (1241761810982985011, NULL, '设置默认支付', NULL, NULL, 1, NULL, 1, 'merchant-platform', 'sj_m_pay_set',
        'sj_m_pay_set'),
       (1241761810982985012, NULL, '保存默认支付', NULL, NULL, 1, NULL, 1, 'merchant-platform', 'sj_m_pay_save',
        'sj_m_pay_save'),
       (1241761810982985013, NULL, 'C扫B二维码', NULL, NULL, 1, NULL, 1, 'merchant-platform', 'sj_m_c2b_qrcode',
        'sj_m_c2b_qrcode'),
       (1241761810982985014, NULL, 'B扫C订单', NULL, NULL, 1, NULL, 1, 'merchant-platform', 'sj_m_b2c_order',
        'sj_m_b2c_order'),
       (1241761810982985015, NULL, '购买套餐', NULL, NULL, 1, NULL, 1, 'merchant-platform', 'sj_m_bundle_buy',
        'sj_m_bundle_buy'),
       (1241761810982985017, NULL, '企业认证资料提交', NULL, NULL, 1, NULL, 1, 'merchant-platform',
        'sj_m_enterprise_info_submit', 'sj_m_enterprise_info_submit'),
       (1241761810982985018, NULL, '会员查询', NULL, NULL, 1, NULL, 1, 'merchant-platform', 'sj_o_member_query',
        'sj_o_member_query'),
       (1241761810982985019, NULL, '审核管理企业查询', NULL, NULL, 1, NULL, 1, 'merchant-platform', 'sj_o_enterprise_query',
        'sj_o_enterprise_query'),
       (1241761810982985021, NULL, '门店管理-新建按钮', NULL, NULL, 1, NULL, 1, 'merchant-platform', 'sj_m_store_create',
        'sj_m_store_create'),
       (1241761810982985022, NULL, '门店管理-编辑按钮', NULL, NULL, 1, NULL, 1, 'merchant-platform', 'sj_m_store_edit',
        'sj_m_store_edit'),
       (1241761810982985023, NULL, '门店管理-删除按钮', NULL, NULL, 1, NULL, 1, 'merchant-platform', 'sj_m_store_del',
        'sj_m_store_del'),
       (1241761810982985024, NULL, '门店管理-查询按钮', NULL, NULL, 1, NULL, 1, 'merchant-platform', 'sj_m_store_query',
        'sj_m_store_query'),
       (1241761810982985025, NULL, '门店管理-保存按钮', NULL, NULL, 1, NULL, 1, 'merchant-platform', 'sj_m_store_save',
        'sj_m_store_save'),
       (1241761810982985026, NULL, '成员管理-新建按钮', NULL, NULL, 1, NULL, 1, 'merchant-platform', 'sj_m_staff_create',
        'sj_m_staff_create'),
       (1241761810982985027, NULL, '成员管理-编辑按钮', NULL, NULL, 1, NULL, 1, 'merchant-platform', 'sj_m_staff_edit',
        'sj_m_staff_edit'),
       (1241761810982985029, NULL, '课程管理-课程审核', NULL, NULL, 1, NULL, 1, NULL, 'p_xc_c_001', NULL),
       (1241761810982985030, NULL, '媒资管理-审核媒体资质', NULL, NULL, 1, NULL, 1, NULL, 'p_xc_m_001', NULL),
       (1241761810982985031, NULL, '机构管理-审核机构', NULL, NULL, 1, NULL, 1, NULL, 'p_xc_t_001', NULL);

/*!40000 ALTER TABLE `resource_button`
    ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table resource_menu
# ------------------------------------------------------------

DROP TABLE IF EXISTS `resource_menu`;

CREATE TABLE `resource_menu`
(
    `ID`               bigint(20)  NOT NULL AUTO_INCREMENT COMMENT '主键',
    `PARENT_ID`        bigint(20)   DEFAULT NULL COMMENT '父id',
    `TITLE`            varchar(50) NOT NULL COMMENT '菜单标题',
    `URL`              varchar(200) DEFAULT NULL COMMENT '链接url',
    `ICON`             varchar(50)  DEFAULT NULL COMMENT '图标',
    `SORT`             int(11)     NOT NULL COMMENT '排序',
    `COMMENT`          varchar(200) DEFAULT NULL COMMENT '说明',
    `STATUS`           int(11)     NOT NULL COMMENT '状态',
    `APPLICATION_CODE` varchar(50)  DEFAULT NULL COMMENT '所属应用编码',
    `PRIVILEGE_CODE`   varchar(50)  DEFAULT NULL COMMENT '绑定权限',
    `PCODE`            varchar(200) DEFAULT NULL COMMENT '用于鉴权',
    PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  ROW_FORMAT = DYNAMIC COMMENT ='菜单';

LOCK TABLES `resource_menu` WRITE;
/*!40000 ALTER TABLE `resource_menu`
    DISABLE KEYS */;

INSERT INTO `resource_menu` (`ID`, `PARENT_ID`, `TITLE`, `URL`, `ICON`, `SORT`, `COMMENT`, `STATUS`, `APPLICATION_CODE`,
                             `PRIVILEGE_CODE`, `PCODE`)
VALUES (1, NULL, '商户后台', NULL, NULL, 1, NULL, 1, '', NULL, NULL),
       (2, NULL, '运营商后台', NULL, NULL, 1, NULL, 1, '', NULL, NULL),
       (3, NULL, '门户', NULL, NULL, 1, NULL, 1, '', NULL, NULL),
       (4, 1, '工作台', NULL, NULL, 1, NULL, 1, 'merchant-platform', 'sj_m_console', 'sj_m_console'),
       (5, 1, '应用管理', NULL, NULL, 2, NULL, 1, 'merchant-platform', '', ''),
       (6, 1, '账户管理', NULL, NULL, 3, NULL, 1, 'merchant-platform', NULL, NULL),
       (7, 1, '组织管理', NULL, NULL, 4, NULL, 1, 'merchant-platform', NULL, NULL),
       (8, 2, '企业管理', NULL, NULL, 1, NULL, 1, 'merchant-platform', '', NULL),
       (9, 2, '服务类型管理', NULL, NULL, 2, NULL, 1, 'merchant-platform', '', NULL),
       (10, 2, '账单管理', NULL, NULL, 3, NULL, 1, 'merchant-platform', '', NULL),
       (11, 2, '系统管理', NULL, NULL, 4, NULL, 1, 'merchant-platform', '', NULL),
       (12, 5, '应用管理列表', NULL, NULL, 1, NULL, 1, 'merchant-platform', 'sj_m_app_list', 'sj_m_app_list'),
       (13, 5, '应用交易总览', NULL, NULL, 2, NULL, 1, 'merchant-platform', 'sj_m_transaction_list', 'sj_m_transaction_list'),
       (14, 5, '应用财务对账', NULL, NULL, 3, NULL, 1, 'merchant-platform', 'sj_m_account_check', 'sj_m_account_check'),
       (15, 5, '开始支付', NULL, NULL, 4, NULL, 1, 'merchant-platform', 'sj_m_payment', 'sj_m_payment'),
       (16, 6, '账户中心', NULL, NULL, 1, NULL, 1, 'merchant-platform', 'sj_m_account_list', 'sj_m_account_list'),
       (17, 6, '企业认证申请', NULL, NULL, 2, NULL, 1, 'merchant-platform', 'sj_m_enterprise_auth', 'sj_m_enterprise_auth'),
       (18, 7, '门店管理', NULL, NULL, 1, NULL, 1, 'merchant-platform', 'sj_m_store_list', 'sj_m_store_list'),
       (19, 7, '成员管理', NULL, NULL, 2, NULL, 1, 'merchant-platform', 'sj_m_staff_list', 'sj_m_staff_list'),
       (20, 8, '会员管理', NULL, NULL, 1, NULL, 1, 'operation-platform', 'sj_o_member_list', 'sj_o_member_list'),
       (21, 8, '企业管理', NULL, NULL, 2, NULL, 1, 'operation-platform', 'sj_o_entreprise_list', 'sj_o_entreprise_list'),
       (22, 8, '审核管理', NULL, NULL, 3, NULL, 1, 'operation-platform', 'sj_o_audit', 'sj_o_audit'),
       (23, 9, '服务类型管理', NULL, NULL, 1, NULL, 1, 'operation-platform', 'sj_o_service_type', 'sj_o_service_type'),
       (24, 10, '往来对账', NULL, NULL, 1, NULL, 1, 'operation-platform', 'sj_o_account_check', 'sj_o_account_check'),
       (25, 11, '管理员管理', NULL, NULL, 1, NULL, 1, 'operation-platform', 'sj_o_admin_list', 'sj_o_admin_list'),
       (26, 11, '角色管理', NULL, NULL, 2, NULL, 1, 'operation-platform', 'sj_o_role_list', 'sj_o_role_list');

/*!40000 ALTER TABLE `resource_menu`
    ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table tenant
# ------------------------------------------------------------

DROP TABLE IF EXISTS `tenant`;

CREATE TABLE `tenant`
(
    `ID`               bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `NAME`             varchar(512) DEFAULT NULL COMMENT '租户名称',
    `TENANT_TYPE_CODE` varchar(50)  DEFAULT NULL COMMENT '租户类型编码',
    `BUNDLE_CODE`      varchar(50)  DEFAULT NULL COMMENT '购买套餐编码',
    PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  ROW_FORMAT = DYNAMIC;

LOCK TABLES `tenant` WRITE;
/*!40000 ALTER TABLE `tenant`
    DISABLE KEYS */;

INSERT INTO `tenant` (`ID`, `NAME`, `TENANT_TYPE_CODE`, `BUNDLE_CODE`)
VALUES (1, '根租户', 'admin', 'admin');

/*!40000 ALTER TABLE `tenant`
    ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table tenant_account
# ------------------------------------------------------------

DROP TABLE IF EXISTS `tenant_account`;

CREATE TABLE `tenant_account`
(
    `ID`         bigint(20) NOT NULL AUTO_INCREMENT,
    `TENANT_ID`  bigint(20) DEFAULT NULL COMMENT '租户id',
    `ACCOUNT_ID` bigint(20) DEFAULT NULL COMMENT '账号d',
    `IS_ADMIN`   tinyint(1) DEFAULT NULL COMMENT '是否是租户管理员',
    PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  ROW_FORMAT = DYNAMIC;



# Dump of table tenant_type
# ------------------------------------------------------------

DROP TABLE IF EXISTS `tenant_type`;

CREATE TABLE `tenant_type`
(
    `ID`   bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `NAME` varchar(50) DEFAULT NULL COMMENT '租户类型名称',
    `CODE` varchar(50) DEFAULT NULL COMMENT '租户类型编码',
    PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  ROW_FORMAT = DYNAMIC;

LOCK TABLES `tenant_type` WRITE;
/*!40000 ALTER TABLE `tenant_type`
    DISABLE KEYS */;

INSERT INTO `tenant_type` (`ID`, `NAME`, `CODE`)
VALUES (1, '系统管理组织', 'admin'),
       (2, '聚合支付-运营商', 'aggregate-pay-operation'),
       (3, '聚合支付-签约商户', 'aggregate-pay-merchant');

/*!40000 ALTER TABLE `tenant_type`
    ENABLE KEYS */;
UNLOCK TABLES;
