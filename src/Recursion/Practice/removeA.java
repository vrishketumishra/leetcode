package Recursion.Practice;

public class removeA {
    public static void main() {
        System.out.println(skip("bbadasafgfssffaaa"));
    }
    static String skip( String up){
    if(up.isEmpty()){
        return "";
    }
    char ch=up.charAt(0);
    if(ch=='a'){
      return skip( up.substring(1));
    } else {
       return ch + skip( up.substring(1));
       //hey your going up add my answer as well
    }
    }
    //return string in every function call
}
