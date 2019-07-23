import edu.duke.FileResource;

public class TestCaesarCipherTwo {

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

    public String halfOfString(String message, int start)
    {
        StringBuilder halfString = new StringBuilder();
        for(int i=start;i<message.length();i+=2)
            halfString.append(message.charAt(i));
        return halfString.toString();
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
        CaesarCipherTwo obj = new CaesarCipherTwo(17,3);
        String encrypted = obj.encrypt(fr.asString());
        System.out.println("Encrypted String is : "+encrypted);
        String decrypted = obj.decrypt(encrypted);
        System.out.println("Decrypted String is : "+decrypted);
        breakCaesarCipher(encrypted);
    }

    public void breakCaesarCipher(String input)
    {
        String s1 = halfOfString(input,0);
        String s2 = halfOfString(input,1);
        int key1 = getKey(s1);
        int key2 = getKey(s2);
        System.out.println("Key1 : "+key1+" Key2 : "+key2);
        CaesarCipherTwo cc = new CaesarCipherTwo(key1,key2);
        System.out.println("Decrypted String is : "+cc.encrypt(input));
    }

    public static void main(String args[])
    {
        TestCaesarCipherTwo obj = new TestCaesarCipherTwo();
        obj.simpleTests();
    }

}
