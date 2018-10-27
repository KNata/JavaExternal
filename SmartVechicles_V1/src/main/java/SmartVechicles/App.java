package SmartVechicles;

import java.util.Locale;
import java.util.Scanner;
import java.util.ResourceBundle;

import SmartVechicles.Controller.VechicleController;
import SmartVechicles.Model.Plane;
import SmartVechicles.View.VechicleService;

public class App {

    public enum LANGUAGES {Ukrainian, English, Polish, Russian}

    public static void main(String[] args) {
        Locale theLocale = Locale.getDefault();
        ResourceBundle currentLanguageBungle;
        System.out.println("Choose the interface language");
        System.out.println("To choose Ukrainian language, press 1");
        System.out.println("To choose English language, press 2");
        System.out.println("To choose Polish language, press 3");
        System.out.println("To choose Russian language, press 4");
        Scanner sc = new Scanner(System.in);
        int codeToChoose = sc.nextInt();
        switch (codeToChoose) {
            case 1:
                theLocale = new Locale("UA");
                currentLanguageBungle = ResourceBundle.getBundle(
                        "language", theLocale);

               System.out.println(currentLanguageBungle.getString("greetings"));

            case 2:
                theLocale = new Locale("EN");
                currentLanguageBungle = ResourceBundle.getBundle(
                        "languageEN", theLocale);
            case 3:
                theLocale = new Locale("PL");
                currentLanguageBungle = ResourceBundle.getBundle(
                        "languagePL", theLocale);
            case 4:
                theLocale = new Locale("RU");
                currentLanguageBungle = ResourceBundle.getBundle(
                        "languageRU", theLocale);
                default:
        }
       // System.out.println(currentLanguageBungle.getString("greetings"));




	}

}
