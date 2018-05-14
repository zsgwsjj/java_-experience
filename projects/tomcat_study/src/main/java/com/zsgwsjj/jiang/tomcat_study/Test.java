package com.zsgwsjj.jiang.tomcat_study;

import java.util.StringTokenizer;

/**
 * @author : jiang
 * @time : 2018/5/10 18:43
 */
public class Test {

    public static void main(String[] args) {

        String a = "xxx zzz\naaa\t21213";
        StringTokenizer ss = new StringTokenizer(a, "\t", false);
        while (ss.hasMoreElements()) {
            System.out.println("：："+ss.nextElement());
        }
    }
}
