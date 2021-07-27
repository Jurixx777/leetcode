// Given an integer n, return the least number of perfect square numbers that sum to n.

// A perfect square is an integer that is the square of an integer; in other words,
// it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.

// Exemple:
// Input: n = 12
// Output: 3
// Explanation: 12 = 4 + 4 + 4.

class Solution {
    public int numSquares(int n) {
        Queue<Integer> queue = new LinkedList<Integer>();
        HashMap<Integer, Integer> visited = new HashMap<Integer, Integer>();
        boolean found = false;
        int sqr;
        int tmpSqr;
        int sqrCnt = 1;
        int count = 0;
        
        queue.add(0);
        // With BFS template processing tree node while not found sum of nodes equal n. 
        // Each node is a sum of previous square and curent square (e.g. 1, 4 , 9 ...). Root node is 0.
        // 0 - 1 - 2 (1 + 1)
        //       - 5 (1 + 4)
        //       - 10 (1 + 9)  
        //   - 4 - ...
        //   - 9 - ...
        while(!found) {
            sqr = queue.poll();
            sqrCnt = 1;
            tmpSqr = 1;
            while(tmpSqr <= n) {
                //chec if sum is visited. if not then map sum to prev sum
                if(visited.putIfAbsent(tmpSqr + sqr, sqr) == null) {
                    queue.add(tmpSqr + sqr);
                }
                found = tmpSqr + sqr == n;
                tmpSqr = (int) Math.pow(++sqrCnt, 2);
            }
        }
        //numerate steps
        sqr = n;
        while(sqr != 0) {
            count++;
            sqr = visited.get(sqr);
        }
        
        return count;
    }
}


