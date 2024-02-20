import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.sql.DriverManager;

public class Library {
    static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    static final String USERNAME = "postgres";
    static final String PASSWORD = "1";
    private Connection connection;
    private List<Book> books;


    public Library() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {

            e.printStackTrace();
        }

        this.books =new ArrayList<>();
        addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald"));
        addBook(new Book("To Kill a Mockingbird", "Harper Lee"));
        addBook(new Book("1984", "George Orwell"));
        addBook(new Book("Pride and Prejudice", "Jane Austen"));
        addBook(new Book("The Catcher in the Rye", "J.D. Salinger"));
        addBook(new Book("The Hobbit", "J.R.R. Tolkien"));
        addBook(new Book("The Chronicles of Narnia", "C.S. Lewis"));
        addBook(new Book("The Harry Potter Series", "J.K. Rowling"));
        addBook(new Book("The Lord of the Rings", "J.R.R. Tolkien"));
        addBook(new Book("The Great Expectations", "Charles Dickens"));
        addBook(new Book("Brave New World", "Aldous Huxley"));
        addBook(new Book("The Alchemist", "Paulo Coelho"));
        addBook(new Book("Moby-Dick", "Herman Melville"));
        addBook(new Book("Crime and Punishment", "Fyodor Dostoevsky"));

    }

    public Connection getConnection() {
        return connection;
    }

    public void addBook(Book book) {
        books.add(book);
    }
    public void addBookToBooks(String author, String title) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO books (title, author) VALUES (?, ?)");
            statement.setString(1, title);
            statement.setDouble(2, Double.parseDouble(author));
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void borrowBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title) && book.isAvailable()) {
                book.setAvailable(false);
                System.out.println("Book '" + title + "' borrowed successfully.");

                updateBookAvailability(title, false);

                return;
            }
        }
        System.out.println("Book '" + title + "' not available for borrowing.");
    }


    public void returnBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title) && !book.isAvailable()) {
                book.setAvailable(true);
                System.out.println("Book '" + title + "' returned successfully.");

                updateBookAvailability(title, true);

                return;
            }
        }
        System.out.println("Book '" + title + "' is not in the library or already returned.");
    }

    private void updateBookAvailability(String title, boolean b){
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE books SET is_available = ? WHERE title = ?");
            statement.setBoolean(1, b);
            statement.setString(2, title);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void displayAvailableBooks() {
        System.out.println("Available Books:");

        for (Book book : books) {
            if (book.isAvailable()) {
                System.out.println(book.getTitle() + " by " + book.getAuthor());
            }
        }
        try {
            if (connection != null) {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM books");
                while (resultSet.next()) {
                    System.out.println("Books: " + resultSet.getString("title") + " by " + resultSet.getString("author"));
                }
            } else {
                System.out.println("Connection to database is null.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
