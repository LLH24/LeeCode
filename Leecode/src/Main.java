import DynamicProgramming.DifferentPaths;
import DynamicProgramming.DifferentPathsII;
import DynamicProgramming.TargetSum;
import GreedyAlgorithm.DistributeCandies;
import GreedyAlgorithm.DivideLetterIntervals;
import GreedyAlgorithm.IgniteBalloonMinimumArrows;
import GreedyAlgorithm.ReconstructQueueBasedOnHeight;

//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        TargetSum targetSum = new TargetSum();
        targetSum.findTargetSumWays(new int[]{7,9,3,8,0,2,4,8,3,9},0);
    }
}