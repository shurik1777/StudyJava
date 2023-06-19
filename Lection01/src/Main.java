/*


 */
public class Main {
    public static void main(String[] args) {
//        boolean f = true ^ false;
//        var a = 123;
//        System.out.println(a);
//        var d = 123.456;
//        System.out.println(d);
//        System.out.println(getType(a));
//        System.out.println(getType(d));
//        d = 1022;
//        System.out.println(d);
////        d = "mistake";
//        var i = 12_321_123 ;
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Integer.MIN_VALUE);
//        int w = 123;
//        w++;
//        System.out.println(++w);
//        w = w-- - --w;
//        w = --w-w--;
//        System.out.println(w);
//        String s = "qwer";
//        boolean b = s.length() >= 5 && s.charAt(4) == '1';
//        boolean b = s.length() >= 5 & s.charAt(4) == '1';
//        boolean a = true;
//        boolean b = true;
//        int a = 5;
//        int b = 2;
//
//        System.out.println(a | b);
//        System.out.println(a & b);
//        System.out.println(a ^ b);
//        System.out.println(a & b);
//        System.out.println(a && b);
//        int[] arr = new int[10];
//        arr[3] = 13;
//        System.out.println(arr[3]);
//        int[] arr[] = new int[3][5];
//        for (int[] line : arr) {
//            for (int item : line) {
//                System.out.printf("%d", item);
//            }
//            System.out.println();
//        int i = 123; double d = i;
//        System.out.println(i);
//        System.out.println(d);
//        d = 3.1415; i = (int)d;
//        System.out.println(d);
//        System.out.println(i);
//        d = 3.9415; i = (int)d;
//        System.out.println(d);
//        System.out.println(i);
//        byte b = Byte.parseByte("123");
//        System.out.println(b);
//        b = Byte.parseByte("1234");
//        System.out.println(b); // NumberFormatException: Value out of range
        byte b = Byte.parseByte("12"); // от 0 до 255 - выше уже ошибка
        System.out.println(b);



        }



    static String getType(Object o) {
        return o.getClass().getSimpleName();
    }
}

