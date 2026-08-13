class Solution {
    public int[][] merge(int[][] intervals) {

        if (intervals == null || intervals.length == 0) {
            return new int[0][0];
        }

        // Sort by starting value
        java.util.Arrays.sort(intervals,
            (a, b) -> Integer.compare(a[0], b[0]));

        java.util.List<int[]> result = new java.util.ArrayList<>();

        // Add first interval
        result.add(intervals[0]);

        // Process remaining intervals
        for (int i = 1; i < intervals.length; i++) {

            int[] current = intervals[i];
            int[] last = result.get(result.size() - 1);

            // Overlap
            if (current[0] <= last[1]) {
                last[1] = Math.max(last[1], current[1]);
            }

            // No overlap
            else {
                result.add(current);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
