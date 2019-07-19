import edu.duke.StorageResource;

import javax.print.DocFlavor;

public class Part1 {

    public int findStopCodon(String dna,int startIndex,String stopCodon) {
        int currIndex = dna.indexOf(stopCodon, startIndex);
        while (currIndex != -1)
        {
            if ((currIndex - startIndex) % 3 == 0)
                return currIndex+3;
            currIndex = dna.indexOf(stopCodon,currIndex+1);
        }
        return dna.length();
    }

    public void testFindStopCodon()
    {
        //                012345678901234
        String test[] = {"ATGAAAAAAAAATAAG"};
        System.out.println(findStopCodon(test[0],0,"TAA"));
    }

    public String findGene(String dna,int where)
    {
        int startIndex = dna.indexOf("ATG",where);
        if(startIndex==-1)
            return "";
        int taaIndex = findStopCodon(dna,startIndex+3,"TAA");
        int tagIndex = findStopCodon(dna,startIndex+3,"TAG");
        int tgaIndex = findStopCodon(dna,startIndex+3,"TGA");
        int stopIndex = Math.min(taaIndex,Math.min(tgaIndex,tagIndex));
        if(stopIndex==dna.length())
            return "";
        return dna.substring(startIndex,stopIndex);
    }
    public void testFindGene()
    {
        System.out.println(findGene("ATGAAAAAAAAATAAG",0));
    }
    public void printAllGenes(String dna)
    {
        int startIndex = 0;
        System.out.println("Genes for the dna : "+dna+" are : ");
        while(true)
        {
            String currGene = findGene(dna,startIndex);
            if(currGene.isEmpty())
                break;
            System.out.println(currGene);
            startIndex = dna.indexOf(currGene,startIndex)+currGene.length();
        }
    }
    public StorageResource getAllGenes(String dna)
    {
        int startIndex = 0;
        StorageResource res = new StorageResource();
        while(true)
        {
            String currGene = findGene(dna,startIndex);
            if(currGene.isEmpty())
                break;
            res.add(currGene);
            startIndex = dna.indexOf(currGene,startIndex)+currGene.length();
        }
        return res;
    }
    public void testGetAllGenes()
    {
        StorageResource genes = getAllGenes("ATGATCTAATTTATGCTGCAACGGTGAAGA");
        System.out.println("Genes are : ");
        for(String s:genes.data())
        {
            System.out.println(s);
        }
    }

    public static void main(String args[])
    {
        Part1 obj = new Part1();
//        obj.printAllGenes("AGTSSSSTTASSTTASTTA");
        obj.testGetAllGenes();
    }

}
