# Onion-Routing-Recursive-Project
🧠 Core Idea Recap
We’re building a recursive class that:
Accepts a binary number as an array of ints (e.g., {1, 0, 1, 0, 1}).
Recursively peels off the outer bits.
Flips the center bit when only one remains.
Reconstructs the binary number with the flipped center and original outer bits.


A small Java console program that:
1. Prompts the user for the length of a binary number (**must be odd and positive**).
2. Prompts for the actual binary number.
3. Validates that the input is strictly binary (`0` and `1`) and matches the given length.
4. Converts the number into an `ArrayList<Long>` while preserving **leading zeros**.
5. **Flips the bits** recursively from the **outside inward** (first & last bits, then next inner pair, etc.) until it reaches the middle.
6. Prints the flipped binary number.

This project demonstrates:
- Input validation
- Recursion
- ArrayList manipulation
- Simple defensive programming 
