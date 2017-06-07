import javax.swing.*;

/**
 * Created by charpentiert on 6/6/17.
 */
public class Shift
{
    public static void main(String [] args)
    {
        String word = getWord();
        int shift = getShift();
        String eWord = encrypt(word, shift);
        //displayEword(eWord, word);

        String orig = decrypt(eWord, shift);

        System.out.println("Original word: " + word);
        System.out.println("shift by: " + shift);
        System.out.println("Encrypted: " + eWord);
        System.out.println("Decrypted: " + orig);
    }

    public static String getWord()
    {
        return JOptionPane.showInputDialog(null, "What word would you like to encrypt").toLowerCase();
    }

    public static int getShift()
    {
        return Integer.parseInt(JOptionPane.showInputDialog(null, "How many characters would you like to shift by?")) % 26;
    }

    public static String encrypt(String word, int shift)
    {
        String buffer = "";
        for (int i = 0; i < word.length(); i++)
        {
            char character = word.charAt(i);
            if (character <= 'z' && character >= 'a')
            {
                character -= 'a' - shift;
                character %= 26;
                character += 'a';
            }
            buffer += character;
        }
        return buffer;
    }

    public static void displayEword(String eWord, String word)
    {
        JOptionPane.showMessageDialog(null, word + " => " + eWord);
    }

    public static String decrypt(String word, int shift)
    {
        String buffer = "";
        for (int i = 0; i < word.length(); i++) {
            char character = word.charAt(i);
            if (character <= 'z' && character >= 'a')
            {
                character -= 'a' - (26 - shift);
                character %= 26;
                character += 'a';
            }
            buffer += character;
        }
        return buffer;
    }

}
