# sms-api

exported at 2023-02-07 21:42:34

## Project name(项目名称)：sms-backend

Project name(项目名称)：sms-backend
Package(包名): mao.sms_api.controller
Class(类名): SmsSendController
Author(作者）: mao
Author QQ：1296193245
GitHub：https://github.com/maomao124/
Date(创建日期)： 2022/12/25
Time(创建时间)： 20:02
Version(版本): 1.0
Description(描述)： 短信发送接口


---
### 发送短信

> BASIC

**Path:** /sms/send

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| mobile | string | 手机号 |
| template | string | 模板编码 |
| signature | string | 签名编码 |
| params | object | 参数 |
| &ensp;&ensp;&#124;─key | string |  |
| accessKeyId | string | 接入key |
| encryption | string | 认证值 |
| timestamp | string | 发送时间戳 |
| sendTime | string | 定时时间 |

**Request Demo:**

```json
{
  "mobile": "",
  "template": "",
  "signature": "",
  "params": {
    "": ""
  },
  "accessKeyId": "",
  "encryption": "",
  "timestamp": "",
  "sendTime": ""
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | boolean | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": false,
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 批量发送短信

> BASIC

**Path:** /sms/batchSend

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| mobile | array | 手机号集合 |
| &ensp;&ensp;&#124;─ | string |  |
| template | array | 模板编码集合 |
| &ensp;&ensp;&#124;─ | string |  |
| signature | array | 签名编码集合 |
| &ensp;&ensp;&#124;─ | string |  |
| params | array | 参数集合 |
| &ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─key | string |  |
| batchCode | string | 批次编码 |
| accessKeyId | string | 接入key |
| encryption | string | 认证值 |
| timestamp | string | 发送时间戳 |
| sendTime | string | 定时时间 |

**Request Demo:**

```json
{
  "mobile": [
    ""
  ],
  "template": [
    ""
  ],
  "signature": [
    ""
  ],
  "params": [
    {
      "": ""
    }
  ],
  "batchCode": "",
  "accessKeyId": "",
  "encryption": "",
  "timestamp": "",
  "sendTime": ""
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | boolean | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": false,
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```







# aggregate-pay-sms

exported at 2023-02-07 21:42:34

## VerificationController

VerificationController


---
### 生成验证信息

> BASIC

**Path:** /generate

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| name |  | YES | 名字，这里的名字统一为sms |
| effectiveTime |  | YES | 有效时间 |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| key | object |  |

**Request Demo:**

```json
{
  "": {}
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 代码 |
| msg | string | 消息 |
| result | object | 结果 |
| &ensp;&ensp;&#124;─key | string |  |
| &ensp;&ensp;&#124;─content | string | 混淆后的内容<br>举例：<br>1.图片验证码为:图片base64编码<br>2.短信验证码为:null<br>3.邮件验证码为: null<br>4.邮件链接点击验证为：null<br>... |

**Response Demo:**

```json
{
  "code": 0,
  "msg": "",
  "result": {
    "key": "",
    "content": ""
  }
}
```




---
### 验证短信是否正确

> BASIC

**Path:** /verify

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/x-www-form-urlencoded | YES |  |

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| name |  | NO | 名字，这里的名字统一为sms |
| verificationKey |  | NO | 验证的key，例如：sms:530a167172a24677a1cb0c44541b7be8 |
| verificationCode |  | NO | 验证码 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 代码 |
| msg | string | 消息 |
| result | boolean | 结果 |

**Response Demo:**

```json
{
  "code": 0,
  "msg": "",
  "result": false
}
```







# sms-manage

exported at 2023-02-07 21:42:34

## Project name(项目名称)：sms-backend

Project name(项目名称)：sms-backend
Package(包名): mao.sms_manage.controller
Class(类名): TemplateController
Author(作者）: mao
Author QQ：1296193245
GitHub：https://github.com/maomao124/
Date(创建日期)： 2022/12/23
Time(创建时间)： 14:11
Version(版本): 1.0
Description(描述)： 模板


---
### 分页查询

> BASIC

**Path:** /template/page

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| selected | NO | NO | 是否选中 |
| configTemplateCode |  | NO | 配置模板代码 |
| configId |  | NO | 通道id |
| name |  | NO | 模板名称 |
| code |  | NO | 模板编码 |
| content |  | NO | 模板内容 |
| remark |  | NO | 备注 |
| type |  | NO | 类型 |
| id |  | NO | id |
| createTime |  | NO | 创建时间 |
| createUser |  | NO | 创建用户 |
| updateTime |  | NO | 更新时间 |
| updateUser |  | NO | 更新用户 |
| isDelete |  | NO | 是否为逻辑删除 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─records | array |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─name | string | 模板名称 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─code | string | 模板编码 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─content | string | 模板内容 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─remark | string | 备注 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─type | integer | 类型 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─id | string | id |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─createTime | string | 创建时间 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─createUser | string | 创建用户 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─updateTime | string | 更新时间 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─updateUser | string | 更新用户 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─isDelete | integer | 是否为逻辑删除 |
| &ensp;&ensp;&#124;─total | integer |  |
| &ensp;&ensp;&#124;─size | integer |  |
| &ensp;&ensp;&#124;─current | integer |  |
| &ensp;&ensp;&#124;─orders | array |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─column | string |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─asc | boolean |  |
| &ensp;&ensp;&#124;─optimizeCountSql | boolean |  |
| &ensp;&ensp;&#124;─isSearchCount | boolean |  |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "records": [
      {
        "name": "",
        "code": "",
        "content": "",
        "remark": "",
        "type": 0,
        "id": "",
        "createTime": "",
        "createUser": "",
        "updateTime": "",
        "updateUser": "",
        "isDelete": 0
      }
    ],
    "total": 0,
    "size": 0,
    "current": 0,
    "orders": [
      {
        "column": "",
        "asc": false
      }
    ],
    "optimizeCountSql": false,
    "isSearchCount": false
  },
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 自定义分页

> BASIC

**Path:** /template/customPage

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| selected | NO | NO | 是否选中 |
| configTemplateCode |  | NO | 配置模板代码 |
| configId |  | NO | 通道id |
| name |  | NO | 模板名称 |
| code |  | NO | 模板编码 |
| content |  | NO | 模板内容 |
| remark |  | NO | 备注 |
| type |  | NO | 类型 |
| id |  | NO | id |
| createTime |  | NO | 创建时间 |
| createUser |  | NO | 创建用户 |
| updateTime |  | NO | 更新时间 |
| updateUser |  | NO | 更新用户 |
| isDelete |  | NO | 是否为逻辑删除 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─records | array |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─selected | boolean | 是否选中 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─configTemplateCode | string | 配置模板代码 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─configId | string | 通道id |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─name | string | 模板名称 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─code | string | 模板编码 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─content | string | 模板内容 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─remark | string | 备注 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─type | integer | 类型 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─id | string | id |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─createTime | string | 创建时间 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─createUser | string | 创建用户 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─updateTime | string | 更新时间 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─updateUser | string | 更新用户 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─isDelete | integer | 是否为逻辑删除 |
| &ensp;&ensp;&#124;─total | integer |  |
| &ensp;&ensp;&#124;─size | integer |  |
| &ensp;&ensp;&#124;─current | integer |  |
| &ensp;&ensp;&#124;─orders | array |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─column | string |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─asc | boolean |  |
| &ensp;&ensp;&#124;─optimizeCountSql | boolean |  |
| &ensp;&ensp;&#124;─isSearchCount | boolean |  |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "records": [
      {
        "selected": false,
        "configTemplateCode": "",
        "configId": "",
        "name": "",
        "code": "",
        "content": "",
        "remark": "",
        "type": 0,
        "id": "",
        "createTime": "",
        "createUser": "",
        "updateTime": "",
        "updateUser": "",
        "isDelete": 0
      }
    ],
    "total": 0,
    "size": 0,
    "current": 0,
    "orders": [
      {
        "column": "",
        "asc": false
      }
    ],
    "optimizeCountSql": false,
    "isSearchCount": false
  },
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 查询全部

> BASIC

**Path:** /template/list

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| selected | NO | NO | 是否选中 |
| configTemplateCode |  | NO | 配置模板代码 |
| configId |  | NO | 通道id |
| name |  | NO | 模板名称 |
| code |  | NO | 模板编码 |
| content |  | NO | 模板内容 |
| remark |  | NO | 备注 |
| type |  | NO | 类型 |
| id |  | NO | id |
| createTime |  | NO | 创建时间 |
| createUser |  | NO | 创建用户 |
| updateTime |  | NO | 更新时间 |
| updateUser |  | NO | 更新用户 |
| isDelete |  | NO | 是否为逻辑删除 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | array | 调用结果 |
| &ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─name | string | 模板名称 |
| &ensp;&ensp;&ensp;&ensp;&#124;─code | string | 模板编码 |
| &ensp;&ensp;&ensp;&ensp;&#124;─content | string | 模板内容 |
| &ensp;&ensp;&ensp;&ensp;&#124;─remark | string | 备注 |
| &ensp;&ensp;&ensp;&ensp;&#124;─type | integer | 类型 |
| &ensp;&ensp;&ensp;&ensp;&#124;─id | string | id |
| &ensp;&ensp;&ensp;&ensp;&#124;─createTime | string | 创建时间 |
| &ensp;&ensp;&ensp;&ensp;&#124;─createUser | string | 创建用户 |
| &ensp;&ensp;&ensp;&ensp;&#124;─updateTime | string | 更新时间 |
| &ensp;&ensp;&ensp;&ensp;&#124;─updateUser | string | 更新用户 |
| &ensp;&ensp;&ensp;&ensp;&#124;─isDelete | integer | 是否为逻辑删除 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": [
    {
      "name": "",
      "code": "",
      "content": "",
      "remark": "",
      "type": 0,
      "id": "",
      "createTime": "",
      "createUser": "",
      "updateTime": "",
      "updateUser": "",
      "isDelete": 0
    }
  ],
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 根据id查询

> BASIC

**Path:** /template/{id}

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| id |  | id |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─name | string | 模板名称 |
| &ensp;&ensp;&#124;─code | string | 模板编码 |
| &ensp;&ensp;&#124;─content | string | 模板内容 |
| &ensp;&ensp;&#124;─remark | string | 备注 |
| &ensp;&ensp;&#124;─type | integer | 类型 |
| &ensp;&ensp;&#124;─id | string | id |
| &ensp;&ensp;&#124;─createTime | string | 创建时间 |
| &ensp;&ensp;&#124;─createUser | string | 创建用户 |
| &ensp;&ensp;&#124;─updateTime | string | 更新时间 |
| &ensp;&ensp;&#124;─updateUser | string | 更新用户 |
| &ensp;&ensp;&#124;─isDelete | integer | 是否为逻辑删除 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "name": "",
    "code": "",
    "content": "",
    "remark": "",
    "type": 0,
    "id": "",
    "createTime": "",
    "createUser": "",
    "updateTime": "",
    "updateUser": "",
    "isDelete": 0
  },
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 获取参数信息

> BASIC

**Path:** /template/paramFields

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| code |  | YES | 代码 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─key | object |  |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "": {}
  },
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 保存

> BASIC

**Path:** /template

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| name | string | 模板名称 |
| code | string | 模板编码 |
| content | string | 模板内容 |
| remark | string | 备注 |
| type | integer | 类型 |
| id | string | id |
| createTime | string | 创建时间 |
| createUser | string | 创建用户 |
| updateTime | string | 更新时间 |
| updateUser | string | 更新用户 |
| isDelete | integer | 是否为逻辑删除 |

**Request Demo:**

```json
{
  "name": "",
  "code": "",
  "content": "",
  "remark": "",
  "type": 0,
  "id": "",
  "createTime": "",
  "createUser": "",
  "updateTime": "",
  "updateUser": "",
  "isDelete": 0
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | boolean | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": false,
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 构建模板内容

> BASIC

**Path:** /template/build

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| name | string | 模板名称 |
| code | string | 模板编码 |
| content | string | 模板内容 |
| remark | string | 备注 |
| type | integer | 类型 |
| id | string | id |
| createTime | string | 创建时间 |
| createUser | string | 创建用户 |
| updateTime | string | 更新时间 |
| updateUser | string | 更新用户 |
| isDelete | integer | 是否为逻辑删除 |

**Request Demo:**

```json
{
  "name": "",
  "code": "",
  "content": "",
  "remark": "",
  "type": 0,
  "id": "",
  "createTime": "",
  "createUser": "",
  "updateTime": "",
  "updateUser": "",
  "isDelete": 0
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | string | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": "",
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 更新

> BASIC

**Path:** /template

**Method:** PUT

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| name | string | 模板名称 |
| code | string | 模板编码 |
| content | string | 模板内容 |
| remark | string | 备注 |
| type | integer | 类型 |
| id | string | id |
| createTime | string | 创建时间 |
| createUser | string | 创建用户 |
| updateTime | string | 更新时间 |
| updateUser | string | 更新用户 |
| isDelete | integer | 是否为逻辑删除 |

**Request Demo:**

```json
{
  "name": "",
  "code": "",
  "content": "",
  "remark": "",
  "type": 0,
  "id": "",
  "createTime": "",
  "createUser": "",
  "updateTime": "",
  "updateUser": "",
  "isDelete": 0
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | boolean | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": false,
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 删除

> BASIC

**Path:** /template

**Method:** DELETE

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
|  | array | id列表 |
|  | string |  |

**Request Demo:**

```json
[
  ""
]
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | array | 调用结果 |
| &ensp;&ensp;&#124;─ | string |  |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": [
    ""
  ],
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```





## Project name(项目名称)：sms-backend

Project name(项目名称)：sms-backend
Package(包名): mao.sms_manage.controller
Class(类名): SignatureController
Author(作者）: mao
Author QQ：1296193245
GitHub：https://github.com/maomao124/
Date(创建日期)： 2022/12/22
Time(创建时间)： 21:08
Version(版本): 1.0
Description(描述)： 签名


---
### 分页查询

> BASIC

**Path:** /signature/page

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| selected | NO | NO | 是否选中 |
| configSignatureCode |  | NO | 三方通道签名 |
| configId |  | NO | 通道id |
| name |  | NO | 签名名称 |
| code |  | NO | 签名编码 |
| content |  | NO | 签名内容 |
| remark |  | NO | 备注 |
| id |  | NO | id |
| createTime |  | NO | 创建时间 |
| createUser |  | NO | 创建用户 |
| updateTime |  | NO | 更新时间 |
| updateUser |  | NO | 更新用户 |
| isDelete |  | NO | 是否为逻辑删除 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─records | array |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─name | string | 签名名称 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─code | string | 签名编码 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─content | string | 签名内容 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─remark | string | 备注 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─id | string | id |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─createTime | string | 创建时间 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─createUser | string | 创建用户 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─updateTime | string | 更新时间 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─updateUser | string | 更新用户 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─isDelete | integer | 是否为逻辑删除 |
| &ensp;&ensp;&#124;─total | integer |  |
| &ensp;&ensp;&#124;─size | integer |  |
| &ensp;&ensp;&#124;─current | integer |  |
| &ensp;&ensp;&#124;─orders | array |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─column | string |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─asc | boolean |  |
| &ensp;&ensp;&#124;─optimizeCountSql | boolean |  |
| &ensp;&ensp;&#124;─isSearchCount | boolean |  |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "records": [
      {
        "name": "",
        "code": "",
        "content": "",
        "remark": "",
        "id": "",
        "createTime": "",
        "createUser": "",
        "updateTime": "",
        "updateUser": "",
        "isDelete": 0
      }
    ],
    "total": 0,
    "size": 0,
    "current": 0,
    "orders": [
      {
        "column": "",
        "asc": false
      }
    ],
    "optimizeCountSql": false,
    "isSearchCount": false
  },
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 自定义分页

> BASIC

**Path:** /signature/customPage

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| selected | NO | NO | 是否选中 |
| configSignatureCode |  | NO | 三方通道签名 |
| configId |  | NO | 通道id |
| name |  | NO | 签名名称 |
| code |  | NO | 签名编码 |
| content |  | NO | 签名内容 |
| remark |  | NO | 备注 |
| id |  | NO | id |
| createTime |  | NO | 创建时间 |
| createUser |  | NO | 创建用户 |
| updateTime |  | NO | 更新时间 |
| updateUser |  | NO | 更新用户 |
| isDelete |  | NO | 是否为逻辑删除 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─records | array |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─selected | boolean | 是否选中 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─configSignatureCode | string | 三方通道签名 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─configId | string | 通道id |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─name | string | 签名名称 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─code | string | 签名编码 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─content | string | 签名内容 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─remark | string | 备注 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─id | string | id |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─createTime | string | 创建时间 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─createUser | string | 创建用户 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─updateTime | string | 更新时间 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─updateUser | string | 更新用户 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─isDelete | integer | 是否为逻辑删除 |
| &ensp;&ensp;&#124;─total | integer |  |
| &ensp;&ensp;&#124;─size | integer |  |
| &ensp;&ensp;&#124;─current | integer |  |
| &ensp;&ensp;&#124;─orders | array |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─column | string |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─asc | boolean |  |
| &ensp;&ensp;&#124;─optimizeCountSql | boolean |  |
| &ensp;&ensp;&#124;─isSearchCount | boolean |  |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "records": [
      {
        "selected": false,
        "configSignatureCode": "",
        "configId": "",
        "name": "",
        "code": "",
        "content": "",
        "remark": "",
        "id": "",
        "createTime": "",
        "createUser": "",
        "updateTime": "",
        "updateUser": "",
        "isDelete": 0
      }
    ],
    "total": 0,
    "size": 0,
    "current": 0,
    "orders": [
      {
        "column": "",
        "asc": false
      }
    ],
    "optimizeCountSql": false,
    "isSearchCount": false
  },
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 查询全部

> BASIC

**Path:** /signature/list

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| selected | NO | NO | 是否选中 |
| configSignatureCode |  | NO | 三方通道签名 |
| configId |  | NO | 通道id |
| name |  | NO | 签名名称 |
| code |  | NO | 签名编码 |
| content |  | NO | 签名内容 |
| remark |  | NO | 备注 |
| id |  | NO | id |
| createTime |  | NO | 创建时间 |
| createUser |  | NO | 创建用户 |
| updateTime |  | NO | 更新时间 |
| updateUser |  | NO | 更新用户 |
| isDelete |  | NO | 是否为逻辑删除 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | array | 调用结果 |
| &ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─name | string | 签名名称 |
| &ensp;&ensp;&ensp;&ensp;&#124;─code | string | 签名编码 |
| &ensp;&ensp;&ensp;&ensp;&#124;─content | string | 签名内容 |
| &ensp;&ensp;&ensp;&ensp;&#124;─remark | string | 备注 |
| &ensp;&ensp;&ensp;&ensp;&#124;─id | string | id |
| &ensp;&ensp;&ensp;&ensp;&#124;─createTime | string | 创建时间 |
| &ensp;&ensp;&ensp;&ensp;&#124;─createUser | string | 创建用户 |
| &ensp;&ensp;&ensp;&ensp;&#124;─updateTime | string | 更新时间 |
| &ensp;&ensp;&ensp;&ensp;&#124;─updateUser | string | 更新用户 |
| &ensp;&ensp;&ensp;&ensp;&#124;─isDelete | integer | 是否为逻辑删除 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": [
    {
      "name": "",
      "code": "",
      "content": "",
      "remark": "",
      "id": "",
      "createTime": "",
      "createUser": "",
      "updateTime": "",
      "updateUser": "",
      "isDelete": 0
    }
  ],
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 根据id查询签名

> BASIC

**Path:** /signature/{id}

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| id |  | id |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─name | string | 签名名称 |
| &ensp;&ensp;&#124;─code | string | 签名编码 |
| &ensp;&ensp;&#124;─content | string | 签名内容 |
| &ensp;&ensp;&#124;─remark | string | 备注 |
| &ensp;&ensp;&#124;─id | string | id |
| &ensp;&ensp;&#124;─createTime | string | 创建时间 |
| &ensp;&ensp;&#124;─createUser | string | 创建用户 |
| &ensp;&ensp;&#124;─updateTime | string | 更新时间 |
| &ensp;&ensp;&#124;─updateUser | string | 更新用户 |
| &ensp;&ensp;&#124;─isDelete | integer | 是否为逻辑删除 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "name": "",
    "code": "",
    "content": "",
    "remark": "",
    "id": "",
    "createTime": "",
    "createUser": "",
    "updateTime": "",
    "updateUser": "",
    "isDelete": 0
  },
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 保存

> BASIC

**Path:** /signature

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| name | string | 签名名称 |
| code | string | 签名编码 |
| content | string | 签名内容 |
| remark | string | 备注 |
| id | string | id |
| createTime | string | 创建时间 |
| createUser | string | 创建用户 |
| updateTime | string | 更新时间 |
| updateUser | string | 更新用户 |
| isDelete | integer | 是否为逻辑删除 |

**Request Demo:**

```json
{
  "name": "",
  "code": "",
  "content": "",
  "remark": "",
  "id": "",
  "createTime": "",
  "createUser": "",
  "updateTime": "",
  "updateUser": "",
  "isDelete": 0
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | boolean | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": false,
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 更新

> BASIC

**Path:** /signature

**Method:** PUT

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| name | string | 签名名称 |
| code | string | 签名编码 |
| content | string | 签名内容 |
| remark | string | 备注 |
| id | string | id |
| createTime | string | 创建时间 |
| createUser | string | 创建用户 |
| updateTime | string | 更新时间 |
| updateUser | string | 更新用户 |
| isDelete | integer | 是否为逻辑删除 |

**Request Demo:**

```json
{
  "name": "",
  "code": "",
  "content": "",
  "remark": "",
  "id": "",
  "createTime": "",
  "createUser": "",
  "updateTime": "",
  "updateUser": "",
  "isDelete": 0
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | boolean | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": false,
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 删除

> BASIC

**Path:** /signature

**Method:** DELETE

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
|  | array | id列表 |
|  | string |  |

**Request Demo:**

```json
[
  ""
]
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | array | 调用结果 |
| &ensp;&ensp;&#124;─ | string |  |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": [
    ""
  ],
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```





## Project name(项目名称)：sms-backend

Project name(项目名称)：sms-backend
Package(包名): mao.sms_manage.controller
Class(类名): BlackListController
Author(作者）: mao
Author QQ：1296193245
GitHub：https://github.com/maomao124/
Date(创建日期)： 2022/12/21
Time(创建时间)： 21:06
Version(版本): 1.0
Description(描述)： 黑名单


---
### 根据条件分页查询黑名单

> BASIC

**Path:** /blacklist/page

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| type |  | NO | 类型 |
| content |  | NO | 内容，手机号 |
| remark |  | NO | 备注 |
| id |  | NO | id |
| createTime |  | NO | 创建时间 |
| createUser |  | NO | 创建用户 |
| updateTime |  | NO | 更新时间 |
| updateUser |  | NO | 更新用户 |
| isDelete |  | NO | 是否为逻辑删除 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─records | array |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─type | string | 类型 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─content | string | 内容，手机号 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─remark | string | 备注 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─id | string | id |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─createTime | string | 创建时间 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─createUser | string | 创建用户 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─updateTime | string | 更新时间 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─updateUser | string | 更新用户 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─isDelete | integer | 是否为逻辑删除 |
| &ensp;&ensp;&#124;─total | integer |  |
| &ensp;&ensp;&#124;─size | integer |  |
| &ensp;&ensp;&#124;─current | integer |  |
| &ensp;&ensp;&#124;─orders | array |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─column | string |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─asc | boolean |  |
| &ensp;&ensp;&#124;─optimizeCountSql | boolean |  |
| &ensp;&ensp;&#124;─isSearchCount | boolean |  |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "records": [
      {
        "type": "",
        "content": "",
        "remark": "",
        "id": "",
        "createTime": "",
        "createUser": "",
        "updateTime": "",
        "updateUser": "",
        "isDelete": 0
      }
    ],
    "total": 0,
    "size": 0,
    "current": 0,
    "orders": [
      {
        "column": "",
        "asc": false
      }
    ],
    "optimizeCountSql": false,
    "isSearchCount": false
  },
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 根据id查询黑名单

> BASIC

**Path:** /blacklist/{id}

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| id |  | id |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─type | string | 类型 |
| &ensp;&ensp;&#124;─content | string | 内容，手机号 |
| &ensp;&ensp;&#124;─remark | string | 备注 |
| &ensp;&ensp;&#124;─id | string | id |
| &ensp;&ensp;&#124;─createTime | string | 创建时间 |
| &ensp;&ensp;&#124;─createUser | string | 创建用户 |
| &ensp;&ensp;&#124;─updateTime | string | 更新时间 |
| &ensp;&ensp;&#124;─updateUser | string | 更新用户 |
| &ensp;&ensp;&#124;─isDelete | integer | 是否为逻辑删除 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "type": "",
    "content": "",
    "remark": "",
    "id": "",
    "createTime": "",
    "createUser": "",
    "updateTime": "",
    "updateUser": "",
    "isDelete": 0
  },
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 保存

> BASIC

**Path:** /blacklist

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| type | string | 类型 |
| content | string | 内容，手机号 |
| remark | string | 备注 |
| id | string | id |
| createTime | string | 创建时间 |
| createUser | string | 创建用户 |
| updateTime | string | 更新时间 |
| updateUser | string | 更新用户 |
| isDelete | integer | 是否为逻辑删除 |

**Request Demo:**

```json
{
  "type": "",
  "content": "",
  "remark": "",
  "id": "",
  "createTime": "",
  "createUser": "",
  "updateTime": "",
  "updateUser": "",
  "isDelete": 0
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | boolean | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": false,
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 更新

> BASIC

**Path:** /blacklist

**Method:** PUT

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| type | string | 类型 |
| content | string | 内容，手机号 |
| remark | string | 备注 |
| id | string | id |
| createTime | string | 创建时间 |
| createUser | string | 创建用户 |
| updateTime | string | 更新时间 |
| updateUser | string | 更新用户 |
| isDelete | integer | 是否为逻辑删除 |

**Request Demo:**

```json
{
  "type": "",
  "content": "",
  "remark": "",
  "id": "",
  "createTime": "",
  "createUser": "",
  "updateTime": "",
  "updateUser": "",
  "isDelete": 0
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | boolean | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": false,
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 删除

> BASIC

**Path:** /blacklist

**Method:** DELETE

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
|  | array | id列表 |
|  | string |  |

**Request Demo:**

```json
[
  ""
]
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | boolean | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": false,
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 导入的方式添加

> BASIC

**Path:** /blacklist/upload

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | multipart/form-data | YES |  |

**Form:**

| name | value | required | type | desc |
| ------------ | ------------ | ------------ | ------------ | ------------ |
| file |  | YES | file | 文件 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": null,
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```





## Project name(项目名称)：sms-backend

Project name(项目名称)：sms-backend
Package(包名): mao.sms_manage.controller
Class(类名): LogController
Author(作者）: mao
Author QQ：1296193245
GitHub：https://github.com/maomao124/
Date(创建日期)： 2022/12/22
Time(创建时间)： 20:33
Version(版本): 1.0
Description(描述)： 无


---
### 分页查询发送日志

> BASIC

**Path:** /log/sendPage

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| signatureName |  | NO | 签名名字 |
| templateName |  | NO | 模板名称 |
| platformId |  | NO | 平台id |
| platformName |  | NO | 平台名称 |
| configId |  | NO | 配置主键 |
| configPlatform |  | NO | 配置平台 |
| configName |  | NO | 配置名称 |
| template |  | NO | 模板 |
| signature |  | NO | 签名 |
| mobile |  | NO | 手机号 |
| request |  | NO | 请求参数 |
| response |  | NO | 返回参数 |
| error |  | NO | 错误信息 |
| useTime |  | NO | 耗时 |
| status |  | NO | 状态 |
| apiLogId |  | NO | 日志id |
| remark |  | NO | 备注 |
| id |  | NO | id |
| createTime |  | NO | 创建时间 |
| createUser |  | NO | 创建用户 |
| updateTime |  | NO | 更新时间 |
| updateUser |  | NO | 更新用户 |
| isDelete |  | NO | 是否为逻辑删除 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─records | array |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─signatureName | string | 签名名字 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─templateName | string | 模板名称 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─platformId | string | 平台id |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─platformName | string | 平台名称 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─configId | string | 配置主键 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─configPlatform | string | 配置平台 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─configName | string | 配置名称 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─template | string | 模板 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─signature | string | 签名 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─mobile | string | 手机号 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─request | string | 请求参数 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─response | string | 返回参数 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─error | string | 错误信息 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─useTime | integer | 耗时 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─status | integer | 状态 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─apiLogId | string | 日志id |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─remark | string | 备注 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─id | string | id |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─createTime | string | 创建时间 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─createUser | string | 创建用户 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─updateTime | string | 更新时间 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─updateUser | string | 更新用户 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─isDelete | integer | 是否为逻辑删除 |
| &ensp;&ensp;&#124;─total | integer |  |
| &ensp;&ensp;&#124;─size | integer |  |
| &ensp;&ensp;&#124;─current | integer |  |
| &ensp;&ensp;&#124;─orders | array |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─column | string |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─asc | boolean |  |
| &ensp;&ensp;&#124;─optimizeCountSql | boolean |  |
| &ensp;&ensp;&#124;─isSearchCount | boolean |  |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "records": [
      {
        "signatureName": "",
        "templateName": "",
        "platformId": "",
        "platformName": "",
        "configId": "",
        "configPlatform": "",
        "configName": "",
        "template": "",
        "signature": "",
        "mobile": "",
        "request": "",
        "response": "",
        "error": "",
        "useTime": 0,
        "status": 0,
        "apiLogId": "",
        "remark": "",
        "id": "",
        "createTime": "",
        "createUser": "",
        "updateTime": "",
        "updateUser": "",
        "isDelete": 0
      }
    ],
    "total": 0,
    "size": 0,
    "current": 0,
    "orders": [
      {
        "column": "",
        "asc": false
      }
    ],
    "optimizeCountSql": false,
    "isSearchCount": false
  },
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 分页查询接收日志

> BASIC

**Path:** /log/receivePage

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| configName |  | NO | 通道名称 |
| signatureName |  | NO | 签名名字 |
| templateName |  | NO | 模板名称 |
| platformId |  | NO | 接入平台id |
| platformName |  | NO | 接入平台名称 |
| business |  | NO | 业务信息 |
| configIds |  | NO | 配置主键集合 |
| template |  | NO | 模板 |
| signature |  | NO | 签名 |
| mobile |  | NO | 手机号 |
| request |  | NO | 请求参数 |
| error |  | NO | 错误信息 |
| useTime |  | NO | 耗时 |
| apiLogId |  | NO | 日志id |
| status |  | NO | 状态 |
| remark |  | NO | 备注 |
| id |  | NO | id |
| createTime |  | NO | 创建时间 |
| createUser |  | NO | 创建用户 |
| updateTime |  | NO | 更新时间 |
| updateUser |  | NO | 更新用户 |
| isDelete |  | NO | 是否为逻辑删除 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─records | array |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─configName | string | 通道名称 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─signatureName | string | 签名名字 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─templateName | string | 模板名称 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─platformId | string | 接入平台id |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─platformName | string | 接入平台名称 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─business | string | 业务信息 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─configIds | string | 配置主键集合 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─template | string | 模板 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─signature | string | 签名 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─mobile | string | 手机号 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─request | string | 请求参数 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─error | string | 错误信息 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─useTime | integer | 耗时 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─apiLogId | string | 日志id |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─status | integer | 状态 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─remark | string | 备注 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─id | string | id |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─createTime | string | 创建时间 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─createUser | string | 创建用户 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─updateTime | string | 更新时间 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─updateUser | string | 更新用户 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─isDelete | integer | 是否为逻辑删除 |
| &ensp;&ensp;&#124;─total | integer |  |
| &ensp;&ensp;&#124;─size | integer |  |
| &ensp;&ensp;&#124;─current | integer |  |
| &ensp;&ensp;&#124;─orders | array |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─column | string |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─asc | boolean |  |
| &ensp;&ensp;&#124;─optimizeCountSql | boolean |  |
| &ensp;&ensp;&#124;─isSearchCount | boolean |  |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "records": [
      {
        "configName": "",
        "signatureName": "",
        "templateName": "",
        "platformId": "",
        "platformName": "",
        "business": "",
        "configIds": "",
        "template": "",
        "signature": "",
        "mobile": "",
        "request": "",
        "error": "",
        "useTime": 0,
        "apiLogId": "",
        "status": 0,
        "remark": "",
        "id": "",
        "createTime": "",
        "createUser": "",
        "updateTime": "",
        "updateUser": "",
        "isDelete": 0
      }
    ],
    "total": 0,
    "size": 0,
    "current": 0,
    "orders": [
      {
        "column": "",
        "asc": false
      }
    ],
    "optimizeCountSql": false,
    "isSearchCount": false
  },
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 根据id查询发送日志

> BASIC

**Path:** /log/{id}

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| id |  | id |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─configId | string | 配置主键 |
| &ensp;&ensp;&#124;─configPlatform | string | 配置平台 |
| &ensp;&ensp;&#124;─configName | string | 配置名称 |
| &ensp;&ensp;&#124;─template | string | 模板 |
| &ensp;&ensp;&#124;─signature | string | 签名 |
| &ensp;&ensp;&#124;─mobile | string | 手机号 |
| &ensp;&ensp;&#124;─request | string | 请求参数 |
| &ensp;&ensp;&#124;─response | string | 返回参数 |
| &ensp;&ensp;&#124;─error | string | 错误信息 |
| &ensp;&ensp;&#124;─useTime | integer | 耗时 |
| &ensp;&ensp;&#124;─status | integer | 状态 |
| &ensp;&ensp;&#124;─apiLogId | string | 日志id |
| &ensp;&ensp;&#124;─remark | string | 备注 |
| &ensp;&ensp;&#124;─id | string | id |
| &ensp;&ensp;&#124;─createTime | string | 创建时间 |
| &ensp;&ensp;&#124;─createUser | string | 创建用户 |
| &ensp;&ensp;&#124;─updateTime | string | 更新时间 |
| &ensp;&ensp;&#124;─updateUser | string | 更新用户 |
| &ensp;&ensp;&#124;─isDelete | integer | 是否为逻辑删除 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "configId": "",
    "configPlatform": "",
    "configName": "",
    "template": "",
    "signature": "",
    "mobile": "",
    "request": "",
    "response": "",
    "error": "",
    "useTime": 0,
    "status": 0,
    "apiLogId": "",
    "remark": "",
    "id": "",
    "createTime": "",
    "createUser": "",
    "updateTime": "",
    "updateUser": "",
    "isDelete": 0
  },
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 发送记录

> BASIC

**Path:** /log/sendLogPage

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| mobile |  | NO | 手机号 |
| signatureName |  | NO | 签名名字 |
| templateName |  | NO | 模板名称 |
| templateType |  | NO | 模板类型 |
| templateContent |  | NO | 模板内容 |
| platformName |  | NO | 平台名称 |
| contentText |  | NO | 内容文本 |
| status |  | NO | 状态 |
| remark |  | NO | 备注 |
| date |  | NO | 日期 |
| createTime |  | NO | 创建时间 |
| marketingId |  | NO | 营销短信主键 |
| response |  | NO | 响应 |
| error |  | NO | 错误 |
| configPlatform |  | NO | 配置平台 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─records | array |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─mobile | string | 手机号 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─signatureName | string | 签名名字 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─templateName | string | 模板名称 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─templateType | string | 模板类型 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─templateContent | string | 模板内容 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─platformName | string | 平台名称 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─contentText | string | 内容文本 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─status | integer | 状态 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─remark | string | 备注 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─date | string | 日期 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─createTime | string | 创建时间 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─marketingId | string | 营销短信主键 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─response | string | 响应 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─error | string | 错误 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─configPlatform | string | 配置平台 |
| &ensp;&ensp;&#124;─total | integer |  |
| &ensp;&ensp;&#124;─size | integer |  |
| &ensp;&ensp;&#124;─current | integer |  |
| &ensp;&ensp;&#124;─orders | array |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─column | string |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─asc | boolean |  |
| &ensp;&ensp;&#124;─optimizeCountSql | boolean |  |
| &ensp;&ensp;&#124;─isSearchCount | boolean |  |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "records": [
      {
        "mobile": "",
        "signatureName": "",
        "templateName": "",
        "templateType": "",
        "templateContent": "",
        "platformName": "",
        "contentText": "",
        "status": 0,
        "remark": "",
        "date": "",
        "createTime": "",
        "marketingId": "",
        "response": "",
        "error": "",
        "configPlatform": ""
      }
    ],
    "total": 0,
    "size": 0,
    "current": 0,
    "orders": [
      {
        "column": "",
        "asc": false
      }
    ],
    "optimizeCountSql": false,
    "isSearchCount": false
  },
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```





## Project name(项目名称)：sms-backend

Project name(项目名称)：sms-backend
Package(包名): mao.sms_manage.controller
Class(类名): PlatformController
Author(作者）: mao
Author QQ：1296193245
GitHub：https://github.com/maomao124/
Date(创建日期)： 2022/12/22
Time(创建时间)： 20:52
Version(版本): 1.0
Description(描述)： 接入平台


---
### 分页查询

> BASIC

**Path:** /platform/page

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| name |  | NO | 名称" |
| accessKeyId |  | NO | 访问密钥id |
| accessKeySecret |  | NO | 认证 秘钥 |
| ipAddr |  | NO | ip地址 |
| needAuth |  | NO | 需要身份验证 |
| isActive |  | NO | 是否可用 |
| remark |  | NO | 备注 |
| level |  | NO | 等级 |
| id |  | NO | id |
| createTime |  | NO | 创建时间 |
| createUser |  | NO | 创建用户 |
| updateTime |  | NO | 更新时间 |
| updateUser |  | NO | 更新用户 |
| isDelete |  | NO | 是否为逻辑删除 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─records | array |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─name | string | 名称" |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─accessKeyId | string | 访问密钥id |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─accessKeySecret | string | 认证 秘钥 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─ipAddr | string | ip地址 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─needAuth | integer | 需要身份验证 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─isActive | integer | 是否可用 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─remark | string | 备注 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─level | integer | 等级 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─id | string | id |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─createTime | string | 创建时间 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─createUser | string | 创建用户 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─updateTime | string | 更新时间 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─updateUser | string | 更新用户 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─isDelete | integer | 是否为逻辑删除 |
| &ensp;&ensp;&#124;─total | integer |  |
| &ensp;&ensp;&#124;─size | integer |  |
| &ensp;&ensp;&#124;─current | integer |  |
| &ensp;&ensp;&#124;─orders | array |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─column | string |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─asc | boolean |  |
| &ensp;&ensp;&#124;─optimizeCountSql | boolean |  |
| &ensp;&ensp;&#124;─isSearchCount | boolean |  |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "records": [
      {
        "name": "",
        "accessKeyId": "",
        "accessKeySecret": "",
        "ipAddr": "",
        "needAuth": 0,
        "isActive": 0,
        "remark": "",
        "level": 0,
        "id": "",
        "createTime": "",
        "createUser": "",
        "updateTime": "",
        "updateUser": "",
        "isDelete": 0
      }
    ],
    "total": 0,
    "size": 0,
    "current": 0,
    "orders": [
      {
        "column": "",
        "asc": false
      }
    ],
    "optimizeCountSql": false,
    "isSearchCount": false
  },
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 根据id查询平台信息

> BASIC

**Path:** /platform/{id}

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| id |  | id |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─name | string | 名称" |
| &ensp;&ensp;&#124;─accessKeyId | string | 访问密钥id |
| &ensp;&ensp;&#124;─accessKeySecret | string | 认证 秘钥 |
| &ensp;&ensp;&#124;─ipAddr | string | ip地址 |
| &ensp;&ensp;&#124;─needAuth | integer | 需要身份验证 |
| &ensp;&ensp;&#124;─isActive | integer | 是否可用 |
| &ensp;&ensp;&#124;─remark | string | 备注 |
| &ensp;&ensp;&#124;─level | integer | 等级 |
| &ensp;&ensp;&#124;─id | string | id |
| &ensp;&ensp;&#124;─createTime | string | 创建时间 |
| &ensp;&ensp;&#124;─createUser | string | 创建用户 |
| &ensp;&ensp;&#124;─updateTime | string | 更新时间 |
| &ensp;&ensp;&#124;─updateUser | string | 更新用户 |
| &ensp;&ensp;&#124;─isDelete | integer | 是否为逻辑删除 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "name": "",
    "accessKeyId": "",
    "accessKeySecret": "",
    "ipAddr": "",
    "needAuth": 0,
    "isActive": 0,
    "remark": "",
    "level": 0,
    "id": "",
    "createTime": "",
    "createUser": "",
    "updateTime": "",
    "updateUser": "",
    "isDelete": 0
  },
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 保存

> BASIC

**Path:** /platform

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| name | string | 名称" |
| accessKeyId | string | 访问密钥id |
| accessKeySecret | string | 认证 秘钥 |
| ipAddr | string | ip地址 |
| needAuth | integer | 需要身份验证 |
| isActive | integer | 是否可用 |
| remark | string | 备注 |
| level | integer | 等级 |
| id | string | id |
| createTime | string | 创建时间 |
| createUser | string | 创建用户 |
| updateTime | string | 更新时间 |
| updateUser | string | 更新用户 |
| isDelete | integer | 是否为逻辑删除 |

**Request Demo:**

```json
{
  "name": "",
  "accessKeyId": "",
  "accessKeySecret": "",
  "ipAddr": "",
  "needAuth": 0,
  "isActive": 0,
  "remark": "",
  "level": 0,
  "id": "",
  "createTime": "",
  "createUser": "",
  "updateTime": "",
  "updateUser": "",
  "isDelete": 0
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | boolean | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": false,
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 更新

> BASIC

**Path:** /platform

**Method:** PUT

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| name | string | 名称" |
| accessKeyId | string | 访问密钥id |
| accessKeySecret | string | 认证 秘钥 |
| ipAddr | string | ip地址 |
| needAuth | integer | 需要身份验证 |
| isActive | integer | 是否可用 |
| remark | string | 备注 |
| level | integer | 等级 |
| id | string | id |
| createTime | string | 创建时间 |
| createUser | string | 创建用户 |
| updateTime | string | 更新时间 |
| updateUser | string | 更新用户 |
| isDelete | integer | 是否为逻辑删除 |

**Request Demo:**

```json
{
  "name": "",
  "accessKeyId": "",
  "accessKeySecret": "",
  "ipAddr": "",
  "needAuth": 0,
  "isActive": 0,
  "remark": "",
  "level": 0,
  "id": "",
  "createTime": "",
  "createUser": "",
  "updateTime": "",
  "updateUser": "",
  "isDelete": 0
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | boolean | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": false,
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 删除

> BASIC

**Path:** /platform

**Method:** DELETE

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
|  | array | id列表 |
|  | string |  |

**Request Demo:**

```json
[
  ""
]
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | boolean | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": false,
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```





## Project name(项目名称)：sms-backend

Project name(项目名称)：sms-backend
Package(包名): mao.sms_manage.controller
Class(类名): StatisticsController
Author(作者）: mao
Author QQ：1296193245
GitHub：https://github.com/maomao124/
Date(创建日期)： 2022/12/23
Time(创建时间)： 13:40
Version(版本): 1.0
Description(描述)： 统计


---
### 发送量统计(列表)

> BASIC

**Path:** /statistics/count/page

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| signatureName |  | NO | 签名名字 |
| templateName |  | NO | 模板名称 |
| platformId |  | NO | 平台id |
| platformName |  | NO | 平台名称 |
| configId |  | NO | 配置主键 |
| configPlatform |  | NO | 配置平台 |
| configName |  | NO | 配置名称 |
| template |  | NO | 模板 |
| signature |  | NO | 签名 |
| mobile |  | NO | 手机号 |
| request |  | NO | 请求参数 |
| response |  | NO | 返回参数 |
| error |  | NO | 错误信息 |
| useTime |  | NO | 耗时 |
| status |  | NO | 状态 |
| apiLogId |  | NO | 日志id |
| remark |  | NO | 备注 |
| id |  | NO | id |
| createTime |  | NO | 创建时间 |
| createUser |  | NO | 创建用户 |
| updateTime |  | NO | 更新时间 |
| updateUser |  | NO | 更新用户 |
| isDelete |  | NO | 是否为逻辑删除 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─records | array |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─count | integer | 总数 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─success | integer | 成功数 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─fail | integer | 失败数 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─date | string | 日期 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─successRate | string | 成功率 |
| &ensp;&ensp;&#124;─total | integer |  |
| &ensp;&ensp;&#124;─size | integer |  |
| &ensp;&ensp;&#124;─current | integer |  |
| &ensp;&ensp;&#124;─orders | array |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─column | string |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─asc | boolean |  |
| &ensp;&ensp;&#124;─optimizeCountSql | boolean |  |
| &ensp;&ensp;&#124;─isSearchCount | boolean |  |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "records": [
      {
        "count": 0,
        "success": 0,
        "fail": 0,
        "date": "",
        "successRate": ""
      }
    ],
    "total": 0,
    "size": 0,
    "current": 0,
    "orders": [
      {
        "column": "",
        "asc": false
      }
    ],
    "optimizeCountSql": false,
    "isSearchCount": false
  },
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 发送量统计

> BASIC

**Path:** /statistics/count

**Method:** GET

> REQUEST



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─count | integer | 总数 |
| &ensp;&ensp;&#124;─success | integer | 成功数 |
| &ensp;&ensp;&#124;─fail | integer | 失败数 |
| &ensp;&ensp;&#124;─date | string | 日期 |
| &ensp;&ensp;&#124;─successRate | string | 成功率 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "count": 0,
    "success": 0,
    "fail": 0,
    "date": "",
    "successRate": ""
  },
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 发送量趋势

> BASIC

**Path:** /statistics/trend

**Method:** GET

> REQUEST



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─key | object |  |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "": {}
  },
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 各通道成功量（条）

> BASIC

**Path:** /statistics/countForConfig

**Method:** GET

> REQUEST



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | array | 调用结果 |
| &ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─key | object |  |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": [
    {
      "": null
    }
  ],
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 各通道送达率

> BASIC

**Path:** /statistics/rateForConfig

**Method:** GET

> REQUEST



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─key | object |  |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "": {}
  },
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 应用发送数量TOP10

> BASIC

**Path:** /statistics/top10

**Method:** GET

> REQUEST



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─key | object |  |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "": {}
  },
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 营销短信发送量趋势

> BASIC

**Path:** /statistics/marketingTrend

**Method:** GET

> REQUEST



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─key | object |  |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "": {}
  },
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```





## Project name(项目名称)：sms-backend

Project name(项目名称)：sms-backend
Package(包名): mao.sms_manage.controller
Class(类名): ConfigController
Author(作者）: mao
Author QQ：1296193245
GitHub：https://github.com/maomao124/
Date(创建日期)： 2022/12/21
Time(创建时间)： 21:21
Version(版本): 1.0
Description(描述)： 通道配置


---
### 分页查询

> BASIC

**Path:** /config/page

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| lastSuccessNumInAnHour |  | NO | 最近一小时成功的数量 |
| lastSuccessNum |  | NO | 最后成功数量 |
| signatureDTOS[0].selected | NO | NO | 是否选中 |
| signatureDTOS[0].configSignatureCode |  | NO | 三方通道签名 |
| signatureDTOS[0].configId |  | NO | 通道id |
| signatureDTOS[0].name |  | NO | 签名名称 |
| signatureDTOS[0].code |  | NO | 签名编码 |
| signatureDTOS[0].content |  | NO | 签名内容 |
| signatureDTOS[0].remark |  | NO | 备注 |
| signatureDTOS[0].id |  | NO | id |
| signatureDTOS[0].createTime |  | NO | 创建时间 |
| signatureDTOS[0].createUser |  | NO | 创建用户 |
| signatureDTOS[0].updateTime |  | NO | 更新时间 |
| signatureDTOS[0].updateUser |  | NO | 更新用户 |
| signatureDTOS[0].isDelete |  | NO | 是否为逻辑删除 |
| signatureIds[0] |  | NO | 签名id集合 |
| templateDTOS[0].selected | NO | NO | 是否选中 |
| templateDTOS[0].configTemplateCode |  | NO | 配置模板代码 |
| templateDTOS[0].configId |  | NO | 通道id |
| templateDTOS[0].name |  | NO | 模板名称 |
| templateDTOS[0].code |  | NO | 模板编码 |
| templateDTOS[0].content |  | NO | 模板内容 |
| templateDTOS[0].remark |  | NO | 备注 |
| templateDTOS[0].type |  | NO | 类型 |
| templateDTOS[0].id |  | NO | id |
| templateDTOS[0].createTime |  | NO | 创建时间 |
| templateDTOS[0].createUser |  | NO | 创建用户 |
| templateDTOS[0].updateTime |  | NO | 更新时间 |
| templateDTOS[0].updateUser |  | NO | 更新用户 |
| templateDTOS[0].isDelete |  | NO | 是否为逻辑删除 |
| templateIds[0] |  | NO | 模板id集合 |
| platformDTO.name |  | NO | 名称" |
| platformDTO.accessKeyId |  | NO | 访问密钥id |
| platformDTO.accessKeySecret |  | NO | 认证 秘钥 |
| platformDTO.ipAddr |  | NO | ip地址 |
| platformDTO.needAuth |  | NO | 需要身份验证 |
| platformDTO.isActive |  | NO | 是否可用 |
| platformDTO.remark |  | NO | 备注 |
| platformDTO.level |  | NO | 等级 |
| platformDTO.id |  | NO | id |
| platformDTO.createTime |  | NO | 创建时间 |
| platformDTO.createUser |  | NO | 创建用户 |
| platformDTO.updateTime |  | NO | 更新时间 |
| platformDTO.updateUser |  | NO | 更新用户 |
| platformDTO.isDelete |  | NO | 是否为逻辑删除 |
| name |  | NO | 名字 |
| platform |  | NO | 平台 |
| domain |  | NO | 域名 |
| accessKeyId |  | NO | 访问密钥id |
| accessKeySecret |  | NO | 秘钥值 |
| other |  | NO | 其他配置 |
| isActive |  | NO | 是否可用 |
| isEnable |  | NO | 是否开启 |
| remark |  | NO | 备注 |
| level |  | NO | 级别，这个字段会动态地调节级别 |
| channelType |  | NO | 通道类型 |
| id |  | NO | id |
| createTime |  | NO | 创建时间 |
| createUser |  | NO | 创建用户 |
| updateTime |  | NO | 更新时间 |
| updateUser |  | NO | 更新用户 |
| isDelete |  | NO | 是否为逻辑删除 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─records | array |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─name | string | 名字 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─platform | string | 平台 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─domain | string | 域名 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─accessKeyId | string | 访问密钥id |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─accessKeySecret | string | 秘钥值 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─other | string | 其他配置 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─isActive | integer | 是否可用 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─isEnable | integer | 是否开启 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─remark | string | 备注 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─level | integer | 级别，这个字段会动态地调节级别 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─channelType | integer | 通道类型 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─id | string | id |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─createTime | string | 创建时间 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─createUser | string | 创建用户 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─updateTime | string | 更新时间 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─updateUser | string | 更新用户 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─isDelete | integer | 是否为逻辑删除 |
| &ensp;&ensp;&#124;─total | integer |  |
| &ensp;&ensp;&#124;─size | integer |  |
| &ensp;&ensp;&#124;─current | integer |  |
| &ensp;&ensp;&#124;─orders | array |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─column | string |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─asc | boolean |  |
| &ensp;&ensp;&#124;─optimizeCountSql | boolean |  |
| &ensp;&ensp;&#124;─isSearchCount | boolean |  |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "records": [
      {
        "name": "",
        "platform": "",
        "domain": "",
        "accessKeyId": "",
        "accessKeySecret": "",
        "other": "",
        "isActive": 0,
        "isEnable": 0,
        "remark": "",
        "level": 0,
        "channelType": 0,
        "id": "",
        "createTime": "",
        "createUser": "",
        "updateTime": "",
        "updateUser": "",
        "isDelete": 0
      }
    ],
    "total": 0,
    "size": 0,
    "current": 0,
    "orders": [
      {
        "column": "",
        "asc": false
      }
    ],
    "optimizeCountSql": false,
    "isSearchCount": false
  },
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 根据id查询通道信息

> BASIC

**Path:** /config/{id}

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| id |  | id |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─lastSuccessNumInAnHour | integer | 最近一小时成功的数量 |
| &ensp;&ensp;&#124;─lastSuccessNum | integer | 最后成功数量 |
| &ensp;&ensp;&#124;─signatureDTOS | array | 签名信息 |
| &ensp;&ensp;&ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─selected | boolean | 是否选中 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─configSignatureCode | string | 三方通道签名 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─configId | string | 通道id |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─name | string | 签名名称 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─code | string | 签名编码 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─content | string | 签名内容 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─remark | string | 备注 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─id | string | id |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─createTime | string | 创建时间 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─createUser | string | 创建用户 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─updateTime | string | 更新时间 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─updateUser | string | 更新用户 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─isDelete | integer | 是否为逻辑删除 |
| &ensp;&ensp;&#124;─signatureIds | array | 签名id集合 |
| &ensp;&ensp;&ensp;&ensp;&#124;─ | string |  |
| &ensp;&ensp;&#124;─templateDTOS | array | 模板信息 |
| &ensp;&ensp;&ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─selected | boolean | 是否选中 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─configTemplateCode | string | 配置模板代码 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─configId | string | 通道id |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─name | string | 模板名称 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─code | string | 模板编码 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─content | string | 模板内容 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─remark | string | 备注 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─type | integer | 类型 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─id | string | id |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─createTime | string | 创建时间 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─createUser | string | 创建用户 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─updateTime | string | 更新时间 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─updateUser | string | 更新用户 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─isDelete | integer | 是否为逻辑删除 |
| &ensp;&ensp;&#124;─templateIds | array | 模板id集合 |
| &ensp;&ensp;&ensp;&ensp;&#124;─ | string |  |
| &ensp;&ensp;&#124;─platformDTO | object | 平台dto |
| &ensp;&ensp;&ensp;&ensp;&#124;─name | string | 名称" |
| &ensp;&ensp;&ensp;&ensp;&#124;─accessKeyId | string | 访问密钥id |
| &ensp;&ensp;&ensp;&ensp;&#124;─accessKeySecret | string | 认证 秘钥 |
| &ensp;&ensp;&ensp;&ensp;&#124;─ipAddr | string | ip地址 |
| &ensp;&ensp;&ensp;&ensp;&#124;─needAuth | integer | 需要身份验证 |
| &ensp;&ensp;&ensp;&ensp;&#124;─isActive | integer | 是否可用 |
| &ensp;&ensp;&ensp;&ensp;&#124;─remark | string | 备注 |
| &ensp;&ensp;&ensp;&ensp;&#124;─level | integer | 等级 |
| &ensp;&ensp;&ensp;&ensp;&#124;─id | string | id |
| &ensp;&ensp;&ensp;&ensp;&#124;─createTime | string | 创建时间 |
| &ensp;&ensp;&ensp;&ensp;&#124;─createUser | string | 创建用户 |
| &ensp;&ensp;&ensp;&ensp;&#124;─updateTime | string | 更新时间 |
| &ensp;&ensp;&ensp;&ensp;&#124;─updateUser | string | 更新用户 |
| &ensp;&ensp;&ensp;&ensp;&#124;─isDelete | integer | 是否为逻辑删除 |
| &ensp;&ensp;&#124;─name | string | 名字 |
| &ensp;&ensp;&#124;─platform | string | 平台 |
| &ensp;&ensp;&#124;─domain | string | 域名 |
| &ensp;&ensp;&#124;─accessKeyId | string | 访问密钥id |
| &ensp;&ensp;&#124;─accessKeySecret | string | 秘钥值 |
| &ensp;&ensp;&#124;─other | string | 其他配置 |
| &ensp;&ensp;&#124;─isActive | integer | 是否可用 |
| &ensp;&ensp;&#124;─isEnable | integer | 是否开启 |
| &ensp;&ensp;&#124;─remark | string | 备注 |
| &ensp;&ensp;&#124;─level | integer | 级别，这个字段会动态地调节级别 |
| &ensp;&ensp;&#124;─channelType | integer | 通道类型 |
| &ensp;&ensp;&#124;─id | string | id |
| &ensp;&ensp;&#124;─createTime | string | 创建时间 |
| &ensp;&ensp;&#124;─createUser | string | 创建用户 |
| &ensp;&ensp;&#124;─updateTime | string | 更新时间 |
| &ensp;&ensp;&#124;─updateUser | string | 更新用户 |
| &ensp;&ensp;&#124;─isDelete | integer | 是否为逻辑删除 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "lastSuccessNumInAnHour": 0,
    "lastSuccessNum": 0,
    "signatureDTOS": [
      {
        "selected": false,
        "configSignatureCode": "",
        "configId": "",
        "name": "",
        "code": "",
        "content": "",
        "remark": "",
        "id": "",
        "createTime": "",
        "createUser": "",
        "updateTime": "",
        "updateUser": "",
        "isDelete": 0
      }
    ],
    "signatureIds": [
      ""
    ],
    "templateDTOS": [
      {
        "selected": false,
        "configTemplateCode": "",
        "configId": "",
        "name": "",
        "code": "",
        "content": "",
        "remark": "",
        "type": 0,
        "id": "",
        "createTime": "",
        "createUser": "",
        "updateTime": "",
        "updateUser": "",
        "isDelete": 0
      }
    ],
    "templateIds": [
      ""
    ],
    "platformDTO": {
      "name": "",
      "accessKeyId": "",
      "accessKeySecret": "",
      "ipAddr": "",
      "needAuth": 0,
      "isActive": 0,
      "remark": "",
      "level": 0,
      "id": "",
      "createTime": "",
      "createUser": "",
      "updateTime": "",
      "updateUser": "",
      "isDelete": 0
    },
    "name": "",
    "platform": "",
    "domain": "",
    "accessKeyId": "",
    "accessKeySecret": "",
    "other": "",
    "isActive": 0,
    "isEnable": 0,
    "remark": "",
    "level": 0,
    "channelType": 0,
    "id": "",
    "createTime": "",
    "createUser": "",
    "updateTime": "",
    "updateUser": "",
    "isDelete": 0
  },
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 保存

> BASIC

**Path:** /config

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| lastSuccessNumInAnHour | integer | 最近一小时成功的数量 |
| lastSuccessNum | integer | 最后成功数量 |
| signatureDTOS | array | 签名信息 |
| &ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─selected | boolean | 是否选中 |
| &ensp;&ensp;&ensp;&ensp;&#124;─configSignatureCode | string | 三方通道签名 |
| &ensp;&ensp;&ensp;&ensp;&#124;─configId | string | 通道id |
| &ensp;&ensp;&ensp;&ensp;&#124;─name | string | 签名名称 |
| &ensp;&ensp;&ensp;&ensp;&#124;─code | string | 签名编码 |
| &ensp;&ensp;&ensp;&ensp;&#124;─content | string | 签名内容 |
| &ensp;&ensp;&ensp;&ensp;&#124;─remark | string | 备注 |
| &ensp;&ensp;&ensp;&ensp;&#124;─id | string | id |
| &ensp;&ensp;&ensp;&ensp;&#124;─createTime | string | 创建时间 |
| &ensp;&ensp;&ensp;&ensp;&#124;─createUser | string | 创建用户 |
| &ensp;&ensp;&ensp;&ensp;&#124;─updateTime | string | 更新时间 |
| &ensp;&ensp;&ensp;&ensp;&#124;─updateUser | string | 更新用户 |
| &ensp;&ensp;&ensp;&ensp;&#124;─isDelete | integer | 是否为逻辑删除 |
| signatureIds | array | 签名id集合 |
| &ensp;&ensp;&#124;─ | string |  |
| templateDTOS | array | 模板信息 |
| &ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─selected | boolean | 是否选中 |
| &ensp;&ensp;&ensp;&ensp;&#124;─configTemplateCode | string | 配置模板代码 |
| &ensp;&ensp;&ensp;&ensp;&#124;─configId | string | 通道id |
| &ensp;&ensp;&ensp;&ensp;&#124;─name | string | 模板名称 |
| &ensp;&ensp;&ensp;&ensp;&#124;─code | string | 模板编码 |
| &ensp;&ensp;&ensp;&ensp;&#124;─content | string | 模板内容 |
| &ensp;&ensp;&ensp;&ensp;&#124;─remark | string | 备注 |
| &ensp;&ensp;&ensp;&ensp;&#124;─type | integer | 类型 |
| &ensp;&ensp;&ensp;&ensp;&#124;─id | string | id |
| &ensp;&ensp;&ensp;&ensp;&#124;─createTime | string | 创建时间 |
| &ensp;&ensp;&ensp;&ensp;&#124;─createUser | string | 创建用户 |
| &ensp;&ensp;&ensp;&ensp;&#124;─updateTime | string | 更新时间 |
| &ensp;&ensp;&ensp;&ensp;&#124;─updateUser | string | 更新用户 |
| &ensp;&ensp;&ensp;&ensp;&#124;─isDelete | integer | 是否为逻辑删除 |
| templateIds | array | 模板id集合 |
| &ensp;&ensp;&#124;─ | string |  |
| platformDTO | object | 平台dto |
| &ensp;&ensp;&#124;─name | string | 名称" |
| &ensp;&ensp;&#124;─accessKeyId | string | 访问密钥id |
| &ensp;&ensp;&#124;─accessKeySecret | string | 认证 秘钥 |
| &ensp;&ensp;&#124;─ipAddr | string | ip地址 |
| &ensp;&ensp;&#124;─needAuth | integer | 需要身份验证 |
| &ensp;&ensp;&#124;─isActive | integer | 是否可用 |
| &ensp;&ensp;&#124;─remark | string | 备注 |
| &ensp;&ensp;&#124;─level | integer | 等级 |
| &ensp;&ensp;&#124;─id | string | id |
| &ensp;&ensp;&#124;─createTime | string | 创建时间 |
| &ensp;&ensp;&#124;─createUser | string | 创建用户 |
| &ensp;&ensp;&#124;─updateTime | string | 更新时间 |
| &ensp;&ensp;&#124;─updateUser | string | 更新用户 |
| &ensp;&ensp;&#124;─isDelete | integer | 是否为逻辑删除 |
| name | string | 名字 |
| platform | string | 平台 |
| domain | string | 域名 |
| accessKeyId | string | 访问密钥id |
| accessKeySecret | string | 秘钥值 |
| other | string | 其他配置 |
| isActive | integer | 是否可用 |
| isEnable | integer | 是否开启 |
| remark | string | 备注 |
| level | integer | 级别，这个字段会动态地调节级别 |
| channelType | integer | 通道类型 |
| id | string | id |
| createTime | string | 创建时间 |
| createUser | string | 创建用户 |
| updateTime | string | 更新时间 |
| updateUser | string | 更新用户 |
| isDelete | integer | 是否为逻辑删除 |

**Request Demo:**

```json
{
  "lastSuccessNumInAnHour": 0,
  "lastSuccessNum": 0,
  "signatureDTOS": [
    {
      "selected": false,
      "configSignatureCode": "",
      "configId": "",
      "name": "",
      "code": "",
      "content": "",
      "remark": "",
      "id": "",
      "createTime": "",
      "createUser": "",
      "updateTime": "",
      "updateUser": "",
      "isDelete": 0
    }
  ],
  "signatureIds": [
    ""
  ],
  "templateDTOS": [
    {
      "selected": false,
      "configTemplateCode": "",
      "configId": "",
      "name": "",
      "code": "",
      "content": "",
      "remark": "",
      "type": 0,
      "id": "",
      "createTime": "",
      "createUser": "",
      "updateTime": "",
      "updateUser": "",
      "isDelete": 0
    }
  ],
  "templateIds": [
    ""
  ],
  "platformDTO": {
    "name": "",
    "accessKeyId": "",
    "accessKeySecret": "",
    "ipAddr": "",
    "needAuth": 0,
    "isActive": 0,
    "remark": "",
    "level": 0,
    "id": "",
    "createTime": "",
    "createUser": "",
    "updateTime": "",
    "updateUser": "",
    "isDelete": 0
  },
  "name": "",
  "platform": "",
  "domain": "",
  "accessKeyId": "",
  "accessKeySecret": "",
  "other": "",
  "isActive": 0,
  "isEnable": 0,
  "remark": "",
  "level": 0,
  "channelType": 0,
  "id": "",
  "createTime": "",
  "createUser": "",
  "updateTime": "",
  "updateUser": "",
  "isDelete": 0
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | boolean | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": false,
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 排序

> BASIC

**Path:** /config/level

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
|  | array | id列表 |
|  | string |  |

**Request Demo:**

```json
[
  ""
]
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | boolean | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": false,
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 更新

> BASIC

**Path:** /config

**Method:** PUT

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| lastSuccessNumInAnHour | integer | 最近一小时成功的数量 |
| lastSuccessNum | integer | 最后成功数量 |
| signatureDTOS | array | 签名信息 |
| &ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─selected | boolean | 是否选中 |
| &ensp;&ensp;&ensp;&ensp;&#124;─configSignatureCode | string | 三方通道签名 |
| &ensp;&ensp;&ensp;&ensp;&#124;─configId | string | 通道id |
| &ensp;&ensp;&ensp;&ensp;&#124;─name | string | 签名名称 |
| &ensp;&ensp;&ensp;&ensp;&#124;─code | string | 签名编码 |
| &ensp;&ensp;&ensp;&ensp;&#124;─content | string | 签名内容 |
| &ensp;&ensp;&ensp;&ensp;&#124;─remark | string | 备注 |
| &ensp;&ensp;&ensp;&ensp;&#124;─id | string | id |
| &ensp;&ensp;&ensp;&ensp;&#124;─createTime | string | 创建时间 |
| &ensp;&ensp;&ensp;&ensp;&#124;─createUser | string | 创建用户 |
| &ensp;&ensp;&ensp;&ensp;&#124;─updateTime | string | 更新时间 |
| &ensp;&ensp;&ensp;&ensp;&#124;─updateUser | string | 更新用户 |
| &ensp;&ensp;&ensp;&ensp;&#124;─isDelete | integer | 是否为逻辑删除 |
| signatureIds | array | 签名id集合 |
| &ensp;&ensp;&#124;─ | string |  |
| templateDTOS | array | 模板信息 |
| &ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─selected | boolean | 是否选中 |
| &ensp;&ensp;&ensp;&ensp;&#124;─configTemplateCode | string | 配置模板代码 |
| &ensp;&ensp;&ensp;&ensp;&#124;─configId | string | 通道id |
| &ensp;&ensp;&ensp;&ensp;&#124;─name | string | 模板名称 |
| &ensp;&ensp;&ensp;&ensp;&#124;─code | string | 模板编码 |
| &ensp;&ensp;&ensp;&ensp;&#124;─content | string | 模板内容 |
| &ensp;&ensp;&ensp;&ensp;&#124;─remark | string | 备注 |
| &ensp;&ensp;&ensp;&ensp;&#124;─type | integer | 类型 |
| &ensp;&ensp;&ensp;&ensp;&#124;─id | string | id |
| &ensp;&ensp;&ensp;&ensp;&#124;─createTime | string | 创建时间 |
| &ensp;&ensp;&ensp;&ensp;&#124;─createUser | string | 创建用户 |
| &ensp;&ensp;&ensp;&ensp;&#124;─updateTime | string | 更新时间 |
| &ensp;&ensp;&ensp;&ensp;&#124;─updateUser | string | 更新用户 |
| &ensp;&ensp;&ensp;&ensp;&#124;─isDelete | integer | 是否为逻辑删除 |
| templateIds | array | 模板id集合 |
| &ensp;&ensp;&#124;─ | string |  |
| platformDTO | object | 平台dto |
| &ensp;&ensp;&#124;─name | string | 名称" |
| &ensp;&ensp;&#124;─accessKeyId | string | 访问密钥id |
| &ensp;&ensp;&#124;─accessKeySecret | string | 认证 秘钥 |
| &ensp;&ensp;&#124;─ipAddr | string | ip地址 |
| &ensp;&ensp;&#124;─needAuth | integer | 需要身份验证 |
| &ensp;&ensp;&#124;─isActive | integer | 是否可用 |
| &ensp;&ensp;&#124;─remark | string | 备注 |
| &ensp;&ensp;&#124;─level | integer | 等级 |
| &ensp;&ensp;&#124;─id | string | id |
| &ensp;&ensp;&#124;─createTime | string | 创建时间 |
| &ensp;&ensp;&#124;─createUser | string | 创建用户 |
| &ensp;&ensp;&#124;─updateTime | string | 更新时间 |
| &ensp;&ensp;&#124;─updateUser | string | 更新用户 |
| &ensp;&ensp;&#124;─isDelete | integer | 是否为逻辑删除 |
| name | string | 名字 |
| platform | string | 平台 |
| domain | string | 域名 |
| accessKeyId | string | 访问密钥id |
| accessKeySecret | string | 秘钥值 |
| other | string | 其他配置 |
| isActive | integer | 是否可用 |
| isEnable | integer | 是否开启 |
| remark | string | 备注 |
| level | integer | 级别，这个字段会动态地调节级别 |
| channelType | integer | 通道类型 |
| id | string | id |
| createTime | string | 创建时间 |
| createUser | string | 创建用户 |
| updateTime | string | 更新时间 |
| updateUser | string | 更新用户 |
| isDelete | integer | 是否为逻辑删除 |

**Request Demo:**

```json
{
  "lastSuccessNumInAnHour": 0,
  "lastSuccessNum": 0,
  "signatureDTOS": [
    {
      "selected": false,
      "configSignatureCode": "",
      "configId": "",
      "name": "",
      "code": "",
      "content": "",
      "remark": "",
      "id": "",
      "createTime": "",
      "createUser": "",
      "updateTime": "",
      "updateUser": "",
      "isDelete": 0
    }
  ],
  "signatureIds": [
    ""
  ],
  "templateDTOS": [
    {
      "selected": false,
      "configTemplateCode": "",
      "configId": "",
      "name": "",
      "code": "",
      "content": "",
      "remark": "",
      "type": 0,
      "id": "",
      "createTime": "",
      "createUser": "",
      "updateTime": "",
      "updateUser": "",
      "isDelete": 0
    }
  ],
  "templateIds": [
    ""
  ],
  "platformDTO": {
    "name": "",
    "accessKeyId": "",
    "accessKeySecret": "",
    "ipAddr": "",
    "needAuth": 0,
    "isActive": 0,
    "remark": "",
    "level": 0,
    "id": "",
    "createTime": "",
    "createUser": "",
    "updateTime": "",
    "updateUser": "",
    "isDelete": 0
  },
  "name": "",
  "platform": "",
  "domain": "",
  "accessKeyId": "",
  "accessKeySecret": "",
  "other": "",
  "isActive": 0,
  "isEnable": 0,
  "remark": "",
  "level": 0,
  "channelType": 0,
  "id": "",
  "createTime": "",
  "createUser": "",
  "updateTime": "",
  "updateUser": "",
  "isDelete": 0
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | boolean | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": false,
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 关联内修改

> BASIC

**Path:** /config/other

**Method:** PUT

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| signatureId | string | 签名id |
| configSignatureCode | string | 三方通道签名 |
| templateId | string | 模板id |
| configTemplateCode | string | 三方通道模板 |
| configId | string | 通道id |

**Request Demo:**

```json
{
  "signatureId": "",
  "configSignatureCode": "",
  "templateId": "",
  "configTemplateCode": "",
  "configId": ""
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | boolean | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": false,
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 删除

> BASIC

**Path:** /config

**Method:** DELETE

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
|  | array | id列表 |
|  | string |  |

**Request Demo:**

```json
[
  ""
]
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | boolean | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": false,
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```







# aggregate-pay-user-service

exported at 2023-02-07 21:42:34

## Project name(项目名称)：aggregate-pay

Project name(项目名称)：aggregate-pay
Package(包名): mao.aggregate_pay_user_service.controller
Class(类名): ResourceControllerV2
Author(作者）: mao
Author QQ：1296193245
GitHub：https://github.com/maomao124/
Date(创建日期)： 2023/1/20
Time(创建时间)： 22:32
Version(版本): 1.0
Description(描述)： 无


---
### 创建应用

> BASIC

**Path:** /v2/apps

**Method:** POST

**Desc:**

 会关联创建uaa服务中的接入客户端，其中code为clientId

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| id | integer | id |
| name | string | 应用名称 |
| code | string | 应用编码 |
| tenantId | integer | 应用所属租户 |

**Request Demo:**

```json
{
  "id": 0,
  "name": "",
  "code": "",
  "tenantId": 0
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | boolean | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": false,
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 修改应用程序

> BASIC

**Path:** /v2/apps

**Method:** PUT

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| id | integer | id |
| name | string | 应用名称 |
| code | string | 应用编码 |
| tenantId | integer | 应用所属租户 |

**Request Demo:**

```json
{
  "id": 0,
  "name": "",
  "code": "",
  "tenantId": 0
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | boolean | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": false,
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 删除应用程序

> BASIC

**Path:** /v2/apps/{applicationCode}

**Method:** DELETE

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| applicationCode |  | 应用程序代码 |

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/x-www-form-urlencoded | YES |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | boolean | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": false,
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 查询应用程序

> BASIC

**Path:** /v2/apps/{applicationCode}

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| applicationCode |  | 应用程序代码 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─id | integer | id |
| &ensp;&ensp;&#124;─name | string | 应用名称 |
| &ensp;&ensp;&#124;─code | string | 应用编码 |
| &ensp;&ensp;&#124;─tenantId | integer | 应用所属租户 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "id": 0,
    "name": "",
    "code": "",
    "tenantId": 0
  },
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 分页条件查找应用

> BASIC

**Path:** /v2/apps/page

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| pageNo |  | YES | 页号 |
| pageSize |  | YES | 页面大小 |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| name | string | 应用名称 |

**Request Demo:**

```json
{
  "name": ""
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | array | 调用结果 |
| &ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─id | integer | id |
| &ensp;&ensp;&ensp;&ensp;&#124;─name | string | 应用名称 |
| &ensp;&ensp;&ensp;&ensp;&#124;─code | string | 应用编码 |
| &ensp;&ensp;&ensp;&ensp;&#124;─tenantId | integer | 应用所属租户 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": [
    {
      "id": 0,
      "name": "",
      "code": "",
      "tenantId": 0
    }
  ],
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 根据权限加载指定应用的资源

> BASIC

**Path:** /v2/apps/privileges/resources/{applicationCode}

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| applicationCode |  | 应用程序代码 |

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| privileageCodes |  | YES | privileage代码 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | array | 调用结果 |
| &ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─applicationCode | string | 应用程序代码 |
| &ensp;&ensp;&ensp;&ensp;&#124;─applicationName | string | 应用程序名称 |
| &ensp;&ensp;&ensp;&ensp;&#124;─appRes | object | 按资源类型分包括菜单等资源信息 如  menu:JSONObject |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─key | object |  |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": [
    {
      "applicationCode": "",
      "applicationName": "",
      "appRes": {
        "": {}
      }
    }
  ],
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 获取多个租户下权限所对应的的资源信息，并按应用拆分

> BASIC

**Path:** /v2/tenants/apps/privileges/resources

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| 0 | object |  |
| &ensp;&ensp;&#124;─rolePrivilegeMap | object | 角色-权限列表 映射 |
| &ensp;&ensp;&ensp;&ensp;&#124;─key | array |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─ | string |  |

**Request Demo:**

```json
{
  "0": {
    "rolePrivilegeMap": {
      "": [
        ""
      ]
    }
  }
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─0 | array |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─applicationCode | string | 应用程序代码 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─applicationName | string | 应用程序名称 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─appRes | object | 按资源类型分包括菜单等资源信息 如  menu:JSONObject |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─key | object |  |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "0": [
      {
        "applicationCode": "",
        "applicationName": "",
        "appRes": {
          "": {}
        }
      }
    ]
  },
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 查询菜单

> BASIC

**Path:** /v2/menus/{id}

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| id |  | id |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─id | integer | id |
| &ensp;&ensp;&#124;─parentId | integer | 菜单父级id |
| &ensp;&ensp;&#124;─title | string | 标题 |
| &ensp;&ensp;&#124;─url | string | 菜单跳转url |
| &ensp;&ensp;&#124;─code | string | 页面标识 |
| &ensp;&ensp;&#124;─icon | string | 图标 |
| &ensp;&ensp;&#124;─sort | integer | 排序 |
| &ensp;&ensp;&#124;─comment | string | 说明 |
| &ensp;&ensp;&#124;─applicationCode | string | 所属应用编码 |
| &ensp;&ensp;&#124;─application | string | 所属应用 |
| &ensp;&ensp;&#124;─privilegeCode | string | 绑定的权限编码 |
| &ensp;&ensp;&#124;─status | integer | 状态 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "id": 0,
    "parentId": 0,
    "title": "",
    "url": "",
    "code": "",
    "icon": "",
    "sort": 0,
    "comment": "",
    "applicationCode": "",
    "application": "",
    "privilegeCode": "",
    "status": 0
  },
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 根据应用编码查询菜单列表

> BASIC

**Path:** /v2/menus/{applicationCode}/menu-list

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| applicationCode |  | 应用程序代码 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | array | 调用结果 |
| &ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─id | integer | id |
| &ensp;&ensp;&ensp;&ensp;&#124;─parentId | integer | 菜单父级id |
| &ensp;&ensp;&ensp;&ensp;&#124;─title | string | 标题 |
| &ensp;&ensp;&ensp;&ensp;&#124;─url | string | 菜单跳转url |
| &ensp;&ensp;&ensp;&ensp;&#124;─code | string | 页面标识 |
| &ensp;&ensp;&ensp;&ensp;&#124;─icon | string | 图标 |
| &ensp;&ensp;&ensp;&ensp;&#124;─sort | integer | 排序 |
| &ensp;&ensp;&ensp;&ensp;&#124;─comment | string | 说明 |
| &ensp;&ensp;&ensp;&ensp;&#124;─applicationCode | string | 所属应用编码 |
| &ensp;&ensp;&ensp;&ensp;&#124;─application | string | 所属应用 |
| &ensp;&ensp;&ensp;&ensp;&#124;─privilegeCode | string | 绑定的权限编码 |
| &ensp;&ensp;&ensp;&ensp;&#124;─status | integer | 状态 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": [
    {
      "id": 0,
      "parentId": 0,
      "title": "",
      "url": "",
      "code": "",
      "icon": "",
      "sort": 0,
      "comment": "",
      "applicationCode": "",
      "application": "",
      "privilegeCode": "",
      "status": 0
    }
  ],
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 根据条件查询菜单列表

> BASIC

**Path:** /v2/menus/page

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| pageNo |  | YES | 页号 |
| pageSize |  | YES | 页面大小 |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| applicationCode | string | 所属应用 |
| title | string | 菜单标题 |
| status | integer | 状态 |

**Request Demo:**

```json
{
  "applicationCode": "",
  "title": "",
  "status": 0
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | array | 调用结果 |
| &ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─id | integer | id |
| &ensp;&ensp;&ensp;&ensp;&#124;─parentId | integer | 菜单父级id |
| &ensp;&ensp;&ensp;&ensp;&#124;─title | string | 标题 |
| &ensp;&ensp;&ensp;&ensp;&#124;─url | string | 菜单跳转url |
| &ensp;&ensp;&ensp;&ensp;&#124;─code | string | 页面标识 |
| &ensp;&ensp;&ensp;&ensp;&#124;─icon | string | 图标 |
| &ensp;&ensp;&ensp;&ensp;&#124;─sort | integer | 排序 |
| &ensp;&ensp;&ensp;&ensp;&#124;─comment | string | 说明 |
| &ensp;&ensp;&ensp;&ensp;&#124;─applicationCode | string | 所属应用编码 |
| &ensp;&ensp;&ensp;&ensp;&#124;─application | string | 所属应用 |
| &ensp;&ensp;&ensp;&ensp;&#124;─privilegeCode | string | 绑定的权限编码 |
| &ensp;&ensp;&ensp;&ensp;&#124;─status | integer | 状态 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": [
    {
      "id": 0,
      "parentId": 0,
      "title": "",
      "url": "",
      "code": "",
      "icon": "",
      "sort": 0,
      "comment": "",
      "applicationCode": "",
      "application": "",
      "privilegeCode": "",
      "status": 0
    }
  ],
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 根据权限编码列表获取菜单

> BASIC

**Path:** /v2/menus/privileges

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| privileges |  | YES | 特权 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | array | 调用结果 |
| &ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─id | integer | id |
| &ensp;&ensp;&ensp;&ensp;&#124;─parentId | integer | 菜单父级id |
| &ensp;&ensp;&ensp;&ensp;&#124;─title | string | 标题 |
| &ensp;&ensp;&ensp;&ensp;&#124;─url | string | 菜单跳转url |
| &ensp;&ensp;&ensp;&ensp;&#124;─code | string | 页面标识 |
| &ensp;&ensp;&ensp;&ensp;&#124;─icon | string | 图标 |
| &ensp;&ensp;&ensp;&ensp;&#124;─sort | integer | 排序 |
| &ensp;&ensp;&ensp;&ensp;&#124;─comment | string | 说明 |
| &ensp;&ensp;&ensp;&ensp;&#124;─applicationCode | string | 所属应用编码 |
| &ensp;&ensp;&ensp;&ensp;&#124;─application | string | 所属应用 |
| &ensp;&ensp;&ensp;&ensp;&#124;─privilegeCode | string | 绑定的权限编码 |
| &ensp;&ensp;&ensp;&ensp;&#124;─status | integer | 状态 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": [
    {
      "id": 0,
      "parentId": 0,
      "title": "",
      "url": "",
      "code": "",
      "icon": "",
      "sort": 0,
      "comment": "",
      "applicationCode": "",
      "application": "",
      "privilegeCode": "",
      "status": 0
    }
  ],
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```





## Project name(项目名称)：aggregate-pay

Project name(项目名称)：aggregate-pay
Package(包名): mao.aggregate_pay_user_service.controller
Class(类名): TenantControllerV2
Author(作者）: mao
Author QQ：1296193245
GitHub：https://github.com/maomao124/
Date(创建日期)： 2023/1/21
Time(创建时间)： 13:23
Version(版本): 1.0
Description(描述)： 统一账号-租户、套餐、账号相关V2.0


---
### 创建租户

> BASIC

**Path:** /v2/tenants

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| name | string | 租户名称 |
| tenantTypeCode | string | 租户类型编码 |
| bundleCode | string | 初始化套餐编码 |
| mobile | string | 租户管理员登录手机号 |
| password | string | 租户管理员登录密码 |
| username | string | 租户管理员登录用户名 |

**Request Demo:**

```json
{
  "name": "",
  "tenantTypeCode": "",
  "bundleCode": "",
  "mobile": "",
  "password": "",
  "username": ""
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─id | integer | 租户id |
| &ensp;&ensp;&#124;─name | string | 租户名称 |
| &ensp;&ensp;&#124;─tenantTypeCode | string | 租户类型编码 |
| &ensp;&ensp;&#124;─bundleCode | string | 套餐编码 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "id": 0,
    "name": "",
    "tenantTypeCode": "",
    "bundleCode": ""
  },
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 创建租户并关联账号

> BASIC

**Path:** /v2/tenantRelateAccount

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| name | string | 租户名称 |
| tenantTypeCode | string | 租户类型编码 |
| bundleCode | string | 初始化套餐编码 |
| mobile | string | 租户管理员登录手机号 |
| password | string | 租户管理员登录密码 |
| username | string | 租户管理员登录用户名 |

**Request Demo:**

```json
{
  "name": "",
  "tenantTypeCode": "",
  "bundleCode": "",
  "mobile": "",
  "password": "",
  "username": ""
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─id | integer | 租户id |
| &ensp;&ensp;&#124;─name | string | 租户名称 |
| &ensp;&ensp;&#124;─tenantTypeCode | string | 租户类型编码 |
| &ensp;&ensp;&#124;─bundleCode | string | 套餐编码 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "id": 0,
    "name": "",
    "tenantTypeCode": "",
    "bundleCode": ""
  },
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 获取租户信息

> BASIC

**Path:** /v2/tenants/{id}

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| id |  | id |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─id | integer | 租户id |
| &ensp;&ensp;&#124;─name | string | 租户名称 |
| &ensp;&ensp;&#124;─tenantTypeCode | string | 租户类型编码 |
| &ensp;&ensp;&#124;─bundleCode | string | 套餐编码 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "id": 0,
    "name": "",
    "tenantTypeCode": "",
    "bundleCode": ""
  },
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 查询租户

> BASIC

**Path:** /v2/tenants/page

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| pageNo |  | YES | 页号 |
| pageSize |  | YES | 页面大小 |
| sortBy |  | YES | 排序 |
| order |  | YES | 订单 |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| name | string | 租户名称 |
| tenantTypeCode | string | 租户类型 |

**Request Demo:**

```json
{
  "name": "",
  "tenantTypeCode": ""
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | array | 调用结果 |
| &ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─id | integer | 租户id |
| &ensp;&ensp;&ensp;&ensp;&#124;─name | string | 租户名称 |
| &ensp;&ensp;&ensp;&ensp;&#124;─tenantTypeCode | string | 租户类型编码 |
| &ensp;&ensp;&ensp;&ensp;&#124;─bundleCode | string | 套餐编码 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": [
    {
      "id": 0,
      "name": "",
      "tenantTypeCode": "",
      "bundleCode": ""
    }
  ],
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 查询某租户类型的套餐列表

> BASIC

**Path:** /v2/bundles/tenant-types/{tenantType}/bundle-list

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| tenantType |  | 租客类型 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | array | 调用结果 |
| &ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─id | integer | id |
| &ensp;&ensp;&ensp;&ensp;&#124;─name | string | 套餐名称 |
| &ensp;&ensp;&ensp;&ensp;&#124;─code | string | 套餐编码 |
| &ensp;&ensp;&ensp;&ensp;&#124;─tenantTypeCode | string | 租户类型编码 |
| &ensp;&ensp;&ensp;&ensp;&#124;─ability | string | 套餐包含功能描述 |
| &ensp;&ensp;&ensp;&ensp;&#124;─numberOfInvocation | integer | API调用次数 |
| &ensp;&ensp;&ensp;&ensp;&#124;─numberOfConcurrent | integer | 并发数 |
| &ensp;&ensp;&ensp;&ensp;&#124;─numberOfApp | integer | 允许创建应用数量 |
| &ensp;&ensp;&ensp;&ensp;&#124;─comment | string | 套餐说明 |
| &ensp;&ensp;&ensp;&ensp;&#124;─initialize | boolean | 是否为初始化套餐 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": [
    {
      "id": 0,
      "name": "",
      "code": "",
      "tenantTypeCode": "",
      "ability": "",
      "numberOfInvocation": 0,
      "numberOfConcurrent": 0,
      "numberOfApp": 0,
      "comment": "",
      "initialize": false
    }
  ],
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 获取某套餐信息

> BASIC

**Path:** /v2/bundles/{bundleCode}

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| bundleCode |  | 包代码 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─id | integer | id |
| &ensp;&ensp;&#124;─name | string | 套餐名称 |
| &ensp;&ensp;&#124;─code | string | 套餐编码 |
| &ensp;&ensp;&#124;─tenantTypeCode | string | 租户类型编码 |
| &ensp;&ensp;&#124;─ability | string | 套餐包含功能描述 |
| &ensp;&ensp;&#124;─numberOfInvocation | integer | API调用次数 |
| &ensp;&ensp;&#124;─numberOfConcurrent | integer | 并发数 |
| &ensp;&ensp;&#124;─numberOfApp | integer | 允许创建应用数量 |
| &ensp;&ensp;&#124;─comment | string | 套餐说明 |
| &ensp;&ensp;&#124;─initialize | boolean | 是否为初始化套餐 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "id": 0,
    "name": "",
    "code": "",
    "tenantTypeCode": "",
    "ability": "",
    "numberOfInvocation": 0,
    "numberOfConcurrent": 0,
    "numberOfApp": 0,
    "comment": "",
    "initialize": false
  },
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 查询所有套餐

> BASIC

**Path:** /v2/bundles/bundle-list

**Method:** GET

> REQUEST



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | array | 调用结果 |
| &ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─id | integer | id |
| &ensp;&ensp;&ensp;&ensp;&#124;─name | string | 套餐名称 |
| &ensp;&ensp;&ensp;&ensp;&#124;─code | string | 套餐编码 |
| &ensp;&ensp;&ensp;&ensp;&#124;─tenantTypeCode | string | 租户类型编码 |
| &ensp;&ensp;&ensp;&ensp;&#124;─ability | string | 套餐包含功能描述 |
| &ensp;&ensp;&ensp;&ensp;&#124;─numberOfInvocation | integer | API调用次数 |
| &ensp;&ensp;&ensp;&ensp;&#124;─numberOfConcurrent | integer | 并发数 |
| &ensp;&ensp;&ensp;&ensp;&#124;─numberOfApp | integer | 允许创建应用数量 |
| &ensp;&ensp;&ensp;&ensp;&#124;─comment | string | 套餐说明 |
| &ensp;&ensp;&ensp;&ensp;&#124;─initialize | boolean | 是否为初始化套餐 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": [
    {
      "id": 0,
      "name": "",
      "code": "",
      "tenantTypeCode": "",
      "ability": "",
      "numberOfInvocation": 0,
      "numberOfConcurrent": 0,
      "numberOfApp": 0,
      "comment": "",
      "initialize": false
    }
  ],
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 切换租户套餐

> BASIC

**Path:** /v2/tenants/{tenantId}/bundles/{bundleCode}

**Method:** PUT

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| tenantId |  | 承租者id |
| bundleCode |  | 包代码 |

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/x-www-form-urlencoded | YES |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | boolean | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": false,
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 初始化租户套餐

> BASIC

**Path:** /v2/tenants/{tenantId}/bundles/{bundleCode}

**Method:** POST

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| tenantId |  | 承租者id |
| bundleCode |  | 包代码 |

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/x-www-form-urlencoded | YES |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | boolean | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": false,
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 新增套餐

> BASIC

**Path:** /v2/bundles

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| id | integer | id |
| name | string | 套餐名称 |
| code | string | 套餐编码 |
| tenantTypeCode | string | 租户类型编码 |
| ability | string | 套餐包含功能描述 |
| numberOfInvocation | integer | API调用次数 |
| numberOfConcurrent | integer | 并发数 |
| numberOfApp | integer | 允许创建应用数量 |
| comment | string | 套餐说明 |
| initialize | boolean | 是否为初始化套餐 |

**Request Demo:**

```json
{
  "id": 0,
  "name": "",
  "code": "",
  "tenantTypeCode": "",
  "ability": "",
  "numberOfInvocation": 0,
  "numberOfConcurrent": 0,
  "numberOfApp": 0,
  "comment": "",
  "initialize": false
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | boolean | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": false,
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 更新套餐

> BASIC

**Path:** /v2/bundles

**Method:** PUT

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| id | integer | id |
| name | string | 套餐名称 |
| code | string | 套餐编码 |
| tenantTypeCode | string | 租户类型编码 |
| ability | string | 套餐包含功能描述 |
| numberOfInvocation | integer | API调用次数 |
| numberOfConcurrent | integer | 并发数 |
| numberOfApp | integer | 允许创建应用数量 |
| comment | string | 套餐说明 |
| initialize | boolean | 是否为初始化套餐 |

**Request Demo:**

```json
{
  "id": 0,
  "name": "",
  "code": "",
  "tenantTypeCode": "",
  "ability": "",
  "numberOfInvocation": 0,
  "numberOfConcurrent": 0,
  "numberOfApp": 0,
  "comment": "",
  "initialize": false
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | boolean | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": false,
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 创建账户

> BASIC

**Path:** /v2/accounts

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| username | string | 用户名 |
| mobile | string | 手机号 |
| password | string | 密码 |

**Request Demo:**

```json
{
  "username": "",
  "mobile": "",
  "password": ""
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─id | integer | 账号id |
| &ensp;&ensp;&#124;─username | string | 用户名 |
| &ensp;&ensp;&#124;─mobile | string | 手机号 |
| &ensp;&ensp;&#124;─password | string | 密码 |
| &ensp;&ensp;&#124;─salt | string | 盐 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "id": 0,
    "username": "",
    "mobile": "",
    "password": "",
    "salt": ""
  },
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 创建账户

> BASIC

**Path:** /v2/accounts/password

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| accountId | integer | 帐户id |
| userName | string | 用户名 |
| password | string | 密码 |

**Request Demo:**

```json
{
  "accountId": 0,
  "userName": "",
  "password": ""
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | boolean | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": false,
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 创建账号并绑定至某租户

> BASIC

**Path:** /v2/accounts/tenants/{tenantId}

**Method:** POST

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| tenantId |  | 承租者id |

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| username | string | 用户名 |
| mobile | string | 手机号 |
| password | string | 密码 |

**Request Demo:**

```json
{
  "username": "",
  "mobile": "",
  "password": ""
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | boolean | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": false,
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 将已存在账号，加入到某租户

> BASIC

**Path:** /v2/bind/accounts/{username}/tenants/{tenantId}

**Method:** POST

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| tenantId |  | 承租者id |
| username |  | 用户名 |

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/x-www-form-urlencoded | YES |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | boolean | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": false,
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 将某账号从租户内移除

> BASIC

**Path:** /v2/unbind/accounts/{username}/tenants/{tenantId}

**Method:** DELETE

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| tenantId |  | 承租者id |
| username |  | 用户名 |

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/x-www-form-urlencoded | YES |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | boolean | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": false,
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 根据用户名判断账号是否存在

> BASIC

**Path:** /v2/exist/accounts/name/{username}

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| username |  | 用户名 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | boolean | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": false,
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 根据手机号判断账号是否存在

> BASIC

**Path:** /v2/exist/accounts/mobile/{mobile}

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| mobile |  | 移动 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | boolean | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": false,
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 根据用户名获取账号信息

> BASIC

**Path:** /v2/account-information/name/{username}

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| username |  | 用户名 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─id | integer | 账号id |
| &ensp;&ensp;&#124;─username | string | 用户名 |
| &ensp;&ensp;&#124;─mobile | string | 手机号 |
| &ensp;&ensp;&#124;─password | string | 密码 |
| &ensp;&ensp;&#124;─salt | string | 盐 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "id": 0,
    "username": "",
    "mobile": "",
    "password": "",
    "salt": ""
  },
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 根据手机号获取账号信息

> BASIC

**Path:** /v2/accounts-information/mobile/{mobile}

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| mobile |  | 移动 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─id | integer | 账号id |
| &ensp;&ensp;&#124;─username | string | 用户名 |
| &ensp;&ensp;&#124;─mobile | string | 手机号 |
| &ensp;&ensp;&#124;─password | string | 密码 |
| &ensp;&ensp;&#124;─salt | string | 盐 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "id": 0,
    "username": "",
    "mobile": "",
    "password": "",
    "salt": ""
  },
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 根据用户名判断账号是否在某租户内

> BASIC

**Path:** /v2/exist/accounts/{username}/tenants/{tenantId}

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| tenantId |  | 承租者id |
| username |  | 用户名 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | boolean | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": false,
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 根据手机号判断账号是否在某租户内

> BASIC

**Path:** /v2/exist/accounts/tenants/{tenantId}/mobiles/{mobile}

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| tenantId |  | 承租者id |
| mobile |  | 移动 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | boolean | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": false,
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 查询账户

> BASIC

**Path:** /v2/accounts/page

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| pageNo |  | YES | 页号 |
| pageSize |  | YES | 页面大小 |
| sortBy |  | YES | 排序 |
| order |  | YES | 订单 |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| username | string | 用户名 |
| mobile | string | 手机号 |
| tenantId | integer | 所属租户 |

**Request Demo:**

```json
{
  "username": "",
  "mobile": "",
  "tenantId": 0
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | array | 调用结果 |
| &ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─id | integer | 账号id |
| &ensp;&ensp;&ensp;&ensp;&#124;─username | string | 用户名 |
| &ensp;&ensp;&ensp;&ensp;&#124;─mobile | string | 手机号 |
| &ensp;&ensp;&ensp;&ensp;&#124;─password | string | 密码 |
| &ensp;&ensp;&ensp;&ensp;&#124;─salt | string | 盐 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": [
    {
      "id": 0,
      "username": "",
      "mobile": "",
      "password": "",
      "salt": ""
    }
  ],
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 查询某账号所属租户列表

> BASIC

**Path:** /v2/accounts/tenant-list/{username}

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| username |  | 用户名 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | array | 调用结果 |
| &ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─id | integer | 租户id |
| &ensp;&ensp;&ensp;&ensp;&#124;─name | string | 租户名称 |
| &ensp;&ensp;&ensp;&ensp;&#124;─tenantTypeCode | string | 租户类型编码 |
| &ensp;&ensp;&ensp;&ensp;&#124;─bundleCode | string | 套餐编码 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": [
    {
      "id": 0,
      "name": "",
      "tenantTypeCode": "",
      "bundleCode": ""
    }
  ],
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 发送短信验证码

> BASIC

**Path:** /v2/getMessage

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| phone |  | YES | 电话 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | string | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": "",
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 身份验证

> BASIC

**Path:** /v2/authentication

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| principal | string | 认证主体:如用户名，手机号等 |
| certificate | string | 凭证:如密码，短信认证码等 |
| authenticationType | string | 认证类型：短信快捷认证、用户名密码认证、二维码认证等 |
| smsKey | string | 短信认证时需要传key到短信微服务校验 |

**Request Demo:**

```json
{
  "principal": "",
  "certificate": "",
  "authenticationType": "",
  "smsKey": ""
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─id | integer | 账号id |
| &ensp;&ensp;&#124;─username | string | 用户名 |
| &ensp;&ensp;&#124;─mobile | string | 手机号 |
| &ensp;&ensp;&#124;─password | string | 密码 |
| &ensp;&ensp;&#124;─salt | string | 盐 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "id": 0,
    "username": "",
    "mobile": "",
    "password": "",
    "salt": ""
  },
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 登录

> BASIC

**Path:** /v2/login

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| principal | string | 认证主体:如用户名，手机号等 |
| certificate | string | 凭证:如密码，短信认证码等 |
| authenticationType | string | 认证类型：短信快捷认证 type_message、用户名密码认证 type_user、二维码认证等 |
| smsKey | string | 短信认证时需要传key到短信微服务校验 |

**Request Demo:**

```json
{
  "principal": "",
  "certificate": "",
  "authenticationType": "",
  "smsKey": ""
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─id | integer | 账号id |
| &ensp;&ensp;&#124;─username | string | 用户名 |
| &ensp;&ensp;&#124;─mobile | string | 手机号 |
| &ensp;&ensp;&#124;─tenants | array | 账号所属多个租户 |
| &ensp;&ensp;&ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─id | integer | 租户id |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─name | string | 租户名称 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─tenantTypeCode | string | 租户类型编码 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─bundleCode | string | 套餐编码 |
| &ensp;&ensp;&#124;─tenantAuthorizationInfoMap | object | 账号所属多个租户下的权限 |
| &ensp;&ensp;&ensp;&ensp;&#124;─0 | object |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─rolePrivilegeMap | object | 角色-权限列表 映射 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─key | array |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─ | string |  |
| &ensp;&ensp;&#124;─resources | object | 资源 |
| &ensp;&ensp;&ensp;&ensp;&#124;─0 | array |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─applicationCode | string | 应用程序代码 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─applicationName | string | 应用程序名称 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─appRes | object | 按资源类型分包括菜单等资源信息 如  menu:JSONObject |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─key | object |  |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "id": 0,
    "username": "",
    "mobile": "",
    "tenants": [
      {
        "id": 0,
        "name": "",
        "tenantTypeCode": "",
        "bundleCode": ""
      }
    ],
    "tenantAuthorizationInfoMap": {
      "0": {
        "rolePrivilegeMap": {
          "": [
            ""
          ]
        }
      }
    },
    "resources": {
      "0": [
        {
          "applicationCode": "",
          "applicationName": "",
          "appRes": {
            "": {}
          }
        }
      ]
    }
  },
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 根据接入客户端获取应用

> BASIC

**Path:** /v2/getApplicationDTOByClientId/{clientId}

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| clientId |  | 客户机id |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─id | integer | id |
| &ensp;&ensp;&#124;─name | string | 应用名称 |
| &ensp;&ensp;&#124;─code | string | 应用编码 |
| &ensp;&ensp;&#124;─tenantId | integer | 应用所属租户 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "id": 0,
    "name": "",
    "code": "",
    "tenantId": 0
  },
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```





## Project name(项目名称)：aggregate-pay

Project name(项目名称)：aggregate-pay
Package(包名): mao.aggregate_pay_user_service.controller
Class(类名): AuthorizationControllerV2
Author(作者）: mao
Author QQ：1296193245
GitHub：https://github.com/maomao124/
Date(创建日期)： 2023/1/20
Time(创建时间)： 22:11
Version(版本): 2.0
Description(描述)： 无


---
### 授权

> BASIC

**Path:** /v2/tenants/{username}/privileges

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| username |  | 用户名 |

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| tenantIds |  | YES | 租户id |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─0 | object |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─rolePrivilegeMap | object | 角色-权限列表 映射 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─key | array |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─ | string |  |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "0": {
      "rolePrivilegeMap": {
        "": [
          ""
        ]
      }
    }
  },
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 查询权限

> BASIC

**Path:** /v2/tenants/{tenantId}/roles/privilege-list

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| tenantId |  | 承租者id |

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| roleCodes |  | YES | 角色代码 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | array | 调用结果 |
| &ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─id | integer | 权限id |
| &ensp;&ensp;&ensp;&ensp;&#124;─name | string | 权限名称 |
| &ensp;&ensp;&ensp;&ensp;&#124;─code | string | 权限编码 |
| &ensp;&ensp;&ensp;&ensp;&#124;─privilegeGroupId | integer | 所属权限组id |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": [
    {
      "id": 0,
      "name": "",
      "code": "",
      "privilegeGroupId": 0
    }
  ],
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 查询权限组id

> BASIC

**Path:** /v2/privilege-groups/{privilegeGroupId}/privilege-list

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| privilegeGroupId |  | 权限组id |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | array | 调用结果 |
| &ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─id | integer | 权限id |
| &ensp;&ensp;&ensp;&ensp;&#124;─name | string | 权限名称 |
| &ensp;&ensp;&ensp;&ensp;&#124;─code | string | 权限编码 |
| &ensp;&ensp;&ensp;&ensp;&#124;─privilegeGroupId | integer | 所属权限组id |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": [
    {
      "id": 0,
      "name": "",
      "code": "",
      "privilegeGroupId": 0
    }
  ],
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 查询权限树

> BASIC

**Path:** /v2/tenants/{tenantId}/roles/role-privilege-list

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| tenantId |  | 承租者id |

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| roleCodes |  | YES | 角色代码 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─id | string | 权限组使用id,权限使用code，约束code不能为纯数值保证不重复 |
| &ensp;&ensp;&#124;─name | string | 节点名称 |
| &ensp;&ensp;&#124;─parentId | string | 一定是权限组id，权限没有结构<br>父级id |
| &ensp;&ensp;&#124;─sort | integer | 同层排序,不排序都为0 |
| &ensp;&ensp;&#124;─status | integer | 状态 |
| &ensp;&ensp;&#124;─isGroup | boolean | 是否为权限组 |
| &ensp;&ensp;&#124;─children | array | 子节点集合 |
| &ensp;&ensp;&ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─id | string | 权限组使用id,权限使用code，约束code不能为纯数值保证不重复 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─name | string | 节点名称 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─parentId | string | 一定是权限组id，权限没有结构<br>父级id |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─sort | integer | 同层排序,不排序都为0 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─status | integer | 状态 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─isGroup | boolean | 是否为权限组 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─children | array | 子节点集合 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─ | object |  |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "id": "",
    "name": "",
    "parentId": "",
    "sort": 0,
    "status": 0,
    "isGroup": false,
    "children": [
      {
        "id": "",
        "name": "",
        "parentId": "",
        "sort": 0,
        "status": 0,
        "isGroup": false,
        "children": [
          {}
        ]
      }
    ]
  },
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 创建角色

> BASIC

**Path:** /v2/tenants/{tenantId}/roles

**Method:** POST

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| tenantId |  | 承租者id |

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| id | integer | id |
| name | string | 角色名称 |
| code | string | 角色编码 |
| tenantId | integer | 角色所属租户 |
| privilegeCodes | array | 角色包含权限列表 |
| &ensp;&ensp;&#124;─ | string |  |

**Request Demo:**

```json
{
  "id": 0,
  "name": "",
  "code": "",
  "tenantId": 0,
  "privilegeCodes": [
    ""
  ]
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | boolean | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": false,
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 删除角色

> BASIC

**Path:** /v2/tenants/{tenantId}/roles/{roleCode}

**Method:** DELETE

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| tenantId |  | 承租者id |
| roleCode |  | 角色代码 |

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/x-www-form-urlencoded | YES |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | boolean | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": false,
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 修改角色

> BASIC

**Path:** /v2/tenants/roles

**Method:** PUT

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| id | integer | id |
| name | string | 角色名称 |
| code | string | 角色编码 |
| tenantId | integer | 角色所属租户 |
| privilegeCodes | array | 角色包含权限列表 |
| &ensp;&ensp;&#124;─ | string |  |

**Request Demo:**

```json
{
  "id": 0,
  "name": "",
  "code": "",
  "tenantId": 0,
  "privilegeCodes": [
    ""
  ]
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | boolean | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": false,
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 角色绑定特权

> BASIC

**Path:** /v2/tenants/{tenantId}/roles/{roleCode}/privileges

**Method:** PUT

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| tenantId |  | 承租者id |
| roleCode |  | 角色代码 |

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/x-www-form-urlencoded | YES |  |

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| privilegeCodes |  | YES | 特权代码 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | boolean | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": false,
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 查询角色

> BASIC

**Path:** /v2/tenants/{tenantId}/roles

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| tenantId |  | 承租者id |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | array | 调用结果 |
| &ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─id | integer | id |
| &ensp;&ensp;&ensp;&ensp;&#124;─name | string | 角色名称 |
| &ensp;&ensp;&ensp;&ensp;&#124;─code | string | 角色编码 |
| &ensp;&ensp;&ensp;&ensp;&#124;─tenantId | integer | 角色所属租户 |
| &ensp;&ensp;&ensp;&ensp;&#124;─privilegeCodes | array | 角色包含权限列表 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─ | string |  |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": [
    {
      "id": 0,
      "name": "",
      "code": "",
      "tenantId": 0,
      "privilegeCodes": [
        ""
      ]
    }
  ],
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 查询角色

> BASIC

**Path:** /v2/roles/tenants/{tenantId}

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| tenantId |  | 承租者id |

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| roleCodes |  | YES | 角色代码 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | array | 调用结果 |
| &ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─id | integer | id |
| &ensp;&ensp;&ensp;&ensp;&#124;─name | string | 角色名称 |
| &ensp;&ensp;&ensp;&ensp;&#124;─code | string | 角色编码 |
| &ensp;&ensp;&ensp;&ensp;&#124;─tenantId | integer | 角色所属租户 |
| &ensp;&ensp;&ensp;&ensp;&#124;─privilegeCodes | array | 角色包含权限列表 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─ | string |  |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": [
    {
      "id": 0,
      "name": "",
      "code": "",
      "tenantId": 0,
      "privilegeCodes": [
        ""
      ]
    }
  ],
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 查询租户作用

> BASIC

**Path:** /v2/tenants/{tenantId}/roles/{roleCode}/role-privilege

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| tenantId |  | 承租者id |
| roleCode |  | 角色代码 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─id | integer | id |
| &ensp;&ensp;&#124;─name | string | 角色名称 |
| &ensp;&ensp;&#124;─code | string | 角色编码 |
| &ensp;&ensp;&#124;─tenantId | integer | 角色所属租户 |
| &ensp;&ensp;&#124;─privilegeCodes | array | 角色包含权限列表 |
| &ensp;&ensp;&ensp;&ensp;&#124;─ | string |  |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "id": 0,
    "name": "",
    "code": "",
    "tenantId": 0,
    "privilegeCodes": [
      ""
    ]
  },
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### bindAccountRole

> BASIC

**Path:** /v2/bind/tenants/{tenantId}/accounts/{username}/roles

**Method:** POST

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| username |  |  |
| tenantId |  |  |

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/x-www-form-urlencoded | YES |  |

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| roleCodes |  | YES |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | boolean | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": false,
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 解开帐户作用

> BASIC

**Path:** /v2/unbind/tenants/{tenantId}/accounts/{username}/roles

**Method:** PUT

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| username |  | 用户名 |
| tenantId |  | 承租者id |

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/x-www-form-urlencoded | YES |  |

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| roleCodes |  | YES | 角色代码 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | boolean | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": false,
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```





## Project name(项目名称)：aggregate-pay

Project name(项目名称)：aggregate-pay
Package(包名): mao.aggregate_pay_user_service.controller
Class(类名): ResourceController
Author(作者）: mao
Author QQ：1296193245
GitHub：https://github.com/maomao124/
Date(创建日期)： 2023/1/20
Time(创建时间)： 22:27
Version(版本): 1.0
Description(描述)： 统一账号-资源


---
### 创建应用

> BASIC

**Path:** /apps

**Method:** POST

**Desc:**

 会关联创建uaa服务中的接入客户端，其中code为clientId

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| id | integer | id |
| name | string | 应用名称 |
| code | string | 应用编码 |
| tenantId | integer | 应用所属租户 |

**Request Demo:**

```json
{
  "id": 0,
  "name": "",
  "code": "",
  "tenantId": 0
}
```




---
### 修改应用程序

> BASIC

**Path:** /apps

**Method:** PUT

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| id | integer | id |
| name | string | 应用名称 |
| code | string | 应用编码 |
| tenantId | integer | 应用所属租户 |

**Request Demo:**

```json
{
  "id": 0,
  "name": "",
  "code": "",
  "tenantId": 0
}
```




---
### 删除应用程序

> BASIC

**Path:** /apps/{applicationCode}

**Method:** DELETE

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| applicationCode |  | 应用程序代码 |

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/x-www-form-urlencoded | YES |  |




---
### 查询应用程序

> BASIC

**Path:** /apps/{applicationCode}

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| applicationCode |  | 应用程序代码 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| id | integer | id |
| name | string | 应用名称 |
| code | string | 应用编码 |
| tenantId | integer | 应用所属租户 |

**Response Demo:**

```json
{
  "id": 0,
  "name": "",
  "code": "",
  "tenantId": 0
}
```




---
### 分页条件查找应用

> BASIC

**Path:** /apps/page

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| pageNo |  | YES | 页号 |
| pageSize |  | YES | 页面大小 |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| name | string | 应用名称 |

**Request Demo:**

```json
{
  "name": ""
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
|  | array | [Project name(项目名称)：aggregate-pay<br>Package(包名): mao.aggregate_pay_common.domain<br>Class(类名): PageVO<br>Author(作者）: mao<br>Author QQ：1296193245<br>GitHub：https://github.com/maomao124/<br>Date(创建日期)： 2023/1/7<br>Time(创建时间)： 14:48<br>Version(版本): 1.0<br>Description(描述)： 无]<[Project name(项目名称)：aggregate-pay<br>Package(包名): mao.aggregate_pay_user_api.dto.resource<br>Class(类名): ApplicationDTO<br>Author(作者）: mao<br>Author QQ：1296193245<br>GitHub：https://github.com/maomao124/<br>Date(创建日期)： 2023/1/18<br>Time(创建时间)： 19:11<br>Version(版本): 1.0<br>Description(描述)： 应用信息]> |
|  | object |  |
| &ensp;&ensp;&#124;─id | integer | id |
| &ensp;&ensp;&#124;─name | string | 应用名称 |
| &ensp;&ensp;&#124;─code | string | 应用编码 |
| &ensp;&ensp;&#124;─tenantId | integer | 应用所属租户 |

**Response Demo:**

```json
[
  {
    "id": 0,
    "name": "",
    "code": "",
    "tenantId": 0
  }
]
```




---
### 根据权限加载指定应用的资源

> BASIC

**Path:** /apps/privileges/resources/{applicationCode}

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| applicationCode |  | 应用程序代码 |

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| privileageCodes |  | YES | privileage代码 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
|  | array | [An ordered collection (also known as a <i>sequence</i>).  The user of this<br>interface has precise control over where in the list each element is<br>inserted.  The user can access elements by their integer index (position in<br>the list), and search for elements in the list.<p><br><br>Unlike sets, lists typically allow duplicate elements.  More formally,<br>lists typically allow pairs of elements <tt>e1</tt> and <tt>e2</tt><br>such that <tt>e1.equals(e2)</tt>, and they typically allow multiple<br>null elements if they allow null elements at all.  It is not inconceivable<br>that someone might wish to implement a list that prohibits duplicates, by<br>throwing runtime exceptions when the user attempts to insert them, but we<br>expect this usage to be rare.<p><br><br>The <tt>List</tt> interface places additional stipulations, beyond those<br>specified in the <tt>Collection</tt> interface, on the contracts of the<br><tt>iterator</tt>, <tt>add</tt>, <tt>remove</tt>, <tt>equals</tt>, and<br><tt>hashCode</tt> methods.  Declarations for other inherited methods are<br>also included here for convenience.<p><br><br>The <tt>List</tt> interface provides four methods for positional (indexed)<br>access to list elements.  Lists (like Java arrays) are zero based.  Note<br>that these operations may execute in time proportional to the index value<br>for some implementations (the <tt>LinkedList</tt> class, for<br>example). Thus, iterating over the elements in a list is typically<br>preferable to indexing through it if the caller does not know the<br>implementation.<p><br><br>The <tt>List</tt> interface provides a special iterator, called a<br><tt>ListIterator</tt>, that allows element insertion and replacement, and<br>bidirectional access in addition to the normal operations that the<br><tt>Iterator</tt> interface provides.  A method is provided to obtain a<br>list iterator that starts at a specified position in the list.<p><br><br>The <tt>List</tt> interface provides two methods to search for a specified<br>object.  From a performance standpoint, these methods should be used with<br>caution.  In many implementations they will perform costly linear<br>searches.<p><br><br>The <tt>List</tt> interface provides two methods to efficiently insert and<br>remove multiple elements at an arbitrary point in the list.<p><br><br>Note: While it is permissible for lists to contain themselves as elements,<br>extreme caution is advised: the <tt>equals</tt> and <tt>hashCode</tt><br>methods are no longer well defined on such a list.<br><br><p>Some list implementations have restrictions on the elements that<br>they may contain.  For example, some implementations prohibit null elements,<br>and some have restrictions on the types of their elements.  Attempting to<br>add an ineligible element throws an unchecked exception, typically<br><tt>NullPointerException</tt> or <tt>ClassCastException</tt>.  Attempting<br>to query the presence of an ineligible element may throw an exception,<br>or it may simply return false; some implementations will exhibit the former<br>behavior and some will exhibit the latter.  More generally, attempting an<br>operation on an ineligible element whose completion would not result in<br>the insertion of an ineligible element into the list may throw an<br>exception or it may succeed, at the option of the implementation.<br>Such exceptions are marked as "optional" in the specification for this<br>interface.<br><br><p>This interface is a member of the<br><a href="{@docRoot}/../technotes/guides/collections/index.html"><br>Java Collections Framework</a>.]<[Project name(项目名称)：aggregate-pay<br>Package(包名): mao.aggregate_pay_user_api.dto.resource<br>Class(类名): ResourceDTO<br>Author(作者）: mao<br>Author QQ：1296193245<br>GitHub：https://github.com/maomao124/<br>Date(创建日期)： 2023/1/18<br>Time(创建时间)： 19:14<br>Version(版本): 1.0<br>Description(描述)： 无]> |
|  | object |  |
| &ensp;&ensp;&#124;─applicationCode | string | 应用程序代码 |
| &ensp;&ensp;&#124;─applicationName | string | 应用程序名称 |
| &ensp;&ensp;&#124;─appRes | object | 按资源类型分包括菜单等资源信息 如  menu:JSONObject |
| &ensp;&ensp;&ensp;&ensp;&#124;─key | object |  |

**Response Demo:**

```json
[
  {
    "applicationCode": "",
    "applicationName": "",
    "appRes": {
      "": {}
    }
  }
]
```




---
### 获取多个租户下权限所对应的的资源信息，并按应用拆分

> BASIC

**Path:** /tenants/apps/privileges/resources

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| 0 | object |  |
| &ensp;&ensp;&#124;─rolePrivilegeMap | object | 角色-权限列表 映射 |
| &ensp;&ensp;&ensp;&ensp;&#124;─key | array |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─ | string |  |

**Request Demo:**

```json
{
  "0": {
    "rolePrivilegeMap": {
      "": [
        ""
      ]
    }
  }
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| 0 | array |  |
| &ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─applicationCode | string | 应用程序代码 |
| &ensp;&ensp;&ensp;&ensp;&#124;─applicationName | string | 应用程序名称 |
| &ensp;&ensp;&ensp;&ensp;&#124;─appRes | object | 按资源类型分包括菜单等资源信息 如  menu:JSONObject |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─key | object |  |

**Response Demo:**

```json
{
  "0": [
    {
      "applicationCode": "",
      "applicationName": "",
      "appRes": {
        "": {}
      }
    }
  ]
}
```




---
### 查询菜单

> BASIC

**Path:** /menus/{id}

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| id |  | id |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| id | integer | id |
| parentId | integer | 菜单父级id |
| title | string | 标题 |
| url | string | 菜单跳转url |
| code | string | 页面标识 |
| icon | string | 图标 |
| sort | integer | 排序 |
| comment | string | 说明 |
| applicationCode | string | 所属应用编码 |
| application | string | 所属应用 |
| privilegeCode | string | 绑定的权限编码 |
| status | integer | 状态 |

**Response Demo:**

```json
{
  "id": 0,
  "parentId": 0,
  "title": "",
  "url": "",
  "code": "",
  "icon": "",
  "sort": 0,
  "comment": "",
  "applicationCode": "",
  "application": "",
  "privilegeCode": "",
  "status": 0
}
```




---
### 根据应用编码查询菜单列表

> BASIC

**Path:** /menus/{applicationCode}/menu-list

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| applicationCode |  | 应用程序代码 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
|  | array | [An ordered collection (also known as a <i>sequence</i>).  The user of this<br>interface has precise control over where in the list each element is<br>inserted.  The user can access elements by their integer index (position in<br>the list), and search for elements in the list.<p><br><br>Unlike sets, lists typically allow duplicate elements.  More formally,<br>lists typically allow pairs of elements <tt>e1</tt> and <tt>e2</tt><br>such that <tt>e1.equals(e2)</tt>, and they typically allow multiple<br>null elements if they allow null elements at all.  It is not inconceivable<br>that someone might wish to implement a list that prohibits duplicates, by<br>throwing runtime exceptions when the user attempts to insert them, but we<br>expect this usage to be rare.<p><br><br>The <tt>List</tt> interface places additional stipulations, beyond those<br>specified in the <tt>Collection</tt> interface, on the contracts of the<br><tt>iterator</tt>, <tt>add</tt>, <tt>remove</tt>, <tt>equals</tt>, and<br><tt>hashCode</tt> methods.  Declarations for other inherited methods are<br>also included here for convenience.<p><br><br>The <tt>List</tt> interface provides four methods for positional (indexed)<br>access to list elements.  Lists (like Java arrays) are zero based.  Note<br>that these operations may execute in time proportional to the index value<br>for some implementations (the <tt>LinkedList</tt> class, for<br>example). Thus, iterating over the elements in a list is typically<br>preferable to indexing through it if the caller does not know the<br>implementation.<p><br><br>The <tt>List</tt> interface provides a special iterator, called a<br><tt>ListIterator</tt>, that allows element insertion and replacement, and<br>bidirectional access in addition to the normal operations that the<br><tt>Iterator</tt> interface provides.  A method is provided to obtain a<br>list iterator that starts at a specified position in the list.<p><br><br>The <tt>List</tt> interface provides two methods to search for a specified<br>object.  From a performance standpoint, these methods should be used with<br>caution.  In many implementations they will perform costly linear<br>searches.<p><br><br>The <tt>List</tt> interface provides two methods to efficiently insert and<br>remove multiple elements at an arbitrary point in the list.<p><br><br>Note: While it is permissible for lists to contain themselves as elements,<br>extreme caution is advised: the <tt>equals</tt> and <tt>hashCode</tt><br>methods are no longer well defined on such a list.<br><br><p>Some list implementations have restrictions on the elements that<br>they may contain.  For example, some implementations prohibit null elements,<br>and some have restrictions on the types of their elements.  Attempting to<br>add an ineligible element throws an unchecked exception, typically<br><tt>NullPointerException</tt> or <tt>ClassCastException</tt>.  Attempting<br>to query the presence of an ineligible element may throw an exception,<br>or it may simply return false; some implementations will exhibit the former<br>behavior and some will exhibit the latter.  More generally, attempting an<br>operation on an ineligible element whose completion would not result in<br>the insertion of an ineligible element into the list may throw an<br>exception or it may succeed, at the option of the implementation.<br>Such exceptions are marked as "optional" in the specification for this<br>interface.<br><br><p>This interface is a member of the<br><a href="{@docRoot}/../technotes/guides/collections/index.html"><br>Java Collections Framework</a>.]<[Project name(项目名称)：aggregate-pay<br>Package(包名): mao.aggregate_pay_user_api.dto.menu<br>Class(类名): MenuDTO<br>Author(作者）: mao<br>Author QQ：1296193245<br>GitHub：https://github.com/maomao124/<br>Date(创建日期)： 2023/1/18<br>Time(创建时间)： 19:09<br>Version(版本): 1.0<br>Description(描述)： 菜单信息]> |
|  | object |  |
| &ensp;&ensp;&#124;─id | integer | id |
| &ensp;&ensp;&#124;─parentId | integer | 菜单父级id |
| &ensp;&ensp;&#124;─title | string | 标题 |
| &ensp;&ensp;&#124;─url | string | 菜单跳转url |
| &ensp;&ensp;&#124;─code | string | 页面标识 |
| &ensp;&ensp;&#124;─icon | string | 图标 |
| &ensp;&ensp;&#124;─sort | integer | 排序 |
| &ensp;&ensp;&#124;─comment | string | 说明 |
| &ensp;&ensp;&#124;─applicationCode | string | 所属应用编码 |
| &ensp;&ensp;&#124;─application | string | 所属应用 |
| &ensp;&ensp;&#124;─privilegeCode | string | 绑定的权限编码 |
| &ensp;&ensp;&#124;─status | integer | 状态 |

**Response Demo:**

```json
[
  {
    "id": 0,
    "parentId": 0,
    "title": "",
    "url": "",
    "code": "",
    "icon": "",
    "sort": 0,
    "comment": "",
    "applicationCode": "",
    "application": "",
    "privilegeCode": "",
    "status": 0
  }
]
```




---
### 根据条件查询菜单列表

> BASIC

**Path:** /menus/page

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| pageNo |  | YES | 页号 |
| pageSize |  | YES | 页面大小 |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| applicationCode | string | 所属应用 |
| title | string | 菜单标题 |
| status | integer | 状态 |

**Request Demo:**

```json
{
  "applicationCode": "",
  "title": "",
  "status": 0
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
|  | array | [Project name(项目名称)：aggregate-pay<br>Package(包名): mao.aggregate_pay_common.domain<br>Class(类名): PageVO<br>Author(作者）: mao<br>Author QQ：1296193245<br>GitHub：https://github.com/maomao124/<br>Date(创建日期)： 2023/1/7<br>Time(创建时间)： 14:48<br>Version(版本): 1.0<br>Description(描述)： 无]<[Project name(项目名称)：aggregate-pay<br>Package(包名): mao.aggregate_pay_user_api.dto.menu<br>Class(类名): MenuDTO<br>Author(作者）: mao<br>Author QQ：1296193245<br>GitHub：https://github.com/maomao124/<br>Date(创建日期)： 2023/1/18<br>Time(创建时间)： 19:09<br>Version(版本): 1.0<br>Description(描述)： 菜单信息]> |
|  | object |  |
| &ensp;&ensp;&#124;─id | integer | id |
| &ensp;&ensp;&#124;─parentId | integer | 菜单父级id |
| &ensp;&ensp;&#124;─title | string | 标题 |
| &ensp;&ensp;&#124;─url | string | 菜单跳转url |
| &ensp;&ensp;&#124;─code | string | 页面标识 |
| &ensp;&ensp;&#124;─icon | string | 图标 |
| &ensp;&ensp;&#124;─sort | integer | 排序 |
| &ensp;&ensp;&#124;─comment | string | 说明 |
| &ensp;&ensp;&#124;─applicationCode | string | 所属应用编码 |
| &ensp;&ensp;&#124;─application | string | 所属应用 |
| &ensp;&ensp;&#124;─privilegeCode | string | 绑定的权限编码 |
| &ensp;&ensp;&#124;─status | integer | 状态 |

**Response Demo:**

```json
[
  {
    "id": 0,
    "parentId": 0,
    "title": "",
    "url": "",
    "code": "",
    "icon": "",
    "sort": 0,
    "comment": "",
    "applicationCode": "",
    "application": "",
    "privilegeCode": "",
    "status": 0
  }
]
```




---
### 根据权限编码列表获取菜单

> BASIC

**Path:** /menus/privileges

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| privileges |  | YES | 特权 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
|  | array | [An ordered collection (also known as a <i>sequence</i>).  The user of this<br>interface has precise control over where in the list each element is<br>inserted.  The user can access elements by their integer index (position in<br>the list), and search for elements in the list.<p><br><br>Unlike sets, lists typically allow duplicate elements.  More formally,<br>lists typically allow pairs of elements <tt>e1</tt> and <tt>e2</tt><br>such that <tt>e1.equals(e2)</tt>, and they typically allow multiple<br>null elements if they allow null elements at all.  It is not inconceivable<br>that someone might wish to implement a list that prohibits duplicates, by<br>throwing runtime exceptions when the user attempts to insert them, but we<br>expect this usage to be rare.<p><br><br>The <tt>List</tt> interface places additional stipulations, beyond those<br>specified in the <tt>Collection</tt> interface, on the contracts of the<br><tt>iterator</tt>, <tt>add</tt>, <tt>remove</tt>, <tt>equals</tt>, and<br><tt>hashCode</tt> methods.  Declarations for other inherited methods are<br>also included here for convenience.<p><br><br>The <tt>List</tt> interface provides four methods for positional (indexed)<br>access to list elements.  Lists (like Java arrays) are zero based.  Note<br>that these operations may execute in time proportional to the index value<br>for some implementations (the <tt>LinkedList</tt> class, for<br>example). Thus, iterating over the elements in a list is typically<br>preferable to indexing through it if the caller does not know the<br>implementation.<p><br><br>The <tt>List</tt> interface provides a special iterator, called a<br><tt>ListIterator</tt>, that allows element insertion and replacement, and<br>bidirectional access in addition to the normal operations that the<br><tt>Iterator</tt> interface provides.  A method is provided to obtain a<br>list iterator that starts at a specified position in the list.<p><br><br>The <tt>List</tt> interface provides two methods to search for a specified<br>object.  From a performance standpoint, these methods should be used with<br>caution.  In many implementations they will perform costly linear<br>searches.<p><br><br>The <tt>List</tt> interface provides two methods to efficiently insert and<br>remove multiple elements at an arbitrary point in the list.<p><br><br>Note: While it is permissible for lists to contain themselves as elements,<br>extreme caution is advised: the <tt>equals</tt> and <tt>hashCode</tt><br>methods are no longer well defined on such a list.<br><br><p>Some list implementations have restrictions on the elements that<br>they may contain.  For example, some implementations prohibit null elements,<br>and some have restrictions on the types of their elements.  Attempting to<br>add an ineligible element throws an unchecked exception, typically<br><tt>NullPointerException</tt> or <tt>ClassCastException</tt>.  Attempting<br>to query the presence of an ineligible element may throw an exception,<br>or it may simply return false; some implementations will exhibit the former<br>behavior and some will exhibit the latter.  More generally, attempting an<br>operation on an ineligible element whose completion would not result in<br>the insertion of an ineligible element into the list may throw an<br>exception or it may succeed, at the option of the implementation.<br>Such exceptions are marked as "optional" in the specification for this<br>interface.<br><br><p>This interface is a member of the<br><a href="{@docRoot}/../technotes/guides/collections/index.html"><br>Java Collections Framework</a>.]<[Project name(项目名称)：aggregate-pay<br>Package(包名): mao.aggregate_pay_user_api.dto.menu<br>Class(类名): MenuDTO<br>Author(作者）: mao<br>Author QQ：1296193245<br>GitHub：https://github.com/maomao124/<br>Date(创建日期)： 2023/1/18<br>Time(创建时间)： 19:09<br>Version(版本): 1.0<br>Description(描述)： 菜单信息]> |
|  | object |  |
| &ensp;&ensp;&#124;─id | integer | id |
| &ensp;&ensp;&#124;─parentId | integer | 菜单父级id |
| &ensp;&ensp;&#124;─title | string | 标题 |
| &ensp;&ensp;&#124;─url | string | 菜单跳转url |
| &ensp;&ensp;&#124;─code | string | 页面标识 |
| &ensp;&ensp;&#124;─icon | string | 图标 |
| &ensp;&ensp;&#124;─sort | integer | 排序 |
| &ensp;&ensp;&#124;─comment | string | 说明 |
| &ensp;&ensp;&#124;─applicationCode | string | 所属应用编码 |
| &ensp;&ensp;&#124;─application | string | 所属应用 |
| &ensp;&ensp;&#124;─privilegeCode | string | 绑定的权限编码 |
| &ensp;&ensp;&#124;─status | integer | 状态 |

**Response Demo:**

```json
[
  {
    "id": 0,
    "parentId": 0,
    "title": "",
    "url": "",
    "code": "",
    "icon": "",
    "sort": 0,
    "comment": "",
    "applicationCode": "",
    "application": "",
    "privilegeCode": "",
    "status": 0
  }
]
```





## Project name(项目名称)：aggregate-pay

Project name(项目名称)：aggregate-pay
Package(包名): mao.aggregate_pay_user_service.controller
Class(类名): AuthorizationController
Author(作者）: mao
Author QQ：1296193245
GitHub：https://github.com/maomao124/
Date(创建日期)： 2023/1/20
Time(创建时间)： 21:51
Version(版本): 1.0
Description(描述)： 统一账号-角色权限


---
### 授权

> BASIC

**Path:** /tenants/{username}/privileges

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| username |  | 用户名 |

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| tenantIds |  | YES | 租户id |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| 0 | object |  |
| &ensp;&ensp;&#124;─rolePrivilegeMap | object | 角色-权限列表 映射 |
| &ensp;&ensp;&ensp;&ensp;&#124;─key | array |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─ | string |  |

**Response Demo:**

```json
{
  "0": {
    "rolePrivilegeMap": {
      "": [
        ""
      ]
    }
  }
}
```




---
### 查询权限

> BASIC

**Path:** /tenants/{tenantId}/roles/privilege-list

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| tenantId |  | 承租者id |

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| roleCodes |  | YES | 角色代码 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
|  | array | [An ordered collection (also known as a <i>sequence</i>).  The user of this<br>interface has precise control over where in the list each element is<br>inserted.  The user can access elements by their integer index (position in<br>the list), and search for elements in the list.<p><br><br>Unlike sets, lists typically allow duplicate elements.  More formally,<br>lists typically allow pairs of elements <tt>e1</tt> and <tt>e2</tt><br>such that <tt>e1.equals(e2)</tt>, and they typically allow multiple<br>null elements if they allow null elements at all.  It is not inconceivable<br>that someone might wish to implement a list that prohibits duplicates, by<br>throwing runtime exceptions when the user attempts to insert them, but we<br>expect this usage to be rare.<p><br><br>The <tt>List</tt> interface places additional stipulations, beyond those<br>specified in the <tt>Collection</tt> interface, on the contracts of the<br><tt>iterator</tt>, <tt>add</tt>, <tt>remove</tt>, <tt>equals</tt>, and<br><tt>hashCode</tt> methods.  Declarations for other inherited methods are<br>also included here for convenience.<p><br><br>The <tt>List</tt> interface provides four methods for positional (indexed)<br>access to list elements.  Lists (like Java arrays) are zero based.  Note<br>that these operations may execute in time proportional to the index value<br>for some implementations (the <tt>LinkedList</tt> class, for<br>example). Thus, iterating over the elements in a list is typically<br>preferable to indexing through it if the caller does not know the<br>implementation.<p><br><br>The <tt>List</tt> interface provides a special iterator, called a<br><tt>ListIterator</tt>, that allows element insertion and replacement, and<br>bidirectional access in addition to the normal operations that the<br><tt>Iterator</tt> interface provides.  A method is provided to obtain a<br>list iterator that starts at a specified position in the list.<p><br><br>The <tt>List</tt> interface provides two methods to search for a specified<br>object.  From a performance standpoint, these methods should be used with<br>caution.  In many implementations they will perform costly linear<br>searches.<p><br><br>The <tt>List</tt> interface provides two methods to efficiently insert and<br>remove multiple elements at an arbitrary point in the list.<p><br><br>Note: While it is permissible for lists to contain themselves as elements,<br>extreme caution is advised: the <tt>equals</tt> and <tt>hashCode</tt><br>methods are no longer well defined on such a list.<br><br><p>Some list implementations have restrictions on the elements that<br>they may contain.  For example, some implementations prohibit null elements,<br>and some have restrictions on the types of their elements.  Attempting to<br>add an ineligible element throws an unchecked exception, typically<br><tt>NullPointerException</tt> or <tt>ClassCastException</tt>.  Attempting<br>to query the presence of an ineligible element may throw an exception,<br>or it may simply return false; some implementations will exhibit the former<br>behavior and some will exhibit the latter.  More generally, attempting an<br>operation on an ineligible element whose completion would not result in<br>the insertion of an ineligible element into the list may throw an<br>exception or it may succeed, at the option of the implementation.<br>Such exceptions are marked as "optional" in the specification for this<br>interface.<br><br><p>This interface is a member of the<br><a href="{@docRoot}/../technotes/guides/collections/index.html"><br>Java Collections Framework</a>.]<[Project name(项目名称)：aggregate-pay<br>Package(包名): mao.aggregate_pay_user_api.dto.auth<br>Class(类名): PrivilegeDTO<br>Author(作者）: mao<br>Author QQ：1296193245<br>GitHub：https://github.com/maomao124/<br>Date(创建日期)： 2023/1/18<br>Time(创建时间)： 19:05<br>Version(版本): 1.0<br>Description(描述)： 无]> |
|  | object |  |
| &ensp;&ensp;&#124;─id | integer | 权限id |
| &ensp;&ensp;&#124;─name | string | 权限名称 |
| &ensp;&ensp;&#124;─code | string | 权限编码 |
| &ensp;&ensp;&#124;─privilegeGroupId | integer | 所属权限组id |

**Response Demo:**

```json
[
  {
    "id": 0,
    "name": "",
    "code": "",
    "privilegeGroupId": 0
  }
]
```




---
### 查询权限组id

> BASIC

**Path:** /privilege-groups/{privilegeGroupId}/privilege-list

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| privilegeGroupId |  | 权限组id |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
|  | array | [An ordered collection (also known as a <i>sequence</i>).  The user of this<br>interface has precise control over where in the list each element is<br>inserted.  The user can access elements by their integer index (position in<br>the list), and search for elements in the list.<p><br><br>Unlike sets, lists typically allow duplicate elements.  More formally,<br>lists typically allow pairs of elements <tt>e1</tt> and <tt>e2</tt><br>such that <tt>e1.equals(e2)</tt>, and they typically allow multiple<br>null elements if they allow null elements at all.  It is not inconceivable<br>that someone might wish to implement a list that prohibits duplicates, by<br>throwing runtime exceptions when the user attempts to insert them, but we<br>expect this usage to be rare.<p><br><br>The <tt>List</tt> interface places additional stipulations, beyond those<br>specified in the <tt>Collection</tt> interface, on the contracts of the<br><tt>iterator</tt>, <tt>add</tt>, <tt>remove</tt>, <tt>equals</tt>, and<br><tt>hashCode</tt> methods.  Declarations for other inherited methods are<br>also included here for convenience.<p><br><br>The <tt>List</tt> interface provides four methods for positional (indexed)<br>access to list elements.  Lists (like Java arrays) are zero based.  Note<br>that these operations may execute in time proportional to the index value<br>for some implementations (the <tt>LinkedList</tt> class, for<br>example). Thus, iterating over the elements in a list is typically<br>preferable to indexing through it if the caller does not know the<br>implementation.<p><br><br>The <tt>List</tt> interface provides a special iterator, called a<br><tt>ListIterator</tt>, that allows element insertion and replacement, and<br>bidirectional access in addition to the normal operations that the<br><tt>Iterator</tt> interface provides.  A method is provided to obtain a<br>list iterator that starts at a specified position in the list.<p><br><br>The <tt>List</tt> interface provides two methods to search for a specified<br>object.  From a performance standpoint, these methods should be used with<br>caution.  In many implementations they will perform costly linear<br>searches.<p><br><br>The <tt>List</tt> interface provides two methods to efficiently insert and<br>remove multiple elements at an arbitrary point in the list.<p><br><br>Note: While it is permissible for lists to contain themselves as elements,<br>extreme caution is advised: the <tt>equals</tt> and <tt>hashCode</tt><br>methods are no longer well defined on such a list.<br><br><p>Some list implementations have restrictions on the elements that<br>they may contain.  For example, some implementations prohibit null elements,<br>and some have restrictions on the types of their elements.  Attempting to<br>add an ineligible element throws an unchecked exception, typically<br><tt>NullPointerException</tt> or <tt>ClassCastException</tt>.  Attempting<br>to query the presence of an ineligible element may throw an exception,<br>or it may simply return false; some implementations will exhibit the former<br>behavior and some will exhibit the latter.  More generally, attempting an<br>operation on an ineligible element whose completion would not result in<br>the insertion of an ineligible element into the list may throw an<br>exception or it may succeed, at the option of the implementation.<br>Such exceptions are marked as "optional" in the specification for this<br>interface.<br><br><p>This interface is a member of the<br><a href="{@docRoot}/../technotes/guides/collections/index.html"><br>Java Collections Framework</a>.]<[Project name(项目名称)：aggregate-pay<br>Package(包名): mao.aggregate_pay_user_api.dto.auth<br>Class(类名): PrivilegeDTO<br>Author(作者）: mao<br>Author QQ：1296193245<br>GitHub：https://github.com/maomao124/<br>Date(创建日期)： 2023/1/18<br>Time(创建时间)： 19:05<br>Version(版本): 1.0<br>Description(描述)： 无]> |
|  | object |  |
| &ensp;&ensp;&#124;─id | integer | 权限id |
| &ensp;&ensp;&#124;─name | string | 权限名称 |
| &ensp;&ensp;&#124;─code | string | 权限编码 |
| &ensp;&ensp;&#124;─privilegeGroupId | integer | 所属权限组id |

**Response Demo:**

```json
[
  {
    "id": 0,
    "name": "",
    "code": "",
    "privilegeGroupId": 0
  }
]
```




---
### 查询权限树

> BASIC

**Path:** /tenants/{tenantId}/roles/role-privilege-list

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| tenantId |  | 承租者id |

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| roleCodes |  | YES | 角色代码 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| id | string | 权限组使用id,权限使用code，约束code不能为纯数值保证不重复 |
| name | string | 节点名称 |
| parentId | string | 一定是权限组id，权限没有结构<br>父级id |
| sort | integer | 同层排序,不排序都为0 |
| status | integer | 状态 |
| isGroup | boolean | 是否为权限组 |
| children | array | 子节点集合 |
| &ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─id | string | 权限组使用id,权限使用code，约束code不能为纯数值保证不重复 |
| &ensp;&ensp;&ensp;&ensp;&#124;─name | string | 节点名称 |
| &ensp;&ensp;&ensp;&ensp;&#124;─parentId | string | 一定是权限组id，权限没有结构<br>父级id |
| &ensp;&ensp;&ensp;&ensp;&#124;─sort | integer | 同层排序,不排序都为0 |
| &ensp;&ensp;&ensp;&ensp;&#124;─status | integer | 状态 |
| &ensp;&ensp;&ensp;&ensp;&#124;─isGroup | boolean | 是否为权限组 |
| &ensp;&ensp;&ensp;&ensp;&#124;─children | array | 子节点集合 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─ | object |  |

**Response Demo:**

```json
{
  "id": "",
  "name": "",
  "parentId": "",
  "sort": 0,
  "status": 0,
  "isGroup": false,
  "children": [
    {
      "id": "",
      "name": "",
      "parentId": "",
      "sort": 0,
      "status": 0,
      "isGroup": false,
      "children": [
        {}
      ]
    }
  ]
}
```




---
### 创建角色

> BASIC

**Path:** /tenants/{tenantId}/roles

**Method:** POST

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| tenantId |  | 承租者id |

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| id | integer | id |
| name | string | 角色名称 |
| code | string | 角色编码 |
| tenantId | integer | 角色所属租户 |
| privilegeCodes | array | 角色包含权限列表 |
| &ensp;&ensp;&#124;─ | string |  |

**Request Demo:**

```json
{
  "id": 0,
  "name": "",
  "code": "",
  "tenantId": 0,
  "privilegeCodes": [
    ""
  ]
}
```




---
### 删除角色

> BASIC

**Path:** /tenants/{tenantId}/roles/{roleCode}

**Method:** DELETE

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| tenantId |  | 承租者id |
| roleCode |  | 角色代码 |

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/x-www-form-urlencoded | YES |  |




---
### 修改角色

> BASIC

**Path:** /tenants/roles

**Method:** PUT

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| id | integer | id |
| name | string | 角色名称 |
| code | string | 角色编码 |
| tenantId | integer | 角色所属租户 |
| privilegeCodes | array | 角色包含权限列表 |
| &ensp;&ensp;&#124;─ | string |  |

**Request Demo:**

```json
{
  "id": 0,
  "name": "",
  "code": "",
  "tenantId": 0,
  "privilegeCodes": [
    ""
  ]
}
```




---
### 角色绑定特权

> BASIC

**Path:** /tenants/{tenantId}/roles/{roleCode}/privileges

**Method:** PUT

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| tenantId |  | 承租者id |
| roleCode |  | 角色代码 |

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/x-www-form-urlencoded | YES |  |

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| privilegeCodes |  | YES | 特权代码 |




---
### 查询角色

> BASIC

**Path:** /tenants/{tenantId}/roles

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| tenantId |  | 承租者id |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
|  | array | [An ordered collection (also known as a <i>sequence</i>).  The user of this<br>interface has precise control over where in the list each element is<br>inserted.  The user can access elements by their integer index (position in<br>the list), and search for elements in the list.<p><br><br>Unlike sets, lists typically allow duplicate elements.  More formally,<br>lists typically allow pairs of elements <tt>e1</tt> and <tt>e2</tt><br>such that <tt>e1.equals(e2)</tt>, and they typically allow multiple<br>null elements if they allow null elements at all.  It is not inconceivable<br>that someone might wish to implement a list that prohibits duplicates, by<br>throwing runtime exceptions when the user attempts to insert them, but we<br>expect this usage to be rare.<p><br><br>The <tt>List</tt> interface places additional stipulations, beyond those<br>specified in the <tt>Collection</tt> interface, on the contracts of the<br><tt>iterator</tt>, <tt>add</tt>, <tt>remove</tt>, <tt>equals</tt>, and<br><tt>hashCode</tt> methods.  Declarations for other inherited methods are<br>also included here for convenience.<p><br><br>The <tt>List</tt> interface provides four methods for positional (indexed)<br>access to list elements.  Lists (like Java arrays) are zero based.  Note<br>that these operations may execute in time proportional to the index value<br>for some implementations (the <tt>LinkedList</tt> class, for<br>example). Thus, iterating over the elements in a list is typically<br>preferable to indexing through it if the caller does not know the<br>implementation.<p><br><br>The <tt>List</tt> interface provides a special iterator, called a<br><tt>ListIterator</tt>, that allows element insertion and replacement, and<br>bidirectional access in addition to the normal operations that the<br><tt>Iterator</tt> interface provides.  A method is provided to obtain a<br>list iterator that starts at a specified position in the list.<p><br><br>The <tt>List</tt> interface provides two methods to search for a specified<br>object.  From a performance standpoint, these methods should be used with<br>caution.  In many implementations they will perform costly linear<br>searches.<p><br><br>The <tt>List</tt> interface provides two methods to efficiently insert and<br>remove multiple elements at an arbitrary point in the list.<p><br><br>Note: While it is permissible for lists to contain themselves as elements,<br>extreme caution is advised: the <tt>equals</tt> and <tt>hashCode</tt><br>methods are no longer well defined on such a list.<br><br><p>Some list implementations have restrictions on the elements that<br>they may contain.  For example, some implementations prohibit null elements,<br>and some have restrictions on the types of their elements.  Attempting to<br>add an ineligible element throws an unchecked exception, typically<br><tt>NullPointerException</tt> or <tt>ClassCastException</tt>.  Attempting<br>to query the presence of an ineligible element may throw an exception,<br>or it may simply return false; some implementations will exhibit the former<br>behavior and some will exhibit the latter.  More generally, attempting an<br>operation on an ineligible element whose completion would not result in<br>the insertion of an ineligible element into the list may throw an<br>exception or it may succeed, at the option of the implementation.<br>Such exceptions are marked as "optional" in the specification for this<br>interface.<br><br><p>This interface is a member of the<br><a href="{@docRoot}/../technotes/guides/collections/index.html"><br>Java Collections Framework</a>.]<[Project name(项目名称)：aggregate-pay<br>Package(包名): mao.aggregate_pay_user_api.dto.auth<br>Class(类名): RoleDTO<br>Author(作者）: mao<br>Author QQ：1296193245<br>GitHub：https://github.com/maomao124/<br>Date(创建日期)： 2023/1/18<br>Time(创建时间)： 19:08<br>Version(版本): 1.0<br>Description(描述)： 角色信息]> |
|  | object |  |
| &ensp;&ensp;&#124;─id | integer | id |
| &ensp;&ensp;&#124;─name | string | 角色名称 |
| &ensp;&ensp;&#124;─code | string | 角色编码 |
| &ensp;&ensp;&#124;─tenantId | integer | 角色所属租户 |
| &ensp;&ensp;&#124;─privilegeCodes | array | 角色包含权限列表 |
| &ensp;&ensp;&ensp;&ensp;&#124;─ | string |  |

**Response Demo:**

```json
[
  {
    "id": 0,
    "name": "",
    "code": "",
    "tenantId": 0,
    "privilegeCodes": [
      ""
    ]
  }
]
```




---
### 查询角色

> BASIC

**Path:** /roles/tenants/{tenantId}

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| tenantId |  | 承租者id |

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| roleCodes |  | YES | 角色代码 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
|  | array | [An ordered collection (also known as a <i>sequence</i>).  The user of this<br>interface has precise control over where in the list each element is<br>inserted.  The user can access elements by their integer index (position in<br>the list), and search for elements in the list.<p><br><br>Unlike sets, lists typically allow duplicate elements.  More formally,<br>lists typically allow pairs of elements <tt>e1</tt> and <tt>e2</tt><br>such that <tt>e1.equals(e2)</tt>, and they typically allow multiple<br>null elements if they allow null elements at all.  It is not inconceivable<br>that someone might wish to implement a list that prohibits duplicates, by<br>throwing runtime exceptions when the user attempts to insert them, but we<br>expect this usage to be rare.<p><br><br>The <tt>List</tt> interface places additional stipulations, beyond those<br>specified in the <tt>Collection</tt> interface, on the contracts of the<br><tt>iterator</tt>, <tt>add</tt>, <tt>remove</tt>, <tt>equals</tt>, and<br><tt>hashCode</tt> methods.  Declarations for other inherited methods are<br>also included here for convenience.<p><br><br>The <tt>List</tt> interface provides four methods for positional (indexed)<br>access to list elements.  Lists (like Java arrays) are zero based.  Note<br>that these operations may execute in time proportional to the index value<br>for some implementations (the <tt>LinkedList</tt> class, for<br>example). Thus, iterating over the elements in a list is typically<br>preferable to indexing through it if the caller does not know the<br>implementation.<p><br><br>The <tt>List</tt> interface provides a special iterator, called a<br><tt>ListIterator</tt>, that allows element insertion and replacement, and<br>bidirectional access in addition to the normal operations that the<br><tt>Iterator</tt> interface provides.  A method is provided to obtain a<br>list iterator that starts at a specified position in the list.<p><br><br>The <tt>List</tt> interface provides two methods to search for a specified<br>object.  From a performance standpoint, these methods should be used with<br>caution.  In many implementations they will perform costly linear<br>searches.<p><br><br>The <tt>List</tt> interface provides two methods to efficiently insert and<br>remove multiple elements at an arbitrary point in the list.<p><br><br>Note: While it is permissible for lists to contain themselves as elements,<br>extreme caution is advised: the <tt>equals</tt> and <tt>hashCode</tt><br>methods are no longer well defined on such a list.<br><br><p>Some list implementations have restrictions on the elements that<br>they may contain.  For example, some implementations prohibit null elements,<br>and some have restrictions on the types of their elements.  Attempting to<br>add an ineligible element throws an unchecked exception, typically<br><tt>NullPointerException</tt> or <tt>ClassCastException</tt>.  Attempting<br>to query the presence of an ineligible element may throw an exception,<br>or it may simply return false; some implementations will exhibit the former<br>behavior and some will exhibit the latter.  More generally, attempting an<br>operation on an ineligible element whose completion would not result in<br>the insertion of an ineligible element into the list may throw an<br>exception or it may succeed, at the option of the implementation.<br>Such exceptions are marked as "optional" in the specification for this<br>interface.<br><br><p>This interface is a member of the<br><a href="{@docRoot}/../technotes/guides/collections/index.html"><br>Java Collections Framework</a>.]<[Project name(项目名称)：aggregate-pay<br>Package(包名): mao.aggregate_pay_user_api.dto.auth<br>Class(类名): RoleDTO<br>Author(作者）: mao<br>Author QQ：1296193245<br>GitHub：https://github.com/maomao124/<br>Date(创建日期)： 2023/1/18<br>Time(创建时间)： 19:08<br>Version(版本): 1.0<br>Description(描述)： 角色信息]> |
|  | object |  |
| &ensp;&ensp;&#124;─id | integer | id |
| &ensp;&ensp;&#124;─name | string | 角色名称 |
| &ensp;&ensp;&#124;─code | string | 角色编码 |
| &ensp;&ensp;&#124;─tenantId | integer | 角色所属租户 |
| &ensp;&ensp;&#124;─privilegeCodes | array | 角色包含权限列表 |
| &ensp;&ensp;&ensp;&ensp;&#124;─ | string |  |

**Response Demo:**

```json
[
  {
    "id": 0,
    "name": "",
    "code": "",
    "tenantId": 0,
    "privilegeCodes": [
      ""
    ]
  }
]
```




---
### 查询租户作用

> BASIC

**Path:** /tenants/{tenantId}/roles/{roleCode}/role-privilege

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| tenantId |  | 承租者id |
| roleCode |  | 角色代码 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| id | integer | id |
| name | string | 角色名称 |
| code | string | 角色编码 |
| tenantId | integer | 角色所属租户 |
| privilegeCodes | array | 角色包含权限列表 |
| &ensp;&ensp;&#124;─ | string |  |

**Response Demo:**

```json
{
  "id": 0,
  "name": "",
  "code": "",
  "tenantId": 0,
  "privilegeCodes": [
    ""
  ]
}
```




---
### bindAccountRole

> BASIC

**Path:** /bind/tenants/{tenantId}/accounts/{username}/roles

**Method:** POST

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| username |  |  |
| tenantId |  |  |

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/x-www-form-urlencoded | YES |  |

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| roleCodes |  | YES |  |




---
### 解开帐户作用

> BASIC

**Path:** /unbind/tenants/{tenantId}/accounts/{username}/roles

**Method:** PUT

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| username |  | 用户名 |
| tenantId |  | 承租者id |

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/x-www-form-urlencoded | YES |  |

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| roleCodes |  | YES | 角色代码 |





## Project name(项目名称)：aggregate-pay

Project name(项目名称)：aggregate-pay
Package(包名): mao.aggregate_pay_user_service.controller
Class(类名): TenantController
Author(作者）: mao
Author QQ：1296193245
GitHub：https://github.com/maomao124/
Date(创建日期)： 2023/1/21
Time(创建时间)： 12:52
Version(版本): 1.0
Description(描述)： 统一账号-租户、套餐、账号相关


---
### 创建租户

> BASIC

**Path:** /tenants

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| name | string | 租户名称 |
| tenantTypeCode | string | 租户类型编码 |
| bundleCode | string | 初始化套餐编码 |
| mobile | string | 租户管理员登录手机号 |
| password | string | 租户管理员登录密码 |
| username | string | 租户管理员登录用户名 |

**Request Demo:**

```json
{
  "name": "",
  "tenantTypeCode": "",
  "bundleCode": "",
  "mobile": "",
  "password": "",
  "username": ""
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| id | integer | 租户id |
| name | string | 租户名称 |
| tenantTypeCode | string | 租户类型编码 |
| bundleCode | string | 套餐编码 |

**Response Demo:**

```json
{
  "id": 0,
  "name": "",
  "tenantTypeCode": "",
  "bundleCode": ""
}
```




---
### 创建租户并关联账号

> BASIC

**Path:** /tenantRelateAccount

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| name | string | 租户名称 |
| tenantTypeCode | string | 租户类型编码 |
| bundleCode | string | 初始化套餐编码 |
| mobile | string | 租户管理员登录手机号 |
| password | string | 租户管理员登录密码 |
| username | string | 租户管理员登录用户名 |

**Request Demo:**

```json
{
  "name": "",
  "tenantTypeCode": "",
  "bundleCode": "",
  "mobile": "",
  "password": "",
  "username": ""
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| id | integer | 租户id |
| name | string | 租户名称 |
| tenantTypeCode | string | 租户类型编码 |
| bundleCode | string | 套餐编码 |

**Response Demo:**

```json
{
  "id": 0,
  "name": "",
  "tenantTypeCode": "",
  "bundleCode": ""
}
```




---
### 获取租户信息

> BASIC

**Path:** /tenants/{id}

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| id |  | id |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| id | integer | 租户id |
| name | string | 租户名称 |
| tenantTypeCode | string | 租户类型编码 |
| bundleCode | string | 套餐编码 |

**Response Demo:**

```json
{
  "id": 0,
  "name": "",
  "tenantTypeCode": "",
  "bundleCode": ""
}
```




---
### 查询租户

> BASIC

**Path:** /tenants/page

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| pageNo |  | YES | 页号 |
| pageSize |  | YES | 页面大小 |
| sortBy |  | YES | 排序 |
| order |  | YES | 订单 |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| name | string | 租户名称 |
| tenantTypeCode | string | 租户类型 |

**Request Demo:**

```json
{
  "name": "",
  "tenantTypeCode": ""
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
|  | array | [Project name(项目名称)：aggregate-pay<br>Package(包名): mao.aggregate_pay_common.domain<br>Class(类名): PageVO<br>Author(作者）: mao<br>Author QQ：1296193245<br>GitHub：https://github.com/maomao124/<br>Date(创建日期)： 2023/1/7<br>Time(创建时间)： 14:48<br>Version(版本): 1.0<br>Description(描述)： 无]<[Project name(项目名称)：aggregate-pay<br>Package(包名): mao.aggregate_pay_user_api.dto.tenant<br>Class(类名): TenantDTO<br>Author(作者）: mao<br>Author QQ：1296193245<br>GitHub：https://github.com/maomao124/<br>Date(创建日期)： 2023/1/18<br>Time(创建时间)： 19:34<br>Version(版本): 1.0<br>Description(描述)： 无]> |
|  | object |  |
| &ensp;&ensp;&#124;─id | integer | 租户id |
| &ensp;&ensp;&#124;─name | string | 租户名称 |
| &ensp;&ensp;&#124;─tenantTypeCode | string | 租户类型编码 |
| &ensp;&ensp;&#124;─bundleCode | string | 套餐编码 |

**Response Demo:**

```json
[
  {
    "id": 0,
    "name": "",
    "tenantTypeCode": "",
    "bundleCode": ""
  }
]
```




---
### 查询某租户类型的套餐列表

> BASIC

**Path:** /bundles/tenant-types/{tenantType}/bundle-list

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| tenantType |  | 租客类型 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
|  | array | [An ordered collection (also known as a <i>sequence</i>).  The user of this<br>interface has precise control over where in the list each element is<br>inserted.  The user can access elements by their integer index (position in<br>the list), and search for elements in the list.<p><br><br>Unlike sets, lists typically allow duplicate elements.  More formally,<br>lists typically allow pairs of elements <tt>e1</tt> and <tt>e2</tt><br>such that <tt>e1.equals(e2)</tt>, and they typically allow multiple<br>null elements if they allow null elements at all.  It is not inconceivable<br>that someone might wish to implement a list that prohibits duplicates, by<br>throwing runtime exceptions when the user attempts to insert them, but we<br>expect this usage to be rare.<p><br><br>The <tt>List</tt> interface places additional stipulations, beyond those<br>specified in the <tt>Collection</tt> interface, on the contracts of the<br><tt>iterator</tt>, <tt>add</tt>, <tt>remove</tt>, <tt>equals</tt>, and<br><tt>hashCode</tt> methods.  Declarations for other inherited methods are<br>also included here for convenience.<p><br><br>The <tt>List</tt> interface provides four methods for positional (indexed)<br>access to list elements.  Lists (like Java arrays) are zero based.  Note<br>that these operations may execute in time proportional to the index value<br>for some implementations (the <tt>LinkedList</tt> class, for<br>example). Thus, iterating over the elements in a list is typically<br>preferable to indexing through it if the caller does not know the<br>implementation.<p><br><br>The <tt>List</tt> interface provides a special iterator, called a<br><tt>ListIterator</tt>, that allows element insertion and replacement, and<br>bidirectional access in addition to the normal operations that the<br><tt>Iterator</tt> interface provides.  A method is provided to obtain a<br>list iterator that starts at a specified position in the list.<p><br><br>The <tt>List</tt> interface provides two methods to search for a specified<br>object.  From a performance standpoint, these methods should be used with<br>caution.  In many implementations they will perform costly linear<br>searches.<p><br><br>The <tt>List</tt> interface provides two methods to efficiently insert and<br>remove multiple elements at an arbitrary point in the list.<p><br><br>Note: While it is permissible for lists to contain themselves as elements,<br>extreme caution is advised: the <tt>equals</tt> and <tt>hashCode</tt><br>methods are no longer well defined on such a list.<br><br><p>Some list implementations have restrictions on the elements that<br>they may contain.  For example, some implementations prohibit null elements,<br>and some have restrictions on the types of their elements.  Attempting to<br>add an ineligible element throws an unchecked exception, typically<br><tt>NullPointerException</tt> or <tt>ClassCastException</tt>.  Attempting<br>to query the presence of an ineligible element may throw an exception,<br>or it may simply return false; some implementations will exhibit the former<br>behavior and some will exhibit the latter.  More generally, attempting an<br>operation on an ineligible element whose completion would not result in<br>the insertion of an ineligible element into the list may throw an<br>exception or it may succeed, at the option of the implementation.<br>Such exceptions are marked as "optional" in the specification for this<br>interface.<br><br><p>This interface is a member of the<br><a href="{@docRoot}/../technotes/guides/collections/index.html"><br>Java Collections Framework</a>.]<[Project name(项目名称)：aggregate-pay<br>Package(包名): mao.aggregate_pay_user_api.dto.tenant<br>Class(类名): BundleDTO<br>Author(作者）: mao<br>Author QQ：1296193245<br>GitHub：https://github.com/maomao124/<br>Date(创建日期)： 2023/1/18<br>Time(创建时间)： 19:31<br>Version(版本): 1.0<br>Description(描述)： 无]> |
|  | object |  |
| &ensp;&ensp;&#124;─id | integer | id |
| &ensp;&ensp;&#124;─name | string | 套餐名称 |
| &ensp;&ensp;&#124;─code | string | 套餐编码 |
| &ensp;&ensp;&#124;─tenantTypeCode | string | 租户类型编码 |
| &ensp;&ensp;&#124;─ability | string | 套餐包含功能描述 |
| &ensp;&ensp;&#124;─numberOfInvocation | integer | API调用次数 |
| &ensp;&ensp;&#124;─numberOfConcurrent | integer | 并发数 |
| &ensp;&ensp;&#124;─numberOfApp | integer | 允许创建应用数量 |
| &ensp;&ensp;&#124;─comment | string | 套餐说明 |
| &ensp;&ensp;&#124;─initialize | boolean | 是否为初始化套餐 |

**Response Demo:**

```json
[
  {
    "id": 0,
    "name": "",
    "code": "",
    "tenantTypeCode": "",
    "ability": "",
    "numberOfInvocation": 0,
    "numberOfConcurrent": 0,
    "numberOfApp": 0,
    "comment": "",
    "initialize": false
  }
]
```




---
### 获取某套餐信息

> BASIC

**Path:** /bundles/{bundleCode}

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| bundleCode |  | 包代码 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| id | integer | id |
| name | string | 套餐名称 |
| code | string | 套餐编码 |
| tenantTypeCode | string | 租户类型编码 |
| ability | string | 套餐包含功能描述 |
| numberOfInvocation | integer | API调用次数 |
| numberOfConcurrent | integer | 并发数 |
| numberOfApp | integer | 允许创建应用数量 |
| comment | string | 套餐说明 |
| initialize | boolean | 是否为初始化套餐 |

**Response Demo:**

```json
{
  "id": 0,
  "name": "",
  "code": "",
  "tenantTypeCode": "",
  "ability": "",
  "numberOfInvocation": 0,
  "numberOfConcurrent": 0,
  "numberOfApp": 0,
  "comment": "",
  "initialize": false
}
```




---
### 查询所有套餐

> BASIC

**Path:** /bundles/bundle-list

**Method:** GET

> REQUEST



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
|  | array | [An ordered collection (also known as a <i>sequence</i>).  The user of this<br>interface has precise control over where in the list each element is<br>inserted.  The user can access elements by their integer index (position in<br>the list), and search for elements in the list.<p><br><br>Unlike sets, lists typically allow duplicate elements.  More formally,<br>lists typically allow pairs of elements <tt>e1</tt> and <tt>e2</tt><br>such that <tt>e1.equals(e2)</tt>, and they typically allow multiple<br>null elements if they allow null elements at all.  It is not inconceivable<br>that someone might wish to implement a list that prohibits duplicates, by<br>throwing runtime exceptions when the user attempts to insert them, but we<br>expect this usage to be rare.<p><br><br>The <tt>List</tt> interface places additional stipulations, beyond those<br>specified in the <tt>Collection</tt> interface, on the contracts of the<br><tt>iterator</tt>, <tt>add</tt>, <tt>remove</tt>, <tt>equals</tt>, and<br><tt>hashCode</tt> methods.  Declarations for other inherited methods are<br>also included here for convenience.<p><br><br>The <tt>List</tt> interface provides four methods for positional (indexed)<br>access to list elements.  Lists (like Java arrays) are zero based.  Note<br>that these operations may execute in time proportional to the index value<br>for some implementations (the <tt>LinkedList</tt> class, for<br>example). Thus, iterating over the elements in a list is typically<br>preferable to indexing through it if the caller does not know the<br>implementation.<p><br><br>The <tt>List</tt> interface provides a special iterator, called a<br><tt>ListIterator</tt>, that allows element insertion and replacement, and<br>bidirectional access in addition to the normal operations that the<br><tt>Iterator</tt> interface provides.  A method is provided to obtain a<br>list iterator that starts at a specified position in the list.<p><br><br>The <tt>List</tt> interface provides two methods to search for a specified<br>object.  From a performance standpoint, these methods should be used with<br>caution.  In many implementations they will perform costly linear<br>searches.<p><br><br>The <tt>List</tt> interface provides two methods to efficiently insert and<br>remove multiple elements at an arbitrary point in the list.<p><br><br>Note: While it is permissible for lists to contain themselves as elements,<br>extreme caution is advised: the <tt>equals</tt> and <tt>hashCode</tt><br>methods are no longer well defined on such a list.<br><br><p>Some list implementations have restrictions on the elements that<br>they may contain.  For example, some implementations prohibit null elements,<br>and some have restrictions on the types of their elements.  Attempting to<br>add an ineligible element throws an unchecked exception, typically<br><tt>NullPointerException</tt> or <tt>ClassCastException</tt>.  Attempting<br>to query the presence of an ineligible element may throw an exception,<br>or it may simply return false; some implementations will exhibit the former<br>behavior and some will exhibit the latter.  More generally, attempting an<br>operation on an ineligible element whose completion would not result in<br>the insertion of an ineligible element into the list may throw an<br>exception or it may succeed, at the option of the implementation.<br>Such exceptions are marked as "optional" in the specification for this<br>interface.<br><br><p>This interface is a member of the<br><a href="{@docRoot}/../technotes/guides/collections/index.html"><br>Java Collections Framework</a>.]<[Project name(项目名称)：aggregate-pay<br>Package(包名): mao.aggregate_pay_user_api.dto.tenant<br>Class(类名): BundleDTO<br>Author(作者）: mao<br>Author QQ：1296193245<br>GitHub：https://github.com/maomao124/<br>Date(创建日期)： 2023/1/18<br>Time(创建时间)： 19:31<br>Version(版本): 1.0<br>Description(描述)： 无]> |
|  | object |  |
| &ensp;&ensp;&#124;─id | integer | id |
| &ensp;&ensp;&#124;─name | string | 套餐名称 |
| &ensp;&ensp;&#124;─code | string | 套餐编码 |
| &ensp;&ensp;&#124;─tenantTypeCode | string | 租户类型编码 |
| &ensp;&ensp;&#124;─ability | string | 套餐包含功能描述 |
| &ensp;&ensp;&#124;─numberOfInvocation | integer | API调用次数 |
| &ensp;&ensp;&#124;─numberOfConcurrent | integer | 并发数 |
| &ensp;&ensp;&#124;─numberOfApp | integer | 允许创建应用数量 |
| &ensp;&ensp;&#124;─comment | string | 套餐说明 |
| &ensp;&ensp;&#124;─initialize | boolean | 是否为初始化套餐 |

**Response Demo:**

```json
[
  {
    "id": 0,
    "name": "",
    "code": "",
    "tenantTypeCode": "",
    "ability": "",
    "numberOfInvocation": 0,
    "numberOfConcurrent": 0,
    "numberOfApp": 0,
    "comment": "",
    "initialize": false
  }
]
```




---
### 切换租户套餐

> BASIC

**Path:** /tenants/{tenantId}/bundles/{bundleCode}

**Method:** PUT

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| tenantId |  | 承租者id |
| bundleCode |  | 包代码 |

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/x-www-form-urlencoded | YES |  |




---
### 初始化租户套餐

> BASIC

**Path:** /tenants/{tenantId}/bundles/{bundleCode}

**Method:** POST

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| tenantId |  | 承租者id |
| bundleCode |  | 包代码 |

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/x-www-form-urlencoded | YES |  |




---
### 新增套餐

> BASIC

**Path:** /bundles

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| id | integer | id |
| name | string | 套餐名称 |
| code | string | 套餐编码 |
| tenantTypeCode | string | 租户类型编码 |
| ability | string | 套餐包含功能描述 |
| numberOfInvocation | integer | API调用次数 |
| numberOfConcurrent | integer | 并发数 |
| numberOfApp | integer | 允许创建应用数量 |
| comment | string | 套餐说明 |
| initialize | boolean | 是否为初始化套餐 |

**Request Demo:**

```json
{
  "id": 0,
  "name": "",
  "code": "",
  "tenantTypeCode": "",
  "ability": "",
  "numberOfInvocation": 0,
  "numberOfConcurrent": 0,
  "numberOfApp": 0,
  "comment": "",
  "initialize": false
}
```




---
### 更新套餐

> BASIC

**Path:** /bundles

**Method:** PUT

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| id | integer | id |
| name | string | 套餐名称 |
| code | string | 套餐编码 |
| tenantTypeCode | string | 租户类型编码 |
| ability | string | 套餐包含功能描述 |
| numberOfInvocation | integer | API调用次数 |
| numberOfConcurrent | integer | 并发数 |
| numberOfApp | integer | 允许创建应用数量 |
| comment | string | 套餐说明 |
| initialize | boolean | 是否为初始化套餐 |

**Request Demo:**

```json
{
  "id": 0,
  "name": "",
  "code": "",
  "tenantTypeCode": "",
  "ability": "",
  "numberOfInvocation": 0,
  "numberOfConcurrent": 0,
  "numberOfApp": 0,
  "comment": "",
  "initialize": false
}
```




---
### 创建账户

> BASIC

**Path:** /accounts

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| username | string | 用户名 |
| mobile | string | 手机号 |
| password | string | 密码 |

**Request Demo:**

```json
{
  "username": "",
  "mobile": "",
  "password": ""
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| id | integer | 账号id |
| username | string | 用户名 |
| mobile | string | 手机号 |
| password | string | 密码 |
| salt | string | 盐 |

**Response Demo:**

```json
{
  "id": 0,
  "username": "",
  "mobile": "",
  "password": "",
  "salt": ""
}
```




---
### 创建账户

> BASIC

**Path:** /accounts/password

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| accountId | integer | 帐户id |
| userName | string | 用户名 |
| password | string | 密码 |

**Request Demo:**

```json
{
  "accountId": 0,
  "userName": "",
  "password": ""
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
|  | boolean | [The Boolean class wraps a value of the primitive type<br>{@code boolean} in an object. An object of type<br>{@code Boolean} contains a single field whose type is<br>{@code boolean}.<br><p><br>In addition, this class provides many methods for<br>converting a{@code boolean} to a{@code String} and a<br>{@code String} to a{@code boolean}, as well as other<br>constants and methods useful when dealing with a<br>{@code boolean}.] |

**Response Demo:**

```json
false
```




---
### 创建账号并绑定至某租户

> BASIC

**Path:** /accounts/tenants/{tenantId}

**Method:** POST

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| tenantId |  | 承租者id |

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| username | string | 用户名 |
| mobile | string | 手机号 |
| password | string | 密码 |

**Request Demo:**

```json
{
  "username": "",
  "mobile": "",
  "password": ""
}
```




---
### 将已存在账号，加入到某租户

> BASIC

**Path:** /bind/accounts/{username}/tenants/{tenantId}

**Method:** POST

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| tenantId |  | 承租者id |
| username |  | 用户名 |

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/x-www-form-urlencoded | YES |  |




---
### 将某账号从租户内移除

> BASIC

**Path:** /unbind/accounts/{username}/tenants/{tenantId}

**Method:** DELETE

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| tenantId |  | 承租者id |
| username |  | 用户名 |

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/x-www-form-urlencoded | YES |  |




---
### 根据用户名判断账号是否存在

> BASIC

**Path:** /exist/accounts/name/{username}

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| username |  | 用户名 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
|  | boolean | boolean |

**Response Demo:**

```json
false
```




---
### 根据手机号判断账号是否存在

> BASIC

**Path:** /exist/accounts/mobile/{mobile}

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| mobile |  | 移动 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
|  | boolean | boolean |

**Response Demo:**

```json
false
```




---
### 根据用户名获取账号信息

> BASIC

**Path:** /account-information/name/{username}

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| username |  | 用户名 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| id | integer | 账号id |
| username | string | 用户名 |
| mobile | string | 手机号 |
| password | string | 密码 |
| salt | string | 盐 |

**Response Demo:**

```json
{
  "id": 0,
  "username": "",
  "mobile": "",
  "password": "",
  "salt": ""
}
```




---
### 根据手机号获取账号信息

> BASIC

**Path:** /accounts-information/mobile/{mobile}

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| mobile |  | 移动 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| id | integer | 账号id |
| username | string | 用户名 |
| mobile | string | 手机号 |
| password | string | 密码 |
| salt | string | 盐 |

**Response Demo:**

```json
{
  "id": 0,
  "username": "",
  "mobile": "",
  "password": "",
  "salt": ""
}
```




---
### 根据用户名判断账号是否在某租户内

> BASIC

**Path:** /exist/accounts/{username}/tenants/{tenantId}

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| tenantId |  | 承租者id |
| username |  | 用户名 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
|  | boolean | boolean |

**Response Demo:**

```json
false
```




---
### 根据手机号判断账号是否在某租户内

> BASIC

**Path:** /exist/accounts/tenants/{tenantId}/mobiles/{mobile}

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| tenantId |  | 承租者id |
| mobile |  | 移动 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
|  | boolean | boolean |

**Response Demo:**

```json
false
```




---
### 查询账户

> BASIC

**Path:** /accounts/page

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| pageNo |  | YES | 页号 |
| pageSize |  | YES | 页面大小 |
| sortBy |  | YES | 排序 |
| order |  | YES | 订单 |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| username | string | 用户名 |
| mobile | string | 手机号 |
| tenantId | integer | 所属租户 |

**Request Demo:**

```json
{
  "username": "",
  "mobile": "",
  "tenantId": 0
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
|  | array | [Project name(项目名称)：aggregate-pay<br>Package(包名): mao.aggregate_pay_common.domain<br>Class(类名): PageVO<br>Author(作者）: mao<br>Author QQ：1296193245<br>GitHub：https://github.com/maomao124/<br>Date(创建日期)： 2023/1/7<br>Time(创建时间)： 14:48<br>Version(版本): 1.0<br>Description(描述)： 无]<[Project name(项目名称)：aggregate-pay<br>Package(包名): mao.aggregate_pay_user_api.dto.tenant<br>Class(类名): AccountDTO<br>Author(作者）: mao<br>Author QQ：1296193245<br>GitHub：https://github.com/maomao124/<br>Date(创建日期)： 2023/1/18<br>Time(创建时间)： 19:15<br>Version(版本): 1.0<br>Description(描述)： 账号信息]> |
|  | object |  |
| &ensp;&ensp;&#124;─id | integer | 账号id |
| &ensp;&ensp;&#124;─username | string | 用户名 |
| &ensp;&ensp;&#124;─mobile | string | 手机号 |
| &ensp;&ensp;&#124;─password | string | 密码 |
| &ensp;&ensp;&#124;─salt | string | 盐 |

**Response Demo:**

```json
[
  {
    "id": 0,
    "username": "",
    "mobile": "",
    "password": "",
    "salt": ""
  }
]
```




---
### 查询某账号所属租户列表

> BASIC

**Path:** /accounts/tenant-list/{username}

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| username |  | 用户名 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
|  | array | [An ordered collection (also known as a <i>sequence</i>).  The user of this<br>interface has precise control over where in the list each element is<br>inserted.  The user can access elements by their integer index (position in<br>the list), and search for elements in the list.<p><br><br>Unlike sets, lists typically allow duplicate elements.  More formally,<br>lists typically allow pairs of elements <tt>e1</tt> and <tt>e2</tt><br>such that <tt>e1.equals(e2)</tt>, and they typically allow multiple<br>null elements if they allow null elements at all.  It is not inconceivable<br>that someone might wish to implement a list that prohibits duplicates, by<br>throwing runtime exceptions when the user attempts to insert them, but we<br>expect this usage to be rare.<p><br><br>The <tt>List</tt> interface places additional stipulations, beyond those<br>specified in the <tt>Collection</tt> interface, on the contracts of the<br><tt>iterator</tt>, <tt>add</tt>, <tt>remove</tt>, <tt>equals</tt>, and<br><tt>hashCode</tt> methods.  Declarations for other inherited methods are<br>also included here for convenience.<p><br><br>The <tt>List</tt> interface provides four methods for positional (indexed)<br>access to list elements.  Lists (like Java arrays) are zero based.  Note<br>that these operations may execute in time proportional to the index value<br>for some implementations (the <tt>LinkedList</tt> class, for<br>example). Thus, iterating over the elements in a list is typically<br>preferable to indexing through it if the caller does not know the<br>implementation.<p><br><br>The <tt>List</tt> interface provides a special iterator, called a<br><tt>ListIterator</tt>, that allows element insertion and replacement, and<br>bidirectional access in addition to the normal operations that the<br><tt>Iterator</tt> interface provides.  A method is provided to obtain a<br>list iterator that starts at a specified position in the list.<p><br><br>The <tt>List</tt> interface provides two methods to search for a specified<br>object.  From a performance standpoint, these methods should be used with<br>caution.  In many implementations they will perform costly linear<br>searches.<p><br><br>The <tt>List</tt> interface provides two methods to efficiently insert and<br>remove multiple elements at an arbitrary point in the list.<p><br><br>Note: While it is permissible for lists to contain themselves as elements,<br>extreme caution is advised: the <tt>equals</tt> and <tt>hashCode</tt><br>methods are no longer well defined on such a list.<br><br><p>Some list implementations have restrictions on the elements that<br>they may contain.  For example, some implementations prohibit null elements,<br>and some have restrictions on the types of their elements.  Attempting to<br>add an ineligible element throws an unchecked exception, typically<br><tt>NullPointerException</tt> or <tt>ClassCastException</tt>.  Attempting<br>to query the presence of an ineligible element may throw an exception,<br>or it may simply return false; some implementations will exhibit the former<br>behavior and some will exhibit the latter.  More generally, attempting an<br>operation on an ineligible element whose completion would not result in<br>the insertion of an ineligible element into the list may throw an<br>exception or it may succeed, at the option of the implementation.<br>Such exceptions are marked as "optional" in the specification for this<br>interface.<br><br><p>This interface is a member of the<br><a href="{@docRoot}/../technotes/guides/collections/index.html"><br>Java Collections Framework</a>.]<[Project name(项目名称)：aggregate-pay<br>Package(包名): mao.aggregate_pay_user_api.dto.tenant<br>Class(类名): TenantDTO<br>Author(作者）: mao<br>Author QQ：1296193245<br>GitHub：https://github.com/maomao124/<br>Date(创建日期)： 2023/1/18<br>Time(创建时间)： 19:34<br>Version(版本): 1.0<br>Description(描述)： 无]> |
|  | object |  |
| &ensp;&ensp;&#124;─id | integer | 租户id |
| &ensp;&ensp;&#124;─name | string | 租户名称 |
| &ensp;&ensp;&#124;─tenantTypeCode | string | 租户类型编码 |
| &ensp;&ensp;&#124;─bundleCode | string | 套餐编码 |

**Response Demo:**

```json
[
  {
    "id": 0,
    "name": "",
    "tenantTypeCode": "",
    "bundleCode": ""
  }
]
```




---
### 发送短信验证码

> BASIC

**Path:** /getMessage

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| phone |  | YES | 电话 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
|  | string | [The{@code String} class represents character strings. All<br>string literals in Java programs, such as{@code "abc"}, are<br>implemented as instances of this class.<br><p><br>Strings are constant; their values cannot be changed after they<br>are created. String buffers support mutable strings.<br>Because String objects are immutable they can be shared. For example:<br><blockquote><pre><br>    String str = "abc";<br></pre></blockquote><p><br>is equivalent to:<br><blockquote><pre><br>    char data[] ={'a', 'b', 'c'};<br>    String str = new String(data);<br></pre></blockquote><p><br>Here are some more examples of how strings can be used:<br><blockquote><pre><br>    System.out.println("abc");<br>    String cde = "cde";<br>    System.out.println("abc" + cde);<br>    String c = "abc".substring(2,3);<br>    String d = cde.substring(1, 2);<br></pre></blockquote><br><p><br>The class{@code String} includes methods for examining<br>individual characters of the sequence, for comparing strings, for<br>searching strings, for extracting substrings, and for creating a<br>copy of a string with all characters translated to uppercase or to<br>lowercase. Case mapping is based on the Unicode Standard version<br>specified by the{@link java.lang.Character Character} class.<br><p><br>The Java language provides special support for the string<br>concatenation operator (&nbsp;+&nbsp;), and for conversion of<br>other objects to strings. String concatenation is implemented<br>through the{@code StringBuilder}(or{@code StringBuffer})<br>class and its{@code append} method.<br>String conversions are implemented through the method<br>{@code toString}, defined by{@code Object} and<br>inherited by all classes in Java. For additional information on<br>string concatenation and conversion, see Gosling, Joy, and Steele,<br><i>The Java Language Specification</i>.<br><br><p> Unless otherwise noted, passing a <tt>null</tt> argument to a constructor<br>or method in this class will cause a{@link NullPointerException} to be<br>thrown.<br><br><p>A{@code String} represents a string in the UTF-16 format<br>in which <em>supplementary characters</em> are represented by <em>surrogate<br>pairs</em> (see the section <a href="Character.html#unicode">Unicode<br>Character Representations</a> in the{@code Character} class for<br>more information).<br>Index values refer to{@code char} code units, so a supplementary<br>character uses two positions in a{@code String}.<br><p>The{@code String} class provides methods for dealing with<br>Unicode code points (i.e., characters), in addition to those for<br>dealing with Unicode code units (i.e.,{@code char} values).] |

**Response Demo:**

```json

```




---
### 身份验证

> BASIC

**Path:** /authentication

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| principal | string | 认证主体:如用户名，手机号等 |
| certificate | string | 凭证:如密码，短信认证码等 |
| authenticationType | string | 认证类型：短信快捷认证、用户名密码认证、二维码认证等 |
| smsKey | string | 短信认证时需要传key到短信微服务校验 |

**Request Demo:**

```json
{
  "principal": "",
  "certificate": "",
  "authenticationType": "",
  "smsKey": ""
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| id | integer | 账号id |
| username | string | 用户名 |
| mobile | string | 手机号 |
| password | string | 密码 |
| salt | string | 盐 |

**Response Demo:**

```json
{
  "id": 0,
  "username": "",
  "mobile": "",
  "password": "",
  "salt": ""
}
```




---
### 登录

> BASIC

**Path:** /login

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| principal | string | 认证主体:如用户名，手机号等 |
| certificate | string | 凭证:如密码，短信认证码等 |
| authenticationType | string | 认证类型：短信快捷认证 type_message、用户名密码认证 type_user、二维码认证等 |
| smsKey | string | 短信认证时需要传key到短信微服务校验 |

**Request Demo:**

```json
{
  "principal": "",
  "certificate": "",
  "authenticationType": "",
  "smsKey": ""
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| id | integer | 账号id |
| username | string | 用户名 |
| mobile | string | 手机号 |
| tenants | array | 账号所属多个租户 |
| &ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─id | integer | 租户id |
| &ensp;&ensp;&ensp;&ensp;&#124;─name | string | 租户名称 |
| &ensp;&ensp;&ensp;&ensp;&#124;─tenantTypeCode | string | 租户类型编码 |
| &ensp;&ensp;&ensp;&ensp;&#124;─bundleCode | string | 套餐编码 |
| tenantAuthorizationInfoMap | object | 账号所属多个租户下的权限 |
| &ensp;&ensp;&#124;─0 | object |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─rolePrivilegeMap | object | 角色-权限列表 映射 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─key | array |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─ | string |  |
| resources | object | 资源 |
| &ensp;&ensp;&#124;─0 | array |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─applicationCode | string | 应用程序代码 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─applicationName | string | 应用程序名称 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─appRes | object | 按资源类型分包括菜单等资源信息 如  menu:JSONObject |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─key | object |  |

**Response Demo:**

```json
{
  "id": 0,
  "username": "",
  "mobile": "",
  "tenants": [
    {
      "id": 0,
      "name": "",
      "tenantTypeCode": "",
      "bundleCode": ""
    }
  ],
  "tenantAuthorizationInfoMap": {
    "0": {
      "rolePrivilegeMap": {
        "": [
          ""
        ]
      }
    }
  },
  "resources": {
    "0": [
      {
        "applicationCode": "",
        "applicationName": "",
        "appRes": {
          "": {}
        }
      }
    ]
  }
}
```




---
### 根据接入客户端获取应用

> BASIC

**Path:** /getApplicationDTOByClientId/{clientId}

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| clientId |  | 客户机id |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| id | integer | id |
| name | string | 应用名称 |
| code | string | 应用编码 |
| tenantId | integer | 应用所属租户 |

**Response Demo:**

```json
{
  "id": 0,
  "name": "",
  "code": "",
  "tenantId": 0
}
```







# sms-server

exported at 2023-02-07 21:42:34

## Project name(项目名称)：sms-backend

Project name(项目名称)：sms-backend
Package(包名): mao.sms_server.controller
Class(类名): SmsSendController
Author(作者）: mao
Author QQ：1296193245
GitHub：https://github.com/maomao124/
Date(创建日期)： 2023/1/3
Time(创建时间)： 21:01
Version(版本): 1.0
Description(描述)： 短信发送接口


---
### send

> BASIC

**Path:** /sms/simulation

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/x-www-form-urlencoded | YES |  |

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| date |  | YES |  |
| num |  | YES |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | boolean | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": false,
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```







# aggregate-pay-transaction-service

exported at 2023-02-07 21:42:34

## Project name(项目名称)：aggregate-pay

Project name(项目名称)：aggregate-pay
Package(包名): mao.aggregate_pay_transaction_service.controller
Class(类名): PageController
Author(作者）: mao
Author QQ：1296193245
GitHub：https://github.com/maomao124/
Date(创建日期)： 2023/1/30
Time(创建时间)： 15:14
Version(版本): 1.0
Description(描述)： 静态页面


---
### 支付页面

> BASIC

**Path:** /pay-page

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| key.key |  | NO |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
|  | string | [The{@code String} class represents character strings. All<br>string literals in Java programs, such as{@code "abc"}, are<br>implemented as instances of this class.<br><p><br>Strings are constant; their values cannot be changed after they<br>are created. String buffers support mutable strings.<br>Because String objects are immutable they can be shared. For example:<br><blockquote><pre><br>    String str = "abc";<br></pre></blockquote><p><br>is equivalent to:<br><blockquote><pre><br>    char data[] ={'a', 'b', 'c'};<br>    String str = new String(data);<br></pre></blockquote><p><br>Here are some more examples of how strings can be used:<br><blockquote><pre><br>    System.out.println("abc");<br>    String cde = "cde";<br>    System.out.println("abc" + cde);<br>    String c = "abc".substring(2,3);<br>    String d = cde.substring(1, 2);<br></pre></blockquote><br><p><br>The class{@code String} includes methods for examining<br>individual characters of the sequence, for comparing strings, for<br>searching strings, for extracting substrings, and for creating a<br>copy of a string with all characters translated to uppercase or to<br>lowercase. Case mapping is based on the Unicode Standard version<br>specified by the{@link java.lang.Character Character} class.<br><p><br>The Java language provides special support for the string<br>concatenation operator (&nbsp;+&nbsp;), and for conversion of<br>other objects to strings. String concatenation is implemented<br>through the{@code StringBuilder}(or{@code StringBuffer})<br>class and its{@code append} method.<br>String conversions are implemented through the method<br>{@code toString}, defined by{@code Object} and<br>inherited by all classes in Java. For additional information on<br>string concatenation and conversion, see Gosling, Joy, and Steele,<br><i>The Java Language Specification</i>.<br><br><p> Unless otherwise noted, passing a <tt>null</tt> argument to a constructor<br>or method in this class will cause a{@link NullPointerException} to be<br>thrown.<br><br><p>A{@code String} represents a string in the UTF-16 format<br>in which <em>supplementary characters</em> are represented by <em>surrogate<br>pairs</em> (see the section <a href="Character.html#unicode">Unicode<br>Character Representations</a> in the{@code Character} class for<br>more information).<br>Index values refer to{@code char} code units, so a supplementary<br>character uses two positions in a{@code String}.<br><p>The{@code String} class provides methods for dealing with<br>Unicode code points (i.e., characters), in addition to those for<br>dealing with Unicode code units (i.e.,{@code char} values).] |

**Response Demo:**

```json

```




---
### 错误页面

> BASIC

**Path:** /pay-error-page

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| key.key |  | NO |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
|  | string | [The{@code String} class represents character strings. All<br>string literals in Java programs, such as{@code "abc"}, are<br>implemented as instances of this class.<br><p><br>Strings are constant; their values cannot be changed after they<br>are created. String buffers support mutable strings.<br>Because String objects are immutable they can be shared. For example:<br><blockquote><pre><br>    String str = "abc";<br></pre></blockquote><p><br>is equivalent to:<br><blockquote><pre><br>    char data[] ={'a', 'b', 'c'};<br>    String str = new String(data);<br></pre></blockquote><p><br>Here are some more examples of how strings can be used:<br><blockquote><pre><br>    System.out.println("abc");<br>    String cde = "cde";<br>    System.out.println("abc" + cde);<br>    String c = "abc".substring(2,3);<br>    String d = cde.substring(1, 2);<br></pre></blockquote><br><p><br>The class{@code String} includes methods for examining<br>individual characters of the sequence, for comparing strings, for<br>searching strings, for extracting substrings, and for creating a<br>copy of a string with all characters translated to uppercase or to<br>lowercase. Case mapping is based on the Unicode Standard version<br>specified by the{@link java.lang.Character Character} class.<br><p><br>The Java language provides special support for the string<br>concatenation operator (&nbsp;+&nbsp;), and for conversion of<br>other objects to strings. String concatenation is implemented<br>through the{@code StringBuilder}(or{@code StringBuffer})<br>class and its{@code append} method.<br>String conversions are implemented through the method<br>{@code toString}, defined by{@code Object} and<br>inherited by all classes in Java. For additional information on<br>string concatenation and conversion, see Gosling, Joy, and Steele,<br><i>The Java Language Specification</i>.<br><br><p> Unless otherwise noted, passing a <tt>null</tt> argument to a constructor<br>or method in this class will cause a{@link NullPointerException} to be<br>thrown.<br><br><p>A{@code String} represents a string in the UTF-16 format<br>in which <em>supplementary characters</em> are represented by <em>surrogate<br>pairs</em> (see the section <a href="Character.html#unicode">Unicode<br>Character Representations</a> in the{@code Character} class for<br>more information).<br>Index values refer to{@code char} code units, so a supplementary<br>character uses two positions in a{@code String}.<br><p>The{@code String} class provides methods for dealing with<br>Unicode code points (i.e., characters), in addition to those for<br>dealing with Unicode code units (i.e.,{@code char} values).] |

**Response Demo:**

```json

```





## Project name(项目名称)：aggregate-pay

Project name(项目名称)：aggregate-pay
Package(包名): mao.aggregate_pay_transaction_service.controller
Class(类名): WxPayController
Author(作者）: mao
Author QQ：1296193245
GitHub：https://github.com/maomao124/
Date(创建日期)： 2023/1/28
Time(创建时间)： 14:17
Version(版本): 1.0
Description(描述)： 无


---
### 申请授权码

> BASIC

**Path:** /wxpay/getWXOAuth2Code

**Method:** GET

> REQUEST



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
|  | string | [The{@code String} class represents character strings. All<br>string literals in Java programs, such as{@code "abc"}, are<br>implemented as instances of this class.<br><p><br>Strings are constant; their values cannot be changed after they<br>are created. String buffers support mutable strings.<br>Because String objects are immutable they can be shared. For example:<br><blockquote><pre><br>    String str = "abc";<br></pre></blockquote><p><br>is equivalent to:<br><blockquote><pre><br>    char data[] ={'a', 'b', 'c'};<br>    String str = new String(data);<br></pre></blockquote><p><br>Here are some more examples of how strings can be used:<br><blockquote><pre><br>    System.out.println("abc");<br>    String cde = "cde";<br>    System.out.println("abc" + cde);<br>    String c = "abc".substring(2,3);<br>    String d = cde.substring(1, 2);<br></pre></blockquote><br><p><br>The class{@code String} includes methods for examining<br>individual characters of the sequence, for comparing strings, for<br>searching strings, for extracting substrings, and for creating a<br>copy of a string with all characters translated to uppercase or to<br>lowercase. Case mapping is based on the Unicode Standard version<br>specified by the{@link java.lang.Character Character} class.<br><p><br>The Java language provides special support for the string<br>concatenation operator (&nbsp;+&nbsp;), and for conversion of<br>other objects to strings. String concatenation is implemented<br>through the{@code StringBuilder}(or{@code StringBuffer})<br>class and its{@code append} method.<br>String conversions are implemented through the method<br>{@code toString}, defined by{@code Object} and<br>inherited by all classes in Java. For additional information on<br>string concatenation and conversion, see Gosling, Joy, and Steele,<br><i>The Java Language Specification</i>.<br><br><p> Unless otherwise noted, passing a <tt>null</tt> argument to a constructor<br>or method in this class will cause a{@link NullPointerException} to be<br>thrown.<br><br><p>A{@code String} represents a string in the UTF-16 format<br>in which <em>supplementary characters</em> are represented by <em>surrogate<br>pairs</em> (see the section <a href="Character.html#unicode">Unicode<br>Character Representations</a> in the{@code Character} class for<br>more information).<br>Index values refer to{@code char} code units, so a supplementary<br>character uses two positions in a{@code String}.<br><p>The{@code String} class provides methods for dealing with<br>Unicode code points (i.e., characters), in addition to those for<br>dealing with Unicode code units (i.e.,{@code char} values).] |

**Response Demo:**

```json

```




---
### 获取openid，注意：此接口必须要在公网能够访问到，至少要微信支付能够调用，内网穿透、公网IP+端口映射都行，我家用的是公网IP

> BASIC

**Path:** /wxpay/wx‐oauth‐code‐return‐test

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| code |  | YES | 代码 |
| state |  | YES | 状态 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
|  | string | [The{@code String} class represents character strings. All<br>string literals in Java programs, such as{@code "abc"}, are<br>implemented as instances of this class.<br><p><br>Strings are constant; their values cannot be changed after they<br>are created. String buffers support mutable strings.<br>Because String objects are immutable they can be shared. For example:<br><blockquote><pre><br>    String str = "abc";<br></pre></blockquote><p><br>is equivalent to:<br><blockquote><pre><br>    char data[] ={'a', 'b', 'c'};<br>    String str = new String(data);<br></pre></blockquote><p><br>Here are some more examples of how strings can be used:<br><blockquote><pre><br>    System.out.println("abc");<br>    String cde = "cde";<br>    System.out.println("abc" + cde);<br>    String c = "abc".substring(2,3);<br>    String d = cde.substring(1, 2);<br></pre></blockquote><br><p><br>The class{@code String} includes methods for examining<br>individual characters of the sequence, for comparing strings, for<br>searching strings, for extracting substrings, and for creating a<br>copy of a string with all characters translated to uppercase or to<br>lowercase. Case mapping is based on the Unicode Standard version<br>specified by the{@link java.lang.Character Character} class.<br><p><br>The Java language provides special support for the string<br>concatenation operator (&nbsp;+&nbsp;), and for conversion of<br>other objects to strings. String concatenation is implemented<br>through the{@code StringBuilder}(or{@code StringBuffer})<br>class and its{@code append} method.<br>String conversions are implemented through the method<br>{@code toString}, defined by{@code Object} and<br>inherited by all classes in Java. For additional information on<br>string concatenation and conversion, see Gosling, Joy, and Steele,<br><i>The Java Language Specification</i>.<br><br><p> Unless otherwise noted, passing a <tt>null</tt> argument to a constructor<br>or method in this class will cause a{@link NullPointerException} to be<br>thrown.<br><br><p>A{@code String} represents a string in the UTF-16 format<br>in which <em>supplementary characters</em> are represented by <em>surrogate<br>pairs</em> (see the section <a href="Character.html#unicode">Unicode<br>Character Representations</a> in the{@code Character} class for<br>more information).<br>Index values refer to{@code char} code units, so a supplementary<br>character uses two positions in a{@code String}.<br><p>The{@code String} class provides methods for dealing with<br>Unicode code points (i.e., characters), in addition to those for<br>dealing with Unicode code units (i.e.,{@code char} values).] |

**Response Demo:**

```json

```




---
### 微信jsapi下单接口

> BASIC

**Path:** /wxpay/wxjspay

**Method:** GET

> REQUEST



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| view | object |  |
| model | object |  |
| &ensp;&ensp;&#124;─key | object |  |
| status | string | CONTINUE :Continue 100<br>SWITCHING_PROTOCOLS :Switching Protocols 101<br>PROCESSING :Processing 102<br>CHECKPOINT :Checkpoint 103<br>OK :OK 200<br>CREATED :Created 201<br>ACCEPTED :Accepted 202<br>NON_AUTHORITATIVE_INFORMATION :Non-Authoritative Information 203<br>NO_CONTENT :No Content 204<br>RESET_CONTENT :Reset Content 205<br>PARTIAL_CONTENT :Partial Content 206<br>MULTI_STATUS :Multi-Status 207<br>ALREADY_REPORTED :Already Reported 208<br>IM_USED :IM Used 226<br>MULTIPLE_CHOICES :Multiple Choices 300<br>MOVED_PERMANENTLY :Moved Permanently 301<br>FOUND :Found 302<br>MOVED_TEMPORARILY :「已废弃」<br>「已废弃」<br>SEE_OTHER :See Other 303<br>NOT_MODIFIED :Not Modified 304<br>USE_PROXY :「已废弃」<br>「已废弃」<br>TEMPORARY_REDIRECT :Temporary Redirect 307<br>PERMANENT_REDIRECT :Permanent Redirect 308<br>BAD_REQUEST :Bad Request 400<br>UNAUTHORIZED :Unauthorized 401<br>PAYMENT_REQUIRED :Payment Required 402<br>FORBIDDEN :Forbidden 403<br>NOT_FOUND :Not Found 404<br>METHOD_NOT_ALLOWED :Method Not Allowed 405<br>NOT_ACCEPTABLE :Not Acceptable 406<br>PROXY_AUTHENTICATION_REQUIRED :Proxy Authentication Required 407<br>REQUEST_TIMEOUT :Request Timeout 408<br>CONFLICT :Conflict 409<br>GONE :Gone 410<br>LENGTH_REQUIRED :Length Required 411<br>PRECONDITION_FAILED :Precondition Failed 412<br>PAYLOAD_TOO_LARGE :Payload Too Large 413<br>REQUEST_ENTITY_TOO_LARGE :「已废弃」<br>「已废弃」<br>URI_TOO_LONG :URI Too Long 414<br>REQUEST_URI_TOO_LONG :「已废弃」<br>「已废弃」<br>UNSUPPORTED_MEDIA_TYPE :Unsupported Media Type 415<br>REQUESTED_RANGE_NOT_SATISFIABLE :Requested range not satisfiable 416<br>EXPECTATION_FAILED :Expectation Failed 417<br>I_AM_A_TEAPOT :I'm a teapot 418<br>INSUFFICIENT_SPACE_ON_RESOURCE :「已废弃」<br>「已废弃」<br>METHOD_FAILURE :「已废弃」<br>「已废弃」<br>DESTINATION_LOCKED :「已废弃」<br>「已废弃」<br>UNPROCESSABLE_ENTITY :Unprocessable Entity 422<br>LOCKED :Locked 423<br>FAILED_DEPENDENCY :Failed Dependency 424<br>TOO_EARLY :Too Early 425<br>UPGRADE_REQUIRED :Upgrade Required 426<br>PRECONDITION_REQUIRED :Precondition Required 428<br>TOO_MANY_REQUESTS :Too Many Requests 429<br>REQUEST_HEADER_FIELDS_TOO_LARGE :Request Header Fields Too Large 431<br>UNAVAILABLE_FOR_LEGAL_REASONS :Unavailable For Legal Reasons 451<br>INTERNAL_SERVER_ERROR :Internal Server Error 500<br>NOT_IMPLEMENTED :Not Implemented 501<br>BAD_GATEWAY :Bad Gateway 502<br>SERVICE_UNAVAILABLE :Service Unavailable 503<br>GATEWAY_TIMEOUT :Gateway Timeout 504<br>HTTP_VERSION_NOT_SUPPORTED :HTTP Version not supported 505<br>VARIANT_ALSO_NEGOTIATES :Variant Also Negotiates 506<br>INSUFFICIENT_STORAGE :Insufficient Storage 507<br>LOOP_DETECTED :Loop Detected 508<br>BANDWIDTH_LIMIT_EXCEEDED :Bandwidth Limit Exceeded 509<br>NOT_EXTENDED :Not Extended 510<br>NETWORK_AUTHENTICATION_REQUIRED :Network Authentication Required 511 |
| cleared | boolean |  |

**Response Demo:**

```json
{
  "view": {},
  "model": {
    "": {}
  },
  "status": "",
  "cleared": false
}
```





## Project name(项目名称)：aggregate-pay

Project name(项目名称)：aggregate-pay
Package(包名): mao.aggregate_pay_transaction_service.controller
Class(类名): PayChannelController
Author(作者）: mao
Author QQ：1296193245
GitHub：https://github.com/maomao124/
Date(创建日期)： 2023/1/15
Time(创建时间)： 21:58
Version(版本): 1.0
Description(描述)： 支付聚道controller


---
### 根据平台服务类型获取支付渠道列表

> BASIC

**Path:** /PayChannel/platformChannelCode/{platformChannelCode}

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| platformChannelCode |  | 平台渠道代码 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | array | 调用结果 |
| &ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─id | integer | id |
| &ensp;&ensp;&ensp;&ensp;&#124;─channelName | string | 支付渠道名称 |
| &ensp;&ensp;&ensp;&ensp;&#124;─channelCode | string | 支付渠道编码 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": [
    {
      "id": 0,
      "channelName": "",
      "channelCode": ""
    }
  ],
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```





## Project name(项目名称)：aggregate-pay

Project name(项目名称)：aggregate-pay
Package(包名): mao.aggregate_pay_transaction_service.controller
Class(类名): TransactionController
Author(作者）: mao
Author QQ：1296193245
GitHub：https://github.com/maomao124/
Date(创建日期)： 2023/1/29
Time(创建时间)： 14:43
Version(版本): 1.0
Description(描述)： 交易相关


---
### 生成门店二维码的url

> BASIC

**Path:** /transaction/createStoreQRCode

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| merchantId | integer | 商户id |
| appId | string | 应用程序id |
| storeId | integer | 门店id |
| subject | string | 商品标题 |
| body | string | 订单描述 |
| totalAmount | string | 总金额，单位是元 |

**Request Demo:**

```json
{
  "merchantId": 0,
  "appId": "",
  "storeId": 0,
  "subject": "",
  "body": "",
  "totalAmount": ""
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | string | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": "",
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```





## Project name(项目名称)：aggregate-pay

Project name(项目名称)：aggregate-pay
Package(包名): mao.aggregate_pay_transaction_service.controller
Class(类名): PayTestController
Author(作者）: mao
Author QQ：1296193245
GitHub：https://github.com/maomao124/
Date(创建日期)： 2023/1/27
Time(创建时间)： 21:12
Version(版本): 1.0
Description(描述)： 支付测试


---
### alipayTest

> BASIC

**Path:** /alipay/test

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| out_trade_no |  | YES |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | string | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": "",
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### alipayTest2

> BASIC

**Path:** /alipay/test2

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| out_trade_no |  | YES |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
|  | string |  |

**Response Demo:**

```json

```





## Project name(项目名称)：aggregate-pay

Project name(项目名称)：aggregate-pay
Package(包名): mao.aggregate_pay_transaction_service.controller
Class(类名): PayChannelParamController
Author(作者）: mao
Author QQ：1296193245
GitHub：https://github.com/maomao124/
Date(创建日期)： 2023/1/16
Time(创建时间)： 20:32
Version(版本): 1.0
Description(描述)： 原始的支付聚道参数Controller


---
### 保存支付通道参数

> BASIC

**Path:** /PayChannelParam

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| id | integer | id |
| appId | string | 应用程序id |
| platformChannelCode | string | 应用绑定的服务类型对应的code |
| channelName | string | 参数配置名称 |
| merchantId | integer | 商户id |
| payChannel | string | 原始支付渠道编码 |
| param | string | 参数 |
| appPlatformChannelId | integer | 应用绑定的服务类型Id |

**Request Demo:**

```json
{
  "id": 0,
  "appId": "",
  "platformChannelCode": "",
  "channelName": "",
  "merchantId": 0,
  "payChannel": "",
  "param": "",
  "appPlatformChannelId": 0
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | boolean | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": false,
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 获取指定应用指定服务类型下所包含的原始支付渠道参数列表

> BASIC

**Path:** /PayChannelParam/queryPayChannelParamByAppAndPlatform

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| appId |  | YES | 应用id |
| platformChannel |  | YES | 服务类型 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | array | 调用结果 |
| &ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─id | integer | id |
| &ensp;&ensp;&ensp;&ensp;&#124;─appId | string | 应用程序id |
| &ensp;&ensp;&ensp;&ensp;&#124;─platformChannelCode | string | 应用绑定的服务类型对应的code |
| &ensp;&ensp;&ensp;&ensp;&#124;─channelName | string | 参数配置名称 |
| &ensp;&ensp;&ensp;&ensp;&#124;─merchantId | integer | 商户id |
| &ensp;&ensp;&ensp;&ensp;&#124;─payChannel | string | 原始支付渠道编码 |
| &ensp;&ensp;&ensp;&ensp;&#124;─param | string | 参数 |
| &ensp;&ensp;&ensp;&ensp;&#124;─appPlatformChannelId | integer | 应用绑定的服务类型Id |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": [
    {
      "id": 0,
      "appId": "",
      "platformChannelCode": "",
      "channelName": "",
      "merchantId": 0,
      "payChannel": "",
      "param": "",
      "appPlatformChannelId": 0
    }
  ],
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 获取指定应用指定服务类型下所包含的某个原始支付参数

> BASIC

**Path:** /PayChannelParam/queryParamByAppPlatformAndPayChannel

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| appId |  | YES | 应用id |
| platformChannel |  | YES | 服务类型 |
| payChannel |  | YES | 支付渠道 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─id | integer | id |
| &ensp;&ensp;&#124;─appId | string | 应用程序id |
| &ensp;&ensp;&#124;─platformChannelCode | string | 应用绑定的服务类型对应的code |
| &ensp;&ensp;&#124;─channelName | string | 参数配置名称 |
| &ensp;&ensp;&#124;─merchantId | integer | 商户id |
| &ensp;&ensp;&#124;─payChannel | string | 原始支付渠道编码 |
| &ensp;&ensp;&#124;─param | string | 参数 |
| &ensp;&ensp;&#124;─appPlatformChannelId | integer | 应用绑定的服务类型Id |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "id": 0,
    "appId": "",
    "platformChannelCode": "",
    "channelName": "",
    "merchantId": 0,
    "payChannel": "",
    "param": "",
    "appPlatformChannelId": 0
  },
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```





## Project name(项目名称)：aggregate-pay

Project name(项目名称)：aggregate-pay
Package(包名): mao.aggregate_pay_transaction_service.controller
Class(类名): PayController
Author(作者）: mao
Author QQ：1296193245
GitHub：https://github.com/maomao124/
Date(创建日期)： 2023/1/30
Time(创建时间)： 15:19
Version(版本): 1.0
Description(描述)： 支付相关


---
### 解析ticket并获取支付页面

> BASIC

**Path:** /pay/pay-entry/{ticket}

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| ticket |  | ticket |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
|  | string | [The{@code String} class represents character strings. All<br>string literals in Java programs, such as{@code "abc"}, are<br>implemented as instances of this class.<br><p><br>Strings are constant; their values cannot be changed after they<br>are created. String buffers support mutable strings.<br>Because String objects are immutable they can be shared. For example:<br><blockquote><pre><br>    String str = "abc";<br></pre></blockquote><p><br>is equivalent to:<br><blockquote><pre><br>    char data[] ={'a', 'b', 'c'};<br>    String str = new String(data);<br></pre></blockquote><p><br>Here are some more examples of how strings can be used:<br><blockquote><pre><br>    System.out.println("abc");<br>    String cde = "cde";<br>    System.out.println("abc" + cde);<br>    String c = "abc".substring(2,3);<br>    String d = cde.substring(1, 2);<br></pre></blockquote><br><p><br>The class{@code String} includes methods for examining<br>individual characters of the sequence, for comparing strings, for<br>searching strings, for extracting substrings, and for creating a<br>copy of a string with all characters translated to uppercase or to<br>lowercase. Case mapping is based on the Unicode Standard version<br>specified by the{@link java.lang.Character Character} class.<br><p><br>The Java language provides special support for the string<br>concatenation operator (&nbsp;+&nbsp;), and for conversion of<br>other objects to strings. String concatenation is implemented<br>through the{@code StringBuilder}(or{@code StringBuffer})<br>class and its{@code append} method.<br>String conversions are implemented through the method<br>{@code toString}, defined by{@code Object} and<br>inherited by all classes in Java. For additional information on<br>string concatenation and conversion, see Gosling, Joy, and Steele,<br><i>The Java Language Specification</i>.<br><br><p> Unless otherwise noted, passing a <tt>null</tt> argument to a constructor<br>or method in this class will cause a{@link NullPointerException} to be<br>thrown.<br><br><p>A{@code String} represents a string in the UTF-16 format<br>in which <em>supplementary characters</em> are represented by <em>surrogate<br>pairs</em> (see the section <a href="Character.html#unicode">Unicode<br>Character Representations</a> in the{@code Character} class for<br>more information).<br>Index values refer to{@code char} code units, so a supplementary<br>character uses two positions in a{@code String}.<br><p>The{@code String} class provides methods for dealing with<br>Unicode code points (i.e., characters), in addition to those for<br>dealing with Unicode code units (i.e.,{@code char} values).] |

**Response Demo:**

```json

```




---
### createAlipayOrderForStore

> BASIC

**Path:** /pay/createAliPayOrder

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/x-www-form-urlencoded | YES |  |

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| appId |  | NO | 应用id |
| tradeNo |  | NO | 交易单号 |
| openId |  | NO | 微信openid |
| storeId |  | NO | 门店id |
| channel |  | NO | 服务类型 |
| body |  | NO | 订单描述 |
| subject |  | NO | 订单标题 |
| totalAmount |  | NO | 金额 |




---
### 微信授权码回调接口，供微信调用

> BASIC

**Path:** /pay/wx-oauth-code-return

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| code |  | YES | 微信授权码 |
| state |  | YES | 状态，微信会原封不动的返回 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
|  | string | [The{@code String} class represents character strings. All<br>string literals in Java programs, such as{@code "abc"}, are<br>implemented as instances of this class.<br><p><br>Strings are constant; their values cannot be changed after they<br>are created. String buffers support mutable strings.<br>Because String objects are immutable they can be shared. For example:<br><blockquote><pre><br>    String str = "abc";<br></pre></blockquote><p><br>is equivalent to:<br><blockquote><pre><br>    char data[] ={'a', 'b', 'c'};<br>    String str = new String(data);<br></pre></blockquote><p><br>Here are some more examples of how strings can be used:<br><blockquote><pre><br>    System.out.println("abc");<br>    String cde = "cde";<br>    System.out.println("abc" + cde);<br>    String c = "abc".substring(2,3);<br>    String d = cde.substring(1, 2);<br></pre></blockquote><br><p><br>The class{@code String} includes methods for examining<br>individual characters of the sequence, for comparing strings, for<br>searching strings, for extracting substrings, and for creating a<br>copy of a string with all characters translated to uppercase or to<br>lowercase. Case mapping is based on the Unicode Standard version<br>specified by the{@link java.lang.Character Character} class.<br><p><br>The Java language provides special support for the string<br>concatenation operator (&nbsp;+&nbsp;), and for conversion of<br>other objects to strings. String concatenation is implemented<br>through the{@code StringBuilder}(or{@code StringBuffer})<br>class and its{@code append} method.<br>String conversions are implemented through the method<br>{@code toString}, defined by{@code Object} and<br>inherited by all classes in Java. For additional information on<br>string concatenation and conversion, see Gosling, Joy, and Steele,<br><i>The Java Language Specification</i>.<br><br><p> Unless otherwise noted, passing a <tt>null</tt> argument to a constructor<br>or method in this class will cause a{@link NullPointerException} to be<br>thrown.<br><br><p>A{@code String} represents a string in the UTF-16 format<br>in which <em>supplementary characters</em> are represented by <em>surrogate<br>pairs</em> (see the section <a href="Character.html#unicode">Unicode<br>Character Representations</a> in the{@code Character} class for<br>more information).<br>Index values refer to{@code char} code units, so a supplementary<br>character uses two positions in a{@code String}.<br><p>The{@code String} class provides methods for dealing with<br>Unicode code points (i.e., characters), in addition to those for<br>dealing with Unicode code units (i.e.,{@code char} values).] |

**Response Demo:**

```json

```




---
### 微信门店下单付款

> BASIC

**Path:** /pay/wxjspay

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/x-www-form-urlencoded | YES |  |

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| appId |  | NO | 应用id |
| tradeNo |  | NO | 交易单号 |
| openId |  | NO | 微信openid |
| storeId |  | NO | 门店id |
| channel |  | NO | 服务类型 |
| body |  | NO | 订单描述 |
| subject |  | NO | 订单标题 |
| totalAmount |  | NO | 金额 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| view | object |  |
| model | object |  |
| &ensp;&ensp;&#124;─key | object |  |
| status | string | CONTINUE :Continue 100<br>SWITCHING_PROTOCOLS :Switching Protocols 101<br>PROCESSING :Processing 102<br>CHECKPOINT :Checkpoint 103<br>OK :OK 200<br>CREATED :Created 201<br>ACCEPTED :Accepted 202<br>NON_AUTHORITATIVE_INFORMATION :Non-Authoritative Information 203<br>NO_CONTENT :No Content 204<br>RESET_CONTENT :Reset Content 205<br>PARTIAL_CONTENT :Partial Content 206<br>MULTI_STATUS :Multi-Status 207<br>ALREADY_REPORTED :Already Reported 208<br>IM_USED :IM Used 226<br>MULTIPLE_CHOICES :Multiple Choices 300<br>MOVED_PERMANENTLY :Moved Permanently 301<br>FOUND :Found 302<br>MOVED_TEMPORARILY :「已废弃」<br>「已废弃」<br>SEE_OTHER :See Other 303<br>NOT_MODIFIED :Not Modified 304<br>USE_PROXY :「已废弃」<br>「已废弃」<br>TEMPORARY_REDIRECT :Temporary Redirect 307<br>PERMANENT_REDIRECT :Permanent Redirect 308<br>BAD_REQUEST :Bad Request 400<br>UNAUTHORIZED :Unauthorized 401<br>PAYMENT_REQUIRED :Payment Required 402<br>FORBIDDEN :Forbidden 403<br>NOT_FOUND :Not Found 404<br>METHOD_NOT_ALLOWED :Method Not Allowed 405<br>NOT_ACCEPTABLE :Not Acceptable 406<br>PROXY_AUTHENTICATION_REQUIRED :Proxy Authentication Required 407<br>REQUEST_TIMEOUT :Request Timeout 408<br>CONFLICT :Conflict 409<br>GONE :Gone 410<br>LENGTH_REQUIRED :Length Required 411<br>PRECONDITION_FAILED :Precondition Failed 412<br>PAYLOAD_TOO_LARGE :Payload Too Large 413<br>REQUEST_ENTITY_TOO_LARGE :「已废弃」<br>「已废弃」<br>URI_TOO_LONG :URI Too Long 414<br>REQUEST_URI_TOO_LONG :「已废弃」<br>「已废弃」<br>UNSUPPORTED_MEDIA_TYPE :Unsupported Media Type 415<br>REQUESTED_RANGE_NOT_SATISFIABLE :Requested range not satisfiable 416<br>EXPECTATION_FAILED :Expectation Failed 417<br>I_AM_A_TEAPOT :I'm a teapot 418<br>INSUFFICIENT_SPACE_ON_RESOURCE :「已废弃」<br>「已废弃」<br>METHOD_FAILURE :「已废弃」<br>「已废弃」<br>DESTINATION_LOCKED :「已废弃」<br>「已废弃」<br>UNPROCESSABLE_ENTITY :Unprocessable Entity 422<br>LOCKED :Locked 423<br>FAILED_DEPENDENCY :Failed Dependency 424<br>TOO_EARLY :Too Early 425<br>UPGRADE_REQUIRED :Upgrade Required 426<br>PRECONDITION_REQUIRED :Precondition Required 428<br>TOO_MANY_REQUESTS :Too Many Requests 429<br>REQUEST_HEADER_FIELDS_TOO_LARGE :Request Header Fields Too Large 431<br>UNAVAILABLE_FOR_LEGAL_REASONS :Unavailable For Legal Reasons 451<br>INTERNAL_SERVER_ERROR :Internal Server Error 500<br>NOT_IMPLEMENTED :Not Implemented 501<br>BAD_GATEWAY :Bad Gateway 502<br>SERVICE_UNAVAILABLE :Service Unavailable 503<br>GATEWAY_TIMEOUT :Gateway Timeout 504<br>HTTP_VERSION_NOT_SUPPORTED :HTTP Version not supported 505<br>VARIANT_ALSO_NEGOTIATES :Variant Also Negotiates 506<br>INSUFFICIENT_STORAGE :Insufficient Storage 507<br>LOOP_DETECTED :Loop Detected 508<br>BANDWIDTH_LIMIT_EXCEEDED :Bandwidth Limit Exceeded 509<br>NOT_EXTENDED :Not Extended 510<br>NETWORK_AUTHENTICATION_REQUIRED :Network Authentication Required 511 |
| cleared | boolean |  |

**Response Demo:**

```json
{
  "view": {},
  "model": {
    "": {}
  },
  "status": "",
  "cleared": false
}
```





## Project name(项目名称)：aggregate-pay

Project name(项目名称)：aggregate-pay
Package(包名): mao.aggregate_pay_transaction_service.controller
Class(类名): PlatformChannelController
Author(作者）: mao
Author QQ：1296193245
GitHub：https://github.com/maomao124/
Date(创建日期)： 2023/1/14
Time(创建时间)： 23:06
Version(版本): 1.0
Description(描述)： 服务类型


---
### 获取平台所有服务类型

> BASIC

**Path:** /PlatformChannel

**Method:** GET

> REQUEST



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | array | 调用结果 |
| &ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─id | integer | id |
| &ensp;&ensp;&ensp;&ensp;&#124;─channelName | string | 支付渠道名称 |
| &ensp;&ensp;&ensp;&ensp;&#124;─channelCode | string | 支付渠道编码 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": [
    {
      "id": 0,
      "channelName": "",
      "channelCode": ""
    }
  ],
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 为app绑定平台服务类型

> BASIC

**Path:** /PlatformChannel/bind

**Method:** PUT

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/x-www-form-urlencoded | YES |  |

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| appId |  | YES | 应用id |
| platformChannelCodes |  | YES | 平台服务类型 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | boolean | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": false,
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 查询应用是否已经绑定了某个服务类型

> BASIC

**Path:** /PlatformChannel/bind

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| appId |  | YES | 应用程序id |
| platformChannel |  | YES | 平台通道 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | boolean | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": false,
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```







# auth-server

exported at 2023-02-07 21:42:34

## Project name(项目名称)：authority

Project name(项目名称)：authority
Package(包名): mao.auth_server.controller.auth
Class(类名): RoleController
Author(作者）: mao
Author QQ：1296193245
GitHub：https://github.com/maomao124/
Date(创建日期)： 2022/11/12
Time(创建时间)： 20:29
Version(版本): 1.0
Description(描述)： 无


---
### 分页查询角色

> BASIC

**Path:** /role/page

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| name |  | NO | 角色名称 |
| code |  | NO | 角色编码 |
| describe |  | NO | 功能描述 |
| status | NO | NO | 状态 |
| readonly | NO | NO | 是否内置角色 |
| startCreateTime |  | NO | 数据权限类型<br>#DataScopeType{ALL:1,全部;THIS_LEVEL:2,本级;THIS_LEVEL_CHILDREN:3,本级以及子级;CUSTOMIZE:4,自定义;SELF:5,个人;} |
| endCreateTime |  | NO |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {},
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 查询角色

> BASIC

**Path:** /role/{id}

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| id |  |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─id | integer |  |
| &ensp;&ensp;&#124;─name | string | 角色名称 |
| &ensp;&ensp;&#124;─code | string | 角色编码 |
| &ensp;&ensp;&#124;─describe | string | 功能描述 |
| &ensp;&ensp;&#124;─status | boolean | 状态 |
| &ensp;&ensp;&#124;─readonly | boolean | 是否内置角色 |
| &ensp;&ensp;&#124;─orgList | array | 关联的组织id |
| &ensp;&ensp;&ensp;&ensp;&#124;─ | integer |  |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "id": 0,
    "name": "",
    "code": "",
    "describe": "",
    "status": false,
    "readonly": false,
    "orgList": [
      0
    ]
  },
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### check

> BASIC

**Path:** /role/check/{code}

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| code |  |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | boolean | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": false,
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 新增角色

> BASIC

**Path:** /role

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| name | string | 角色名称 |
| code | string | 角色编码 |
| describe | string | 功能描述 |
| status | boolean | 状态 |
| orgList | array | 关联的组织id |
| &ensp;&ensp;&#124;─ | integer |  |

**Request Demo:**

```json
{
  "name": "",
  "code": "",
  "describe": "",
  "status": false,
  "orgList": [
    0
  ]
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─name | string | 角色名称 |
| &ensp;&ensp;&#124;─code | string | 角色编码 |
| &ensp;&ensp;&#124;─describe | string | 功能描述 |
| &ensp;&ensp;&#124;─status | boolean | 状态 |
| &ensp;&ensp;&#124;─orgList | array | 关联的组织id |
| &ensp;&ensp;&ensp;&ensp;&#124;─ | integer |  |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "name": "",
    "code": "",
    "describe": "",
    "status": false,
    "orgList": [
      0
    ]
  },
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 修改角色

> BASIC

**Path:** /role

**Method:** PUT

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| id | integer |  |
| name | string | 角色名称 |
| code | string | 角色编码 |
| describe | string | 功能描述 |
| status | boolean | 状态 |
| orgList | array | 关联的组织id |
| &ensp;&ensp;&#124;─ | integer |  |

**Request Demo:**

```json
{
  "id": 0,
  "name": "",
  "code": "",
  "describe": "",
  "status": false,
  "orgList": [
    0
  ]
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─id | integer |  |
| &ensp;&ensp;&#124;─name | string | 角色名称 |
| &ensp;&ensp;&#124;─code | string | 角色编码 |
| &ensp;&ensp;&#124;─describe | string | 功能描述 |
| &ensp;&ensp;&#124;─status | boolean | 状态 |
| &ensp;&ensp;&#124;─orgList | array | 关联的组织id |
| &ensp;&ensp;&ensp;&ensp;&#124;─ | integer |  |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "id": 0,
    "name": "",
    "code": "",
    "describe": "",
    "status": false,
    "orgList": [
      0
    ]
  },
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 删除角色

> BASIC

**Path:** /role

**Method:** DELETE

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/x-www-form-urlencoded | YES |  |

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| ids[] |  | YES |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | boolean | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": false,
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 给用户分配角色

> BASIC

**Path:** /role/user

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| roleId | integer | 角色ID<br>#auth_role |
| userIdList | array | 用户ID |
| &ensp;&ensp;&#124;─ | integer |  |

**Request Demo:**

```json
{
  "roleId": 0,
  "userIdList": [
    0
  ]
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | boolean | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": false,
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 查询角色的用户

> BASIC

**Path:** /role/user/{roleId}

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| roleId |  |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | array | 调用结果 |
| &ensp;&ensp;&#124;─ | integer |  |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": [
    0
  ],
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 查询角色拥有的资源id

> BASIC

**Path:** /role/authority/{roleId}

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| roleId |  |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─menuIdList | array | 菜单ID<br>#auth_menu |
| &ensp;&ensp;&ensp;&ensp;&#124;─ | integer |  |
| &ensp;&ensp;&#124;─resourceIdList | array | 资源id<br>#auth_resource |
| &ensp;&ensp;&ensp;&ensp;&#124;─ | integer |  |
| &ensp;&ensp;&#124;─roleId | integer | 角色id<br>#auth_role |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "menuIdList": [
      0
    ],
    "resourceIdList": [
      0
    ],
    "roleId": 0
  },
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 给角色配置权限

> BASIC

**Path:** /role/authority

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| menuIdList | array | 菜单ID<br>#auth_menu |
| &ensp;&ensp;&#124;─ | integer |  |
| resourceIdList | array | 资源id<br>#auth_resource |
| &ensp;&ensp;&#124;─ | integer |  |
| roleId | integer | 角色id<br>#auth_role |

**Request Demo:**

```json
{
  "menuIdList": [
    0
  ],
  "resourceIdList": [
    0
  ],
  "roleId": 0
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | boolean | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": false,
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 根据角色编码查询用户ID

> BASIC

**Path:** /role/codes

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| codes |  | YES |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | array | 调用结果 |
| &ensp;&ensp;&#124;─ | integer |  |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": [
    0
  ],
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```





## Project name(项目名称)：authority

Project name(项目名称)：authority
Package(包名): mao.auth_server.controller.auth
Class(类名): LoginController
Author(作者）: mao
Author QQ：1296193245
GitHub：https://github.com/maomao124/
Date(创建日期)： 2022/11/10
Time(创建时间)： 19:50
Version(版本): 1.0
Description(描述)： 登录Controller


---
### captcha

> BASIC

**Path:** /anno/captcha

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| key |  | YES |  |




---
### 登录认证

> BASIC

**Path:** /anno/login

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| key | string | 验证码KEY |
| code | string | 验证码 |
| account | string | 账号 |
| password | string | 密码 |

**Request Demo:**

```json
{
  "key": "",
  "code": "",
  "account": "",
  "password": ""
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─user | object | 用户信息 |
| &ensp;&ensp;&ensp;&ensp;&#124;─id | integer |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─account | string | 账号 |
| &ensp;&ensp;&ensp;&ensp;&#124;─name | string | 姓名 |
| &ensp;&ensp;&ensp;&ensp;&#124;─orgId | integer | 组织ID<br>#core_org |
| &ensp;&ensp;&ensp;&ensp;&#124;─stationId | integer | 岗位ID<br>#core_station |
| &ensp;&ensp;&ensp;&ensp;&#124;─email | string | 邮箱 |
| &ensp;&ensp;&ensp;&ensp;&#124;─mobile | string | 手机 |
| &ensp;&ensp;&ensp;&ensp;&#124;─sex | string | 性别<br>#Sex{W:女;M:男;N:未知}<br>W :W="女"<br>M :M="男"<br>N :N="未知" |
| &ensp;&ensp;&ensp;&ensp;&#124;─status | boolean | 启用状态 1启用 0禁用 |
| &ensp;&ensp;&ensp;&ensp;&#124;─avatar | string | 照片 |
| &ensp;&ensp;&ensp;&ensp;&#124;─workDescribe | string | 工作描述<br>比如：  市长、管理员、局长等等   用于登陆展示 |
| &ensp;&ensp;&ensp;&ensp;&#124;─lastLoginTime | string | 最后登录时间 |
| &ensp;&ensp;&#124;─token | object | token令牌 |
| &ensp;&ensp;&ensp;&ensp;&#124;─token | string | token |
| &ensp;&ensp;&ensp;&ensp;&#124;─expire | integer | 有效时间：单位：秒 |
| &ensp;&ensp;&#124;─permissionsList | array | 权限列表 |
| &ensp;&ensp;&ensp;&ensp;&#124;─ | string |  |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "user": {
      "id": 0,
      "account": "",
      "name": "",
      "orgId": 0,
      "stationId": 0,
      "email": "",
      "mobile": "",
      "sex": "",
      "status": false,
      "avatar": "",
      "workDescribe": "",
      "lastLoginTime": ""
    },
    "token": {
      "token": "",
      "expire": 0
    },
    "permissionsList": [
      ""
    ]
  },
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 校验验证码是否正确

> BASIC

**Path:** /anno/check

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| key | string | 验证码KEY |
| code | string | 验证码 |
| account | string | 账号 |
| password | string | 密码 |

**Request Demo:**

```json
{
  "key": "",
  "code": "",
  "account": "",
  "password": ""
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
|  | boolean | boolean |

**Response Demo:**

```json
false
```





## Project name(项目名称)：authority

Project name(项目名称)：authority
Package(包名): mao.auth_server.controller.common
Class(类名): TestController
Author(作者）: mao
Author QQ：1296193245
GitHub：https://github.com/maomao124/
Date(创建日期)： 2022/11/12
Time(创建时间)： 12:31
Version(版本): 1.0
Description(描述)： 无


---
### ping

> BASIC

**Path:** /test/ping

**Method:** GET

> REQUEST



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | string | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": "",
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### test

> BASIC

**Path:** /test/test

**Method:** GET

> REQUEST



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
|  | boolean |  |

**Response Demo:**

```json
false
```





## Project name(项目名称)：authority

Project name(项目名称)：authority
Package(包名): mao.auth_server.controller.auth
Class(类名): UserController
Author(作者）: mao
Author QQ：1296193245
GitHub：https://github.com/maomao124/
Date(创建日期)： 2022/11/12
Time(创建时间)： 20:35
Version(版本): 1.0
Description(描述)： 无


---
### 分页查询用户

> BASIC

**Path:** /user/page

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| account |  | NO | 账号 |
| name |  | NO | 姓名 |
| orgId |  | NO | 组织ID<br>#core_org |
| stationId |  | NO | 岗位ID<br>#core_station |
| mobile |  | NO | 手机 |
| email |  | NO |  |
| sex |  | NO | 性别<br>#Sex{W:女;M:男}<br>W :W="女"<br>M :M="男"<br>N :N="未知" |
| status | NO | NO |  |
| isCanLogin | NO | NO | 是否可登陆 |
| photo |  | NO | 照片 |
| workDescribe |  | NO | 工作描述<br>比如：  市长、管理员、局长等等   用于登陆展示 |
| loginCount |  | NO | 登录次数<br>一直累计，记录了此账号总共登录次数 |
| startCreateTime |  | NO |  |
| endCreateTime |  | NO |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {},
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 查询用户

> BASIC

**Path:** /user/{id}

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| id |  | id |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─account | string | 账号 |
| &ensp;&ensp;&#124;─name | string | 姓名 |
| &ensp;&ensp;&#124;─orgId | integer | 组织ID<br>#core_org |
| &ensp;&ensp;&#124;─stationId | integer | 岗位ID<br>#core_station |
| &ensp;&ensp;&#124;─email | string | 邮箱 |
| &ensp;&ensp;&#124;─mobile | string | 手机 |
| &ensp;&ensp;&#124;─sex | string | 性别<br>#Sex{W:女;M:男;N:未知}<br>W :W="女"<br>M :M="男"<br>N :N="未知" |
| &ensp;&ensp;&#124;─status | boolean | 启用状态 1启用 0禁用 |
| &ensp;&ensp;&#124;─avatar | string | 头像 |
| &ensp;&ensp;&#124;─workDescribe | string | 工作描述<br>比如：  市长、管理员、局长等等   用于登陆展示 |
| &ensp;&ensp;&#124;─passwordErrorLastTime | string | 最后一次输错密码时间 |
| &ensp;&ensp;&#124;─passwordErrorNum | integer | 密码错误次数 |
| &ensp;&ensp;&#124;─passwordExpireTime | string | 密码过期时间 |
| &ensp;&ensp;&#124;─password | string | 密码 |
| &ensp;&ensp;&#124;─lastLoginTime | string | 最后登录时间 |
| &ensp;&ensp;&#124;─updateTime | string |  |
| &ensp;&ensp;&#124;─updateUser | integer |  |
| &ensp;&ensp;&#124;─id | integer |  |
| &ensp;&ensp;&#124;─createTime | string |  |
| &ensp;&ensp;&#124;─createUser | integer |  |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "account": "",
    "name": "",
    "orgId": 0,
    "stationId": 0,
    "email": "",
    "mobile": "",
    "sex": "",
    "status": false,
    "avatar": "",
    "workDescribe": "",
    "passwordErrorLastTime": "",
    "passwordErrorNum": 0,
    "passwordExpireTime": "",
    "password": "",
    "lastLoginTime": "",
    "updateTime": "",
    "updateUser": 0,
    "id": 0,
    "createTime": "",
    "createUser": 0
  },
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### findAllUserId

> BASIC

**Path:** /user/find

**Method:** GET

> REQUEST



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | array | 调用结果 |
| &ensp;&ensp;&#124;─ | integer |  |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": [
    0
  ],
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 新增用户

> BASIC

**Path:** /user

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| id | integer |  |
| account | string | 账号 |
| name | string | 姓名 |
| orgId | integer | 组织ID<br>#core_org |
| stationId | integer | 岗位ID<br>#core_station |
| email | string | 邮箱 |
| mobile | string | 手机 |
| sex | string | 性别<br>#Sex{W:女;M:男;N:未知}<br>W :W="女"<br>M :M="男"<br>N :N="未知" |
| status | boolean | 启用状态 1启用 0禁用 |
| avatar | string | 头像 |
| workDescribe | string | 工作描述<br>比如：  市长、管理员、局长等等   用于登陆展示 |
| password | string | 密码 |

**Request Demo:**

```json
{
  "id": 0,
  "account": "",
  "name": "",
  "orgId": 0,
  "stationId": 0,
  "email": "",
  "mobile": "",
  "sex": "",
  "status": false,
  "avatar": "",
  "workDescribe": "",
  "password": ""
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─account | string | 账号 |
| &ensp;&ensp;&#124;─name | string | 姓名 |
| &ensp;&ensp;&#124;─orgId | integer | 组织ID<br>#core_org |
| &ensp;&ensp;&#124;─stationId | integer | 岗位ID<br>#core_station |
| &ensp;&ensp;&#124;─email | string | 邮箱 |
| &ensp;&ensp;&#124;─mobile | string | 手机 |
| &ensp;&ensp;&#124;─sex | string | 性别<br>#Sex{W:女;M:男;N:未知}<br>W :W="女"<br>M :M="男"<br>N :N="未知" |
| &ensp;&ensp;&#124;─status | boolean | 启用状态 1启用 0禁用 |
| &ensp;&ensp;&#124;─avatar | string | 头像 |
| &ensp;&ensp;&#124;─workDescribe | string | 工作描述<br>比如：  市长、管理员、局长等等   用于登陆展示 |
| &ensp;&ensp;&#124;─passwordErrorLastTime | string | 最后一次输错密码时间 |
| &ensp;&ensp;&#124;─passwordErrorNum | integer | 密码错误次数 |
| &ensp;&ensp;&#124;─passwordExpireTime | string | 密码过期时间 |
| &ensp;&ensp;&#124;─password | string | 密码 |
| &ensp;&ensp;&#124;─lastLoginTime | string | 最后登录时间 |
| &ensp;&ensp;&#124;─updateTime | string |  |
| &ensp;&ensp;&#124;─updateUser | integer |  |
| &ensp;&ensp;&#124;─id | integer |  |
| &ensp;&ensp;&#124;─createTime | string |  |
| &ensp;&ensp;&#124;─createUser | integer |  |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "account": "",
    "name": "",
    "orgId": 0,
    "stationId": 0,
    "email": "",
    "mobile": "",
    "sex": "",
    "status": false,
    "avatar": "",
    "workDescribe": "",
    "passwordErrorLastTime": "",
    "passwordErrorNum": 0,
    "passwordExpireTime": "",
    "password": "",
    "lastLoginTime": "",
    "updateTime": "",
    "updateUser": 0,
    "id": 0,
    "createTime": "",
    "createUser": 0
  },
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 修改用户

> BASIC

**Path:** /user

**Method:** PUT

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| id | integer |  |
| account | string | 账号 |
| name | string | 姓名 |
| orgId | integer | 组织ID<br>#core_org |
| stationId | integer | 岗位ID<br>#core_station |
| email | string | 邮箱 |
| mobile | string | 手机 |
| sex | string | 性别<br>#Sex{W:女;M:男;N:未知}<br>W :W="女"<br>M :M="男"<br>N :N="未知" |
| status | boolean | 启用状态 1启用 0禁用 |
| avatar | string | 头像 |
| workDescribe | string | 工作描述<br>比如：  市长、管理员、局长等等   用于登陆展示 |

**Request Demo:**

```json
{
  "id": 0,
  "account": "",
  "name": "",
  "orgId": 0,
  "stationId": 0,
  "email": "",
  "mobile": "",
  "sex": "",
  "status": false,
  "avatar": "",
  "workDescribe": ""
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─account | string | 账号 |
| &ensp;&ensp;&#124;─name | string | 姓名 |
| &ensp;&ensp;&#124;─orgId | integer | 组织ID<br>#core_org |
| &ensp;&ensp;&#124;─stationId | integer | 岗位ID<br>#core_station |
| &ensp;&ensp;&#124;─email | string | 邮箱 |
| &ensp;&ensp;&#124;─mobile | string | 手机 |
| &ensp;&ensp;&#124;─sex | string | 性别<br>#Sex{W:女;M:男;N:未知}<br>W :W="女"<br>M :M="男"<br>N :N="未知" |
| &ensp;&ensp;&#124;─status | boolean | 启用状态 1启用 0禁用 |
| &ensp;&ensp;&#124;─avatar | string | 头像 |
| &ensp;&ensp;&#124;─workDescribe | string | 工作描述<br>比如：  市长、管理员、局长等等   用于登陆展示 |
| &ensp;&ensp;&#124;─passwordErrorLastTime | string | 最后一次输错密码时间 |
| &ensp;&ensp;&#124;─passwordErrorNum | integer | 密码错误次数 |
| &ensp;&ensp;&#124;─passwordExpireTime | string | 密码过期时间 |
| &ensp;&ensp;&#124;─password | string | 密码 |
| &ensp;&ensp;&#124;─lastLoginTime | string | 最后登录时间 |
| &ensp;&ensp;&#124;─updateTime | string |  |
| &ensp;&ensp;&#124;─updateUser | integer |  |
| &ensp;&ensp;&#124;─id | integer |  |
| &ensp;&ensp;&#124;─createTime | string |  |
| &ensp;&ensp;&#124;─createUser | integer |  |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "account": "",
    "name": "",
    "orgId": 0,
    "stationId": 0,
    "email": "",
    "mobile": "",
    "sex": "",
    "status": false,
    "avatar": "",
    "workDescribe": "",
    "passwordErrorLastTime": "",
    "passwordErrorNum": 0,
    "passwordExpireTime": "",
    "password": "",
    "lastLoginTime": "",
    "updateTime": "",
    "updateUser": 0,
    "id": 0,
    "createTime": "",
    "createUser": 0
  },
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 修改头像

> BASIC

**Path:** /user/avatar

**Method:** PUT

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| id | integer |  |
| avatar | string | 头像 |

**Request Demo:**

```json
{
  "id": 0,
  "avatar": ""
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─account | string | 账号 |
| &ensp;&ensp;&#124;─name | string | 姓名 |
| &ensp;&ensp;&#124;─orgId | integer | 组织ID<br>#core_org |
| &ensp;&ensp;&#124;─stationId | integer | 岗位ID<br>#core_station |
| &ensp;&ensp;&#124;─email | string | 邮箱 |
| &ensp;&ensp;&#124;─mobile | string | 手机 |
| &ensp;&ensp;&#124;─sex | string | 性别<br>#Sex{W:女;M:男;N:未知}<br>W :W="女"<br>M :M="男"<br>N :N="未知" |
| &ensp;&ensp;&#124;─status | boolean | 启用状态 1启用 0禁用 |
| &ensp;&ensp;&#124;─avatar | string | 头像 |
| &ensp;&ensp;&#124;─workDescribe | string | 工作描述<br>比如：  市长、管理员、局长等等   用于登陆展示 |
| &ensp;&ensp;&#124;─passwordErrorLastTime | string | 最后一次输错密码时间 |
| &ensp;&ensp;&#124;─passwordErrorNum | integer | 密码错误次数 |
| &ensp;&ensp;&#124;─passwordExpireTime | string | 密码过期时间 |
| &ensp;&ensp;&#124;─password | string | 密码 |
| &ensp;&ensp;&#124;─lastLoginTime | string | 最后登录时间 |
| &ensp;&ensp;&#124;─updateTime | string |  |
| &ensp;&ensp;&#124;─updateUser | integer |  |
| &ensp;&ensp;&#124;─id | integer |  |
| &ensp;&ensp;&#124;─createTime | string |  |
| &ensp;&ensp;&#124;─createUser | integer |  |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "account": "",
    "name": "",
    "orgId": 0,
    "stationId": 0,
    "email": "",
    "mobile": "",
    "sex": "",
    "status": false,
    "avatar": "",
    "workDescribe": "",
    "passwordErrorLastTime": "",
    "passwordErrorNum": 0,
    "passwordExpireTime": "",
    "password": "",
    "lastLoginTime": "",
    "updateTime": "",
    "updateUser": 0,
    "id": 0,
    "createTime": "",
    "createUser": 0
  },
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 修改密码

> BASIC

**Path:** /user/password

**Method:** PUT

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| id | integer |  |
| oldPassword | string | 密码 |
| password | string | 密码 |
| confirmPassword | string | 密码 |

**Request Demo:**

```json
{
  "id": 0,
  "oldPassword": "",
  "password": "",
  "confirmPassword": ""
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | boolean | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": false,
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 重置密码

> BASIC

**Path:** /user/reset

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| ids[] |  | YES | id |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | boolean | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": false,
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 删除用户

> BASIC

**Path:** /user

**Method:** DELETE

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/x-www-form-urlencoded | YES |  |

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| ids[] |  | YES | id |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | boolean | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": false,
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 单体查询用户

> BASIC

**Path:** /user/anno/id/{id}

**Method:** POST

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| id |  | id |

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| full | boolean | 是否查询SysUser对象所有信息，true则通过rpc接口查询 |
| roles | boolean | 是否只查询角色信息，true则通过rpc接口查询 |
| org | boolean | 是否只查询组织信息，true则通过rpc接口查询 |
| station | boolean | 是否只查询岗位信息，true则通过rpc接口查询 |

**Request Demo:**

```json
{
  "full": false,
  "roles": false,
  "org": false,
  "station": false
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─id | integer | id |
| &ensp;&ensp;&#124;─account | string | 账号 |
| &ensp;&ensp;&#124;─name | string | 姓名 |
| &ensp;&ensp;&#124;─orgId | integer | 组织ID<br>#pd_core_org |
| &ensp;&ensp;&#124;─stationId | integer | 岗位ID<br>#pd_core_station |
| &ensp;&ensp;&#124;─mobile | string | 手机<br>启用条件： LoginUser.isFull = true \|\| LoginUser.isUser = true |
| &ensp;&ensp;&#124;─photo | string | 照片<br>启用条件： LoginUser.isFull = true \|\| LoginUser.isUser = true |
| &ensp;&ensp;&#124;─workDescribe | string | 工作描述<br>比如：  市长、管理员、局长等等   用于登陆展示<br>启用条件： LoginUser.isFull = true \|\| LoginUser.isUser = true |
| &ensp;&ensp;&#124;─loginCount | integer | 登录次数<br>一直累计，记录了此账号总共登录次数<br>启用条件： LoginUser.isFull = true \|\| LoginUser.isUser = true |
| &ensp;&ensp;&#124;─roles | array | 当前登录用户的角色编码<br>启用条件： LoginUser.isFull = true \|\| LoginUser.isRole = true |
| &ensp;&ensp;&ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─id | integer | id |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─name | string | 角色名称 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─code | string | 角色编码 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─describe | string | 功能描述 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─isEnable | boolean | 是否启用 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─isReadonly | boolean | 是否只读角色 |
| &ensp;&ensp;&#124;─org | object | 当前登录用户的组织架构<br>启用条件： LoginUser.isFull = true \|\| LoginUser.isOrg = true |
| &ensp;&ensp;&ensp;&ensp;&#124;─id | integer | id |
| &ensp;&ensp;&ensp;&ensp;&#124;─name | string | 名称 |
| &ensp;&ensp;&ensp;&ensp;&#124;─abbreviation | string | 简称 |
| &ensp;&ensp;&ensp;&ensp;&#124;─parentId | integer | 父ID |
| &ensp;&ensp;&ensp;&ensp;&#124;─sortValue | integer | 排序 |
| &ensp;&ensp;&ensp;&ensp;&#124;─status | boolean | 状态 |
| &ensp;&ensp;&ensp;&ensp;&#124;─describe | string | 描述 |
| &ensp;&ensp;&#124;─station | object | 当前登录用户的 岗位<br>启用条件： LoginUser.isFull = true \|\| LoginUser.isStation = true |
| &ensp;&ensp;&ensp;&ensp;&#124;─id | integer | id |
| &ensp;&ensp;&ensp;&ensp;&#124;─name | string | 名称 |
| &ensp;&ensp;&ensp;&ensp;&#124;─orgId | integer | 组织ID<br>#pd_core_org |
| &ensp;&ensp;&ensp;&ensp;&#124;─sortValue | integer | 排序 |
| &ensp;&ensp;&ensp;&ensp;&#124;─status | boolean | 状态 |
| &ensp;&ensp;&ensp;&ensp;&#124;─describe | string | 描述 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "id": 0,
    "account": "",
    "name": "",
    "orgId": 0,
    "stationId": 0,
    "mobile": "",
    "photo": "",
    "workDescribe": "",
    "loginCount": 0,
    "roles": [
      {
        "id": 0,
        "name": "",
        "code": "",
        "describe": "",
        "isEnable": false,
        "isReadonly": false
      }
    ],
    "org": {
      "id": 0,
      "name": "",
      "abbreviation": "",
      "parentId": 0,
      "sortValue": 0,
      "status": false,
      "describe": ""
    },
    "station": {
      "id": 0,
      "name": "",
      "orgId": 0,
      "sortValue": 0,
      "status": false,
      "describe": ""
    }
  },
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 查询角色的已关联用户

> BASIC

**Path:** /user/role/{roleId}

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| roleId |  | 角色id |

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| keyword |  | NO | 账号account或名称name |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─idList | array |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─ | integer |  |
| &ensp;&ensp;&#124;─userList | array |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─account | string | 账号 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─name | string | 姓名 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─orgId | integer | 组织ID<br>#core_org |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─stationId | integer | 岗位ID<br>#core_station |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─email | string | 邮箱 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─mobile | string | 手机 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─sex | string | 性别<br>#Sex{W:女;M:男;N:未知}<br>W :W="女"<br>M :M="男"<br>N :N="未知" |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─status | boolean | 启用状态 1启用 0禁用 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─avatar | string | 头像 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─workDescribe | string | 工作描述<br>比如：  市长、管理员、局长等等   用于登陆展示 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─passwordErrorLastTime | string | 最后一次输错密码时间 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─passwordErrorNum | integer | 密码错误次数 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─passwordExpireTime | string | 密码过期时间 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─password | string | 密码 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─lastLoginTime | string | 最后登录时间 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─updateTime | string |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─updateUser | integer |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─id | integer |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─createTime | string |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─createUser | integer |  |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "idList": [
      0
    ],
    "userList": [
      {
        "account": "",
        "name": "",
        "orgId": 0,
        "stationId": 0,
        "email": "",
        "mobile": "",
        "sex": "",
        "status": false,
        "avatar": "",
        "workDescribe": "",
        "passwordErrorLastTime": "",
        "passwordErrorNum": 0,
        "passwordExpireTime": "",
        "password": "",
        "lastLoginTime": "",
        "updateTime": "",
        "updateUser": 0,
        "id": 0,
        "createTime": "",
        "createUser": 0
      }
    ]
  },
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```





## Project name(项目名称)：authority

Project name(项目名称)：authority
Package(包名): mao.auth_server.controller.core
Class(类名): OrgController
Author(作者）: mao
Author QQ：1296193245
GitHub：https://github.com/maomao124/
Date(创建日期)： 2022/11/12
Time(创建时间)： 13:43
Version(版本): 1.0
Description(描述)： 无


---
### 分页查询组织

> BASIC

**Path:** /org/page

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| name |  | YES | 名称 |
| abbreviation |  | NO | 简称 |
| parentId |  | NO | 父ID |
| treePath |  | NO | 树结构 |
| sortValue |  | NO | 排序 |
| status | NO | NO | 状态 |
| describe |  | NO | 描述 |
| updateTime |  | NO |  |
| updateUser |  | NO |  |
| id |  | YES |  |
| createTime |  | NO |  |
| createUser |  | NO |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {},
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 查询组织

> BASIC

**Path:** /org/{id}

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| id |  |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─name | string | 名称 |
| &ensp;&ensp;&#124;─abbreviation | string | 简称 |
| &ensp;&ensp;&#124;─parentId | integer | 父ID |
| &ensp;&ensp;&#124;─treePath | string | 树结构 |
| &ensp;&ensp;&#124;─sortValue | integer | 排序 |
| &ensp;&ensp;&#124;─status | boolean | 状态 |
| &ensp;&ensp;&#124;─describe | string | 描述 |
| &ensp;&ensp;&#124;─updateTime | string |  |
| &ensp;&ensp;&#124;─updateUser | integer |  |
| &ensp;&ensp;&#124;─id | integer |  |
| &ensp;&ensp;&#124;─createTime | string |  |
| &ensp;&ensp;&#124;─createUser | integer |  |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "name": "",
    "abbreviation": "",
    "parentId": 0,
    "treePath": "",
    "sortValue": 0,
    "status": false,
    "describe": "",
    "updateTime": "",
    "updateUser": 0,
    "id": 0,
    "createTime": "",
    "createUser": 0
  },
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 新增组织

> BASIC

**Path:** /org

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| name | string | 名称 |
| abbreviation | string | 简称 |
| parentId | integer | 父ID |
| sortValue | integer | 排序 |
| status | boolean | 状态 |
| describe | string | 描述 |

**Request Demo:**

```json
{
  "name": "",
  "abbreviation": "",
  "parentId": 0,
  "sortValue": 0,
  "status": false,
  "describe": ""
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─name | string | 名称 |
| &ensp;&ensp;&#124;─abbreviation | string | 简称 |
| &ensp;&ensp;&#124;─parentId | integer | 父ID |
| &ensp;&ensp;&#124;─treePath | string | 树结构 |
| &ensp;&ensp;&#124;─sortValue | integer | 排序 |
| &ensp;&ensp;&#124;─status | boolean | 状态 |
| &ensp;&ensp;&#124;─describe | string | 描述 |
| &ensp;&ensp;&#124;─updateTime | string |  |
| &ensp;&ensp;&#124;─updateUser | integer |  |
| &ensp;&ensp;&#124;─id | integer |  |
| &ensp;&ensp;&#124;─createTime | string |  |
| &ensp;&ensp;&#124;─createUser | integer |  |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "name": "",
    "abbreviation": "",
    "parentId": 0,
    "treePath": "",
    "sortValue": 0,
    "status": false,
    "describe": "",
    "updateTime": "",
    "updateUser": 0,
    "id": 0,
    "createTime": "",
    "createUser": 0
  },
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 修改组织

> BASIC

**Path:** /org

**Method:** PUT

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| id | integer |  |
| name | string | 名称 |
| abbreviation | string | 简称 |
| parentId | integer | 父ID |
| sortValue | integer | 排序 |
| status | boolean | 状态 |
| describe | string | 描述 |

**Request Demo:**

```json
{
  "id": 0,
  "name": "",
  "abbreviation": "",
  "parentId": 0,
  "sortValue": 0,
  "status": false,
  "describe": ""
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─name | string | 名称 |
| &ensp;&ensp;&#124;─abbreviation | string | 简称 |
| &ensp;&ensp;&#124;─parentId | integer | 父ID |
| &ensp;&ensp;&#124;─treePath | string | 树结构 |
| &ensp;&ensp;&#124;─sortValue | integer | 排序 |
| &ensp;&ensp;&#124;─status | boolean | 状态 |
| &ensp;&ensp;&#124;─describe | string | 描述 |
| &ensp;&ensp;&#124;─updateTime | string |  |
| &ensp;&ensp;&#124;─updateUser | integer |  |
| &ensp;&ensp;&#124;─id | integer |  |
| &ensp;&ensp;&#124;─createTime | string |  |
| &ensp;&ensp;&#124;─createUser | integer |  |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "name": "",
    "abbreviation": "",
    "parentId": 0,
    "treePath": "",
    "sortValue": 0,
    "status": false,
    "describe": "",
    "updateTime": "",
    "updateUser": 0,
    "id": 0,
    "createTime": "",
    "createUser": 0
  },
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 删除组织

> BASIC

**Path:** /org

**Method:** DELETE

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/x-www-form-urlencoded | YES |  |

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| ids[] |  | YES |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | boolean | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": false,
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 查询系统所有的组织树

> BASIC

**Path:** /org/tree

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| name |  | NO |  |
| status | NO | NO |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | array | 调用结果 |
| &ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─children | array |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─children | array |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─label | string |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─name | string | 名称 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─abbreviation | string | 简称 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─parentId | integer | 父ID |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─treePath | string | 树结构 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─sortValue | integer | 排序 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─status | boolean | 状态 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─describe | string | 描述 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─updateTime | string |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─updateUser | integer |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─id | integer |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─createTime | string |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─createUser | integer |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─label | string |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─name | string | 名称 |
| &ensp;&ensp;&ensp;&ensp;&#124;─abbreviation | string | 简称 |
| &ensp;&ensp;&ensp;&ensp;&#124;─parentId | integer | 父ID |
| &ensp;&ensp;&ensp;&ensp;&#124;─treePath | string | 树结构 |
| &ensp;&ensp;&ensp;&ensp;&#124;─sortValue | integer | 排序 |
| &ensp;&ensp;&ensp;&ensp;&#124;─status | boolean | 状态 |
| &ensp;&ensp;&ensp;&ensp;&#124;─describe | string | 描述 |
| &ensp;&ensp;&ensp;&ensp;&#124;─updateTime | string |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─updateUser | integer |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─id | integer |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─createTime | string |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─createUser | integer |  |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": [
    {
      "children": [
        {
          "children": [],
          "label": "",
          "name": "",
          "abbreviation": "",
          "parentId": 0,
          "treePath": "",
          "sortValue": 0,
          "status": false,
          "describe": "",
          "updateTime": "",
          "updateUser": 0,
          "id": 0,
          "createTime": "",
          "createUser": 0
        }
      ],
      "label": "",
      "name": "",
      "abbreviation": "",
      "parentId": 0,
      "treePath": "",
      "sortValue": 0,
      "status": false,
      "describe": "",
      "updateTime": "",
      "updateUser": 0,
      "id": 0,
      "createTime": "",
      "createUser": 0
    }
  ],
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```





## Project name(项目名称)：authority

Project name(项目名称)：authority
Package(包名): mao.auth_server.controller.core
Class(类名): StationController
Author(作者）: mao
Author QQ：1296193245
GitHub：https://github.com/maomao124/
Date(创建日期)： 2022/11/12
Time(创建时间)： 19:42
Version(版本): 1.0
Description(描述)： 无


---
### 分页查询岗位

> BASIC

**Path:** /station/page

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| name |  | NO | 名称 |
| orgId |  | NO | 组织ID<br>#core_org |
| status | NO | NO | 状态 |
| describe |  | NO | 描述 |
| startCreateTime |  | NO |  |
| endCreateTime |  | NO |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {},
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 根据id查询岗位

> BASIC

**Path:** /station/{id}

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| id |  |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─name | string | 名称 |
| &ensp;&ensp;&#124;─orgId | integer | 组织ID<br>#core_org |
| &ensp;&ensp;&#124;─status | boolean | 状态 |
| &ensp;&ensp;&#124;─describe | string | 描述 |
| &ensp;&ensp;&#124;─updateTime | string |  |
| &ensp;&ensp;&#124;─updateUser | integer |  |
| &ensp;&ensp;&#124;─id | integer |  |
| &ensp;&ensp;&#124;─createTime | string |  |
| &ensp;&ensp;&#124;─createUser | integer |  |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "name": "",
    "orgId": 0,
    "status": false,
    "describe": "",
    "updateTime": "",
    "updateUser": 0,
    "id": 0,
    "createTime": "",
    "createUser": 0
  },
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 新增岗位

> BASIC

**Path:** /station

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| name | string | 名称 |
| orgId | integer | 组织ID<br>#core_org |
| status | boolean | 状态 |
| describe | string | 描述 |

**Request Demo:**

```json
{
  "name": "",
  "orgId": 0,
  "status": false,
  "describe": ""
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─name | string | 名称 |
| &ensp;&ensp;&#124;─orgId | integer | 组织ID<br>#core_org |
| &ensp;&ensp;&#124;─status | boolean | 状态 |
| &ensp;&ensp;&#124;─describe | string | 描述 |
| &ensp;&ensp;&#124;─updateTime | string |  |
| &ensp;&ensp;&#124;─updateUser | integer |  |
| &ensp;&ensp;&#124;─id | integer |  |
| &ensp;&ensp;&#124;─createTime | string |  |
| &ensp;&ensp;&#124;─createUser | integer |  |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "name": "",
    "orgId": 0,
    "status": false,
    "describe": "",
    "updateTime": "",
    "updateUser": 0,
    "id": 0,
    "createTime": "",
    "createUser": 0
  },
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 修改岗位

> BASIC

**Path:** /station

**Method:** PUT

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| id | integer |  |
| name | string | 名称 |
| orgId | integer | 组织ID<br>#core_org |
| status | boolean | 状态 |
| describe | string | 描述 |

**Request Demo:**

```json
{
  "id": 0,
  "name": "",
  "orgId": 0,
  "status": false,
  "describe": ""
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─name | string | 名称 |
| &ensp;&ensp;&#124;─orgId | integer | 组织ID<br>#core_org |
| &ensp;&ensp;&#124;─status | boolean | 状态 |
| &ensp;&ensp;&#124;─describe | string | 描述 |
| &ensp;&ensp;&#124;─updateTime | string |  |
| &ensp;&ensp;&#124;─updateUser | integer |  |
| &ensp;&ensp;&#124;─id | integer |  |
| &ensp;&ensp;&#124;─createTime | string |  |
| &ensp;&ensp;&#124;─createUser | integer |  |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "name": "",
    "orgId": 0,
    "status": false,
    "describe": "",
    "updateTime": "",
    "updateUser": 0,
    "id": 0,
    "createTime": "",
    "createUser": 0
  },
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 删除岗位

> BASIC

**Path:** /station

**Method:** DELETE

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/x-www-form-urlencoded | YES |  |

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| ids[] |  | YES |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | boolean | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": false,
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```





## Project name(项目名称)：authority

Project name(项目名称)：authority
Package(包名): mao.auth_server.controller.common
Class(类名): OptLogController
Author(作者）: mao
Author QQ：1296193245
GitHub：https://github.com/maomao124/
Date(创建日期)： 2022/11/12
Time(创建时间)： 13:33
Version(版本): 1.0
Description(描述)： 无


---
### 分页查询系统操作日志

> BASIC

**Path:** /optLog/page

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| requestIp |  | NO | 操作IP |
| type |  | NO | 日志类型<br>#LogType{OPT:操作类型;EX:异常类型}<br>OPT :OPT="操作类型"<br>EX :EX="异常类型" |
| userName |  | NO | 操作人 |
| description |  | NO | 操作描述 |
| classPath |  | NO | 类路径 |
| actionMethod |  | NO | 请求方法 |
| requestUri |  | NO | 请求地址 |
| httpMethod |  | NO | 请求类型<br>#HttpMethod{GET:GET请求;POST:POST请求;PUT:PUT请求;DELETE:DELETE请求;PATCH:PATCH请求;TRACE:TRACE请求;HEAD:HEAD请求;OPTIONS:OPTIONS请求;}<br>GET :GET:GET<br>POST :POST:POST<br>PUT :PUT:PUT<br>DELETE :DELETE:DELETE<br>PATCH :PATCH:PATCH<br>TRACE :TRACE:TRACE<br>HEAD :HEAD:HEAD<br>OPTIONS :OPTIONS:OPTIONS |
| params |  | NO | 请求参数 |
| result |  | NO | 返回值 |
| exDesc |  | NO | 异常详情信息 |
| exDetail |  | NO | 异常描述 |
| startTime |  | NO | 开始时间 |
| finishTime |  | NO | 完成时间 |
| consumingTime |  | NO | 消耗时间 |
| ua |  | NO | 浏览器 |
| id |  | YES |  |
| createTime |  | NO |  |
| createUser |  | NO |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {},
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 查询系统操作日志

> BASIC

**Path:** /optLog/{id}

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| id |  |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─requestIp | string | 操作IP |
| &ensp;&ensp;&#124;─type | string | 日志类型<br>#LogType{OPT:操作类型;EX:异常类型}<br>OPT :OPT="操作类型"<br>EX :EX="异常类型" |
| &ensp;&ensp;&#124;─userName | string | 操作人 |
| &ensp;&ensp;&#124;─description | string | 操作描述 |
| &ensp;&ensp;&#124;─classPath | string | 类路径 |
| &ensp;&ensp;&#124;─actionMethod | string | 请求方法 |
| &ensp;&ensp;&#124;─requestUri | string | 请求地址 |
| &ensp;&ensp;&#124;─httpMethod | string | 请求类型<br>#HttpMethod{GET:GET请求;POST:POST请求;PUT:PUT请求;DELETE:DELETE请求;PATCH:PATCH请求;TRACE:TRACE请求;HEAD:HEAD请求;OPTIONS:OPTIONS请求;}<br>GET :GET:GET<br>POST :POST:POST<br>PUT :PUT:PUT<br>DELETE :DELETE:DELETE<br>PATCH :PATCH:PATCH<br>TRACE :TRACE:TRACE<br>HEAD :HEAD:HEAD<br>OPTIONS :OPTIONS:OPTIONS |
| &ensp;&ensp;&#124;─params | string | 请求参数 |
| &ensp;&ensp;&#124;─result | string | 返回值 |
| &ensp;&ensp;&#124;─exDesc | string | 异常详情信息 |
| &ensp;&ensp;&#124;─exDetail | string | 异常描述 |
| &ensp;&ensp;&#124;─startTime | string | 开始时间 |
| &ensp;&ensp;&#124;─finishTime | string | 完成时间 |
| &ensp;&ensp;&#124;─consumingTime | integer | 消耗时间 |
| &ensp;&ensp;&#124;─ua | string | 浏览器 |
| &ensp;&ensp;&#124;─id | integer |  |
| &ensp;&ensp;&#124;─createTime | string |  |
| &ensp;&ensp;&#124;─createUser | integer |  |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "requestIp": "",
    "type": "",
    "userName": "",
    "description": "",
    "classPath": "",
    "actionMethod": "",
    "requestUri": "",
    "httpMethod": "",
    "params": "",
    "result": "",
    "exDesc": "",
    "exDetail": "",
    "startTime": "",
    "finishTime": "",
    "consumingTime": 0,
    "ua": "",
    "id": 0,
    "createTime": "",
    "createUser": 0
  },
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 删除系统操作日志

> BASIC

**Path:** /optLog

**Method:** DELETE

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/x-www-form-urlencoded | YES |  |

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| ids[] |  | YES |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | boolean | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": false,
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```





## Project name(项目名称)：authority

Project name(项目名称)：authority
Package(包名): mao.auth_server.controller.auth
Class(类名): RoleAuthorityController
Author(作者）: mao
Author QQ：1296193245
GitHub：https://github.com/maomao124/
Date(创建日期)： 2022/11/12
Time(创建时间)： 20:28
Version(版本): 1.0
Description(描述)： 无


---
### 查询指定角色关联的菜单和资源

> BASIC

**Path:** /roleAuthority/{roleId}

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| roleId |  |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | array | 调用结果 |
| &ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─authorityId | integer | 资源id<br>#auth_resource<br>#auth_menu |
| &ensp;&ensp;&ensp;&ensp;&#124;─authorityType | string | 权限类型<br>#AuthorizeType{MENU:菜单;RESOURCE:资源;}<br>MENU :MENU="菜单"<br>RESOURCE :RESOURCE="资源" |
| &ensp;&ensp;&ensp;&ensp;&#124;─roleId | integer | 角色id<br>#auth_role |
| &ensp;&ensp;&ensp;&ensp;&#124;─id | integer |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─createTime | string |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─createUser | integer |  |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": [
    {
      "authorityId": 0,
      "authorityType": "",
      "roleId": 0,
      "id": 0,
      "createTime": "",
      "createUser": 0
    }
  ],
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```





## Project name(项目名称)：authority

Project name(项目名称)：authority
Package(包名): mao.auth_server.controller.common
Class(类名): DashboardController
Author(作者）: mao
Author QQ：1296193245
GitHub：https://github.com/maomao124/
Date(创建日期)： 2022/11/12
Time(创建时间)： 13:40
Version(版本): 1.0
Description(描述)： 无


---
### 最近10天访问记录

> BASIC

**Path:** /dashboard/visit

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| id |  | NO | id |
| account |  | NO | 账号 |
| name |  | NO | 姓名 |
| orgId |  | NO | 组织ID<br>#pd_core_org |
| stationId |  | NO | 岗位ID<br>#pd_core_station |
| mobile |  | NO | 手机<br>启用条件： LoginUser.isFull = true \|\| LoginUser.isUser = true |
| photo |  | NO | 照片<br>启用条件： LoginUser.isFull = true \|\| LoginUser.isUser = true |
| workDescribe |  | NO | 工作描述<br>比如：  市长、管理员、局长等等   用于登陆展示<br>启用条件： LoginUser.isFull = true \|\| LoginUser.isUser = true |
| loginCount |  | NO | 登录次数<br>一直累计，记录了此账号总共登录次数<br>启用条件： LoginUser.isFull = true \|\| LoginUser.isUser = true |
| roles[0].id |  | NO | id |
| roles[0].name |  | NO | 角色名称 |
| roles[0].code |  | NO | 角色编码 |
| roles[0].describe |  | NO | 功能描述 |
| roles[0].isEnable | NO | NO | 是否启用 |
| roles[0].isReadonly | NO | NO | 是否只读角色 |
| org.id |  | NO | id |
| org.name |  | NO | 名称 |
| org.abbreviation |  | NO | 简称 |
| org.parentId |  | NO | 父ID |
| org.sortValue |  | NO | 排序 |
| org.status | NO | NO | 状态 |
| org.describe |  | NO | 描述 |
| station.id |  | NO | id |
| station.name |  | NO | 名称 |
| station.orgId |  | NO | 组织ID<br>#pd_core_org |
| station.sortValue |  | NO | 排序 |
| station.status | NO | NO | 状态 |
| station.describe |  | NO | 描述 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─key | object |  |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "": {}
  },
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 生成id

> BASIC

**Path:** /common/generateId

**Method:** GET

> REQUEST



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | integer | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": 0,
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```





## Project name(项目名称)：authority

Project name(项目名称)：authority
Package(包名): mao.auth_server.controller.common
Class(类名): LoginLogController
Author(作者）: mao
Author QQ：1296193245
GitHub：https://github.com/maomao124/
Date(创建日期)： 2022/11/12
Time(创建时间)： 13:37
Version(版本): 1.0
Description(描述)： 无


---
### 分页查询登录日志

> BASIC

**Path:** /loginLog/page

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| requestIp |  | NO | 操作IP |
| userId |  | NO | 登录人ID |
| userName |  | NO | 登录人姓名 |
| account |  | NO | 登录人账号 |
| description |  | NO | 登录描述 |
| loginDate |  | NO | 登录时间 |
| ua |  | NO | 浏览器请求头 |
| browser |  | NO | 浏览器名称 |
| browserVersion |  | NO | 浏览器版本 |
| operatingSystem |  | NO | 操作系统 |
| location |  | NO | 登录地点 |
| id |  | YES |  |
| createTime |  | NO |  |
| createUser |  | NO |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {},
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 查询登录日志

> BASIC

**Path:** /loginLog/{id}

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| id |  |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─requestIp | string | 操作IP |
| &ensp;&ensp;&#124;─userId | integer | 登录人ID |
| &ensp;&ensp;&#124;─userName | string | 登录人姓名 |
| &ensp;&ensp;&#124;─account | string | 登录人账号 |
| &ensp;&ensp;&#124;─description | string | 登录描述 |
| &ensp;&ensp;&#124;─loginDate | string | 登录时间 |
| &ensp;&ensp;&#124;─ua | string | 浏览器请求头 |
| &ensp;&ensp;&#124;─browser | string | 浏览器名称 |
| &ensp;&ensp;&#124;─browserVersion | string | 浏览器版本 |
| &ensp;&ensp;&#124;─operatingSystem | string | 操作系统 |
| &ensp;&ensp;&#124;─location | string | 登录地点 |
| &ensp;&ensp;&#124;─id | integer |  |
| &ensp;&ensp;&#124;─createTime | string |  |
| &ensp;&ensp;&#124;─createUser | integer |  |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "requestIp": "",
    "userId": 0,
    "userName": "",
    "account": "",
    "description": "",
    "loginDate": "",
    "ua": "",
    "browser": "",
    "browserVersion": "",
    "operatingSystem": "",
    "location": "",
    "id": 0,
    "createTime": "",
    "createUser": 0
  },
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 新增登录日志

> BASIC

**Path:** /loginLog/anno/login/{account}

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| account |  |  |

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| description | 登陆成功 | NO |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─requestIp | string | 操作IP |
| &ensp;&ensp;&#124;─userId | integer | 登录人ID |
| &ensp;&ensp;&#124;─userName | string | 登录人姓名 |
| &ensp;&ensp;&#124;─account | string | 登录人账号 |
| &ensp;&ensp;&#124;─description | string | 登录描述 |
| &ensp;&ensp;&#124;─loginDate | string | 登录时间 |
| &ensp;&ensp;&#124;─ua | string | 浏览器请求头 |
| &ensp;&ensp;&#124;─browser | string | 浏览器名称 |
| &ensp;&ensp;&#124;─browserVersion | string | 浏览器版本 |
| &ensp;&ensp;&#124;─operatingSystem | string | 操作系统 |
| &ensp;&ensp;&#124;─location | string | 登录地点 |
| &ensp;&ensp;&#124;─id | integer |  |
| &ensp;&ensp;&#124;─createTime | string |  |
| &ensp;&ensp;&#124;─createUser | integer |  |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "requestIp": "",
    "userId": 0,
    "userName": "",
    "account": "",
    "description": "",
    "loginDate": "",
    "ua": "",
    "browser": "",
    "browserVersion": "",
    "operatingSystem": "",
    "location": "",
    "id": 0,
    "createTime": "",
    "createUser": 0
  },
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 删除登录日志

> BASIC

**Path:** /loginLog

**Method:** DELETE

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/x-www-form-urlencoded | YES |  |

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| ids[] |  | YES |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | boolean | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": false,
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```





## Project name(项目名称)：authority

Project name(项目名称)：authority
Package(包名): mao.auth_server.controller.auth
Class(类名): MenuController
Author(作者）: mao
Author QQ：1296193245
GitHub：https://github.com/maomao124/
Date(创建日期)： 2022/11/12
Time(创建时间)： 20:09
Version(版本): 1.0
Description(描述)： 无


---
### 分页查询菜单

> BASIC

**Path:** /menu/page

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| name |  | YES | 菜单名称 |
| describe |  | NO | 功能描述 |
| isPublic | NO | NO | 是否公开菜单<br>就是无需分配就可以访问的。所有人可见 |
| path |  | NO | 对应路由path |
| component |  | NO | 对应路由组件component |
| isEnable | NO | NO | 是否启用 |
| sortValue |  | NO | 排序 |
| icon |  | NO | 菜单图标 |
| group |  | NO | 菜单分组 |
| parentId |  | NO | 父级菜单id |
| updateTime |  | NO |  |
| updateUser |  | NO |  |
| id |  | YES |  |
| createTime |  | NO |  |
| createUser |  | NO |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {},
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 查询菜单

> BASIC

**Path:** /menu/{id}

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| id |  |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─name | string | 菜单名称 |
| &ensp;&ensp;&#124;─describe | string | 功能描述 |
| &ensp;&ensp;&#124;─isPublic | boolean | 是否公开菜单<br>就是无需分配就可以访问的。所有人可见 |
| &ensp;&ensp;&#124;─path | string | 对应路由path |
| &ensp;&ensp;&#124;─component | string | 对应路由组件component |
| &ensp;&ensp;&#124;─isEnable | boolean | 是否启用 |
| &ensp;&ensp;&#124;─sortValue | integer | 排序 |
| &ensp;&ensp;&#124;─icon | string | 菜单图标 |
| &ensp;&ensp;&#124;─group | string | 菜单分组 |
| &ensp;&ensp;&#124;─parentId | integer | 父级菜单id |
| &ensp;&ensp;&#124;─updateTime | string |  |
| &ensp;&ensp;&#124;─updateUser | integer |  |
| &ensp;&ensp;&#124;─id | integer |  |
| &ensp;&ensp;&#124;─createTime | string |  |
| &ensp;&ensp;&#124;─createUser | integer |  |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "name": "",
    "describe": "",
    "isPublic": false,
    "path": "",
    "component": "",
    "isEnable": false,
    "sortValue": 0,
    "icon": "",
    "group": "",
    "parentId": 0,
    "updateTime": "",
    "updateUser": 0,
    "id": 0,
    "createTime": "",
    "createUser": 0
  },
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 新增菜单

> BASIC

**Path:** /menu

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| name | string | 菜单名称 |
| describe | string | 功能描述 |
| isPublic | boolean | 是否公开菜单<br>就是无需分配就可以访问的。所有人可见 |
| path | string | 对应路由path |
| component | string | 对应路由组件component |
| isEnable | boolean | 是否启用 |
| sortValue | integer | 排序 |
| icon | string | 菜单图标 |
| group | string | 菜单分组 |
| parentId | integer | 父级菜单id |

**Request Demo:**

```json
{
  "name": "",
  "describe": "",
  "isPublic": false,
  "path": "",
  "component": "",
  "isEnable": false,
  "sortValue": 0,
  "icon": "",
  "group": "",
  "parentId": 0
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─name | string | 菜单名称 |
| &ensp;&ensp;&#124;─describe | string | 功能描述 |
| &ensp;&ensp;&#124;─isPublic | boolean | 是否公开菜单<br>就是无需分配就可以访问的。所有人可见 |
| &ensp;&ensp;&#124;─path | string | 对应路由path |
| &ensp;&ensp;&#124;─component | string | 对应路由组件component |
| &ensp;&ensp;&#124;─isEnable | boolean | 是否启用 |
| &ensp;&ensp;&#124;─sortValue | integer | 排序 |
| &ensp;&ensp;&#124;─icon | string | 菜单图标 |
| &ensp;&ensp;&#124;─group | string | 菜单分组 |
| &ensp;&ensp;&#124;─parentId | integer | 父级菜单id |
| &ensp;&ensp;&#124;─updateTime | string |  |
| &ensp;&ensp;&#124;─updateUser | integer |  |
| &ensp;&ensp;&#124;─id | integer |  |
| &ensp;&ensp;&#124;─createTime | string |  |
| &ensp;&ensp;&#124;─createUser | integer |  |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "name": "",
    "describe": "",
    "isPublic": false,
    "path": "",
    "component": "",
    "isEnable": false,
    "sortValue": 0,
    "icon": "",
    "group": "",
    "parentId": 0,
    "updateTime": "",
    "updateUser": 0,
    "id": 0,
    "createTime": "",
    "createUser": 0
  },
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 修改菜单

> BASIC

**Path:** /menu

**Method:** PUT

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| id | integer |  |
| name | string | 菜单名称 |
| describe | string | 功能描述 |
| isPublic | boolean | 是否公开菜单<br>就是无需分配就可以访问的。所有人可见 |
| path | string | 对应路由path |
| component | string | 对应路由组件component |
| isEnable | boolean | 是否启用 |
| sortValue | integer | 排序 |
| icon | string | 菜单图标 |
| group | string | 菜单分组 |
| parentId | integer | 父级菜单id |

**Request Demo:**

```json
{
  "id": 0,
  "name": "",
  "describe": "",
  "isPublic": false,
  "path": "",
  "component": "",
  "isEnable": false,
  "sortValue": 0,
  "icon": "",
  "group": "",
  "parentId": 0
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─name | string | 菜单名称 |
| &ensp;&ensp;&#124;─describe | string | 功能描述 |
| &ensp;&ensp;&#124;─isPublic | boolean | 是否公开菜单<br>就是无需分配就可以访问的。所有人可见 |
| &ensp;&ensp;&#124;─path | string | 对应路由path |
| &ensp;&ensp;&#124;─component | string | 对应路由组件component |
| &ensp;&ensp;&#124;─isEnable | boolean | 是否启用 |
| &ensp;&ensp;&#124;─sortValue | integer | 排序 |
| &ensp;&ensp;&#124;─icon | string | 菜单图标 |
| &ensp;&ensp;&#124;─group | string | 菜单分组 |
| &ensp;&ensp;&#124;─parentId | integer | 父级菜单id |
| &ensp;&ensp;&#124;─updateTime | string |  |
| &ensp;&ensp;&#124;─updateUser | integer |  |
| &ensp;&ensp;&#124;─id | integer |  |
| &ensp;&ensp;&#124;─createTime | string |  |
| &ensp;&ensp;&#124;─createUser | integer |  |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "name": "",
    "describe": "",
    "isPublic": false,
    "path": "",
    "component": "",
    "isEnable": false,
    "sortValue": 0,
    "icon": "",
    "group": "",
    "parentId": 0,
    "updateTime": "",
    "updateUser": 0,
    "id": 0,
    "createTime": "",
    "createUser": 0
  },
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 删除菜单

> BASIC

**Path:** /menu

**Method:** DELETE

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/x-www-form-urlencoded | YES |  |

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| ids[] |  | YES |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | boolean | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": false,
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 查询用户可用的所有资源

> BASIC

**Path:** /menu

**Method:** GET

**Desc:**

 「已废弃」

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| group |  | NO | 菜单分组 |
| userId |  | NO | 指定用户id |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | array | 调用结果 |
| &ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─children | array |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─children | array |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─label | string | 标签 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─name | string | 菜单名称 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─describe | string | 功能描述 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─isPublic | boolean | 是否公开菜单<br>就是无需分配就可以访问的。所有人可见 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─path | string | 对应路由path |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─component | string | 对应路由组件component |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─isEnable | boolean | 是否启用 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─sortValue | integer | 排序 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─icon | string | 菜单图标 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─group | string | 菜单分组 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─parentId | integer | 父级菜单id |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─updateTime | string |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─updateUser | integer |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─id | integer |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─createTime | string |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─createUser | integer |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─label | string | 标签 |
| &ensp;&ensp;&ensp;&ensp;&#124;─name | string | 菜单名称 |
| &ensp;&ensp;&ensp;&ensp;&#124;─describe | string | 功能描述 |
| &ensp;&ensp;&ensp;&ensp;&#124;─isPublic | boolean | 是否公开菜单<br>就是无需分配就可以访问的。所有人可见 |
| &ensp;&ensp;&ensp;&ensp;&#124;─path | string | 对应路由path |
| &ensp;&ensp;&ensp;&ensp;&#124;─component | string | 对应路由组件component |
| &ensp;&ensp;&ensp;&ensp;&#124;─isEnable | boolean | 是否启用 |
| &ensp;&ensp;&ensp;&ensp;&#124;─sortValue | integer | 排序 |
| &ensp;&ensp;&ensp;&ensp;&#124;─icon | string | 菜单图标 |
| &ensp;&ensp;&ensp;&ensp;&#124;─group | string | 菜单分组 |
| &ensp;&ensp;&ensp;&ensp;&#124;─parentId | integer | 父级菜单id |
| &ensp;&ensp;&ensp;&ensp;&#124;─updateTime | string |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─updateUser | integer |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─id | integer |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─createTime | string |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─createUser | integer |  |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": [
    {
      "children": [
        {
          "children": [],
          "label": "",
          "name": "",
          "describe": "",
          "isPublic": false,
          "path": "",
          "component": "",
          "isEnable": false,
          "sortValue": 0,
          "icon": "",
          "group": "",
          "parentId": 0,
          "updateTime": "",
          "updateUser": 0,
          "id": 0,
          "createTime": "",
          "createUser": 0
        }
      ],
      "label": "",
      "name": "",
      "describe": "",
      "isPublic": false,
      "path": "",
      "component": "",
      "isEnable": false,
      "sortValue": 0,
      "icon": "",
      "group": "",
      "parentId": 0,
      "updateTime": "",
      "updateUser": 0,
      "id": 0,
      "createTime": "",
      "createUser": 0
    }
  ],
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 查询用户可用的所有菜单路由树

> BASIC

**Path:** /menu/router

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| group |  | NO | 组 |
| userId |  | NO | 用户id |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | array | 调用结果 |
| &ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─path | string |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─name | string |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─component | string | @ApiModelProperty(value = "功能描述") |
| &ensp;&ensp;&ensp;&ensp;&#124;─redirect | string |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─meta | object |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─title | string | 标题 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─icon | string | 图标 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─breadcrumb | boolean | 面包屑 |
| &ensp;&ensp;&ensp;&ensp;&#124;─hidden | boolean |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─alwaysShow | boolean |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─children | array |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─path | string |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─name | string |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─component | string | @ApiModelProperty(value = "功能描述") |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─redirect | string |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─meta | object |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─title | string | 标题 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─icon | string | 图标 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─breadcrumb | boolean | 面包屑 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─hidden | boolean |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─alwaysShow | boolean |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─children | array |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─ | object |  |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": [
    {
      "path": "",
      "name": "",
      "component": "",
      "redirect": "",
      "meta": {
        "title": "",
        "icon": "",
        "breadcrumb": false
      },
      "hidden": false,
      "alwaysShow": false,
      "children": [
        {
          "path": "",
          "name": "",
          "component": "",
          "redirect": "",
          "meta": {
            "title": "",
            "icon": "",
            "breadcrumb": false
          },
          "hidden": false,
          "alwaysShow": false,
          "children": []
        }
      ]
    }
  ],
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### adminRouter

> BASIC

**Path:** /menu/admin/router

**Method:** GET

> REQUEST



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | array | 调用结果 |
| &ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─path | string |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─name | string |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─component | string | @ApiModelProperty(value = "功能描述") |
| &ensp;&ensp;&ensp;&ensp;&#124;─redirect | string |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─meta | object |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─title | string | 标题 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─icon | string | 图标 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─breadcrumb | boolean | 面包屑 |
| &ensp;&ensp;&ensp;&ensp;&#124;─hidden | boolean |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─alwaysShow | boolean |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─children | array |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─path | string |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─name | string |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─component | string | @ApiModelProperty(value = "功能描述") |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─redirect | string |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─meta | object |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─title | string | 标题 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─icon | string | 图标 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─breadcrumb | boolean | 面包屑 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─hidden | boolean |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─alwaysShow | boolean |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─children | array |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─ | object |  |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": [
    {
      "path": "",
      "name": "",
      "component": "",
      "redirect": "",
      "meta": {
        "title": "",
        "icon": "",
        "breadcrumb": false
      },
      "hidden": false,
      "alwaysShow": false,
      "children": [
        {
          "path": "",
          "name": "",
          "component": "",
          "redirect": "",
          "meta": {
            "title": "",
            "icon": "",
            "breadcrumb": false
          },
          "hidden": false,
          "alwaysShow": false,
          "children": []
        }
      ]
    }
  ],
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 查询系统中所有的的菜单树结构， 不用缓存，因为该接口很少会使用，就算使用，也会管理员维护菜单时使用

> BASIC

**Path:** /menu/tree

**Method:** GET

> REQUEST



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | array | 调用结果 |
| &ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─children | array |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─children | array |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─label | string | 标签 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─name | string | 菜单名称 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─describe | string | 功能描述 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─isPublic | boolean | 是否公开菜单<br>就是无需分配就可以访问的。所有人可见 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─path | string | 对应路由path |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─component | string | 对应路由组件component |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─isEnable | boolean | 是否启用 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─sortValue | integer | 排序 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─icon | string | 菜单图标 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─group | string | 菜单分组 |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─parentId | integer | 父级菜单id |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─updateTime | string |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─updateUser | integer |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─id | integer |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─createTime | string |  |
| &ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&ensp;&#124;─createUser | integer |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─label | string | 标签 |
| &ensp;&ensp;&ensp;&ensp;&#124;─name | string | 菜单名称 |
| &ensp;&ensp;&ensp;&ensp;&#124;─describe | string | 功能描述 |
| &ensp;&ensp;&ensp;&ensp;&#124;─isPublic | boolean | 是否公开菜单<br>就是无需分配就可以访问的。所有人可见 |
| &ensp;&ensp;&ensp;&ensp;&#124;─path | string | 对应路由path |
| &ensp;&ensp;&ensp;&ensp;&#124;─component | string | 对应路由组件component |
| &ensp;&ensp;&ensp;&ensp;&#124;─isEnable | boolean | 是否启用 |
| &ensp;&ensp;&ensp;&ensp;&#124;─sortValue | integer | 排序 |
| &ensp;&ensp;&ensp;&ensp;&#124;─icon | string | 菜单图标 |
| &ensp;&ensp;&ensp;&ensp;&#124;─group | string | 菜单分组 |
| &ensp;&ensp;&ensp;&ensp;&#124;─parentId | integer | 父级菜单id |
| &ensp;&ensp;&ensp;&ensp;&#124;─updateTime | string |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─updateUser | integer |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─id | integer |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─createTime | string |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─createUser | integer |  |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": [
    {
      "children": [
        {
          "children": [],
          "label": "",
          "name": "",
          "describe": "",
          "isPublic": false,
          "path": "",
          "component": "",
          "isEnable": false,
          "sortValue": 0,
          "icon": "",
          "group": "",
          "parentId": 0,
          "updateTime": "",
          "updateUser": 0,
          "id": 0,
          "createTime": "",
          "createUser": 0
        }
      ],
      "label": "",
      "name": "",
      "describe": "",
      "isPublic": false,
      "path": "",
      "component": "",
      "isEnable": false,
      "sortValue": 0,
      "icon": "",
      "group": "",
      "parentId": 0,
      "updateTime": "",
      "updateUser": 0,
      "id": 0,
      "createTime": "",
      "createUser": 0
    }
  ],
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```





## Project name(项目名称)：authority

Project name(项目名称)：authority
Package(包名): mao.auth_server.controller.auth
Class(类名): ResourceController
Author(作者）: mao
Author QQ：1296193245
GitHub：https://github.com/maomao124/
Date(创建日期)： 2022/11/12
Time(创建时间)： 20:25
Version(版本): 1.0
Description(描述)： 无


---
### 分页查询资源

> BASIC

**Path:** /resource/page

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| code |  | NO | 资源编码<br>规则：<br>链接：<br>数据列：<br>按钮： |
| name |  | YES | 接口名称 |
| menuId |  | NO | 菜单ID<br>#auth_menu |
| describe |  | NO | 接口描述 |
| method |  | NO |  |
| url |  | NO |  |
| updateTime |  | NO |  |
| updateUser |  | NO |  |
| id |  | YES |  |
| createTime |  | NO |  |
| createUser |  | NO |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {},
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 查询资源

> BASIC

**Path:** /resource/{id}

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| id |  |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─code | string | 资源编码<br>规则：<br>链接：<br>数据列：<br>按钮： |
| &ensp;&ensp;&#124;─name | string | 接口名称 |
| &ensp;&ensp;&#124;─menuId | integer | 菜单ID<br>#auth_menu |
| &ensp;&ensp;&#124;─describe | string | 接口描述 |
| &ensp;&ensp;&#124;─method | string |  |
| &ensp;&ensp;&#124;─url | string |  |
| &ensp;&ensp;&#124;─updateTime | string |  |
| &ensp;&ensp;&#124;─updateUser | integer |  |
| &ensp;&ensp;&#124;─id | integer |  |
| &ensp;&ensp;&#124;─createTime | string |  |
| &ensp;&ensp;&#124;─createUser | integer |  |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "code": "",
    "name": "",
    "menuId": 0,
    "describe": "",
    "method": "",
    "url": "",
    "updateTime": "",
    "updateUser": 0,
    "id": 0,
    "createTime": "",
    "createUser": 0
  },
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 新增资源

> BASIC

**Path:** /resource

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | string | 资源编码<br>规则：<br>链接：<br>数据列：<br>按钮： |
| name | string | 接口名称 |
| menuId | integer | 菜单ID<br>#auth_menu |
| describe | string | 接口描述 |

**Request Demo:**

```json
{
  "code": "",
  "name": "",
  "menuId": 0,
  "describe": ""
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─code | string | 资源编码<br>规则：<br>链接：<br>数据列：<br>按钮： |
| &ensp;&ensp;&#124;─name | string | 接口名称 |
| &ensp;&ensp;&#124;─menuId | integer | 菜单ID<br>#auth_menu |
| &ensp;&ensp;&#124;─describe | string | 接口描述 |
| &ensp;&ensp;&#124;─method | string |  |
| &ensp;&ensp;&#124;─url | string |  |
| &ensp;&ensp;&#124;─updateTime | string |  |
| &ensp;&ensp;&#124;─updateUser | integer |  |
| &ensp;&ensp;&#124;─id | integer |  |
| &ensp;&ensp;&#124;─createTime | string |  |
| &ensp;&ensp;&#124;─createUser | integer |  |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "code": "",
    "name": "",
    "menuId": 0,
    "describe": "",
    "method": "",
    "url": "",
    "updateTime": "",
    "updateUser": 0,
    "id": 0,
    "createTime": "",
    "createUser": 0
  },
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 修改资源

> BASIC

**Path:** /resource

**Method:** PUT

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| id | integer |  |
| name | string | 接口名称 |
| menuId | integer | 菜单ID<br>#auth_menu |
| describe | string | 接口描述 |

**Request Demo:**

```json
{
  "id": 0,
  "name": "",
  "menuId": 0,
  "describe": ""
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─code | string | 资源编码<br>规则：<br>链接：<br>数据列：<br>按钮： |
| &ensp;&ensp;&#124;─name | string | 接口名称 |
| &ensp;&ensp;&#124;─menuId | integer | 菜单ID<br>#auth_menu |
| &ensp;&ensp;&#124;─describe | string | 接口描述 |
| &ensp;&ensp;&#124;─method | string |  |
| &ensp;&ensp;&#124;─url | string |  |
| &ensp;&ensp;&#124;─updateTime | string |  |
| &ensp;&ensp;&#124;─updateUser | integer |  |
| &ensp;&ensp;&#124;─id | integer |  |
| &ensp;&ensp;&#124;─createTime | string |  |
| &ensp;&ensp;&#124;─createUser | integer |  |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "code": "",
    "name": "",
    "menuId": 0,
    "describe": "",
    "method": "",
    "url": "",
    "updateTime": "",
    "updateUser": 0,
    "id": 0,
    "createTime": "",
    "createUser": 0
  },
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 删除资源

> BASIC

**Path:** /resource

**Method:** DELETE

**Desc:**

 链接类型的资源 只清空 menu_id
按钮和数据列 则物理删除

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/x-www-form-urlencoded | YES |  |

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| ids[] |  | YES |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | boolean | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": false,
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 查询用户可用的所有资源

> BASIC

**Path:** /resource

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| menuId |  | NO | 父资源id， 用于查询按钮 |
| userId |  | NO | 登录人用户id |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | array | 调用结果 |
| &ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─code | string | 资源编码<br>规则：<br>链接：<br>数据列：<br>按钮： |
| &ensp;&ensp;&ensp;&ensp;&#124;─name | string | 接口名称 |
| &ensp;&ensp;&ensp;&ensp;&#124;─menuId | integer | 菜单ID<br>#auth_menu |
| &ensp;&ensp;&ensp;&ensp;&#124;─describe | string | 接口描述 |
| &ensp;&ensp;&ensp;&ensp;&#124;─method | string |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─url | string |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─updateTime | string |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─updateUser | integer |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─id | integer |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─createTime | string |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─createUser | integer |  |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": [
    {
      "code": "",
      "name": "",
      "menuId": 0,
      "describe": "",
      "method": "",
      "url": "",
      "updateTime": "",
      "updateUser": 0,
      "id": 0,
      "createTime": "",
      "createUser": 0
    }
  ],
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 查询所有资源

> BASIC

**Path:** /resource/list

**Method:** GET

> REQUEST



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | array | 调用结果 |
| &ensp;&ensp;&#124;─ | object |  |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": [
    {}
  ],
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```







# aggregate-pay-log

exported at 2023-02-07 21:42:34

## Project name(项目名称)：aggregate-pay

Project name(项目名称)：aggregate-pay
Package(包名): mao.aggregate_pay_log.controller
Class(类名): LoginLogController
Author(作者）: mao
Author QQ：1296193245
GitHub：https://github.com/maomao124/
Date(创建日期)： 2023/1/24
Time(创建时间)： 15:27
Version(版本): 1.0
Description(描述)： 登录日志


---
### 保存登录日志

> BASIC

**Path:** /log/login

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| id | integer | 主键 |
| requestIp | string | 登录IP |
| userId | integer | 登录人ID |
| username | string | 用户名 |
| mobile | string | 手机号 |
| tenants | string | 账号所属的多个租户id，json数据保存 |
| loginDate | string | 登录时间 |
| location | string | 登录地点 |

**Request Demo:**

```json
{
  "id": 0,
  "requestIp": "",
  "userId": 0,
  "username": "",
  "mobile": "",
  "tenants": "",
  "loginDate": "",
  "location": ""
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | boolean | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": false,
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 分页查询系统操作日志

> BASIC

**Path:** /log/login/page

**Method:** GET

> REQUEST



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {},
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 查询系统登录日志

> BASIC

**Path:** /log/login/{id}

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| id |  |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─id | integer | 主键 |
| &ensp;&ensp;&#124;─requestIp | string | 登录IP |
| &ensp;&ensp;&#124;─userId | integer | 登录人ID |
| &ensp;&ensp;&#124;─username | string | 用户名 |
| &ensp;&ensp;&#124;─mobile | string | 手机号 |
| &ensp;&ensp;&#124;─tenants | string | 账号所属的多个租户id，json数据保存 |
| &ensp;&ensp;&#124;─loginDate | string | 登录时间 |
| &ensp;&ensp;&#124;─location | string | 登录地点 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "id": 0,
    "requestIp": "",
    "userId": 0,
    "username": "",
    "mobile": "",
    "tenants": "",
    "loginDate": "",
    "location": ""
  },
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```





## Project name(项目名称)：aggregate-pay

Project name(项目名称)：aggregate-pay
Package(包名): mao.aggregate_pay_log.controller
Class(类名): OptLogController
Author(作者）: mao
Author QQ：1296193245
GitHub：https://github.com/maomao124/
Date(创建日期)： 2023/1/14
Time(创建时间)： 14:31
Version(版本): 1.0
Description(描述)： 操作日志


---
### 保存操作日志

> BASIC

**Path:** /log/opt

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| id | integer | id |
| requestIp | string | 操作IP |
| type | string | 日志类型<br>#LogType{OPT:操作类型;EX:异常类型}<br>OPT :OPT="操作类型"<br>EX :EX="异常类型" |
| userName | integer | 操作人 |
| description | string | 操作描述 |
| classPath | string | 类路径 |
| actionMethod | string | 请求方法 |
| requestUri | string | 请求地址 |
| httpMethod | string | 请求类型<br>#HttpMethod{GET:GET请求;POST:POST请求;PUT:PUT请求;DELETE:DELETE请求;PATCH:PATCH请求;TRACE:TRACE请求;HEAD:HEAD请求;OPTIONS:OPTIONS请求;}<br>GET :GET:GET<br>POST :POST:POST<br>PUT :PUT:PUT<br>DELETE :DELETE:DELETE<br>PATCH :PATCH:PATCH<br>TRACE :TRACE:TRACE<br>HEAD :HEAD:HEAD<br>OPTIONS :OPTIONS:OPTIONS |
| params | string | 请求参数 |
| result | string | 返回值 |
| exDesc | string | 异常详情信息 |
| exDetail | string | 异常描述 |
| startTime | string | 开始时间 |
| finishTime | string | 完成时间 |
| consumingTime | integer | 消耗时间 |
| ua | string | 浏览器 |

**Request Demo:**

```json
{
  "id": 0,
  "requestIp": "",
  "type": "",
  "userName": 0,
  "description": "",
  "classPath": "",
  "actionMethod": "",
  "requestUri": "",
  "httpMethod": "",
  "params": "",
  "result": "",
  "exDesc": "",
  "exDetail": "",
  "startTime": "",
  "finishTime": "",
  "consumingTime": 0,
  "ua": ""
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | boolean | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": false,
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 分页查询系统操作日志

> BASIC

**Path:** /log/opt/page

**Method:** GET

> REQUEST



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {},
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 分页查询某个商户的系统操作日志

> BASIC

**Path:** /log/opt/page/{merchantId}

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| merchantId |  |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {},
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 分页查询某个商户的系统操作日志，给商户看的

> BASIC

**Path:** /log/opt/page2/{merchantId}

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| merchantId |  |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {},
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 查询系统操作日志

> BASIC

**Path:** /log/opt/{id}

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| id |  |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─id | integer | id |
| &ensp;&ensp;&#124;─requestIp | string | 操作IP |
| &ensp;&ensp;&#124;─type | string | 日志类型<br>#LogType{OPT:操作类型;EX:异常类型}<br>OPT :OPT="操作类型"<br>EX :EX="异常类型" |
| &ensp;&ensp;&#124;─userName | integer | 操作人 |
| &ensp;&ensp;&#124;─description | string | 操作描述 |
| &ensp;&ensp;&#124;─classPath | string | 类路径 |
| &ensp;&ensp;&#124;─actionMethod | string | 请求方法 |
| &ensp;&ensp;&#124;─requestUri | string | 请求地址 |
| &ensp;&ensp;&#124;─httpMethod | string | 请求类型<br>#HttpMethod{GET:GET请求;POST:POST请求;PUT:PUT请求;DELETE:DELETE请求;PATCH:PATCH请求;TRACE:TRACE请求;HEAD:HEAD请求;OPTIONS:OPTIONS请求;}<br>GET :GET:GET<br>POST :POST:POST<br>PUT :PUT:PUT<br>DELETE :DELETE:DELETE<br>PATCH :PATCH:PATCH<br>TRACE :TRACE:TRACE<br>HEAD :HEAD:HEAD<br>OPTIONS :OPTIONS:OPTIONS |
| &ensp;&ensp;&#124;─params | string | 请求参数 |
| &ensp;&ensp;&#124;─result | string | 返回值 |
| &ensp;&ensp;&#124;─exDesc | string | 异常详情信息 |
| &ensp;&ensp;&#124;─exDetail | string | 异常描述 |
| &ensp;&ensp;&#124;─startTime | string | 开始时间 |
| &ensp;&ensp;&#124;─finishTime | string | 完成时间 |
| &ensp;&ensp;&#124;─consumingTime | integer | 消耗时间 |
| &ensp;&ensp;&#124;─ua | string | 浏览器 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "id": 0,
    "requestIp": "",
    "type": "",
    "userName": 0,
    "description": "",
    "classPath": "",
    "actionMethod": "",
    "requestUri": "",
    "httpMethod": "",
    "params": "",
    "result": "",
    "exDesc": "",
    "exDetail": "",
    "startTime": "",
    "finishTime": "",
    "consumingTime": 0,
    "ua": ""
  },
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```







# aggregate-pay-payment-agent-service

exported at 2023-02-07 21:42:34

## Project name(项目名称)：aggregate-pay

Project name(项目名称)：aggregate-pay
Package(包名): mao.aggregate_pay_payment_agent_service.controller
Class(类名): PayChannelAgentController
Author(作者）: mao
Author QQ：1296193245
GitHub：https://github.com/maomao124/
Date(创建日期)： 2023/2/1
Time(创建时间)： 20:33
Version(版本): 1.0
Description(描述)： 支付代理服务


---
### 调用支付宝手机WAP下单接口

> BASIC

**Path:** /pay/agent/createPayOrderByAliWAP

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| aliConfigParam | object | 阿里配置参数 |
| &ensp;&ensp;&#124;─appId | string | 应用id |
| &ensp;&ensp;&#124;─rsaPrivateKey | string | 私钥 |
| &ensp;&ensp;&#124;─notifyUrl | string | 异步回调通知 |
| &ensp;&ensp;&#124;─returnUrl | string | 同步回调通知 |
| &ensp;&ensp;&#124;─url | string | 支付宝网关 |
| &ensp;&ensp;&#124;─charset | string | 编码方式 UTF-8。 |
| &ensp;&ensp;&#124;─format | string | 格式JSON |
| &ensp;&ensp;&#124;─alipayPublicKey | string | 支付宝公钥 |
| &ensp;&ensp;&#124;─logPath | string | 日志保存路径 |
| &ensp;&ensp;&#124;─signType | string | RSA2 户生成签名字符串所使用的签名算法类型，目前支持RSA2和RSA，推荐使用RSA2 |
| alipayBean | object | 支付实体对象，根据支付宝接口协议 |
| &ensp;&ensp;&#124;─outTradeNo | string | 商户订单号，必填 |
| &ensp;&ensp;&#124;─subject | string | 订单名称，必填 |
| &ensp;&ensp;&#124;─totalAmount | string | 付款金额(元)，必填 |
| &ensp;&ensp;&#124;─productCode | string | 产品编号，必填 |
| &ensp;&ensp;&#124;─body | string | 商品描述，可空 |
| &ensp;&ensp;&#124;─expireTime | string | 超时时间参数 |
| &ensp;&ensp;&#124;─timestamp | string | 时间 |
| &ensp;&ensp;&#124;─storeId | integer | 门店id |
| &ensp;&ensp;&#124;─attach | string | 订单附件数据， 格式为： SJPAY,平台商户号,Appid,门店,平台渠道编码 |

**Request Demo:**

```json
{
  "aliConfigParam": {
    "appId": "",
    "rsaPrivateKey": "",
    "notifyUrl": "",
    "returnUrl": "",
    "url": "",
    "charset": "",
    "format": "",
    "alipayPublicKey": "",
    "logPath": "",
    "signType": ""
  },
  "alipayBean": {
    "outTradeNo": "",
    "subject": "",
    "totalAmount": "",
    "productCode": "",
    "body": "",
    "expireTime": "",
    "timestamp": "",
    "storeId": 0,
    "attach": ""
  }
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─code | string | 系统状态 "0"代表请求成功 |
| &ensp;&ensp;&#124;─msg | string | 消息 |
| &ensp;&ensp;&#124;─tradeNo | string | 原始渠道订单号() 聚合平台角度：原始交易号      商户应用角度：聚合平台的订单号 |
| &ensp;&ensp;&#124;─outTradeNo | string | 商户订单号   聚合平台角度：自己订单号       商户应用角度：自己订单号 |
| &ensp;&ensp;&#124;─tradeState | string | 支付状态<br>SUCCESS :业务交易支付 明确成功<br>FAILED :业务交易支付 明确失败，<br>UNKNOWN :业务交易状态未知，<br>USERPAYING :交易新建，等待支付<br>REVOKED :交易已撤销 |
| &ensp;&ensp;&#124;─content | string | 内容 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "code": "",
    "msg": "",
    "tradeNo": "",
    "outTradeNo": "",
    "tradeState": "",
    "content": ""
  },
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 微信jsapi下单接口请求

> BASIC

**Path:** /pay/agent/createPayOrderByWeChatJSAPI

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| wxConfigParam | object | 微信配置参数 |
| &ensp;&ensp;&#124;─appId | string | 应用id |
| &ensp;&ensp;&#124;─appSecret | string | 是APPID对应的接口密码，用于获取接口调用凭证access_token时使用。 |
| &ensp;&ensp;&#124;─mchId | string | 商户号 |
| &ensp;&ensp;&#124;─key | string | key |
| &ensp;&ensp;&#124;─returnUrl | string | 回调地址 |
| weChatBean | object | 微信支付 |
| &ensp;&ensp;&#124;─appid | string | 公众号 |
| &ensp;&ensp;&#124;─mchId | string | 商户号 |
| &ensp;&ensp;&#124;─nonceStr | string | 随机字符串 |
| &ensp;&ensp;&#124;─sign | string | 签名 |
| &ensp;&ensp;&#124;─body | string | 商品描述 |
| &ensp;&ensp;&#124;─outTradeNo | string | 商户订单号 |
| &ensp;&ensp;&#124;─totalFee | integer | 标价金额 |
| &ensp;&ensp;&#124;─spbillCreateIp | string | 终端IP |
| &ensp;&ensp;&#124;─notifyUrl | string | 通知地址 |
| &ensp;&ensp;&#124;─tradeType | string | 交易类型 |
| &ensp;&ensp;&#124;─openId | string | 开放id |
| &ensp;&ensp;&#124;─storeId | integer | 自定义字段，门店id |
| &ensp;&ensp;&#124;─attach | string | 附加数据 attach 否 |

**Request Demo:**

```json
{
  "wxConfigParam": {
    "appId": "",
    "appSecret": "",
    "mchId": "",
    "key": "",
    "returnUrl": ""
  },
  "weChatBean": {
    "appid": "",
    "mchId": "",
    "nonceStr": "",
    "sign": "",
    "body": "",
    "outTradeNo": "",
    "totalFee": 0,
    "spbillCreateIp": "",
    "notifyUrl": "",
    "tradeType": "",
    "openId": "",
    "storeId": 0,
    "attach": ""
  }
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─key | string |  |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "": ""
  },
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```







# aggregate-pay-uaa-service

exported at 2023-02-07 21:42:34

## Project name(项目名称)：aggregate-pay

Project name(项目名称)：aggregate-pay
Package(包名): mao.aggregate_pay_uaa_service.controller
Class(类名): UAAController
Author(作者）: mao
Author QQ：1296193245
GitHub：https://github.com/maomao124/
Date(创建日期)： 2023/1/22
Time(创建时间)： 12:53
Version(版本): 1.0
Description(描述)： 认证和授权


---
### 检查令牌

> BASIC

**Path:** /oauth/check_token

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/x-www-form-urlencoded | YES |  |

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| token |  | YES | 令牌 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| key | object |  |

**Response Demo:**

```json
{
  "": null
}
```




---
### 创建客户细节

> BASIC

**Path:** /oauth/createClientDetails

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| key | string |  |

**Request Demo:**

```json
{
  "": ""
}
```




---
### 根据appId查询client信息  appId也就是client_id

> BASIC

**Path:** /oauth/getClientDetailsByClientId

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| appId |  | YES | 应用程序id |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| key | string |  |

**Response Demo:**

```json
{
  "": ""
}
```





## Project name(项目名称)：aggregate-pay

Project name(项目名称)：aggregate-pay
Package(包名): mao.aggregate_pay_uaa_service.controller
Class(类名): PageController
Author(作者）: mao
Author QQ：1296193245
GitHub：https://github.com/maomao124/
Date(创建日期)： 2023/1/22
Time(创建时间)： 14:08
Version(版本): 1.0
Description(描述)： 无


---
### 登录页面

> BASIC

**Path:** /login

**Method:** GET

> REQUEST



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
|  | string | [The{@code String} class represents character strings. All<br>string literals in Java programs, such as{@code "abc"}, are<br>implemented as instances of this class.<br><p><br>Strings are constant; their values cannot be changed after they<br>are created. String buffers support mutable strings.<br>Because String objects are immutable they can be shared. For example:<br><blockquote><pre><br>    String str = "abc";<br></pre></blockquote><p><br>is equivalent to:<br><blockquote><pre><br>    char data[] ={'a', 'b', 'c'};<br>    String str = new String(data);<br></pre></blockquote><p><br>Here are some more examples of how strings can be used:<br><blockquote><pre><br>    System.out.println("abc");<br>    String cde = "cde";<br>    System.out.println("abc" + cde);<br>    String c = "abc".substring(2,3);<br>    String d = cde.substring(1, 2);<br></pre></blockquote><br><p><br>The class{@code String} includes methods for examining<br>individual characters of the sequence, for comparing strings, for<br>searching strings, for extracting substrings, and for creating a<br>copy of a string with all characters translated to uppercase or to<br>lowercase. Case mapping is based on the Unicode Standard version<br>specified by the{@link java.lang.Character Character} class.<br><p><br>The Java language provides special support for the string<br>concatenation operator (&nbsp;+&nbsp;), and for conversion of<br>other objects to strings. String concatenation is implemented<br>through the{@code StringBuilder}(or{@code StringBuffer})<br>class and its{@code append} method.<br>String conversions are implemented through the method<br>{@code toString}, defined by{@code Object} and<br>inherited by all classes in Java. For additional information on<br>string concatenation and conversion, see Gosling, Joy, and Steele,<br><i>The Java Language Specification</i>.<br><br><p> Unless otherwise noted, passing a <tt>null</tt> argument to a constructor<br>or method in this class will cause a{@link NullPointerException} to be<br>thrown.<br><br><p>A{@code String} represents a string in the UTF-16 format<br>in which <em>supplementary characters</em> are represented by <em>surrogate<br>pairs</em> (see the section <a href="Character.html#unicode">Unicode<br>Character Representations</a> in the{@code Character} class for<br>more information).<br>Index values refer to{@code char} code units, so a supplementary<br>character uses two positions in a{@code String}.<br><p>The{@code String} class provides methods for dealing with<br>Unicode code points (i.e., characters), in addition to those for<br>dealing with Unicode code units (i.e.,{@code char} values).] |

**Response Demo:**

```json

```





## Project name(项目名称)：aggregate-pay

Project name(项目名称)：aggregate-pay
Package(包名): mao.aggregate_pay_uaa_service.controller
Class(类名): UAAControllerV2
Author(作者）: mao
Author QQ：1296193245
GitHub：https://github.com/maomao124/
Date(创建日期)： 2023/1/22
Time(创建时间)： 19:12
Version(版本): 2.0
Description(描述)： 认证和授权


---
### 检查令牌

> BASIC

**Path:** /v2/oauth/check_token

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/x-www-form-urlencoded | YES |  |

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| token |  | YES | 令牌 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─key | object |  |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "": null
  },
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 创建客户细节

> BASIC

**Path:** /v2/oauth/createClientDetails

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| key | string |  |

**Request Demo:**

```json
{
  "": ""
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | boolean | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": false,
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 根据appId查询client信息  appId也就是client_id

> BASIC

**Path:** /v2/oauth/getClientDetailsByClientId

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| appId |  | YES | 应用程序id |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─key | string |  |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "": ""
  },
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```







# aggregate-pay-merchant-service

exported at 2023-02-07 21:42:34

## Project name(项目名称)：aggregate-pay

Project name(项目名称)：aggregate-pay
Package(包名): mao.aggregate_pay_merchant_service.controller
Class(类名): StaffController
Author(作者）: mao
Author QQ：1296193245
GitHub：https://github.com/maomao124/
Date(创建日期)： 2023/2/5
Time(创建时间)： 21:56
Version(版本): 1.0
Description(描述)： 无


---
### 分页条件查询商户下员工

> BASIC

**Path:** /staff/queryStaffByPage/{pageNo}/{pageSize}

**Method:** POST

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| pageNo |  | 页号 |
| pageSize |  | 页面大小 |

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| id | integer | id |
| merchantId | integer | 商户ID |
| fullName | string | 姓名 |
| fullname | string | 姓名 |
| position | string | 职位 |
| username | string | 用户名 |
| mobile | string | 手机号 |
| storeId | integer | 员工所属门店 |
| lastLoginTime | string | 最后登录时间 |
| staffStatus | boolean | 员工状态 |

**Request Demo:**

```json
{
  "id": 0,
  "merchantId": 0,
  "fullName": "",
  "fullname": "",
  "position": "",
  "username": "",
  "mobile": "",
  "storeId": 0,
  "lastLoginTime": "",
  "staffStatus": false
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | array | 调用结果 |
| &ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─id | integer | id |
| &ensp;&ensp;&ensp;&ensp;&#124;─merchantId | integer | 商户ID |
| &ensp;&ensp;&ensp;&ensp;&#124;─fullName | string | 姓名 |
| &ensp;&ensp;&ensp;&ensp;&#124;─fullname | string | 姓名 |
| &ensp;&ensp;&ensp;&ensp;&#124;─position | string | 职位 |
| &ensp;&ensp;&ensp;&ensp;&#124;─username | string | 用户名 |
| &ensp;&ensp;&ensp;&ensp;&#124;─mobile | string | 手机号 |
| &ensp;&ensp;&ensp;&ensp;&#124;─storeId | integer | 员工所属门店 |
| &ensp;&ensp;&ensp;&ensp;&#124;─lastLoginTime | string | 最后登录时间 |
| &ensp;&ensp;&ensp;&ensp;&#124;─staffStatus | boolean | 员工状态 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": [
    {
      "id": 0,
      "merchantId": 0,
      "fullName": "",
      "fullname": "",
      "position": "",
      "username": "",
      "mobile": "",
      "storeId": 0,
      "lastLoginTime": "",
      "staffStatus": false
    }
  ],
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 保存员工信息

> BASIC

**Path:** /staff/my/staffs

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| id | integer | id |
| merchantId | integer | 商户ID |
| fullName | string | 姓名 |
| fullname | string | 姓名 |
| position | string | 职位 |
| username | string | 用户名 |
| mobile | string | 手机号 |
| storeId | integer | 员工所属门店 |
| lastLoginTime | string | 最后登录时间 |
| staffStatus | boolean | 员工状态 |

**Request Demo:**

```json
{
  "id": 0,
  "merchantId": 0,
  "fullName": "",
  "fullname": "",
  "position": "",
  "username": "",
  "mobile": "",
  "storeId": 0,
  "lastLoginTime": "",
  "staffStatus": false
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─id | integer | id |
| &ensp;&ensp;&#124;─merchantId | integer | 商户ID |
| &ensp;&ensp;&#124;─fullName | string | 姓名 |
| &ensp;&ensp;&#124;─fullname | string | 姓名 |
| &ensp;&ensp;&#124;─position | string | 职位 |
| &ensp;&ensp;&#124;─username | string | 用户名 |
| &ensp;&ensp;&#124;─mobile | string | 手机号 |
| &ensp;&ensp;&#124;─storeId | integer | 员工所属门店 |
| &ensp;&ensp;&#124;─lastLoginTime | string | 最后登录时间 |
| &ensp;&ensp;&#124;─staffStatus | boolean | 员工状态 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "id": 0,
    "merchantId": 0,
    "fullName": "",
    "fullname": "",
    "position": "",
    "username": "",
    "mobile": "",
    "storeId": 0,
    "lastLoginTime": "",
    "staffStatus": false
  },
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 删除员工信息

> BASIC

**Path:** /staff/my/staffs

**Method:** DELETE

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| id | integer | id |
| merchantId | integer | 商户ID |
| fullName | string | 姓名 |
| fullname | string | 姓名 |
| position | string | 职位 |
| username | string | 用户名 |
| mobile | string | 手机号 |
| storeId | integer | 员工所属门店 |
| lastLoginTime | string | 最后登录时间 |
| staffStatus | boolean | 员工状态 |

**Request Demo:**

```json
{
  "id": 0,
  "merchantId": 0,
  "fullName": "",
  "fullname": "",
  "position": "",
  "username": "",
  "mobile": "",
  "storeId": 0,
  "lastLoginTime": "",
  "staffStatus": false
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | boolean | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": false,
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```





## Project name(项目名称)：aggregate-pay

Project name(项目名称)：aggregate-pay
Package(包名): mao.aggregate_pay_merchant_service.controller
Class(类名): MerchantController
Author(作者）: mao
Author QQ：1296193245
GitHub：https://github.com/maomao124/
Date(创建日期)： 2023/1/9
Time(创建时间)： 15:53
Version(版本): 1.0
Description(描述)： 商户Controller


---
### 根据商户id查询商户信息

> BASIC

**Path:** /merchant/{merchantId}

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| merchantId |  | 商人id |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─id | integer | id |
| &ensp;&ensp;&#124;─merchantName | string | 商户名称 |
| &ensp;&ensp;&#124;─merchantNo | integer | 企业编号 |
| &ensp;&ensp;&#124;─merchantAddress | string | 企业地址 |
| &ensp;&ensp;&#124;─merchantType | string | 商户类型 |
| &ensp;&ensp;&#124;─businessLicensesImg | string | 营业执照img |
| &ensp;&ensp;&#124;─idCardFrontImg | string | 法人身份证正面照片 |
| &ensp;&ensp;&#124;─idCardAfterImg | string | 法人身份证反面照片 |
| &ensp;&ensp;&#124;─username | string | 联系人姓名 |
| &ensp;&ensp;&#124;─mobile | string | 联系人手机号 |
| &ensp;&ensp;&#124;─password | string | 用户密码 |
| &ensp;&ensp;&#124;─contactsAddress | string | 联系人地址 |
| &ensp;&ensp;&#124;─auditStatus | string | 审核状态 |
| &ensp;&ensp;&#124;─tenantId | integer | 租户ID |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "id": 0,
    "merchantName": "",
    "merchantNo": 0,
    "merchantAddress": "",
    "merchantType": "",
    "businessLicensesImg": "",
    "idCardFrontImg": "",
    "idCardAfterImg": "",
    "username": "",
    "mobile": "",
    "password": "",
    "contactsAddress": "",
    "auditStatus": "",
    "tenantId": 0
  },
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 注册商户

> BASIC

**Path:** /merchant

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| id | integer | id |
| merchantName | string | 商户名称 |
| merchantNo | integer | 企业编号 |
| merchantAddress | string | 企业地址 |
| merchantType | string | 商户类型 |
| businessLicensesImg | string | 营业执照img |
| idCardFrontImg | string | 法人身份证正面照片 |
| idCardAfterImg | string | 法人身份证反面照片 |
| username | string | 联系人姓名 |
| mobile | string | 联系人手机号 |
| password | string | 用户密码 |
| contactsAddress | string | 联系人地址 |
| auditStatus | string | 审核状态 |
| tenantId | integer | 租户ID |

**Request Demo:**

```json
{
  "id": 0,
  "merchantName": "",
  "merchantNo": 0,
  "merchantAddress": "",
  "merchantType": "",
  "businessLicensesImg": "",
  "idCardFrontImg": "",
  "idCardAfterImg": "",
  "username": "",
  "mobile": "",
  "password": "",
  "contactsAddress": "",
  "auditStatus": "",
  "tenantId": 0
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─id | integer | id |
| &ensp;&ensp;&#124;─merchantName | string | 商户名称 |
| &ensp;&ensp;&#124;─merchantNo | integer | 企业编号 |
| &ensp;&ensp;&#124;─merchantAddress | string | 企业地址 |
| &ensp;&ensp;&#124;─merchantType | string | 商户类型 |
| &ensp;&ensp;&#124;─businessLicensesImg | string | 营业执照img |
| &ensp;&ensp;&#124;─idCardFrontImg | string | 法人身份证正面照片 |
| &ensp;&ensp;&#124;─idCardAfterImg | string | 法人身份证反面照片 |
| &ensp;&ensp;&#124;─username | string | 联系人姓名 |
| &ensp;&ensp;&#124;─mobile | string | 联系人手机号 |
| &ensp;&ensp;&#124;─password | string | 用户密码 |
| &ensp;&ensp;&#124;─contactsAddress | string | 联系人地址 |
| &ensp;&ensp;&#124;─auditStatus | string | 审核状态 |
| &ensp;&ensp;&#124;─tenantId | integer | 租户ID |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "id": 0,
    "merchantName": "",
    "merchantNo": 0,
    "merchantAddress": "",
    "merchantType": "",
    "businessLicensesImg": "",
    "idCardFrontImg": "",
    "idCardAfterImg": "",
    "username": "",
    "mobile": "",
    "password": "",
    "contactsAddress": "",
    "auditStatus": "",
    "tenantId": 0
  },
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 商户资质申请

> BASIC

**Path:** /merchant/{merchantId}

**Method:** POST

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| merchantId |  | 商人id |

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| id | integer | id |
| merchantName | string | 商户名称 |
| merchantNo | integer | 企业编号 |
| merchantAddress | string | 企业地址 |
| merchantType | string | 商户类型 |
| businessLicensesImg | string | 营业执照img |
| idCardFrontImg | string | 法人身份证正面照片 |
| idCardAfterImg | string | 法人身份证反面照片 |
| username | string | 联系人姓名 |
| mobile | string | 联系人手机号 |
| password | string | 用户密码 |
| contactsAddress | string | 联系人地址 |
| auditStatus | string | 审核状态 |
| tenantId | integer | 租户ID |

**Request Demo:**

```json
{
  "id": 0,
  "merchantName": "",
  "merchantNo": 0,
  "merchantAddress": "",
  "merchantType": "",
  "businessLicensesImg": "",
  "idCardFrontImg": "",
  "idCardAfterImg": "",
  "username": "",
  "mobile": "",
  "password": "",
  "contactsAddress": "",
  "auditStatus": "",
  "tenantId": 0
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | boolean | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": false,
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 商户下新增门店

> BASIC

**Path:** /merchant/createStore

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| id | integer | id |
| storeName | string | 门店名称 |
| storeNumber | integer | 门店编号 |
| merchantId | integer | 所属商户 |
| parentId | integer | 父门店 |
| storeStatus | boolean | 门店状态 |
| storeAddress | string | 门店地址 |

**Request Demo:**

```json
{
  "id": 0,
  "storeName": "",
  "storeNumber": 0,
  "merchantId": 0,
  "parentId": 0,
  "storeStatus": false,
  "storeAddress": ""
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─id | integer | id |
| &ensp;&ensp;&#124;─storeName | string | 门店名称 |
| &ensp;&ensp;&#124;─storeNumber | integer | 门店编号 |
| &ensp;&ensp;&#124;─merchantId | integer | 所属商户 |
| &ensp;&ensp;&#124;─parentId | integer | 父门店 |
| &ensp;&ensp;&#124;─storeStatus | boolean | 门店状态 |
| &ensp;&ensp;&#124;─storeAddress | string | 门店地址 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "id": 0,
    "storeName": "",
    "storeNumber": 0,
    "merchantId": 0,
    "parentId": 0,
    "storeStatus": false,
    "storeAddress": ""
  },
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 商户新增员工

> BASIC

**Path:** /merchant/createStaff

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| id | integer | id |
| merchantId | integer | 商户ID |
| fullName | string | 姓名 |
| fullname | string | 姓名 |
| position | string | 职位 |
| username | string | 用户名 |
| mobile | string | 手机号 |
| storeId | integer | 员工所属门店 |
| lastLoginTime | string | 最后登录时间 |
| staffStatus | boolean | 员工状态 |

**Request Demo:**

```json
{
  "id": 0,
  "merchantId": 0,
  "fullName": "",
  "fullname": "",
  "position": "",
  "username": "",
  "mobile": "",
  "storeId": 0,
  "lastLoginTime": "",
  "staffStatus": false
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─id | integer | id |
| &ensp;&ensp;&#124;─merchantId | integer | 商户ID |
| &ensp;&ensp;&#124;─fullName | string | 姓名 |
| &ensp;&ensp;&#124;─fullname | string | 姓名 |
| &ensp;&ensp;&#124;─position | string | 职位 |
| &ensp;&ensp;&#124;─username | string | 用户名 |
| &ensp;&ensp;&#124;─mobile | string | 手机号 |
| &ensp;&ensp;&#124;─storeId | integer | 员工所属门店 |
| &ensp;&ensp;&#124;─lastLoginTime | string | 最后登录时间 |
| &ensp;&ensp;&#124;─staffStatus | boolean | 员工状态 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "id": 0,
    "merchantId": 0,
    "fullName": "",
    "fullname": "",
    "position": "",
    "username": "",
    "mobile": "",
    "storeId": 0,
    "lastLoginTime": "",
    "staffStatus": false
  },
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 为门店设置管理员

> BASIC

**Path:** /merchant/bindStaffToStore/{storeId}/{staffId}

**Method:** POST

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| storeId |  | 门店id |
| staffId |  | 员工id |

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/x-www-form-urlencoded | YES |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | boolean | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": false,
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 根据租户id查询商户信息

> BASIC

**Path:** /merchant/tenantId/{tenantId}

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| tenantId |  | 租户id |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─id | integer | id |
| &ensp;&ensp;&#124;─merchantName | string | 商户名称 |
| &ensp;&ensp;&#124;─merchantNo | integer | 企业编号 |
| &ensp;&ensp;&#124;─merchantAddress | string | 企业地址 |
| &ensp;&ensp;&#124;─merchantType | string | 商户类型 |
| &ensp;&ensp;&#124;─businessLicensesImg | string | 营业执照img |
| &ensp;&ensp;&#124;─idCardFrontImg | string | 法人身份证正面照片 |
| &ensp;&ensp;&#124;─idCardAfterImg | string | 法人身份证反面照片 |
| &ensp;&ensp;&#124;─username | string | 联系人姓名 |
| &ensp;&ensp;&#124;─mobile | string | 联系人手机号 |
| &ensp;&ensp;&#124;─password | string | 用户密码 |
| &ensp;&ensp;&#124;─contactsAddress | string | 联系人地址 |
| &ensp;&ensp;&#124;─auditStatus | string | 审核状态 |
| &ensp;&ensp;&#124;─tenantId | integer | 租户ID |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "id": 0,
    "merchantName": "",
    "merchantNo": 0,
    "merchantAddress": "",
    "merchantType": "",
    "businessLicensesImg": "",
    "idCardFrontImg": "",
    "idCardAfterImg": "",
    "username": "",
    "mobile": "",
    "password": "",
    "contactsAddress": "",
    "auditStatus": "",
    "tenantId": 0
  },
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 分页条件查询商户下门店

> BASIC

**Path:** /merchant/queryStoreByPage/{pageNo}/{pageSize}

**Method:** POST

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| pageNo |  | 页号 |
| pageSize |  | 页面大小 |

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| id | integer | id |
| storeName | string | 门店名称 |
| storeNumber | integer | 门店编号 |
| merchantId | integer | 所属商户 |
| parentId | integer | 父门店 |
| storeStatus | boolean | 门店状态 |
| storeAddress | string | 门店地址 |

**Request Demo:**

```json
{
  "id": 0,
  "storeName": "",
  "storeNumber": 0,
  "merchantId": 0,
  "parentId": 0,
  "storeStatus": false,
  "storeAddress": ""
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | array | 调用结果 |
| &ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─id | integer | id |
| &ensp;&ensp;&ensp;&ensp;&#124;─storeName | string | 门店名称 |
| &ensp;&ensp;&ensp;&ensp;&#124;─storeNumber | integer | 门店编号 |
| &ensp;&ensp;&ensp;&ensp;&#124;─merchantId | integer | 所属商户 |
| &ensp;&ensp;&ensp;&ensp;&#124;─parentId | integer | 父门店 |
| &ensp;&ensp;&ensp;&ensp;&#124;─storeStatus | boolean | 门店状态 |
| &ensp;&ensp;&ensp;&ensp;&#124;─storeAddress | string | 门店地址 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": [
    {
      "id": 0,
      "storeName": "",
      "storeNumber": 0,
      "merchantId": 0,
      "parentId": 0,
      "storeStatus": false,
      "storeAddress": ""
    }
  ],
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```





## Project name(项目名称)：aggregate-pay

Project name(项目名称)：aggregate-pay
Package(包名): mao.aggregate_pay_merchant_service.controller
Class(类名): TestController
Author(作者）: mao
Author QQ：1296193245
GitHub：https://github.com/maomao124/
Date(创建日期)： 2023/1/9
Time(创建时间)： 15:16
Version(版本): 1.0
Description(描述)： 无


---
### test

> BASIC

**Path:** /test

**Method:** GET

> REQUEST



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
|  | string |  |

**Response Demo:**

```json

```





## Project name(项目名称)：aggregate-pay

Project name(项目名称)：aggregate-pay
Package(包名): mao.aggregate_pay_merchant_service.controller
Class(类名): AppController
Author(作者）: mao
Author QQ：1296193245
GitHub：https://github.com/maomao124/
Date(创建日期)： 2023/1/12
Time(创建时间)： 19:56
Version(版本): 1.0
Description(描述)： app


---
### 创建应用

> BASIC

**Path:** /app/{merchantId}

**Method:** POST

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| merchantId |  | 商户id |

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| appId | string | 应用程序id |
| appName | string | 商店名称 |
| merchantId | integer | 所属商户 |
| publicKey | string | 公钥 |
| notifyUrl | string | 授权回调地址 |

**Request Demo:**

```json
{
  "appId": "",
  "appName": "",
  "merchantId": 0,
  "publicKey": "",
  "notifyUrl": ""
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─appId | string | 应用程序id |
| &ensp;&ensp;&#124;─appName | string | 商店名称 |
| &ensp;&ensp;&#124;─merchantId | integer | 所属商户 |
| &ensp;&ensp;&#124;─publicKey | string | 公钥 |
| &ensp;&ensp;&#124;─notifyUrl | string | 授权回调地址 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "appId": "",
    "appName": "",
    "merchantId": 0,
    "publicKey": "",
    "notifyUrl": ""
  },
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 查询商户下的应用列表

> BASIC

**Path:** /app/queryAppByMerchantId

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| merchantId |  | YES | 商户id |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | array | 调用结果 |
| &ensp;&ensp;&#124;─ | object |  |
| &ensp;&ensp;&ensp;&ensp;&#124;─appId | string | 应用程序id |
| &ensp;&ensp;&ensp;&ensp;&#124;─appName | string | 商店名称 |
| &ensp;&ensp;&ensp;&ensp;&#124;─merchantId | integer | 所属商户 |
| &ensp;&ensp;&ensp;&ensp;&#124;─publicKey | string | 公钥 |
| &ensp;&ensp;&ensp;&ensp;&#124;─notifyUrl | string | 授权回调地址 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": [
    {
      "appId": "",
      "appName": "",
      "merchantId": 0,
      "publicKey": "",
      "notifyUrl": ""
    }
  ],
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 通过id获取应用

> BASIC

**Path:** /app/getAppById

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| id |  | YES | id |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─appId | string | 应用程序id |
| &ensp;&ensp;&#124;─appName | string | 商店名称 |
| &ensp;&ensp;&#124;─merchantId | integer | 所属商户 |
| &ensp;&ensp;&#124;─publicKey | string | 公钥 |
| &ensp;&ensp;&#124;─notifyUrl | string | 授权回调地址 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "appId": "",
    "appName": "",
    "merchantId": 0,
    "publicKey": "",
    "notifyUrl": ""
  },
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 查询应用是否属于某个商户

> BASIC

**Path:** /app/queryAppInMerchant/{appId}/{merchantId}

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| appId |  | 应用程序id |
| merchantId |  | 商人id |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | boolean | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": false,
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```





## Project name(项目名称)：aggregate-pay

Project name(项目名称)：aggregate-pay
Package(包名): mao.aggregate_pay_merchant_service.controller
Class(类名): StoreController
Author(作者）: mao
Author QQ：1296193245
GitHub：https://github.com/maomao124/
Date(创建日期)： 2023/1/28
Time(创建时间)： 22:08
Version(版本): 1.0
Description(描述)： 无


---
### 查询门店是否属于某商户

> BASIC

**Path:** /store/queryStoreInMerchant/{storeId}/{merchantId}

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| storeId |  | 门店id |
| merchantId |  | 商户id |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | boolean | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": false,
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 更新商户下的门店信息

> BASIC

**Path:** /store/my/stores

**Method:** PUT

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| id | integer | id |
| storeName | string | 门店名称 |
| storeNumber | integer | 门店编号 |
| merchantId | integer | 所属商户 |
| parentId | integer | 父门店 |
| storeStatus | boolean | 门店状态 |
| storeAddress | string | 门店地址 |

**Request Demo:**

```json
{
  "id": 0,
  "storeName": "",
  "storeNumber": 0,
  "merchantId": 0,
  "parentId": 0,
  "storeStatus": false,
  "storeAddress": ""
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─id | integer | id |
| &ensp;&ensp;&#124;─storeName | string | 门店名称 |
| &ensp;&ensp;&#124;─storeNumber | integer | 门店编号 |
| &ensp;&ensp;&#124;─merchantId | integer | 所属商户 |
| &ensp;&ensp;&#124;─parentId | integer | 父门店 |
| &ensp;&ensp;&#124;─storeStatus | boolean | 门店状态 |
| &ensp;&ensp;&#124;─storeAddress | string | 门店地址 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "id": 0,
    "storeName": "",
    "storeNumber": 0,
    "merchantId": 0,
    "parentId": 0,
    "storeStatus": false,
    "storeAddress": ""
  },
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 新增商户下的门店信息

> BASIC

**Path:** /store/my/stores

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| staffIds |  | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| id | integer | id |
| storeName | string | 门店名称 |
| storeNumber | integer | 门店编号 |
| merchantId | integer | 所属商户 |
| parentId | integer | 父门店 |
| storeStatus | boolean | 门店状态 |
| storeAddress | string | 门店地址 |

**Request Demo:**

```json
{
  "id": 0,
  "storeName": "",
  "storeNumber": 0,
  "merchantId": 0,
  "parentId": 0,
  "storeStatus": false,
  "storeAddress": ""
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | object | 调用结果 |
| &ensp;&ensp;&#124;─id | integer | id |
| &ensp;&ensp;&#124;─storeName | string | 门店名称 |
| &ensp;&ensp;&#124;─storeNumber | integer | 门店编号 |
| &ensp;&ensp;&#124;─merchantId | integer | 所属商户 |
| &ensp;&ensp;&#124;─parentId | integer | 父门店 |
| &ensp;&ensp;&#124;─storeStatus | boolean | 门店状态 |
| &ensp;&ensp;&#124;─storeAddress | string | 门店地址 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": {
    "id": 0,
    "storeName": "",
    "storeNumber": 0,
    "merchantId": 0,
    "parentId": 0,
    "storeStatus": false,
    "storeAddress": ""
  },
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 删除商户下的门店信息

> BASIC

**Path:** /store/my/stores

**Method:** DELETE

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| id | integer | id |
| storeName | string | 门店名称 |
| storeNumber | integer | 门店编号 |
| merchantId | integer | 所属商户 |
| parentId | integer | 父门店 |
| storeStatus | boolean | 门店状态 |
| storeAddress | string | 门店地址 |

**Request Demo:**

```json
{
  "id": 0,
  "storeName": "",
  "storeNumber": 0,
  "merchantId": 0,
  "parentId": 0,
  "storeStatus": false,
  "storeAddress": ""
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | boolean | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": false,
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```







# aggregate-pay-merchant-application

exported at 2023-02-07 21:42:34

## Project name(项目名称)：aggregate-pay

Project name(项目名称)：aggregate-pay
Package(包名): mao.aggregate_pay_merchant_application.controller
Class(类名): StoreController
Author(作者）: mao
Author QQ：1296193245
GitHub：https://github.com/maomao124/
Date(创建日期)： 2023/1/28
Time(创建时间)： 21:27
Version(版本): 1.0
Description(描述)： 无


---
### 分页条件查询商户下门店

> BASIC

**Path:** /my/stores/merchants/page

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/x-www-form-urlencoded | YES |  |

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| pageNo |  | YES | 页号 |
| pageSize |  | YES | 页面大小 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
|  | array | [Project name(项目名称)：aggregate-pay<br>Package(包名): mao.aggregate_pay_common.domain<br>Class(类名): PageVO<br>Author(作者）: mao<br>Author QQ：1296193245<br>GitHub：https://github.com/maomao124/<br>Date(创建日期)： 2023/1/7<br>Time(创建时间)： 14:48<br>Version(版本): 1.0<br>Description(描述)： 无]<[Project name(项目名称)：aggregate-pay<br>Package(包名): mao.aggregate_pay_merchant_api.dto<br>Class(类名): StoreDTO<br>Author(作者）: mao<br>Author QQ：1296193245<br>GitHub：https://github.com/maomao124/<br>Date(创建日期)： 2023/1/9<br>Time(创建时间)： 15:07<br>Version(版本): 1.0<br>Description(描述)： 无]> |
|  | object |  |
| &ensp;&ensp;&#124;─id | integer | id |
| &ensp;&ensp;&#124;─storeName | string | 门店名称 |
| &ensp;&ensp;&#124;─storeNumber | integer | 门店编号 |
| &ensp;&ensp;&#124;─merchantId | integer | 所属商户 |
| &ensp;&ensp;&#124;─parentId | integer | 父门店 |
| &ensp;&ensp;&#124;─storeStatus | boolean | 门店状态 |
| &ensp;&ensp;&#124;─storeAddress | string | 门店地址 |

**Response Demo:**

```json
[
  {
    "id": 0,
    "storeName": "",
    "storeNumber": 0,
    "merchantId": 0,
    "parentId": 0,
    "storeStatus": false,
    "storeAddress": ""
  }
]
```




---
### 生成商户应用门店的二维码

> BASIC

**Path:** /my/apps/{appId}/stores/{storeId}/app-store-qrcode

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| storeId |  | 商户门店id |
| appId |  | 商户应用id |

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| body |  | NO |  |
| totalAmount |  | NO |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
|  | string | [The{@code String} class represents character strings. All<br>string literals in Java programs, such as{@code "abc"}, are<br>implemented as instances of this class.<br><p><br>Strings are constant; their values cannot be changed after they<br>are created. String buffers support mutable strings.<br>Because String objects are immutable they can be shared. For example:<br><blockquote><pre><br>    String str = "abc";<br></pre></blockquote><p><br>is equivalent to:<br><blockquote><pre><br>    char data[] ={'a', 'b', 'c'};<br>    String str = new String(data);<br></pre></blockquote><p><br>Here are some more examples of how strings can be used:<br><blockquote><pre><br>    System.out.println("abc");<br>    String cde = "cde";<br>    System.out.println("abc" + cde);<br>    String c = "abc".substring(2,3);<br>    String d = cde.substring(1, 2);<br></pre></blockquote><br><p><br>The class{@code String} includes methods for examining<br>individual characters of the sequence, for comparing strings, for<br>searching strings, for extracting substrings, and for creating a<br>copy of a string with all characters translated to uppercase or to<br>lowercase. Case mapping is based on the Unicode Standard version<br>specified by the{@link java.lang.Character Character} class.<br><p><br>The Java language provides special support for the string<br>concatenation operator (&nbsp;+&nbsp;), and for conversion of<br>other objects to strings. String concatenation is implemented<br>through the{@code StringBuilder}(or{@code StringBuffer})<br>class and its{@code append} method.<br>String conversions are implemented through the method<br>{@code toString}, defined by{@code Object} and<br>inherited by all classes in Java. For additional information on<br>string concatenation and conversion, see Gosling, Joy, and Steele,<br><i>The Java Language Specification</i>.<br><br><p> Unless otherwise noted, passing a <tt>null</tt> argument to a constructor<br>or method in this class will cause a{@link NullPointerException} to be<br>thrown.<br><br><p>A{@code String} represents a string in the UTF-16 format<br>in which <em>supplementary characters</em> are represented by <em>surrogate<br>pairs</em> (see the section <a href="Character.html#unicode">Unicode<br>Character Representations</a> in the{@code Character} class for<br>more information).<br>Index values refer to{@code char} code units, so a supplementary<br>character uses two positions in a{@code String}.<br><p>The{@code String} class provides methods for dealing with<br>Unicode code points (i.e., characters), in addition to those for<br>dealing with Unicode code units (i.e.,{@code char} values).] |

**Response Demo:**

```json

```




---
### 更新商户下的门店信息

> BASIC

**Path:** my/stores

**Method:** PUT

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| id | integer | id |
| storeName | string | 门店名称 |
| storeNumber | integer | 门店编号 |
| merchantId | integer | 所属商户 |
| parentId | integer | 父门店 |
| storeStatus | boolean | 门店状态 |
| storeAddress | string | 门店地址 |

**Request Demo:**

```json
{
  "id": 0,
  "storeName": "",
  "storeNumber": 0,
  "merchantId": 0,
  "parentId": 0,
  "storeStatus": false,
  "storeAddress": ""
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| id | integer | id |
| storeName | string | 门店名称 |
| storeNumber | integer | 门店编号 |
| merchantId | integer | 所属商户 |
| parentId | integer | 父门店 |
| storeStatus | boolean | 门店状态 |
| storeAddress | string | 门店地址 |

**Response Demo:**

```json
{
  "id": 0,
  "storeName": "",
  "storeNumber": 0,
  "merchantId": 0,
  "parentId": 0,
  "storeStatus": false,
  "storeAddress": ""
}
```




---
### 新增商户下的门店信息

> BASIC

**Path:** my/stores

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| staffIds |  | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| id | integer | id |
| storeName | string | 门店名称 |
| storeNumber | integer | 门店编号 |
| merchantId | integer | 所属商户 |
| parentId | integer | 父门店 |
| storeStatus | boolean | 门店状态 |
| storeAddress | string | 门店地址 |

**Request Demo:**

```json
{
  "id": 0,
  "storeName": "",
  "storeNumber": 0,
  "merchantId": 0,
  "parentId": 0,
  "storeStatus": false,
  "storeAddress": ""
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| id | integer | id |
| storeName | string | 门店名称 |
| storeNumber | integer | 门店编号 |
| merchantId | integer | 所属商户 |
| parentId | integer | 父门店 |
| storeStatus | boolean | 门店状态 |
| storeAddress | string | 门店地址 |

**Response Demo:**

```json
{
  "id": 0,
  "storeName": "",
  "storeNumber": 0,
  "merchantId": 0,
  "parentId": 0,
  "storeStatus": false,
  "storeAddress": ""
}
```




---
### 删除商户下的门店信息

> BASIC

**Path:** my/stores/{storeId}

**Method:** DELETE

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| storeId |  | 门店id |

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/x-www-form-urlencoded | YES |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
|  | boolean | [The Boolean class wraps a value of the primitive type<br>{@code boolean} in an object. An object of type<br>{@code Boolean} contains a single field whose type is<br>{@code boolean}.<br><p><br>In addition, this class provides many methods for<br>converting a{@code boolean} to a{@code String} and a<br>{@code String} to a{@code boolean}, as well as other<br>constants and methods useful when dealing with a<br>{@code boolean}.] |

**Response Demo:**

```json
false
```





## Project name(项目名称)：aggregate-pay

Project name(项目名称)：aggregate-pay
Package(包名): mao.aggregate_pay_merchant_application.controller
Class(类名): PlatformParamController
Author(作者）: mao
Author QQ：1296193245
GitHub：https://github.com/maomao124/
Date(创建日期)： 2023/1/14
Time(创建时间)： 23:21
Version(版本): 1.0
Description(描述)： 商户平台‐渠道和支付参数


---
### 获取平台所有服务类型

> BASIC

**Path:** /my/platform-channels

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| tenantId |  | NO |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
|  | array | [An ordered collection (also known as a <i>sequence</i>).  The user of this<br>interface has precise control over where in the list each element is<br>inserted.  The user can access elements by their integer index (position in<br>the list), and search for elements in the list.<p><br><br>Unlike sets, lists typically allow duplicate elements.  More formally,<br>lists typically allow pairs of elements <tt>e1</tt> and <tt>e2</tt><br>such that <tt>e1.equals(e2)</tt>, and they typically allow multiple<br>null elements if they allow null elements at all.  It is not inconceivable<br>that someone might wish to implement a list that prohibits duplicates, by<br>throwing runtime exceptions when the user attempts to insert them, but we<br>expect this usage to be rare.<p><br><br>The <tt>List</tt> interface places additional stipulations, beyond those<br>specified in the <tt>Collection</tt> interface, on the contracts of the<br><tt>iterator</tt>, <tt>add</tt>, <tt>remove</tt>, <tt>equals</tt>, and<br><tt>hashCode</tt> methods.  Declarations for other inherited methods are<br>also included here for convenience.<p><br><br>The <tt>List</tt> interface provides four methods for positional (indexed)<br>access to list elements.  Lists (like Java arrays) are zero based.  Note<br>that these operations may execute in time proportional to the index value<br>for some implementations (the <tt>LinkedList</tt> class, for<br>example). Thus, iterating over the elements in a list is typically<br>preferable to indexing through it if the caller does not know the<br>implementation.<p><br><br>The <tt>List</tt> interface provides a special iterator, called a<br><tt>ListIterator</tt>, that allows element insertion and replacement, and<br>bidirectional access in addition to the normal operations that the<br><tt>Iterator</tt> interface provides.  A method is provided to obtain a<br>list iterator that starts at a specified position in the list.<p><br><br>The <tt>List</tt> interface provides two methods to search for a specified<br>object.  From a performance standpoint, these methods should be used with<br>caution.  In many implementations they will perform costly linear<br>searches.<p><br><br>The <tt>List</tt> interface provides two methods to efficiently insert and<br>remove multiple elements at an arbitrary point in the list.<p><br><br>Note: While it is permissible for lists to contain themselves as elements,<br>extreme caution is advised: the <tt>equals</tt> and <tt>hashCode</tt><br>methods are no longer well defined on such a list.<br><br><p>Some list implementations have restrictions on the elements that<br>they may contain.  For example, some implementations prohibit null elements,<br>and some have restrictions on the types of their elements.  Attempting to<br>add an ineligible element throws an unchecked exception, typically<br><tt>NullPointerException</tt> or <tt>ClassCastException</tt>.  Attempting<br>to query the presence of an ineligible element may throw an exception,<br>or it may simply return false; some implementations will exhibit the former<br>behavior and some will exhibit the latter.  More generally, attempting an<br>operation on an ineligible element whose completion would not result in<br>the insertion of an ineligible element into the list may throw an<br>exception or it may succeed, at the option of the implementation.<br>Such exceptions are marked as "optional" in the specification for this<br>interface.<br><br><p>This interface is a member of the<br><a href="{@docRoot}/../technotes/guides/collections/index.html"><br>Java Collections Framework</a>.]<[Project name(项目名称)：aggregate-pay<br>Package(包名): mao.aggregate_pay_transaction_api.dto<br>Class(类名): PlatformChannelDTO<br>Author(作者）: mao<br>Author QQ：1296193245<br>GitHub：https://github.com/maomao124/<br>Date(创建日期)： 2023/1/13<br>Time(创建时间)： 22:00<br>Version(版本): 1.0<br>Description(描述)： 平台支付渠道DTO]> |
|  | object |  |
| &ensp;&ensp;&#124;─id | integer | id |
| &ensp;&ensp;&#124;─channelName | string | 支付渠道名称 |
| &ensp;&ensp;&#124;─channelCode | string | 支付渠道编码 |

**Response Demo:**

```json
[
  {
    "id": 0,
    "channelName": "",
    "channelCode": ""
  }
]
```




---
### 根据平台服务类型获取支付渠道列表

> BASIC

**Path:** /my/pay-channels/platform-channel/{platformChannelCode}

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| platformChannelCode |  | 服务类型编码 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
|  | array | [An ordered collection (also known as a <i>sequence</i>).  The user of this<br>interface has precise control over where in the list each element is<br>inserted.  The user can access elements by their integer index (position in<br>the list), and search for elements in the list.<p><br><br>Unlike sets, lists typically allow duplicate elements.  More formally,<br>lists typically allow pairs of elements <tt>e1</tt> and <tt>e2</tt><br>such that <tt>e1.equals(e2)</tt>, and they typically allow multiple<br>null elements if they allow null elements at all.  It is not inconceivable<br>that someone might wish to implement a list that prohibits duplicates, by<br>throwing runtime exceptions when the user attempts to insert them, but we<br>expect this usage to be rare.<p><br><br>The <tt>List</tt> interface places additional stipulations, beyond those<br>specified in the <tt>Collection</tt> interface, on the contracts of the<br><tt>iterator</tt>, <tt>add</tt>, <tt>remove</tt>, <tt>equals</tt>, and<br><tt>hashCode</tt> methods.  Declarations for other inherited methods are<br>also included here for convenience.<p><br><br>The <tt>List</tt> interface provides four methods for positional (indexed)<br>access to list elements.  Lists (like Java arrays) are zero based.  Note<br>that these operations may execute in time proportional to the index value<br>for some implementations (the <tt>LinkedList</tt> class, for<br>example). Thus, iterating over the elements in a list is typically<br>preferable to indexing through it if the caller does not know the<br>implementation.<p><br><br>The <tt>List</tt> interface provides a special iterator, called a<br><tt>ListIterator</tt>, that allows element insertion and replacement, and<br>bidirectional access in addition to the normal operations that the<br><tt>Iterator</tt> interface provides.  A method is provided to obtain a<br>list iterator that starts at a specified position in the list.<p><br><br>The <tt>List</tt> interface provides two methods to search for a specified<br>object.  From a performance standpoint, these methods should be used with<br>caution.  In many implementations they will perform costly linear<br>searches.<p><br><br>The <tt>List</tt> interface provides two methods to efficiently insert and<br>remove multiple elements at an arbitrary point in the list.<p><br><br>Note: While it is permissible for lists to contain themselves as elements,<br>extreme caution is advised: the <tt>equals</tt> and <tt>hashCode</tt><br>methods are no longer well defined on such a list.<br><br><p>Some list implementations have restrictions on the elements that<br>they may contain.  For example, some implementations prohibit null elements,<br>and some have restrictions on the types of their elements.  Attempting to<br>add an ineligible element throws an unchecked exception, typically<br><tt>NullPointerException</tt> or <tt>ClassCastException</tt>.  Attempting<br>to query the presence of an ineligible element may throw an exception,<br>or it may simply return false; some implementations will exhibit the former<br>behavior and some will exhibit the latter.  More generally, attempting an<br>operation on an ineligible element whose completion would not result in<br>the insertion of an ineligible element into the list may throw an<br>exception or it may succeed, at the option of the implementation.<br>Such exceptions are marked as "optional" in the specification for this<br>interface.<br><br><p>This interface is a member of the<br><a href="{@docRoot}/../technotes/guides/collections/index.html"><br>Java Collections Framework</a>.]<[Project name(项目名称)：aggregate-pay<br>Package(包名): mao.aggregate_pay_transaction_api.dto<br>Class(类名): PayChannelDTO<br>Author(作者）: mao<br>Author QQ：1296193245<br>GitHub：https://github.com/maomao124/<br>Date(创建日期)： 2023/1/13<br>Time(创建时间)： 21:54<br>Version(版本): 1.0<br>Description(描述)： 原始第三方支付渠道DTO]> |
|  | object |  |
| &ensp;&ensp;&#124;─id | integer | id |
| &ensp;&ensp;&#124;─channelName | string | 支付渠道名称 |
| &ensp;&ensp;&#124;─channelCode | string | 支付渠道编码 |

**Response Demo:**

```json
[
  {
    "id": 0,
    "channelName": "",
    "channelCode": ""
  }
]
```




---
### 商户配置支付渠道参数

> BASIC

**Path:** /my/pay-channel-params

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| id | integer | id |
| appId | string | 应用程序id |
| platformChannelCode | string | 应用绑定的服务类型对应的code |
| channelName | string | 参数配置名称 |
| merchantId | integer | 商户id |
| payChannel | string | 原始支付渠道编码 |
| param | string | 参数 |
| appPlatformChannelId | integer | 应用绑定的服务类型Id |

**Request Demo:**

```json
{
  "id": 0,
  "appId": "",
  "platformChannelCode": "",
  "channelName": "",
  "merchantId": 0,
  "payChannel": "",
  "param": "",
  "appPlatformChannelId": 0
}
```




---
### 获取指定应用指定服务类型下所包含的原始支付渠道参数列表

> BASIC

**Path:** /my/pay-channel-params/apps/{appId}/platform-channels/{platformChannel}

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| appId |  | 应用id |
| platformChannel |  | 平台支付渠道编码 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
|  | array | [An ordered collection (also known as a <i>sequence</i>).  The user of this<br>interface has precise control over where in the list each element is<br>inserted.  The user can access elements by their integer index (position in<br>the list), and search for elements in the list.<p><br><br>Unlike sets, lists typically allow duplicate elements.  More formally,<br>lists typically allow pairs of elements <tt>e1</tt> and <tt>e2</tt><br>such that <tt>e1.equals(e2)</tt>, and they typically allow multiple<br>null elements if they allow null elements at all.  It is not inconceivable<br>that someone might wish to implement a list that prohibits duplicates, by<br>throwing runtime exceptions when the user attempts to insert them, but we<br>expect this usage to be rare.<p><br><br>The <tt>List</tt> interface places additional stipulations, beyond those<br>specified in the <tt>Collection</tt> interface, on the contracts of the<br><tt>iterator</tt>, <tt>add</tt>, <tt>remove</tt>, <tt>equals</tt>, and<br><tt>hashCode</tt> methods.  Declarations for other inherited methods are<br>also included here for convenience.<p><br><br>The <tt>List</tt> interface provides four methods for positional (indexed)<br>access to list elements.  Lists (like Java arrays) are zero based.  Note<br>that these operations may execute in time proportional to the index value<br>for some implementations (the <tt>LinkedList</tt> class, for<br>example). Thus, iterating over the elements in a list is typically<br>preferable to indexing through it if the caller does not know the<br>implementation.<p><br><br>The <tt>List</tt> interface provides a special iterator, called a<br><tt>ListIterator</tt>, that allows element insertion and replacement, and<br>bidirectional access in addition to the normal operations that the<br><tt>Iterator</tt> interface provides.  A method is provided to obtain a<br>list iterator that starts at a specified position in the list.<p><br><br>The <tt>List</tt> interface provides two methods to search for a specified<br>object.  From a performance standpoint, these methods should be used with<br>caution.  In many implementations they will perform costly linear<br>searches.<p><br><br>The <tt>List</tt> interface provides two methods to efficiently insert and<br>remove multiple elements at an arbitrary point in the list.<p><br><br>Note: While it is permissible for lists to contain themselves as elements,<br>extreme caution is advised: the <tt>equals</tt> and <tt>hashCode</tt><br>methods are no longer well defined on such a list.<br><br><p>Some list implementations have restrictions on the elements that<br>they may contain.  For example, some implementations prohibit null elements,<br>and some have restrictions on the types of their elements.  Attempting to<br>add an ineligible element throws an unchecked exception, typically<br><tt>NullPointerException</tt> or <tt>ClassCastException</tt>.  Attempting<br>to query the presence of an ineligible element may throw an exception,<br>or it may simply return false; some implementations will exhibit the former<br>behavior and some will exhibit the latter.  More generally, attempting an<br>operation on an ineligible element whose completion would not result in<br>the insertion of an ineligible element into the list may throw an<br>exception or it may succeed, at the option of the implementation.<br>Such exceptions are marked as "optional" in the specification for this<br>interface.<br><br><p>This interface is a member of the<br><a href="{@docRoot}/../technotes/guides/collections/index.html"><br>Java Collections Framework</a>.]<[Project name(项目名称)：aggregate-pay<br>Package(包名): mao.aggregate_pay_transaction_api.dto<br>Class(类名): PayChannelParamDTO<br>Author(作者）: mao<br>Author QQ：1296193245<br>GitHub：https://github.com/maomao124/<br>Date(创建日期)： 2023/1/13<br>Time(创建时间)： 21:55<br>Version(版本): 1.0<br>Description(描述)： 商户原始支付渠道参数配置DTO]> |
|  | object |  |
| &ensp;&ensp;&#124;─id | integer | id |
| &ensp;&ensp;&#124;─appId | string | 应用程序id |
| &ensp;&ensp;&#124;─platformChannelCode | string | 应用绑定的服务类型对应的code |
| &ensp;&ensp;&#124;─channelName | string | 参数配置名称 |
| &ensp;&ensp;&#124;─merchantId | integer | 商户id |
| &ensp;&ensp;&#124;─payChannel | string | 原始支付渠道编码 |
| &ensp;&ensp;&#124;─param | string | 参数 |
| &ensp;&ensp;&#124;─appPlatformChannelId | integer | 应用绑定的服务类型Id |

**Response Demo:**

```json
[
  {
    "id": 0,
    "appId": "",
    "platformChannelCode": "",
    "channelName": "",
    "merchantId": 0,
    "payChannel": "",
    "param": "",
    "appPlatformChannelId": 0
  }
]
```




---
### 获取指定应用指定服务类型下所包含的某个原始支付参数

> BASIC

**Path:** /my/pay-channel-params/apps/{appId}/platform-channels/{platformChannel}/pay-channels/{payChannel}

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| appId |  | 应用id |
| platformChannel |  | 平台支付渠道编码 |
| payChannel |  | 实际支付渠道编码 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| id | integer | id |
| appId | string | 应用程序id |
| platformChannelCode | string | 应用绑定的服务类型对应的code |
| channelName | string | 参数配置名称 |
| merchantId | integer | 商户id |
| payChannel | string | 原始支付渠道编码 |
| param | string | 参数 |
| appPlatformChannelId | integer | 应用绑定的服务类型Id |

**Response Demo:**

```json
{
  "id": 0,
  "appId": "",
  "platformChannelCode": "",
  "channelName": "",
  "merchantId": 0,
  "payChannel": "",
  "param": "",
  "appPlatformChannelId": 0
}
```





## Project name(项目名称)：aggregate-pay

Project name(项目名称)：aggregate-pay
Package(包名): mao.aggregate_pay_merchant_application.controller
Class(类名): MerchantController
Author(作者）: mao
Author QQ：1296193245
GitHub：https://github.com/maomao124/
Date(创建日期)： 2023/1/10
Time(创建时间)： 21:49
Version(版本): 1.0
Description(描述)： 商户


---
### 发送验证码

> BASIC

**Path:** /sms

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| phone |  | YES | 电话 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
|  | string | [The{@code String} class represents character strings. All<br>string literals in Java programs, such as{@code "abc"}, are<br>implemented as instances of this class.<br><p><br>Strings are constant; their values cannot be changed after they<br>are created. String buffers support mutable strings.<br>Because String objects are immutable they can be shared. For example:<br><blockquote><pre><br>    String str = "abc";<br></pre></blockquote><p><br>is equivalent to:<br><blockquote><pre><br>    char data[] ={'a', 'b', 'c'};<br>    String str = new String(data);<br></pre></blockquote><p><br>Here are some more examples of how strings can be used:<br><blockquote><pre><br>    System.out.println("abc");<br>    String cde = "cde";<br>    System.out.println("abc" + cde);<br>    String c = "abc".substring(2,3);<br>    String d = cde.substring(1, 2);<br></pre></blockquote><br><p><br>The class{@code String} includes methods for examining<br>individual characters of the sequence, for comparing strings, for<br>searching strings, for extracting substrings, and for creating a<br>copy of a string with all characters translated to uppercase or to<br>lowercase. Case mapping is based on the Unicode Standard version<br>specified by the{@link java.lang.Character Character} class.<br><p><br>The Java language provides special support for the string<br>concatenation operator (&nbsp;+&nbsp;), and for conversion of<br>other objects to strings. String concatenation is implemented<br>through the{@code StringBuilder}(or{@code StringBuffer})<br>class and its{@code append} method.<br>String conversions are implemented through the method<br>{@code toString}, defined by{@code Object} and<br>inherited by all classes in Java. For additional information on<br>string concatenation and conversion, see Gosling, Joy, and Steele,<br><i>The Java Language Specification</i>.<br><br><p> Unless otherwise noted, passing a <tt>null</tt> argument to a constructor<br>or method in this class will cause a{@link NullPointerException} to be<br>thrown.<br><br><p>A{@code String} represents a string in the UTF-16 format<br>in which <em>supplementary characters</em> are represented by <em>surrogate<br>pairs</em> (see the section <a href="Character.html#unicode">Unicode<br>Character Representations</a> in the{@code Character} class for<br>more information).<br>Index values refer to{@code char} code units, so a supplementary<br>character uses two positions in a{@code String}.<br><p>The{@code String} class provides methods for dealing with<br>Unicode code points (i.e., characters), in addition to those for<br>dealing with Unicode code units (i.e.,{@code char} values).] 验证码的key |

**Response Demo:**

```json

```




---
### 注册商户

> BASIC

**Path:** /merchants/register

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| mobile | string | 商户手机号 |
| username | string | 商户用户名 |
| password | string | 商户密码 |
| verifiykey | string | 验证码的key |
| verifiyCode | string | 验证码 |

**Request Demo:**

```json
{
  "mobile": "",
  "username": "",
  "password": "",
  "verifiykey": "",
  "verifiyCode": ""
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| mobile | string | 商户手机号 |
| username | string | 商户用户名 |
| password | string | 商户密码 |
| verifiykey | string | 验证码的key |
| verifiyCode | string | 验证码 |

**Response Demo:**

```json
{
  "mobile": "",
  "username": "",
  "password": "",
  "verifiykey": "",
  "verifiyCode": ""
}
```




---
### 上传证件照

> BASIC

**Path:** /upload

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | multipart/form-data | YES |  |

**Form:**

| name | value | required | type | desc |
| ------------ | ------------ | ------------ | ------------ | ------------ |
| file |  | YES | file | 多部分文件 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
|  | string | [The{@code String} class represents character strings. All<br>string literals in Java programs, such as{@code "abc"}, are<br>implemented as instances of this class.<br><p><br>Strings are constant; their values cannot be changed after they<br>are created. String buffers support mutable strings.<br>Because String objects are immutable they can be shared. For example:<br><blockquote><pre><br>    String str = "abc";<br></pre></blockquote><p><br>is equivalent to:<br><blockquote><pre><br>    char data[] ={'a', 'b', 'c'};<br>    String str = new String(data);<br></pre></blockquote><p><br>Here are some more examples of how strings can be used:<br><blockquote><pre><br>    System.out.println("abc");<br>    String cde = "cde";<br>    System.out.println("abc" + cde);<br>    String c = "abc".substring(2,3);<br>    String d = cde.substring(1, 2);<br></pre></blockquote><br><p><br>The class{@code String} includes methods for examining<br>individual characters of the sequence, for comparing strings, for<br>searching strings, for extracting substrings, and for creating a<br>copy of a string with all characters translated to uppercase or to<br>lowercase. Case mapping is based on the Unicode Standard version<br>specified by the{@link java.lang.Character Character} class.<br><p><br>The Java language provides special support for the string<br>concatenation operator (&nbsp;+&nbsp;), and for conversion of<br>other objects to strings. String concatenation is implemented<br>through the{@code StringBuilder}(or{@code StringBuffer})<br>class and its{@code append} method.<br>String conversions are implemented through the method<br>{@code toString}, defined by{@code Object} and<br>inherited by all classes in Java. For additional information on<br>string concatenation and conversion, see Gosling, Joy, and Steele,<br><i>The Java Language Specification</i>.<br><br><p> Unless otherwise noted, passing a <tt>null</tt> argument to a constructor<br>or method in this class will cause a{@link NullPointerException} to be<br>thrown.<br><br><p>A{@code String} represents a string in the UTF-16 format<br>in which <em>supplementary characters</em> are represented by <em>surrogate<br>pairs</em> (see the section <a href="Character.html#unicode">Unicode<br>Character Representations</a> in the{@code Character} class for<br>more information).<br>Index values refer to{@code char} code units, so a supplementary<br>character uses two positions in a{@code String}.<br><p>The{@code String} class provides methods for dealing with<br>Unicode code points (i.e., characters), in addition to those for<br>dealing with Unicode code units (i.e.,{@code char} values).] |

**Response Demo:**

```json

```




---
### 商户资质申请

> BASIC

**Path:** /my/merchants/save

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| merchantName | string | 企业名称 |
| merchantNo | string | 企业编号 |
| merchantAddress | string | 企业地址 |
| merchantType | string | 行业类型 |
| businessLicensesImg | string | 营业执照图片 |
| idCardFrontImg | string | 法人身份证正面 |
| idCardAfterImg | string | 法人身份证反面 |
| username | string | 联系人 |
| contactsAddress | string | 联系人地址 |

**Request Demo:**

```json
{
  "merchantName": "",
  "merchantNo": "",
  "merchantAddress": "",
  "merchantType": "",
  "businessLicensesImg": "",
  "idCardFrontImg": "",
  "idCardAfterImg": "",
  "username": "",
  "contactsAddress": ""
}
```




---
### 获取登录用户的商户信息

> BASIC

**Path:** /my/merchants

**Method:** GET

> REQUEST



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| id | integer | id |
| merchantName | string | 商户名称 |
| merchantNo | integer | 企业编号 |
| merchantAddress | string | 企业地址 |
| merchantType | string | 商户类型 |
| businessLicensesImg | string | 营业执照img |
| idCardFrontImg | string | 法人身份证正面照片 |
| idCardAfterImg | string | 法人身份证反面照片 |
| username | string | 联系人姓名 |
| mobile | string | 联系人手机号 |
| password | string | 用户密码 |
| contactsAddress | string | 联系人地址 |
| auditStatus | string | 审核状态 |
| tenantId | integer | 租户ID |

**Response Demo:**

```json
{
  "id": 0,
  "merchantName": "",
  "merchantNo": 0,
  "merchantAddress": "",
  "merchantType": "",
  "businessLicensesImg": "",
  "idCardFrontImg": "",
  "idCardAfterImg": "",
  "username": "",
  "mobile": "",
  "password": "",
  "contactsAddress": "",
  "auditStatus": "",
  "tenantId": 0
}
```




---
### 查询交易总览

> BASIC

**Path:** /my/merchants/transactions

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/x-www-form-urlencoded | YES |  |

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| startTime |  | YES | 开始时间 |
| endTime |  | YES | 结束时间 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | string | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": "",
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 查询各个app下的交易总览

> BASIC

**Path:** /my/merchants/transactions/apps

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/x-www-form-urlencoded | YES |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | string | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": "",
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```




---
### 查询各个支付聚道下的交易总览

> BASIC

**Path:** /my/merchants/transactions/channels

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/x-www-form-urlencoded | YES |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| code | integer | 调用是否成功标识，0：成功，-1:系统繁忙，此时请开发者稍候再试 详情见[ExceptionCode] |
| data | string | 调用结果 |
| msg | string | 结果消息，如果调用成功，消息通常为空T |
| path | string |  |
| extra | object | 附加数据 |
| &ensp;&ensp;&#124;─key | object |  |
| timestamp | integer | 响应时间 |

**Response Demo:**

```json
{
  "code": 0,
  "data": "",
  "msg": "",
  "path": "",
  "extra": {
    "": {}
  },
  "timestamp": 0
}
```





## Project name(项目名称)：aggregate-pay

Project name(项目名称)：aggregate-pay
Package(包名): mao.aggregate_pay_merchant_application.controller
Class(类名): StaffController
Author(作者）: mao
Author QQ：1296193245
GitHub：https://github.com/maomao124/
Date(创建日期)： 2023/2/5
Time(创建时间)： 21:42
Version(版本): 1.0
Description(描述)： 商户平台‐员工管理


---
### 分页条件查询商户下员工

> BASIC

**Path:** /my/staffs/page

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/x-www-form-urlencoded | YES |  |

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| pageNo |  | YES | 页号 |
| pageSize |  | YES | 页面大小 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
|  | array | [Project name(项目名称)：aggregate-pay<br>Package(包名): mao.aggregate_pay_common.domain<br>Class(类名): PageVO<br>Author(作者）: mao<br>Author QQ：1296193245<br>GitHub：https://github.com/maomao124/<br>Date(创建日期)： 2023/1/7<br>Time(创建时间)： 14:48<br>Version(版本): 1.0<br>Description(描述)： 无]<[Project name(项目名称)：aggregate-pay<br>Package(包名): mao.aggregate_pay_merchant_api.dto<br>Class(类名): StaffDTO<br>Author(作者）: mao<br>Author QQ：1296193245<br>GitHub：https://github.com/maomao124/<br>Date(创建日期)： 2023/1/9<br>Time(创建时间)： 15:06<br>Version(版本): 1.0<br>Description(描述)： 无]> |
|  | object |  |
| &ensp;&ensp;&#124;─id | integer | id |
| &ensp;&ensp;&#124;─merchantId | integer | 商户ID |
| &ensp;&ensp;&#124;─fullName | string | 姓名 |
| &ensp;&ensp;&#124;─fullname | string | 姓名 |
| &ensp;&ensp;&#124;─position | string | 职位 |
| &ensp;&ensp;&#124;─username | string | 用户名 |
| &ensp;&ensp;&#124;─mobile | string | 手机号 |
| &ensp;&ensp;&#124;─storeId | integer | 员工所属门店 |
| &ensp;&ensp;&#124;─lastLoginTime | string | 最后登录时间 |
| &ensp;&ensp;&#124;─staffStatus | boolean | 员工状态 |

**Response Demo:**

```json
[
  {
    "id": 0,
    "merchantId": 0,
    "fullName": "",
    "fullname": "",
    "position": "",
    "username": "",
    "mobile": "",
    "storeId": 0,
    "lastLoginTime": "",
    "staffStatus": false
  }
]
```




---
### 保存员工信息

> BASIC

**Path:** /my/staffs

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| id | integer | id |
| merchantId | integer | 商户ID |
| fullName | string | 姓名 |
| fullname | string | 姓名 |
| position | string | 职位 |
| username | string | 用户名 |
| mobile | string | 手机号 |
| storeId | integer | 员工所属门店 |
| lastLoginTime | string | 最后登录时间 |
| staffStatus | boolean | 员工状态 |

**Request Demo:**

```json
{
  "id": 0,
  "merchantId": 0,
  "fullName": "",
  "fullname": "",
  "position": "",
  "username": "",
  "mobile": "",
  "storeId": 0,
  "lastLoginTime": "",
  "staffStatus": false
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| id | integer | id |
| merchantId | integer | 商户ID |
| fullName | string | 姓名 |
| fullname | string | 姓名 |
| position | string | 职位 |
| username | string | 用户名 |
| mobile | string | 手机号 |
| storeId | integer | 员工所属门店 |
| lastLoginTime | string | 最后登录时间 |
| staffStatus | boolean | 员工状态 |

**Response Demo:**

```json
{
  "id": 0,
  "merchantId": 0,
  "fullName": "",
  "fullname": "",
  "position": "",
  "username": "",
  "mobile": "",
  "storeId": 0,
  "lastLoginTime": "",
  "staffStatus": false
}
```




---
### 更新员工信息，前端并没有传递id过来，功能暂时未实现

> BASIC

**Path:** /my/staffs

**Method:** PUT

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| id | integer | id |
| merchantId | integer | 商户ID |
| fullName | string | 姓名 |
| fullname | string | 姓名 |
| position | string | 职位 |
| username | string | 用户名 |
| mobile | string | 手机号 |
| storeId | integer | 员工所属门店 |
| lastLoginTime | string | 最后登录时间 |
| staffStatus | boolean | 员工状态 |

**Request Demo:**

```json
{
  "id": 0,
  "merchantId": 0,
  "fullName": "",
  "fullname": "",
  "position": "",
  "username": "",
  "mobile": "",
  "storeId": 0,
  "lastLoginTime": "",
  "staffStatus": false
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| id | integer | id |
| merchantId | integer | 商户ID |
| fullName | string | 姓名 |
| fullname | string | 姓名 |
| position | string | 职位 |
| username | string | 用户名 |
| mobile | string | 手机号 |
| storeId | integer | 员工所属门店 |
| lastLoginTime | string | 最后登录时间 |
| staffStatus | boolean | 员工状态 |

**Response Demo:**

```json
{
  "id": 0,
  "merchantId": 0,
  "fullName": "",
  "fullname": "",
  "position": "",
  "username": "",
  "mobile": "",
  "storeId": 0,
  "lastLoginTime": "",
  "staffStatus": false
}
```




---
### 删除员工信息

> BASIC

**Path:** /my/staffs/{staffId}

**Method:** DELETE

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| staffId |  |  |

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/x-www-form-urlencoded | YES |  |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
|  | boolean | 员工dto |

**Response Demo:**

```json
false
```





## Project name(项目名称)：aggregate-pay

Project name(项目名称)：aggregate-pay
Package(包名): mao.aggregate_pay_merchant_application.controller
Class(类名): AppController
Author(作者）: mao
Author QQ：1296193245
GitHub：https://github.com/maomao124/
Date(创建日期)： 2023/1/12
Time(创建时间)： 20:10
Version(版本): 1.0
Description(描述)： 应用管理


---
### 创建应用

> BASIC

**Path:** /my/apps

**Method:** POST

> REQUEST

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/json | YES |  |

**Request Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| appId | string | 应用程序id |
| appName | string | 商店名称 |
| merchantId | integer | 所属商户 |
| publicKey | string | 公钥 |
| notifyUrl | string | 授权回调地址 |

**Request Demo:**

```json
{
  "appId": "",
  "appName": "",
  "merchantId": 0,
  "publicKey": "",
  "notifyUrl": ""
}
```



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| appId | string | 应用程序id |
| appName | string | 商店名称 |
| merchantId | integer | 所属商户 |
| publicKey | string | 公钥 |
| notifyUrl | string | 授权回调地址 |

**Response Demo:**

```json
{
  "appId": "",
  "appName": "",
  "merchantId": 0,
  "publicKey": "",
  "notifyUrl": ""
}
```




---
### 查询商户下的应用列表

> BASIC

**Path:** /my/apps

**Method:** GET

> REQUEST



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
|  | array | [An ordered collection (also known as a <i>sequence</i>).  The user of this<br>interface has precise control over where in the list each element is<br>inserted.  The user can access elements by their integer index (position in<br>the list), and search for elements in the list.<p><br><br>Unlike sets, lists typically allow duplicate elements.  More formally,<br>lists typically allow pairs of elements <tt>e1</tt> and <tt>e2</tt><br>such that <tt>e1.equals(e2)</tt>, and they typically allow multiple<br>null elements if they allow null elements at all.  It is not inconceivable<br>that someone might wish to implement a list that prohibits duplicates, by<br>throwing runtime exceptions when the user attempts to insert them, but we<br>expect this usage to be rare.<p><br><br>The <tt>List</tt> interface places additional stipulations, beyond those<br>specified in the <tt>Collection</tt> interface, on the contracts of the<br><tt>iterator</tt>, <tt>add</tt>, <tt>remove</tt>, <tt>equals</tt>, and<br><tt>hashCode</tt> methods.  Declarations for other inherited methods are<br>also included here for convenience.<p><br><br>The <tt>List</tt> interface provides four methods for positional (indexed)<br>access to list elements.  Lists (like Java arrays) are zero based.  Note<br>that these operations may execute in time proportional to the index value<br>for some implementations (the <tt>LinkedList</tt> class, for<br>example). Thus, iterating over the elements in a list is typically<br>preferable to indexing through it if the caller does not know the<br>implementation.<p><br><br>The <tt>List</tt> interface provides a special iterator, called a<br><tt>ListIterator</tt>, that allows element insertion and replacement, and<br>bidirectional access in addition to the normal operations that the<br><tt>Iterator</tt> interface provides.  A method is provided to obtain a<br>list iterator that starts at a specified position in the list.<p><br><br>The <tt>List</tt> interface provides two methods to search for a specified<br>object.  From a performance standpoint, these methods should be used with<br>caution.  In many implementations they will perform costly linear<br>searches.<p><br><br>The <tt>List</tt> interface provides two methods to efficiently insert and<br>remove multiple elements at an arbitrary point in the list.<p><br><br>Note: While it is permissible for lists to contain themselves as elements,<br>extreme caution is advised: the <tt>equals</tt> and <tt>hashCode</tt><br>methods are no longer well defined on such a list.<br><br><p>Some list implementations have restrictions on the elements that<br>they may contain.  For example, some implementations prohibit null elements,<br>and some have restrictions on the types of their elements.  Attempting to<br>add an ineligible element throws an unchecked exception, typically<br><tt>NullPointerException</tt> or <tt>ClassCastException</tt>.  Attempting<br>to query the presence of an ineligible element may throw an exception,<br>or it may simply return false; some implementations will exhibit the former<br>behavior and some will exhibit the latter.  More generally, attempting an<br>operation on an ineligible element whose completion would not result in<br>the insertion of an ineligible element into the list may throw an<br>exception or it may succeed, at the option of the implementation.<br>Such exceptions are marked as "optional" in the specification for this<br>interface.<br><br><p>This interface is a member of the<br><a href="{@docRoot}/../technotes/guides/collections/index.html"><br>Java Collections Framework</a>.]<[Project name(项目名称)：aggregate-pay<br>Package(包名): mao.aggregate_pay_merchant_api.dto<br>Class(类名): AppDTO<br>Author(作者）: mao<br>Author QQ：1296193245<br>GitHub：https://github.com/maomao124/<br>Date(创建日期)： 2023/1/9<br>Time(创建时间)： 15:02<br>Version(版本): 1.0<br>Description(描述)： 无]> |
|  | object |  |
| &ensp;&ensp;&#124;─appId | string | 应用程序id |
| &ensp;&ensp;&#124;─appName | string | 商店名称 |
| &ensp;&ensp;&#124;─merchantId | integer | 所属商户 |
| &ensp;&ensp;&#124;─publicKey | string | 公钥 |
| &ensp;&ensp;&#124;─notifyUrl | string | 授权回调地址 |

**Response Demo:**

```json
[
  {
    "appId": "",
    "appName": "",
    "merchantId": 0,
    "publicKey": "",
    "notifyUrl": ""
  }
]
```




---
### 根据应用id查询应用信息

> BASIC

**Path:** /my/apps/{appId}

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| appId |  | 应用id |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
| appId | string | 应用程序id |
| appName | string | 商店名称 |
| merchantId | integer | 所属商户 |
| publicKey | string | 公钥 |
| notifyUrl | string | 授权回调地址 |

**Response Demo:**

```json
{
  "appId": "",
  "appName": "",
  "merchantId": 0,
  "publicKey": "",
  "notifyUrl": ""
}
```




---
### 绑定服务类型

> BASIC

**Path:** /my/apps/{appId}/platform-channels

**Method:** POST

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| appId |  | 应用程序id |

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| Content-Type | application/x-www-form-urlencoded | YES |  |

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| platformChannelCodes |  | YES | 平台通道编码 |




---
### 查询应用是否绑定了某个服务类型

> BASIC

**Path:** /my/merchants/apps/platformchannels

**Method:** GET

> REQUEST

**Query:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| appId |  | YES | 应用程序id |
| platformChannel |  | YES | 平台通道 |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
|  | integer | 1为绑定了，0为没有绑定 |

**Response Demo:**

```json

```





## Project name(项目名称)：aggregate-pay

Project name(项目名称)：aggregate-pay
Package(包名): mao.aggregate_pay_merchant_application.controller
Class(类名): RoLeController
Author(作者）: mao
Author QQ：1296193245
GitHub：https://github.com/maomao124/
Date(创建日期)： 2023/2/6
Time(创建时间)： 20:41
Version(版本): 1.0
Description(描述)： 商户平台‐角色管理


---
### 得到当前角色列表

> BASIC

**Path:** /my/roles/tenants/{tenantId}

**Method:** GET

> REQUEST

**Path Params:**

| name | value | desc |
| ------------ | ------------ | ------------ |
| tenantId |  | 租户id |



> RESPONSE

**Headers:**

| name | value | required | desc |
| ------------ | ------------ | ------------ | ------------ |
| content-type | application/json;charset=UTF-8 | NO |  |

**Body:**

| name | type | desc |
| ------------ | ------------ | ------------ |
|  | string | json |

**Response Demo:**

```json

```







