package testing;

public class While {
    public static void main(String[] args){
        int n = 10;
        int res = sumUpTo(n);
        System.out.println(res);

    }

    public static int sumUpTo(int n){
        int i = 1;
        int sum = 0;
        while (i < n+1) {
            sum = sum + i;
            i = i + 1;
        }
        return sum;
    }




}
