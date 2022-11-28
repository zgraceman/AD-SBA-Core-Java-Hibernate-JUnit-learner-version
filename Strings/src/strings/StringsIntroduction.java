package strings;

import java.io.*;
import java.util.*;

public class StringsIntroduction {

	public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();
        
        System.out.println(A.length() + B.length()); // part 1
        if (A.compareTo(B) > B.compareTo(A)) {System.out.println("Yes");} // part 2
        else {System.out.println("No");} // part 2
        System.out.println(A.substring(0, 1).toUpperCase() + A.substring(1) + " " + B.substring(0, 1).toUpperCase() + B.substring(1)); // part 3
    }
}
