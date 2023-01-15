# 数据库名称：aggregate_pay_log

DROP TABLE IF EXISTS `opt_log`;
CREATE TABLE `opt_log`
(
    `id`             bigint(20) NOT NULL COMMENT '主键',
    `request_ip`     varchar(50)     DEFAULT '' COMMENT '操作IP',
    `type`           varchar(5)      DEFAULT 'OPT' COMMENT '日志类型\n#LogType{OPT:操作类型;EX:异常类型}',
    `user_name`      bigint(20)     DEFAULT NULL COMMENT '操作人(商户id)',
    `description`    varchar(255)    DEFAULT '' COMMENT '操作描述',
    `class_path`     varchar(255)    DEFAULT '' COMMENT '类路径',
    `action_method`  varchar(150)     DEFAULT '' COMMENT '请求方法',
    `request_uri`    varchar(50)     DEFAULT '' COMMENT '请求地址',
    `http_method`    varchar(10)     DEFAULT 'GET' COMMENT '请求类型\n#HttpMethod{GET:GET请求;POST:POST请求;PUT:PUT请求;DELETE:DELETE请求;PATCH:PATCH请求;TRACE:TRACE请求;HEAD:HEAD请求;OPTIONS:OPTIONS请求;}',
    `params`         longtext COMMENT '请求参数',
    `result`         longtext COMMENT '返回值',
    `ex_desc`        longtext COMMENT '异常详情信息',
    `ex_detail`      longtext COMMENT '异常描述',
    `start_time`     timestamp(3)  NULL DEFAULT NULL COMMENT '开始时间',
    `finish_time`    timestamp(3)  NULL DEFAULT NULL COMMENT '完成时间',
    `consuming_time` bigint(20)      DEFAULT '0' COMMENT '消耗时间',
    `ua`             varchar(500)    DEFAULT '' COMMENT '浏览器',
    PRIMARY KEY (`id`) USING BTREE,
    KEY `index_type` (`type`) USING BTREE COMMENT '日志类型',
    KEY `index_user_name` (`user_name`) USING BTREE COMMENT '操作人(商户id)'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  ROW_FORMAT = DYNAMIC COMMENT ='系统日志';
