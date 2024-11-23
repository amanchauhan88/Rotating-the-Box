class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;
        
        // Create the output matrix with swapped dimensions
        char[][] rotated = new char[n][m];
        
        // Process each row of the box to simulate gravity
        for (int i = 0; i < m; i++) {
            int emptySlot = n - 1; // Pointer for the last empty slot in the current row
            
            // Traverse the row in reverse
            for (int j = n - 1; j >= 0; j--) {
                if (box[i][j] == '*') {
                    // Reset the empty slot pointer when an obstacle is found
                    emptySlot = j - 1;
                } else if (box[i][j] == '#') {
                    // Move the stone to the last empty slot
                    box[i][j] = '.';
                    box[i][emptySlot] = '#';
                    emptySlot--;
                }
            }
        }
        
        // Rotate the box by 90 degrees clockwise
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][m - 1 - i] = box[i][j];
            }
        }
        
        return rotated; 
    
    }
}