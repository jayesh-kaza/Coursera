public class Part2 {

    public int howMany(String stringa,String stringb)
    {
        int count=0;
        int startIndex = stringb.indexOf(stringa);
        while(startIndex!=-1)
        {
            startIndex = stringb.indexOf(stringa,startIndex+stringa.length());
            count++;
        }
        return count;
    }
    public void testHowMany()
    {
        System.out.println(howMany("GAA","ATGAACGAATTGAATC"));
        System.out.println(howMany("AA","ATAAAA"));
    }
    public static void main(String args[])
    {
        Part2 obj = new Part2();
        obj.testHowMany();
    }
}
