package arrays;

/*
 * Stock Buy And Sell
 * refer: https://takeuforward.org/data-structure/stock-buy-and-sell/
 */
public class StockBuySell {
	
	//Brute force approach
	public static int maxProfit1(int[] prices) {
		int n = prices.length;
		int maxProfit = 0;
		int profit = 0;
		
		for(int i=0; i<n; i++) {
			for(int j=i+1; j<n; j++) {
				profit = prices[j] - prices[i];
				if(profit > maxProfit) {
					maxProfit = profit;
				}
			}
		}
		
		return maxProfit;
	}
	
	//Optimal approach
	public static int maxProfit2(int[] prices) {
		int n = prices.length;
		int min = prices[0];
		int maxProfit = 0;
		int profit = 0;
		
		for(int i=1; i<n; i++) {
			if(prices[i] < min) {
				min = prices[i];
			}
			
			profit = prices[i] - min;
			
			if(profit > maxProfit) {
				maxProfit = profit;
			}
		}
		
		return maxProfit;
	}
	
	public static void main(String[] args) {
		int[] prices = {7,1,5,3,6,4};
		System.out.println("Max profit using maxProfit1: "+maxProfit1(prices));
		System.out.println("Max profit using maxProfit2: "+maxProfit2(prices));
	}

}
