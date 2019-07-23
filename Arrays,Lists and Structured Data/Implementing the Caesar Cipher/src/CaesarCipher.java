import edu.duke.FileResource;

public class CaesarCipher {

    public String encrypt(String input,int key)
    {
        StringBuilder encrypted = new StringBuilder(input);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0,key);
        for(int i=0;i<encrypted.length();i++)
        {
            char currentChar = encrypted.charAt(i);
            boolean flag = false;
            if(Character.isLowerCase(currentChar)) {
                flag = true;
                currentChar = Character.toUpperCase(currentChar);
            }

            int idx = alphabet.indexOf(currentChar);

            if(idx!=-1) {
                if(flag)
                    encrypted.setCharAt(i, Character.toLowerCase(shiftedAlphabet.charAt(idx)));
                else
                    encrypted.setCharAt(i,shiftedAlphabet.charAt(idx));
            }
        }
        return encrypted.toString();
    }

    public void testCaesar()
    {
        FileResource fr = new FileResource();
        String message = fr.asString();
        int key = 13;
        String encrypted = encrypt(message,key);
        System.out.println("Key is "+key+"\n"+encrypted);
    }

    public String encryptTwoKeys(String input,int key1,int key2)
    {
        StringBuilder encrypted = new StringBuilder(input);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0,key1);
        String shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0,key2);
        for(int i=0;i<encrypted.length();i++)
        {
            char currentChar = encrypted.charAt(i);
            boolean flag = false;
            if(Character.isLowerCase(currentChar)) {
                flag = true;
                currentChar = Character.toUpperCase(currentChar);
            }

            int idx = alphabet.indexOf(currentChar);

            if(idx!=-1)
            {
                if (i % 2 == 0) {
                    if (flag)
                        encrypted.setCharAt(i, Character.toLowerCase(shiftedAlphabet1.charAt(idx)));
                    else
                        encrypted.setCharAt(i, shiftedAlphabet1.charAt(idx));
                } else {
                    if (flag)
                        encrypted.setCharAt(i, Character.toLowerCase(shiftedAlphabet2.charAt(idx)));
                    else
                        encrypted.setCharAt(i, shiftedAlphabet2.charAt(idx));
                }
            }
        }
        return encrypted.toString();
    }
    public static void main(String args[])
    {
        CaesarCipher obj = new CaesarCipher();
        //obj.testCaesar();
        //System.out.println(obj.encrypt("First Legion",17));
        //System.out.println(obj.encrypt("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!",15));
        //System.out.println(obj.encrypt("Pi cddc qt xc iwt rdcutgtcrt gddb lxiw ndjg wpi dc udg p hjgegxht epgin. NTAA ADJS!",26-15));
        //System.out.println(obj.encryptTwoKeys("First Legion",23,17));
        //System.out.println(obj.encryptTwoKeys("Czojq Ivdzle",26-23,26-17));
        //System.out.println(obj.encrypt("Just a test string with lots of eeeeeeeeeeeeeeeees",18));
        //System.out.println(obj.encryptTwoKeys("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!",8,21));
        //System.out.println(obj.encryptTwoKeys("Top ncmy qkff vi vguv vbg ycpx",26-2,26-20));
        //System.out.println(obj.encrypt("Can you imagine life WITHOUT the internet AND computers in your pocket?",15));
        //System.out.println(obj.encryptTwoKeys("Can you imagine life WITHOUT the internet AND computers in your pocket?",21,8));
        System.out.println(obj.encryptTwoKeys("Hfs cpwewloj loks cd Hoto kyg Cyy.",26-14,26-24));

    }
}
