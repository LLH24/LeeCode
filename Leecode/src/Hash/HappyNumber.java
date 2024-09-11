package Hash;

import java.util.HashSet;

/***
 * 判断是否是快乐数
 * 我的算法，算个位十位等的和，写的太丑了
 */
public class HappyNumber {
    public static boolean isHappy(int n) {
        int sum = 0;
        int gaowei = n / 10;
        int yuwei = n % 10;
        HashSet<Integer> integers = new HashSet<>();
        while (true) {
            while (gaowei != 0) {
                int temp = gaowei;
                sum += yuwei * yuwei;
                gaowei = temp  / 10;
                yuwei = temp  % 10;
            }
            sum += yuwei * yuwei;
            gaowei = sum / 10;
            yuwei = sum % 10;
            if (sum == 1){
                return true;
            }
            if (integers.contains(sum)){
                return false;
            }else integers.add(sum);
            sum = 0;
        }
    }
}
