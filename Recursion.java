/*
 * This programs have different functions which are doing their work by using recursion. 
 * This program is mainly for learning the basics of Recursion
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Recursion {
	public static void main(String args[])
	{
		/*
		 * Given an array of integers and an item, we have to search the indices of that item
		 * in the given array and return an array containing those indices
		 * 
		 */
//		int arr[]= {10,20,20,40,40,20,60};
//		int ar[]=findAllIndex(arr,0,20,0);
//		for(int item : ar)
//		{
//			System.out.println(item);
//		}
		
		
		/*
		 * Given an array of integers and an item, we have to find tha end index of that item in the array
		 * and return it as an integer
		 */	
		
//		System.out.println(findEndIndex(arr,0,20));
		
		/*
		 * Given a String we have to find all its substrings and return it to as an arrayList.
		 * 
		 */
//		System.out.println(getSS("ab"));
		
		/*
		 * earlier we used to have keypad mobile. those mobile used to use 1 key for typing more than one 
		 * characters. Given the sequence of key pressed by the user return the total possible messages
		 * that can be generated the key sequence pressed
		 */
		
		System.out.println(getKpc("145"));
		
		/*
		 * Given a string find all the permutations that can be generated by using all the characters of
		 * the string 
		 */
		
//		System.out.println(getPermutations("abc"));
		
		/*
		 * Given a dice. initially we are on 0 and we have to reach number n on a board numbered from 1 to n.
		 * Find and print all the ways by which we can reach on number n.
		 * 
		 */
		
//		System.out.println(getBoardPath(0,10));
		
		/*
		 *  Find all the permutations Head and Tails which could occur on tossing a coin n times.
		 *  
		 */
		
//		System.out.println(getCoinToss(3));
		
		/*
		 * Given a 2-d board. numbered from (0,0) to (n-1,m-1). Find all permutation to reach from
		 * (0,0) to (n-1,m-1), given that we cannot move backward once a move is taken in any direction.
		 * and given that we can take moves only in the horizontal direction and vertical direction only and 
		 * we can take only 1 step at a time.
		 * 
		 */
		
//		System.out.println(getMazePath(0 , 0 , 2 , 2 ));
		
		/*
		 * Given a 2-d board. numbered from (0,0) to (n-1,m-1). Find all permutation to reach from
		 * (0,0) to (n-1,m-1), given that we cannot move backward once a move is taken in any direction.
		 * and given that we can take moves only in the horizontal direction ,vertical direction and 
		 * also we can move diagonally. Also given that we can move only one step at a time
		 *  in any direction.  
		 */
		
		
//		System.out.println(getMazePathDiagonal(0 , 0 , 2 , 2));
		
		/*
		 *  Given a 2-d board. numbered from (0,0) to (n-1,m-1). Find all permutation to reach from
		 * (0,0) to (n-1,m-1), given that we cannot move backward once a move is taken in any direction.
		 * and given that we can take moves only in the horizontal direction ,vertical direction and 
		 * also we can move diagonally. Also given that we can move any number of step at a time 
		 * in any direction.  
		
		 */
		
		
