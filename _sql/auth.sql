SET FOREIGN_KEY_CHECKS = 0;
-- ----------------------------
-- Table structure for `auth_menu`
-- ----------------------------
DROP TABLE IF EXISTS `auth_menu`;
CREATE TABLE `auth_menu`
(
    `id`          bigint(20)  NOT NULL COMMENT '主键',
    `name`        varchar(20) NOT NULL DEFAULT '' COMMENT '菜单名称',
    `describe_`   varchar(200)         DEFAULT '' COMMENT '功能描述',
    `is_public`   bit(1)               DEFAULT b'0' COMMENT '是否公开菜单\r\n就是无需分配就可以访问的。所有人可见',
    `path`        varchar(255)         DEFAULT '' COMMENT '对应路由path',
    `component`   varchar(255)         DEFAULT NULL COMMENT '对应路由组件component',
    `is_enable`   bit(1)               DEFAULT b'1' COMMENT '状态',
    `sort_value`  int(11)              DEFAULT '1' COMMENT '排序',
    `icon`        varchar(255)         DEFAULT '' COMMENT '菜单图标',
    `group_`      varchar(20)          DEFAULT '' COMMENT '菜单分组',
    `parent_id`   bigint(20)           DEFAULT '0' COMMENT '父级菜单id',
    `create_user` bigint(20)           DEFAULT NULL COMMENT '创建人id',
    `create_time` datetime             DEFAULT NULL COMMENT '创建时间',
    `update_user` bigint(20)           DEFAULT NULL COMMENT '更新人id',
    `update_time` datetime             DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE,
    KEY `INX_STATUS` (`is_enable`, `is_public`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  ROW_FORMAT = COMPACT COMMENT ='菜单';

-- ----------------------------
-- Records of auth_menu
-- ----------------------------
INSERT INTO `auth_menu`
VALUES ('101', '系统管理', '系统管理', '\0', '/user', '/user/Index', '', '0', 'el-icon-user-solid', '', '0', '1',
        '2019-07-25 15:35:12', '3', '2020-01-09 19:23:12');
INSERT INTO `auth_menu`
VALUES ('104', '监控管理', '开发者', '\0', '/developer', '/developer/Index', '', '3', 'el-icon-user-solid', '', '0', '1',
        '2019-11-11 14:38:34', '3', '2020-01-09 19:22:52');
INSERT INTO `auth_menu`
VALUES ('603976297063910529', '菜单配置', '', '\0', '/auth/menu', '/auth/menu/Index', '', '3', '', '', '101', '1',
        '2019-07-25 15:46:11', '3', '2019-11-11 14:31:52');
INSERT INTO `auth_menu`
VALUES ('603981723864141121', '角色管理', '', '\0', '/auth/role', '/auth/role/Index', '', '4', '', '', '101', '1',
        '2019-07-25 16:07:45', '3', '2019-11-11 14:31:57');
INSERT INTO `auth_menu`
VALUES ('603982542332235201', '组织管理', '', '\0', '/user/org', '/user/org/Index', '', '0', '', '', '101', '1',
        '2019-07-25 16:11:00', '3', '2020-01-11 08:51:22');
INSERT INTO `auth_menu`
VALUES ('603982713849908801', '岗位管理', '', '\0', '/user/station', '/user/station/Index', '', '1', '', '', '101', '1',
        '2019-07-25 16:11:41', '3', '2019-11-11 14:28:43');
INSERT INTO `auth_menu`
VALUES ('603983082961243905', '用户管理', '', '\0', '/user/user', '/user/user/Index', '', '2', '', '', '101', '1',
        '2019-07-25 16:13:09', '3', '2020-01-09 19:27:02');
INSERT INTO `auth_menu`
VALUES ('605078672772170209', '操作日志', '', '\0', '/developer/optLog', '/developer/optLog/Index', '', '3', '', '', '104',
        '1', '2019-07-28 16:46:38', '3', '2019-11-11 14:35:14');
INSERT INTO `auth_menu`
VALUES ('605078979149300257', '数据库监控', '', '\0', '/developer/db', '/developer/db/Index', '\0', '2', '', '', '104', '1',
        '2019-07-28 16:47:51', '3', '2020-01-10 10:40:42');
INSERT INTO `auth_menu`
VALUES ('605079239015793249', '接口文档', '', '\0', 'http://39.100.244.120:8760/api/gate/doc.html', 'Layout', '', '5', '',
        '', '104', '1', '2019-07-28 16:48:53', '3', '2020-01-10 10:33:23');
INSERT INTO `auth_menu`
VALUES ('605079411338773153', '注册配置中心', '', '\0', 'http://localhost:8848/nacos', 'Layout', '\0', '6', '', '', '104',
        '1', '2019-07-28 16:49:34', '3', '2020-01-10 10:40:47');
INSERT INTO `auth_menu`
VALUES ('645215230518909025', '登录日志', '', '\0', '/developer/loginLog', '/developer/loginLog/Index', '', '4', '', '',
        '104', '3', '2019-11-16 10:54:59', '3', '2019-11-16 10:54:59');
INSERT INTO `auth_menu`
VALUES ('667033750256747169', '文件管理', '', '\0', '/file/attachment', '/file/attachment/Index', '\0', '5', '', '', '101',
        '3', '2020-01-15 15:53:59', '3', '2020-02-05 08:47:15');
INSERT INTO `auth_menu`
VALUES ('676762150244450433', '接口路由', '', '\0', '/ofpay', '/ofpay/Index', '', '10', 'el-icon-guide', '', '0', '3',
        '2020-02-11 12:11:10', '3', '2020-02-11 12:11:10');
INSERT INTO `auth_menu`
VALUES ('676762509503365569', '调用记录', '', '\0', '/ofpay/receive', '/ofpay/receive/Index', '', '0', '', '',
        '676762150244450433', '3', '2020-02-11 12:12:36', '3', '2020-02-11 12:14:24');
INSERT INTO `auth_menu`
VALUES ('676762719185011233', '请求记录', '', '\0', '/ofpay/send', '/ofpay/send/Index', '', '1', '', '',
        '676762150244450433', '3', '2020-02-11 12:13:26', '3', '2020-02-11 12:13:26');
INSERT INTO `auth_menu`
VALUES ('680085395794296897', '平台管理', '', '\0', '/ofpay/platform', '/ofpay/platform/Index', '', '2', '', '',
        '676762150244450433', '3', '2020-02-20 16:16:34', '3', '2020-02-20 18:24:30');
INSERT INTO `auth_menu`
VALUES ('681133179561574689', '客户管理', '1', '\0', '/ofpay/customer', '/ofpay/customer/Index', '', '3', '', '',
        '676762150244450433', '3', '2020-02-23 13:40:05', '3', '2020-03-01 18:31:12');

-- ----------------------------
-- Table structure for `auth_resource`
-- ----------------------------
DROP TABLE IF EXISTS `auth_resource`;
CREATE TABLE `auth_resource`
(
    `id`          bigint(20)   NOT NULL COMMENT 'ID',
    `code`        varchar(150)          DEFAULT '' COMMENT '资源编码\n规则：\n链接：\n数据列：\n按钮：',
    `name`        varchar(150) NOT NULL DEFAULT '' COMMENT '接口名称',
    `menu_id`     bigint(20)            DEFAULT NULL COMMENT '菜单ID\n#c_auth_menu',
    `method`      varchar(10)           DEFAULT NULL,
    `url`         varchar(255)          DEFAULT NULL,
    `describe_`   varchar(255)          DEFAULT '' COMMENT '接口描述',
    `create_user` bigint(20)            DEFAULT NULL COMMENT '创建人id',
    `create_time` datetime              DEFAULT NULL COMMENT '创建时间',
    `update_user` bigint(20)            DEFAULT NULL COMMENT '更新人id',
    `update_time` datetime              DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `UN_CODE` (`code`) USING BTREE COMMENT '编码唯一'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  ROW_FORMAT = COMPACT COMMENT ='资源';

-- ----------------------------
-- Records of auth_resource
-- ----------------------------
INSERT INTO `auth_resource`
VALUES ('643444685339100193', 'org:add', '添加', '603982542332235201', 'POST', '/org', '', '3', '2019-11-11 13:39:28',
        '3', '2019-11-11 13:39:50');
INSERT INTO `auth_resource`
VALUES ('643444685339100194', 'role:config', '配置', '603981723864141121', 'POST', '/role/authority', '', '3',
        '2019-11-11 13:39:28', '3', '2020-03-03 19:57:51');
INSERT INTO `auth_resource`
VALUES ('643444685339100195', 'resource:add', '添加', '603976297063910529', 'POST', '/resource', '', '3',
        '2019-11-11 13:39:28', '3', '2019-11-11 13:39:50');
INSERT INTO `auth_resource`
VALUES ('643444685339100196', 'resource:update', '修改', '603976297063910529', 'PUT', '/resource', '', '3',
        '2019-11-11 13:39:28', '3', '2019-11-11 13:39:50');
INSERT INTO `auth_resource`
VALUES ('643444685339100197', 'resource:delete', '删除', '603976297063910529', 'DELETE', '/resource', '', '3',
        '2019-11-11 13:39:28', '3', '2019-11-11 13:39:50');
INSERT INTO `auth_resource`
VALUES ('643444819758154945', 'org:update', '修改', '603982542332235201', 'PUT', '/org', '', '3', '2019-11-11 13:40:00',
        '3', '2019-11-11 13:40:00');
INSERT INTO `auth_resource`
VALUES ('643444858974897441', 'org:delete', '删除', '603982542332235201', 'DELETE', '/org', '', '3',
        '2019-11-11 13:40:09', '3', '2019-11-11 13:40:09');
INSERT INTO `auth_resource`
VALUES ('643444897201784193', 'org:view', '查询', '603982542332235201', 'GET', '/org/tree', '', '3',
        '2019-11-11 13:40:18', '3', '2020-03-03 19:53:41');
INSERT INTO `auth_resource`
VALUES ('643444992357959137', 'org:import', '导入', '603982542332235201', 'POST', '/org', '', '3', '2019-11-11 13:40:41',
        '3', '2019-11-11 13:40:41');
INSERT INTO `auth_resource`
VALUES ('643445016773002817', 'org:export', '导出', '603982542332235201', 'GET', '/org', '', '3', '2019-11-11 13:40:47',
        '3', '2019-11-11 13:40:47');
INSERT INTO `auth_resource`
VALUES ('643445116756821697', 'station:add', '添加', '603982713849908801', 'POST', '/station', '', '3',
        '2019-11-11 13:41:11', '3', '2019-11-11 13:41:11');
INSERT INTO `auth_resource`
VALUES ('643445162915137313', 'station:update', '修改', '603982713849908801', 'PUT', '/station', '', '3',
        '2019-11-11 13:41:22', '3', '2019-11-11 13:41:22');
INSERT INTO `auth_resource`
VALUES ('643445197954353025', 'station:delete', '删除', '603982713849908801', 'DELETE', '/station', '', '3',
        '2019-11-11 13:41:30', '3', '2019-11-11 13:41:30');
INSERT INTO `auth_resource`
VALUES ('643445229575210977', 'station:view', '查看', '603982713849908801', 'GET', '/station/page', '', '3',
        '2019-11-11 13:41:38', '3', '2020-03-03 19:54:12');
INSERT INTO `auth_resource`
VALUES ('643445262110427201', 'station:export', '导出', '603982713849908801', 'GET', '/station', '', '3',
        '2019-11-11 13:41:45', '3', '2019-11-11 13:41:45');
INSERT INTO `auth_resource`
VALUES ('643445283996305569', 'station:import', '导入', '603982713849908801', 'POST', '/station', '', '3',
        '2019-11-11 13:41:51', '3', '2019-11-11 13:41:51');
INSERT INTO `auth_resource`
VALUES ('643445352703199521', 'user:add', '添加', '603983082961243905', 'POST', '/user', '', '3', '2019-11-11 13:42:07',
        '3', '2019-11-11 13:42:07');
INSERT INTO `auth_resource`
VALUES ('643445412774021505', 'user:update', '修改', '603983082961243905', 'PUT', '/user', '', '3', '2019-11-11 13:42:21',
        '3', '2019-11-11 13:42:21');
INSERT INTO `auth_resource`
VALUES ('643445448081672673', 'user:delete', '删除', '603983082961243905', 'DELETE', '/user', '', '3',
        '2019-11-11 13:42:30', '3', '2019-11-11 13:42:30');
INSERT INTO `auth_resource`
VALUES ('643445477274028609', 'user:view', '查看', '603983082961243905', 'GET', '/user/page', '', '3',
        '2019-11-11 13:42:37', '3', '2020-03-03 19:54:41');
INSERT INTO `auth_resource`
VALUES ('643445514607528609', 'user:import', '导入', '603983082961243905', 'POST', '/user', '', '3',
        '2019-11-11 13:42:46', '3', '2019-11-11 13:42:46');
INSERT INTO `auth_resource`
VALUES ('643445542076025601', 'user:export', '导出', '603983082961243905', 'GET', '/user', '', '3', '2019-11-11 13:42:52',
        '3', '2019-11-11 13:42:52');
INSERT INTO `auth_resource`
VALUES ('643445641149680705', 'menu:add', '添加', '603976297063910529', 'POST', '/menu', '', '3', '2019-11-11 13:43:16',
        '3', '2019-11-11 13:43:16');
INSERT INTO `auth_resource`
VALUES ('643445674330819745', 'menu:update', '修改', '603976297063910529', 'PUT', '/menu', '', '3', '2019-11-11 13:43:24',
        '3', '2019-11-11 13:43:24');
INSERT INTO `auth_resource`
VALUES ('643445704177487105', 'menu:delete', '删除', '603976297063910529', 'DELETE', '/menu', '', '3',
        '2019-11-11 13:43:31', '3', '2019-11-11 13:43:31');
INSERT INTO `auth_resource`
VALUES ('643445747320098145', 'menu:view', '查看', '603976297063910529', 'GET', '/menu/tree', '', '3',
        '2019-11-11 13:43:41', '3', '2020-03-03 19:55:10');
INSERT INTO `auth_resource`
VALUES ('643445774687931841', 'menu:export', '导出', '603976297063910529', 'GET', '/menu', '', '3', '2019-11-11 13:43:48',
        '3', '2019-11-11 13:43:48');
INSERT INTO `auth_resource`
VALUES ('643445802106097185', 'menu:import', '导入', '603976297063910529', 'POST', '/menu', '', '3',
        '2019-11-11 13:43:54', '3', '2019-11-11 13:43:54');
INSERT INTO `auth_resource`
VALUES ('643448338154263521', 'role:add', '添加', '603981723864141121', 'POST', '/role', '', '3', '2019-11-11 13:53:59',
        '3', '2019-11-11 13:53:59');
INSERT INTO `auth_resource`
VALUES ('643448369779315777', 'role:update', '修改', '603981723864141121', 'PUT', '/role', '', '3', '2019-11-11 13:54:06',
        '3', '2019-11-11 13:54:06');
INSERT INTO `auth_resource`
VALUES ('643448507767723169', 'role:delete', '删除', '603981723864141121', 'DELETE', '/role', '', '3',
        '2019-11-11 13:54:39', '3', '2019-11-11 13:54:39');
INSERT INTO `auth_resource`
VALUES ('643448611161511169', 'role:view', '查看', '603981723864141121', 'GET', '/role/page', '', '3',
        '2019-11-11 13:55:04', '3', '2020-03-03 19:55:44');
INSERT INTO `auth_resource`
VALUES ('643448656451605857', 'role:export', '导出', '603981723864141121', 'GET', '/role', '', '3', '2019-11-11 13:55:15',
        '3', '2019-11-11 13:55:15');
INSERT INTO `auth_resource`
VALUES ('643448730950833601', 'role:import', '导入', '603981723864141121', 'POST', '/role', '', '3',
        '2019-11-11 13:55:32', '3', '2019-11-11 13:55:32');
INSERT INTO `auth_resource`
VALUES ('643448826945869409', 'role:auth', '授权', '603981723864141121', 'POST', '/role/user', '', '3',
        '2019-11-11 13:55:55', '3', '2020-03-03 19:57:57');
INSERT INTO `auth_resource`
VALUES ('643450770317909249', 'optLog:view', '查看', '605078672772170209', 'GET', '/optLog', '', '3',
        '2019-11-11 14:03:39', '3', '2019-11-11 14:03:39');
INSERT INTO `auth_resource`
VALUES ('643450853134441825', 'optLog:export', '导出', '605078672772170209', 'GET', '/optLog', '', '3',
        '2019-11-11 14:03:58', '3', '2019-11-11 14:03:58');
INSERT INTO `auth_resource`
VALUES ('645288214990422241', 'optLog:delete', '删除', '605078672772170209', 'DELETE', '/optLog', '', '3',
        '2019-11-16 15:45:00', '3', '2019-11-16 15:45:00');
INSERT INTO `auth_resource`
VALUES ('645288283693121889', 'loginLog:delete', '删除', '645215230518909025', 'DELETE', '/loginLog', '', '3',
        '2019-11-16 15:45:16', '3', '2019-11-16 15:45:16');
INSERT INTO `auth_resource`
VALUES ('645288375300915649', 'loginLog:export', '导出', '645215230518909025', 'GET', '/loginLog', '', '3',
        '2019-11-16 15:45:38', '3', '2019-11-16 15:45:38');
INSERT INTO `auth_resource`
VALUES ('667033832750318369', 'file:add', '添加', '667033750256747169', 'POST', '/file', '', '3', '2020-01-15 15:54:19',
        '3', '2020-01-15 15:54:19');
INSERT INTO `auth_resource`
VALUES ('667033888949797761', 'file:update', '修改', '667033750256747169', 'PUT', '/file', '', '3', '2020-01-15 15:54:32',
        '3', '2020-01-15 15:54:32');
INSERT INTO `auth_resource`
VALUES ('667033951713362913', 'file:delete', '删除', '667033750256747169', 'DELETE', '/file', '', '3',
        '2020-01-15 15:54:47', '3', '2020-01-15 15:54:47');
INSERT INTO `auth_resource`
VALUES ('667034024379679809', 'file:view', '查看', '667033750256747169', 'GET', '/file', '', '3', '2020-01-15 15:55:05',
        '3', '2020-01-15 15:55:05');
INSERT INTO `auth_resource`
VALUES ('676763119808152449', 'receive:view', '查看', '676762509503365569', 'GET', '/receiveRecord/page', '', '3',
        '2020-02-11 12:15:02', '3', '2020-03-03 23:29:14');
INSERT INTO `auth_resource`
VALUES ('676763196182234113', 'send:view', '查看', '676762719185011233', 'GET', '/sendRecord/page', '', '3',
        '2020-02-11 12:15:20', '3', '2020-03-03 23:29:03');
INSERT INTO `auth_resource`
VALUES ('684536767625301441', 'rule:config-view', '配置-查看', '603981723864141121', 'GET', '/role/authority/*', '', '3',
        '2020-03-03 23:04:44', '3', '2020-03-03 23:26:26');
INSERT INTO `auth_resource`
VALUES ('684539815017848257', 'resource:view', '查看', '603976297063910529', 'GET', '/resource/page', '', '3',
        '2020-03-03 23:16:50', '3', '2020-03-03 23:16:50');

-- ----------------------------
-- Table structure for `auth_role`
-- ----------------------------
DROP TABLE IF EXISTS `auth_role`;
CREATE TABLE `auth_role`
(
    `id`          bigint(20)  NOT NULL,
    `name`        varchar(30) NOT NULL DEFAULT '' COMMENT '角色名称',
    `code`        varchar(20)          DEFAULT '' COMMENT '角色编码',
    `describe_`   varchar(100)         DEFAULT '' COMMENT '功能描述',
    `status`      bit(1)               DEFAULT b'1' COMMENT '状态',
    `readonly`    bit(1)               DEFAULT b'0' COMMENT '是否内置角色',
    `create_user` bigint(20)           DEFAULT '0' COMMENT '创建人id',
    `create_time` datetime             DEFAULT NULL COMMENT '创建时间',
    `update_user` bigint(20)           DEFAULT '0' COMMENT '更新人id',
    `update_time` datetime             DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `UN_CODE` (`code`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  ROW_FORMAT = COMPACT COMMENT ='角色';

-- ----------------------------
-- Records of auth_role
-- ----------------------------
INSERT INTO `auth_role`
VALUES ('100', '平台管理员', 'PT_ADMIN', '平台内置管理员', '', '', '1', '2019-10-25 13:46:00', '3', '2020-03-03 21:19:27');
INSERT INTO `auth_role`
VALUES ('643779012732130273', '普通员工', 'BASE_USER', '只有最基本的权限', '', '\0', '3', '2019-11-12 11:47:58', '3',
        '2019-11-16 09:47:11');
INSERT INTO `auth_role`
VALUES ('645198153556958497', '部门经理', 'DEPT_MANAGER', '管理本级以及子级用户', '', '\0', '3', '2019-11-16 09:47:07', '3',
        '2020-03-19 13:30:25');

-- ----------------------------
-- Table structure for `auth_role_authority`
-- ----------------------------
DROP TABLE IF EXISTS `auth_role_authority`;
CREATE TABLE `auth_role_authority`
(
    `id`             bigint(20)  NOT NULL COMMENT '主键',
    `authority_id`   bigint(20)  NOT NULL COMMENT '权限id\n#c_auth_resource\n#c_auth_menu',
    `authority_type` varchar(10) NOT NULL DEFAULT 'MENU' COMMENT '权限类型\n#AuthorizeType{MENU:菜单;RESOURCE:资源;}',
    `role_id`        bigint(20)  NOT NULL COMMENT '角色id\n#c_auth_role',
    `create_time`    datetime             DEFAULT NULL COMMENT '创建时间',
    `create_user`    bigint(20)           DEFAULT '0' COMMENT '创建人',
    PRIMARY KEY (`id`) USING BTREE,
    KEY `IDX_KEY` (`role_id`, `authority_type`, `authority_id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  ROW_FORMAT = COMPACT COMMENT ='角色的资源';

-- ----------------------------
-- Records of auth_role_authority
-- ----------------------------
INSERT INTO `auth_role_authority`
VALUES ('646807586212951009', '643444685339100193', 'RESOURCE', '646807483838377697', '2019-11-20 20:22:26', '3');
INSERT INTO `auth_role_authority`
VALUES ('646807586229728257', '101', 'MENU', '646807483838377697', '2019-11-20 20:22:26', '3');
INSERT INTO `auth_role_authority`
VALUES ('646807586229728289', '643464272629728001', 'MENU', '646807483838377697', '2019-11-20 20:22:26', '3');
INSERT INTO `auth_role_authority`
VALUES ('646807586229728321', '643464953478514081', 'MENU', '646807483838377697', '2019-11-20 20:22:26', '3');
INSERT INTO `auth_role_authority`
VALUES ('646807586229728353', '643464392888812545', 'MENU', '646807483838377697', '2019-11-20 20:22:26', '3');
INSERT INTO `auth_role_authority`
VALUES ('646807586233922689', '603982542332235201', 'MENU', '646807483838377697', '2019-11-20 20:22:26', '3');
INSERT INTO `auth_role_authority`
VALUES ('648840524161089921', '605080648767505601', 'MENU', '645198153556958497', '2019-11-26 11:00:36', '3');
INSERT INTO `auth_role_authority`
VALUES ('648840524186255777', '605080107379327969', 'MENU', '645198153556958497', '2019-11-26 11:00:36', '3');
INSERT INTO `auth_role_authority`
VALUES ('648840524190450113', '101', 'MENU', '645198153556958497', '2019-11-26 11:00:36', '3');
INSERT INTO `auth_role_authority`
VALUES ('648840524190450145', '605080359394083937', 'MENU', '645198153556958497', '2019-11-26 11:00:36', '3');
INSERT INTO `auth_role_authority`
VALUES ('648840524190450177', '102', 'MENU', '645198153556958497', '2019-11-26 11:00:36', '3');
INSERT INTO `auth_role_authority`
VALUES ('648840524194644513', '103', 'MENU', '645198153556958497', '2019-11-26 11:00:36', '3');
INSERT INTO `auth_role_authority`
VALUES ('648840524198838849', '603983082961243905', 'MENU', '645198153556958497', '2019-11-26 11:00:36', '3');
INSERT INTO `auth_role_authority`
VALUES ('648840524198838881', '105', 'MENU', '645198153556958497', '2019-11-26 11:00:36', '3');
INSERT INTO `auth_role_authority`
VALUES ('648840524203033217', '106', 'MENU', '645198153556958497', '2019-11-26 11:00:36', '3');
INSERT INTO `auth_role_authority`
VALUES ('648840524203033249', '107', 'MENU', '645198153556958497', '2019-11-26 11:00:36', '3');
INSERT INTO `auth_role_authority`
VALUES ('648840524203033281', '605078463069552993', 'MENU', '645198153556958497', '2019-11-26 11:00:36', '3');
INSERT INTO `auth_role_authority`
VALUES ('648840524207227617', '603981723864141121', 'MENU', '645198153556958497', '2019-11-26 11:00:36', '3');
INSERT INTO `auth_role_authority`
VALUES ('648840524207227649', '605078371293987105', 'MENU', '645198153556958497', '2019-11-26 11:00:36', '3');
INSERT INTO `auth_role_authority`
VALUES ('648840524207227681', '605079751035454305', 'MENU', '645198153556958497', '2019-11-26 11:00:36', '3');
INSERT INTO `auth_role_authority`
VALUES ('648840524207227713', '605080023753294753', 'MENU', '645198153556958497', '2019-11-26 11:00:36', '3');
INSERT INTO `auth_role_authority`
VALUES ('648840524211422049', '603976297063910529', 'MENU', '645198153556958497', '2019-11-26 11:00:36', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625204871937', '643445116756821697', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625213260577', '643444685339100197', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625217454913', '643445802106097185', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625217454945', '643448826945869409', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625221649281', '643444685339100196', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625225843617', '643444685339100193', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625225843649', '643445514607528609', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625225843681', '643444685339100195', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625225843713', '643444685339100194', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625230038049', '667033888949797761', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625230038081', '643448507767723169', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625230038113', '643445197954353025', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625230038145', '645288283693121889', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625234232481', '643444897201784193', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625234232513', '667034094479082657', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625234232545', '643448730950833601', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625238426881', '667033832750318369', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625238426913', '643445412774021505', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625242621249', '643445262110427201', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625242621281', '643448656451605857', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625246815617', '643450853134441825', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625246815649', '643445774687931841', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625246815681', '667034024379679809', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625246815713', '684539815017848257', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625251010049', '643445477274028609', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625251010081', '684536767625301441', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625255204417', '643445352703199521', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625255204449', '643445747320098145', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625259398785', '643445016773002817', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625259398817', '643445162915137313', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625259398849', '643444858974897441', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625263593185', '643450770317909249', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625263593217', '643444992357959137', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625263593249', '643445229575210977', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625263593281', '643445641149680705', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625263593313', '643444819758154945', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625267787649', '643448369779315777', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625267787681', '643448338154263521', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625267787713', '643445704177487105', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625267787745', '676763119808152449', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625267787777', '643445283996305569', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625271982113', '643445674330819745', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625271982145', '643445542076025601', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625271982177', '645288214990422241', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625271982209', '645288375300915649', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625276176545', '676763196182234113', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625276176577', '643445448081672673', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625276176609', '643448611161511169', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625276176641', '667033951713362913', 'RESOURCE', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625280370977', '645215230518909025', 'MENU', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625280371009', '605079411338773153', 'MENU', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625280371041', '603983082961243905', 'MENU', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625280371073', '667033750256747169', 'MENU', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625280371105', '603982542332235201', 'MENU', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625284565441', '603981723864141121', 'MENU', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625284565473', '676762509503365569', 'MENU', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625284565505', '681133179561574689', 'MENU', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625284565537', '605079239015793249', 'MENU', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625288759873', '605078672772170209', 'MENU', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625288759905', '603976297063910529', 'MENU', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625288759937', '676762719185011233', 'MENU', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625288759969', '680085395794296897', 'MENU', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625288760001', '605078979149300257', 'MENU', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625292954337', '101', 'MENU', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625292954369', '104', 'MENU', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625292954401', '676762150244450433', 'MENU', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690284625292954433', '603982713849908801', 'MENU', '100', '2020-03-19 19:44:40', '3');
INSERT INTO `auth_role_authority`
VALUES ('690609420521966817', '643445116756821697', 'RESOURCE', '643779012732130273', '2020-03-20 17:15:17', '3');
INSERT INTO `auth_role_authority`
VALUES ('690609420526161153', '643445262110427201', 'RESOURCE', '643779012732130273', '2020-03-20 17:15:17', '3');
INSERT INTO `auth_role_authority`
VALUES ('690609420526161185', '643444992357959137', 'RESOURCE', '643779012732130273', '2020-03-20 17:15:17', '3');
INSERT INTO `auth_role_authority`
VALUES ('690609420530355521', '643444685339100193', 'RESOURCE', '643779012732130273', '2020-03-20 17:15:17', '3');
INSERT INTO `auth_role_authority`
VALUES ('690609420530355553', '643444897201784193', 'RESOURCE', '643779012732130273', '2020-03-20 17:15:17', '3');
INSERT INTO `auth_role_authority`
VALUES ('690609420530355585', '643445016773002817', 'RESOURCE', '643779012732130273', '2020-03-20 17:15:17', '3');
INSERT INTO `auth_role_authority`
VALUES ('690609420534549921', '643445229575210977', 'RESOURCE', '643779012732130273', '2020-03-20 17:15:17', '3');
INSERT INTO `auth_role_authority`
VALUES ('690609420534549953', '643444819758154945', 'RESOURCE', '643779012732130273', '2020-03-20 17:15:17', '3');
INSERT INTO `auth_role_authority`
VALUES ('690609420534549985', '643445162915137313', 'RESOURCE', '643779012732130273', '2020-03-20 17:15:17', '3');
INSERT INTO `auth_role_authority`
VALUES ('690609420534550017', '643445283996305569', 'RESOURCE', '643779012732130273', '2020-03-20 17:15:17', '3');
INSERT INTO `auth_role_authority`
VALUES ('690609420534550049', '603982713849908801', 'MENU', '643779012732130273', '2020-03-20 17:15:17', '3');
INSERT INTO `auth_role_authority`
VALUES ('690609420538744385', '101', 'MENU', '643779012732130273', '2020-03-20 17:15:17', '3');
INSERT INTO `auth_role_authority`
VALUES ('690609420538744417', '603982542332235201', 'MENU', '643779012732130273', '2020-03-20 17:15:17', '3');

-- ----------------------------
-- Table structure for `auth_role_org`
-- ----------------------------
DROP TABLE IF EXISTS `auth_role_org`;
CREATE TABLE `auth_role_org`
(
    `id`          bigint(20) NOT NULL COMMENT 'ID',
    `role_id`     bigint(20) DEFAULT NULL COMMENT '角色ID\n#c_auth_role',
    `org_id`      bigint(20) DEFAULT NULL COMMENT '部门ID\n#c_core_org',
    `create_time` datetime   DEFAULT NULL,
    `create_user` bigint(20) DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  ROW_FORMAT = COMPACT COMMENT ='角色组织关系';

-- ----------------------------
-- Records of auth_role_org
-- ----------------------------
INSERT INTO `auth_role_org`
VALUES ('684510274555769057', '100', '100', '2020-03-03 21:19:27', '3');
INSERT INTO `auth_role_org`
VALUES ('684510274564157697', '100', '101', '2020-03-03 21:19:27', '3');
INSERT INTO `auth_role_org`
VALUES ('684510274564157729', '100', '102', '2020-03-03 21:19:27', '3');
INSERT INTO `auth_role_org`
VALUES ('684510274564157761', '100', '643775612976106881', '2020-03-03 21:19:27', '3');
INSERT INTO `auth_role_org`
VALUES ('684510274564157793', '100', '643775664683486689', '2020-03-03 21:19:27', '3');
INSERT INTO `auth_role_org`
VALUES ('684510274564157825', '100', '643775904077582049', '2020-03-03 21:19:27', '3');
INSERT INTO `auth_role_org`
VALUES ('684510274564157857', '100', '643776324342648929', '2020-03-03 21:19:27', '3');
INSERT INTO `auth_role_org`
VALUES ('684510274564157889', '100', '643776407691858113', '2020-03-03 21:19:27', '3');
INSERT INTO `auth_role_org`
VALUES ('684510274564157921', '100', '643776508795556193', '2020-03-03 21:19:27', '3');
INSERT INTO `auth_role_org`
VALUES ('684510274568352257', '100', '643776594376135105', '2020-03-03 21:19:27', '3');
INSERT INTO `auth_role_org`
VALUES ('684510274568352289', '100', '643776633823564321', '2020-03-03 21:19:27', '3');
INSERT INTO `auth_role_org`
VALUES ('684510274568352321', '100', '643776668917305985', '2020-03-03 21:19:27', '3');
INSERT INTO `auth_role_org`
VALUES ('684510274568352353', '100', '643776713909605089', '2020-03-03 21:19:27', '3');
INSERT INTO `auth_role_org`
VALUES ('684510274568352385', '100', '643776757199016769', '2020-03-03 21:19:27', '3');
INSERT INTO `auth_role_org`
VALUES ('684510274568352417', '100', '684470048693160353', '2020-03-03 21:19:27', '3');
INSERT INTO `auth_role_org`
VALUES ('690190442947420673', '645198153556958497', '100', '2020-03-19 13:30:25', '3');
INSERT INTO `auth_role_org`
VALUES ('690190442951615009', '645198153556958497', '101', '2020-03-19 13:30:25', '3');
INSERT INTO `auth_role_org`
VALUES ('690190442951615041', '645198153556958497', '643775612976106881', '2020-03-19 13:30:25', '3');
INSERT INTO `auth_role_org`
VALUES ('690190442951615073', '645198153556958497', '643776594376135105', '2020-03-19 13:30:25', '3');
INSERT INTO `auth_role_org`
VALUES ('690190442951615105', '645198153556958497', '643776633823564321', '2020-03-19 13:30:25', '3');
INSERT INTO `auth_role_org`
VALUES ('690190442951615137', '645198153556958497', '102', '2020-03-19 13:30:25', '3');
INSERT INTO `auth_role_org`
VALUES ('690190442955809473', '645198153556958497', '643776668917305985', '2020-03-19 13:30:25', '3');
INSERT INTO `auth_role_org`
VALUES ('690190442955809505', '645198153556958497', '643776713909605089', '2020-03-19 13:30:25', '3');
INSERT INTO `auth_role_org`
VALUES ('690190442955809537', '645198153556958497', '643776757199016769', '2020-03-19 13:30:25', '3');
INSERT INTO `auth_role_org`
VALUES ('690190442955809569', '645198153556958497', '643775904077582049', '2020-03-19 13:30:25', '3');
INSERT INTO `auth_role_org`
VALUES ('690190442955809601', '645198153556958497', '643775664683486689', '2020-03-19 13:30:25', '3');
INSERT INTO `auth_role_org`
VALUES ('690190442955809633', '645198153556958497', '643776324342648929', '2020-03-19 13:30:25', '3');
INSERT INTO `auth_role_org`
VALUES ('690190442955809665', '645198153556958497', '643776407691858113', '2020-03-19 13:30:25', '3');
INSERT INTO `auth_role_org`
VALUES ('690190442955809697', '645198153556958497', '643776508795556193', '2020-03-19 13:30:25', '3');

-- ----------------------------
-- Table structure for `auth_user`
-- ----------------------------
DROP TABLE IF EXISTS `auth_user`;
CREATE TABLE `auth_user`
(
    `id`                       bigint(20)  NOT NULL COMMENT 'ID',
    `account`                  varchar(30) NOT NULL COMMENT '账号',
    `name`                     varchar(50) NOT NULL COMMENT '姓名',
    `org_id`                   bigint(20)           DEFAULT NULL COMMENT '组织ID\n#c_core_org',
    `station_id`               bigint(20)           DEFAULT NULL COMMENT '岗位ID\n#c_core_station',
    `email`                    varchar(255)         DEFAULT NULL COMMENT '邮箱',
    `mobile`                   varchar(20)          DEFAULT '' COMMENT '手机',
    `sex`                      varchar(1)           DEFAULT 'N' COMMENT '性别\n#Sex{W:女;M:男;N:未知}',
    `status`                   bit(1)               DEFAULT b'0' COMMENT '启用状态 1启用 0禁用',
    `avatar`                   varchar(255)         DEFAULT '' COMMENT '头像',
    `work_describe`            varchar(255)         DEFAULT '' COMMENT '工作描述\r\n比如：  市长、管理员、局长等等   用于登陆展示',
    `password_error_last_time` datetime             DEFAULT NULL COMMENT '最后一次输错密码时间',
    `password_error_num`       int(11)              DEFAULT '0' COMMENT '密码错误次数',
    `password_expire_time`     datetime             DEFAULT NULL COMMENT '密码过期时间',
    `password`                 varchar(64) NOT NULL DEFAULT '' COMMENT '密码',
    `last_login_time`          datetime             DEFAULT NULL COMMENT '最后登录时间',
    `create_user`              bigint(20)           DEFAULT '0' COMMENT '创建人id',
    `create_time`              datetime             DEFAULT NULL COMMENT '创建时间',
    `update_user`              bigint(20)           DEFAULT '0' COMMENT '更新人id',
    `update_time`              datetime             DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE KEY `UN_ACCOUNT` (`account`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  ROW_FORMAT = COMPACT COMMENT ='用户';

-- ----------------------------
-- Records of auth_user
-- ----------------------------
INSERT INTO `auth_user`
VALUES ('3', '123', '平台管理员', '100', '100', '', '', 'M', '', 'BiazfanxmamNRoxxVxka.png', '超级管理员', '2020-03-21 18:48:51',
        '0', null, 'cea87ef1cb2e47570020bf7c014e1074', '2020-03-21 18:48:53', '1', '2019-09-02 11:32:02', '3',
        '2020-01-15 15:39:59');
INSERT INTO `auth_user`
VALUES ('641577229343523041', 'test', '赵六', '102', '100', '', '', 'M', '', 'BiazfanxmamNRoxxVxka.png', '',
        '2020-03-18 13:55:15', '0', null, 'cea87ef1cb2e47570020bf7c014e1074', '2020-03-18 13:55:26', '3',
        '2019-11-06 09:58:56', '3', '2020-01-10 16:32:11');
INSERT INTO `auth_user`
VALUES ('641590096981656001', 'manong', '李四', '101', '645199319300842081', '', '', 'M', '', 'BiazfanxmamNRoxxVxka.png',
        '122', '2020-03-21 18:49:20', '0', null, 'cea87ef1cb2e47570020bf7c014e1074', '2020-03-21 18:49:21', '3',
        '2019-11-06 10:50:01', '3', '2020-03-01 13:22:08');
INSERT INTO `auth_user`
VALUES ('648841103860041025', '11111', '王五', '643776668917305985', '645200885772724545', '', '', 'M', '',
        'BiazfanxmamNRoxxVxka.png', '', null, '0', null, 'cea87ef1cb2e47570020bf7c014e1074', null, '3',
        '2019-11-26 11:02:54', '3', '2020-02-06 13:20:46');
INSERT INTO `auth_user`
VALUES ('683356335357559137', 'test1', '测试', null, null, '', '', 'W', '', 'BiazfanxmamNRoxxVxka.png', '',
        '2020-02-29 16:55:10', '0', null, 'cea87ef1cb2e47570020bf7c014e1074', '2020-02-29 16:55:10', '3',
        '2020-02-29 16:54:07', '3', '2020-03-01 19:12:06');

-- ----------------------------
-- Table structure for `auth_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `auth_user_role`;
CREATE TABLE `auth_user_role`
(
    `id`          bigint(20) NOT NULL,
    `role_id`     bigint(20) NOT NULL DEFAULT '0' COMMENT '角色ID\n#c_auth_role',
    `user_id`     bigint(20) NOT NULL DEFAULT '0' COMMENT '用户ID\n#c_core_accou',
    `create_user` bigint(20)          DEFAULT NULL COMMENT '创建人ID',
    `create_time` datetime            DEFAULT NULL COMMENT '创建时间',
    PRIMARY KEY (`id`) USING BTREE,
    KEY `IDX_KEY` (`role_id`, `user_id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  ROW_FORMAT = COMPACT COMMENT ='角色分配\r\n账号角色绑定';

-- ----------------------------
-- Records of auth_user_role
-- ----------------------------
INSERT INTO `auth_user_role`
VALUES ('646807547461776193', '646807483838377697', '641590096981656001', '3', '2019-11-20 20:22:17');
INSERT INTO `auth_user_role`
VALUES ('647449120218284897', '647449059488957153', '641577229343523041', '641577229343523041', '2019-11-22 14:51:39');
INSERT INTO `auth_user_role`
VALUES ('683356538315735681', '645198153556958497', '641577229343523041', '3', '2020-02-29 16:54:55');
INSERT INTO `auth_user_role`
VALUES ('683356538332512929', '645198153556958497', '683356335357559137', '3', '2020-02-29 16:54:55');
INSERT INTO `auth_user_role`
VALUES ('689124069395663201', '100', '3', '3', '2020-03-16 14:53:02');
INSERT INTO `auth_user_role`
VALUES ('690652179203096993', '643779012732130273', '641590096981656001', '3', '2020-03-20 20:05:11');
INSERT INTO `auth_user_role`
VALUES ('690652179211485633', '643779012732130273', '641577229343523041', '3', '2020-03-20 20:05:11');

-- ----------------------------
-- Table structure for `common_login_log`
-- ----------------------------
DROP TABLE IF EXISTS `common_login_log`;
CREATE TABLE `common_login_log`
(
    `id`               bigint(20) NOT NULL COMMENT '主键',
    `request_ip`       varchar(50)  DEFAULT '' COMMENT '操作IP',
    `user_id`          bigint(20)   DEFAULT NULL COMMENT '登录人ID',
    `user_name`        varchar(50)  DEFAULT NULL COMMENT '登录人姓名',
    `account`          varchar(30)  DEFAULT '' COMMENT '登录人账号',
    `description`      varchar(255) DEFAULT '' COMMENT '登录描述',
    `login_date`       date         DEFAULT NULL COMMENT '登录时间',
    `ua`               varchar(500) DEFAULT '0' COMMENT '浏览器请求头',
    `browser`          varchar(100) DEFAULT NULL COMMENT '浏览器名称',
    `browser_version`  varchar(255) DEFAULT NULL COMMENT '浏览器版本',
    `operating_system` varchar(100) DEFAULT NULL COMMENT '操作系统',
    `location`         varchar(50)  DEFAULT '' COMMENT '登录地点',
    `create_time`      datetime     DEFAULT NULL,
    `create_user`      bigint(20)   DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE,
    KEY `IDX_BROWSER` (`browser`) USING BTREE,
    KEY `IDX_OPERATING` (`operating_system`) USING BTREE,
    KEY `IDX_LOGIN_DATE` (`login_date`, `account`) USING BTREE,
    KEY `IDX_ACCOUNT_IP` (`account`, `request_ip`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  ROW_FORMAT = DYNAMIC COMMENT ='登录日志';

-- ----------------------------
-- Records of common_login_log
-- ----------------------------

-- ----------------------------
-- Table structure for `common_opt_log`
-- ----------------------------
DROP TABLE IF EXISTS `common_opt_log`;
CREATE TABLE `common_opt_log`
(
    `id`             bigint(20) NOT NULL COMMENT '主键',
    `request_ip`     varchar(50)     DEFAULT '' COMMENT '操作IP',
    `type`           varchar(5)      DEFAULT 'OPT' COMMENT '日志类型\n#LogType{OPT:操作类型;EX:异常类型}',
    `user_name`      varchar(50)     DEFAULT '' COMMENT '操作人',
    `description`    varchar(255)    DEFAULT '' COMMENT '操作描述',
    `class_path`     varchar(255)    DEFAULT '' COMMENT '类路径',
    `action_method`  varchar(50)     DEFAULT '' COMMENT '请求方法',
    `request_uri`    varchar(50)     DEFAULT '' COMMENT '请求地址',
    `http_method`    varchar(10)     DEFAULT 'GET' COMMENT '请求类型\n#HttpMethod{GET:GET请求;POST:POST请求;PUT:PUT请求;DELETE:DELETE请求;PATCH:PATCH请求;TRACE:TRACE请求;HEAD:HEAD请求;OPTIONS:OPTIONS请求;}',
    `params`         longtext COMMENT '请求参数',
    `result`         longtext COMMENT '返回值',
    `ex_desc`        longtext COMMENT '异常详情信息',
    `ex_detail`      longtext COMMENT '异常描述',
    `start_time`     timestamp  NULL DEFAULT NULL COMMENT '开始时间',
    `finish_time`    timestamp  NULL DEFAULT NULL COMMENT '完成时间',
    `consuming_time` bigint(20)      DEFAULT '0' COMMENT '消耗时间',
    `ua`             varchar(500)    DEFAULT '' COMMENT '浏览器',
    `create_time`    datetime        DEFAULT NULL,
    `create_user`    bigint(20)      DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE,
    KEY `index_type` (`type`) USING BTREE COMMENT '日志类型'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  ROW_FORMAT = DYNAMIC COMMENT ='系统日志';

-- ----------------------------
-- Records of common_opt_log
-- ----------------------------

-- ----------------------------
-- Table structure for `core_org`
-- ----------------------------
DROP TABLE IF EXISTS `core_org`;
CREATE TABLE `core_org`
(
    `id`           bigint(20)   NOT NULL COMMENT 'ID',
    `name`         varchar(255) NOT NULL DEFAULT '' COMMENT '名称',
    `abbreviation` varchar(255)          DEFAULT '' COMMENT '简称',
    `parent_id`    bigint(20)            DEFAULT '0' COMMENT '父ID',
    `tree_path`    varchar(255)          DEFAULT ',' COMMENT '树结构',
    `sort_value`   int(11)               DEFAULT '1' COMMENT '排序',
    `status`       bit(1)                DEFAULT b'1' COMMENT '状态',
    `describe_`    varchar(255)          DEFAULT '' COMMENT '描述',
    `create_time`  datetime              DEFAULT NULL,
    `create_user`  bigint(20)            DEFAULT NULL,
    `update_time`  datetime              DEFAULT NULL,
    `update_user`  bigint(20)            DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE,
    FULLTEXT KEY `FU_PATH` (`tree_path`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  ROW_FORMAT = COMPACT COMMENT ='组织';

-- ----------------------------
-- Records of core_org
-- ----------------------------
INSERT INTO `core_org`
VALUES ('100', '品达物流集团有限公司', '品达集团', '0', ',', '1', '', '总公司', '2019-07-10 17:02:18', '1', '2020-02-20 20:57:11', '3');
INSERT INTO `core_org`
VALUES ('101', '品达上海分公司', '上海品达', '100', ',100,', '0', '', '上海分公司', '2019-08-06 09:10:53', '1', '2020-01-10 06:23:32',
        '3');
INSERT INTO `core_org`
VALUES ('102', '品达北京分公司', '品达北京', '100', ',100,', '1', '', '北京分公司', '2019-11-07 16:13:09', '1', '2020-01-10 06:23:48',
        '3');
INSERT INTO `core_org`
VALUES ('643775612976106881', '综合部', '综合部', '101', ',100,101,', '0', '', '前台&HR', '2019-11-12 11:34:27', '3',
        '2020-03-01 18:25:34', '3');
INSERT INTO `core_org`
VALUES ('643775664683486689', '管理层', '', '100', ',100,', '3', '', '', '2019-11-12 11:34:39', '3',
        '2019-11-12 11:36:16', '3');
INSERT INTO `core_org`
VALUES ('643775904077582049', '总经办', '', '100', ',100,', '2', '', '', '2019-11-12 11:35:37', '3',
        '2019-11-12 11:36:52', '3');
INSERT INTO `core_org`
VALUES ('643776324342648929', '财务部', '', '100', ',100,', '4', '', '', '2019-11-12 11:37:17', '3',
        '2019-11-12 11:37:40', '3');
INSERT INTO `core_org`
VALUES ('643776407691858113', '市场部', '', '100', ',100,', '5', '', '', '2019-11-12 11:37:37', '3',
        '2019-11-12 11:37:37', '3');
INSERT INTO `core_org`
VALUES ('643776508795556193', '销售部', '', '100', ',100,', '6', '', '', '2019-11-12 11:38:01', '3',
        '2019-11-12 11:38:01', '3');
INSERT INTO `core_org`
VALUES ('643776594376135105', '研发部', '', '101', ',100,101,', '1', '', 'java/html', '2019-11-12 11:38:21', '3',
        '2020-03-01 18:25:57', '3');
INSERT INTO `core_org`
VALUES ('643776633823564321', '产品部', '', '101', ',100,101,', '2', '', '', '2019-11-12 11:38:31', '3',
        '2019-11-12 11:38:31', '3');
INSERT INTO `core_org`
VALUES ('643776668917305985', '综合部', '', '102', ',100,102,', '0', '', '', '2019-11-12 11:38:39', '3',
        '2019-11-12 11:38:39', '3');
INSERT INTO `core_org`
VALUES ('643776713909605089', '研发部', '', '102', ',100,102,', '0', '', '', '2019-11-12 11:38:50', '3',
        '2019-11-12 11:38:50', '3');
INSERT INTO `core_org`
VALUES ('643776757199016769', '销售部', '', '102', ',100,102,', '2', '', '', '2019-11-12 11:39:00', '3',
        '2019-11-12 11:39:00', '3');

-- ----------------------------
-- Table structure for `core_station`
-- ----------------------------
DROP TABLE IF EXISTS `core_station`;
CREATE TABLE `core_station`
(
    `id`          bigint(20)   NOT NULL COMMENT 'ID',
    `name`        varchar(255) NOT NULL DEFAULT '' COMMENT '名称',
    `org_id`      bigint(20)            DEFAULT '0' COMMENT '组织ID\n#c_core_org',
    `status`      bit(1)                DEFAULT b'1' COMMENT '状态',
    `describe_`   varchar(255)          DEFAULT '' COMMENT '描述',
    `create_time` datetime              DEFAULT NULL,
    `create_user` bigint(20)            DEFAULT NULL,
    `update_time` datetime              DEFAULT NULL,
    `update_user` bigint(20)            DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  ROW_FORMAT = COMPACT COMMENT ='岗位';

-- ----------------------------
-- Records of core_station
-- ----------------------------
INSERT INTO `core_station`
VALUES ('100', '总经理', '643775904077582049', '', '总部-1把手', '2019-07-10 17:03:03', '1', '2019-11-16 09:59:17', '3');
INSERT INTO `core_station`
VALUES ('101', '副总经理', '643775904077582049', '', '总部-2把手', '2019-07-22 17:07:55', '1', '2019-11-16 09:59:21', '3');
INSERT INTO `core_station`
VALUES ('642032719487828225', '研发经理', '643776594376135105', '', '子公司-研发部老大', '2019-11-07 16:08:49', '3',
        '2019-11-16 09:53:42', '3');
INSERT INTO `core_station`
VALUES ('645199319300842081', '副总经理', '101', '', '子公司-老大', '2019-11-16 09:51:45', '3', '2019-11-16 09:53:50', '3');
INSERT INTO `core_station`
VALUES ('645199745026892801', '产品经理', '643776633823564321', '', '子公司-产品部老大', '2019-11-16 09:53:27', '3',
        '2019-11-16 09:54:01', '3');
INSERT INTO `core_station`
VALUES ('645200064280536545', '人事经理', '643775612976106881', '', '子公司-综合老大', '2019-11-16 09:54:43', '3',
        '2019-11-16 09:54:43', '3');
INSERT INTO `core_station`
VALUES ('645200151886964289', 'Java工程师', '643776594376135105', '', '普通员工', '2019-11-16 09:55:04', '3',
        '2019-11-16 09:55:04', '3');
INSERT INTO `core_station`
VALUES ('645200250243393185', '需求工程师', '643776633823564321', '', '普通员工', '2019-11-16 09:55:27', '3',
        '2019-11-16 09:55:27', '3');
INSERT INTO `core_station`
VALUES ('645200304014370561', 'UI工程师', '643776633823564321', '', '普通员工', '2019-11-16 09:55:40', '3',
        '2019-11-16 09:55:40', '3');
INSERT INTO `core_station`
VALUES ('645200358959753057', '运维工程师', '643776594376135105', '', '普通员工', '2019-11-16 09:55:53', '3',
        '2019-11-16 09:55:53', '3');
INSERT INTO `core_station`
VALUES ('645200405453612993', '前台小姐姐', '643775612976106881', '', '普通员工', '2019-11-16 09:56:04', '3',
        '2019-11-16 09:56:04', '3');
INSERT INTO `core_station`
VALUES ('645200545698555937', '人事经理', '643776668917305985', '', '北京分公司-综合部老大', '2019-11-16 09:56:38', '3',
        '2019-11-16 09:56:38', '3');
INSERT INTO `core_station`
VALUES ('645200670781089921', '研发经理', '643776713909605089', '', '北京分公司-研发部老大', '2019-11-16 09:57:07', '3',
        '2019-11-16 09:57:07', '3');
INSERT INTO `core_station`
VALUES ('645200806559099105', '销售经理', '643776757199016769', '', '北京销售部老大', '2019-11-16 09:57:40', '3',
        '2019-11-16 09:57:40', '3');
INSERT INTO `core_station`
VALUES ('645200885772724545', '行政', '643776668917305985', '', '普通员工', '2019-11-16 09:57:59', '3',
        '2019-11-16 09:57:59', '3');
INSERT INTO `core_station`
VALUES ('645200938289605025', '大前端工程师', '643776713909605089', '', '普通员工', '2019-11-16 09:58:11', '3',
        '2019-11-16 09:58:11', '3');
INSERT INTO `core_station`
VALUES ('645201064705927681', '销售员工', '643776757199016769', '', '普通员工', '2019-11-16 09:58:41', '3',
        '2019-11-16 09:58:41', '3');
INSERT INTO `core_station`
VALUES ('645201184268757601', '销售总监', '643775664683486689', '', '总部2把手', '2019-11-16 09:59:10', '3',
        '2019-11-16 09:59:10', '3');
INSERT INTO `core_station`
VALUES ('645201307765844833', '财务总监', '643776324342648929', '', '总部2把手', '2019-11-16 09:59:39', '3',
        '2019-11-16 09:59:39', '3');
INSERT INTO `core_station`
VALUES ('645201405757369281', '市场经理', '643776407691858113', '', '总部市场部老大', '2019-11-16 10:00:03', '3',
        '2019-11-16 10:00:03', '3');
INSERT INTO `core_station`
VALUES ('645201481133206561', '销售总监', '643776508795556193', '', '总部销售部老大', '2019-11-16 10:00:21', '3',
        '2019-11-16 10:00:21', '3');
INSERT INTO `core_station`
VALUES ('645201573391117441', '前端工程师', '643776594376135105', '', '普通员工', '2019-11-16 10:00:43', '3',
        '2020-03-01 19:11:58', '3');
