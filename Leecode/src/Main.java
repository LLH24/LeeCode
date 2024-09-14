import GreedyAlgorithm.DistributeCandies;
import GreedyAlgorithm.ReconstructQueueBasedOnHeight;

//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        ReconstructQueueBasedOnHeight reconstructQueueBasedOnHeight = new ReconstructQueueBasedOnHeight();
        reconstructQueueBasedOnHeight.reconstructQueue(new int[][]{{7,0}, {4,4},{7,1},{5,0}, {6,1}, {5,2}});

    }
}