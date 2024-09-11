package Hash;

import java.util.ArrayList;
import java.util.HashSet;

public class IntersectionOfTwoArrays {
    /***
     * 求两个数组的交集
     * 方法一：用数组的hash方法对交集进行处理，保存进入集合，再将集合变为数组
     * return resSet.stream().mapToInt(x -> x).toArray();这个可以研究下
     * 方法二：直接用hashset去判断，后面步骤相同
     * 直接用数组的方法，会比hashset更快速，set把数值映射到key上都要做hash计算的
     * 如果数组的大小可以知道就用数组的方式，不知道就用set的方式
     *
     * 以下为方法1：数组方法
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersection(int[] nums1, int[] nums2) {
        int[] ints = new int[1000];
        int[] intInt = new int[1000];
        ArrayList<Integer> integers = new ArrayList<>();

        for (int i = 0; i < nums1.length; i++) {
            ints[nums1[i] - 0]++;
        }
        for (int i = 0; i < nums2.length; i++) {
            if (ints[nums2[i] - 0] != 0)
            intInt[nums2[i] - 0]++;
        }
        for (int i = 0; i < intInt.length; i++) {
            if (intInt[i] != 0) {
                integers.add(i);
            }
        }
        int index = 0;
        int[] returnInt = new int[integers.size()];
        for (Integer integer : integers) {
            returnInt[index] = integer;
            index++;
        }
        return returnInt;
    }

    /***
     * 方法二：hashset方法
     * @param nums1
     * @param nums2
     * @return
     */
//    public static int[] intersection(int[] nums1, int[] nums2) {
//        HashSet<Integer> integers = new HashSet<>();
//        HashSet<Integer> integersA = new HashSet<>();
//        for (int i = 0; i < nums1.length; i++) {
//            integers.add(nums1[i]);
//        }
//
//        for (int i = 0; i < nums2.length; i++) {
//            if (integers.contains(nums2[i])){
//                integersA.add(nums2[i]);
//            }
//        }
//        return integersA.stream().mapToInt(x -> x).toArray();
//    }
}
