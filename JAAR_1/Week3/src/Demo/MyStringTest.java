package Demo;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MyStringTest {
	@Test
	public void test() {
		//MyString hi = new MyString(new char[] {'H', 'i', '!'});
		//char[] chs = hi.getCharacters();
		//chs[0] = 'B';
		//assertArrayEquals(new char[] {'H', 'i', '!'}, hi.getCharacters());
		
		StringList myStringList = new StringList();
		myStringList.add(new MyString(new char[] {'H', 'i', '!'}));
		assertTrue(myStringList.getConcatenation().equals(new MyString(new char[] {'H', 'i', '!'})));
		
		
	}
}
