java -jar java-cup-11a.jar -destdir ..\src -parser Parser -symbols Symbols -interface sintactico.cup
java -jar jFlex.jar -d ..\src lexico.flex
pause