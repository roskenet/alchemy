# Some guidelines on commenting code 

Goldilocks and the Three Bears:
not too much; not to little; just right

## Assume the reader already knows the language

You are not teaching your reader how to code. Do not explain the obvious features of the language. You are explaining the non-obvious aspects of your code.

## Write in full sentences with proper capitalization and punctuation

Comments are not code. They are the words you are writing to yourself or other readers of your code. Your comments will be much less cryptic and more easily understood if you follow this guideline.

## Comment on unusual uses of the language

Every language has oddities and idiosyncrasies that might not be used often or might be used in unexpected ways. These should be clarified and highlighted.

## Try to comment in a way that is resilient to code changes

Very often, as code changes, comments are not necessarily updated to match those changes. One way to mitigate this issue is to put comments in globs at the beginning of functions or to precede blocks of code rather than them being interspersed within code blocks. This is so that if those code blocks change, the comments are still valid. You will see examples of how to do this throughout this book.

## Comment at a high level

Describe the intent of the code and the way it attempts to solve a problem. This guideline goes hand in hand with the first guideline we mentioned. The higher the level the comments are describing, the less likely they will need to be changed as the code changes.

## Convey your intent

With your comments, strive to convey the intent of the code you are writing, why the code is needed, and what the code is trying to accomplish. What the code is actually doing should come from the code itself.

Szuhay, Jeff; Learn C Programming, Packt 2022
