public class Test { 

public static void main(String[]args){
    String s = "Hello";
    char c = s.charAt(0);
    System.out.println(c);



}


    boolean contains(String str, char ch) {
        int i=0;
        while (i<str.length()) {
            char p = str.charAt(i);
            if (p == ch)
                return true;
            i = i+1;
        }
        return false;
    }












}