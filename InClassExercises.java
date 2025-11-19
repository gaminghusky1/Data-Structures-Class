public class InClassExercises {
    public static void main(String[] args) {
//        System.out.println(pow(3, -4));
        System.out.println(getBinary(Integer.MAX_VALUE));
    }

    public static double pow(double x, int n) {
        if (n == 0) return 1;
        if (n < 0) {
            return 1 / (pow(x, -n));
        }
        if (n % 2 == 0) {
            return pow(x * x, n / 2);
        }
        return x * pow(x, n - 1);
    }

    public static String getBinary(int num) {
        if (num == 0) return "0";
        if (num == 1) return "1";
//        return getBinary(num / 2) + num % 2;
        return getBinary(num >> 1) + num % 2;
    }
}
