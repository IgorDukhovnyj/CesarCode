package first.project.javarash;
import java.util.Scanner;

public class CLI {

    //меню для юзера
    public static void menu() {
        System.out.println("Введіть число для вибору функції COMMAND: 1 - ENCRYPT Зашифрувати файл; 2 - DECRYPT Дешифрувати файл");
        Scanner console = new Scanner(System.in);
        int choise = console.nextInt();
        if (choise == 1) {
            System.out.println("Обрано: 1 - ENCRYPT Зашифрувати файл");
            menukey();
            menupath();
        } else if (choise == 2) {
            System.out.println("Обрано: 2 - DECRYPT Дешифрувати файл");
            menukey();
            menupath();
        } else {
            System.out.println("Не вірний вибір. Введіть тільки одне число 1 або 2. Повторіть введення: ");
            menukey();
            menupath();
        }
    }

    //зчитали і записали ключ з консолі
    public static int menukey() {
        System.out.println("Напишіть число і натисніть Enter для зазначення Ключа кодування " +
                "(при наявності Аргументів - вкажіть довільне число, пріорітетний Ключ буде взято з Аргументів: ");
        Scanner consoleKey = new Scanner(System.in);
        int choiseConsoleKey = consoleKey.nextInt();
        return choiseConsoleKey;
    }

    //зчитали і записали шлях до файлу з консолі
    public static String menupath() {
        System.out.println("Введіть шлях до файлу для Шифрування/Дешифрування і натисніть Enter " +
                "(при наявності Аргументів - вкажіть довільний шлях, пріорітетний Шлях буде взято з Аргументів: : ");
        Scanner consolePath = new Scanner(System.in);
        String choiseFilePath = consolePath.nextLine();
        return choiseFilePath;
    }
}
