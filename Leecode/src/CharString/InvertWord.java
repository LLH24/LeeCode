package CharString;

public class InvertWord {
    /***
     * 单词反转
     * 1.首尾和中间多余空格去除
     * 2.全部反转
     * 3.对单词进行反转
     *
     *StringBuilder > StringBuffer > String
     * StringBuffer 是多线程安全的
     *
     * // string ----> stringbuffer
     * 		String s = "123";
     * 		StringBuffer sb  = new StringBuffer(s);
     * 		System.out.println("StringBuffer "+sb);
     * // stringbufffer ---- string
     * 		StringBuffer sb1 = new StringBuffer("hello");
     * 		String ss = sb1.toString();
     * 		System.out.println("string "+ss);
     *
     * @param
     * @return
     */
    public static String reverseWords(String s) {
        StringBuilder  res = deleteNull(s);
        res = invertString(res,0,res.length()-1);
        return invertWords(res);
    }

    public static StringBuilder deleteNull(String s){//去除多余空格
        StringBuilder stringBuilder = new StringBuilder();
        int start = 0;
        int end = s.length()-1;
        while(s.charAt(start) == ' ') start++;
        while(s.charAt(end) == ' ') end--;
        for (int i = start; i <= end; i++) {//将非空格都放入，当遇到空格时，只要前面不是空格就可以继续加入
            if(s.charAt(i) != ' ' || s.charAt(i-1) != ' ') stringBuilder.append(s.charAt(i));
        }
        return stringBuilder;
    }

    public static StringBuilder invertString(StringBuilder s ,int start,int end){
        while(start < end){
            char temp = s.charAt(start);
            s.setCharAt(start, s.charAt(end));
            s.setCharAt(end,temp);
            start++;
            end--;
        }
        return s;
    }

    public static String invertWords(StringBuilder s){
        int start = 0;
        int end = 0;
        while(end <= s.length()){
            if(end == s.length()||s.charAt(end) == ' '){
                invertString(s,start,end - 1);
                start = end+1;
            }
            end++;
        }
        return new String(s);
    }
}
