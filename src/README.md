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

## Input Format (`Data/input.txt`)

The program expects five lines:

<sequence1>
<sequence2>
Match <value>
Mismatch <value>
Gap <value>


Example:
GATTACA
GCATGCU
Match 1
Mismatch -1
Gap -2


---

## Output Format (`Data/output.txt`)

The output file contains:
<optimal score>
<aligned sequence 1>
<aligned sequence 2>



Example:
0
G-ATTACA
GCAT-GCU


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


