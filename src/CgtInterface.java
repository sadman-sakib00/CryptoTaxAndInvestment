import java.util.Scanner;

public class CgtInterface {

    public static void main(String[] args) {
        CgtInterface calc = new CgtInterface();
        calc.run();
    }
    public void run() {
        Scanner scanner = new Scanner(System.in);
        //Name
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        //Salary
        System.out.print("Enter your annual salary: ");
        double salary = scanner.nextDouble();
        while (salary <= 0) {
            System.out.println("Invalid salary. Please enter a positive number.");
            System.out.print("Enter your annual salary: ");
            salary = scanner.nextDouble();
        }
        scanner.nextLine();
        //Residence
        System.out.print("Are you a resident? (Y/N): ");
        boolean isResident = scanner.nextLine().equalsIgnoreCase("Y");
        //Buying price
        System.out.print("Enter the buying price of the cryptocurrency: ");
        double buyingPrice = scanner.nextDouble();
        while (buyingPrice <= 0) {
            System.out.println("Invalid buying price. Please enter a positive number.");
            System.out.print("Enter the buying price of the cryptocurrency: ");
            buyingPrice = scanner.nextDouble();
        }
        //Selling price
        System.out.print("Enter the selling price of the cryptocurrency: ");
        double sellingPrice = scanner.nextDouble();
        while (sellingPrice <= 0 || sellingPrice <= buyingPrice) {
            System.out.println("Invalid selling price. Please enter a positive number greater than the buying price.");
            System.out.print("Enter the selling price of the cryptocurrency: ");
            sellingPrice = scanner.nextDouble();
        }
        //Years held
        System.out.print("Enter the number of years the cryptocurrency was held: ");
        int yearsHeld = scanner.nextInt();
        while (yearsHeld <= 0) {
            System.out.println("Invalid number of years. Please enter a positive integer.");
            System.out.print("Enter the number of years the cryptocurrency was held: ");
            yearsHeld = scanner.nextInt();
        }

        // Creating user
        User user = new User(name, salary, buyingPrice, sellingPrice, yearsHeld, isResident);


        // Calculate CGT and display results
        user.printUserDetails();
        user.printCryptoDetails();
        //user.calcCgt();       //Not need here since I am calling it in print method as well
        user.printCgtDetails();


        //Initial Investment
        System.out.print("Enter the initial investment amount: ");
        double initialInvestment = scanner.nextDouble();
        while (initialInvestment <= 0 || initialInvestment > user.getActualProfit()) {
            System.out.println("Invalid initial investment amount. Please enter a positive number less than or equal to the actual profit.");
            System.out.print("Enter the initial investment amount: ");
            initialInvestment = scanner.nextDouble();
        }
        user.setInitialInvestment(initialInvestment);

        //Investment for the next two years
        System.out.print("Investment amount after first year: ");
        double yearlyInvestment1 = scanner.nextDouble();
        while (yearlyInvestment1 < 0) {
            System.out.println("Invalid yearly investment amount. Please enter a positive number or zero.");
            System.out.print("Investment amount after first year: ");
            yearlyInvestment1 = scanner.nextDouble();
        }
        user.setYearlyInvestment1(yearlyInvestment1);

        System.out.print("Investment amount after second year: ");
        double yearlyInvestment2 = scanner.nextDouble();
        while (yearlyInvestment2 < 0) {
            System.out.println("Invalid yearly investment amount. Please enter a positive number or zero.");
            System.out.print("Investment amount after second year: ");
            yearlyInvestment2 = scanner.nextDouble();
        }
        user.setYearlyInvestment2(yearlyInvestment2);

        //Choose currency type
        System.out.println("Choose the Cryptocurrency to invest in: \n" +
                            "\t\t1. for Best Coin\n" +
                            "\t\t2. for Simple Coin\n" +
                            "\t\t3. for Fast Coin\n" +
                            "Enter your coin selection:");
        int cryptocurrencyType = scanner.nextInt();
        while (cryptocurrencyType != 1 && cryptocurrencyType != 2 && cryptocurrencyType != 3) {
            System.out.println("Invalid cryptocurrency. Please choose one of the options (Bestcoin[1]/Simplecoin[2]/Fastcoin[3]).");
            System.out.print("Choose the cryptocurrency: ");
            cryptocurrencyType = scanner.nextInt();
        }
        user.setInvestCoinSelection(cryptocurrencyType);

        //Print investment details
        user.printInvestmentDetails();

        /*
        A test input -

        Sakib
        75000
        Y
        5000
        9000
        4
        500
        1000
        500
        3
        */


    }
}
