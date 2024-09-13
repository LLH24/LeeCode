package GreedyAlgorithm;

public class LemonWaterChange {
    /***
     * 柠檬水找零
     * 一杯5
     * 给的钱只有5，10，20
     * 换20的时候，就是先10，再5，因为5更万能
     * @param bills
     * @return
     */
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        int twenty = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                five++;
            }else if (bills[i] == 10){
                if(five == 0) return false;
                ten++;
                five--;
            }else if (bills[i] == 20){
                if (ten == 0){
                    if (five < 3) return false;
                    five -= 3;
                    twenty++;
                }else {
                    if (five == 0) return false;
                    five--;
                    ten--;
                    twenty++;
                }
            }
        }
        return true;
    }
}
