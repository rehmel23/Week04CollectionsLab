package week04Collections;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

public class Week04StringBuilderListSetMapLab {

	public static void main(String[] args) {

		// 1. Why would we use a StringBuilder instead of a String?
		// 		a. Instantiate a new StringBuilder
		//		b. Append the characters 0 through 9 to it separated by dashes
		// 				Note:  make sure no dash appears at the end of the StringBuilder
		System.out.println("Question 1:");
		StringBuilder count = new StringBuilder();
		for (int i = 0; i < 10; i++) {
			count.append(i);
			
			if (i != 9) {
				count.append("-");
			}
		}
		System.out.println(count);
		
		// 2. List of String:
		//		a. Create a list of Strings 
		//		b. Add 5 Strings to it, each with a different length
		System.out.println("\nQuestion 2:");
		List<String> strings = new ArrayList<String>();
		strings.add("I");
		strings.add("am");
		strings.add("practicing");
		strings.add("java");
		strings.add("programming");
		for (String string : strings) {
			System.out.println(string);
		}
		
		// 3. Write and test a method that takes a list of strings 
		//			and returns the shortest string
		System.out.println("\nQuestion 3:");
		System.out.println(shortestString(strings));
		
		// 4. Write and test a method that takes a list of strings 
		//			and returns the list with the first and last element switched
		System.out.println("\nQuestion 4:");
		List<String> newStrings = switchFirstAndLast(strings);
		
		for (String string : newStrings) {
			System.out.println(string);
		}
		
		// 5. Write and test a method that takes a list of strings 
		//			and returns a string with all the list elements concatenated to each other,
		// 			separated by a comma
		System.out.println("\nQuestion 5:");
		System.out.println(concatenate(strings));
		
		// 6. Write and test a method that takes a list of strings and a string 
		//			and returns a new list with all strings from the original list
		// 			containing the second string parameter (i.e. like a search method)
		System.out.println("\nQuestion 6:");
		List<String> searchResults = searchString(strings, "ra");
		for (String result : searchResults) {
			System.out.println(result);
		}
		
		// 7. Write and test a method that takes a list of integers 
		//			and returns a List<List<Integer>> with the following conditions specified
		//			for the return value:
		//		a. The first List in the returned value contains any number from the input list 
		//			that is divisible by 2
		//		b. The second List contains values from the input list that are divisible by 3
		//		c. The third containing values divisible by 5, and 
		//		d. The fourth all numbers from the input List not divisible by 2, 3, or 5
		System.out.println("\nQuestion 7:");
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 15, 16, 20, 25, 30);
		
		List<List<Integer>> sortedNumbers = sortDivisibleNumbers(numbers);
		
		for(List<Integer> list : sortedNumbers) {
			for(Integer number : list) {
				System.out.println(number);
			}
			System.out.println("----------");
		}
		
		
		// 8. Write and test a method that takes a list of strings 
		//			and returns a list of integers that contains the length of each string
		System.out.println("\nQuestion 8:");
		List<Integer> stringLengths = getStringLengths(strings);
		for(Integer length : stringLengths) {
			System.out.println(length);
		}

		
		// 9. Create a set of strings and add 5 values
		System.out.println("\nQuestion 9:");
		Set<String> setStrings = new HashSet<String>();
		setStrings.add("Leaving");
		setStrings.add("Teaching");
		setStrings.add("Is");
		setStrings.add("Really");
		setStrings.add("Hard");
		
		
		// 10. Write and test a method that takes a set of strings and a character 
		//			and returns a set of strings consisting of all the strings in the
		// 			input set that start with the character parameter.
		System.out.println("\nQuestion 10:");
		Set<String> starts = stringStartsWith(setStrings, 'T');
		for(String str : starts) {
			System.out.println(str);
		}

		
		// 11. Write and test a method that takes a set of strings 
		//			and returns a list of the same strings
		System.out.println("\nQuestion 11:");
		List<String> list = copyStringSetToList(setStrings);
		
		for (String string : list) {
			System.out.println(string);
		}
		

		// 12. Write and test a method that takes a set of integers 
		//			and returns a new set of integers containing only even numbers 
		//			from the original set
		System.out.println("\nQuestion 12:");
		Set<Integer> numberSet = new HashSet<Integer>();
		for (int i = 1; i < 15; i++) {
			numberSet.add(i);
		}
		Set<Integer> evenSet = extractEvens(numberSet);
		
