import java_cup.runtime.SymbolFactory;

%%
%cup
%class Scanner

%{
	private SymbolFactory sf;
	private boolean debug;
	public Scanner(java.io.InputStream r, SymbolFactory sf){
		this(r);
		this.sf=sf;
		debug=true;
	}	
%}

%eofval{
	return sf.newSymbol("EOF",Symbols.EOF);
%eofval}

nuevalinea		= \n | \n\r | \r\n

%%

"MOD" {
	if(debug)
		System.out.println("token MOD");
	return sf.newSymbol("MOD",Symbols.MOD);
}
{nuevalinea} {
	if(debug)
		System.out.println("token LINEANUEVA");
	return sf.newSymbol("LINEANUEVA",Symbols.LINEANUEVA);
}
. {
	System.err.println("Caracter Ilegal encontrado en analisis lexico: " + yytext() + "\n");
}