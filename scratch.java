import java.util.ArrayList;
import java.util.List;

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