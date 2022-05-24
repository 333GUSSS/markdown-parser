import static org.junit.Assert.*;
import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.ArrayList;

public class MarkdownParseTest {

    @Test
    public void testSnippet1() throws IOException {
        assertEquals(List.of("url.com", "`google.com", "ucsd.edu"), MarkdownParse.getLinks(Files.readString(Path.of("test-snippet-1.md"))));
    }
    
    @Test
    public void testSnippet2() throws IOException {
        assertEquals(List.of("b.com", "a.com(())", "example.com"), MarkdownParse.getLinks(Files.readString(Path.of("test-snippet-2.md"))));
    }

    @Test
    public void testSnippet3() throws IOException {
        assertEquals(List.of("https://something.com", "some-thing.html"), MarkdownParse.getLinks(Files.readString(Path.of("test-snippet-3.md"))));
    }
    
    
}


/*
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    
    @Test
    public void testFile() throws IOException {
        assertEquals(List.of("https://something.com", "some-thing.html"), MarkdownParse.getLinks(Files.readString(Path.of("test-file.md"))));
    }

    @Test
    public void testFile2() throws IOException {
	    assertEquals(List.of("https://www.youtube.com/", "https://code.visualstudio.com/"), MarkdownParse.getLinks(Files.readString(Path.of("test-file-normalLinks.md"))));
    }
    */
