grammar Ofp;

@header {
    package antlr4;
}

start : method* main method*;
	  
main: 'void' 'main' '(' ')' block ;

method :  'void' ID '(' parameterList? ')' block | type ('['']')? ID '(' parameterList? ')' block ;

parameter: type ID ;

parameterList: parameter (',' parameter)* ;

block: '{' localDecl* stmt* '}' ;

returnStmt: 'return' expr SC ;

type :    'int' arrType?
		| 'float' arrType?
		| 'string' arrType?
		| 'char' arrType?
		| 'bool'
		;
		
varType : 	 ID
			|MINUS? INT
			|MINUS? FLOAT
			|STR
			|CHAR
			;

stmt : asgnStmt
     | declaration
     | whileStmt
     | ifStmt
     | print
     | returnStmt
     | methodCall
     ; 

expr : 	| ID? '(' expr ')'
        | expr MULT expr
        | expr DIV expr
        | expr PLUS expr
        | expr MINUS expr
        | expr SMALL expr
        | expr BIGGER expr
        | expr EQ expr
        | 'new' type
        | ID '.length'
        | varType
        | arrayList
        | arrType        
     ;
			
localDecl: type arrType? ID SC ;

declaration : type arrType? ID '=' (expr | arrType | array) SC ;

asgnStmt : ID arrType? '=' expr SC ;

methodCall : ID '(' varType* ')' SC ;

arrayList : varType (',' varType)* ;

array : '{' arrayList+  '}' ;

arrType : ID? '[' expr ']' ;

whileStmt : 'while' '(' condition ')' '{' stmt+ '}';

ifStmt : 'if' '(' condition ')' (stmt|block) elseStmt?;

elseStmt : ('else' (stmt|block)) ;

condition : (expr COP expr) | expr ;

print : ('println'|'print') '(' (ID arrType?| STR) ')' SC ;

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
STR: '"' (((SYM|ID)(SYM|ID)*) | ' ')* '"';
CHAR: '\'' (((SYM|ID)(SYM|ID)*) | ' ')* '\'';

SYM: ('0'..'9'|'_'|'!'|'.'|','|'?'|'='|':'|'('|')') ;

COMMENT :  '#' ~[\r\n]* -> skip ;
  									
SC: ';' ;

WS : [ \t\r\n]+ -> skip ;

