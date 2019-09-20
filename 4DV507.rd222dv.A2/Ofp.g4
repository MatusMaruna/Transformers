grammar Ofp;

start : method* main method*;
	  

method :  'void' ID '(' parameter? ')' '{' stmt+ '}' | type ID '(' parameter? ')' '{' stmt+ returnStmt? '}' ;
main: 'void' 'main' '(' ')' '{' stmt+ '}';

stmt : expr ';'
     | asgnStmt
     | declaration
     | whileStmt
     | ifStmt
     | ifStmtOne
     | print ';'
     | returnStmt
     ; 

expr : 	'(' expr ')'
        | expr (MULT | DIV) expr
        | expr (PLUS | MINUS) expr
        | expr (SMALL | BIGGER) expr
        | expr EQ expr
        | varType
        | arrExpr | arrType | inArray
        | expr expr
        
     ;

returnStmt: 'return' expr ';' ;

parameter: type ID (',' type ID)* ;

varType : (ID|INT|FLOAT|IDmax|STR|CHAR);

asgnStmt : ID arrType? ('=' expr)? ';' ;

declaration : type arrType? ID ('=' (expr | arrType | array))? ';' ;

type : 'int' arrType?
		| 'float' arrType?
		| 'string' arrType?
		| 'char' arrType?
		| 'bool'
		;

arrExpr : 'new' type ;

array : '{' inArray+  '}' ;

inArray : varType (',' varType)* ;

arrType : ID? '[' expr? ']' ;

whileStmt : 'while' '(' condition ')' '{' stmt+ '}';

ifStmt : 'if' '(' condition ')' '{' stmt+ ('}''else''{'  stmt+)? '}';

ifStmtOne : 'if' '(' condition ')'  stmt ('else' stmt)? ;

// ifStmt : 'if' '(' condition ')' '{' stmt+ '}';

condition : (expr COP expr) | expr ;

// ASSIGN : '=' ;
PLUS : '+' ;
MINUS : '-' ;
MULT : '*' ;
DIV : '/' ;
SMALL: '<' ;
BIGGER: '>';
EQ: '==' ;
COP: SMALL|BIGGER|EQ ;

INT : '0' | ('-'?('1'..'9')+ ('0'..'9')*) ;

FLOAT : (('0'..'9')+'.'('0'..'9')+) 
		| ('-') ('0'..'9')+'.'(('1'..'9')+ | ('0'..'9')+ ('1'..'9')+)  
		| '-' ('1'..'9')+ '.' ('0'..'9')+;

ID  :	('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z')* ;
IDmax: ID'.length';
SYM: ('0'..'9'|'_'|'!'|'.'|','|'?'|'='|':'|'('|')') ;
STR: '"' (((SYM|ID)(SYM|ID)*) | ' ')* '"';
CHAR: '\'' (((SYM|ID)(SYM|ID)*) | ' ')* '\'';

COMMENT :  '#' ~[\r\n]* -> skip ;
  									
	
print : ('println'|'print') '(' (ID arrType?| STR) ')' ;

WS : [ \t\r\n]+ -> skip ;