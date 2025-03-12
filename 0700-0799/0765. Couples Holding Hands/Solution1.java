class Solution {
    public int minSwapsCouples(int[] row) {
        int n = row.length;
        int swaps = 0;

        // Map to store (person -> index)
        Map<Integer, Integer> position = new HashMap<>();
        for (int i = 0; i < n; i++) {
            position.put(row[i], i);
        }

        for (int i = 0; i < n; i += 2) {
            int firstPerson = row[i];
            int expectedPartner = firstPerson ^ 1; // Get partner (bitwise XOR)

            // If already a couple, continue
            if (row[i + 1] == expectedPartner) continue;

            // Find the current position of expectedPartner
            int partnerIndex = position.get(expectedPartner);

            // Swap row[i+1] and row[partnerIndex]
            position.put(row[partnerIndex], i + 1);
            position.put(row[i + 1], partnerIndex);

            // Swap in the array
            int temp = row[i + 1];
            row[i + 1] = row[partnerIndex];
            row[partnerIndex] = temp;

            swaps++;
        }
        return swaps;
    }
}