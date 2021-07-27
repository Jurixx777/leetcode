// Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

// An input string is valid if:

//     Open brackets must be closed by the same type of brackets.
//     Open brackets must be closed in the correct order.

class Solution {
    public boolean isValid(String s) {
        Stack<String> stack = new Stack<String>();
        for(char c: s.toCharArray()) {
            switch(c){
                case '[': 
                    stack.push(String.valueOf(c)); 
                    break;
                    
                case ']': 
                    if(stack.isEmpty() || stack.pop().charAt(0) != '[') return false;
                    break;
                    
                case '(': 
                    stack.push(String.valueOf(c)); 
                    break;
                    
                case ')':
                    if(stack.isEmpty() || stack.pop().charAt(0) != '(') return false;
                    break;
                    
                case '{': 
                    stack.push(String.valueOf(c)); 
                    break;
                    
                case '}':
                    if(stack.isEmpty() || stack.pop().charAt(0) != '{') return false;
                    break;
            }
        }  
        return stack.isEmpty();
    }
}
