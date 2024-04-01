%{
#include <stdio.h>
%}

%%
[a-zA-Z]   { printf("'%c' is a character.\n", yytext[0]); }
[0-9]     { printf("'%c' is a number.\n", yytext[0]); }
.         { printf("'%c' is something else.\n", yytext[0]); }
%%

int main() {
    printf("Enter the string: ");
    yylex();
    return 0;
}

