class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        if(s.length()<2)
            return false;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(stack.isEmpty()){
                stack.add(c);
                continue;
            }
            if((c==')' && stack.peek() == '(') || 
                (c=='}' && stack.peek() == '{') ||
                ( c== ']' && stack.peek() == '[')){
                stack.pop();
            }else{
                stack.add(c);
            }
        }
        return stack.isEmpty();
    }
}
