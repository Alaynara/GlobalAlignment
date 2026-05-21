Global Alignment Using the Needleman–Wunsch Algorithm
=====================================================

This document explains the theory behind the Needleman–Wunsch algorithm and how it is implemented in this project.

## Overview

The Needleman–Wunsch algorithm performs global sequence alignment, meaning it aligns two sequences from beginning to end.
It guarantees an optimal alignment using dynamic programming.

This project implements the algorithm in Java using four classes:
- AlignmentInput: stores sequences and scoring parameters
- ScoreMatrixBuilder: builds the scoring and pointer matrices
- Traceback:  reconstructs the optimal alignment
- GlobalAlignment: coordinates input, execution, and output

---

## Scoring Model

The algorithm uses three scoring parameters:
- Match score: reward for identical characters
- Mismatch penalty: penalty for different characters
- Gap penalty: penalty for inserting a gap (“-”)

Example scoring:
Match 1
Mismatch -1
Gap -2

These values determine how the dynamic programming matrix is filled.

---

## Matrix Initialization
Two matrices are created:
- Score matrix: stores the best score up to each cell
- Pointer matrix: stores the direction of the optimal move 
  - diagonal (match or mismatch)
  - up (gap in sequence 2)
  - left (gap in sequence 1)

## Initialization rules:

First row: cumulative gap penalties

First column: cumulative gap penalties

This ensures the alignment spans the entire length of both sequences.

---

## Matrix Filling (Dynamic Programming)

For each cell (i, j), compute three possible scores:

- Diagonal: `score[i-1] [j-1]` + match or mismatch

- Up: `score[i-1] [j]` + gap

- Left: `score[i] [j-1]` + gap

Choose the maximum of the three and store:

- the score in the score matrix

- the direction in the pointer matrix

This ensures the optimal score is always propagated forward.

---

## Traceback

Starting from the bottom-right cell:

1. Follow the pointer directions backward

2. Build the aligned sequences in reverse

3. Stop when reaching the top-left cell

## Traceback reconstructs:

- aligned sequence 1

- aligned sequence 2

- the final optimal score

---

## Example

### Input:

ACCGTATGCA
ACGTCGTA
Match 1
Mismatch -1
Gap -2

### Output:

0
ACCGTATGCA
A-CGT-CGTA

This alignment is valid and scores correctly under the given scoring model.

---

## Time and Space Complexity

Time complexity: O(n × m)
Space complexity: O(n × m)

Where:

n = length of sequence 1
m = length of sequence 2

## References

Needleman, S. B., & Wunsch, C. D. (1970). 
A general method applicable to the search for similarities in the amino acid sequence of two proteins.