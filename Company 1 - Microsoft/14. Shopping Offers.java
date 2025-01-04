class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return dfs(price, special, needs, new HashMap<>());
    }

    private int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs, Map<List<Integer>, Integer> dp) {
        if (dp.containsKey(needs)) {
            return dp.get(needs);
        }

        // Base case... Buy all items without any offers
        int withoutOffer = 0;
        for (int i = 0; i < needs.size(); i++) {
            withoutOffer += needs.get(i) * price.get(i);
        }

        int minCost = withoutOffer; 

        // Try each special offer
        for (List<Integer> offer : special) {
            boolean isValid = true;

            // Check if the offer can be applied
            for (int i = 0; i < needs.size(); i++) {
                if (needs.get(i) < offer.get(i)) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                // Apply....
                for (int i = 0; i < needs.size(); i++) {
                    needs.set(i, needs.get(i) - offer.get(i));
                }
                //Rec. call...
                int offerCost = dfs(price, special, needs, dp) + offer.get(offer.size() - 1);
                // Backtracking
                for (int i = 0; i < needs.size(); i++) {
                    needs.set(i, needs.get(i) + offer.get(i));
                }
                
                minCost = Math.min(minCost, offerCost);
            }
        }
        dp.put(new ArrayList<>(needs), minCost);

        return minCost;
    }
}
