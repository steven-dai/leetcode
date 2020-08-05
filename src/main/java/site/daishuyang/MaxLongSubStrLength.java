package site.daishuyang;

/**
 * 找出其中不含有重复字符的 最长子串 的长度
 */
public class MaxLongSubStrLength {

    public static void main(String[] args) {
        String param = "pwwkew";
        System.out.println(solution(param));
    }

    public static int solution(String param) {
        if (param == null) {
            return 0;
        }
        if (param.length() < 2) {
            return param.length();
        }
        char[] paramCharArray = param.toCharArray();
        // 当前最大长度
        int maxLength = 1;
        // 当前起始位置
        int startAt = 0;
        // 临时变量
        int temp = startAt;
        // 遍历
        for (int i = 1; i < paramCharArray.length; i++) {
            // 循环字符
            char paramChar = paramCharArray[i];
            // 循环字符和之前的字符比较
            for (int j = startAt; j < i; j++) {
                char subChar = paramCharArray[j];
                if (paramChar == subChar) {
                    // 两者相等
                    temp = j + 1;
                }
            }
            startAt = temp;
            maxLength = (i - startAt + 1) > maxLength ? (i - startAt + 1) : maxLength;
        }
        return maxLength;
    }
}