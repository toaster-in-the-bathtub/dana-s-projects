import java.util.Scanner;

public class LibraryManagementSystem {
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

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter book title:");
                    scanner.nextLine();
                    String bookTitle = scanner.nextLine();

                    System.out.println("Enter author:");
                    String author = scanner.nextLine();

                    System.out.println("Enter author nationality:");
                    String nationality = scanner.nextLine();

                    Book newBook = new Book(bookTitle, author, nationality);
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
                    System.out.println("Available Books:");
                    library.displayAvailableBooks();
                    break;

                case 5:
                    System.out.println("Thanks for using the library!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}