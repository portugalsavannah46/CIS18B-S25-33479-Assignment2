public class Book extends Item implements IBorrowable {
    private String author;
    private String ISBN;
    private String borrower;

    public Book(String title, int publicationYear, String author, String ISBN) {
        super(title, publicationYear);
        this.author = author;
        this.ISBN = ISBN;
        this.borrower = null;
    }

    public String getAuthor() { return author; }
    public String getISBN() { return ISBN; }

    @Override
    public void borrowItem(String borrower) {
        if (this.borrower == null) {
            this.borrower = borrower;
            System.out.println(getTitle() + " borrowed by " + borrower);
        } else {
            System.out.println(getTitle() + " is already borrowed.");
        }
    }

    @Override
    public void returnItem() {
        this.borrower = null;
        System.out.println(getTitle() + " has been returned.");
    }

    @Override
    public boolean isBorrowed() {
        return borrower != null;
    }
}
