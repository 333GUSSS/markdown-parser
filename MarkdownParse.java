//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MarkdownParse {

    public static Map<String, List<String>> getLinks(File dirOrFile) throws IOException {
        Map<String, List<String>> result = new HashMap<>();
        if(dirOrFile.isDirectory()) {
	    int i = 0;
            for(File f: dirOrFile.listFiles()) {
                result.putAll(getLinks(f));
		++i;
            }
            return result;
        }
        else {
            Path p = dirOrFile.toPath();
            int lastDot = p.toString().lastIndexOf(".");
            if(lastDot == -1 || !p.toString().substring(lastDot).equals(".md")) {
                return result;
            }
            ArrayList<String> links = getLinks(Files.readString(p));
            result.put(dirOrFile.getPath(), links);
            return result;
        }
    }

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next )
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
            int openBracket = markdown.indexOf("[", currentIndex);
	    if (openBracket == -1) {
		    break;
	    }
            int closeBracket = findBraces(markdown, openBracket, '[', ']'); 
	    if (closeBracket == -1) {
		    break;
	    }
            int openParen = markdown.indexOf("(", closeBracket);
	    if (openParen == -1) {
		    break;
	    }
            int closeParen = findBraces(markdown, openParen, '(', ')');
	    if (closeParen == -1) {
		    break;
	    }
            toReturn.add(markdown.substring(openParen + 1, closeParen));
            currentIndex = closeParen + 1;
	    ++currentIndex;
        }

        return toReturn;
    }

    public static int findBraces(String markdown, int aStart, char aChar, char aCloseChar) {
	int openBrace = markdown.indexOf(aChar, aStart);
	int openCount = 0;
	int i = openBrace + 1;
	while (true) {
		if (i >= markdown.length()) {
			return -1;
		}
		char theCurr = markdown.charAt(i);
		if (theCurr == aCloseChar) {
			if (0 == openCount) {
				return i;
			} else {
				--openCount;
			}
		} else if (theCurr == aChar) {
			++openCount;
		}
		++i;
	}
    }

    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
//        String content = Files.readString(fileName);
	File theFile = fileName.toFile();
        //ArrayList<String> links = getLinks(content);
        Map<String, List<String>> links = getLinks(theFile);
	if (0 == links.size()) {
		System.out.println("No links found");
	} else {
		links.forEach((k, v) -> {
			System.out.println(k);
			System.out.println(v);
		});
	}

    }
}
