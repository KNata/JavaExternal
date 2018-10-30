package StringOperations;

import java.io.*;
import java.util.*;

/**
 * Hello world!
 *"^[a-c_-]{y}$"
 */
public class App 
{
    public static void main( String[] args ) {
        //Logger theLogger = new Logger();
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

        */
        File theFile = new File("TestFile.txt");
        try {
            FileReader fileReader = new FileReader(theFile);
            BufferedReader bufferReader = new BufferedReader(fileReader);
            String entranceLine = bufferReader.readLine();
            if (entranceLine.length() > 0) {
                String[] wordArrayFromFile = entranceLine.split(" ");
                List<String> wordListFromFile = Arrays.asList(wordArrayFromFile);
                System.out.println(wordListFromFile.size());
                System.out.println(entranceLine);

                List<String> foundSentenceFromFile = theServise.findByTemplate(wordListFromFile);
                System.out.println(theServise.findTheLongestWord(wordListFromFile));
                ArrayList<String> helpfullListF = new ArrayList<String>(wordListFromFile);
                theServise.removeTheNeededString(wordListFromFile, helpfullListF);
                System.out.println(wordListFromFile.toString());

            }
        } catch (IOException ex) {
        }


    }
}
