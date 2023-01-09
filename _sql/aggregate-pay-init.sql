# Create Database
# ------------------------------------------------------------
CREATE DATABASE IF NOT EXISTS aggregate_pay_merchant_service DEFAULT CHARACTER SET = utf8mb4;

Use aggregate_pay_merchant_service;


SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for app
-- ----------------------------
DROP TABLE IF EXISTS `app`;
CREATE TABLE `app`
(
    `ID`          bigint(20) NOT NULL,
    `APP_ID`      varchar(50) DEFAULT NULL,
    `APP_NAME`    varchar(50) DEFAULT NULL COMMENT '商店名称',
    `MERCHANT_ID` bigint(20)  DEFAULT NULL COMMENT '所属商户',
    `PUBLIC_KEY`  varchar(50) DEFAULT NULL COMMENT '应用公钥(RSAWithSHA256)',
    `NOTIFY_URL`  varchar(50) DEFAULT NULL COMMENT '授权回调地址',
    PRIMARY KEY (`ID`) USING BTREE,
    UNIQUE KEY `APP_ID` (`APP_ID`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for merchant 商户
-- ----------------------------
DROP TABLE IF EXISTS `merchant`;
CREATE TABLE `merchant`
(
    `ID`                    bigint(20) NOT NULL COMMENT '主键',
    `MERCHANT_NAME`         varchar(50)  DEFAULT NULL COMMENT '商户名称',
    `MERCHANT_NO`           varchar(32)  DEFAULT NULL COMMENT '企业编号',
    `MERCHANT_ADDRESS`      varchar(255) DEFAULT NULL COMMENT '企业地址',
    `MERCHANT_TYPE`         varchar(50)  DEFAULT NULL COMMENT '商户类型',
    `BUSINESS_LICENSES_IMG` varchar(100) DEFAULT NULL COMMENT '营业执照（企业证明）',
    `ID_CARD_FRONT_IMG`     varchar(100) DEFAULT NULL COMMENT '法人身份证正面照片',
    `ID_CARD_AFTER_IMG`     varchar(100) DEFAULT NULL COMMENT '法人身份证反面照片',
    `USERNAME`              varchar(50)  DEFAULT NULL COMMENT '联系人姓名',
    `MOBILE`                varchar(50)  DEFAULT NULL COMMENT '联系人手机号(关联统一账号)',
    `CONTACTS_ADDRESS`      varchar(255) DEFAULT NULL COMMENT '联系人地址',
    `AUDIT_STATUS`          varchar(20)  DEFAULT NULL COMMENT '审核状态 0-未申请,1-已申请待审核,2-审核通过,3-审核拒绝',
    `TENANT_ID`             bigint(20)   DEFAULT NULL COMMENT '租户ID,关联统一用户',
    PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for staff  员工
-- ----------------------------
DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff`
(
    `ID`              bigint(20) NOT NULL COMMENT '主键',
    `MERCHANT_ID`     bigint(20)  DEFAULT NULL COMMENT '商户ID',
    `FULL_NAME`       varchar(50) DEFAULT NULL COMMENT '姓名',
    `POSITION`        varchar(50) DEFAULT NULL COMMENT '职位',
    `USERNAME`        varchar(50) DEFAULT NULL COMMENT '用户名(关联统一用户)',
    `MOBILE`          varchar(50) DEFAULT NULL COMMENT '手机号(关联统一用户)',
    `STORE_ID`        bigint(20)  DEFAULT NULL COMMENT '员工所属门店',
    `LAST_LOGIN_TIME` datetime    DEFAULT NULL COMMENT '最后一次登录时间',
    `STAFF_STATUS`    bit(1)      DEFAULT NULL COMMENT '0表示禁用，1表示启用',
    PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for store 门店
-- ----------------------------
DROP TABLE IF EXISTS `store`;
CREATE TABLE `store`
(
    `ID`            bigint(20) NOT NULL,
    `STORE_NAME`    varchar(50) DEFAULT NULL COMMENT '门店名称',
    `STORE_NUMBER`  bigint(20)  DEFAULT NULL COMMENT '门店编号',
    `MERCHANT_ID`   bigint(20)  DEFAULT NULL COMMENT '所属商户',
    `PARENT_ID`     bigint(20)  DEFAULT NULL COMMENT '父门店',
    `STORE_STATUS`  bit(1)      DEFAULT NULL COMMENT '0表示禁用，1表示启用',
    `STORE_ADDRESS` varchar(50) DEFAULT NULL COMMENT '门店地址',
    PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for store_staff 门店与员工是多对多关系，所以需要中间表
-- ----------------------------
DROP TABLE IF EXISTS `store_staff`;
CREATE TABLE `store_staff`
(
    `ID`       bigint(20) NOT NULL,
    `STORE_ID` bigint(20) DEFAULT NULL COMMENT '门店标识',
    `STAFF_ID` bigint(20) DEFAULT NULL COMMENT '员工标识',
    PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  ROW_FORMAT = DYNAMIC;

SET FOREIGN_KEY_CHECKS = 1;



# Create Database 交易服务数据库
# ------------------------------------------------------------
CREATE DATABASE IF NOT EXISTS aggregate_pay_transaction DEFAULT CHARACTER SET = utf8mb4;

Use aggregate_pay_transaction;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for app_platform_channel
-- ----------------------------
DROP TABLE IF EXISTS `app_platform_channel`;
CREATE TABLE `app_platform_channel`
(
    `ID`               bigint(20) NOT NULL,
    `APP_ID`           varchar(50) DEFAULT NULL COMMENT '应用id',
    `PLATFORM_CHANNEL` varchar(50) DEFAULT NULL COMMENT '平台支付渠道',
    PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  ROW_FORMAT = DYNAMIC COMMENT ='说明了应用选择了平台中的哪些支付渠道';

-- ----------------------------
-- Table structure for pay_channel 支付渠道
-- ----------------------------
DROP TABLE IF EXISTS `pay_channel`;
CREATE TABLE `pay_channel`
(
    `ID`           bigint(20) NOT NULL,
    `CHANNEL_NAME` varchar(50) DEFAULT NULL COMMENT '原始支付渠道名称',
    `CHANNEL_CODE` varchar(50) DEFAULT NULL COMMENT '原始支付渠道编码',
    PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for pay_channel_param 支付参数
-- ----------------------------
DROP TABLE IF EXISTS `pay_channel_param`;
CREATE TABLE `pay_channel_param`
(
    `ID`                      bigint(20) NOT NULL,
    `CHANNEL_NAME`            varchar(50) DEFAULT NULL COMMENT '配置名称',
    `MERCHANT_ID`             bigint(20)  DEFAULT NULL COMMENT '商户ID',
    `PAY_CHANNEL`             varchar(50) DEFAULT NULL COMMENT '原始支付渠道编码',
    `PARAM`                   text COMMENT '支付参数',
    `APP_PLATFORM_CHANNEL_ID` bigint(20)  DEFAULT NULL COMMENT '应用与支付渠道绑定ID',
    PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  ROW_FORMAT = DYNAMIC COMMENT ='某商户针对某一种原始支付渠道的配置参数';

-- ----------------------------
-- Table structure for pay_order 订单
-- ----------------------------
DROP TABLE IF EXISTS `pay_order`;
CREATE TABLE `pay_order`
(
    `ID`                     bigint(20)  NOT NULL,
    `TRADE_NO`               varchar(50) NOT NULL COMMENT '聚合支付订单号',
    `MERCHANT_ID`            bigint(20)  NOT NULL COMMENT '所属商户',
    `STORE_ID`               bigint(20)   DEFAULT NULL COMMENT '商户下门店',
    `APP_ID`                 varchar(50) NOT NULL COMMENT '所属应用',
    `PAY_CHANNEL`            varchar(50)  DEFAULT NULL COMMENT '原始支付渠道编码',
    `PAY_CHANNEL_MCH_ID`     varchar(50)  DEFAULT NULL COMMENT '原始渠道商户id',
    `PAY_CHANNEL_MCH_APP_ID` varchar(50)  DEFAULT NULL COMMENT '原始渠道商户应用id',
    `PAY_CHANNEL_TRADE_NO`   varchar(50)  DEFAULT NULL COMMENT '原始渠道订单号',
    `CHANNEL`                varchar(50)  DEFAULT NULL COMMENT '聚合支付的渠道',
    `OUT_TRADE_NO`           varchar(50)  DEFAULT NULL COMMENT '商户订单号',
    `SUBJECT`                varchar(50)  DEFAULT NULL COMMENT '商品标题',
    `BODY`                   varchar(256) DEFAULT NULL COMMENT '订单描述',
    `CURRENCY`               varchar(50)  DEFAULT NULL COMMENT '币种CNY',
    `TOTAL_AMOUNT`           int(11)      DEFAULT NULL COMMENT '订单总金额，单位为分',
    `OPTIONAL`               varchar(256) DEFAULT NULL COMMENT '用户自定义的参数,商户自定义数据',
    `ANALYSIS`               varchar(256) DEFAULT NULL COMMENT '用于统计分析的数据,用户自定义',
    `EXTRA`                  varchar(512) DEFAULT NULL COMMENT '特定渠道发起时额外参数',
    `TRADE_STATE`            varchar(50)  DEFAULT NULL COMMENT '交易状态支付状态,0-订单生成,1-支付中(目前未使用),2-支付成功,3-业务处理完成,4-关闭',
    `ERROR_CODE`             varchar(50)  DEFAULT NULL COMMENT '渠道支付错误码',
    `ERROR_MSG`              varchar(256) DEFAULT NULL COMMENT '渠道支付错误信息',
    `DEVICE`                 varchar(50)  DEFAULT NULL COMMENT '设备',
    `CLIENT_IP`              varchar(50)  DEFAULT NULL COMMENT '客户端IP',
    `CREATE_TIME`            datetime     DEFAULT NULL COMMENT '创建时间',
    `UPDATE_TIME`            datetime     DEFAULT NULL COMMENT '更新时间',
    `EXPIRE_TIME`            datetime     DEFAULT NULL COMMENT '订单过期时间',
    `PAY_SUCCESS_TIME`       datetime     DEFAULT NULL COMMENT '支付成功时间',
    PRIMARY KEY (`ID`) USING BTREE,
    UNIQUE KEY `unique_TRADE_NO` (`TRADE_NO`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for payment_bill
-- ----------------------------
DROP TABLE IF EXISTS `payment_bill`;
CREATE TABLE `payment_bill`
(
    `id`                bigint(20)     NOT NULL,
    `merchant_id`       bigint(20)     NOT NULL COMMENT '商户id',
    `merchant_name`     varchar(60)    NOT NULL COMMENT '商户名称',
    `merchant_app_id`   bigint(20)     NOT NULL COMMENT '商户应用Id',
    `merchant_order_no` varchar(60)    NOT NULL COMMENT '商户订单号',
    `channel_order_no`  varchar(60)    NOT NULL COMMENT '渠道订单号',
    `product_name`      varchar(255)   NOT NULL COMMENT '商品名称',
    `create_time`       varchar(60)    DEFAULT NULL COMMENT '创建时间',
    `pos_time`          varchar(60)    NOT NULL COMMENT '交易时间',
    `equipment_no`      varchar(60)    DEFAULT NULL COMMENT '终端号',
    `user_account`      varchar(60)    DEFAULT NULL COMMENT '用户账号/标识信息',
    `total_amount`      decimal(10, 2) DEFAULT NULL COMMENT '订单金额',
    `trade_amount`      decimal(10, 2) NOT NULL COMMENT '实际交易金额',
    `discount_amount`   decimal(10, 2) DEFAULT NULL COMMENT '折扣金额',
    `service_fee`       decimal(10, 4) DEFAULT NULL COMMENT '手续费',
    `refund_order_no`   varchar(60)    DEFAULT NULL COMMENT '退款单号',
    `refund_money`      decimal(10, 2) DEFAULT NULL,
    `platform_channel`  varchar(50)    NOT NULL COMMENT '平台支付渠道',
    `remark`            varchar(255)   DEFAULT NULL COMMENT '备注',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

-- ----------------------------
-- Table structure for platform_channel
-- ----------------------------
DROP TABLE IF EXISTS `platform_channel`;
CREATE TABLE `platform_channel`
(
    `ID`           bigint(20) NOT NULL,
    `CHANNEL_NAME` varchar(50) DEFAULT NULL COMMENT '平台支付渠道名称',
    `CHANNEL_CODE` varchar(50) DEFAULT NULL COMMENT '平台支付渠道编码',
    PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for platform_pay_channel
-- ----------------------------
DROP TABLE IF EXISTS `platform_pay_channel`;
CREATE TABLE `platform_pay_channel`
(
    `ID`               bigint(20) NOT NULL,
    `PLATFORM_CHANNEL` varchar(20) DEFAULT NULL COMMENT '平台支付渠道编码',
    `PAY_CHANNEL`      varchar(20) DEFAULT NULL COMMENT '原始支付渠道名称',
    PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for refund_order
-- ----------------------------
DROP TABLE IF EXISTS `refund_order`;
CREATE TABLE `refund_order`
(
    `ID`                    bigint(20) NOT NULL,
    `REFUND_NO`             varchar(50)  DEFAULT NULL COMMENT '聚合支付退款订单号',
    `TRADE_NO`              varchar(50)  DEFAULT NULL COMMENT '聚合支付订单号',
    `MERCHANT_ID`           bigint(20)   DEFAULT NULL COMMENT '所属商户',
    `APP_ID`                varchar(50)  DEFAULT NULL COMMENT '所属应用',
    `PAY_CHANNEL`           varchar(50)  DEFAULT NULL COMMENT '原始支付渠道编码',
    `PAY_CHANNEL_MCH_ID`    varchar(50)  DEFAULT NULL COMMENT '原始渠道商户id',
    `PAY_CHANNEL_TRADE_NO`  varchar(50)  DEFAULT NULL COMMENT '原始渠道订单号',
    `PAY_CHANNEL_REFUND_NO` varchar(50)  DEFAULT NULL COMMENT '原始渠道退款订单号',
    `CHANNEL`               varchar(50)  DEFAULT NULL COMMENT '聚合支付的渠道',
    `OUT_TRADE_NO`          varchar(50)  DEFAULT NULL COMMENT '商户订单号',
    `OUT_REFUND_NO`         varchar(50)  DEFAULT NULL COMMENT '商户退款订单号',
    `PAY_CHANNEL_USER`      varchar(50)  DEFAULT NULL COMMENT '原始渠道用户标识,如微信openId,支付宝账号',
    `PAY_CHANNEL_USERNAME`  varchar(50)  DEFAULT NULL COMMENT '原始渠道用户姓名',
    `CURRENCY`              varchar(50)  DEFAULT NULL COMMENT '币种CNY',
    `TOTAL_AMOUNT`          int(11)      DEFAULT NULL COMMENT '订单总金额，单位为分',
    `REFUND_AMOUNT`         int(11)      DEFAULT NULL COMMENT '退款金额,单位分',
    `OPTIONAL`              varchar(256) DEFAULT NULL COMMENT '用户自定义的参数,商户自定义数据',
    `ANALYSIS`              varchar(256) DEFAULT NULL COMMENT '用于统计分析的数据,用户自定义',
    `EXTRA`                 varchar(512) DEFAULT NULL COMMENT '特定渠道发起时额外参数',
    `REFUND_STATE`          varchar(50)  DEFAULT NULL COMMENT '退款状态:0-订单生成,1-退款中,2-退款成功,3-退款失败,4-业务处理完成',
    `REFUND_RESULT`         varchar(50)  DEFAULT NULL COMMENT '退款结果:0-不确认结果,1-等待手动处理,2-确认成功,3-确认失败',
    `ERROR_CODE`            varchar(50)  DEFAULT NULL COMMENT '渠道支付错误码',
    `ERROR_MSG`             varchar(256) DEFAULT NULL COMMENT '渠道支付错误信息',
    `DEVICE`                varchar(50)  DEFAULT NULL COMMENT '设备',
    `CLIENT_IP`             varchar(50)  DEFAULT NULL COMMENT '客户端IP',
    `CREATE_TIME`           datetime     DEFAULT NULL COMMENT '创建时间',
    `UPDATE_TIME`           datetime     DEFAULT NULL COMMENT '更新时间',
    `EXPIRE_TIME`           datetime     DEFAULT NULL COMMENT '订单过期时间',
    `REFUND_SUCCESS_TIME`   datetime     DEFAULT NULL COMMENT '退款成功时间',
    PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  ROW_FORMAT = DYNAMIC;

SET FOREIGN_KEY_CHECKS = 1;

-- ----------------------------
-- Records of platform_channel
-- ----------------------------
BEGIN;
INSERT INTO `platform_channel`
VALUES (1, '聚合支付B扫C', 'aggregate_pay_b2c');
INSERT INTO `platform_channel`
VALUES (2, '聚合支付C扫B', 'aggregate_pay_c2b');
INSERT INTO `platform_channel`
VALUES (3, '微信Native支付', 'wx_native');
INSERT INTO `platform_channel`
VALUES (4, '支付宝手机网站支付', 'alipay_wap');
COMMIT;
