import java.util.Scanner; // import the scanner class

class Main {
    public static void main(String[] args) {
        Scanner scannerObj = new Scanner(System.in); // create a scanner object
        int fEGlobal = 0; // first entry global var
        String oGlobal = ""; // operator global var
        int sEGlobal = 0; // second entry global var


        // first entry number
        boolean firstEntryValid = false;
        while (!firstEntryValid) {
            System.out.print("Enter First Number: ");
            String firstEntry = scannerObj.nextLine(); // read user input
            try {
                fEGlobal = Integer.parseInt(firstEntry); // parses the stringed number into an integer
                firstEntryValid = true;
            } catch (Exception e) {
                System.out.println("Exception in thread \"main\" Entry: " + firstEntry + " Cannot be converted to java.lang.int (File.java:13)");
            }
        }


        // operation choice
        String[] operations = {"+", "-", "*", "/"}; // valid operation choices
        boolean operationEntryValid = false;
        while (!operationEntryValid) {
            System.out.print("Choose an operation (+, -, *, /): ");
            String operationEntry = scannerObj.nextLine();
            for (String operative : operations) {
                if (operative.equals(operationEntry)) {
                    operationEntryValid = true;
                    oGlobal = operationEntry;
                    break;
                } else if (operative.equals("/")) { // throws the exception if the entry isn't in the valid operator list
                    System.out.println("Exception in thread \"main\" Entry: " + operationEntry + " Cannot be applied to java.lang.int (File.java:26)");
                }
            }
        }


        // second entry number
        boolean secondEntryValid = false;
        while (!secondEntryValid) {
            System.out.print("Enter Second Number: ");
            String secondEntry = scannerObj.nextLine(); // read user input
            try {
                sEGlobal = Integer.parseInt(secondEntry); // parses the stringed number into an integer
                secondEntryValid = true;
            } catch (Exception e) {
                System.out.println("Exception in thread \"main\" Entry: " + secondEntry + " Cannot be converted to java.lang.int (File.java:42)");
            }
        }


        // calculate and print the equation
        float result = switch (oGlobal) { // matches the operator and calculates the result directly into the result variable using switch case
            case "+" -> fEGlobal + sEGlobal;
            case "-" -> fEGlobal - sEGlobal;
            case "*" -> fEGlobal * sEGlobal;
            case "/" -> (float) fEGlobal / sEGlobal;
            default -> 0;
        };
        String fullEquation = (fEGlobal + oGlobal + sEGlobal + "=" + result);
        System.out.println(fullEquation);

    }
}