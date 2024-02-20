abstract class Author {
    protected String name;
    protected String nationality;
    private int author_id;

    public int getauthor_id() {
        return author_id;
    }
    public void setauthor_id(int author_id) {
        this.author_id = author_id;
    }

    public Author(String name, String nationality) {
        this.name = name;
        this.nationality = nationality;
    }

    // abstract method
    public abstract void displayDetails();
}

