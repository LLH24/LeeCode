package DynamicProgramming;

public class TheWeightLastStoneII {
    /***
     * 最后一块石头的重量
     * 分成两部分，最好的结果是一半一半，没有达到的话，就是对冲比如一个13，一个14，那就剩下1；
     * 只需要到sum的一半，无论是不是偶数
     * 都用sum-2*target下的最大值
     * @param stones
     * @return
     */
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int i = 0; i < stones.length; i++) {
            sum += stones[i];
        }
        int target = sum/2;
        int[] bp =new int[target+1];
        for (int i = 0; i < stones.length; i++) {
            for (int j = target; j >= 0; j--) {
                if(j >= stones[i])bp[j] = Math.max(bp[j],bp[j-stones[i]]+stones[i]);
            }
        }
        return sum-2*bp[target];
    }
}
