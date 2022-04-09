import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
class TestClass {
    public static void main(String args[] ) throws Exception {
        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String numberOfInt = br.readLine();              // Reading input from STDIN
        long nums = Long.parseLong(numberOfInt);
        int val = 0;
        ArrayList<Long> numList = new ArrayList<Long>();
        long sum = 1;
        numList.add(sum);
        numList.add(sum);
        for ( long i = 2; i <= 100005; i++ ) {
            sum = sum * i;
            sum = sum % 1000000007;
            numList.add(sum);
        }
        for ( long j = 0; j < nums; j++ ) {
            numberOfInt = br.readLine();              // Reading input from STDIN
            val = Integer.parseInt(numberOfInt);
            sum = numList.get(val);
            System.out.println(sum);
        }
    }

}
