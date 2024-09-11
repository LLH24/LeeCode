package CharString;

import java.util.Scanner;

public class ReplaceNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        System.out.println(replace(s));
        scanner.close();
    }
    
    public static String replace(String s){
        int count = 0;
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            if(Character.isDigit(c)) count++;
        }
        char[] newCharArray = new char[charArray.length+count*5];
        System.arraycopy(charArray,0,newCharArray,0,charArray.length);
        for (int i = charArray.length-1,j = newCharArray.length-1;i<j;j--,i--){
            if (!Character.isDigit(charArray[i]))  newCharArray[j] = charArray[i];
            else {
                newCharArray[j] = 'r';
                newCharArray[j-1] = 'e';
                newCharArray[j-2] = 'b';
                newCharArray[j-3] = 'm';
                newCharArray[j-4] = 'u';
                newCharArray[j-5] = 'n';
                j-=5;
            }
        }
        return new String(newCharArray);
    }
}
