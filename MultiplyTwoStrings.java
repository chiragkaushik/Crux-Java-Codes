import java.math.BigInteger;
import java.util.ArrayList;

public class MultiplyTwoStrings {
	static int count = 1;
	public static ArrayList<Integer> addTwoAL(ArrayList<Integer> list1 , ArrayList<Integer> list2){
		
//		int j = 0 ;
//		while(j < count) {
//			list2.add(0);
//			j++;
//		}
		count++;
		ArrayList<Integer> result = new ArrayList<>() ;
		int carry = 0 ;
		
		int l1 = list1.size();
		int l2= list2.size();		
		
		int i = 0; 
		
		while( i < l1 && i < l2) {
			
			int sum = list1.get(i) + list2.get(i) + carry;
			
			carry = sum/10 ;
			result.add(sum%10);			
			i++;
		}
		
		while(i<l1) {
			int sum = list1.get(i) + carry;
			result.add(sum%10);
			carry = sum/10;
			i++;
		}
		
		while(i<l2) {
			int sum = list2.get(i) + carry;
			result.add(sum%10);
			carry = sum/10;
			i++;
		}
		
		if(carry>0) {
			result.add(carry);
		}
		return result;
		
	}
	
	public static ArrayList<Integer> multiplyByDigit(String str , int d){
		
		int l = str.length();
		
		int i = 0 ;
		int carry = 0;
		
		ArrayList<Integer> result = new ArrayList<>();
		
		for( ; i < l ; i++) {
			
			int a = Character.getNumericValue(str.charAt(i));
			int m = a * d;
			int sum = m + carry;
			carry =sum/10;
			result.add(sum%10);			
		}
		if(carry>0) {
			result.add(carry);
		}
		
		return result;
	}
	public static String multiply(String str1, String str2) {
		
		ArrayList<Integer> list1 = new ArrayList<>();
		ArrayList<Integer> list2 = new ArrayList<>();
		
		StringBuffer sb = new StringBuffer(str1);
		sb.reverse();
		str1 = sb.toString();
		
		sb = new StringBuffer(str2);
		sb.reverse();
		str2 = sb.toString();
		
		list1 = multiplyByDigit(str1,Character.getNumericValue(str2.charAt(0)));
		
		for(int i = 1;  i < str2.length() ; i++) {
			list2 = multiplyByDigit(str1,Character.getNumericValue(str2.charAt(i)));
			int j = 0;
			while(j<count) {
				j++;
				list2.add(0,0);
			}
//			System.out.println(list2);
			list1 = addTwoAL(list1,list2);
//			count++;
		}
		
// 		System.out.println(list1);
		int zero = 0;
		boolean flag = false;
		int start = 0;
 		StringBuffer result = new StringBuffer();
 		for(int i = list1.size()-1;i >=0 ; i--) {
 			if(!flag) {
 				if(list1.get(i)==0) {
 					continue;
 				}
 				else {
 					flag = true;
 				}
 			}
 			result.append(list1.get(i));
// 			if(list1.get(i)==0) {
// 				zero++;
// 			}
 		}
 		if(!flag) {
 			return "0";
 		}
 		return result.toString();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Integer> list1 = new ArrayList<>();
		ArrayList<Integer> list2 = new ArrayList<>();
		
		list1.add(8);
		list1.add(7);
		list1.add(7);
		list2.add(2);
		list2.add(9);
		list2.add(8);
		list2.add(9);
//		System.out.println(addTwoAL(list1,list2));

//		System.out.println(multiplyByDigit("254",4));
		
//		System.out.println(multiply("145","000"));
		String str1 = "5131848155574784703269632922904933776792735241197982102373370";
		String str2 = "56675688419586288442134264892419611145485574406534291250836";
		System.out.println(multiply(str1,str2)+" * "+ count);
//		System.out.println(str1.length()+" "+str2.length());
		BigInteger b1 = new BigInteger("5131848155574784703269632922904933776792735241197982102373370");
		BigInteger b2 = new BigInteger("56675688419586288442134264892419611145485574406534291250836");
		System.out.println(b1.multiply(b2).toString());
		System.out.println("290851027081985078955918627261751688832742312387314888842460711865148550965912482730570750031304678344564428861596637320");
		System.out.println("2908510270819850789559186272617516888327423123873148888424299238553239956025636868948130741716041880087583856877716585240220");
	}

}
