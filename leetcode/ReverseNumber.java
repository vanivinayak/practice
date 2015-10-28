package leetode50;


//Reverse the given int and float numbers (check for conditions when they are negatives)
public class ReverseNumber {

	public int reverseInt(int num){
		int x = 0;
		boolean flag = false;
		if (num<0){
			num = 0-num;
			flag = true;
		}
		while(num > 0){
			x = x*10 +(num%10);
			num = num/10;	
		}
		return flag?  -1*x:  x;
	}
	
	public float reverseFloat(float num){
		float res; boolean flag=false;
		if(num < 0){num = 0-num; flag = true;}
		String test = String.valueOf(num);
		String[] ar = test.split("[.]");
		res = Float.valueOf( reverseInt(Integer.valueOf(ar[1]))+"."+reverseInt(Integer.valueOf(ar[0])) );
		return flag? -1*res:  res;
	}
	
	public static void main (String[] s) {
		ReverseNumber rn = new ReverseNumber();
		System.out.println(rn.reverseInt(123));
		System.out.println(rn.reverseInt(-45623));
		System.out.println(rn.reverseFloat(234.456f));
		System.out.println(rn.reverseFloat(-346.97f));
	}
}
