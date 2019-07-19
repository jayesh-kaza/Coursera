public class Part1 {
    public String findSimpleGene(String dna)
    {
        int startIndex = dna.indexOf("ATG");
        if(startIndex==-1)
            return "";
        int stopIndex = dna.indexOf("TAA",startIndex+3);
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
        String dnas[] = {"TACGGGGGGGGGGAGTCAGATAA","ATGCATGCATGCATGCATGCATGC","ATCCAT","ATGCGTAGATGATGCTAA","ATGCGTAGATGTGCTAA"};
        for(String dna:dnas)
        {
            System.out.println("Dna is : "+dna);
            System.out.println("Gene is : "+findSimpleGene(dna));
        }
    }
    public static void main(String args[])
    {
        Part1 obj = new Part1();
        obj.testSimpleGene();
    }
}
