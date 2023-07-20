/**
 *Problem: 735. Asteroid Collision
 *We are given an array asteroids of integers representing asteroids in a row.
 *For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.
 *Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
 */


class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<Integer>();

        for(int asteroid : asteroids){
            boolean flag = true;
            //Stack.peek() access the top element of the stack without removing it.
            while(!st.isEmpty() && (st.peek()>0 && asteroid < 0)){
                //The st.peek()>0 && asteroid < 0 is to indicate that a collision takes place.
                //Math.abs() is used here on out because we already know that the asteroids are going to collide and we only need to know the numberic properties.

                //If the top of the asteroid in the stack is smaller, then it will explodel
                //Hence pop it from the stack, also continue with the next asteroid in the stack
                if(Math.abs(st.peek()) < Math.abs(asteroid)){
                    st.pop();
                    continue;
                }
                //If both asteroids have the same size, then both asteroids will explode. 
                //Pop the asteroid from the stack, also, we wont push the current asteroid to the stack.
                else if(Math.abs(st.peek()) == Math.abs(asteroid)){
                    st.pop();
                }

                //If we reach here, the current asteroid will be destroyed
                //Hence, we should not add it to the stack
                flag = false;
                break;
            }

            if(flag){
                st.push(asteroid);
            }
            
        }

        //Add the asteroids from the stack to the vector in the reverse order.
        int[] remainingAsteroids = new int[st.size()];
        for(int i = remainingAsteroids.length-1; i>=0; i--){
            remainingAsteroids[i] = st.peek();
            st.pop();
        }

        return remainingAsteroids;
    }

}
