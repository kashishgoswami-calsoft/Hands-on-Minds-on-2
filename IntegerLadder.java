import java.util.ArrayList;


public class IntegerLadder {
    
   
    public static int gcd(int a, int b) {
        while (a != 0) {
            int temp = a;
            a = b % a;
            b = temp;
        }
        return b;
    }

    public static void main(String[] args) {
       
        int limit =1000000;

        ArrayList<ArrayList<Integer>> sides = new ArrayList<>(limit);
        for (int i = 0; i < limit; i++) {
            sides.add(new ArrayList<>());
        }

      
        for (int m = 2; m * m < limit; m++) {
            for (int n = (m % 2) + 1; n < m; n += 2) {
                if (gcd(m, n) != 1) continue; 

           
                int a = m * m - n * n;
                int b = 2 * m * n;
                int c = m * m + n * n;

               
                for (int k = 1; k * c < limit; k++) {
                    sides.get(k * a).add(k * b);
                    sides.get(k * b).add(k * a);
                }
            }
        }

        int count = 0;

      
        for (ArrayList<Integer> current : sides) {
            int size = current.size();
            for (int left = 0; left < size; left++) {
                for (int right = left + 1; right < size; right++) {
                    long X = current.get(left);
                    long Y = current.get(right);

                   
                    if ((X * Y) % (X + Y) == 0) {
                        count++;
                    }
                }
            }
        }

       
        System.out.println(count);
    }
}
