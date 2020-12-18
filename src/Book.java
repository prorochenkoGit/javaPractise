

/*.Создать класс, описывающий книгу (Book).
    В классе должны быть описаны нужные свойства книги(автор, название,
    год написания и т. д.)и методы для получения, изменения этих свойств.
    Протестировать работу класса в классе BookTest, содержащим метод
     статический main(String[] args).*/
public class Book {
    private String author;
    private String title;
    private int  year_of_writing;
        public String getTitle() {
            return title;
        }
        public String getAuthor() {
            return author;
        }
        public int getYearOfWriting() {
            return year_of_writing;
        }
        public Book(String title, String author, int year_of_writing){
            this.title=title; this.author=author; this.year_of_writing=year_of_writing;
        }
        public void info(){
            System.out.println("Название: " + title + " Автор: " + author + " Год написания: " + year_of_writing);
        }

}
class BookTest{
    public static void main(String[] args) {
        Book book = new Book("'Театр'","Сомерсет Моэм",1937);
        String title = book.getTitle();
        String author = book.getAuthor();
        int year = book.getYearOfWriting();
        System.out.println(title + " " + author + " " + year);

    }
}
