package Demo;

import java.util.Arrays;

public class StringList {
	/**
	 * @invar | elements != null
	 * @invar | Arrays.stream(elements).allMatch(e -> e != null)
	 * @representationObject
	 */
	
	private MyString[] elements;
	
	public StringList() {
		elements = new MyString[0];
	}
	
	public MyString[] getElements() {
		return elements;
	}
	
	/**
	 * 
	 * @pre | element != null
	 */
	public void add(MyString element) {
		MyString[] newElements = new MyString[elements.length + 1];
		System.arraycopy(element, 0, newElements, 0, elements.length);
		newElements[elements.length] = element;
		elements = newElements;
 	}
	
	/**
	 * @pre | element != null
	 */
	
	public void set(int index, MyString element) {
		elements[index] = element;
	}
	
	public MyString getConcatenation() {
		MyString result = new MyString(new char[0]);
		for(int i = 0; i < elements.length; i++) {
			result = result.append(elements[i]);
		}
		return result;
	}
	
}
