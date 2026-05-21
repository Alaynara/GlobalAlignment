# Global Alignment (Needleman–Wunsch Algorithm)

A Java implementation of the Needleman–Wunsch global alignment algorithm, used in bioinformatics to compute the optimal alignment between two DNA, RNA, or protein sequences.

This program reads input from `Data/input.txt`, constructs the scoring and pointer matrices, performs traceback, and writes the optimal alignment and score to `Data/output.txt`.

---

## Features

- Full implementation of the Needleman–Wunsch dynamic programming algorithm
- Modular Java design using multiple classes
- Reads sequences and scoring parameters from a text file
- Handles empty‑string edge cases
- Outputs:
    - Optimal alignment score
    - Aligned sequence 1
    - Aligned sequence 2
- Can be run from IntelliJ or the command line

---

## Project Structure
```
GlobalAlignment/
├── Data/
│    ├── input.txt
│    └── output.txt
├── src/
│    └── alignment/
│         ├── AlignmentInput.java
│         ├── ScoreMatrixBuilder.java
│         ├── Traceback.java
│         └── GlobalAlignment.java
├── .gitignore
└── README.md
```

---

## Input

The program reads all required data from a text file. The file must contain the
following values in order, each on its own line:

1. Sequence 1
2. Sequence 2
3. Match score (integer)
4. Mismatch penalty (integer)
5. Gap penalty (integer)

Example:

GATTACA
GCATGCU
1
-1
-2

---

## Output

The program writes the results to an output file containing:

- The optimal global alignment of the two sequences
- The final alignment score
- (Optional) the scoring matrix used during computation

Example:

Alignment Score: 0

G A T T A C A
| |   |   | |
G C A T - G C U

---

## How to Run

### Running in IntelliJ IDEA

1. Open the project in IntelliJ
2. Ensure the folder structure matches the layout above
3. Place your `input.txt` inside the `Data/` folder
4. Run `GlobalAlignment.java`
5. View results in `Data/output.txt`

### Running from the Command Line

From the project root:
javac src/alignment/*.java
java -cp src alignment.GlobalAlignment


---

## Algorithm Overview

The Needleman–Wunsch algorithm performs global alignment using dynamic programming:

1. Initialize a scoring matrix with cumulative gap penalties
2. Fill the matrix using match, mismatch, and gap scores
3. Record traceback directions in a pointer matrix
4. Trace back from the bottom‑right corner to reconstruct the optimal alignment

This guarantees the optimal alignment across the full length of both sequences.

---

## Testing

JUnit tests can be added to verify:

- Scoring matrix initialization
- DP recurrence correctness
- Traceback correctness
- Edge cases such as empty sequences

---

## Author

Alayna Ra  
Computer Science Engineering Student  
Eastern Washington University


