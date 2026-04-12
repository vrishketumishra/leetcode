public class Performance {
    public static void main(String[] args) {
//        String string="";
//        for(int i=0; i<26;i++){
//            char ch = (char)('a'+ i);
//            string=string+ ch;
//        }
//        System.out.println(string);
//IT IS NOT A GOOD SOLUTION AS IT IS CREATING A NEW OBJECT FOR EACH ITERATIONA AND THEN CHECKING SO IT'S
//TIME COMPLEXITY BECOMES O(N^2) RATHER THAN O(N). THUS WE USE STRING BUILDER
        StringBuilder Builder= new StringBuilder();
        for (int i=0;i<26;i++){
            char ch= (char)('a'+i);
            Builder.append(ch);
        }
        System.out.println(Builder.toString());
        Builder.deleteCharAt(3);
        System.out.println(Builder.toString());
    }
}
