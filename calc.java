import java.util.Scanner;

public class calc {

    private static long factorial(int n) {
        long fact = 1;
        for (int i = 2; i <= n; i++) fact *= i;
        return fact;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=========== Simple Calculator ===========");
            System.out.println("1.  Addition");
            System.out.println("2.  Subtraction");
            System.out.println("3.  Multiplication");
            System.out.println("4.  Division");
            System.out.println("5.  Square");
            System.out.println("6.  Cube");
            System.out.println("7.  Square Root");
            System.out.println("8.  Cube Root");
            System.out.println("9.  Modulus (remainder)");
            System.out.println("10. Power (x^y)");
            System.out.println("11. Factorial (n!)");
            System.out.println("12. Sine   (degrees)");
            System.out.println("13. Cosine (degrees)");
            System.out.println("14. Tangent(degrees)");
            System.out.println("15. Exit");
            System.out.print("Enter your choice 1‑15: ");

            int choice = sc.nextInt();

            if (choice == 15) {
                System.out.println("Good‑bye! Have a great day.");
                break;
            }

            if (choice < 1 || choice > 14) {
                System.out.println("Invalid choice, please try again.");
                continue;
            }

            double firstNumber;
            double secondNumber = 0;          

            boolean twoOperands = (choice >= 1 && choice <= 4)   
                    || choice == 9                   
                    || choice == 10;                  

            if (twoOperands) {
                System.out.print("Enter first number: ");
                firstNumber = sc.nextDouble();
                System.out.print("Enter second number: ");
                secondNumber = sc.nextDouble();
            } else {
                System.out.print("Enter a number: ");
                firstNumber = sc.nextDouble();
            }

            switch (choice) {
                case 1:
                    System.out.println("Answer: " + (firstNumber + secondNumber));
                    break;
                case 2:
                    System.out.println("Answer: " + (firstNumber - secondNumber));
                    break;
                case 3:
                    System.out.println("Answer: " + (firstNumber * secondNumber));
                    break;
                case 4:
                    if (secondNumber != 0) {
                        System.out.println("Answer: " + (firstNumber / secondNumber));
                    } else {
                        System.out.println("Cannot divide by zero!");
                    }
                    break;

                case 5:
                    System.out.println("Answer: " + (firstNumber * firstNumber));
                    break;
                case 6:
                    System.out.println("Answer: " + (firstNumber * firstNumber * firstNumber));
                    break;
                case 7:
                    if (firstNumber >= 0) {
                        System.out.println("Answer: " + Math.sqrt(firstNumber));
                    } else {
                        System.out.println("Cannot calculate square root of a negative number!");
                    }
                    break;
                case 8:
                    System.out.println("Answer: " + Math.cbrt(firstNumber));
                    break;
                case 10: 
                    System.out.println("Answer: " + Math.pow(firstNumber, secondNumber));
                    break;

                case 9:
                    if (secondNumber != 0) {
                        System.out.println("Answer: " + (firstNumber % secondNumber));
                    } else {
                        System.out.println("Cannot perform modulus by zero!");
                    }
                    break;

                case 11:
                    if (firstNumber < 0 || firstNumber != (int) firstNumber) {
                        System.out.println("Factorial is defined for non‑negative integers only.");
                    } else {
                        long fact = factorial((int) firstNumber);
                        System.out.println("Answer: " + fact);
                    }
                    break;

                case 12: 
                    System.out.println("Answer: " +
                            Math.sin(Math.toRadians(firstNumber)));
                    break;
                case 13:
                    System.out.println("Answer: " +
                            Math.cos(Math.toRadians(firstNumber)));
                    break;
                case 14: 
                    System.out.println("Answer: " +
                            Math.tan(Math.toRadians(firstNumber)));
                    break;
            }
        }

        sc.close();
    }
}
