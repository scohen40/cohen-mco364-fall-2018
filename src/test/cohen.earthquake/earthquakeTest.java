package cohen.earthquake;

import java.util.ArrayList;

public class test {
	    static String mergeStrings(String a, String b) {
	        StringBuilder sb = new StringBuilder();
//	        if(a.length() > b.length()) {
	        System.out.println("done");
	            for(int i = a.length(); i < a.length(); i++) {
	            		System.out.println(i);
	                sb.append(a.charAt(i));
	                if(b.charAt(i) != -1) {
	                         sb.append(a.charAt(i));
	                }
	            }
//	        }
//	        else {
//	            for(int i = b.length(); i < b.length(); i++) {
//	            	System.out.println(i);
//	                sb.append(b.charAt(i));
//	                if(a.charAt(i) != -1) {
//	                    sb.append(a.charAt(i));
//	                }
//	            }
//	        }
	        return sb.toString(); 

	    }
	
	
	public static void main(String[] args) {    
			mergeStrings("abc","cde");
	    }
}
