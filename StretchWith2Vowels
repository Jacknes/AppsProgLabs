public class StretchWith2Vowels {
    public static void main(String[] args) {
      String sentence;
      while(!(sentence = readSentence()).equals("*")){
          System.out.println("Matching words = " + matchCount(sentence));                 
      }
    }
    
    public static String readSentence() {
        System.out.print("Sentence: ");
        return In.nextLine();
    }
    
    public static int matchCount(String sentence){
        int count = 0;
        for(String word : sentence.split(" +")){
           if (matches(word)){
               count++;
           }
        }
        return count;
    }
    
    public static boolean matches(String word){
        word = word.toLowerCase();
        for (String segment: word.split("z")){
            if (countVowel(segment) == 2){
                return true;
            }
        }
        return false;        
    }
    
    public static int countVowel(String segment){
        int count = 0;
        for (int i = 0; i < segment.length(); i++){
            if (isVowel(segment.charAt(i))){
                count++;
            }
        }    
        return count;
    }
    
    public static boolean isVowel(char c){
        return "aeiou".contains(("" + c));
    }
}
