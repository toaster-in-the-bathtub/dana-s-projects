abstract class Author {
    protected String name;
    private int author_id;

    public int getauthor_id() {
        return author_id;
    }
    public void setauthor_id(int author_id) {
        this.author_id = author_id;
    }

    public Author(String name) {
        this.name = name;
    }

    // abstract method
    public abstract void displayDetails();
}

