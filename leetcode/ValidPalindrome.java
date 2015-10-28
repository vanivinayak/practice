package leetode50;

/*
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
For example,
"A man, a plan, a canal: Panama" is a palindrome. "race a car" is not a palindrome.
 */
public class ValidPalindrome {

	
	public boolean validPalindrome(String str){
		boolean flag = true;
		str = str.trim();
		str = str.toLowerCase();
		str = str.replaceAll("[!@#$%^&*()-=_+}{;:\'\" \\ \\/?.>,<~` ]", "");
		str.toLowerCase();
		int len = str.length();
		if(len ==1 || len==0) return true;
		else{
		for(int i=0; i<(len/2) +1;i++ ){
			if(str.charAt(i) != str.charAt(len-i-1)){
				return false;
			}
		}
		return flag;
		}
		
	}
	
	public static void main(String[] args){
		ValidPalindrome vp = new ValidPalindrome();
		System.out.println(vp.validPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(vp.validPalindrome("race a car"));
	}
}
