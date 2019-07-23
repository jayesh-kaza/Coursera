public class CaesarBreaker {
    public int[] countLetters(String input)
    {
        //                 01234567890123456789012345
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

    public String decrypt(String encrypted)
    {
        CaesarCipher cc = new CaesarCipher();
        int dkey = getKey(encrypted);
        return  cc.encrypt(encrypted,26-dkey);
    }

    public void testDecrypt()
    {
        System.out.println(decrypt("Bmkl s lwkl kljafy oalz dglk gx wwwwwwwwwwwwwwwwwk"));
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

    public String decryptTwoKeys(String encrypted)
    {
        String s1 = halfOfString(encrypted,0);
        String s2 = halfOfString(encrypted,1);
        int key1 = getKey(s1);
        int key2 = getKey(s2);
        System.out.println("Key1 : "+key1+" Key2 : "+key2);
        CaesarCipher cc = new CaesarCipher();
        return cc.encryptTwoKeys(encrypted,key1,key2);
    }
    public static void main(String args[])
    {
        CaesarBreaker csb = new CaesarBreaker();
        //csb.testDecrypt();
        //System.out.println(csb.halfOfString("Qbkm Zgis", 1));
        //System.out.println(csb.decryptTwoKeys("Gwpv c vbuq pvokki yfve iqqu qc bgbgbgbgbgbgbgbgbu\n"));
        //System.out.println(csb.decryptTwoKeys("Akag tjw Xibhr awoa aoee xakex znxag xwko"));
        //System.out.println(csb.decryptTwoKeys("Aal uttx hm aal Qtct Fhljha pl Wbdl. Pvxvxlx!"));

        System.out.println(csb.decryptTwoKeys("Uybi Gfqgykii Jgziegv Uigeixdiex Smiizzin\n" +
                "\n" +
                "Sei sw klv deec lrpcqrvbw sw fyi jytgvwj yej sivr jiyzxwyc tscprffvrxzsew edsek hzjwiiiex kisltj nmklzr xyi hvtrvkqvrk, azxy iijirvtl kisltj zr sklvv hvtrvkqvrkw ek Uybi, nmkl sklvv mewkmkykij, eeh azxy zruyjxic. Rw av dsmi mexf klv zrwsiqrxzse rkv, xyi jfglw sw jgziegv zw wymwxzrx wvfq xyi hzwtsmiic sw ein zrwsiqrxzse ks xyi gfqgykekmfrrpcc mexvrjmmi xrwb fj tistijwzrx rru rrrppdzrx zrwsiqrxzse.\n" +
                "\n" +
                "Ni lrzv fykwkeehzrx gvfkiedw me xifqvximt tsdtlxzrx; mexvveik jcjxvqj, rvxnsiozrx, eeh wvglvzxp; fzscsxmtec tsdtlxzrx; qvqfvp jcjxvqj rru dejwzzv ueke qrrrkvqvrk; eeh pveirzrx rru dsuicmek. Klv iijirvtl mexvvvwkw sw fyi wetycxp fzvvceg nmkl xyiji eiirw eeh azxy iijirvtlvv eiirw me fxyii umjgztcmeij jytl ej smfpfkp, iekzrviimek, eeeskitlescsxc, rru vrmmiseqvrkec jgziegvw.\n" +
                "\n" +
                "GJ Uigx Tysks Av rpjs hf nsio me r eydfvv sw fxyii zqgsixrrk rvvej zrtplhzrx tsdtlxvv kieglzgj rru mmjyrpzdrxzse, wvrjsi eikafvbw, eydiimtec rrrppwzw, jswxneii iekzrviimek, tsdtciomkc xyifvp, eeh vfffxzgj.\n" +
                "\n" +
                "Klv uigeixdiex mj rvxyrfcc yemhyv zr xyi wpqsmfwzw xyek vbzwkw fvxnivr xyi iuytekmfr kislt eeh xyi vvwveigy wetycxp. Xyi wprvvxc fvxnivr xyid yej sivr e ovc xf klv jytgvwj zr gfrkmeyrpcc vvjfvdmek xyi glvimtycyd rru zrkixvrxzrx iijirvtl eeh iuytekmfr. Klv uigeixdiex mj lwzrx r uyrp egtisrgy ks gfqsmei vvwveigy rru vhlgrxzse. Fimekzrx iijirvtl mexf klv tyivzglplq mj klv sijx arc xf kvrme jxlhvrkw esslx xyi qfwk rhmeegvh xvgyrfpfkp rru ks hzwjidmeeki xyi prxvwk uimicsgqvrkw sw tsdtlxzrx kitlescsxc me jstmvxp.\n" +
                "\n" +
                "TW Hvtk Glfxf Ni iegfyiexi yehvvxvrhleki wkyuiexj ks kvx mezfpmiu nmkl sekfmek qrnfv vvwveigy gvfnvgkw xyvfyxl xyi G-WLVW gvfkied, yehvvxvrhleki xyijij, Vvwveigy Vbgiimvrti jfv Yehvvxvrhlekij (VVY) jygtfvk, mehvtvruiex wkyumvw, vxt. Wfqv fj slv iogvtkmfrrp jzvjx qrnfvj xvrhleki azxy umjxzrtxzse, aymtl mezfpmij r jmxrzjzgrrk iijirvtl gfqgseiex, rru zr qrrp tejij klv iijirvtl lrw vvwlpkiu zr tlfcmtekmfrj zr pveumek gfrwiiiegvw.\n" +
                "\n" +
                "Xyi idmeiegv fj slv vvwveigy rru kirgymek jrglpkc mj klv smxkvwk jxiiekkl sw klv uigeixdiex. Deec jrglpkc qvqsiiw lrzv sivr vvgfkemqiu sskl ek lrzzvvjmkc eeh rrxzseec cimicw jfv xyizv iogvpciegv zr vvwveigy, iuytekmfr, rru jiizzgv. Lzkypp mmjmspv, qlpkmumjgztcmeeic tisaitxj rvv sizrx tsehlgkiu, wgsewfvvh fp meimfyj wyehzrx rkvrtmvw.\n" +
                "\n" +
                "Xyi hvtrvkqvrk gvfzzhvw ee vbkvvqvpp jxzqlprxzrx, tisuytxzzv, eeh jimvrupp vrmmiseqvrk zr xyi jfvd fj gcejwisfq, fjwmti, rru ces jtrgv; gfqgykmek mejiejxiytxlvv; xvetlzrx jygtfvk; eeh kieuyrxv wicpfajlztj rru rwjmjxrrkwymgw. Zx ieespvw jrglpkc eeh wkyuiexj ks etgfqgpzwy klvmi wycp tfxvrkmrp. Klv uigeixdiex mj tsewkvlgkiu ks iegfyiexi merfzrxzzv tscprffvrxzsew edsek xyi wtmvrtij, iekzrviimek, vrmmiseqvrkec jxlhzij, eeh qvhzgzrv.\n"));

    }


}
