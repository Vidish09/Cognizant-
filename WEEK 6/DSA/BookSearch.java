import java.util.Comparator;
import java.util.List;

class Book {
    private final String title;

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

public class BookSearch {

   
    static Book linearSearchByTitle(List<Book> books, String targetTitle) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(targetTitle)) {
                return book;
            }
        }
        return null; // not found
    }

    /**
     * Binary search by title. PRECONDITION: `books` must already be sorted
     * ascending by title (see sortByTitle below), or results are undefined.
     * Time complexity: O(log n)
     */
    static Book binarySearchByTitle(List<Book> books, String targetTitle) {
        int low = 0;
        int high = books.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2; // avoids overflow vs (low+high)/2
            Book midBook = books.get(mid);
            int comparison = midBook.getTitle().compareToIgnoreCase(targetTitle);

            if (comparison == 0) {
                return midBook; // found
            } else if (comparison < 0) {
                low = mid + 1;  // target is alphabetically after mid; search right half
            } else {
                high = mid - 1; // target is alphabetically before mid; search left half
            }
        }
        return null; // not found
    }

    /**
     * Sorts the given list of books by title, ascending.
     * Must be called before binarySearchByTitle to satisfy its precondition.
     */
    public static void sortByTitle(List<Book> books) {
        books.sort(Comparator.comparing(Book::getTitle, String.CASE_INSENSITIVE_ORDER));
    }
}