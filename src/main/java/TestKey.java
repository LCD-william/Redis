import redis.clients.jedis.Jedis;

import java.util.Set;

public class TestKey {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);

        System.out.println("清空数据"+jedis.flushDB());
        System.out.println("是否存在key：username" +jedis.exists("username"));
        System.out.println("新增key username：william" + jedis.set("username","william"));
        System.out.println("新增key password： 123456"+ jedis.set("password","123456"));
        System.out.println("系统中的所有key：");
        Set<String> keys = jedis.keys("*");
        System.out.println(keys);

        System.out.println("删除key password" + jedis.del("password"));
        System.out.println("判断key password存不存在" + jedis.exists("password"));
        System.out.println("查看key username 的类型" + jedis.type("username"));
        System.out.println("随机返回keys中的一个" + jedis.randomKey());
        System.out.println("重命名key" + jedis.rename("username","newusername"));
        System.out.println("取出改名之后的username" + jedis.get("newusername"));
        System.out.println("按索引查新" + jedis.select(0));
        System.out.println("删除当前库中所有key" + jedis.flushDB());
        System.out.println("返回当前数据库key的数量" + jedis.dbSize());
        System.out.println("删除所有数据库中的key" + jedis.flushAll());
    }
}
