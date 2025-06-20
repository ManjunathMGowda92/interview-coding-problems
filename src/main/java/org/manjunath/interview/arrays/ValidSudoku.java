package org.manjunath.interview.arrays;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        int n = 9;

        // Create HashSets to store the rows values, column values and box values.
        Set<Character>[] rows = new HashSet[n];
        Set<Character>[] columns = new HashSet[n];
        Set<Character>[] boxes = new HashSet[n];

        for (int i = 0; i < n; i++) {
            rows[i] = new HashSet<>();
            columns[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                char val = board[r][c];

                // Check if the position is empty, then continue to next index.
                if (val == '.') {
                    continue;
                }

                // if the row already contains the value, then return false.
                if (rows[r].contains(val)) {
                    return false;
                }
                rows[r].add(val);

                // if the column contains the value, then return false.
                if (columns[c].contains(val)) {
                    return false;
                }
                columns[c].add(val);

                // Get the index of box set, and check if the box contains the value, then return false.
                int boxIndex = (r / 3) * 3 + c / 3;
                if (boxes[boxIndex].contains(val)) {
                    return false;
                }
                boxes[boxIndex].add(val);
            }
        }
        return true;
    }
}
