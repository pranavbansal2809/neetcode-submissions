class Solution {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while(i<j){
            if(!isAlphaNum(s.charAt(i))){
                i++;
                continue;
            }else if(!isAlphaNum(s.charAt(j))){
                j--;
                continue;
            }else if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))){
                return false;
            }
            i++; j--;
        }
        return true;
    }

    public boolean isAlphaNum(char c){
        if((c>='a' && c<='z')
            || (c>='A' && c<='Z')
            || (c>='0' && c<='9')){
            return true;
        }
        return false;
    }
}
