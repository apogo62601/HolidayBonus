import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class TwoDimRaggedArrayUtilitySTUDENT_Test3 {

	//STUDENT fill in dataSetSTUDENT with values, it must be a ragged array
	private double[][] dataSetSTUDENT;
		
	private File inputFile, outputFile;
	

	
	@BeforeEach
	void setUp() throws Exception {
		outputFile = new File("C:\\Users\\maste_000\\Desktop\\StudentTest3.txt");
		inputFile = new File("C:\\Users\\maste_000\\Desktop\\Assignment 5- Student Dataset 2.txt");
		dataSetSTUDENT = TwoDimRaggedArrayUtility.readFile(inputFile);
	}

	@AfterEach
	void tearDown() throws Exception {
		dataSetSTUDENT = null;
		inputFile = outputFile = null;
	}

	/**
	 * Student Test getTotal method
	 * Return the total of all the elements in the two dimensional array
	 */
	@Test
	void testGetTotal() {
		assertEquals(47.9, TwoDimRaggedArrayUtility.getTotal(dataSetSTUDENT));
	}

	/**
	 * Student Test getAverage method
	 * Return the average of all the elements in the two dimensional array
	 */
	@Test
	void testGetAverage() {
		assertEquals((47.9/11), TwoDimRaggedArrayUtility.getAverage(dataSetSTUDENT));
	}

	/**
	 * Student Test getRowTotal method
	 * Return the total of all the elements of the row.
	 * Row 0 refers to the first row in the two dimensional array
	 */
	@Test
	void testGetRowTotal() {
		assertEquals(10, TwoDimRaggedArrayUtility.getRowTotal(dataSetSTUDENT, 2));	
	}

	/**
	 * Student Test getColumnTotal method
	 * Return the total of all the elements in the column. If a row in the two dimensional array
	 * doesn't have this column index, it is not an error, it doesn't participate in this method.
	 * Column 0 refers to the first column in the two dimensional array
	 */
	@Test
	void testGetColumnTotal() {
		assertEquals(10.5, TwoDimRaggedArrayUtility.getColumnTotal(dataSetSTUDENT, 2));	
	}

	/**
	 * Student Test getHighestInArray method
	 * Return the largest of all the elements in the two dimensional array.
	 */
	@Test
	void testGetHighestInArray() {
		assertEquals(9.5, TwoDimRaggedArrayUtility.getHighestInArray(dataSetSTUDENT));
	}
	
	/**
	 * Test the writeToFile method
	 * write the array to the outputFile File
	 * then read it back to make sure formatted correctly to read
	 * @throws FileNotFoundException File not found.
	 */
	@Test
	void testWriteToFile() throws FileNotFoundException {
		double[][] array;
		TwoDimRaggedArrayUtility.writeToFile(dataSetSTUDENT, outputFile);
		array = TwoDimRaggedArrayUtility.readFile(outputFile);
		
		for (int row = 0 ; row < array.length && row < dataSetSTUDENT.length; row++) {
		
			for(int column = 0; column < array[row].length && column < dataSetSTUDENT[row].length; column++) {
				
				assertTrue(array[row][column] == dataSetSTUDENT[row][column]);
			}
		}
	}
}
