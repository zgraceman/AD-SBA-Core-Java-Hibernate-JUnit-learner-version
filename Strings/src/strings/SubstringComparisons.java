package strings;

import java.util.Scanner;

public class SubstringComparisons {

	 public static String getSmallestAndLargest(String s, int k) {
	        String smallest = s.substring(s.length()-k);
	        String largest = s.substring(0, k);
	        
	        for(int i = 0; i <= s.length() - k; i++){
	            String s2 = s.substring(i, k + i);
	            if (smallest.compareTo(s2) > 0){
	                smallest = s2;
	            }
	            if (largest.compareTo(s2) < 0){
	                largest = s2;
	            }
	        }
	        
	        return smallest + "\n" + largest;
	    }
	 
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();
      
        System.out.println(getSmallestAndLargest(s, k));
    }
}
