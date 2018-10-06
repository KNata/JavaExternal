package com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class App 
{
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a startpoint of the interval (int): ");
        int startPoint = sc.nextInt();
        System.out.println("Enter an endpoint of the interval (int): ");
        int endPoint = sc.nextInt();
        if (startPoint < endPoint) {
			System.out.println("Odd numbers from [" + startPoint + "; " + endPoint + "] interval");
			printOddNumbersFromInterval(startPoint, endPoint);
			System.out.println();
			System.out.println("Even numbers from [" + startPoint + "; " + endPoint + "] interval");
			printEvenNumbers(startPoint, endPoint);
			long sumOfOddNumbers = oddNumbersSum(startPoint, endPoint);
			long sumOfEvenNumbers = evenNumbersSum(startPoint, endPoint);
			System.out.println();
			System.out.println("Sum of odd numbers = " + sumOfOddNumbers);
			System.out.println("Sum of even numbers = " + sumOfEvenNumbers);
			System.out.println("Sum of even and odd numbers = " + oddAndEvenNumbersSum(sumOfOddNumbers, sumOfEvenNumbers));

            int theBiggestOddNumber = theBiggestOddNumber(startPoint, endPoint);
            int theBiggestEvenNumber = theBiggestEvenNumber(startPoint, endPoint);
            System.out.println("Enter a size of Fibonacci number: ");
            int fibonacciNumberSize = sc.nextInt();
            if (fibonacciNumberSize == 0) {
                System.out.println(1);
            } else {
                ArrayList<Long> theFibonacciNumbersList = fibonacciNumbers(fibonacciNumberSize, theBiggestOddNumber, theBiggestEvenNumber);
                System.out.println("Fibonacci numbers: ");
                for (int i = 0; i < theFibonacciNumbersList.size(); i++) {
                    System.out.println(theFibonacciNumbersList.get(i));
                }
            }
            System.out.println();
            System.out.println("The persantage of odd Fibonacci numbers: " + showPersantageOfOddNumbers(fibonacciNumberSize, startPoint, endPoint));
            System.out.println("The persantage of even Fibonacci numbers: " + (100 - showPersantageOfOddNumbers(fibonacciNumberSize, startPoint, endPoint)));

        } else {
            System.out.println("End point can't be lower than a start point");
        }

    }

    private static boolean isEven (int aNumber) {
        return ((aNumber % 2) == 0); // (aNumber & 1) == 0)
    }

    public static void printOddNumbersFromInterval(int startPoint, int endPoint) {
        for (int i = startPoint; i <= endPoint; i++) {
            if (!isEven(i)) {
                System.out.println(i);
            }
        }
    }

    public static void printEvenNumbers(int startPoint, int endPoint) {
        for (int j = endPoint; j >= startPoint; j--) {
            if (isEven(j)) {
                System.out.println(j);
            }
        }
    }

    public static long oddNumbersSum(int startPoint, int endPoint) {
        long theSum = 0;
        for (int i = startPoint; i <= endPoint; i++) {
            if (!isEven(i)) {
                theSum += i;
            }
        }
        return theSum;
    }


    public static long evenNumbersSum(int startPoint, int endPoint) {
        long theSum = 0;
        for (int i = startPoint; i <= endPoint; i++) {
            if (isEven(i)) {
                theSum += i;
            }
        }
        return theSum;
    }


    public static long oddAndEvenNumbersSum(long oddNumbersSum, long evenNumbersSum) {
        return oddNumbersSum + evenNumbersSum;
    }


    public static int theBiggestOddNumber(int startPoint, int endPoint) {
        ArrayList<Integer> oddNumbersList = new ArrayList();
        for (int i = startPoint; i <= endPoint; i++) {
            if (!isEven(i)) {
                oddNumbersList.add(i);
            }
        }
        Collections.sort(oddNumbersList);
        return oddNumbersList.get(oddNumbersList.size()-1);
    }


    public static int theBiggestEvenNumber(int startPoint, int endPoint) {
        ArrayList<Integer> evenNumbersList = new ArrayList<Integer>();
        for (int i = startPoint; i <= endPoint; i++) {
            if (isEven(i)) {
                evenNumbersList.add(i);
            }
        }
        Collections.sort(evenNumbersList);
        return evenNumbersList.get(evenNumbersList.size()-1);
    }


    public static ArrayList<Long> fibonacciNumbers(int n, long theBiggestOddNumber, long theBiggestEvenNumber) {
        long temp = 0;
        ArrayList<Long> fibonacciNumbersList = new ArrayList<Long>();
        for (int i = 2; i <= n; i++) {
            temp = theBiggestOddNumber + theBiggestEvenNumber;
            theBiggestOddNumber = theBiggestEvenNumber;
            theBiggestEvenNumber = temp;
            fibonacciNumbersList.add(theBiggestEvenNumber);
        }
        return fibonacciNumbersList;
    }


    public static double showPersantageOfOddNumbers(int n, long theBiggestOddNumber, long theBiggestEvenNumber) {
        ArrayList<Long> oddNumbersList = new ArrayList<Long>();
        long temp = 0;
        if (n == 0) {
            return theBiggestOddNumber;
        }
        for (int i = 2; i <= n; i++) {
            temp = theBiggestOddNumber + theBiggestEvenNumber;
            theBiggestOddNumber = theBiggestEvenNumber;
            theBiggestEvenNumber = temp;
            if (isEven((int)theBiggestEvenNumber)) {
                oddNumbersList.add(theBiggestEvenNumber);
            }
        }
        double thePersantage = (oddNumbersList.size() * 100) / n;
        return thePersantage;
    }


}

