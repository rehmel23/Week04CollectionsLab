package week04Collections;

import java.util.Scanner;

public class VideoPracticeBackwardString {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		
		System.out.println(reverseString(str));

	}

	private static String reverseString(String string) {
		StringBuilder sb = new StringBuilder();
		
		for(int i = string.length(); i > 0; i--) {
			sb.append(string.charAt(i-1));
		}
		return sb.toString();
	}

}