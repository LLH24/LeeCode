package CharString;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class InvertString {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length-1;
        while(left<right){
            char temp =s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
