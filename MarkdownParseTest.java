import static org.junit.Assert.*;
import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.ArrayList;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    
    @Test
    public void testFile() throws IOException {
        assertEquals(List.of("https://something.com", "some-thing.html"), MarkdownParse.getLinks(Files.readString(Path.of("test-file.md"))));
        //assertEquals(Arraylist, MarkdownParse.getLinks(Files.readString(Path.of("test-file-empty.md"))));
        //assertEquals(List.of("(https://studentaid.gov/h/apply-for-aid/fafsa)"), MarkdownParse.getLinks(Files.readString(Path.of("test-file-nestedParanthesis.md"))));
        //assertEquals(List.of("https://www.youtube.com/, https://code.visualstudio.com/"), MarkdownParse.getLinks(Files.readString(Path.of("test-file-normalLinks.md"))));
    }

    @Test
    public void testFile2() throws IOException {
        //assertEquals(List.of("https://something.com", "some-thing.html"), MarkdownParse.getLinks(Files.readString(Path.of("test-file.md"))));
        //assertEquals(Arraylist, MarkdownParse.getLinks(Files.readString(Path.of("test-file-empty.md"))));
        //assertEquals(List.of("(https://studentaid.gov/h/apply-for-aid/fafsa)"), MarkdownParse.getLinks(Files.readString(Path.of("test-file-nestedParanthesis.md"))));
	assertEquals(List.of("https://www.youtube.com/", "https://code.visualstudio.com/"), MarkdownParse.getLinks(Files.readString(Path.of("test-file-normalLinks.md"))));
    }
}
