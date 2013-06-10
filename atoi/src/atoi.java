import java.math.BigDecimal;
import java.math.BigInteger;


class Solution {
	
	boolean isDigit(char c) {
		/*
		System.out.println("isDigit: c = " + c);
		System.out.println("(int)c = " + (int)c);
		System.out.println("(int)'0' = " + (int)'0');
		System.out.println("(int)'9' = " + (int)'9');
		*/
		if ( (int)c >= (int)'0' && (int)c <= (int)'9' ) {
			//System.out.println("isDigit: yes");
			return true;
		}
		
		//System.out.println("isDigit: no\n");
		return false;
	}
	
    public int atoi(String str) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	
    	if (str.length()==0) {
    		return 0;
    	}
    	
    	int i=0;
    	long ret= 0;
    	int sign = 1;
    	
    	//skip spaces
    	while(  str.charAt(i)==' ' ) {
    		++i;
    	}
    	
    	//check optional + or -
    	if (str.charAt(i) == '+') {
    		++i;
    	} else if (str.charAt(i) == '-') {
    		++i;
    		sign = -1;
    	}	
    	
    	if (!isDigit(str.charAt(i))) {
    		return 0;
    	}
    	
    	
    	// !!!!!!!!!!!!!!!!!!!!! 
    	
    	char c;
    	while ( true ) {
    		if (i==str.length()) {
    			break;
    		} 
    		c = str.charAt(i++);
    		//System.out.println("c = " + c);
    		if (isDigit(c)) {
    			ret = ret*10 + (int)c - (int)'0';
    			//System.out.println("ret = " + ret);
    		} else {
    			break;
    		} 
    		//System.out.println();
    	}
    	
    	//System.out.println("ret = " + ret);
    	//System.out.println("ret>Integer.MAX_VALUE+1 : " + (ret>Integer.MAX_VALUE+1));
    	//System.out.println("Integer.MAX_VALUE+1 =  " + Integer.MAX_VALUE+1);
    	if (sign==1 && ret>Integer.MAX_VALUE) {
    		//System.out.println("max");
    		ret = Integer.MAX_VALUE;
    		//System.out.println("Integer.MAX_VALUE + 1= " + Integer.MAX_VALUE + 1);
    		
    	} else if (sign == -1 && ret>(long)Integer.MAX_VALUE+1) {
    		//System.out.println("min");
    		//System.out.println("ret = " + ret);
    		ret = Integer.MIN_VALUE;
    	}
    	
    	//System.out.println("ret= " + ret );
    	
    	return (int)ret * sign;
    }
}


public class atoi {
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.atoi("") );
		System.out.println(s.atoi("23") );
		System.out.println(s.atoi("-29") );
		System.out.println(s.atoi("7897897897879123213"));
		System.out.println(s.atoi("-7897897897879123213"));
	}
}
