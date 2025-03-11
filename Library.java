import java.util.ArrayList;

public class Library {
    private static Library instance;
    private ArrayList<Item> items;

    private Library() {
        items = new ArrayList<>();
    }

    public static Library getInstance() {
        if (instance == null) {
            instance = new Library();
        }
        return instance;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void listAvailableItems() {
        System.out.println("Available Items in Library:");
        for (Item item : items) {
            if (item instanceof Book && ((Book) item).isBorrowed()) continue;
            System.out.println(item.getTitle());
        }
    }

    public Item findItemByTitle(String title) {
        for (Item item : items) {
            if (item.getTitle().equalsIgnoreCase(title)) {
                return item;
            }
        }
        return null;
    }
}
