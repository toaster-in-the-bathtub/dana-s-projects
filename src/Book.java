class Book extends Author {
    private String title;
    private boolean isAvailable;
    private int book_id;


    public int getbook_id() {
        return book_id;
    }
    public void setbook_id() {
        this.book_id = book_id;
    }



    public Book(String title, String author, String nationality) {
        super(author, nationality);
        this.title = title;
        this.isAvailable = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return title;
    }

    public String getNationality() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }


    // override abstract method
    @Override
    public void displayDetails() {
        System.out.println("Author Details - Name: " + name + ", Nationality: " + nationality);
        System.out.println("Book Title: " + title);
    }


    public void borrowBook() {
        if (isAvailable) {
            System.out.println("Book '" + title + "' is borrowed.");
            isAvailable = false;
        } else {
            System.out.println("Book '" + title + "' is not available for borrowing.");
        }
    }

    public void returnBook() {
        if (!isAvailable) {
            System.out.println("Book '" + title + "' is returned.");
            isAvailable = true;
        } else {
            System.out.println("Book '" + title + "' was not borrowed.");
        }
    }


    public void setAvailability(boolean available) {
        this.isAvailable = available;
    }
}
