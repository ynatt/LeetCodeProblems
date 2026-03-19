package vel.vn;

import java.util.stream.IntStream;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println(addStrings("11", "123"));
    }

    public static String addStrings(String num1, String num2) {
        String biggerNumber = num1.length() > num2.length() ? num1 : num2;
        String smallerNumber = num1.length() > num2.length() ? num2 : num1;
        int digit1;
        int digit2;
        int j = smallerNumber.length() - 1;
        StringBuilder result = new StringBuilder();
        int sum;
        boolean over = false;
        for(int i = biggerNumber.length() - 1; i >= 0 ; i--, j--) {
            digit1 = biggerNumber.charAt(i) - '0' + (over ? 1 : 0);
            over = false;
            if(j >= 0) {
                digit2 = smallerNumber.charAt(j) - '0';
            } else {
                digit2 = 0;
            }
            sum = digit1 + digit2;
            if (sum > 9) {
                sum = sum - 10;
                over = true;
            }
            result.append(sum);
        }

        if(over) result.append('1');
        return result.reverse().toString();
    }

    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int f = 0;
        int l = s.length() - 1;
        char ch;
        while(f < l) {
            ch = s.charAt(f);
            while (!isVovel(ch) && f < l){
                f++;
                ch = s.charAt(f);
            }
            ch = s.charAt(l);
            while (!isVovel(ch) && f < l){
                l--;
                ch = s.charAt(l);
            }
            //System.out.println(f + " " + l);
            chars[l] = chars[f];
            chars[f] = ch;
            f++;
            l--;
        }

        return new String(chars);
    }

    public boolean isVovel(char ch) {
        return ch ==  'a' || ch ==  'A' || ch ==  'e' || ch ==  'E' || ch ==  'i' || ch ==  'I' || ch ==  'o' || ch ==  'O' || ch ==  'u' || ch ==  'U';
    }
}