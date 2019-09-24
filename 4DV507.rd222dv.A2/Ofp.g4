grammar Ofp;

start : method* main method*;
	  

method :  'void' ID '(' parameter? ')' block | type ('['']')? ID '(' parameter? ')' block ;
main: 'void' 'main' '(' ')' block ;

stmt : expr ';'
     | asgnStmt
     | declaration
     | whileStmt
     | ifStmt
     | print ';'
     | returnStmt
     ; 

expr : 	| ID? '(' expr ')'
        | expr (MULT | DIV) expr
        | expr (PLUS | MINUS) expr
        | expr (SMALL | BIGGER) expr
        | expr EQ expr
        | varType
        | arrExpr | arrType | inArray        
     ;

block: '{' stmt* '}' ;

returnStmt: 'return' expr ';' ;

parameter: type ID (',' type ID)* ;

varType : (ID|MINUS? INT|MINUS? FLOAT|IDmax|STR|CHAR);

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

arrType : ID? '[' expr ']' ;

whileStmt : 'while' '(' condition ')' '{' stmt+ '}';

ifStmt : 'if' '(' condition ')' (stmt|block) ('else' (stmt|block))?;

condition : (expr COP expr) | expr ;

PLUS : '+' ;
MINUS : '-' ;
MULT : '*' ;
DIV : '/' ;
SMALL: '<' ;
BIGGER: '>';
EQ: '==' ;
COP: SMALL|BIGGER|EQ ;

INT : ('0'..'9')+ ;

FLOAT : ('0'..'9')+'.'('0'..'9')+;

ID  :	('a'..'z'|'A'..'Z')('a'..'z'|'A'..'Z')* ;
IDmax: ID'.length';
SYM: ('0'..'9'|'_'|'!'|'.'|','|'?'|'='|':'|'('|')') ;
STR: '"' (((SYM|ID)(SYM|ID)*) | ' ')* '"';
CHAR: '\'' (((SYM|ID)(SYM|ID)*) | ' ')* '\'';

COMMENT :  '#' ~[\r\n]* -> skip ;
  									
	
print : ('println'|'print') '(' (ID arrType?| STR) ')' ;

WS : [ \t\r\n]+ -> skip ;