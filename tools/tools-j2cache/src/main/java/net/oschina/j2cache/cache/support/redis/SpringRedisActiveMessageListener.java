package net.oschina.j2cache.cache.support.redis;

import net.oschina.j2cache.cluster.ClusterPolicy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

/**
 * 监听二缓key失效，主动清除本地缓存
 */
public class SpringRedisActiveMessageListener implements MessageListener
{

    /**
     * 日志记录器
     */
    private static Logger logger = LoggerFactory.getLogger(net.oschina.j2cache.cache.support.redis.SpringRedisActiveMessageListener.class);

    /**
     * 集群政策
     */
    private ClusterPolicy clusterPolicy;

    /**
     * 名称空间
     */
    private String namespace;

    SpringRedisActiveMessageListener(ClusterPolicy clusterPolicy, String namespace)
    {
        this.clusterPolicy = clusterPolicy;
        this.namespace = namespace;
    }

    @Override
    public void onMessage(Message message, byte[] pattern)
    {
        String key = message.toString();
        if (key == null)
        {
            return;
        }
        if (key.startsWith(namespace + ":"))
        {
            String[] k = key.replaceFirst(namespace + ":", "").split(":", 2);
            if (k.length != 2)
            {
                return;
            }
            clusterPolicy.evict(k[0], k[1]);
        }

    }

}
