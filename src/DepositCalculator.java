import java.util.Scanner;

public class DepositCalculator {
    public static void main(String[] args) {
        new DepositCalculator().runDepositCalculator();
    }

    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return getRandom(pay, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return getRandom(amount + amount * yearRate * depositPeriod, 2);
    }

    double getRandom(double value, int place) {
        double ScaLe = Math.pow(10, place);
        return Math.round(value * ScaLe) / ScaLe;
    }

    void runDepositCalculator() {
        int period;
        int action;
        double depositAmount = 0;
        int amount;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        if (action == 1) {
            depositAmount = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            depositAmount = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + depositAmount);
    }
}
