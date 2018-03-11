# Large Integers

Your task is to implement the class Num that stores and performs arithmetic operations on arbitrarily large integers. You must use the following data structure for representing Num: Linked list or Array List or Array of long integers, where the digits are in the chosen base. In particular, do not use strings to represent the numbers. Each node of the list stores exactly one long integer. The base is defined to be 10 in the starter code, but you may modify it. In the discussions below, we will use base = 10, using linked lists to represent Num. For base = 10, the number 4628 is represented by the list: 8-->2-->6-->4.

Level 1

Implement the following methods:
Num(String s): Constructor for Num class; takes a string s as parameter, with a number in decimal, and creates the Num object representing that number in the chosen base. Note that, the string s is in base 10, even if the chosen base is not 10. The string s can have arbitrary length.
Num(long x): Constructor for Num class.
String toString(): convert the Num class object into its equivalent string (in decimal). There should be no leading zeroes in the string.
Num add(Num a, Num b): sum of two numbers stored as Num.
Num subtract(Num a, Num b): given two Num a and b as parameters, representing the numbers n1 and n2 repectively, returns the Num corresponding to n1-n2.
Num product(Num a, Num b): product of two numbers.
Num power(Num x, long n): given an Num x, and n, returns the Num corresponding to x^n (x to the power n). Assume that n is a nonnegative number. Use divide-and-conquer to implement power using O(log n) calls to product and add.
printList(): Print the base + ":" + elements of the list, separated by spaces.
Level 2

Num power(Num x, Num n): return x^n, where x and n are both Num. Here x may be negative, but assume that n is non-negative.
Num divide(Num a, Num b): Divide a by b result. Fractional part is discarded (take just the quotient). If b is 0, raise an exception.
Num mod(Num a, Num b): remainder you get when a is divided by b (a%b). Assume that a is non-negative, and b > 0.
Num squareRoot(Num a): return the square root of a (truncated). Use binary search. Assume that a is non-negative.
