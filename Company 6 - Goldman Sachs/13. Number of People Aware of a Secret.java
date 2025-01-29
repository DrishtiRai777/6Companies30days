// https://leetcode.com/problems/number-of-people-aware-of-a-secret/description/
class Solution {
    public int peopleAwareOfSecret(int totalDays, int delay, int forget) {
        int mod = 1_000_000_007;
        long[] peopleAware = new long[totalDays];
        long totalPeopleAware = 0;
        
        peopleAware[0] = 1;

        for (int i = 0; i < totalDays; i++) {
            for (int k = delay; k < forget && i + k < totalDays; k++) {
                peopleAware[i + k] = (peopleAware[i + k] + peopleAware[i]) % mod;
            }

            totalPeopleAware = (totalPeopleAware + peopleAware[i]) % mod;
            
            if (i >= forget) {
                totalPeopleAware = (totalPeopleAware - peopleAware[i - forget] + mod) % mod;
            }
        }
        
        return (int) totalPeopleAware;
    }
}
