java -jar java-cup-11a.jar -expect 100 -destdir ..\src -parser Parser -symbols Symbols -interface sintactico.cup
java -jar jFlex.jar -d ..\src lexico.flex
pause