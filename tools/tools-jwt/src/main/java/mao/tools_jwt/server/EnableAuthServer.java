package mao.tools_jwt.server;

import mao.tools_jwt.server.config.AuthServerConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import(AuthServerConfiguration.class)
public @interface EnableAuthServer
{

/*

配置文件示例：


authentication:
  user:
    # 过期时间
    expire: 1800
    # 私钥位置
    prikey: keys/pri.key
    # 公钥位置
    pubKey: keys/pub.key

 */
}
