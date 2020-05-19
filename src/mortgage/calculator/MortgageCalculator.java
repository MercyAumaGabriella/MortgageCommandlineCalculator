
package mortgage.calculator;

import java.text.NumberFormat;
import java.util.Scanner;


public class MortgageCalculator {

    
    public static void main(String[] args) {
         //Creating an object that will allow me to read input.
         Scanner scan = new Scanner(System.in);
         
         //Prompting the user to input the loan amount called Principal.
         System.out.print("Principal: ");
         double amount = scan.nextDouble();
         
         //Prompting the user to input the annual interest rate.
         System.out.print("Annual Interest Rate: ");
         double annualInterest = scan.nextDouble();
         
         //Prompting the user to input the number of years given within which he/she will pay the loan.
         System.out.print("Period (Years): ");
         double years = scan.nextDouble();
         
         //Calculating the number of months and monthly interest
         double numberOfMonths = years*12;
         
         //Below the percentage is being removed from interest and the monthly interest is being found 
         double interest = annualInterest/100;
         double monthlyInterest = interest/12;
         
         /*below we have broken down the formular to find mortgage for simplicity. 
         Note that Upper represents the nominator of the equation and Lower represents
         the denominator of the equation*/
         double calculatedInterest = 1+ monthlyInterest;
         
         double UpperOne = Math.pow(calculatedInterest, numberOfMonths);
         double UpperTwo = monthlyInterest*UpperOne;
        
         double LowerOne = Math.pow(calculatedInterest, numberOfMonths);
         double LowerTwo = LowerOne-1;
         
         double Mort = UpperTwo/LowerTwo;
         double Mortage = Math.round((amount*Mort)*100)/100.0;
         
         //Converting the mortgage value into string in a currency format.
         String Mortgage = NumberFormat.getCurrencyInstance().format(Mortage);
                  
         System.out.println("Mortgage: "+ Mortgage);
         
    }
    
}
