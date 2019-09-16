public class FlowerBouquets {


    /**
     *
     * type 1 bouquet = 3 roses           = p dollars
     * type 2 bouquet = 1 rose + 1 cosmos = q dollars
     *
     * Constraint: She can only every choose consecutive flowers to make a bouquet
     *
     * @param p integer denoting cost of bouquet of type 1
     * @param q integer denoting cost of bouquet of type 2
     * @param s string denoting the garden pattern, where 0 indicates rose and 1 indicates cosmos
     * @return integer denoting the max profit that Lara can make if she prepares bouquets optimally
     */
    private static int flowerBouquets(int p, int q, String s){

        int[] flowerArrangement = new int[s.length()];
        for(int i = 0; i < flowerArrangement.length; i++) {
            flowerArrangement[i] = Integer.parseInt(String.valueOf(s.charAt(i)));
        }

        int dp[] = new int[s.length()];

        // she can pluck either 2 consecutive flowers or 3 consecutive flowers from the garden
        for (int i = 0; i < flowerArrangement.length; i++){

            if ((flowerArrangement[i]==0 && flowerArrangement[i+1]==1)
            || (flowerArrangement[i]==1 && flowerArrangement[i+1]==0)){

                dp[i] = Math.max(dp[i-1], q + dp[i-2]);

            } else if (flowerArrangement[i]==0 && flowerArrangement[i+1]==0 && flowerArrangement[i+2] == 0){

                dp[i] = Math.max(dp[i-1], p + dp[i-3]);
            }
        }

        return dp[s.length()-1];
    }


    public static void main(String[] args) {

    }
}