		for (Integer number : evenSet) {
			System.out.println(number);
		}

		
		// 13. Create a map of string and string and add 3 items to it where the key of each
		// 			is a word and the value is the definition of the word
		System.out.println("\nQuestion 13:");
		Map<String, String> dictionary = new HashMap<String, String>();
		dictionary.put("lamp", "a device for giving light, either one consisting of an electric bulb together with its holder and shade or cover.");
		dictionary.put("telephone", "a system for transmitting voices over a distance using wire or radio, by converting acoustic vibrations to electrical signals.");
		dictionary.put("computer", "an electronic device for storing and processing data, typically in binary form, according to instructions given to it in a variable program.");
		
		System.out.println(dictionary);
	
		
		// 14. Write and test a method that takes a Map<String, String> and a string 
		// 			and returns the value for a key in the map that matches the
		// 			string parameter (i.e. like a language dictionary lookup)
		System.out.println("\nQuestion 14:");
		String word = "lamp";
		System.out.println(word + ": " + getDefinition(dictionary, word));
		
		// 15. Write and test a method that takes a List<String> 
		//			and returns a Map<Character, Integer> containing a count of 
		//			all the strings that start with a given character
		System.out.println("\nQuestion 15:");
		Map<Character, Integer> counts = countStartingLetters(strings);
		
		for(Character character : counts.keySet()) {
			System.out.println(character + " - " + counts.get(character));
		}

	}
	
	
	// Method 15:
	public static Map<Character, Integer> countStartingLetters(List<String> stringList){
		Map<Character, Integer> results = new HashMap<Character, Integer>();
		
		for (String word : stringList) {
			char c = word.charAt(0);
			
			if(results.get(c) == null) {
				results.put(c, 1);
			}else {
				results.put(c, results.get(c) + 1);
			}
		}
		
		return results;
	}
	
	
	// Method 14:
	public static String getDefinition(Map<String, String> stringMap, String word) {
		String definition = stringMap.get(word);
		
		return definition;
	}

	
	// Method 12:
	public static Set<Integer> extractEvens(Set<Integer> nums){
		Set<Integer> result = new HashSet<Integer>();
		
		for (Integer num : nums) {
			if (num % 2 == 0) {
				result.add(num);
			}
		}
		return result;
	}

	
	// Method 11:
	public static List<String> copyStringSetToList(Set<String> strings){
		List<String> result = new ArrayList<String>();
		for (String string : strings) {
			result.add(string);
		}
		
		return result;
	}


	// Method 10:
	public static Set<String> stringStartsWith(Set<String> strings, char c){
		Set<String> starts = new HashSet<String>();
		for (String str : strings) {
			if(str.charAt(0) == c) {
				starts.add(str);
			}
		}
		
		return starts;
	}

	
	// Method 8:
	public static List<Integer> getStringLengths(List<String> list){
		List<Integer> result = new ArrayList<Integer>();
		
		for (String string : list) {
			result.add(string.length());
		}
		return result;
	}

	
	// Method 7:
	public static List<List<Integer>> sortDivisibleNumbers(List<Integer> list){
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		results.add(new ArrayList<Integer>());
		results.add(new ArrayList<Integer>());
		results.add(new ArrayList<Integer>());
		results.add(new ArrayList<Integer>());
		
		for(Integer number : list) {
			if(number % 2 == 0) {
				results.get(0).add(number);
			}
			if(number % 3 == 0) {
				results.get(1).add(number);
			}
			if(number % 5 == 0) {
				results.get(2).add(number);
			}
			if(number % 2 !=0 && number % 3 != 0 && number % 5 !=0) {
				results.get(3).add(number);
			}
		}
		return results;
	}

	
	// Method 6:
	public static List<String> searchString(List<String> list, String str){
		List<String> results = new ArrayList<String>();
		for (String string : list)
			if(string.contains(str)) {
				results.add(string);
			}
		return results;
	}

	
	// Method 5:
	public static String concatenate(List<String> list) {
		StringBuilder result = new StringBuilder();
		int counter = 0;
		for (String string : list) {
			result.append(string);
			counter++;
			if (counter != list.size()) {
				result.append(", ");
			}
				
		}
		return result.toString();
	}
	
	
	// Method 4:
	public static List<String> switchFirstAndLast(List<String> list){
		String last = list.get(list.size() - 1);
		list.set(list.size() - 1, list.get(0));
		list.set(0, last);
		
		return list;
	}
	
	
	// Method 3:
	public static String shortestString(List<String> list) {
		String shortest = list.get(0);
		
		for(String string : list) {
			if(string.length() < shortest.length()) {
				shortest = string;
			}
		}
		return shortest;
	}
	

}
