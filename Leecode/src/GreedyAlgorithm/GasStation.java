package GreedyAlgorithm;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sumGas = 0;
        int sumCost = 0;
        for (int i = 0; i <gas.length; i++) {
            sumGas += gas[i];
            sumCost += cost[i];
        }
        if (sumGas < sumCost){
            return -1;
        }else {
            int trueSumGas = 0;
            for (int i = 0; i < gas.length; i++) {
                if (i == gas.length-1) return gas.length-1;
                for (int j = 0+i; j < i + gas.length ; j++) {
                    j = j%gas.length;
                    trueSumGas += gas[j];
                    trueSumGas -= cost[j];
                    if (trueSumGas < 0) {
                        trueSumGas = 0;
                        i = j;
                        break;
                    }
//                    if (j == i-1){//到左边，其实很好，但是可能是首位
//                        return i;
//                    }
                    if((j+1) % gas.length == i) return i;

                }
            }
        }
        return -1;
    }
}
