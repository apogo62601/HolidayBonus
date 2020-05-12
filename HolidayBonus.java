
public class HolidayBonus {
	
	/**
	 * This method returns a double[][] array containing holiday bonuses for stores.
	 * @param dataArray Double[][] array containing sales.
	 * @param highBonus Bonus amount for the highest performing store.
	 * @param lowBonus Bonus amount for the lowest performing store.
	 * @param otherBonus Bonus amount for all other stores.
	 * @return Double[][] array containing holiday bonuses for stores.
	 */
	public static double[] calculateHolidayBonus(double[][] dataArray, double highBonus, double lowBonus, double otherBonus) {
		
		// Declaring and initializing arrays and variables.
		double [] bonusArray = new double[dataArray.length];
		double highest;
		double lowest;
		int maxColumn = dataArray[0].length;
		
		// For loop for determining max column.
		for (int row = 1; row < dataArray.length; row++) {
			
			if(maxColumn < dataArray[row].length)
				maxColumn = dataArray[row].length;
			else {
				continue;
			}
		}
		
		// For loop for initializing bonusArray length and data.
		for(int column = 0, row = 0; row < dataArray.length && column < maxColumn; column++, row++) {
		
			// Initialize variables to hold the highest number in column.
			highest = TwoDimRaggedArrayUtility.getHighestInColumn(dataArray, column);
			lowest = TwoDimRaggedArrayUtility.getLowestInColumn(dataArray, column);
			
			// For loop for assigning holiday bonus to stores.
			for(int row2 = 0; row2 < dataArray.length; row2++) {
				
				if (column >= dataArray[row2].length) {
					continue;
				}
				else if (dataArray[row2][column] == highest) {
					bonusArray[row2] += highBonus;
				} 
				else if (dataArray[row2][column] == lowest) {
					bonusArray[row2] += lowBonus;
				}
				else {
					bonusArray[row2] += otherBonus;
				}
			}
		}
		
		// Return bonusArray.
		return bonusArray;
	}
	
	/**
	 * This method returns the total of the holiday bonus array.
	 * @param dataArray Double[][] array containing sales.
	 * @param highBonus Bonus for the highest performing store.
	 * @param lowBonus Bonus for the lowest performing store.
	 * @param otherBonus Bonus for all other stores.
	 * @return Total of the holiday bonus array.
	 */
	public static double calculateTotalHolidayBonus(double[][] dataArray, double highBonus, double lowBonus, double otherBonus) {
		
		// Declaring and initializing variables.
		double sum = 0;
		double [] bonusArray = HolidayBonus.calculateHolidayBonus(dataArray, highBonus, lowBonus, otherBonus);
		
		// For loop for accumulating sum.
		for (int row = 0; row < bonusArray.length; row++) {
			
			sum += bonusArray[row];
		}
		
		// Return sum.
		return sum;
	}
}
