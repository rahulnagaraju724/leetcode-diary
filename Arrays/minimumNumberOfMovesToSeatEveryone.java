class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        //2037. Minimum Number of Moves to Seat Everyone
        Arrays.sort(seats);
        Arrays.sort(students);
        int n=seats.length;
        int minMoves=0;
        for(int i=0;i<n;i++){
            minMoves+=Math.abs(seats[i]-students[i]);
        }
        return minMoves;
    }
}