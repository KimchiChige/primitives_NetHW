import java.util.Scanner;

public class Primitives {
    private static int totalIncome = 0;
    private static int totalExpenses = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("Выберите операцию и введите её номер:");
            System.out.println("1. Добавить новый доход");
            System.out.println("2. Добавить новый расход");
            System.out.println("3. Выбрать систему налогообложения");
            
            String input = scanner.nextLine().trim();
            
            if (input.equalsIgnoreCase("end")) {
                System.out.println("Программа завершена!");
                break;
            }
            
            int choice = Integer.parseInt(input);
            
            if (choice == 1) {
                System.out.print("Введите сумму дохода: ");
                int amount = Integer.parseInt(scanner.nextLine().trim());
                if (amount >= 0) {
                    totalIncome += amount;
                }
            } else if (choice == 2) {
                System.out.print("Введите сумму расхода: ");
                int amount = Integer.parseInt(scanner.nextLine().trim());
                if (amount >= 0) {
                    totalExpenses += amount;
                }
            } else if (choice == 3) {
                int tax1 = calculateUsnIncome(totalIncome, totalExpenses);
                int tax2 = calculateUsnIncomeMinusExpenses(totalIncome, totalExpenses);
                
                System.out.println("Налог на УСН доходы: " + tax1 + " рублей");
                System.out.println("Налог на УСН доходы минус расходы: " + tax2 + " рублей");
                
                if (tax1 < tax2) {
                    System.out.println("Мы советуем вам УСН доходы");
                    System.out.println("Экономия: " + (tax2 - tax1) + " рублей");
                } else if (tax2 < tax1) {
                    System.out.println("Мы советуем вам УСН доходы минус расходы");
                    System.out.println("Экономия: " + (tax1 - tax2) + " рублей");
                } else {
                    System.out.println("Можете выбрать любую систему налогообложения");
                }
            }
        }
        
        scanner.close();
    }
    
    private static int calculateUsnIncome(int income, int expenses) {
        return income * 6 / 100;
    }
    
    private static int calculateUsnIncomeMinusExpenses(int income, int expenses) {
        int diff = income - expenses;
        if (diff < 0) {
            return 0;
        }
        return diff * 15 / 100;
    }
}
