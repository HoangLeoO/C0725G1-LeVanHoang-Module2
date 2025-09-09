package ss2_java_loop.bai_tap;

public class IsFirstPrime {
    public static void main(String[] args) {
        int count = 0;
        int n = 2; // số bắt đầu kiểm tra

        while (count < 20) {
            boolean isPrime = true;

            // kiểm tra n có phải số nguyên tố
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                count++;
                System.out.println("Prime " + count + ": " + n);
            }

            n++;
        }
    }
}
