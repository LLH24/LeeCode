import DynamicProgramming.*;
import GreedyAlgorithm.DistributeCandies;
import GreedyAlgorithm.DivideLetterIntervals;
import GreedyAlgorithm.IgniteBalloonMinimumArrows;
import GreedyAlgorithm.ReconstructQueueBasedOnHeight;
import Hot100.*;

import java.util.LinkedList;

//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        lruCache.get(1);
        lruCache.put(3,3);
        lruCache.get(2);
    }
}