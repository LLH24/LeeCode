package BacktrackingAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class CombinatorialSum {
    ArrayList<Integer> combines = new ArrayList<>();
    ArrayList<List<Integer>> results = new ArrayList<>();
    /***
     * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
     * 只使用数字1到9
     * 每个数字 最多使用一次
     *
     * 剪枝的判断：
     * 1.一个是之前的，个数不狗，减掉
     * 2.加起来的和超过需要的和了，减掉
     * @param k
     * @param n
     * @return
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        combineSum(k,n,1,0);
        return results;
    }

    public void combineSum(int k ,int n,int startIndex,int sum){
        if (sum > n) return;
        if (combines.size() == k ){
            if ( n == sum){
                results.add(new ArrayList<>(combines));//不可直接带入conbines，否则无用，因为是对象引用最后全部归零
            }
            return;
        }
        for (int i = startIndex;i <= 10-(k - combines.size()) ;i++){
            combines.add(i);
            combineSum(k,n,i+1,sum += i);
            combines.removeLast();
            sum -= i;
        }
    }
}
