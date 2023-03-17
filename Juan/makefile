all: lexico sintactico

lexico: AnalizadorLexicoTiny.l
	java -cp jflex.jar jflex.Main AnalizadorLexicoTiny.l

sintactico: lexico Tiny.cup
	java -cp cup.jar java_cup.Main -parser AnalizadorSintacticoTiny -symbols ClaseLexica -nopositions Tiny.cup

Esint: sintactico
	cp AnalizadorSintacticoTiny.java AnalizadorSintacticoCUP/asint/
	cp ClaseLexica.java AnalizadorSintacticoCUP/asint/
	cp AnalizadorLexicoTiny.java AnalizadorSintacticoCUP/alex/
	cd AnalizadorSintacticoCUP; javac -cp "../cup.jar" */*.java

Eerror: sintactico
	cp AnalizadorSintacticoTiny.java RecuperacionErroresCUP/asint/
	cp ClaseLexica.java RecuperacionErroresCUP/asint/
	cp AnalizadorLexicoTiny.java RecuperacionErroresCUP/alex/
	cd RecuperacionErroresCUP; javac -cp "../cup.jar" */*.java