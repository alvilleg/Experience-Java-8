package academy.elqoo.java8.optional;

import org.junit.Test;

import javax.swing.text.html.Option;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class OptionalTest {

    @Test
    public void shouldCreateEmptyOptional(){
        Optional<String> optional = Optional.empty(); // create empty optional
        assertThat(optional.isPresent(),equalTo(false));
    }

    @Test
    public void shouldReturnBookName(){
        Optional<Book> book = Optional8.getBook();
        String bookName = "Experience Java 8"; // book. ....
        assertThat(bookName,equalTo("Experience Java 8"));
    }

    @Test
    public void shouldReturnBookAuthor(){
        Optional<Book> book = Optional8.getBookWithAuthor();

        String authorName = book.get().getAuthor().orElse(""); // book. ....
        assertThat(authorName,equalTo("Stijn De Mulder"));
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldThrowNoElementException(){
        Optional<Book> book = Optional8.getBook();
        book.get().getAuthor().get();
    }

    @Test(expected = MyCustomException.class)
    public void shouldThrowOptionalEmptyException() throws Exception{
        Optional<Book> book = Optional8.getBook();
        book.get().getAuthor().orElseThrow(MyCustomException::new); // getAuthor.or.....
    }

}
