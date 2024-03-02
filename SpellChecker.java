
public class SpellChecker {


	public static void main(String[] args) {
		String word1 = args[0];
		int threshold = Integer.parseInt(args[1]);
		String[] dictionary = readDictionary("dictionary.txt");
		String correction = spellChecker(word1, threshold, dictionary);
		System.out.println(correction);
	}

	public static String tail(String str)
	 {
		return str.substring(1);
	
	}

	public static int levenshtein(String word1, String word2) 
	{
		int a,b,c;
		word1=word1.toLowerCase();
		word2=word2.toLowerCase();
		if (word2.length()==0)
		{
			return word1.length();
		}
		else if (word1.length()==0)
		{
			return word2.length();
		}
		else if (word1.charAt(0)==word2.charAt(0))
		{
			return levenshtein(tail(word1), tail(word2));
		}
		else 
		{ 
			a=levenshtein(tail(word1), word2);
			b=levenshtein(word1, tail(word2));
			c=levenshtein(tail(word1), tail(word2));
			return 1+Math.min(a, Math.min(c, b));

		}

 
	}

	public static String[] readDictionary(String fileName)
	 {
		In in = new In(fileName);
		String[] dictionary = new String[3000];
		dictionary=in.readAllLines();
		return dictionary;
	}

	public static String spellChecker(String word, int threshold, String[] dictionary) {
		int rem=-1;
		int minchange=threshold;
		int chek;
		for (int i=0;i<dictionary.length;i++)
		{
			chek=levenshtein(word, dictionary[i]);
			if (chek<=minchange)
			{
				minchange=chek;
				rem=i;
			}
		}
		if (rem==-1)
		{
		return word;
		}
		 return dictionary[rem];
	}

}
