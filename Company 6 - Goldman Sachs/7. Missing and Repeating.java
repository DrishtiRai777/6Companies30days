// https://www.geeksforgeeks.org/problems/find-missing-and-repeating2512/1
// XOR Method
class Solution {
    public static int ithBit(int num, int k) {
        return (num & (1 << k)) != 0 ? 1 : 0;
    }
    
    public static int setBit(int num) {
        int i=31;
        while(i >= 0) {
            if((num & (1 << i)) != 0) return i;
            i--;
        }
        
        return -1;
    }
    
    ArrayList<Integer> findTwoElement(int arr[]) {
        // Finding that ultimate number
        int xor = 0;
        for(int i=1; i<=arr.length; i++) {
            xor ^= arr[i-1];
            xor ^= i;
        }
        
        int setBit = setBit(xor);
        int xor1 = 0, xor2 = 0;
        
        for(int i=1; i<=arr.length; i++) {
            if(ithBit(arr[i-1], setBit) == 1) xor1 ^= arr[i-1];
            else xor2 ^= arr[i-1];
            
            // Numbers...
            if(ithBit(i, setBit) == 1) xor1 ^= i;
            else xor2 ^= i;
        }
        
        // See if the number in xor1 is missing or repeating
        boolean flag = false;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == xor1) {
                flag = true;
                break;
            }
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        
        if(flag == false) {
            list.add(xor2);
            list.add(xor1);
        }
        else {
            list.add(xor1);
            list.add(xor2);
        }
        
        return list;
    }
}
