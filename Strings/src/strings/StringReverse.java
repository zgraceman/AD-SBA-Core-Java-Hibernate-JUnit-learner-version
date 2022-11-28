package strings;

import java.io.*;
import java.util.*;

public class StringReverse {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
        String A=sc.next();
        
        String reverse = new StringBuilder(A).reverse().toString();
        if (A.compareTo(reverse) == 0) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }

	}

}
