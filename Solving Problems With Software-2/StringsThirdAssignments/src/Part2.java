public class Part2 {
    public float cgRatio(String dna)
    {
        int length=dna.length(),count=0;
        for(int i=0;i<length;i++)
            if(dna.charAt(i)=='G' || dna.charAt(i)=='C')
                count++;
        return (float)count/length;
    }

    public int countCTG(String dna)
    {
        int count=0;
        int startIndex = dna.indexOf("CTG");
        while(startIndex!=-1)
        {
            startIndex = dna.indexOf("CTG",startIndex+3);
            count++;
        }
        return count;
    }
    public static void main(String args[])
    {
        Part2 obj = new Part2();
        System.out.println(obj.cgRatio("ATGCCATAG"));
        System.out.println(obj.countCTG("ATGCTGCATAG"));
    }
}
