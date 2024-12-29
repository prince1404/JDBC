
public class rangePalindrome {
	public static void main(String[] args) {
		for (int n = 0; n <=100; n++) {
			if(isPlindrome(n)) {
				System.out.println(n);
			}
		}
		
	}
	
	
	public static boolean isPlindrome(int num) {
		int temp,rev=0;
		int n=num;
		
		while(num>0) {
			temp=num%10;
			rev=rev*10+temp;
			num/=10;
		}
		if(rev==n) {
			return true;
		}
		else {
			return false;
		}
		
	}

}
