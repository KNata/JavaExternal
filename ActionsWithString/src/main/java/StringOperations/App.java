package StringOperations;

import java.util.*;
import java.util.Arrays;

/**
 * Hello world!
 *"^[a-c_-]{y}$"
 */
public class App 
{
    public static void main( String[] args ) {
        StringSevice theServise = new StringSevice();
/*
        String theSentence = "Aquamarine awfully besty cfgdhy heeeey heeeeeeeeeeeey hey";
        theServise.exameEntranceString(theSentence);
        String[] wordArray = theSentence.split(" ");
        List<String> wordList = Arrays.asList(wordArray);

        List<String> foundSentenceFromTemplate = theServise.findByTemplate(wordList);
        System.out.println(theServise.findTheLongestWord(wordList));
        theServise.removeTheNeededString(wordList);
        System.out.println(wordList.toString());
*/
// Case 2: From keyBoard
        System.out.println();
        Scanner theScanner = new Scanner(System.in);
        System.out.println("Enter a sentence: ");
       // String enteredSentence = theScanner.nextLine();
        String enteredSentence = "hey, hey, heeeyyyyy";
        System.out.println("You entered: " + enteredSentence);
        enteredSentence = theServise.exameEntranceString(enteredSentence);
        System.out.println("Proceeded sentence: " + enteredSentence);
        String[] wordArrayFromEnteredString = enteredSentence.split(" ");
        List<String> wordListFromEnteredString = Arrays.asList(wordArrayFromEnteredString);
        List<String> foundSentenceFromEnteredString = theServise.findByTemplate(wordListFromEnteredString);
        System.out.println("All found words which starts in " + " and ends in ");
        System.out.println(foundSentenceFromEnteredString.toString());
        System.out.println("The longest word is " + theServise.findTheLongestWord(foundSentenceFromEnteredString));
        ArrayList<String> helpfullList = new ArrayList<String>(wordListFromEnteredString);
        theServise.removeTheNeededString(wordListFromEnteredString, helpfullList);
        System.out.println("Result list");
        System.out.println(helpfullList.toString());



    }
}
