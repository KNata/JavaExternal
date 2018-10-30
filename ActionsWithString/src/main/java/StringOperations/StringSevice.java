package StringOperations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSevice {

    public static String BEGINNING_STRING_TEMPLATE = "h"; // check for the correct template
    public static String END_STRING_TEMPLATE = "y"; // check for the correct template


    StringSevice() {
    }

    private static boolean checkWithRegExp(String userNameString){
        Pattern p = Pattern.compile("^[a-c_-]{y}$");
        Matcher m = p.matcher(userNameString);
        return m.matches();
    }

    public List<String> findByTemplate(List<String> wordList) {
        List<String> resultStringList = new ArrayList<String>();
        for(int i = 0; i < wordList.size(); i++) {
            if(wordList.get(i).startsWith(BEGINNING_STRING_TEMPLATE) && wordList.get(i).endsWith(END_STRING_TEMPLATE)) {
                resultStringList.add(wordList.get(i));
            }
        }
        return resultStringList;
    }


    public String findTheLongestWord(List<String> selectedStrings) {
        String temp = " ";
        for (int i = 0; i < selectedStrings.size(); i++) {
            if (selectedStrings.get(i).length() >= temp.length()) {
                    temp = selectedStrings.get(i);
            }
        }
        return temp;
    }

    public void removeTheNeededString(List<String> wordList, ArrayList<String> helpfulArrayList) {
        String stringToRemove = findTheLongestWord(wordList);
        Collections.copy(helpfulArrayList, wordList);
        for(int i = 0; i < helpfulArrayList.size(); i++) {
            if (helpfulArrayList.get(i).equals(stringToRemove)) {
                helpfulArrayList.remove(i);
            }
        }
    }


    public String exameEntranceString(String aWord) {
        return aWord.replaceAll("[^a-zA-Z0-9\\\\s]", " ");
    }
}
