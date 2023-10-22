import java.util.Scanner;
//第一次
public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请选择功能：1.加密 2.解密");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                System.out.println("请输入要加密的字符串：");
                String plainText = scanner.nextLine();
                String cipherText = encrypt(plainText);
                System.out.println("加密后的字符串为：" + cipherText);
                break;
            case 2:
                System.out.println("请输入要解密的字符串：");
                String cipherText2 = scanner.nextLine();
                String plainText2 = decrypt(cipherText2);
                System.out.println("解密后的字符串为：" + plainText2);
                break;
            default:
                System.out.println("输入有误！");
        }
    }

    public static String encrypt(String plainText) {
        char[] chars = plainText.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] += i + 1 + 3;
        }
        char temp = chars[0];
        chars[0] = chars[chars.length - 1];
        chars[chars.length - 1] = temp;
        return new StringBuilder(new String(chars)).reverse().toString();
    }

    public static String decrypt(String cipherText) {
        char[] chars = new StringBuilder(cipherText).reverse().toString().toCharArray();        char temp = chars[0];
        chars[0] = chars[chars.length - 1];
        chars[chars.length - 1] = temp;
        for (int i = 0; i < chars.length; i++) {
            chars[i] -= i + 1 + 3;
        }
        return new String(chars);
    }
}