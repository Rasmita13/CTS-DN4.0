class Book {
    String id, title, author;

    public Book(String id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }
}

public class LibrarySearch {
    public static Book linearSearch(Book[] books, String title) {
        for (Book b : books) {
            if (b.title.equals(title))
                return b;
        }
        return null;
    }

    public static Book binarySearch(Book[] books, String title) {
        int low = 0, high = books.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (books[mid].title.equals(title))
                return books[mid];
            else if (books[mid].title.compareTo(title) < 0)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        Book[] books = {
            new Book("B101", "Algorithms", "Author A"),
            new Book("B102", "Data Structures", "Author B"),
            new Book("B103", "Networking", "Author C")
        };
        System.out.println(linearSearch(books, "Data Structures") != null ? "Found" : "Not Found");
        System.out.println(binarySearch(books, "Networking") != null ? "Found" : "Not Found");
    }
}

