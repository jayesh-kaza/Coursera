import edu.duke.FileResource;

public class TestCaesarCipher {

    public int[] countLetters(String input)
    {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int count[] = new int[26];
        for(int i=0;i<input.length();i++)
        {
            int index = alphabet.indexOf(Character.toLowerCase(input.charAt(i)));
            if(index!=-1)
                count[index] += 1;
        }
        return count;
    }

    public int maxIndex(int[] count)
    {
        int index = 0;
        for(int i=0;i<count.length;i++)
            if(count[index] < count[i])
                index = i;
        return index;
    }

    public int getKey(String s)
    {
        int count[] = countLetters(s);
        int maxDex = maxIndex(count);
        int dkey = maxDex - 4;
        if(maxDex < 4)
            dkey = 26 - (4 - maxDex);
        return 26-dkey;
    }

    public void simpleTests()
    {
        FileResource fr = new FileResource();
        OneKey obj = new OneKey(18);
        String encrypted = obj.encrypt(fr.asString());
        System.out.println("Enctpyed String is : "+encrypted);
        String decrypted = obj.decrypt(encrypted);
        System.out.println("Decrypted String is : "+decrypted);
        breakCaesarCipher(encrypted);
    }

    public void breakCaesarCipher(String input)
    {
        int key = getKey(input);
        OneKey cc = new OneKey(key);
        System.out.println("Decrypted message is :"+cc.decrypt(input));
    }

    public static void main(String args[])
    {
        TestCaesarCipher obj = new TestCaesarCipher();
        obj.simpleTests();
    }
}
