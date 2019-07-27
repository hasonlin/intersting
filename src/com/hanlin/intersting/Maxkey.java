package com.hanlin.intersting;

import java.util.*;

/**
 * Created by admin on 2018/5/11 0011.
 */
public class Maxkey {

    public static void main(String[] args) {
        String str = "22222";
        char[] strArr = str.toCharArray();
        Map<Character,Integer> map = MapFuntion(strArr);
//        FindMaxValue(map);
        FindMaxValue2(map,strArr);

        //
       /* int i= 9;
        switch (i){
            case 0:
                System.out.println("zero");
                break;
            default:
            System.out.println("default");
            break;
            case 1:
                System.out.println(1);
            case 2:
                System.out.println(2);
        }*/
    }

    public static Map<Character,Integer> MapFuntion(char[] strArr){
        Map<Character,Integer> map = new HashMap<Character, Integer>();
        if (strArr != null&&strArr.length!=0) {
            for (char str:strArr) {
                if(null!=map.get(str)){
                    map.put(str,map.get(str)+1);
                }else {
                    map.put(str,1);
                }
            }
        }
        return map;
    }

    public static Character FindMaxValue(Map<Character,Integer> map){
        Set<Character> set = map.keySet();
        Iterator it = set.iterator();
        Character character = (Character) it.next();
        int maxValue = map.get(character);
        while (it.hasNext()){
            Character c = (Character) it.next();
            if(maxValue<map.get(c)){
                character = c;
                maxValue = map.get(c);
            }
        }
        System.out.println("出现次数最多的字符："+character+"次数为："+maxValue);
        return character;
    }

    public static Character FindMaxValue2(Map<Character,Integer> map,char[] arr){
        Set<Character> set = map.keySet();
        Iterator it = set.iterator();
        Character character = (Character) it.next();
        int maxValue = map.get(character);
        for (int i = 0; i < arr.length; i++) {
            if(maxValue<map.get(arr[i])){
                character = arr[i];
                maxValue = map.get(arr[i]);
            }
        }
        System.out.println("出现次数最多的字符："+character+"次数为："+maxValue);
        return character;
    }
}
