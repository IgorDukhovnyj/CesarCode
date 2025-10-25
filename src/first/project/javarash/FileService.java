package first.project.javarash;

import static first.project.javarash.CLI.menupath;

public class FileService {

    static String filePath = menupath(); //додаваня міток у назву нових файлів
    static String encrypted = "[ENCRYPTED]";
    static String decrypted = "[DECRYPTED]";
    static int index = filePath.lastIndexOf(".");
    static String fileName = filePath.substring(0, index);
    static String fileEnd = filePath.substring(index);
    static String encryptedFile = fileName + encrypted + fileEnd;
    static String decryptedFile = fileName + decrypted + fileEnd;


}
