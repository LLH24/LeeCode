package CharString;

/***
 * 查找某串字符中，我们需要的字符在哪个位置开始
 * 很有意思啊，难的我头皮发麻
 */
public class StrStr {
    public static int strStr(String haystack, String needle) {
        int[] next = new int[needle.length()];
        getNext(next,needle);
        int j = 0;
        int i = 0;
        while(i<haystack.length()){
            if (haystack.charAt(i) == needle.charAt(j)){
                if (j == needle.length()-1) return i-needle.length()+1;
                i++;
                j++;
            }else {
                if(j != 0) j = next[j-1];
                else i++;
            }
        }return -1;
    }


    public static void getNext(int[] next,String s){
        if (next.length == 0) return;
        int j = 0;
        next[0] = 0;
        for (int i = 1;i<next.length;i++){
            /***
             * 这里是有问题的，我一开始就发现了的
             * 确实有问题，例如"adcadde"这个，就是错误的
             * leecode上收藏了一篇很好的文章
             * 目前是理解了
             * 当不同的时候，我们去找前缀的前面和后缀的后面
             * 这俩最大的相同部分
             * 因为前后缀相同
             * 于是，变为了找前缀的最大公共前后缀
             */
//            while(j>0 && s.charAt(j) != s.charAt(i)){
//                j--;
//            }

            while(j>0 && s.charAt(j) != s.charAt(i)){
                j = next[j - 1];
            }
            if (s.charAt(j) == s.charAt(i)){
                next[i] = j+1;
                j++;
            }
        }
    }
}
