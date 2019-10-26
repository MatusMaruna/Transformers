public class Test { 

public static void main(String[]args){
    char[] charArr = {'a','b','c','d','e','f'};
    printArray(charArr);



}


    static void printArray(char[] arr) {
        System.out.print(arr[0]);
        int i = 0;
        while(i<arr.length) {
            char c = arr[i];
            System.out.print(" ");
           System.out.print(c);
            i = i + 1;
        }
        System.out.println("");
    }












}