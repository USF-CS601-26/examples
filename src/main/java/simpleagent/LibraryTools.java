package simpleagent;

import dev.langchain4j.agent.tool.Tool;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class LibraryTools {

    private final LibraryCatalog catalog;

    public LibraryTools(LibraryCatalog catalog) {
        this.catalog = catalog;
    }

    @Tool("List all available books in the library")
    public String listAvailableBooks() {
        System.out.println("[Tool] listAvailableBooks()");

        StringBuilder sb = new StringBuilder();
        catalog.getAvailableBooks().forEach(b -> sb.append(b).append(System.lineSeparator()));
        return sb.isEmpty() ? "No books available." : sb.toString();
    }

    @Tool("Checkout a book by title")
    public String checkoutBook(String title) {
        System.out.println("[Tool] checkoutBook(" + title + ")");
        boolean success = catalog.checkoutBook(title);
        return success ? "Checked out: " + title : "Book not available: " + title;
    }


    @Tool("Return a book by title")
    public String returnBook(String title) {
        System.out.println("[Tool] returnBook(" + title + ")");
        boolean success = catalog.returnBook(title);
        return success ? "Returned: " + title : "Cannot return: " + title;
    }
}