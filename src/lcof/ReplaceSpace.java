package lcof;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 */

/**
 * xxzuo
 * 面试题05. 替换空格
 * 2020/5/23
 */
public class ReplaceSpace {
    public String replaceSpace(String s) {
        StringBuilder res = new StringBuilder();
        for(char c : s.toCharArray()){
            if(c == ' ')
                res.append("%20");
            else
                res.append(c);
        }
        return res.toString();
    }
}
