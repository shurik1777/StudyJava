//import java.util.Scanner;
//public class Program {
//    public static void main(String[] args) {
//        Scanner iScanner = new Scanner(System.in);
//        System.out.printf("int a: ");
//        int x = iScanner.nextInt();
//        System.out.printf("double a: ");
//        double y = iScanner.nextDouble();
//        System.out.printf("%d + %f = %f", x, y, x + y);
//        iScanner.close();
//    }}

//import java.util.Scanner;
//
//public class Program {
//    public static void main(String[] args) {
//        Scanner iScanner = new Scanner(System.in);
//        System.out.printf("int a: ");
//        boolean flag = iScanner.hasNextInt();
//        System.out.println(flag);
//        int i = iScanner.nextInt();
//        System.out.println(i);
//        iScanner.close();
//    }
//}
//public class Program {
//    public static void main(String[] args) {
//        int a = 1, b = 2;
//        int c = a + b; // тс
//        String res = a + " + " + b + " = " + c;
//        System.out.println(res);
//    }
//}
//
//public class Program {
//    public static void main(String[] args) {
//        int a = 1, b = 2;
//        int c = a + b;
//        String res = String.format("%d + %d = %d \n", a, b, c);
//        System.out.printf("%d + %d = %d \n", a, b, c);
//        System.out.println(res);
//    }
//}
//public class Program {
//    public static void main(String[] args) {
//
//        float pi = 3.1415f;
//        System.out.printf("%f\n", pi); // 3,141500
//        System.out.printf("%.2f\n", pi); // 3,14
//        System.out.printf("%.3f\n", pi); // 3,141
//        System.out.printf("%e\n", pi); // 3,141500e+00
//        System.out.printf("%.2e\n", pi); // 3,14e+00
//        System.out.printf("%.3e\n", pi); // 3,141e+00
//    }
//}
/*Область видимости переменных
        У переменных существует понятие «область видимости».
        Если переменную объявили внутри некоторого блока фигурных скобок { },
        то снаружи этого блока переменная будет недоступна.
*/
//public class Program {
//    public static void main(String[] args) {
//        {
//            int i = 123;
//            System.out.println(i);
//        }
//        System.out.println(i); // error: cannot find symbol
//    }
////}
//public class Program {
//    static void sayHi() {
//        System.out.println("hi!");
//    }
//
//    static int sum(int a, int b) {
//        return a + b;
//    }
//
//    static double factor(int n) {
//        if (n == 1) return 1;
//        return n * factor(n - 1);
//    }
//
//    public static void main(String[] args) {
//        sayHi(); // hi!
//        System.out.println(sum(1, 3)); // 4
//        System.out.println(factor(5)); // 120.0
//    }
//}

import java.io.FileWriter;
import java.io.IOException;

public class Program {
    public static void main(String[] args) {
        try (FileWriter fw = new FileWriter("file.txt", false)) {
            fw.write("line 1");
            fw.append('\n');
            fw.append('2');
            fw.append('\n');
            fw.write("line 3");
            fw.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}