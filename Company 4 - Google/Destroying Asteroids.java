// https://leetcode.com/problems/destroying-asteroids/
class Solution {
    public boolean asteroidsDestroyed(int mass, int[] ast) {
        long planet = mass;
        Arrays.sort(ast);
        if(mass < ast[0]) return false;
        for(int i=0; i<ast.length; i++) {
            if(planet >= ast[i]) planet += ast[i];
            else return false;
        }

        return true;
    }
}
