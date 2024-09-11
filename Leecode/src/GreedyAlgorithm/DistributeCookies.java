package GreedyAlgorithm;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class DistributeCookies {
    /***
     * 分发饼干
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
//        Integer[] S = (Integer[]) Arrays.stream(s).boxed().toArray();
//        Arrays.sort(S,(o1,o2) -> o2-o1);
        //泛型不能用int，必须用包装类,new Comparator 也不行，因为后面跟的是泛型
        Arrays.sort(s);
        Arrays.sort(g);
        int count = 0;
        int startIndex = g.length-1;
        for (int i = s.length-1; i >= 0; i--) {
            if (s[i] < g[0]) return count;
            if (count == g.length) return count;
            for (int j = startIndex; j >=0; j--) {
                if(s[i] >= g[j]) {
                    count++;
                    startIndex = j-1;
                    break;
                }
            }
        }
        return count;
    }
}
