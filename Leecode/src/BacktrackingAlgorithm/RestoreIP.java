package BacktrackingAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class RestoreIP {
    List<String> results = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        char[] charArray = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        findResult(charArray,0,0,stringBuilder);
        return results;
    }

    public void findResult(char[] charArray,int start,int level,StringBuilder stringBuilder){
        if (level == 3 && charArray.length-start > 3) return;
        if (level == 4 && stringBuilder.length() == charArray.length+4) {//带.到这一层，先进行判断长度,必须满足长度和深度的要求才行
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
            results.add(new String(stringBuilder));
            return;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        /*
        得写在这儿,才能保证，每一层的值是相同的这个东西相加
         */
        for (int i = start; i < Math.min(start + 3 , charArray.length) ; i++) {//每次最多3个
            //最后一段要是还剩下4个或者更多数字，直接返回,或者后面的数字加起来>255，也是直接返回
            if(level == 3){
                if (charArray.length-start > 3) break;
                int value = 0;
                for (int j = start; j < Math.min(start + 3 , charArray.length); j++) {
                    value += (charArray[j] - '0');
                }
                if (value > 255) break;
            }
            //下面一段第一个为0，那必须以0为段
            if (charArray[start] == '0') {
                stringBuilder.append("0.");
                findResult(charArray,start+1,level+1,new StringBuilder(stringBuilder));
                break;
            }
            Integer localValue = Integer.valueOf(localStringBuilder.append(charArray[i]).toString());
            if (localValue > 255) return;
            stringBuilder.append(charArray[i]);
            stringBuilder.append('.');
            findResult(charArray,i+1,level+1,new StringBuilder(stringBuilder));
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
    }
}
