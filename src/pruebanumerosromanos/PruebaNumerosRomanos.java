/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebanumerosromanos;

/**
 *
 * @author Julio Chan
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class PruebaNumerosRomanos {
    
    private static final String[][] ROMAN = {
        {"I", "V"},
        {"X", "L"},
        {"C", "D"},
        {"M", "M"}
    };

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner r = new Scanner(System.in);
        int number = 0;
        String romanNumber = "";
        
        System.out.println("Ingrese un número");
        
        try {
            number = r.nextInt();
            
            romanNumber = decToRom(number);
            System.out.println(romanNumber);
        }
        catch (InputMismatchException e) {
            System.out.println("Debe ingresar un número entero");
        }

        r.close();
    }
    
    public static String decToRom(Integer number) {
        String romanNumber = "",
               strNumber = number.toString();
        String[] digits = strNumber.split("");
        
        if (number > 0 && number <= 1000) {
            for (int i = 0; i < digits.length; i++) {
                int position = Math.abs((i + 1) - digits.length);
                romanNumber += getRomanNumber(digits[i], position);
            }
        }
        else {
            return "El número debe estar entre el 1 y el 1000";
        }
        
        return romanNumber;
    }
    
    private static String getRomanNumber(String digit, int position) {
        String romanNumber = "";
        int digt = Integer.parseInt(digit);
        
        if (digt <= 3) {
            for(int i = 0; i < digt; i++) {
                romanNumber += ROMAN[position][0];
            }
        }
        else if (digt  == 4) {
            romanNumber = ROMAN[position][0] + ROMAN[position][1];
        }
        else if (digt >= 5 && digt <= 8) {
            String units = "";
            int remaider = digt - 5;
            
            for (int i = 0; i < remaider; i++) {
                units += ROMAN[position][0];
            }
            
            romanNumber = ROMAN[position][1] + units;
        }
        else if (digt == 9) {
            romanNumber = ROMAN[position][0] + ROMAN[position + 1][0];
        }
        
        return romanNumber;
    }

}
