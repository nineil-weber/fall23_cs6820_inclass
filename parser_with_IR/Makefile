filename = "test_IR1.txt"
directory = "testfiles/"${filename}

create: 
	jflex lcalc.flex
	java -jar java-cup-11b.jar -expect 1 -interface -parser ExprParser ycalc.cup
	javac -cp java-cup-11b.jar *.java
	jar xf java-cup-11b.jar

test:
	java Main ${directory}

clean:
	rm *.class
	rm ExprLex.java
	rm ExprParser.java
	rm sym.java
	rm -r META-INF
	rm -r java_cup
