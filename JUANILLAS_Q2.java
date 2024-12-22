import java.util.Scanner;

public class CreaturePowerSorter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] powerLevels = new int[10];

        // Step 1: Input power levels
        System.out.println("Enter 10 power levels of creatures:");
        for (int i = 0; i < powerLevels.length; i++) {
            powerLevels[i] = scanner.nextInt();
        }

        // Bubble Sort (Ascending)
        int[] ascendingSorted = powerLevels.clone();
        bubbleSort(ascendingSorted);
        System.out.print("\nBubble Sort (Ascending): ");
        for (int num : ascendingSorted) {
            System.out.print(num + " ");
        }

        // Selection Sort (Descending)
        int[] descendingSorted = powerLevels.clone();
        selectionSort(descendingSorted);
        System.out.print("\nSelection Sort (Descending): ");
        for (int num : descendingSorted) {
            System.out.print(num + " ");
        }

        // Analysis
        int sumEven = 0, sumOdd = 0;
        int min = powerLevels[0], max = powerLevels[0];
        for (int num : powerLevels) {
            if (num % 2 == 0) {
                sumEven += num;
            } else {
                sumOdd += num;
            }
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
        }

        System.out.println("\n\nAnalysis:");
        System.out.println("Sum of Even Numbers: " + sumEven);
        System.out.println("Sum of Odd Numbers: " + sumOdd);
        System.out.println("Minimum Power Level: " + min);
        System.out.println("Maximum Power Level: " + max);
    }

    // Bubble Sort (Ascending)
    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap array[j] and array[j+1]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // Selection Sort (Descending)
    public static void selectionSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            // Find the maximum element in the remaining array
            int maxIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] > array[maxIdx]) {
                    maxIdx = j;
                }
            }
            // Swap the found maximum element with the first element
            int temp = array[maxIdx];
            array[maxIdx] = array[i];
            array[i] = temp;
        }
    }
}
