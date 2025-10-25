package first.project.javarash;
import java.io.*;
import static first.project.javarash.CLI.menu;
import static first.project.javarash.CLI.menukey;

public class Main {

    public static void main(String[] args) throws IOException {
        //вивести в консоль аргументи у разі їх наявності
        for (String arg : args) {
            System.out.println(arg);
        }

        menu(); //меню для юзера

        //читання файлу
        InputStream is = new FileInputStream(FileService.filePath); //читання файлу
        var data = is.readAllBytes(); //у data залито вміст файлу
        String line = new String(data);
        is.close();

        String[] words = line.split(""); //ділимо рядок line на символи
        int key = args.length != 0 ? Integer.valueOf(args[0]) : menukey(); //зазначили ключ з консолі, розібратись з аргументами л28-1 1:10
        System.out.println("Зазначений для шифрування Ключ (число): " + key);
        char[] coded = new char[words.length]; //створили новий масив куди розділені з рядка символи записуються

        System.out.println("Розпочато читання файлу з вказаної директорії: " + FileService.filePath);
        System.out.println("Файл прочитано. Початковий текст: " + line);

        //шифрування файлу
        for (int i = 0; i < words.length; i++) {
            char charAt = words[i].charAt(0);
            char codedChar;
            if (CaesarCipher.ALPHABET.contains(charAt)) {
                int code = CaesarCipher.ALPHABET.indexOf(charAt);
                int codePlusKey = (code + key) % CaesarCipher.ALPHABET.size(); // % CaesarCipher.ALPHABET.size() - робимо циклічність по ALPHABET
                if (codePlusKey < 0) {
                    codePlusKey += CaesarCipher.ALPHABET.size();
                }
                codedChar = CaesarCipher.ALPHABET.get(codePlusKey);
            } else {
//                System.out.println("Пропущено символ, що не є літерою: '" + charAt + "'"); //це можна вимкнути в фінальній версії
                codedChar = charAt;
            }
            coded[i] = codedChar;
        }
        System.out.println("Текст Зашифровано успішно [ENCRYPTED]: " + new String(coded));

        //запис нового файлу в директорію де лежить початковий файл з новим іменем [ENCRYPTED] (закодовано)
        OutputStream os = new FileOutputStream(FileService.encryptedFile);
        os.write(new String(coded).getBytes());
        System.out.println("Зашифрований текст записано у новий файл у початкову директорію з поміткою [ENCRYPTED] у назві файлу");
        os.close();

        char[] decoded = new char[words.length];
        for (int i = 0; i < coded.length; i++) {
            char c = coded[i];

            if (CaesarCipher.ALPHABET.contains(c)) {
                int code = CaesarCipher.ALPHABET.indexOf(c);
                int codePlusKey = (code - key) % CaesarCipher.ALPHABET.size();
                if (codePlusKey < 0) {
                    codePlusKey += CaesarCipher.ALPHABET.size();
                }
                decoded[i] = CaesarCipher.ALPHABET.get(codePlusKey);
            } else {
                decoded[i] = c;
            }
        }

        System.out.println("Текст Дешифровано успішно [DECRYPTED]: " + new String(decoded));

        OutputStream os2 = new FileOutputStream(FileService.decryptedFile);//запис нового файлу в директорію де лежить початковий файл з новим іменем [DECRYPTED] (розкодовано)
        os2.write(new String(decoded).getBytes());
        System.out.println("Дешифрований текст записано у новий файл у початкову директорію з поміткою [DECRYPTED] у назві файлу");
        os2.close();






    }
}