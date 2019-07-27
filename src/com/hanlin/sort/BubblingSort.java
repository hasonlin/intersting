package com.hanlin.sort;
//冒泡排序法
public class BubblingSort {
    public static void main(String[] args) {
        int[] a = new int[]{1,5,6,8,7,20,15,72,16};
        BubblingSort bubblingSort = new BubblingSort();
        bubblingSort.sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+",");
        }
    }

    public void sort(int[] a){
        for (int i = 0; i < a.length-1; i++) {
            for (int j = 0; j <a.length-1-i; j++) {
                if(a[j]>a[j+1]){
                    int temp = a[j+1];
                    a[j+1] = a[j];
                    a[j] = temp;
                }
            }
        }
    }
}
