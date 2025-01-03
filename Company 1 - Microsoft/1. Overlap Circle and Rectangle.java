// Problem: https://leetcode.com/problems/circle-and-rectangle-overlapping/
class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        // Point to the rec nearest to circle
        int nearestX = Math.max(x1, Math.min(x2, xCenter));
        int nearestY = Math.max(y1, Math.min(y2, yCenter));

        // Distance between nearest point and center of circle
        int distX = xCenter - nearestX;
        int distY = yCenter - nearestY;

        return distX * distX + distY * distY <= radius * radius;
    }
}
