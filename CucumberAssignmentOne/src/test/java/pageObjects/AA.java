package pageObjects;

public class AA {
	
	public static void main(String args[]) {
		
//		int[] a= {1,2,4,5,6};
//		for(int i=0;i<(a.length-1);i++) {
//			if(i>=1)
//			{
//				a[i]=a[i+1];
//			}
//		
//		}
//		for(int i=0;i<a.length-1;i++)
//		{
//			System.out.println(a[i]);
//		}
		
		
		String a="W3l5O7E3";
		String cha=a.replaceAll("[0-9]","");
		System.out.println(cha);
		System.out.println(a);
		String in=a.replaceAll("[a-zA-Z]", "");
		System.out.println(in);
		int n=Integer.parseInt(in);
		int sum=0;
		while(n>0) {
			sum=sum+n%10;
			n=n/10;
		
			
		}
		System.out.println(sum);
		
	}
	

}
