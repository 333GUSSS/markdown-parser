all: test

test: MarkdownParse.class MarkdownParseTest.class
	/software/CSE/oracle-java-se-14/jdk-14.0.2/bin/java -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore MarkdownParseTest

MarkdownParseTest.class: MarkdownParse.class MarkdownParseTest.java
	/software/CSE/oracle-java-se-14/jdk-14.0.2/bin/javac -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar MarkdownParseTest.java

MarkdownParse.class: MarkdownParse.java
	/software/CSE/oracle-java-se-14/jdk-14.0.2/bin/javac MarkdownParse.java

clean:
	rm *.class