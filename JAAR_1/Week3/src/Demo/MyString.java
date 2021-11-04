package Demo;

import java.util.Arrays;

/**
 * 
 * @immutable
 */

public class MyString {

	/**
	 * @representationObject
	 */
	
	private char[] characters;
	
	/**
	 * 
	 * @inspects | this
	 */
	public char[] getCharacters() {
		return characters.clone();
	}
	
	public int getLength() {
		return characters.length;
	}
	
	public char charAt(int index) {
		return characters[index];
	}
	
	public MyString(char[] characters) {
		this.characters = characters.clone();
	}
	
	public boolean equals(MyString other) {
		return other != null && Arrays.equals(characters, other.characters);
	}
	
	/**
	 * @pre | other != null
	 */
	
	public MyString append(MyString other) {
		char[] newChars = new char[characters.length + other.characters.length];
		System.arraycopy(characters, 0, newChars, 0, characters.length);
		System.arraycopy(other.characters, 0, newChars, characters.length, other.characters.length);
		return new MyString(newChars);
	}
	
}
