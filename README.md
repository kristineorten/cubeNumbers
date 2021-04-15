# cubeNumbers

## What does the code do?
### Review
The review-option gives you a list of numbers and the corresponding cubic value.

### Practice
The practice-option computes cubic numbers from values in the range
(the default range is [1,100]). The user should compute the cubic root
of the number.

## How to run the code?
`<filename>`: Runs the code with default range [1,100].

`<filename> <min> <max>`: Runs the code with range [`<min>`,`<max`]

`<filename> <max> <min>`: Runs the code with range [`<min>`,`<max`]

## Theory
A simple way to compute cubic roots is to remove the last three digits of
the number and find the closest (lower) cubic root of the rest of the number
You then take the last digit of the original number and put it
at the end of the answer (special cases: 3/7, 2/8)
