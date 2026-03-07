//javac test.java;java test
public class test {

    static int square(int x) {
        return x * x;
    }

    public static void main(String[] args) {

        int a = 5;
        double b = 3.14;
        String name = "Java";
        boolean flag = true;

        if (flag) {
            System.out.println(name + " square: " + square(a));
        }

        for (int i = 0; i < 3; i++) {
            System.out.println("i = " + i);
        }
    }
}
