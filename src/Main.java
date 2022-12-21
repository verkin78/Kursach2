import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        String string = (JOptionPane.showInputDialog(null, "Введите текст для строки"));
        String s1 = string.substring(0, string.length() / 2);
        String s2 = string.substring(string.length() / 2, string.length());
        JOptionPane.showMessageDialog(null, "Введённая строка разделена пополам на (" + s1
                + ") и (" + s2 + ")");
    }
}

