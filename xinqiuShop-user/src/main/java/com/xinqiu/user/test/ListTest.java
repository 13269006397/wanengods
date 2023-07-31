package com.xinqiu.user.test;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;

public class ListTest {

    /**
     * list排序
     */
    @Test
    void listSort(){
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("春");
        stringList.add("秋");
        stringList.add("夏");
        stringList.add("冬");

        for (String s : stringList) {
            System.out.println(s);
        }
    }

    /**
     * list安全删除
     */
    @Test
    void listRemoveTest(){
        ArrayList<String> list = new ArrayList<>();
        list.add("11");
        list.add("22");
        list.add("33");
        list.add("33");

        // 1.普通删除
        // 动态数组 删除之后数组下标前移 for需循环i++之后会少数据
        /*for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("33")){
                list.remove(i);
            }
        }*/

        // 2.索引同步调整
        /*for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("33")){
                list.remove(i--);
            }
        }*/

        // 3.倒序删除 list.size()长度从1开始 数组下标从0 所以需要-1
        /*for (int i = list.size()-1; i >=0 ; i--) {
            if (list.get(i).equals("33")){
                list.remove(i);
            }
        }*/

        // 4.迭代器
       /* Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            if ("33".equals(iterator.next())){
                iterator.remove();
            }
        }*/
        list.removeIf(e -> "33".equals(e));
        System.out.println("删除后的list:"+JSON.toJSONString(list));
    }


}
