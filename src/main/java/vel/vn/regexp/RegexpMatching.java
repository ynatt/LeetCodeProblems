package vel.vn.regexp;

public class RegexpMatching {
    Boolean[][] memo;
    String text;
    String pattern;

    /**
     * https://leetcode.com/problems/regular-expression-matching/
     * Hard
     */
    public boolean isMatch(String text, String pattern) {
        this.text = text;
        this.pattern = pattern;
        memo = new Boolean[text.length() + 1][pattern.length() + 1];
        return dp(0, 0);
    }

    public void toString(Boolean[][] matrix) {
        for(int i = 0; i < matrix[0].length; i++) {
            for(int j = 0; j < matrix.length; j++) {
                System.out.print((matrix[j][i] == null ? "-" : (matrix[j][i] ? "T" : "F")) + " ");
            }
            System.out.println();
        }
    }

    public boolean dp(int i, int j) {
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        boolean res, match;
        if (j == pattern.length()){
            res = i == text.length();
        } else{
            match = i < text.length() && (pattern.charAt(j) == text.charAt(i) || pattern.charAt(j) == '.');
            if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*'){
                res = dp(i, j + 2) || (match && dp(i + 1, j));
            } else {
                res = match && dp(i + 1, j + 1);
            }
        }
        memo[i][j] = res;
        System.out.println("i = " + i + " j = " + j);
        toString(memo);
        return res;
    }
}
