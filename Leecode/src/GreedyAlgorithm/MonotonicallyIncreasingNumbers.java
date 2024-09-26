package GreedyAlgorithm;

public class MonotonicallyIncreasingNumbers {
    /***
     * 单调递增的数字
     * @param n
     * @return
     */

    //法一，需要多次调用Integer.valueOf方法，效率低
//    public int monotoneIncreasingDigits(int n) {
//        String[] split = (n + "").split("");
//        int start = split.length;
//        for (int i = split.length-2; i >= 0 ; i--) {
//            if (Integer.valueOf(split[i]) > Integer.valueOf(split[i+1])){
//                split[i] = Integer.parseInt(split[i]) -1+"";
//                start = i;
//            }
//        }
//        for (int i = start+1; i < split.length; i++) {
//            split[i] = "9";
//        }
//        return Integer.valueOf(String.join("",split));
//    }

    public int monotoneIncreasingDigits(int n) {
        String s = String.valueOf(n);
        char[] charArray = s.toCharArray();
        int start = charArray.length;
        for (int i = charArray.length-2; i >= 0 ; i--) {
            if (charArray[i] > charArray[i+1]){
                charArray[i] = (char) (charArray[i] - 1 );
                start = i;
            }
        }
        for (int i = start+1; i < charArray.length; i++) {
            charArray[i] = '9';
        }

        return Integer.valueOf(String.valueOf(charArray));
    }
}
