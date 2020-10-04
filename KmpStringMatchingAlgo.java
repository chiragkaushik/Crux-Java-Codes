
public class KmpStringMatchingAlgo {
	
	public static void lps(String pattern , int lps[]) {
		int m = pattern.length();
		int i = 1 ;
		lps[0] = 0;
		int l = 0;
		while(i<m) {
			if(pattern.charAt(i)==pattern.charAt(l)) {
				
				l++;
				lps[i]=l;
				i++;
			}
			else {
				if(l!=0) {
					l = lps[l-1];
				}
				else {
					lps[i] =  0;
					i++;
				}
			}
		}
	}
	public static boolean kmpSearch(String str,String pattern , int lps[]) {
		boolean flag =false;
		int n = str.length();
		int m = pattern.length();
		
		int i = 0 ; 
		int j = 0 ;
		while(i<n) {
			if(str.charAt(i) == pattern.charAt(j) ) {
				i++;
				j++;
			}
			
			if(j == m)
			{
				System.out.println("Pattern found at index "+(i-j));
				j = lps[j-1];
				flag = true;
			}
			else if(i < n && (str.charAt(i)!=pattern.charAt(j))) {
				
				if(j != 0) {
					j = lps[j-1];
				}
				else {
					i++;
				}
			}
		}
		return flag ;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String pattern = "ABCAB";
		String str = "ABCBABCABC";
		int l = pattern.length();
		int lps[] = new int[l];
		
		lps(pattern,lps);
		
		for(int item:lps) {
			System.out.print(item+" ");
		}
		System.out.println();
		System.out.println(kmpSearch(str,pattern,lps));

	}

}
