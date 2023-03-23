import java.util.Formatter;

public class Investment
{
    private double year1Deposit;
    private double year2Deposit;
    private double year3Deposit;
    int coinSelection;

    // constructor
    public Investment()
    {

    }

    public double getYear1Deposit() {
        return year1Deposit;
    }

    public void setYear1Deposit(double year1Deposit) {
        this.year1Deposit = year1Deposit;
    }

    public double getYear2Deposit() {
        return year2Deposit;
    }

    public void setYear2Deposit(double year2Deposit) {
        this.year2Deposit = year2Deposit;
    }

    public double getYear3Deposit() {
        return year3Deposit;
    }

    public void setYear3Deposit(double year3Deposit) {
        this.year3Deposit = year3Deposit;
    }

    public void setCoinSelection(int inputSelection)
    {
        coinSelection = inputSelection;
    }
    public int getCoinSelection()
    {
        return(coinSelection);
    }

    public double coinProfitRate(int type) {
        if(type==1) {
            return 0.18;
        } else if(type==2) {
            return 0.12;
        } else if(type==3) {
            return 0.15;
        } else {
            return 0.00;
        }
    }

    public void calcInvestment() {
        Double yearOneProfit = coinProfitRate(coinSelection) * year1Deposit;
        Double yearTwoProfit = coinProfitRate(coinSelection) * (year1Deposit+year2Deposit);
        Double yearThreeProfit = coinProfitRate(coinSelection) * (year1Deposit+year2Deposit+year2Deposit);

        //Print profit for the selected coin type
        System.out.println("Predicted Profit for Investment in "+ (coinSelection == 1 ? "Best Coin:" :
                coinSelection == 2 ? "Simple Coin:" : "Fast Coin:"));
        Formatter fmt = new Formatter();
        fmt.format("%15s %15s %15s\n", "Years", "YearlyProfit", "TotalProfit");
        fmt.format("-------------------------------------------------------\n");
        fmt.format("%15s %15s %15s\n", 1, yearOneProfit, yearOneProfit);
        fmt.format("%15s %15s %15s\n", 2, yearTwoProfit, yearOneProfit+yearTwoProfit);
        fmt.format("%15s %15s %15s\n", 3, yearThreeProfit, yearTwoProfit+yearThreeProfit);
        System.out.println(fmt);
    }


}