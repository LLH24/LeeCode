import DynamicProgramming.DifferentPaths;
import DynamicProgramming.DifferentPathsII;
import DynamicProgramming.TargetSum;
import DynamicProgramming.WordSplitting;
import GreedyAlgorithm.DistributeCandies;
import GreedyAlgorithm.DivideLetterIntervals;
import GreedyAlgorithm.IgniteBalloonMinimumArrows;
import GreedyAlgorithm.ReconstructQueueBasedOnHeight;

import java.util.LinkedList;

//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        WordSplitting wordSplitting = new WordSplitting();
        LinkedList<String> strings = new LinkedList<>();
        strings.add("leet");
        strings.add("code");
        wordSplitting.wordBreak("leetcode",strings);
    }
}