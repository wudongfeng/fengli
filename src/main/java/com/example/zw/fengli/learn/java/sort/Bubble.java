package com.example.zw.fengli.learn.java.sort;

public class Bubble {


    public static void main(String[] args) {

        int[] array=new int[]{7,9,3,6,1,12};
        System.out.println(array);
        print(array);
        baseSort(array);
        print(array);


    }

    /**
     * 冒泡排序
     * @param array
     * @return
     */
    public static int[] baseSort(int[] array) {

        for(int i=0;i<=array.length-1;i++){
            for(int j=i+1;j<=array.length-1;j++){
                if (array[i] > array[j]) {
                    int temp=array[i];
                    array[i]=array[j];
                    array[j]=temp;
                }
            }
            System.out.println("第"+(i+1)+"次排序：");
            print(array);
        }
        return array;

    }

    public static void print(int[] array){
        for(int a:array){
            System.out.print(a);
            System.out.print(" ");
        }
        System.out.println();
    }


}
