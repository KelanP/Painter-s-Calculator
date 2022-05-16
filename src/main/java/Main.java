import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in); //Create the scanner object

        System.out.println("Hello, welcome to the wall painting calculator\n" );
        System.out.print("Are you painting multiple walls? Y or N: ");
        String multiWall = myScanner.nextLine();
        System.out.print("How many coats of paint do you need? (A minimum of two is recommended): ");
        int multiCoat = myScanner.nextInt();


        if (multiWall.equalsIgnoreCase("Y")) //run for multiple walls
        {
            System.out.print("How many walls do you need to paint: ");
            int noOfWalls = myScanner.nextInt();
            System.out.print("Please enter the coverage of your paint in square meters per litre: ");
            double paintCoverage = myScanner.nextDouble();
            double neededPaint = 0;
            for (int z=1; z<=noOfWalls;z++){
                System.out.print("Please enter the height of wall " + z +" in meters: ");
                double wallHeight = myScanner.nextDouble();
                System.out.print("Please enter the width of wall " + z +" in meters: ");
                double wallWidth = myScanner.nextDouble();
                double wallArea = wallHeight * wallWidth; //Determine the total area of the wall
                System.out.print("Please enter the total area that does not need to be painted in square meters (doors, windows, sockets,etc.): ");
                double notNeededArea = myScanner.nextDouble();
                neededPaint = multiCoat * (neededPaint+ ((wallArea - notNeededArea) / paintCoverage));
            }
            System.out.println("Delightful! You will need: " + neededPaint + " litres of paint");
            System.out.print("Do you have different bucket sizes available to you? Y or N: ");
            String minusLine = myScanner.nextLine(); //gets rid of the additional 'buffer line'
            String multiBucket = myScanner.nextLine();

            if (multiBucket.equalsIgnoreCase("N")) //run for single bucket size
            {
                System.out.print("What is the size of each paint bucket in litres?: ");
                double bucketSize = myScanner.nextDouble();
                double requiredBuckets = neededPaint / bucketSize; //determines how many buckets of paint are needed
                int intRequiredBuckets = (int) Math.ceil(requiredBuckets);
                System.out.println("You will require: " + intRequiredBuckets + " buckets of paint");
            }

            else if (multiBucket.equalsIgnoreCase("Y")) //run for multiple bucket sizes
            {
                System.out.println("How many sizes of buckets are available to you?");
                int x = myScanner.nextInt();
                double[] availableBucketSizesArray = new double[x];
                System.out.println("Please enter the sizes of the available paint buckets in litres:");
                for (int i = 0; i < x; i++) //loop to get the sizes of buckets
                {
                    availableBucketSizesArray[i] = myScanner.nextInt();
                }
                Arrays.sort(availableBucketSizesArray); //sorts the array from smallest to largest
                System.out.println("These are your options:");

                for (int t = x; t>=1; --t) {
                    double orderedPaint = neededPaint/availableBucketSizesArray[t-1];
                    System.out.println(Math.ceil(orderedPaint) + " x "+ availableBucketSizesArray[t-1] + "litre buckets");
                }

            }
            else System.out.println("Fool of a Took, type Y or N correctly next time!");
            System.out.println("Happy painting!");
        }
        else if (multiWall.equalsIgnoreCase("N")) //run for single wall
        {
            System.out.print("Please enter the height of your wall in meters: ");
            double wallHeight = myScanner.nextDouble();
            System.out.print("Please enter the width of your wall in meters: ");
            double wallWidth = myScanner.nextDouble();
            double wallArea = wallHeight * wallWidth; //Determine the total area of the wall
            System.out.print("Please enter the coverage of your paint in square meters per litre: ");
            double paintCoverage = myScanner.nextDouble();
            System.out.print("Please enter the total area that does not need to be painted in square meters (doors, windows, sockets,etc.): ");
            double notNeededArea = myScanner.nextDouble();
            double neededPaint = multiCoat * ((wallArea - notNeededArea) / paintCoverage); //Determine the total area of the wall that needs painting and times by number of coats
            System.out.println("Delightful! You will need: " + neededPaint + " litres of paint");

            System.out.print("Do you have different bucket sizes available to you? Y or N: ");
            String minusLine = myScanner.nextLine();
            String multiBucket = myScanner.nextLine();

            if (multiBucket.equalsIgnoreCase("N")) //run for single bucket size
            {
                System.out.print("What is the size of the paint bucket in litres?: ");
                double bucketSize = myScanner.nextDouble();
                double requiredBuckets = neededPaint / bucketSize; //determines how many buckets of paint are needed
                int intRequiredBuckets = (int) Math.ceil(requiredBuckets);
                System.out.println("You will require: " + intRequiredBuckets + " buckets of paint");
            }

            else if (multiBucket.equalsIgnoreCase("Y")) //run for multiple bucket sizes
            {
                System.out.println("How many sizes of buckets are available to you?");
                int numBucketSizes = myScanner.nextInt();
                double[] availableBucketSizesArray = new double[numBucketSizes];
                System.out.println("Please enter the sizes of the available paint buckets in litres:");
                for (int i = 0; i < numBucketSizes; i++) //loop to get the sizes of buckets
                {
                    availableBucketSizesArray[i] = myScanner.nextInt();
                }
                Arrays.sort(availableBucketSizesArray); //sorts the array from smallest to largest
                System.out.println("These are your options:");

                for (int t = numBucketSizes; t>=1; --t) {
                    double orderedPaint = neededPaint/availableBucketSizesArray[t-1];
                    System.out.println(Math.ceil(orderedPaint) + " x "+ availableBucketSizesArray[t-1] + " litre buckets");
                }

            }
            else System.out.println("Fool of a Took, type Y or N correctly next time!");

            System.out.println("Happy painting!");

        }
        else
            System.out.println("You melon, you couldn't type Y or N correctly! smh");










    }
}
