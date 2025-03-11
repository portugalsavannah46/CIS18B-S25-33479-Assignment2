import java.util.Scanner;

public class LibraryTest {
    public static void main(String[] args) {
        Library library = Library.getInstance();
        
        // Creating items using Factory
        Book book1 = (Book) LibraryItemFactory.createItem("book", "Java Programming", 2021, "John Doe");
        Book book2 = (Book) LibraryItemFactory.createItem("book", "Data Structures", 2020, "Alice Smith");
        Magazine magazine = (Magazine) LibraryItemFactory.createItem("magazine", "Tech Monthly", 2023, "10");

        // Adding items to Library
        library.addItem(book1);
        library.addItem(book2);
        library.addItem(magazine);

        // User interaction
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nLibrary Menu:\n1. List Available Items\n2. Borrow Book\n3. Return Book\n4. Search Item\n5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    library.listAvailableItems();
                    break;
                case 2:
                    System.out.print("Enter book title to borrow: ");
                    String borrowTitle = scanner.nextLine();
                    Item borrowItem = library.findItemByTitle(borrowTitle);
                    if (borrowItem instanceof Book) {
                        System.out.print("Enter your name: ");
                        String borrowerName = scanner.nextLine();
                        ((Book) borrowItem).borrowItem(borrowerName);
                    } else {
                        System.out.println("Book not found or not borrowable.");
                    }
                    break;
                case 3:
                    System.out.print("Enter book title to return: ");
                    String returnTitle = scanner.nextLine();
                    Item returnItem = library.findItemByTitle(returnTitle);
                    if (returnItem instanceof Book) {
                        ((Book) returnItem).returnItem();
                    } else {
                        System.out.println("Book not found or not borrowable.");
                    }
                    break;
                case 4:
                    System.out.print("Enter item title to search: ");
                    String searchTitle = scanner.nextLine();
                    Item foundItem = library.findItemByTitle(searchTitle);
                    if (foundItem != null) {
                        System.out.println("Item found: " + foundItem.getTitle());
                    } else {
                        System.out.println("Item not found.");
                    }
                    break;
                case 5:
                    System.out.println("Exiting Library System...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
