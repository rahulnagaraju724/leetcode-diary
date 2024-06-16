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

class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        int ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> student = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0; i < seats.length; i++) {
            pq.add(seats[i]);
            student.add(students[i]);
        }
        
        while (!pq.isEmpty()) {
            int a = pq.poll();
            int b = student.poll();
            ans += Math.abs(a - b);
        }
        
        return ans;
    }
}


class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
        int maxPosition = 100;
        int[] seatCount = new int[maxPosition + 1];
        int[] studentCount = new int[maxPosition + 1];
        
        for (int seat : seats) {
            seatCount[seat]++;
        }
        
        for (int student : students) {
            studentCount[student]++;
        }
        
        int seatIdx = 0;
        int studentIdx = 0;
        int moves = 0;
        
        while (seatIdx <= maxPosition && studentIdx <= maxPosition) {
            while (seatIdx <= maxPosition && seatCount[seatIdx] == 0) {
                seatIdx++;
            }
            while (studentIdx <= maxPosition && studentCount[studentIdx] == 0) {
                studentIdx++;
            }
            
            if (seatIdx <= maxPosition && studentIdx <= maxPosition) {
                int count = Math.min(seatCount[seatIdx], studentCount[studentIdx]);
                moves += count * Math.abs(seatIdx - studentIdx);
                seatCount[seatIdx] -= count;
                studentCount[studentIdx] -= count;
            }
        }
        
        return moves;
    }

}