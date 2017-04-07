public class StretchWith2Vowels {
    public static void main(String[] args) {
      String sentence;
      while(!(sentence = readSentence()).equals("*")){ //Condensed read loop called readSentence()
          System.out.println("Matching words = " + matchCount(sentence));                 
      }
    }
    
    public static String readSentence() {
        System.out.print("Sentence: "); // Reads in the sentence from the user.
        return In.nextLine();
    }
    
    public static int matchCount(String sentence){ //Counts the number of words in the sentence that match the required pattern.
        int count = 0; //initial count variable
        for(String word : sentence.split(" +")){ //Splits the sentence into individual words based on one or more spaces. 
           if (matches(word)){ //For each word in the sentence, the word is passed into matches.
               count++; //If matches returns true, the count will be iterated. Matches returns true for every word that matches the pattern. 
           }
        }
        return count; //Returns the number of words that match the pattern in the sentence. 
    }
    
    public static boolean matches(String word){ //Returns if a single word matches the pattern required. 
        word = word.toLowerCase(); //Makes the word lower case to remove any upper/lower case issues in the below processing.
        for (String segment: word.split("z")){ //Splits the word into segments based on 'z'. Such that azooza becomes {"a", "oo", "a"}
            if (countVowel(segment) == 2){ //For each segment, countVowel is called on the segment. countVowel returns the number of vowels in the segment.
                return true; //If the segment contains two vowels (matching the pattern) true is returned. 
            }
        }
        return false; //If no segments match, false is returned. 
    }
    
    public static int countVowel(String segment){ //Function returns the number of vowels in a segment. eg. kaael = 3
        int count = 0;
        for (int i = 0; i < segment.length(); i++){ //For each character in the segment.
            if (isVowel(segment.charAt(i))){ //Called isVowel, that compares the character and determines if it's a vowel (true or false).
                count++; //If it is a vowel, count is iterated. 
            }
        }    
        return count; //The number of vowels is returned.
    }
    
    public static boolean isVowel(char c){ //Compares the character c to a string of vowels to determine if it is one. 
        return "aeiou".contains(("" + c)); //"" + C forms a string so it can be compared to "aeiou". Because of line 25 no case issues occur. 
    }
}
