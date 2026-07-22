import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class LibrarySearchDemo {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book(1, "The Pragmatic Programmer", "Andrew Hunt"));
        books.add(new Book(2, "Clean Code", "Robert C. Martin"));
        books.add(new Book(3, "Introduction to Algorithms", "Thomas Cormen"));
        books.add(new Book(4, "Design Patterns", "Erich Gamma"));
        books.add(new Book(5, "Effective Java", "Joshua Bloch"));

        String target = "Clean Code";

        // --- Linear search: works on the unsorted list as-is ---
        System.out.println("Books (unsorted, insertion order):");
        books.forEach(System.out::println);

        long startLinear = System.nanoTime();
        Book foundLinear = BookSearch.linearSearchByTitle(books, target);
        long endLinear = System.nanoTime();

        System.out.println("\nLinear search for \"" + target + "\": "
                + (foundLinear != null ? foundLinear : "NOT FOUND"));
        System.out.println("Linear search took " + (endLinear - startLinear) + " ns");

        // --- Binary search: requires sorting by title first ---
        BookSearch.sortByTitle(books);
        System.out.println("\nBooks (sorted by title):");
        books.forEach(System.out::println);

        long startBinary = System.nanoTime();
        Book foundBinary = BookSearch.binarySearchByTitle(books, target);
        long endBinary = System.nanoTime();

        System.out.println("\nBinary search for \"" + target + "\": "
                + (foundBinary != null ? foundBinary : "NOT FOUND"));
        System.out.println("Binary search took " + (endBinary - startBinary) + " ns");

        // --- Searching for a title that doesn't exist ---
        String missingTitle = "Nonexistent Book";
        Book missingResult = BookSearch.binarySearchByTitle(books, missingTitle);
        System.out.println("\nBinary search for \"" + missingTitle + "\": "
                + (missingResult != null ? missingResult : "NOT FOUND"));
    }

        private static class Book {
                private final int id;
                private final String title;
                private final String author;

                Book(int id, String title, String author) {
                        this.id = id;
                        this.title = title;
                        this.author = author;
                }

                @Override
                public String toString() {
                        return id + ": " + title + " by " + author;
                }
        }

        private static class BookSearch {
                static Book linearSearchByTitle(List<Book> books, String title) {
                        for (Book book : books) {
                                if (book.title.equals(title)) {
                                        return book;
                                }
                        }
                        return null;
                }

                static void sortByTitle(List<Book> books) {
                        books.sort(Comparator.comparing(book -> book.title));
                }

                static Book binarySearchByTitle(List<Book> books, String title) {
                        int low = 0;
                        int high = books.size() - 1;
                        while (low <= high) {
                                int middle = low + (high - low) / 2;
                                Book book = books.get(middle);
                                int comparison = book.title.compareTo(title);
                                if (comparison == 0) {
                                        return book;
                                }
                                if (comparison < 0) {
                                        low = middle + 1;
                                } else {
                                        high = middle - 1;
                                }
                        }
                        return null;
                }
        }
}