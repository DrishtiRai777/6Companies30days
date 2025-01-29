// https://www.geeksforgeeks.org/problems/brackets-in-matrix-chain-multiplication1024/1
class Pair<String, Integer> {
    String expr;
    int cost;

    public Pair(String expr, int cost) {
        this.expr = expr;
        this.cost = cost;
    }
}

class Solution {
    public static Pair<String, Integer> computeOrder(int[] dims, Pair<String, Integer>[][] memo, int start, int end) {
        if (start == end) {
            String matrixLabel = "";
            matrixLabel += (char) ('A' + start - 1);
            return new Pair<>(matrixLabel, 0);
        }

        if (memo[start][end] != null && memo[start][end].cost != -1) {
            return memo[start][end];
        }

        int minCost = Integer.MAX_VALUE;
        String optimalOrder = "";

        for (int split = start; split < end; split++) {
            Pair<String, Integer> leftPart = computeOrder(dims, memo, start, split);
            Pair<String, Integer> rightPart = computeOrder(dims, memo, split + 1, end);
            int multiplicationCost = leftPart.cost + rightPart.cost + dims[start - 1] * dims[split] * dims[end];
            String currentOrder = "(" + leftPart.expr + rightPart.expr + ")";

            if (multiplicationCost < minCost) {
                minCost = multiplicationCost;
                optimalOrder = currentOrder;
            }
        }

        memo[start][end] = new Pair<>(optimalOrder, minCost);
        return memo[start][end];
    }

    public static String matrixChainOrder(int[] dims, int size) {
        Pair<String, Integer>[][] memo = new Pair[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                memo[i][j] = new Pair<>("", -1);
            }
        }

        return computeOrder(dims, memo, 1, size - 1).expr;
    }
}
