package task15;

import java.util.AbstractList;
import java.util.ArrayList;

public class BookList {
    private String myBook;
    private AbstractList<Book> myList;

    public BookList(String myBook) {
        this.myBook = myBook;
        this.myList = new ArrayList<Book>();
    }

    public boolean addNewBook(Book book) {
        if (findBook(Book.getBook()) >= 0) {
            System.out.println("Book is already on file");
        }
        myList.add(book);
        return true;
    }

    public boolean updateBook(Book oldBook, Book newBook) {
        int foundPosition = findBook(oldBook);
        if (foundPosition < 0) {
            System.out.println(oldBook.getBook() + ", was not found");
            return false;
        }

        this.myList.set(foundPosition, newBook);
        System.out.println(oldBook.getBook() + ", was replaced with " + newBook.getBook());
        return true;
    }

    public boolean remove(Book books) {
        int foundPosition = findBook(books);
        if (foundPosition < 0) {
            System.out.println(books.getBook() + ", was not found");
            return false;
        }
        this.myList.remove(foundPosition);
        System.out.println(books.getBook() + ", was deleted");
        return true;
    }

    private int findBook(Book book) {
        return this.myList.indexOf(book);
    }

    private int findBook(String BookName) {
        for (int i = 0; i < myList.size(); i++) {
            Book book = this.myList.get(i);
            if (Book.getBook().equals(BookName)) {
                return i;
            }
        }

        return -1;
    }


    public Book queryBook(String book){
        int position = findBook(book);
        if(position >= 0) {
            return this.myList.get(position);
        }
        return null;
    }

    public void printList() {
        System.out.println("Book list:");
        for (int i = 0; i < this.myList.size(); i++) {
            System.out.println((i + 1) + "." + this.myList.get(i).getBook() + " -> " + this.myList.get(i).getTacGia());
        }
    }
}
