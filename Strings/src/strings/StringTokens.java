package strings;

import java.io.*;
import java.util.*;

public class StringTokens {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        s = s.trim();
        if (s.length()==0) {System.out.println(0); return;}
        String[] tokens = s.split("[^a-zA-Z]+");
        System.out.println(tokens.length);
        for (int i=0; i < tokens.length; i++) {
            System.out.println(tokens[i]);
        }
        
        scan.close();
	}

}
