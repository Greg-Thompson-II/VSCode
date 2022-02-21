//Created to test result of preincrement and operational values

public class testIncrement {
    public static void main(String args[]) {
        int a = 20;
        a += a + ++a;
        System.out.println(a);
    }
}
