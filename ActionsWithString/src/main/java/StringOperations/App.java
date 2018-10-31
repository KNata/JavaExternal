package StringOperations;

import java.io.*;
import java.io.IOException;


import java.util.*;


public class App
{
    public static void main( String[] args ) throws IOException, FileNotFoundException {
        StringSevice theServise = new StringSevice();

        System.out.println("To check string from template press 1");
        System.out.println("To enter string and check it press 2");
        System.out.println("To check string from file press 3");

        Scanner theScanner = new Scanner(System.in);
        int choice = theScanner.nextInt();
        if (choice == 1) {
            checkStringFromTemplate(theServise);
        } else if (choice == 2) {
            checkStringFromEnteredLine(theServise, theScanner);
        } else if (choice == 3) {
            checkStringFromFile(theServise);
        } else {
            System.out.println("Something went wrong... \nTry again");
        }
    }



    public static void checkStringFromTemplate (StringSevice theServise) throws IOException {
        String theSentence = "Aquamarine awfully besty cfgdhy heeeey heeeeeeeeeeeey hey";
        theServise.exameEntranceString(theSentence);
        String[] wordArray = theSentence.split(" ");
        List<String> wordList = Arrays.asList(wordArray);
        List<String> foundSentenceFromTemplate = theServise.findByTemplate(wordList);
        System.out.println("The longest word in a line is: " + theServise.findTheLongestWord(wordList));
        ArrayList<String> helpfullList = new ArrayList<String>(wordList);
        theServise.removeTheNeededString(wordList, helpfullList);
        System.out.println(helpfullList.toString());

        FileWriter writer = new FileWriter("outputFormStringTemplate.txt");
        for (int i = 0; i < helpfullList.size(); i++) {
            writer.write(helpfullList.get(i) + " ");
        }
        writer.close();
    }

    public static void checkStringFromEnteredLine(StringSevice theServise, Scanner theScanner) throws IOException{
        System.out.println("Enter a sentence: ");
        String enteredSentence = theScanner.nextLine();
        //String enteredSentence = "hey, hey, heeeyyyyy";
        System.out.println("You entered: " + enteredSentence);
        enteredSentence = theServise.exameEntranceString(enteredSentence);
        System.out.println("Proceeded sentence: " + enteredSentence);
        String[] wordArrayFromEnteredString = enteredSentence.split(" ");
        List<String> wordListFromEnteredString = Arrays.asList(wordArrayFromEnteredString);
        List<String> foundSentenceFromEnteredString = theServise.findByTemplate(wordListFromEnteredString);
       // System.out.println("All found words which starts in " + " and ends in ");
        System.out.println(foundSentenceFromEnteredString.toString());
        System.out.println("The longest word is " + theServise.findTheLongestWord(foundSentenceFromEnteredString));
        ArrayList<String> helpfullListEnteredString = new ArrayList<String>(wordListFromEnteredString);
        theServise.removeTheNeededString(wordListFromEnteredString, helpfullListEnteredString);
        System.out.println("Result list");
        System.out.println(helpfullListEnteredString.toString());

        FileWriter writer = new FileWriter("outputFormStringTemplate.txt");
        for (int i = 0; i < helpfullListEnteredString.size(); i++) {
            writer.write(helpfullListEnteredString.get(i) + " ");
        }
        writer.close();
    }

    public static void checkStringFromFile(StringSevice theServise) throws IOException, FileNotFoundException{
            File theFile = new File("TestFile.txt");
            FileReader fileReader = new FileReader(theFile);
            BufferedReader bufferReader = new BufferedReader(fileReader);
            String entranceLine = bufferReader.readLine();
            if (entranceLine.length() > 0) {
                String[] wordArrayFromFile = entranceLine.split(" ");
                List<String> wordListFromFile = Arrays.asList(wordArrayFromFile);
                System.out.println("Message in file: " + entranceLine);

                List<String> foundSentenceFromFile = theServise.findByTemplate(wordListFromFile);
                System.out.println("The longest word in a line is: " + theServise.findTheLongestWord(wordListFromFile));
                ArrayList<String> helpfullListF = new ArrayList<String>(wordListFromFile);
                theServise.removeTheNeededString(wordListFromFile, helpfullListF);
                System.out.println(helpfullListF.toString());

                FileWriter writer = new FileWriter("outputFromFile.txt");
                for (int i = 0; i < helpfullListF.size(); i++) {
                    writer.write(helpfullListF.get(i) + " ");
                }

                writer.close();
                bufferReader.close();
            }


        }


}

