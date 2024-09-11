package Hash;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FourNumberSum {
    /***
     * 该题只要求统计出次数，没有要求一定要求出（i,j,k,l）元组
     *
     *
     * 有一个最简单的方法，就是4个一起遍历（0001）（0002）到（nnnn）时间是n^4太差
     * 法二：
     * A和B分组，C和D分组对分好的组再进行组合，时间为3n^2
     * @param nums1
     * @param nums2
     * @param nums3
     * @param nums4
     * @return
     */

    //法二：第一种写法，需要再多查询一遍
//    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
//        HashMap<Integer, Integer> integerIntegerHashMapA = new HashMap<>();
//        HashMap<Integer, Integer> integerIntegerHashMapB = new HashMap<>();
//        int res = 0;
//        for (int i = 0; i < nums1.length; i++) {
//            for (int j = 0; j < nums1.length; j++) {
//                integerIntegerHashMapA.put(nums1[i]+nums2[j],integerIntegerHashMapA.getOrDefault(nums1[i]+nums2[j],0)+1);
//            }
//        }
//
//        for (int k = 0; k < nums1.length; k++) {
//            for (int l = 0; l < nums1.length; l++) {
//                integerIntegerHashMapB.put(nums3[k]+nums4[l],integerIntegerHashMapB.getOrDefault(nums3[k]+nums4[l],0)+1);
//            }
//        }
//
//        Set<Map.Entry<Integer, Integer>> entries = integerIntegerHashMapA.entrySet();//再复习下entryset
//        for (Map.Entry<Integer, Integer> entry : entries) {
//            res +=integerIntegerHashMapB.getOrDefault(0-entry.getKey(),0)*entry.getValue();
//        }
//        return res;
//    }

    //第二种写法，不需要再查询一遍，时间更短
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> integerIntegerHashMapA = new HashMap<>();
        HashMap<Integer, Integer> integerIntegerHashMapB = new HashMap<>();
        int res = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums1.length; j++) {
                integerIntegerHashMapA.put(nums1[i]+nums2[j],integerIntegerHashMapA.getOrDefault(nums1[i]+nums2[j],0)+1);
            }
        }

        for (int k = 0; k < nums1.length; k++) {
            for (int l = 0; l < nums1.length; l++) {//查询CD大组，是否纯在和AB大组组合的组合，如果存在，就和AB的组合个数相
                res+=integerIntegerHashMapA.getOrDefault(0-nums3[k]-nums4[l],0);
            }
        }
        return res;
    }
}
