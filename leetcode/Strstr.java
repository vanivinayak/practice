package leetode50;

public class Strstr {

	//This is not working - gives Time Exceed Error
	public int strstr(String haystack, String needle){
		int len1 = haystack.length();
		int len2 = needle.length();
		
		if (len2 == 0 ) return 0;
		else if (len2 > len1 || len1 == 0) return -1;
		else {
			for(int i=0; i < len1; i++){
				int k = i;
				int j =0;
				while(j < len2 && k < len1 && (haystack.charAt(k) == needle.charAt(j))){
					k++;
					j++;
				}
				if(j == len2) { return i; }
			}
		}
		return -1;
	}
	
	//short way of doing the same strstr
	public int strstrX(String haystack, String needle){
		 for (int i = 0; ; i++) {
			 for (int j = 0; ; j++) {
				 if (j == needle.length()) return i;
				 if (i + j == haystack.length()) return -1;
				 if (needle.charAt(j) != haystack.charAt(i + j)) break;
			 } 
		}
	}
	public static void main(String[] args){
		Strstr s = new Strstr();
		System.out.println("mississippi & issi = " +s.strstr("mississippi", "issi"));
		System.out.println("mississippi & isi = " +s.strstr("mississippi", "isi"));
		System.out.println("mississippi & issibhhuyrhgvjh = " +s.strstr("mississippi", "issibhhuyrhgvjh"));
		System.out.println("abbbca & ca = " +s.strstr("abbbca", "ca"));
		System.out.println("abbbca & '' = " +s.strstr("abbbca", ""));
	}
}
 