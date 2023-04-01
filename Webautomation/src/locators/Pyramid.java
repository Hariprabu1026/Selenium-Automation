package locators;
import java.util.Scanner;

public class Pyramid {

	    public static void main(String[] args) {
	    	
	    	// Create a scanner to read the user's input
	        Scanner scanner = new Scanner(System.in);
	        
	        // Get the number of rows for the pyramid from the user
	        System.out.print("Enter the number of rows: ");
	        int rows = scanner.nextInt();
	        
	        // Create the pyramid
	        for (int i = 1; i <= rows; i++) {
	            // Print spaces before the stars
	            for (int j = 1; j <= rows - i; j++) {
	                System.out.print(" ");
	            }
	            // Print the stars
	            for (int k = 1; k <= 2 * i - 1; k++) {
	                System.out.print("*");
	            }
	            // Move to the next line
	            System.out.println();
	        }
	    }
	}

