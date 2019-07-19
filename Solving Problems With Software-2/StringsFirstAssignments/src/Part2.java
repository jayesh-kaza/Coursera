public class Part2 {
    public String findSimpleGene(String dna,String startCodon,String stopCodon,boolean flag)
    {
        if(flag)
        {
            startCodon = startCodon.toLowerCase();
            stopCodon = stopCodon.toLowerCase();
        }
        int startIndex = dna.indexOf(startCodon);
        if(startIndex==-1)
            return "";
        int stopIndex = dna.indexOf(stopCodon,startIndex+3);
        if(stopIndex==-1)
            return "";
        String gene = dna.substring(startIndex,stopIndex+3);
        if(gene.length()%3==0)
            return gene;
        else
            return "";
    }
    public void testSimpleGene()
    {
        String dnas[] = {"TACGGGGGGGGGGAGTCAGATAA","ATGCATGCATGCATGCATGCATGC","ATCCAT","atgacataa","ATGCGTAGATGATGCTAA"};
        for(String dna:dnas)
        {
            boolean flag = false;
            if(dna.toLowerCase().equals(dna))
                flag = true;
            System.out.println("Dna is : "+dna);
            System.out.println("Gene is : "+findSimpleGene(dna,"ATG","TAA",flag));
        }
    }
    public static void main(String args[])
    {
        Part2 obj = new Part2();
        obj.testSimpleGene();

    }
}
