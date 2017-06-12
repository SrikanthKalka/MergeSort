public class MergeSortImpl {

	public static int[] arrayOfNumbers = { 56, 85, 0, 30, 36, 33, 39, 11 };
	public static int[] result_Array;

	// To Merge the given array.
	public static int[] mergeInputArray(int[] inputArray) {

		if (inputArray.length <= 1)
			return inputArray;

		int mid_point = inputArray.length / 2;

		// Some times length of the array will be odd number
		// (eg: 9 then midpoint is 4 , hence Left array should be 4 and right
		// array should be 5 elements)
		int[] left_array = new int[mid_point];
		int[] right_array;

		// Right array merge Logic
		if (inputArray.length % 2 == 0) {
			right_array = new int[mid_point];
		} else {
			right_array = new int[mid_point + 1];
		}

		// Upto above code, just we have merged the cell and created as Right &
		// Left array (No values exist in the cells)
		// To insert input array values, in to merged Left array

		for (int i = 0; i < mid_point; i++) {
			left_array[i] = inputArray[i];
		}

		System.out.print("\nLeft[ ]: ");
		printElements(left_array);

		// To insert input array values in to merged Right array
		// Right array starts from Midpoint (Hence we need to insert values from
		// midpoint to till end)
		int right_index = 0;
		for (int j = mid_point; j < inputArray.length; j++) {

			if (right_index < right_array.length) {
				right_array[right_index] = inputArray[j];
				right_index++;
			}
		}

		System.out.print("Right[ ]: ");
		printElements(right_array);
		System.out.println("\n========================");

		left_array = mergeInputArray(left_array);
		right_array = mergeInputArray(right_array);

		result_Array = mergeSort(left_array, right_array);

		return result_Array;

	}

	private static int[] mergeSort(int[] left_array, int[] right_array) {

		int lenght_result = left_array.length + right_array.length;
		result_Array = new int[lenght_result];
		int index_right = 0;
		int index_left = 0;
		int index_result = 0;

		// Checking indexes of both array less than their length
		while (index_left < left_array.length
				|| index_right < right_array.length) {

			// case 1: When Right and Left array's both have an elements

			if (index_left < left_array.length
					&& index_right < right_array.length) {

				// To compare and put the element in Result array

				System.out
						.println("Right and Left array's both have an elements");
				if (left_array[index_left] <= right_array[index_right]) {
					result_Array[index_result] = left_array[index_left];
					index_left++;
					index_result++;
					System.out.print("Resultant-Array ");
					printElements(result_Array);
				} else {
					result_Array[index_result] = right_array[index_right];
					index_right++;
					index_result++;
					System.out.print("Resultant-Array ");
					printElements(result_Array);
				}

			}
			// case 2: When only Left array have an elements
			else if (index_left < left_array.length) {
				System.out.println("only Left array have an elements");
				result_Array[index_result] = left_array[index_left];
				index_left++;
				index_result++;
				System.out.print("Resultant-Array ");
				printElements(result_Array);

			}
			// case 3: When only Right array have an elements
			else if (index_right < right_array.length) {
				System.out.println("only Right array have an elements");
				result_Array[index_result] = right_array[index_right];
				index_right++;
				index_result++;
				System.out.print("Resultant-Array ");
				printElements(result_Array);
			}
		}
		return result_Array;
	}

	/*
	 * public static int[] generateRandomNum(int[] arrayOfNumbers) {
	 * 
	 * for (int i = 0; i < arrayOfNumbers.length; i++) {
	 * 
	 * // To generate random numbers from 1 to 100 arrayOfNumbers[i] = (int)
	 * (Math.random() * 100);
	 * 
	 * }
	 * 
	 * return arrayOfNumbers;
	 * 
	 * }
	 */

	public static void printElements(int[] array) {

		for (int i = 0; i < array.length; i++) {

			if (i < array.length - 1) {
				System.out.print(array[i] + ", ");
			} else {
				System.out.println(array[i]);
			}

		}

	}

	public static void main(String[] args) {

		// generateRandomNum(arrayOfNumbers);
		System.out.println("Random-input: Array of elements.");
		printElements(arrayOfNumbers);
		mergeInputArray(arrayOfNumbers);
		System.out.println("After-Sorting: Array of elements.");
		printElements(result_Array);

	}
}
