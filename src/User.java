public class User
{
    private String name;
    private Investment userInvestment;
    private double annualSalary;
    private double buyingPrice;
    private double sellingPrice;
    private int yearsHeld;
    private boolean isResident;
    private double taxRate;
    private double cgt;
    private double actualProfit;

    public User(String name, double annualSalary, double buyingPrice, double sellingPrice, int yearsHeld, boolean isResident) {
        this.name = name;
        this.annualSalary = annualSalary;
        this.buyingPrice = buyingPrice;
        this.sellingPrice = sellingPrice;
        this.yearsHeld = yearsHeld;
        this.isResident = isResident;

        userInvestment = new Investment();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(double annualSalary) {
        this.annualSalary = annualSalary;
    }

    public double getBuyingPrice() {
        return buyingPrice;
    }

    public void setBuyingPrice(double buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public int getYearsHeld() {
        return yearsHeld;
    }

    public void setYearsHeld(int yearsHeld) {
        this.yearsHeld = yearsHeld;
    }

    public boolean isResident() {
        return isResident;
    }

    public void setResident(boolean resident) {
        isResident = resident;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public double getCgt() {
        return cgt;
    }

    public double getActualProfit() {
        return actualProfit;
    }

    public static double getTaxRate(double totalIncome, boolean isResident) {
        //Getting the tax rate based on income and residency
        if (isResident) {
            if (totalIncome <= 18200) {
                return 0;
            } else if (totalIncome <= 45000) {
                return 0.19;
            } else if (totalIncome <= 120000) {
                return 0.325;
            } else if (totalIncome <= 180000) {
                return 0.37;
            } else {
                return 0.45;
            }
        } else {
            if (totalIncome <= 120000) {
                return 0.325;
            } else if (totalIncome <= 180000) {
                return 0.37;
            } else {
                return 0.45;
            }
        }
    }

    public void calcCgt() {
        double profit = sellingPrice - buyingPrice;
        double profitForCGT = profit / yearsHeld;
        double totalIncome = annualSalary + profitForCGT;
        taxRate = getTaxRate(totalIncome, isResident);
        cgt = taxRate * profitForCGT;
        actualProfit = profitForCGT - cgt;
    }


    public void printUserDetails() {
        System.out.println("\nUser Details:");
        System.out.printf("Name: %s\n", name);
        System.out.printf("Annual salary: $%.2f\n", annualSalary);
        System.out.println("Resident:" + (isResident ? "Yes" : "No"));
    }

    public void printCryptoDetails() {
        System.out.println("\nCryptocurrency:");
        System.out.printf("Buying price of cryptocurrency: $%.2f\n", buyingPrice);
        System.out.printf("Selling price of cryptocurrency: $%.2f\n", sellingPrice);
        System.out.printf("No of years cryptocurrency is held: %d\n", yearsHeld);
    }

    public void printCgtDetails() {
        calcCgt();
        System.out.println("\nCapital Gains Tax: ");
        System.out.printf("Tax rate: %.1f%%\n", taxRate * 100);
        System.out.printf("Capital gains tax: $%.2f\n", cgt);
        System.out.printf("Actual profit: $%.2f\n", actualProfit);

    }


    public void setInitialInvestment(double amount) {
        userInvestment.setYear1Deposit(amount);
    }

    public void setYearlyInvestment1(double amount) {
        userInvestment.setYear2Deposit(amount);
    }

    public void setYearlyInvestment2(double amount) {
        userInvestment.setYear3Deposit(amount);
    }

    public void setInvestCoinSelection(int inputCoin)
    {
        userInvestment.setCoinSelection(inputCoin);
    }

    public int getInvestCoinSelection()
    {
        return userInvestment.getCoinSelection();
    }

    public void printInvestmentDetails() {
        userInvestment.calcInvestment();
    }
}