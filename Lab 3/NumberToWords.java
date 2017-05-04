public class NumberToWords {
	public static void main(String[] args) {
            int number;
            System.out.print ("Number: ");
            number = In.nextInt();
            while (number != -1) //Allows numbers to be converted until the user types -1.
            {
                if (number == 0) //Zero check, simplifies logic below.
                {
                    System.out.println("zero");
                } else if (number / 100 == 0) //Checks if the value is over 99 (Three digit). Eg. 987 / 100 = 9. 
                {
                    System.out.println(convertToString(number));
                } else { // The number is over 99 (Three Digit).
                    int firstDigit = number/100; //Seperates the first digit for logic reasoning. 
                    if (number%100 == 0) //if the last two digits are equal to 0, eg. 800.
                    {
                        System.out.println(convertToString(firstDigit) + " hundred"); //prints out only the first digit converted + "hundred"
                    } else // The the second and third digits are not 0. eg. 945. 
                    {
                        System.out.println(convertToString(firstDigit) + " hundred and " + convertToString(number%100)); //Prints out the first digit converted + " hundred and " + converted digit 2 and 3. 
                    }
                }
                System.out.print ("Number: "); //Asks for input again. 
                number = In.nextInt();                   
            }  
	}
        
           
        private static String convertToString(int number)
        { // Function uses two arrays that have their elements lined up with their value in the array. Eg. singles[7] = "seven". This simplifies logic but requires empty elements at the start. 
            String[] singles = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "tweleve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
            String[] doubles = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
            if (number > 0 && number < 20){ //if the number is a 'teen' eg. 0 - 20.              
                    return singles[number]; 
            } else {                  
                return doubles[number/10] + " " + singles[number%10]; // if the value is greater then 19, the value will be a double + a single. Eg. 44 == "fourty" + :"four" == double[4] + singles[4].
            }
        }
}
