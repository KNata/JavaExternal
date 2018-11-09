package StackCalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) throws IOException
    {
        String input;

    int output;
      while(true)
    {
        System.out.print("Enter postfix: ");
        System.out.flush();
        input = getString();
        if( input.equals("") )
// Ввод строки с клавиатуры
// Завершение, если нажата клавиша
// [Enter]
            break;
// Создание объекта для разбора выражения
        ParsePost aParser = new ParsePost(input);
        output = aParser.doParse();  // Обработка выражения
        System.out.println("Evaluates to " + output);
    }
}
    //--------------------------------------------------------------
    public static String getString() throws IOException
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
//--------------------------------------------------------------
}  // Конец класса PostfixApp