package mao.tools_jwt.client;


import mao.tools_jwt.client.config.AuthClientConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import(AuthClientConfiguration.class)
public @interface EnableAuthClient
{

/*
配置文件示例：


authentication:
  user:
    # 过期时间
    expire: 1800
    # 公钥位置
    pubKey: keys/pub.key

 */
}
