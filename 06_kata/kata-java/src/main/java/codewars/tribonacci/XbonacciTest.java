package codewars.tribonacci;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.assertArrayEquals;

class Xbonacci {
    public double[] tribonacci(double[] s, int n) {
        var result = new double[n];
        if (n == 0) {
            return new double[]{};
        }
        if (n == 1) {
            result[0] = s[0];
            return result;
        }
        if (n == 2) {
            result[0] = s[0];
            result[1] = s[1];
            return result;
        }

        result[0] = s[0];
        result[1] = s[1];
        result[2] = s[2];

        for (var idx = 3; idx < n; idx++) {
            result[idx] = result[idx - 1] + result[idx - 2] + result[idx - 3];
        }
        return result;
    }
}

// Easier solution:
//public class Xbonacci {
//	public double[] tribonacci(double[] s, int n) {
//
//	    double[] tritab=Arrays.copyOf(s, n);
//	    for(int i=3;i<n;i++){
//	    	tritab[i]=tritab[i-1]+tritab[i-2]+tritab[i-3];
//	    }
//	    return tritab;
//
//	  }
//}

public class XbonacciTest {
    private Xbonacci variabonacci;

    @Before
    public void setUp() throws Exception {
        variabonacci = new Xbonacci();
    }

    @After
    public void tearDown() throws Exception {
        variabonacci = null;
    }

    private double precision = 1e-10;

    @Test
    public void sampleTests() {
        assertArrayEquals(new double[]{1, 1, 1, 3, 5, 9, 17, 31, 57, 105}, variabonacci.tribonacci(new double[]{1, 1, 1}, 10), precision);
        assertArrayEquals(new double[]{0, 0, 1, 1, 2, 4, 7, 13, 24, 44}, variabonacci.tribonacci(new double[]{0, 0, 1}, 10), precision);
        assertArrayEquals(new double[]{0, 1, 1, 2, 4, 7, 13, 24, 44, 81}, variabonacci.tribonacci(new double[]{0, 1, 1}, 10), precision);
    }
}

