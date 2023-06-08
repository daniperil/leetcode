/**
 *Problem: 1318. Minimum Flips to Make a OR b Equal to c
 *Given 3 positives numbers a, b and c. Return the minimum flips required in some bits of a and b to make ( a OR b == c ). (bitwise OR operation).
 *Flip operation consists of change any single bit 1 to 0 or change the bit 0 to 1 in their binary representation.
 */

class Solution {
    public int minFlips(int a, int b, int c) {
        
        int counter = 0;

        if ((a | b) == c) {
            return counter;
        }   

        int[] binArrayA = new int[32]; // Array to store binary representation
        int[] binArrayB = new int[32]; // Array to store binary representation
        int[] binArrayC = new int[32]; // Array to store binary representation
        int numA = a;
        int numB = b;
        int numC = c;
        int indexA = 0;
        int indexB = 0;
        int indexC = 0;
        int indexD = 0;
    

        while (numA != 0) {
        binArrayA[indexA] = numA & 1; // Store the least significant bit
        numA = numA >>> 1; // Right shift the number by 1
        indexA++; // Move to the next bit
        }
        while (numB != 0) {
        binArrayB[indexB] = numB & 1; // Store the least significant bit
        numB = numB >>> 1; // Right shift the number by 1
        indexB++; // Move to the next bit
        }

        while (numC != 0) {
        binArrayC[indexC] = numC & 1; // Store the least significant bit
        numC = numC >>> 1; // Right shift the number by 1
        indexC++; // Move to the next bit
        }       
        
        while(indexD!=31){
        
            /**if(binArrayA[indexD]==1 && binArrayB[indexD]==0 && binArrayC[indexD]==1){
                indexD++;
            }
            if(binArrayA[indexD]==0 && binArrayB[indexD]==1 && binArrayC[indexD]==1){
                indexD++;
            }*/
            //When both a and b are 0 an c is 1
            if(binArrayA[indexD] == 0 && binArrayB[indexD] == 0 && binArrayC[indexD] == 1){
                counter++;
            }
            //When both a and b are 1 and c is 0
            if(binArrayA[indexD] == 1 && binArrayB[indexD] == 1 && binArrayC[indexD]==0){
                counter+=2;
            }

            //When 
            if(binArrayA[indexD] == 1 && binArrayB[indexD] == 0 && binArrayC[indexD]==0){
                counter++;
            }
            if(binArrayA[indexD] == 0 && binArrayB[indexD] == 1 && binArrayC[indexD]==0){
                counter++;
            }       
            /**if(binArrayA[indexD]==1 && binArrayB[indexD]==1 && binArrayC[indexD]==1){
                indexD++;
            }*/
            indexD++;
            
        }

        return counter;

    }
}
