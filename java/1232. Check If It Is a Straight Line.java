/**
 *Problem: 1232. Check If It Is a Straight Line
 *You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point. Check if these points make a straight line in the XY plane.
 */
 
class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        //From y=mx+b we know that the difference between xs and the difference between ys
        //must be constant along the points
        //This only works for incremental points
        /** 
        int differencex = coordinates[1][0]-coordinates[0][0];
        int differencey = coordinates[1][1]-coordinates[0][1];
        boolean resp = true;

        for(int i = 2;i<coordinates.length; i++){
            if(coordinates[i][0]-coordinates[i-1][0] != differencex || coordinates[i][1]-coordinates[i-1][1] != differencey){
                resp = false;
                return resp;
            }
        }
        return resp;
    */
        //The equation of a slope needs to be used
        // m = (y2 – y1)/(x2 – x1) 
        int x0 = coordinates[0][0];
        int y0 = coordinates[0][1];
        int x1 = coordinates[1][0];
        int y1 = coordinates[1][1];
        
        for (int i = 2; i < coordinates.length; i++) {
            int x2 = coordinates[i][0];
            int y2 = coordinates[i][1];
            //The equality between the slope of two different points with respect to the first point has to be the same.
            if ((x2 - x0) * (y1 - y0) != (y2 - y0) * (x1 - x0)) {
                return false;
            }
        }
        return true;
        
    }
}
