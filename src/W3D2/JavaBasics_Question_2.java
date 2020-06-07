package W3D2;
import java.util.Scanner;

abstract class Book{
    String title;								// adding member variable "title"
	abstract void setTitle(String s);			// declaring "setTitle" abstract method
    String getTitle(){
        return title;
    }
}
class MyBook extends Book{						// Declaring class MyBook by inheriting Book class
    void setTitle(String s){					// Declaring setTitle method by overriding method of Super class
        title = s;
    }
}
public class JavaBasics_Question_2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);					// Creating object of Scanner class for user input and storing it in scan variable
        String title = scan.nextLine();							// Taking user input and storing it in title variable
        MyBook book = new MyBook();								// Creating a MyBook object and storing it in book variable
        book.setTitle(title);									// calling setTitle method of object "book"
        System.out.println("The Title is: " + book.getTitle());	// Calling getTitle method and printing the result
    }
}
