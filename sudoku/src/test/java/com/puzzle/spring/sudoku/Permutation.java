public class Permutation {
	public static void main(String[] args) {
		Permutation permute = new Permutation();
		permute.recurse(0, "ABCD");
	}
	
	public void recurse(int index, String str) {
		if (index >= str.length() - 1) {
			System.out.println(str);
			return;
		}
		for(int i = index ; i < str.length() ; i++) {
			recurse(index + 1, swap(index, i , str));
		}
	}
	
	public String swap(int index1, int index2, String str) {
		char c = str.charAt(index1);
		char c2 = str.charAt(index2);
		String newString = "";
		for( int i = 0 ; i < str.length() ; i++) {
			if (i == index1)
				newString = newString + c2;
			else if(i == index2)
				newString = newString + c;
			else
				newString = newString + str.charAt(i);
		}
		return newString;
	}
}
