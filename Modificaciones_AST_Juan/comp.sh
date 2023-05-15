if [ ! -f "constructorASTCUP/Inputs/$1.jn" ]; then
    echo "constructorASTCUP/Inputs/$1.jn no existe. ¿Estás completamente seguro de que la extensión es .jn?"
    exit 1
fi

#generamos lexico
java -cp jflex.jar jflex.Main AnalizadorLexico.l
cp AnalizadorLexicoExp.java constructorASTCUP/alex/

#generamos semantico
cd evaluadorExpresionesCUP/eval 
java -cp ../../cup.jar java_cup.Main -parser Evaluador -symbols ClaseLexica -nopositions Eval.cup
cd ../..

cd constructorASTCUP/constructorast
java -cp ../../cup.jar java_cup.Main -parser ConstructorASTExp -symbols ClaseLexica -nopositions ../../ConstructorAST.cup
cd ../..

#compilamos y ejecutamos archivo
cd constructorASTCUP
javac -cp "../cup.jar:." */*.java 
echo "Compilando constructorASTCUP/Inputs/$1.jn a constructorASTCUP/$1.wat..."
java -cp "../cup.jar:." constructorast.Main Inputs/$1.jn $1.wat >> ../CompilationLog.txt

#si hay error, se para
exitValue=$? 

if [ $exitValue != 0 ] 
then 
    echo "Error en la compilación. Consulte CompilationLog.txt para más información."
exit $exitValue 
fi 

cd ..
echo "Compilando constructorASTCUP/$1.wat a $1.wasm..."
#si no, se compila y ejecuta
./wat2wasm constructorASTCUP/$1.wat
echo "Ejecutando $1.wasm..."
node runner.js $1.wasm