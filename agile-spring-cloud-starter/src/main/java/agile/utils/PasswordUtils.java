package agile.utils;

import org.jasypt.util.password.BasicPasswordEncryptor;

public class PasswordUtils {

    private static final BasicPasswordEncryptor encryptor = new BasicPasswordEncryptor();

    public static String encrypt(String password) {
        return encryptor.encryptPassword(password);
    }

    public static boolean check(String plainPassword, String encryptedPassword) {
        return encryptor.checkPassword(plainPassword, encryptedPassword);
    }

}
