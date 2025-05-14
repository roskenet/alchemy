package challenges;

public class FirstNonRepeater {

    public static Character find(String input) {

        for(int idx = 0; idx < input.length()-2; ++idx) {
           if ((char) input.getBytes()[idx] != (char) input.getBytes()[idx+1]) {
              return (char) input.getBytes()[idx+1];
           }
        }
        return null;
    }

}
