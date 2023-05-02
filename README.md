# Impact Take Home Test

## About
> 
 - Author: Ntepela Clinton Letsoela
 - Email: clintonletsoela724c@gmail.com

## Assumptions
> 
 - It is assumed that the input string can be in any order, thus program is designed to first sort the numbers in ascending order.
 - It is assumed that the markers understand how to compile and run Java code, thus instructions on how to run the code are not included.

## Architectural Decision Records
>
 - All variables and class names are named using camelCase.
 - The naming convention used for the unit test is as follows:
    `methodName_StateUnderTest_ExpectedBehavior`
 - The Junit testing framewoork was chosen because of its simplicity and time effeciency.
 - Since it was not stated how to deal with duplicates, the author implemented a solution that
   will include duplicates. For example, if the input is `"1,2,5,5,6,7,9"`, the output will be
   `"1-2, 5, 5-7, 9"`.

## Code Structure
>
 - The src code for the implemented solution consists of 2 folders or packages.
 - The package `numberrangesummarizer/myclasses` contains the actual src code, which
   consists of the `Main` class and the `ListOfNumbers` class. The `ListOfNumbers` class implements the `NumberRangeSummarizer` interface provided.
 - The `Tests` package consists of the `NumberRangeSummarizerTests`, which contains unit tests
   of the implemented solution.

