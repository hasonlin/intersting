package com.hanlin.sort;
//选择排序
public class SelectSort {
    public static void main(String[] args) {
        int[] a = new int[]{1,8,2,5,7,20,15,72,16};
        SelectSort selectSort = new SelectSort();
        selectSort.sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+",");
        }
    }

    public void sort(int[] a){
        for (int i = 0; i < a.length-1; i++) {
            int minIndex = i;  //用来记录最小的值的索引
            for (int j = i+1; j < a.length; j++) {
               if(a[j]<a[minIndex]){
                   minIndex = j;
               }
            }
            if(i !=minIndex){
                int temp = a[i];
                a[i] = a[minIndex];
                a[minIndex] = temp;
            }
        }
    }
}
