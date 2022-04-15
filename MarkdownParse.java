//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();

        ArrayList<String> empty_link = new ArrayList<>();

        // find the next [, then find the ], then find the (, then read link upto next )
        int currentIndex = 0;
        
        if (markdown.length() == 0) {
            System.out.print("There are no links in the file.Thus, you will recieve an empty pair of brackets");
        }

        //System.out.println("file total length = " + markdown.length());
        
        while(currentIndex < markdown.length()) {
            int openBracket = markdown.indexOf("[", currentIndex);
            //System.out.println("26: currentIndex = " + currentIndex + "\n" + "26: openBracket = " + openBracket);

            int closeBracket = markdown.indexOf("]", openBracket);
            //System.out.println("29: closeBracket = " + closeBracket);

            int openParen = markdown.indexOf("(", closeBracket);
            //System.out.println("32: openParen = " + openParen);

            int closeParen = markdown.indexOf(")", openParen);
           // System.out.println("35: closeParen = " + closeParen);

            toReturn.add(markdown.substring(openParen + 1, closeParen));
            currentIndex = closeParen + 1;
        }

        return toReturn;
    }


    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
	    System.out.println(links);
    }
}
