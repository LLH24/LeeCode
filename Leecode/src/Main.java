import DynamicProgramming.DifferentPaths;
import DynamicProgramming.DifferentPathsII;
import GreedyAlgorithm.DistributeCandies;
import GreedyAlgorithm.DivideLetterIntervals;
import GreedyAlgorithm.IgniteBalloonMinimumArrows;
import GreedyAlgorithm.ReconstructQueueBasedOnHeight;

//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        DifferentPathsII differentPathsII = new DifferentPathsII();
        System.out.println(differentPathsII.uniquePathsWithObstacles(new int[][]{{0,1},{0,0}
        }));
    }
}