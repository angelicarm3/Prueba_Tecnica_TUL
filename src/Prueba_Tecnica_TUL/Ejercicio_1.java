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
        System.out.println("Frase inicial: " + s);
        
        boolean isPalindrome = false;        
        int[] num = toIntArray(s, n);
        
        num = modifyArray(num, n, k);               
        isPalindrome = validatePalindrome(num, n);
        
        String s2 = toString(num, n);
           
        if (isPalindrome) {
            return toString(num, n);
        } else {
            return "-1";
        }
    }
    
    public static int[] toIntArray(String s, int n) {
        int[] num = new int[n];
        
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(s.substring(i, i + 1));
        }
        
        return num;
    }
    
    public static int[] modifyArray(int[] num, int n, int k) {
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
        String s2 = "";

        for (int i = 0; i < n; i++) {
            s2 += Integer.toString(num[i]);
        }
        
        return s2;
    }
}
