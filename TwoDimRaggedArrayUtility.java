import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TwoDimRaggedArrayUtility {
	
	/**
	 * Reads a file and returns the data in a double array.
	 * @param fileName File to be read.
	 * @return Double array with data from file.
	 * @throws FileNotFoundException File not found.
	 */
	public static double[][] readFile(File fileName) throws FileNotFoundException {
		
		// Declaring and initializing variables.
		final int MAX_ROW = 10, MAX_COLUMN = 10;
		int rowCount = 0, columnCount = 0;
		double[][] dataArray; 
		String line = "";
		
		// Create and initialize Scanner Objects.
		Scanner fileReader = new Scanner(fileName);
		Scanner lineReader = new Scanner(line);
		
		// Determining row count.
		while(fileReader.hasNextLine() && rowCount < MAX_ROW) {
			fileReader.nextLine();
			rowCount++;
		}
		
		// Initializing dataArray row size.
		dataArray = new double[rowCount][];
		
		// Reset fileReader.
		fileReader.close();
		fileReader = new Scanner(fileName);
		
		// Loop for dataArray initialization.
		for (int row = 0; fileReader.hasNextLine() && row <= MAX_ROW; row++) {
		
			// Reseting column count.
			columnCount = 0;
			
			// Initialize line.
			line = fileReader.nextLine().trim();
			// Initialize lineReader.
			lineReader = new Scanner(line);
			
			// Determining column count.
			while(lineReader.hasNextDouble() && columnCount < MAX_COLUMN) {
				lineReader.nextDouble();
				columnCount++;
			} 
			
			// Reset lineReader.
			lineReader.close();
			lineReader = new Scanner(line);
			
			// Initializing dataArray column size for row.
			if (columnCount <= MAX_COLUMN) {
				dataArray[row] = new double [columnCount];
			}
			else {
				dataArray[row] = new double [MAX_COLUMN];
			}
			
			// Loop for storing data into dataArray.
			for (int column = 0; lineReader.hasNextDouble() && column <= MAX_COLUMN; column++) {
				dataArray[row][column] = lineReader.nextDouble();				
			}
			
			// close lineReader.
			lineReader.close();
		}
		
		// Close all Scanner objects.
		fileReader.close();
		lineReader.close();
		
		// Return dataArray.
		return dataArray;
	}
	
	/**
	 * Writes a double array[][] data to a file.
	 * @param dataArray Array to be written to file.
	 * @param outputFile File to be written to.
	 * @throws FileNotFoundException File not found.
	 */
	public static void writeToFile(double[][] dataArray, File outputFile) throws FileNotFoundException {
		
		// Create PrintWriter object.
		PrintWriter output = new PrintWriter(outputFile);
		
		// Loop for writing data to file.
		for (int row = 0; row < dataArray.length; row++) {
			
			for (int column = 0; column < dataArray[row].length; column++) {
				
				output.print((dataArray[row][column]) + " ");
			}
			output.print("\n");
		}
	
		// Close PrintWriter object.
		output.close();
	}
	
	/**
	 * This method returns the sum of a double[][] array.
	 * @param dataArray Array to be summed.
	 * @return Sum of the double[][] array.
	 */
	public static double getTotal(double[][] dataArray) {
		
		// Declaring and initializing sum accumulator.
		double sum = 0;
		
		// Loop for accumulating sum.
		for (int row = 0; row < dataArray.length; row++) {
					
			for (int column = 0; column < dataArray[row].length; column++) {
						
				sum += dataArray[row][column];
			}
		}
		
		// return sum.
		return sum;
	}
	
	/**
	 * This method returns the average of a double[][] array.
	 * @param dataArray Array to be averaged.
	 * @return Average of the double[][] array.
	 */
	public static double getAverage(double[][] dataArray) {
		
		// Declaring and initializing variables.
		int numberCount = 0;
		double sum = 0, average;
		
		// Loop for calculating sum and number count.
		for (int row = 0; row < dataArray.length; row++) {
			
			numberCount += dataArray[row].length;
			
			for (int column = 0; column < dataArray[row].length; column++) {
				
				sum += dataArray[row][column];
			}
		}
		
		// Calculating average.
		average = (sum / numberCount);
		
		// Return average.
		return average;
	}
	
	/**
	 * This method returns the total at a row index in a double[][] array.
	 * @param dataArray Array to be operated on.
	 * @param index Row index for the double[][] array.
	 * @return Total at a row index of the double[][] array.
	 */
	public static double getRowTotal(double[][] dataArray, int index) {
		
		// Declaring and initializing sum accumulator.
		double sum = 0;
		
		// Loop for accumulating sum.
		for (int column = 0; column < dataArray[index].length; column++) {
			
			sum += dataArray[index][column];
		}
		
		// Return sum.
		return sum;
	}
	
	/**
	 * This method returns the total at a column index in a double[][] array.
	 * @param dataArray Array to be operated on.
	 * @param index Column index for the double[][] array.
	 * @return Total at a column index of the double[][] array.
	 */
	public static double getColumnTotal(double[][] dataArray, int index) {
		
		// Declaring and initializing sum accumulator.
		double sum = 0;
		
		// Loop for accumulating sum.
		for (int row = 0; row < dataArray.length; row++) {
			
			if (index < dataArray[row].length) {
				
				sum += dataArray[row][index];
			}
			else {
					
				// Skip iteration if row does not contain column.
				continue;
			}
		}
		
		// Return sum.
		return sum;
	}
	
	/**
	 * This method returns the highest number at a row index in a double[][] array.
	 * @param dataArray Array to be operated on.
	 * @param index Row index for the double[][] array.
	 * @return Highest number at the row index in the double[][] array.
	 */
	public static double getHighestInRow(double[][] dataArray, int index) {
		
		// Declaring and initializing double variable.
		double highest = dataArray[index][0];
		
		// Loop for calculating highest in row.
		for (int column = 1; column < dataArray[index].length; column++) {
			
			if (highest < dataArray[index][column]) {
				
				highest = dataArray[index][column];
			}
			else {

				continue;
			}
		}
		
		// Return highest.
		return highest;
	}
	
	/**
	 * This method returns the lowest number at a row index in a double[][] array.
	 * @param dataArray Array to be operated on.
	 * @param index Row index for the double[][] array.
	 * @return Lowest number at the row index in the double[][] array.
	 */
	public static double getLowestInRow(double[][] dataArray, int index) {
		
		// Declaring and initializing double variable.
		double lowest = dataArray[index][0];
		
		// Loop for calculating lowest in row.
		for (int column = 1; column < dataArray[index].length; column++) {
			
			if (lowest > dataArray[index][column]) {
				
				lowest = dataArray[index][column];
			}
			else {
				
				continue;
			}
		}
		
		// Return lowest.
		return lowest;
	}
	
	/**
	 * This method returns the highest number at a column index in a double[][] array.
	 * @param dataArray Array to be operated on.
	 * @param index Column index for the double[][] array.
	 * @return Highest number at the column index in the double[][] array.
	 */
	public static double getHighestInColumn (double[][] dataArray, int index) {
		
		// Declaring and initializing double variable.
		double highest= -999999999.999999999;
		
		// Loop for calculating highest in column.
		for (int row = 0; row < dataArray.length; row++) {
			
			if (index < dataArray[row].length && highest < dataArray[row][index]) {
				
				highest = dataArray[row][index];
			}
			else {
				
				// Skip iteration if row does not contain column.
				continue;
			}
		}
		
		// Return highest.
		return highest;
	}
	
	/**
	 * This method returns the lowest number at a column index in a double[][] array.
	 * @param dataArray Array to be operated on.
	 * @param index Column index for the double[][] array.
	 * @return Lowest number at the column index in the double[][] array.
	 */
	public static double getLowestInColumn (double[][] dataArray, int index) {
		
		// Declaring and initializing double variable.
		double lowest = 999999999.999999999;
		
		// Loop for calculating lowest in column.
		for (int row = 0; row < dataArray.length; row++) {
			
			if (index < dataArray[row].length && lowest > dataArray[row][index]) {
				
				lowest = dataArray[row][index];
			}
			else {
				
				// Skip iteration if row does not contain column.
				continue;
			}
		}
		
		// Return lowest.
		return lowest;
	}
	
	/**
	 * This method returns the highest number in a double[][] array.
	 * @param dataArray Array to be operated on.
	 * @return Highest number in the double[][] array.
	 */
	public static double getHighestInArray (double[][] dataArray) {
		
		// Declaring and initializing double variable.
		double highest = dataArray[0][0];
		
		// Loop for calculating highest in array.
		for (int row = 0; row < dataArray.length; row++) {
			
			for (int column = 0; column < dataArray[row].length; column++) {
				
				if (highest < dataArray[row][column]) {
					
					highest = dataArray[row][column];
				}
				else {
					
					continue;
				}
			}
		}
		
		// Return highest.
		return highest;
	}

	/**
	 * This method returns the lowest number in a double[][] array.
	 * @param dataArray Array to be operated on.
	 * @return Lowest number in the double[][] array.
	 */
	public static double getLowestInArray (double[][] dataArray) {
	
		// Declaring and initializing double variable.
		double lowest = dataArray[0][0];
	
		// Loop for calculating lowest in array.
		for (int row = 0; row < dataArray.length; row++) {
			
			for (int column = 0; column < dataArray[row].length; column++) {
				
				if (lowest > dataArray[row][column]) {
					
					lowest = dataArray[row][column];
				}
				else {
					
					continue;
				}
			}
		}
	
		// Return lowest.
		return lowest;
	}
}
