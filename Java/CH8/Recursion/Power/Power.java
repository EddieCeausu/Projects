public class Power {
    public static int power(int b, int e) {
        if(e == 0) return 1;
        return b * power(b, e-1);
    }
    public static void main(String args[]) {
        int base, exp, answer;
        base = Integer.parseInt(args[0]);
        exp = Integer.parseInt(args[1]);
        answer = power(base, exp);
        System.out.println(answer);
    }
}
