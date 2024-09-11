package CharString;

public class ReverseString {
    /***
     * char[] charArray = {'a', 'b', 'c'};
     * String str = new String(charArray); // 使用String类的构造函数
     * String str2 = String.valueOf(charArray); // 使用String类的静态方法
     * 不能使用char[].toString()，这个是按照object的toString方法进行返回,Object类中的toString()方法返回该对象的字符串表示形式。
     * java.lang.Object@1a2b3c4d的形式，其中java.lang.Object是对象的类名，1a2b3c4d是对象的哈希码的十六进制表示。
     * @param s
     * @param k
     * @return
     */
    public  String reverseStr(String s, int k) {
        char[] charArray = s.toCharArray();
        int index = 0;
        if (charArray.length % (2 * k) < k) {
            for (int i = 2*k - 1; i < charArray.length; i += 2 * k) {
                reverse(charArray, index, index / 2 + i / 2);
                index = i+1;
            }
            reverse(charArray,index,charArray.length-1);
        }else {
            for (int i = 2*k - 1; i < charArray.length; i += 2 * k) {
                reverse(charArray, index, index / 2 + i / 2);
                index = i+1;
            }
            reverse(charArray,index,index+k-1);
        }
        return new String(charArray);
    }

    public  char[] reverse(char[] s, int start, int end) {
        int left = start;
        int right = end;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
        return s;
    }
}
