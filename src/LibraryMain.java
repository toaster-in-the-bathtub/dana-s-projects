import java.util.InputMismatchException;
import java.util.Scanner;

public class LibraryMain {
    public static void main(String[] args) {


        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Add Book");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. Display Available Books");
            System.out.println("5. Exit");

            try {
                int choice = scanner.nextInt();
                System.out.println("Вы ввели число: " + choice);

                switch (choice) {
                    case 1:
                        System.out.println("Enter book title:");
                        scanner.nextLine();
                        String bookTitle = scanner.nextLine();

                        System.out.println("Enter author:");
                        String author = scanner.nextLine();

                        Book newBook = new Book(bookTitle, author);
                        library.addBook(newBook);
                        System.out.println("Book added successfully!");
                        break;

                    case 2:
                        System.out.println("Enter book title to borrow:");
                        scanner.nextLine();
                        String bookToBorrow = scanner.nextLine();

                        library.borrowBook(bookToBorrow);
                        break;

                    case 3:
                        System.out.println("Enter book title to return:");
                        scanner.nextLine();
                        String bookToReturn = scanner.nextLine();

                        library.returnBook(bookToReturn);
                        break;

                    case 4:
                        System.out.println("search in our library...please wait...:");
                        library.displayAvailableBooks();
                        break;

                    case 5:
                        System.out.println("Thanks for using the library!");
                        scanner.close();
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid choice. Please enter a number.");
                break;
            } finally {
                scanner.close();
                break;
            }
        }
    }
}