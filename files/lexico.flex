import java_cup.runtime.SymbolFactory;

%%
%cup
%class Scanner

%{
	private SymbolFactory sf;
	private int lineaNum;
	private boolean debug;
	public Scanner(java.io.InputStream r, SymbolFactory sf){
		this(r);
		this.sf=sf;
		lineaNum=0;
		debug=true;
	}	
%}

%eofval{
	return sf.newSymbol("EOF",Symbols.EOF);
%eofval}

digito			= [0-9]
numero			= {digito}+("."{digito}+)?
letra			= [a-zA-Z]
identificador	= {letra}([a-zA-Z0-9.%$])*
nuevalinea		= \n | \n\r | \r\n
espacio			= [ \t]+
cadena			= "\""[^;\n]*"\""

%%

"END" {
	if(debug)
		System.out.println("token END");
	return sf.newSymbol("END",Symbols.END);
}
"DIM" {
	if(debug)
		System.out.println("token DIM");
	return sf.newSymbol("DIM",Symbols.DIM);
}
"AS" {
	if(debug)
		System.out.println("token AS");
	return sf.newSymbol("AS",Symbols.AS);
}
"INTEGER" {
	if(debug)
		System.out.println("token INTEGER");
	return sf.newSymbol("INTEGER",Symbols.INTEGER);
}
"FLOAT" {
	if(debug)
		System.out.println("token FLOAT");
	return sf.newSymbol("FLOAT",Symbols.FLOAT);
}
"STRING" {
	if(debug)
		System.out.println("token STRING");
	return sf.newSymbol("STRING",Symbols.STRING);
}
"," {
	if(debug)
		System.out.println("token COMA");
	return sf.newSymbol("COMA",Symbols.COMA);
}
"=" {
	if(debug)
		System.out.println("token IGUAL");
	return sf.newSymbol("IGUAL",Symbols.IGUAL);
}
"+" {
	if(debug)
		System.out.println("token SUMA");
	return sf.newSymbol("SUMA",Symbols.SUMA);
}
"-" {
    if(debug)
		System.out.println("token REST");
	return sf.newSymbol("REST",Symbols.REST);
}
"*" {
	if(debug)
		System.out.println("token MULT");
	return sf.newSymbol("MULT",Symbols.MULT);
}
"/" {
	if(debug)
		System.out.println("token DIVI");
	return sf.newSymbol("DIVI",Symbols.DIVI);
}
"^" {
	if(debug)
		System.out.println("token POTE");
	return sf.newSymbol("POTE",Symbols.POTE);
}
"(" {
	if(debug)
		System.out.println("token LPARENT");
	return sf.newSymbol("LPARENT",Symbols.LPARENT);
}
")" {
	if(debug)
		System.out.println("token RPARENT");
	return sf.newSymbol("RPARENT",Symbols.RPARENT);
}					
"PRINT" {
	if(debug)
		System.out.println("token PRINT");
	return sf.newSymbol("PRINT",Symbols.PRINT);
}
";" {
	if(debug)
		System.out.println("token PTCO");
	return sf.newSymbol("PTCO",Symbols.PTCO);
}
"INPUT" {
	if(debug)
		System.out.println("token INPUT");
	return sf.newSymbol("INPUT",Symbols.INPUT);
}
"FOR" {
	if(debug)
		System.out.println("token FOR");
	return sf.newSymbol("FOR",Symbols.FOR);
}
"TO" {
	if(debug)
		System.out.println("token TO");
	return sf.newSymbol("TO",Symbols.TO);
}
"STEP" {
	if(debug)
		System.out.println("token STEP");
	return sf.newSymbol("STEP",Symbols.STEP);
}
"NEXT" {
	if(debug)
		System.out.println("token NEXT");
	return sf.newSymbol("NEXT",Symbols.NEXT);
}
"<=" {
	if(debug)
		System.out.println("token MENORIGUAL");
	return sf.newSymbol("MENORIGUAL",Symbols.MENORIGUAL);
}
"<" {
	if(debug)
		System.out.println("token MENOR");
	return sf.newSymbol("MENOR",Symbols.MENOR);
}
">=" {
	if(debug)
		System.out.println("token MAYORIGUAL");
	return sf.newSymbol("MAYORIGUAL",Symbols.MAYORIGUAL);
}
">" {
	if(debug)
		System.out.println("token MAYOR");
	return sf.newSymbol("MAYOR",Symbols.MAYOR);
}
"<>" {
	if(debug)
		System.out.println("token DIFERENTE");
	return sf.newSymbol("DIFERENTE",Symbols.DIFERENTE);
}
"AND" {
	if(debug)
		System.out.println("token AND");
	return sf.newSymbol("AND",Symbols.AND);
}
"OR" {
	if(debug)
		System.out.println("token OR");
	return sf.newSymbol("OR",Symbols.OR);
}
"NOT" {
	if(debug)
		System.out.println("token NOT");
	return sf.newSymbol("NOT",Symbols.NOT);
}
"IF" {
	if(debug)
		System.out.println("token IF");
	return sf.newSymbol("IF",Symbols.IF);
}
"THEN" {
	if(debug)
		System.out.println("token THEN");
	return sf.newSymbol("THEN",Symbols.THEN);
}
"ELSE" {
	if(debug)
		System.out.println("token ELSE");
	return sf.newSymbol("ELSE",Symbols.ELSE);
}
"ENDIF" {
	if(debug)
		System.out.println("token ENDIF");
	return sf.newSymbol("ENDIF",Symbols.ENDIF);
}
"WHILE" {
	if(debug)
		System.out.println("token WHILE");
	return sf.newSymbol("WHILE",Symbols.WHILE);
}
"WEND" {
	if(debug)
		System.out.println("token WEND");
	return sf.newSymbol("WEND",Symbols.WEND);
}
"DO" {
	if(debug)
		System.out.println("token DO");
	return sf.newSymbol("DO",Symbols.DO);
}
"LOOP" {
	if(debug)
		System.out.println("token LOOP");
	return sf.newSymbol("LOOP",Symbols.LOOP);
}
"UNTIL" {
	if(debug)
		System.out.println("token UNTIL");
	return sf.newSymbol("UNTIL",Symbols.UNTIL);
}
{identificador} {
	if(debug)
		System.out.println("token IDENTIFICADOR");
	return sf.newSymbol("IDENTIFICADOR",Symbols.IDENTIFICADOR,new String(yytext()));
}
{numero} {
	if(debug)
		System.out.println("token NUMERO");
	return sf.newSymbol("NUMERO",Symbols.NUMERO,new String(yytext()));
}
{cadena} {
	if(debug)
        System.out.println("token CADENA");
	return sf.newSymbol("CADENA",Symbols.CADENA,new String(yytext()));
}					
{nuevalinea} {
	lineaNum++;
	if(debug)
		System.out.println("token LINEANUEVA");
	return sf.newSymbol("LINEANUEVA",Symbols.LINEANUEVA);
}
{espacio} {
	/*Salta espacios en blanco*/
}
"'"[^\n]* {
	/*Salto comentarios*/
	if(debug)
		System.out.println("token COMENTARIO");
}
"REM"{espacio}[^\n]* {
	/* salto comentarios */
	if(debug)
		System.out.println("token COMENTARIO");
}
. {
	System.err.println("Caracter Ilegal encontrado en analisis lexico: " + yytext() + "\n");
}