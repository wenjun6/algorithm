package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *假定需要速记的内容记作字符串 word，速记员小明遵循特殊的缩写规则：连续子串将可缩写为其长度。注意：
 * 1). 小明可选择内容是否被缩写；
 * 2). 小明可选择内容中共有几处被缩写，但每两处缩写不能相邻。
 *
 * 请返回字符串 word 的缩写之后长度为 limit 的所有方案。
 *
 * 注意：输出的顺序并不重要。
 *
 * 示例 1：
 *
 * 输入: word = "hello", limit = 3
 * 输出: ["3l1","3lo","2l2","1e3","h3o","he3"]
 *
 * 示例 2：
 *
 * 输入: word = "sea", limit = 3
 * 输出: ["1e1","1ea","s1a","se1","sea"]
 *
 * 提示：
 *
 * 1 <= word.length <= 15 且仅包含小写字符
 * 1 <= limit <= word.length
 */
class Scratch {
    public static void main(String[] args) {
        String word = "hello";
        int limit = 3;
        String[] strings = abridgeWord(word, limit);
        for(String s:strings){
            System.out.println(s);
        }
    }

    public static String[] abridgeWord(String word,int limit){
        int n = word.length();
        List<String> res = new ArrayList<String>();
        StringBuffer sb = new StringBuffer();

        for(int i=0;i<(1<<n);i++){
            int last = -1;
            sb.delete(0,sb.length());
            int j=0;
            while(j<n){
                if((i & (1<<j))!=0){
                    if(last + 1 == j){
                        sb.append(word.charAt(j));
                    }else if(last ==-1){
                        sb.append(j + "" + word.charAt(j));
                    }else if(j - last >1){
                        sb.append(j-last -1+""+word.charAt(j));
                    }
                    last = j;
                    if(sb.length() > limit){
                        break;
                    }
                }
                j++;
            }
            if(last<n-1){
                sb.append(n-1-last+"");
            }
            if(sb.length()==limit){
                res.add(sb.toString());
            }
        }
        return res.toArray(new String[res.size()]);
    }
}