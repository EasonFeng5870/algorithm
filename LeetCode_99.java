package leetcode;

/**
 * https://leetcode-cn.com/problems/decode-ways
 *
 * @author eason.feng at 2019/12/25/0025 11:45
 **/
public class LeetCode_99 {

    public int numDecodings(String s) {

        if (s == null || "".equals(s)) {
            return 0;
        }

        if (s.length() == 1) {
            if ("0".equals(s)) {
                return 0;
            }
            else {
                return 1;
            }
        }
        int len = s.length();
        int factor = 1;
        int last = "0".equals(s.charAt(len - 1)) ? 0 : 1;
        for (int i = len - 2; i >= 0; i--) {
            if ("0".equals(s.charAt(i))) {
                factor = last;
                last = 0;
                continue;
            }
            if (((s.charAt(i) - '0') * 10) + (s.charAt(i + 1) - '0') > 26) {
                last = factor;
            }
            else {
                int sum = last + factor;
                factor = last;
                last = sum;
            }
        }
        return last;
    }

}
