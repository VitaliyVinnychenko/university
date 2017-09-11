/**
 * Created 05.02.2017 by Vitaliy Vinnichenko (v1.0)
 */
package hypermarkets;

/**
 * This class is designed to show Hypermarket model
 * store information about Hypermarket
 */
public class Hypermarket {

    private int coveringArea;
    private int employeesNumber;
    private int averageDailyVisitorsNumber;
    private double averageIncomeByVisitor;
    private String name;

    private static int employeesNumberInAllHypermarkets = 0;

    Hypermarket(){
        this.coveringArea = 5000;
        this.averageDailyVisitorsNumber = 1000;
        this.averageIncomeByVisitor = 5.3;
        this.employeesNumber = 500;
        this.name = "Silpo";
        this.calculateEmployeesNumber();
    }

    Hypermarket(
            int coveringArea,
            int employeesNumber,
            int averageDailyVisitorsNumber,
            double averageIncomeByVisitor
    ){
        this.coveringArea = coveringArea;
        this.averageDailyVisitorsNumber = averageDailyVisitorsNumber;
        this.averageIncomeByVisitor = averageIncomeByVisitor;
        this.employeesNumber = employeesNumber;
        this.name = "Auchan";
        this.calculateEmployeesNumber();
    }

    Hypermarket(
            int coveringArea,
            int employeesNumber,
            int averageDailyVisitorsNumber,
            double averageIncomeByVisitor,
            String name
    ){
        this.coveringArea = coveringArea;
        this.averageDailyVisitorsNumber = averageDailyVisitorsNumber;
        this.averageIncomeByVisitor = averageIncomeByVisitor;
        this.employeesNumber = employeesNumber;
        this.name = name;
        this.calculateEmployeesNumber();
    }

    public int getCoveringAreaValue(){
        return this.coveringArea;
    }

    public int getEmployeesNumber(){
        return this.employeesNumber;
    }

    public int getAverageDailyVisitorsNumber(){
        return this.averageDailyVisitorsNumber;
    }

    public double getAverageIncomeByVisitor(){
        return this.averageIncomeByVisitor;
    }

    public String getHypermarketName(){
        return this.name;
    }

    public void resetValues(
            int coveringArea,
            int employeesNumber,
            int averageDailyVisitorsNumber,
            double averageIncomeByVisitor,
            String name
    ){
        this.coveringArea = coveringArea;
        this.employeesNumber = employeesNumber;
        this.averageDailyVisitorsNumber = averageDailyVisitorsNumber;
        this.averageIncomeByVisitor = averageIncomeByVisitor;
        this.name = name;
        this.calculateEmployeesNumber();
    }

    /**
     * print out info about object
     * @return
     */
    @Override
    public String toString() {
        return "Name: \"" + this.name + "\"\n"
        + "Covering area: " + this.coveringArea + " square meters\n"
        + "Employees: " + this.employeesNumber + "\n"
        + "Average income by visitor: $" + this.averageIncomeByVisitor + "\n"
        + "Average daily visitors number: " + this.averageDailyVisitorsNumber;
    }

    public void calculateEmployeesNumber(){         // calculate employees number among all objects
        employeesNumberInAllHypermarkets += this.employeesNumber;
    }

    /**
     * show employees number among all object
     */
    public static void staticPrintSum(){
        System.out.println("** Summary employees number: " + employeesNumberInAllHypermarkets);
    }

    /**
     * show employees number among all object
     */
    public void printSum(){
        System.out.println("* Summary employees number: " + employeesNumberInAllHypermarkets + "\n");
    }

    public static void main(String[] args){
        Hypermarket defParamsObject = new Hypermarket();
        Hypermarket fiveParamsObject = new Hypermarket(12534, 743, 7124, 10.2, "Auchan");
        Hypermarket fourParamsObject = new Hypermarket(12534, 743, 7324, 10.2);

        System.out.println(defParamsObject.toString());
        defParamsObject.printSum();

        System.out.println(fourParamsObject.toString());
        fourParamsObject.printSum();

        System.out.println(fiveParamsObject.toString());
        fiveParamsObject.printSum();

        staticPrintSum();
    }
}
