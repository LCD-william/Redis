import redis.clients.jedis.Jedis;

public class TestSet {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.flushDB();

        System.out.println("向set中添加元素"+ jedis.sadd("setEle","ele1","ele2","ele3","ele4"));
        System.out.println("获得所有元素" + jedis.smembers("setEle"));
        System.out.println("删除一个元素" + jedis.srem("setEle","ele2"));
        System.out.println("所有元素为" + jedis.smembers("setEle"));

        System.out.println("随机移除一个元素" + jedis.spop("setEle"));
        System.out.println("所有元素为" + jedis.smembers("setEle"));
        System.out.println("查看包含的元素数量" + jedis.scard("setEle"));
        System.out.println("判断ele1是否在set中" + jedis.sismember("setEle", "ele1"));

        jedis.flushDB();


    }
}
