grammar CStruct;

@header { package com.freedom.cn.custom; }

porg
   : structDefine+ EOF
   ;

Identifier
    : IdentifierNondigit (Nondigit | Digit)*
    ;

fragment IdentifierNondigit
    : Nondigit
    ;
fragment Nondigit
    : [a-zA-Z_]
    ;

fragment Digit
    : [0-9]
    ;

VarName
    :  (Nondigit | Digit )+
    ;

TypeName
    : (CW|'*')+
    ;

fragment CW
   : ([a-zA-Z0-9_*-]| '[' | ']')
   ;

LINE_COMMENT: '//' .*? '\n' -> skip ;

COMMENT: '/*' .*? '*/' -> skip;

WS : [ \t\n\r]+ -> skip;

MultiLineMacro
    : '#' (~[\n]*? '\\' '\r'? '\n')+ ~ [\n]+ -> channel (HIDDEN)
    ;

Directive
    : '#' ~ [\n]* -> channel (HIDDEN)
    ;

struct
    : 'struct'
    ;

union
    : 'union'
    ;

structDefine
    : struct Identifier '{' structFields '}' ';'
    ;

structFields
    : structField+
    ;

unionInStruct
    : union '{' structFields '}' VarName ';'
    ;

structInStruct
    : struct typeSpecifier ';'
    ;

structField
    : structOrUnionField
    | unionInStruct
    | structInStruct
    ;

structOrUnionField
    : typeSpecifier ';'
    ;

typeSpecifier
     : TypeName (WS+ TypeName)*
     ;