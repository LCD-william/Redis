import redis.clients.jedis.Jedis;

import java.util.HashMap;

public class TestMap {
    public static void main(String[] args) {

        Jedis jedis = new Jedis("127.0.0.1", 6379);
        HashMap<String ,String> map = new HashMap<String, String>();
        map.put("key1","value1");
        map.put("key2","value2");
        map.put("key3","value3");
        map.put("key4","value4");
        map.put("key5","value5");
        jedis.flushDB();

        System.out.println("添加一个新的map" + jedis.hmset("map",map));
        System.out.println("获取所有键值对" + jedis.hgetAll("map"));
        System.out.println("获取所有的散列值" + jedis.hvals("map"));
        System.out.println("将 key5 的值加一 如果不存在添加key5" + jedis.hincrBy("map","key6",1));
        System.out.println(jedis.hgetAll("map"));
        System.out.println("将 key5 的值加一 如果不存在添加key5" + jedis.hincrBy("map","key6",5));
        System.out.println("是否存在key3" + jedis.hexists("map","key3"));

        jedis.flushDB();



    }
}
