package playground;

import java.util.regex.Matcher;
        import java.util.regex.Pattern;

public class RegexMatches {
    public static void main( String args[] ) {
        // String to be scanned to find the pattern.
        String line = "2020-12-24--3030-04-1";
        String pattern = "(\\d\\d\\d\\d)-(\\d\\d)-(\\d\\d)";

        // Create a Pattern object
        Pattern r = Pattern.compile(pattern);

        // Now create matcher object.
        Matcher m = r.matcher(line);
        m.find();
        System.out.println(m.group(1));

//        if (m.find( )) {
//            System.out.println("Found value: " + m.group(0) );
//            System.out.println("Found value: " + m.group(1) );
//            System.out.println("Found value: " + m.group(2) );
//        } else {
//            System.out.println("NO MATCH");
//        }
    }
}

