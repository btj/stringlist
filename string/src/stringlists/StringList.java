package stringlists;

import java.util.Arrays;

/**
 * Each instance of this class represents a sequence of strings.
 * 
 * @invar | getElements() != null
 * @invar | Arrays.stream(getElements()).allMatch(e -> e != null)
 */
public class StringList {
	
	/**
	 * @invar | elements != null
	 * @invar | Arrays.stream(elements).allMatch(e -> e != null)
	 * 
	 * @representationObject
	 */
	private String[] elements;
	
	/**
	 * Returns the elements of this string list as an array.
	 * 
	 * @creates | result
	 */
	public String[] getElements() { return elements.clone(); }
	
	public String getConcatenation() {
		if (elements.length == 0)
			return "";
		else {
			String result = elements[0];
			for (int i = 1; i < elements.length; i++)
				result = result.concat(elements[i]);
			return result;
		}
	}
	
	public StringList(String[] elements) {
		if (elements == null)
			throw new IllegalArgumentException("The given array must not be null");
		if (Arrays.stream(elements).anyMatch(e -> e == null)) // exists e in elements. e == null 
			throw new IllegalArgumentException("The elements must not be null");
		
		this.elements = elements.clone();
	}
	
	public void setElement(int index, String value) {
		if (value == null)
			throw new IllegalArgumentException("The given value must not be null.");
		elements[index] = value;
	}

}
