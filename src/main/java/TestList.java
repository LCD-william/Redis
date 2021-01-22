import redis.clients.jedis.Jedis;

public class TestList {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);

        jedis.flushAll();
        System.out.println("添加一个list");
        System.out.println(jedis.lpush("collections","arraylist","hashmap","hashset","test1","test2"));
        System.out.println("打印指定list" + jedis.lrange("collections",0,-1));
        System.out.println("打印指定list的区间" + jedis.lrange("collections",0,2));

        System.out.println("删除list中的某个元素" + jedis.lrem("collections",2,"arraylist"));
        System.out.println("打印指定list" + jedis.lrange("collections", 0, -1));
        System.out.println("左出栈" + jedis.lpop("collections"));
        System.out.println(jedis.lrange("collections",0,-1));
        System.out.println("右出栈" + jedis.rpop("collections"));

        System.out.println("修改list指定位置元素" + jedis.lset("collections",1, "treemap"));
        System.out.println("获取下表为2的元素" + jedis.lindex("collections" , 1));

        System.out.println(jedis.lindex("collections", -1));

        jedis.flushAll();
    }
}
