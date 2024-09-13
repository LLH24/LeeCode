package GreedyAlgorithm;

public class DistributeCandies {
    /***
     * 分发糖果
     * //左右两次循环，否则很难思考全面
     * 因为最低点肯定是1，往左往右都是+1，所以只记录加的就可以
     * @param ratings
     * @return
     */
    public int candy(int[] ratings) {
        int result = 0;
        int[] candy = new int[ratings.length];
        candy[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            candy[i] = 1;
            if (ratings[i] > ratings[i-1]){//第一次的时候，不用判断后面是不是比前面高
                candy[i] = candy[i-1] +1;
            }
        }
        // 第二次要记录糖果数量，且要判断前面的糖果可能本身就比我高1353，这样不用修改糖果数量
        result += candy[candy.length-1];
        for (int i = ratings.length-2; i >-1 ; i--) {
            if (ratings[i] > ratings[i+1] && candy[i] <= candy[i+1]){
                candy[i] = candy[i+1] + 1;
            }
            result +=candy[i];
        }
        return result;
    }
}
