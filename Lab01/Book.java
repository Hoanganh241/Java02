package task15;

public class Book {
    private static String book;
    private String TacGia;

    public Book(String book, String tacGia) {
        this.TacGia = tacGia;
        this.book = book;
    }
    public static Book createBoook(String book, String tacGia) {
        return new Book(book, tacGia);
    }

    public static String getBook() {
        return book;
    }

    public String getTacGia() {
        return TacGia;
    }
}
