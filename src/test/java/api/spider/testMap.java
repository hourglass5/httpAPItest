package api.spider;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class testMap {
    public static void main(String[] args) throws Exception {
        Map mapA = new HashMap<>();
        // 向集合中添加指定的key与value的映射关系
        mapA.put("box1","芭乐");
        mapA.put("box2","黑布林");
        mapA.put("box3","芒果");

        boolean key1 = false;
        // 如果此映射包含指定key的映射关系，则返回true
        key1 = mapA.containsKey("box4");
        System.out.println("key1:"+key1);

        boolean key2 = false;
        // 如果此映射将一个或多个key映射到指定值，则返回true
        key2 = mapA.containsValue("黑布林");
        System.out.println(key2);

        String value1 = "苹果";
        // 如果存在指定的key对象，则返回该对象对应的值，否则返回null
        value1 = (String) mapA.get("box6");
        System.out.println(value1);

        // 返回该集合中所有key对象形成的Set集合
        Set value2 = mapA.keySet();
        System.out.println(value2);

        // 返回该集合中所有值对象形成的Collection集合
        Collection value3 = mapA.values();
        System.out.println(value3);
    }
}
