// https://www.geeksforgeeks.org/problems/number-following-a-pattern3126/1
class Solution{
    static String printMinNumberForPattern(String S){
        Stack<Integer> s = new Stack<>();
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<=S.length(); i++) {
            s.push(i+1);
            
            if(i == S.length() || S.charAt(i) == 'I') {
                while(!s.isEmpty()) 
                    sb.append(s.pop());
            }
        }
        
        return sb.toString();
    }
}
