public class OneKey {

    private String alphabet;
    private String shiftedAlphabet;
    private int mainKey;

    OneKey(int key)
    {
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0,key);
        mainKey = key;
    }

    public String encrypt(String input)
    {
        StringBuilder encrypted = new StringBuilder(input);
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

    public String decrypt(String input)
    {
        OneKey obj = new OneKey(26-mainKey);
        return obj.encrypt(input);
    }
}