//		System.out.println(getMazePathDMM(0 , 0, 2 , 2).size());
		
		
		
		
//		Scanner sc = new Scanner(System.in) ;
//		int n = sc.nextInt();
//		int arr[] = new int[n] ;
//		String str ="" ;
//		for(int i = 0 ; i < n ; i++)
//		{
//			arr[i] = sc.nextInt() ;
//			str += arr[i] ;
//		}
//		int target = sc.nextInt() ;
//		System.out.println(countWays(str , "" , 0 , target));
//		printWays(str, "", 0, target );
		
		
	}
	public static void printWays(String str , String ans , int sum , int target )
	{
		if(sum == target)
		{
			System.out.print(ans + " ");
			return;
		}
		
		if(str.length() == 0)
		{
			return ;
		}
		
		if(sum > target)
		{
			return ;
		}
		
		for(int i = 0 ; i < str.length()  ;i++)
		{
			char ch = str.charAt(i) ;
			String ros = str.substring(i + 1) ;
			printWays(ros, ans + ch +" ", sum + Integer.parseInt(ch + ""), target );
		}		
	}
	public static int countWays(String str , String ans , int sum , int target )
	{
		if(sum == target)
		{
			
			//System.out.print(ans + " ");
			return 1;
		}
		
		if(str.length() == 0)
		{
			return 0;
		}
		
		if(sum > target)
		{
			return 0;
		}
		int recRes = 0;
		for(int i = 0 ; i < str.length()  ;i++)
		{
			char ch = str.charAt(i) ;
			String ros = str.substring(i + 1) ;
			recRes += countWays(ros, ans + ch +" ", sum + Integer.parseInt(ch + ""), target );
		}		
		return recRes ;
	}
	public static String getCode(char ch) {

        if (ch == '1')
            return "abc";
        else if (ch == '2')
            return "def";
        else if (ch == '3')
            return "ghi";
        else if (ch == '4')
            return "jk";
        else if (ch == '5')
            return "lmno";
        else if (ch == '6')
            return "pqr";
        else if (ch == '7')
            return "stu";
        else if (ch == '8')
            return "vwx";
        else if (ch == '9')
            return "yz";
        else if (ch == '0')
            return "@#";
        else
            return "";
    }

	
	public static ArrayList<String> getKpc(String str)
	{
		if(str.length()==0)
		{
			ArrayList<String> baseRes=new ArrayList<>();
			baseRes.add("");
			return baseRes;
		}
		char ch=str.charAt(0);
		String ros=str.substring(1);
		
		String code = getCode(ch);
		
		ArrayList<String> recRes=getKpc(ros);
		ArrayList<String> myRes=new ArrayList<>();
		for(int i = 0; i < code.length(); i++)
		{
			for(String s : recRes)
			{
				myRes.add(code.charAt(i)+s);
			}
		}		
		return myRes;
	}
	public static ArrayList<String> getPermutations(String str)
	{
		if(str.length()==0)
		{
			ArrayList<String> baseRes=new ArrayList<>();
			baseRes.add("");
			return baseRes;
		}
		char ch=str.charAt(0);
		String ros=str.substring(1);
		
		ArrayList<String> recRes = getPermutations(ros);
		ArrayList<String> myRes=new ArrayList<>();
		for(String s: recRes)
		{
			for(int i=0;i<=ros.length();i++)
			{
				myRes.add(s.substring(0,i)+ch+s.substring(i));
			}
		}
		return myRes;
	}
	
	
	public static int findEndIndex(int arr[],int vidx,int item)
	{
		if(vidx==arr.length)
		{
			return -1;
		}
		int recAns = findEndIndex(arr,vidx+1,item);
		if(arr[vidx]==item && recAns == -1)
		{
			return vidx;
		}
		
		return recAns;
	}
	public static int[] findAllIndex(int arr[],int vidx,int item, int count)
	{
		if(vidx==arr.length)
		{
			int br[]=new int[count];
			return br;
		}
		int recAns[];
		if(arr[vidx]==item)
		{
			recAns=findAllIndex(arr,vidx+1,item,count+1);
			recAns[count]=vidx;
		}
		else
		{
			recAns=findAllIndex(arr,vidx+1,item,count);
		}
		return recAns;
	}
	
	public static ArrayList<String> getSS(String str)
	{
		if(str.length()==0)
		{
			ArrayList<String> baseRes=new ArrayList<>();
			baseRes.add("");
			return baseRes;
		}
		char ch=str.charAt(0);
		String ros=str.substring(1);
		
		ArrayList<String> recRes=getSS(ros);
		ArrayList<String> myRes=new ArrayList<>();
		
		for(String val : recRes)
		{
			myRes.add(val); // No
			myRes.add(ch+val); // Yes
			myRes.add((int)ch+val); // ascii value
		}
		
		return myRes;
	}
	
	
	
	
	public static ArrayList<String> getBoardPath( int curr , int end)
	{
		if(curr == end)
		{
			ArrayList<String> baseRes = new ArrayList<>();
			baseRes.add("");
			return baseRes;
		}
		ArrayList<String> myRes = new ArrayList<>();
		for(int dice  = 1; dice <=6 && dice + curr <=10 ; dice++)
		{
			ArrayList<String> recRes = getBoardPath ( curr + dice , end);
			for(String val : recRes)
			{
				myRes.add(dice + val);
			}
		}
		return myRes;		
	}
	
	public static ArrayList<String> getCoinToss(int n)
	{
		if(n==0)
		{
			ArrayList<String> baseRes = new ArrayList<>();
			baseRes.add("");
			//baseRes.add("T");
			return baseRes; 
		}
		ArrayList<String> recRes = getCoinToss(n-1); 
		ArrayList<String> myRes = new ArrayList<>();
		for(String val : recRes)
		{
			myRes.add("H" + val);
			myRes.add("T" + val);
		}
		return myRes;
	}
	
	public static ArrayList<String> getMazePath(int cr, int cc, int er, int ec)
	{
		if(cr == er && cc == ec)
		{
			ArrayList<String> baseRes = new ArrayList<>();
			baseRes.add("");
			return baseRes;
		}
		if(cr > er)
		{
			ArrayList<String> baseRes = new ArrayList<>();
			return baseRes;
			
		}
		if(cc > ec)
		{
			ArrayList<String> baseRes = new ArrayList<>();
			return baseRes;
			
		}
		ArrayList<String> myRes = new ArrayList<>();
		// Either do not make call for each column or make negative base case
	//	if(cc<ec)
	//	{
			ArrayList<String> recResHorizontal = getMazePath(cr , cc + 1, er ,ec);
			for(String val: recResHorizontal) 
			{
				myRes.add("H"+val);
			}
		//}
	//	if(cr  < er)
	//	{
			ArrayList<String> recResVertical = getMazePath(cr + 1 ,cc ,er , ec);
			for(String val: recResVertical) 
			{
				myRes.add("V"+val);
			}
	//	}
			
		return myRes;
	}
	
	public static ArrayList<String> getMazePathDiagonal(int cr, int cc , int er, int ec)
	{
		if(cr == er && cc == ec)
		{
			ArrayList<String> baseRes = new ArrayList<>();
			baseRes.add("");
			return baseRes;
		}
		if(cr > er)
		{
			ArrayList<String> baseRes = new ArrayList<>();
			return baseRes;
			
		}
		if(cc > ec)
		{
			ArrayList<String> baseRes = new ArrayList<>();
			return baseRes;
			
		}
		ArrayList<String> myRes = new ArrayList<>();
		// Either do not make call for each column or make negative base case
	//	if(cc<ec)
	//	{
			ArrayList<String> recResHorizontal = getMazePathDiagonal(cr , cc + 1, er ,ec);
			for(String val: recResHorizontal) 
			{
				myRes.add("H"+val);
			}
		//}
	//	if(cr  < er)
	//	{
			ArrayList<String> recResVertical = getMazePathDiagonal(cr + 1 ,cc ,er , ec);
			for(String val: recResVertical) 
			{
				myRes.add("V"+val);
			}
	//	}
			ArrayList<String> recResDiagonal = getMazePathDiagonal(cr + 1 ,cc + 1 ,er , ec);
			for(String val: recResDiagonal) 
			{
				myRes.add("D"+val);
			}
			
		return myRes;
	}
	
	public static ArrayList<String> getMazePathDMM(int cr, int cc , int er , int ec)
	{
		if(cr == er && cc == ec)
		{
			ArrayList<String> baseRes = new ArrayList<>();
			baseRes.add("\n");
			return baseRes;
		}
		// Negative Base Case
		if(cr > er)
		{
			ArrayList<String> baseRes = new ArrayList<>();
			return baseRes;			
		}
		// Negative Base Case
		if(cc > ec)
		{
			ArrayList<String> baseRes = new ArrayList<>();
			return baseRes;			
		}
		ArrayList<String> myRes = new ArrayList<>();
		
		for(int i = 1; i <= ec ; i++)
		{
			ArrayList<String> recResHorizontal = getMazePathDMM(cr , cc + i, er ,ec);
			for(String val: recResHorizontal) 
			{
				myRes.add("H"+i+val);
			}
		}

		for( int i = 1; i <= er; i++)
		{
			ArrayList<String> recResVertical = getMazePathDMM(cr + i ,cc ,er , ec);
			for(String val: recResVertical) 
			{
				myRes.add("V"+i+val);
			}
		}
		
		for(int i = 1 ; i <= er || i <= ec ; i++)
		{
			ArrayList<String> recResDiagonal = getMazePathDMM(cr + i ,cc + i ,er , ec);
			for(String val: recResDiagonal) 
			{
				myRes.add("D"+i+val);
			}
		}
		
		return myRes;
	}


}
