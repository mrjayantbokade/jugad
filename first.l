%{
#include <stdio.h>
%}

%%

%%

int main() {
    char input[100]; // Assuming a maximum input length of 100 characters
    printf("Enter a string: ");
    fgets(input, sizeof(input), stdin); // Read input from user

    // Initialize character count
    int charCount = 0;

    // Process each character in the input
    for (int i = 0; input[i] != '\0'; i++) {
        if (input[i] != '\n') // Ignore newline characters
            charCount++;
    }

    printf("Number of characters in the input string: %d\n", charCount);
    return 0;
}

