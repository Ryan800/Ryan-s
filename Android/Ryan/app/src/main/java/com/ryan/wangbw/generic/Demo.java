package com.ryan.wangbw.generic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author wangbw
 * @desc
 * @date 2015/10/30.
 */
public class Demo {

    public static void main(String[] args) {
        Set s1 = new HashSet(2);
        s1.add("wang");
        s1.add(1);
        Set s2 = new HashSet(3);
        s2.add("bing");
        s2.add(3);
        s2.add("wang");
        Set<String> s3 = new HashSet<>(3);
        int result = numElementsInCommon(s1, s2);
        System.out.println(result);

        List<String> l1 = new ArrayList<>();
        l1.add("wang");
        List l2 = new ArrayList();
        l2.add("bing");
        l2.add(2);
        List<Object> l3 = new ArrayList<>();
        l3.add("wen");
        l3.add(5);
        l3.add(l1.get(0));
        l2.addAll(l1);
        l3.addAll(l1);

//        unsafeAdd(l1, new Integer(42));
//        String s = l1.get(1);

//        Collection
        HashSet<String> set = new HashSet<>(l1);
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        HashMap<String, String> hashMap = new HashMap<>(3);
        hashMap.put("1", "a");
        hashMap.put("2", "b");
        hashMap.put("3", "c");

        Iterator iterator1 = hashMap.entrySet().iterator();
        while (iterator1.hasNext()) {
            HashMap.Entry entry = (HashMap.Entry) iterator1.next();
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

        Set<Map.Entry<String, String>> set22 = hashMap.entrySet();
        for (Map.Entry<String, String> entry : set22) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

    }

    static int numElementsInCommon(Set s1, Set s2) {
        int result = 0;
        for (Object o1 : s1) {
            if (s2.contains(o1)) {
                result++;
            }
        }
        return result;
    }

    static int numElecmentsInCommon2(Set<?> s1, Set<?> s2) {
        int result = 0;
        for (Object o1:s1) {
            if (s2.contains(o1)) {
                result++;
            }
        }
        return result;
    }

    private static void unsafeAdd(List list, Object o) {
        list.add(o);
    }
}
