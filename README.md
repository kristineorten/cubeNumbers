# cubeNumbers

## What does the code do?
### Review
The review-option gives you a list of numbers and the corresponding cubic values.

### Practice
The practice-option computes cubic numbers from values in the range
(the default range is [1,100]). The user should compute the cubic root
of the number.

## How to run the code?
`java cubeNumbers`: Runs the code with default range [1,100].

`java cubeNumbers <min> <max>`: Runs the code with range [`<min>`,`<max`]

`java cubeNumbers <max> <min>`: Runs the code with range [`<min>`,`<max`]

## Intended use
This program is intended for practicing calculating cubic roots.
A simple way to compute cubic roots of big numbers is to remove the last three digits of the number and find the closest (lower) cubic root of the rest of the number. You then take the last digit of the original number and put it at the end of the answer (special cases: 3 and 7, 2 and 8 - write 3 for 7, 7 for 3, 2 for 8 and 8 for 2). Examples:

(531441)^(1/3): 531441 -> 531. 531 is more than 512 (8^3) and less than 729 (9^3), so the number is 8. The last digit of 531441 is 1, so that means (531441)^(1/3) = 81.

(1092727)^(1/3): 1092727 -> 1092. 1092 is more than 1000 (10^3) and less than 1331 (11^3), so the number is 10. The last digit of 1092727 is 7, so the answer is 103 (because 7 -> 3 (special case)).

(729)^(1/3): 729 -> 0. 0 is equal to 0 (0^3), so the number is 0. The last digit of 729 is 9, so the answer is 9.

This method is most effective if you have memorized some cubic numbers, but you can also look them up by using the review option. Memorizing the cubic numbers from 1 (1^3=1) to 10 (10^3=1000) enables you to quickly solve cubic roots up to 1295029 (=109^3).
