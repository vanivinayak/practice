package leetode50;

/*
Given an input string s, reverse the string word by word.
For example, given s = "the sky is blue", return "blue is sky the".		
*/
public class ReverseWordsInString {
	//time = O(n) & space = O(n)
	public String revreseWordsInString(String str){
		str = str.trim();
		String[] strArray = str.split("\\s+");
		String reveresedStr = "";
		int len = strArray.length;
		if(!str.equals(""))
			for(int i= len-1 ; i>=0;i--){
				if(strArray[i] != "")
					reveresedStr += strArray[i]+ " ";
			}
		return reveresedStr.trim();
	}
	
	//Follow-up in place
	//time = O(n) but keep Space = O(1)
	public String revreseWordsInStringInPlace(char[] strAr){
		
		//swap last and first going inwards to reverse
		int len = strAr.length;
		reverse(strAr, 0, len);
		System.out.println("reverse str:"+String.valueOf(strAr));
		int st =0;
		for(int i = 0;  i <= len; i++){
			if(i== len ||strAr[i] == ' ' ){
				reverse(strAr, st, i);
				st = i+1;
			}
		}
		//System.out.println(strAr);
		return String.valueOf(strAr);
	}
	public void reverse(char[] ar, int st, int end){
		char temp;
		
		for(int i = 0; i < ((end - st)/2); i++){
			temp = ar[st +i];
			ar[st +i] = ar[end -i -1];
			ar[end -i -1] =  temp;
		}
	}
	
	public static void main (String[] s) {
		ReverseWordsInString rsw = new ReverseWordsInString();
		System.out.println(rsw.revreseWordsInString("the        sky is blue"));
		System.out.println(rsw.revreseWordsInString(""));
		System.out.println(rsw.revreseWordsInString("X "));
		
		System.out.println("In Place:"+rsw.revreseWordsInStringInPlace("hate blue carota".toCharArray()));
		
		
		System.out.println("-------test implementation:"+rsw.reverseSentence("me in life is me"));
		int[] ar = {1,2,3,4,5};
		int[] res = rsw.rotateInPlace(ar, 2);
		for(int x: res){
			System.out.print(x+" ");
		}
		System.out.println();
		int[] ar1 = {1,2,3,4,5,6,7,8,9};
		int[] res1 = rsw.rotateInPlace(ar1, 4);
		for(int x: res1){
			System.out.print(x+" ");
		}
	}
	/*
	 * Rotates k elements from back of the array to front(k is less than )
	 * space= O(1) as doing it in place
	 */
	public int[] rotateInPlace(int[] input, int k){
		int len = input.length;
		int c1st = 0;
		int c2end = len-k;
		int temp =0;
		 while(c2end < len && c1st < k){
			 temp = input[c2end];
			 for(int i = c2end; i>c1st; i--){
				 input[i] = input[i-1];
			 }
			 input[c1st] = temp;
			 c1st++;
			 c2end++;
		 }
		return input;
	}
	
	//reverse a string - character array
	public void reverseStr(char[] ar, int st, int end){
		while(st < end){
			char temp = ar[st];
			ar[st] = ar[end];
			ar[end] = temp;
			st++;
			end--;
		}
	}
	//reverse words in a sentence - no extra space
	public String reverseSentence(String st){
		char[] strAr = st.toCharArray();
		reverseStr(strAr,0,strAr.length-1);
		int start = 0;
		for(int i = 0;i<strAr.length;i++){
			if(strAr[i] == ' ' || i==strAr.length-1){
				if(i==strAr.length-1) reverseStr(strAr, start, i);
				else reverseStr(strAr, start, i-1);
				start = i+1;
			}
		}
		return new String(strAr);
	}

}
