package task15;

import java.util.Scanner;

public class MainBook {
    private static Scanner scanner = new Scanner(System.in);
    private static BookList bookList = new BookList("java");


    public static void main(String[] args) {
        boolean quite = false;
        startBookList();
        while (!quite) {
            System.out.println("\n Enter action: (5 to show available action)");
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 0:
                    System.out.println("\n Shutting down...");
                    quite = true;
                    break;
                case 1:
                    bookList.printList();
                    break;
                case 2:
                    addNewBook();
                    break;
                case 3:
                    updateBook();
                    break;
                case 4:
                    removeBook();
                    break;
                case 5:
                    queryBook();
                    break;

            }


        }

    }


    private static void addNewBook() {
        System.out.println("Enter new book Name: ");
        String book = scanner.nextLine();
        System.out.println("Enter Author's name: ");
        String Author = scanner.nextLine();
        Book newBook = Book.createBoook(book, Author);
        if (bookList.addNewBook(newBook)) {
            System.out.println("New Book Added: name = " + book + ", Author " + Author);
        }
        else {
            System.out.println("Can't add, " + book + " already on life");
        }
    }

    private static void updateBook() {
        System.out.println("Enter existing Book's name: ");
        String book = scanner.nextLine();
        Book extBook = bookList.queryBook(book);
        if (extBook == null)
        {
            System.out.println("Cannot found book");
            return;
        }

        System.out.println("Enter new Book's Name: ");
        String newBook = scanner.nextLine();
        System.out.println("Enter new Author's Name: ");
        String newAuthor = scanner.nextLine();

        Book newBooks = Book.createBoook(newBook, newAuthor);
        if(bookList.updateBook(extBook, newBooks))
        {
            System.out.println("Successfully updated");
        }else {
            System.out.println("Error Updating Book");
        }
    }
    private static void removeBook() {
        System.out.println("Enter existing Book's name: ");
        String name = scanner.nextLine();
        Book extBook = bookList.queryBook(name);
        if (extBook == null){
            System.out.println("Cannot found book");
            return;
        }

        if (bookList.addNewBook(extBook)) {
            System.out.println("Successfully deleted");
        }
        else {
            System.out.println("Error Deleting Book");
        }
    }


    private static void queryBook() {
        System.out.println("Enter existing Book's name: ");
        String name = scanner.nextLine();
        Book extBook = bookList.queryBook(name);
        if(extBook == null) {
            System.out.println("Can't found Book");
            return;
        }

        System.out.println("Name: " + extBook.getBook() + " Book's name is: " + extBook.getTacGia());
    }

    private static void startBookList() {
        System.out.println("Starting book library...");
        System.out.println("0 - to shutdown\n + " +
                "1 - to print book list\n"+
                "2 - to add a new book\n"+
                "3 - to update an existing book\n"+
                "4 - to remove and existing book\n"+
                "5 - query for existing book\n"+
                "6 - to print a list of available actions.");

        System.out.println("Choose Your Action: ");
    }
}
