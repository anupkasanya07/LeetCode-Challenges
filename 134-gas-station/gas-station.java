class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int currentTank = 0;
        int startStation = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            
            currentTank += gas[i] - cost[i];

            // If fuel runs out before reaching station i + 1,
            // none of the stations from startStation up to i can be valid starting points.
            if (currentTank < 0) {
                startStation = i + 1;
                currentTank = 0;
            }
        }

        // If total gas is less than total cost, completing the circuit is impossible.
        return (totalGas >= totalCost) ? startStation : -1;
    }
}