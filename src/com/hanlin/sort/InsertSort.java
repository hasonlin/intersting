package com.hanlin.sort;
//插入排序
public class InsertSort {
    public static void main(String[] args) {
        int[] a = new int[]{1,8,2,5,7,20,15,72,16};
        InsertSort insertSort = new InsertSort();
        insertSort.sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+",");
        }
    }

    public void sort(int[] a){
        for(int index = 1; index<a.length; index++){//外层向右的index，即作为比较对象的数据的index
            int temp = a[index];//用作比较的数据
            int leftindex = index-1;
            while(leftindex>=0 && a[leftindex]>temp){//当比到最左边或者遇到比temp小的数据时，结束循环
                a[leftindex+1] = a[leftindex];
                leftindex--;
            }
            a[leftindex+1] = temp;//把temp放到空位上
        }
    }
}
