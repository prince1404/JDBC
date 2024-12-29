
public class Palindrome {
	public static void main(String[] args) {
		System.out.println("hello");
		
		int num=1221;
		int rev =0;
		int temp;
		int n=num;
		
		while(num>0) {
			 temp=num%10;
			rev =rev*10+temp;
			num/=10;
		}
		
		if(rev==n) {
			System.out.println("Palindrome");
			
		}
		else {
			System.out.println("not palindrome");
		}
		
		
	}

}
