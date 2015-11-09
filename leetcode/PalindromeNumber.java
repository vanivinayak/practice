package leetode50;

import java.lang.management.PlatformLoggingMXBean;

/*
 * Determine whether an integer is a palindrome. Do this without extra space.
 */
public class PalindromeNumber {
	//123 -- 121
	public boolean isValidPalindrome(int num){
		int div = 1;
		int x = num;
		while(x>1){
			div *= 10;
			x /=10;
		}
		System.out.println("div"+div);
		while (num!=0){
			System.out.println(num);
			int left = num/div; 
			int right = num%10;
			if(left!=right)
				return false;
			//num = num - left*div; // remove first digit
			num = num%div; //remove first digit
			num = num/10; //remove last digit	
			div /=100;
		}
		return true;
		
	}

	public static void main(String arg[]){
		PalindromeNumber pn = new PalindromeNumber();
		System.out.println(pn.isValidPalindrome(12321));
		System.out.println(pn.isValidPalindrome(123));
	}
}
