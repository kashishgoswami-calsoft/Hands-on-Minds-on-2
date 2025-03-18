import java.util.ArrayList;
// import java.util.Scanner;

public class IntegerLadder {
    
    // Function to find the greatest common divisor (GCD)
    public static int gcd(int a, int b) {
        while (a != 0) {
            int temp = a;
            a = b % a;
            b = temp;
        }
        return b;
    }

    public static void main(String[] args) {
        // Scanner scanner = new Scanner(System.in);
        // System.out.print("Enter limit: ");
        // int limit = scanner.nextInt();
        // scanner.close();
        int limit =1000000;

        ArrayList<ArrayList<Integer>> sides = new ArrayList<>(limit);
        for (int i = 0; i < limit; i++) {
            sides.add(new ArrayList<>());
        }

        // Generate all Pythagorean triples
        for (int m = 2; m * m < limit; m++) {
            for (int n = (m % 2) + 1; n < m; n += 2) {
                if (gcd(m, n) != 1) continue; // Only valid (m, n)

                // Compute basic Pythagorean triple
                int a = m * m - n * n;
                int b = 2 * m * n;
                int c = m * m + n * n;

                // Generate all multiples of the triple
                for (int k = 1; k * c < limit; k++) {
                    sides.get(k * a).add(k * b);
                    sides.get(k * b).add(k * a);
                }
            }
        }

        int count = 0;

        // Process all triangles with one identical side (width of the street)
        for (ArrayList<Integer> current : sides) {
            int size = current.size();
            for (int left = 0; left < size; left++) {
                for (int right = left + 1; right < size; right++) {
                    long X = current.get(left);
                    long Y = current.get(right);

                    // Check the condition
                    if ((X * Y) % (X + Y) == 0) {
                        count++;
                    }
                }
            }
        }

        // Display the result
        System.out.println(count);
    }
}
