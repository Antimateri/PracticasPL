ast: lexico
	cd evaluadorExpresionesCUP/eval; java -cp ../../cup.jar java_cup.Main -parser Evaluador -symbols ClaseLexica -nopositions Eval.cup
	cd constructorASTCUP/constructorast; java -cp ../../cup.jar java_cup.Main -parser ConstructorASTExp -symbols ClaseLexica -nopositions ../../ConstructorAST.cup
	cd constructorASTCUP; javac -cp "../cup.jar:." */*.java; java -cp "../cup.jar:." constructorast.Main  input.txt

lexico:
	java -cp jflex.jar jflex.Main AnalizadorLexicoAbur.l
	cp AnalizadorLexicoExp.java constructorASTCUP/alex/

true:
	java -cp jflex.jar jflex.Main AnalizadorLexicoDiver.l
	cp AnalizadorLexicoExp.java constructorASTCUP/alex/
	cd evaluadorExpresionesCUP/eval; java -cp ../../cup.jar java_cup.Main -parser Evaluador -symbols ClaseLexica -nopositions Eval.cup
	cd constructorASTCUP/constructorast; java -cp ../../cup.jar java_cup.Main -parser ConstructorASTExp -symbols ClaseLexica -nopositions ../../ConstructorAST.cup
	cd constructorASTCUP; javac -cp "../cup.jar:." */*.java; java -cp "../cup.jar:." constructorast.Main  ../trueInput.txt