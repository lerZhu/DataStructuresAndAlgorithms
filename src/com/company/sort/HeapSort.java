package com.company.sort;

import java.util.Arrays;

/**
 * @author zhulei
 * @create 2021-04-15 10:15
 */
public class HeapSort {
    public static void main(String[] args) {
        //要求将数组进行升序
        int[] arr = new int[]{4,6,8,5,9};
        heapSort(arr);
    }

    /**
     * 堆排序
     * @param arr
     */
    public static void heapSort(int[] arr) {

//        adjustHeap(arr,1,arr.length);
//        System.out.println("第一次" + Arrays.toString(arr));
//
//        adjustHeap(arr,0,arr.length);
//        System.out.println("第二次" + Arrays.toString(arr));

        int temp = 0;

        //将无序序列构成一个堆，根据升序还是降序需求选择大顶堆或小顶堆
        //从最后一个非叶子结点开始，从左至右，从下至上进行调整
        //第一个非叶子结点 arr.length / 2 - 1
        for (int i = arr.length / 2 - 1; i >= 0 ; i--) {
            adjustHeap(arr,i,arr.length);
        }

        /*
        将堆顶元素与末尾元素交换，将最大元素沉到数组末端
        重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素
        反复执行调整+交换步骤，直到整个序列有序
         */
        for (int j = arr.length - 1; j > 0 ; j--) {
            //交换
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr,0,j);
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 将一个数组（二叉树），调整成一个大顶堆
     *
     * @param arr 待调整的数组
     * @param i 表示非叶子结点在数组中的索引
     * @param length 对多少个元素进行调整，length在逐渐减少
     */
    public static void adjustHeap(int[] arr,int i,int length) {
        //先取出当前元素的值，保存在零时变量
        int temp = arr[i];

        //k = i * 2 + 1是i节点的左子节点
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            //左子节点的值小于右子节点的值
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                //k指向右子节点
                k++;
            }
            //如果右子节点大于当前节点
            if (arr[k] > temp) {
                //把较大值赋给当前节点
                arr[i] = arr[k];
                //i指向k，继续循环比较
                i = k;
            }else {
                break;
            }
        }

        //当for循环结束后，我们已经将以i为父节点的树的最大值，放在了最顶部
        arr[i] = temp;
    }
}
