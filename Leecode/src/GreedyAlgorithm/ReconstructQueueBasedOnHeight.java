package GreedyAlgorithm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class ReconstructQueueBasedOnHeight {
    /***
     * 根据身高重新排列
     * 有点意思，根据身高高到低排序，后面序号是几就插到几，交换位置
     * @param people
     * @return
     */
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {//这竟然是合法的，因为int[]是对象，本身不是基本数据类型
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2 [0]) return o1[1] - o2[1];
                return o2[0] - o1[0];
            }
        });
        LinkedList<int[]> ints = new LinkedList<>();
        for (int i = 0; i < people.length; i++) {
            ints.add(people[i][1],people[i]);
        }
        return ints.toArray(new int[people.length][]);//这里是为什么呢，其他的好像都可以，就是这里必须这样
    }
}
