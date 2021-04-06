package me.warriorg.redis;

import org.junit.jupiter.api.Test;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

import java.util.HashSet;
import java.util.Set;

public class JedisConnectTest {

    @Test
    public void testJedis() {
        Jedis jedis = new Jedis("localhost", 6379);
        jedis.set("foo", "bar");
        String value = jedis.get("foo");
        System.out.println(value);
        jedis.close();
    }

    @Test
    public void testJedisPool() {
        JedisPool jedisPool = new JedisPool("localhost", 6379);
        Jedis jedis = jedisPool.getResource();
        jedis.set("bar", "foo");
        String value = jedis.get("bar");
        System.out.println(value);
        jedis.close();
        jedisPool.close();
    }

    @Test
    public void testJedisCluster() {
        Set<HostAndPort> nodes = new HashSet<>(2);
        nodes.add(new HostAndPort("192.168.10.10", 6379));
        nodes.add(new HostAndPort("192.168.10.11", 6379));
        nodes.add(new HostAndPort("192.168.10.12", 6379));
        JedisCluster cluster = new JedisCluster(nodes);
        cluster.set("cluster-test", "hehehehe");
        String result = cluster.get("cluster-test");
        System.out.println(result);
        cluster.close();
    }
}
