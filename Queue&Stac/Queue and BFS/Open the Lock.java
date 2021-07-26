// You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. 
// The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'. Each move consists of turning one wheel one slot.

// The lock initially starts at '0000', a string representing the state of the 4 wheels.

// You are given a list of deadends dead ends, meaning if the lock displays any of these codes, 
// the wheels of the lock will stop turning and you will be unable to open it.

// Given a target representing the value of the wheels that will unlock the lock, 
// return the minimum total number of turns required to open the lock, or -1 if it is impossible.

// Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
// Output: 6
// Explanation:
// A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202".
// Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" would be invalid,
// because the wheels of the lock become stuck after the display becomes the dead end "0102".

class Solution {
    //check state and if not visited add to queue  
    void addToQueue(Queue<char[]> queue, HashMap<String, String> visited, char[] node, char[] next) {
        if(!visited.containsKey(String.valueOf(next))) {
            queue.add(next);
            visited.put(String.valueOf(next), String.valueOf(node));
        }
    }
    //main method  
    public int openLock(String[] deadends, String target) {
        boolean found = false;
        char[] node = {'0','0','0','0'}; //set start position
        char[] next;
        
        Queue<char[]> queue = new LinkedList<char[]>();
        HashMap<String, String> visited = new HashMap<String, String>(); //key - current wheel position, val - previous wheel position 
        
        //put deddens to visited, we don't need to visit it
        for(String s: deadends) {
            visited.put(s,null);
        }
        //put start position to visited
        if(!visited.containsKey(String.valueOf(node))) {
            queue.add(node);
            visited.put(String.valueOf(node), null);
        }
        //rotate wheels
        while(queue.size() != 0 && found == false) {
            node = queue.poll();
            for(int i = 0; i < node.length; i++) {
                //rotate forward
                next = node.clone();
                //calc wheel next position
                next[i] = next[i] == '9' ? '0' : (char)(next[i] + 1);
                addToQueue(queue, visited, node, next);
                //if next position equals target then break
                if((found = target.equals(String.valueOf(next))) == true) break;
                
                //rotate backward
                next = node.clone();
                next[i] = next[i] == '0' ? '9' : (char)(next[i] - 1);
                addToQueue(queue, visited, node, next);
                if((found = target.equals(String.valueOf(next))) == true) break;
                
            }
        }
        //numerate previous positions
        int count = -1;
        String prev = target;
        while(prev != null && found == true) {
            count++;
            prev = visited.get(prev);
        }
        //return the total number of turns    
        return count;
    }
}
