import java.math.BigInteger;
import java.util.Scanner;

public class Szyfrowanie {

    static final Scanner input = new Scanner(System.in);

    public static String keyword;
    public static long openP;
    public static long openG;
    public static long secretA;
    public static long secretB;

    public static void main(String[] args) {
            String message=getMessage();
            //getMessage(message,keyword);
            vigener(message);
            getParameters(openP,openG,secretA,secretB);
            rsa(message);
            aes(message);
        }

    public static String getMessage() {
        String message;
        System.out.println("Podaj wiadomosc:");
        message = input.next();
        System.out.println("Podaj klucz:");
        keyword = input.next();
        return message;
    }

    public static void vigener(String message){
        Vigener vigenerCypher= new Vigener(message,keyword);
        vigenerCypher.getMessage(message,keyword);
    }

    public static void getParameters(long openP, long openG, long secretA, long secretB){

        System.out.println("Podaj wartosc publicznego klucza nr 1:");
        openP=input.nextLong();
        System.out.println("Podaj wartosc publicznego klucza nr 2:");
        openG=input.nextLong();
        System.out.println("Podaj wartosc tajnego klucza nr 1 :");
        secretA=input.nextLong();
        System.out.println("Podaj wartosc tajnego klucza nr 2:");
        secretB=input.nextLong();
    // sprawdzam sobie czy mamy liczbe pierwsza jak nie to jeszcze raz wywoluje te metode i tak w kolko az poda sie liczby pierwsze
        for(int i=2; i<openP;i++)
        {
            if(openP%i==0){
                System.out.println("Nie podales liczby pierwszej.");
                System.out.println("Podaj liczby pierwsza.");
                getParameters(openP, openG,secretA,secretB);
            }
            else{
                DiffieHellman diffieHellman=new DiffieHellman(openP,openG,secretA,secretB);
                diffieHellman.getLong(openP,openG,secretA,secretB);
            }
        }
    }

    public static void rsa(String message){
        RSA rsa = new RSA(1024);

        System.out.println("Plaintext: " + message);
        BigInteger plaintext = new BigInteger(message.getBytes());

        BigInteger ciphertext = rsa.encrypt(plaintext);
        System.out.println("Ciphertext: " + ciphertext);
        plaintext = rsa.decrypt(ciphertext);

        String text2 = new String(plaintext.toByteArray());
        System.out.println("Plaintext: " + text2);
    }

    public static void aes(String message){

        System.out.println("Podaj tajny klucz:");
        final String secretKey = input.next();

        String encryptedString = AES.encrypt(message, secretKey) ;
        String decryptedString = AES.decrypt(encryptedString, secretKey) ;

        System.out.println(message);
        System.out.println(encryptedString);
        System.out.println(decryptedString);
    }
}
