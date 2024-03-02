

public class HashTagTokenizer {

	public static void main(String[] args) {

		String hashTag = args[0];
		String []dictionary = readDictionary("dictionary.txt");
		breakHashTag(hashTag, dictionary);
		//boolean a = existInDictionary(hashTag.substring(1, 2), dictionary);
		//System.out.println(hashTag.substring(1, 2));
		//System.out.println(a);


	}

	public static String[] readDictionary(String fileName) {
		In in = new In(fileName);
		String[] dictionary = new String[3000];
		dictionary=in.readAllLines();
		return dictionary;
	}

	public static boolean existInDictionary(String word, String []dictionary) {
		boolean a=false;
		for (int i =0 ; i<3000;i++)
		{
			if (dictionary[i].equals(word))
			{
				return true;
			}
		}
		return a ; 

	}

	public static void breakHashTag(String hashtag, String[] dictionary) {

		// Base case: do nothing (return) if hashtag is an empty string.
        boolean  a;
		if (hashtag.isEmpty())
		 {
            return;
        }

		else
	     {
			int rem=0;
            int N = hashtag.length();
            for (int i = 1; i <= N; i++)
	     	{
	    		a=existInDictionary(hashtag.substring(rem, i), dictionary);
		     	if (a) 
		    	{
				    //System.out.println(hashtag.substring(rem, i));
			     	if(i+1>=N)
			    	{
					    return;
				    }
			    	else 
					{
						System.out.println(hashtag.substring(rem, i));
						breakHashTag(hashtag.substring(i,N), dictionary);
					}

		        }
			
        }
	}

    }

}
