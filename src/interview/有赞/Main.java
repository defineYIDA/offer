package interview.有赞;

import java.util.*;

/**
 * @Author: zl
 * @Date: 2019/9/17 15:34
 */
public class Main {
    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        *//*while (sc.hasNext()) {
            list.add(sc.nextInt());
        }*//*
        list.add(3);
        list.add(5); list.add(0); list.add(1); list.add(4);*/
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(getStr(s));
    }

    private static String getStr(String s) {
        StringBuilder sb = new StringBuilder(s);
        return "";
    }
    private static Integer lack(List<Integer> list) {
        if (list.size() == 0) {
            return 0;
        }
        int[] hash = new int[list.size() + 1];
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) <= list.size()) {
                hash[list.get(i)]++;
            }
        }
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] == 0)
                return i;
        }
        return 0;
    }
}
