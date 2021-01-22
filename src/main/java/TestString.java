import redis.clients.jedis.Jedis;

public class TestString {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);

        jedis.flushDB();
        System.out.println("新增数据");
        System.out.println("添加key username：" + jedis.set("username","william"));
        System.out.println("获取username key" + jedis.get("username"));
        System.out.println("添加字符到username key ：" + jedis.append("username","hello"));
        System.out.println("获取username 字符串的长度" + jedis.strlen("username"));

        System.out.println("设置多个字符串" + jedis.mset("password","123456","age","16"));
        System.out.println("获取多个字符串" + jedis.mget("password","age"));

        System.out.println("设置新增字符串" + jedis.setnx("username","hellowilliam"));
        System.out.println("获取新的username key" + jedis.get("username"));

        System.out.println("设置新增字符串" + jedis.setnx("key1","value1"));
        System.out.println("获取新的username key" + jedis.get("key1"));

        jedis.flushDB();
        jedis.flushAll();


    }
}
