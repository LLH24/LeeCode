package BacktrackingAlgorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combination {
    List<List<Integer>> results = new LinkedList<>();
    List<Integer> result = new ArrayList<>();

    /***
     * 回溯，集合
     * 只删除尾节点的话，用array也是可以的，而且创建的开销小
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        backtracking(n,k,1);
        return results;
    }
    public void backtracking(int n,int k,int index){
        if (result.size() == k){
            results.add(new ArrayList<>(result));//这个类似于复制，而不是直接赋值，这里用array，数组创建的开销比链表小
            return;
        }
        for (int i  = index;i <= n-(k-result.size())+1;i++){//进行剪枝操作,比如我还需要5个，那么后4个不选，倒数第5个可选
            result.add(i);//只删除尾节点的话，用array也是可以的，而且创建的开销小
            backtracking(n,k,i+1);
            result.removeLast();
        }
    }
}
