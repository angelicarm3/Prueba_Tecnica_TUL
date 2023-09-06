package Prueba_Tecnica_TUL;

import java.util.Scanner;

/*
 * 
 */

/**
 *
 * @author Angelica
 */
public class Ejercicio_1 {

    public static void main(String[] args) {
        /*
        * Recieves input from console and calls highestValuePalindrome.
        */
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Ingrese el número.");
        String s = scan.nextLine();
        int n = s.length();
        System.out.println("Ingrese la cantidad de casmbios permitidos.");
        int k = scan.nextInt();
        scan.nextLine();
        
        System.out.println("Frase final: " + highestValuePalindrome(s, n, k));
        System.out.println("");
    }

    public static String highestValuePalindrome(String s, int n, int k) {
        /*
        * Recieves an array of integers (digits of a number), the array's length and the amount of changes allowed.
        * return: String (a string representation of the number) if the number is a palindrome
        * or -1 if it was imposible to trun the number into a palindrome within the amount of changes allowed. 
        */
        
        System.out.println("Frase inicial: " + s);
        
        boolean isPalindrome = false;        
        int[] num = toIntArray(s, n);
        
        num = modifyArray(num, n, k);               
        isPalindrome = validatePalindrome(num, n);
                   
        if (isPalindrome) {
            return toString(num, n);
        } else {
            return "-1";
        }
    }
    
    public static int[] toIntArray(String s, int n) {
        /*
        * Recieves a string representation of a number and the string's length.
        * return: int[] (an array of integers where each position stores a digit of the number). 
        */
        int[] num = new int[n];
        
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(s.substring(i, i + 1));
        }
        
        return num;
    }
    
    public static int[] modifyArray(int[] num, int n, int k) {
        /*
        * Recieves an array of integers (digits of a number), the array's length and the amount of changes allowed.
        * It compares the array from start to end and viceversa to modify it in order to get the highest palindrome posible
        * without exceeding the amount of changes allowed.
        * return: int[] (the array of integers modified). 
        */
        int j = n - 1;
        int flag = 0;
        
        if (num.length == 1 && k == 1) {
            num[0] = 9;
        } else {
            do {
                for (int i = 0; i < n; i++) {
                    if (num[i] != 9 && num[j] != 9) {
                        if (flag <= k - 2) {
                            num[i] = 9;
                            num[j] = 9;
                            flag += 2;
                        }
                    } else if (num[i] == 9 && num[j] != 9) {
                        if (flag <= k - 1) {
                            num[j] = 9;
                            flag++;
                        }
                    } else if (num[i] != 9 && num[j] == 9) {
                        if (flag <= k - 1) {
                            num[i] = 9;
                            flag++;
                        }
                    }

                    j--;
                }

                if (n % 2 != 0 && k == 1 && flag == 0) {
                    num[(n / 2)] = 9;
                }
            } while (flag != k && j >= 0);
        }
        
        return num;
    }
    
    public static boolean validatePalindrome(int[] num, int n) {
        /*
        * Recieves an array of integers (digits of a number) and the array's length.
        * return: boolean (true if the number is a palindrome, flase if it's not). 
         */
        boolean isPalindrome = false;
        int flag = 0;
        int j = n - 1;
        
        for (int i = 0; i < n; i++) {            
            if (num[i] != num[j]) {
                flag++;
            } 
            
            j--;
        }
        
        if (flag == 0) {
            isPalindrome = true;
        }
        else {
            isPalindrome = false;
        }
        
        return isPalindrome;
    }
    
    public static String toString (int[] num, int n) {
        /*
        * Recieves an array of integers (digits of a number) and the array's length.
        * return: String (a string representation of the number). 
         */
        String s2 = "";

        for (int i = 0; i < n; i++) {
            s2 += Integer.toString(num[i]);
        }
        
        return s2;
    }
}
