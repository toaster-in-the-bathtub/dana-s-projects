public class Magazine extends Author {
    private String title;
    private String publisher;
    private int magazine_id;


    public int getMagazine_id() {
        return magazine_id;
    }
    public void setmagazine_id(int magazine_id) {
        this.magazine_id = magazine_id;
    }

    public Magazine(String title, String author, String nationality, String publisher) {
        super(author, nationality);
        this.title = title;
        this.publisher = publisher;
    }

    // override abstract method
    @Override
    public void displayDetails() {
        System.out.println("Author Details - Name: " + name + ", Nationality: " + nationality + ", Publisher: " + publisher);
    }
}
