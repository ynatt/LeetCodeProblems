package vel.vn.strings;

public class Strings {

    /**
     * 38. Count and Say (Medium)
     */
    public String countAndSay(int n) {
        if(n == 1) return "1";
        String result = "1";
        for(int i = 1; i < n; i++) {
            result = RLE(result);
        }
        return result;
    }

    public String RLE(String s) {
        StringBuilder result = new StringBuilder();
        char[] chars = s.toCharArray();
        char currentChar = ' ';
        int repeated = 0;
        for(char ch : chars) {
            if(currentChar != ch) {
                if(currentChar != ' ') {
                    result.append(repeated).append(currentChar);
                }
                currentChar = ch;
                repeated = 1;
            } else {
                repeated++;
            }
        }
        result.append(repeated).append(currentChar);
        return result.toString();
    }
}
