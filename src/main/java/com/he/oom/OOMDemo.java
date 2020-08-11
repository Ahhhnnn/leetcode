package com.he.oom;

import java.util.HashMap;
import java.util.Map;

/**
 * oom demo
 */
public class OOMDemo {
    public static void main(String[] args) throws InterruptedException {
        Map cache = new HashMap();
        for (int i = 0; i<128;i++){
            Thread.sleep(500);
            cache.put(i,new byte[1024*1024]);
        }
        System.out.println("put cache finsh");
    }
}
