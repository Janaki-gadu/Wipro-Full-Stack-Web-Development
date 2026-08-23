public class FDAccount extends Account {

    private int noOfDays;
    private int age;

    public FDAccount(double amount, int noOfDays, int age) {
        this.amount = amount;
        this.noOfDays = noOfDays;
        this.age = age;
    }

    @Override
    public double calculateInterest() {

        if(amount < 10000000) {

            if(noOfDays>=7 && noOfDays<=14)
                interestRate=(age>=60)?5.0:4.5;

            else if(noOfDays<=29)
                interestRate=(age>=60)?5.25:4.75;

            else if(noOfDays<=45)
                interestRate=(age>=60)?6.0:5.5;

            else if(noOfDays<=60)
                interestRate=(age>=60)?7.5:7.0;

            else if(noOfDays<=184)
                interestRate=(age>=60)?8.0:7.5;

            else if(noOfDays<=365)
                interestRate=(age>=60)?8.5:8.0;
        }
        else {

            if(noOfDays>=7 && noOfDays<=14)
                interestRate=6.5;

            else if(noOfDays<=29)
                interestRate=6.75;

            else if(noOfDays<=45)
                interestRate=6.75;

            else if(noOfDays<=60)
                interestRate=8.0;

            else if(noOfDays<=184)
                interestRate=8.5;

            else if(noOfDays<=365)
                interestRate=10.0;
        }

        return amount*interestRate/100;
    }
}