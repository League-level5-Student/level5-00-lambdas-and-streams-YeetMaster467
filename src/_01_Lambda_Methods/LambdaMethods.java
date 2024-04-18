package _01_Lambda_Methods;

import java.util.Random;

public class LambdaMethods {
	public static void main(String[] args) {
		Random r = new Random();
		// 1. Look at the SpecialPrinter function interface.
	
		// Here is an example of calling the printCustomMessage method with a lambda.
		// This prints the passed in String 10 times.
		printCustomMessage((s)->{
			for(int i = 0; i < 10; i++) {
				System.out.println(s);
			}
		}, "repeat");
		
		//2. Call the printCustonMessage method using a lambda so that the String prints backwards.
		printCustomMessage( s -> System.out.println(new StringBuilder(s).reverse().toString()), "reverse" );
		//3. Call the printCustonMessage method using a lambda so that the String prints with a mix between upper an lower case characters.
		printCustomMessage( s -> {
			StringBuilder st = new StringBuilder(s);
			for (int i = 0; i < s.length(); i++) {
				if (i % 2 == 0) {
					st.setCharAt(i, Character.toUpperCase(s.charAt(i)));
				}
			}
			System.out.println(st.toString());
		}, "goofy");
		//4. Call the printCustonMessage method using a lambda so that the String prints with a period in between each character.
		printCustomMessage (s -> {
			String pr = "";
			for (int i = 0; i < s.length(); i++) {
				pr += s.charAt(i) + ".";
			}
			System.out.println(pr);
		}, "periods");
		//5. Call the printCustonMessage method using a lambda so that the String prints without any vowels.
		printCustomMessage (s -> {
			String pr = "";
			s = s.toLowerCase();
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) != 'a' && s.charAt(i) != 'e' && s.charAt(i) != 'i' && s.charAt(i) != 'o' && s.charAt(i) != 'u') {
					pr += s.charAt(i);
				} else {
					if (r.nextBoolean() && s.charAt(i) == 'y') {
						pr += s.charAt(i);
					}
				}
			}
			System.out.println(pr);
		}, "you get no vowels");
	
	}
	
	public static void printCustomMessage(SpecialPrinter sp, String value) {
		sp.printSpecial(value);
	}
}
	
