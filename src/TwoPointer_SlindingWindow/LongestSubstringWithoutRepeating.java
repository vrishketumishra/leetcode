package TwoPointer_SlindingWindow;

import java.util.Arrays;

public class LongestSubstringWithoutRepeating {
    static void main() {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
        public static int lengthOfLongestSubstring(String s) {
            int[] hash=new int[256];
            Arrays.fill(hash,-1);
            int n=s.length();
            int l=0;
            int r=0;
            int maxlen=0;
            while(r<n){
                if(hash[s.charAt(r)]!=-1){
                    if(hash[s.charAt(r)]>=l){
                        l=hash[s.charAt(r)]+1;
                    }
                }
                int len=r-l+1;
                maxlen=Math.max(len,maxlen);
                hash[s.charAt(r)]=r;
                r++;
            }
            return maxlen;
        }

}
