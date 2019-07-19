import edu.duke.FileResource;
import edu.duke.StorageResource;

public class Part3 {

    public float cgRatio(String dna)
    {
        int length=dna.length(),count=0;
        for(int i=0;i<length;i++)
            if(dna.charAt(i)=='g' || dna.charAt(i)=='c')
                count++;
        return (float)count/length;
    }

    public void processGenes(StorageResource sr)
    {
        StorageResource stringsLongerThanNine = new StorageResource();
        StorageResource stringsCGRatio = new StorageResource();
        int highestLength=0;
        for(String st:sr.data())
        {
            if(st.length()>60)
                stringsLongerThanNine.add(st);
            if(cgRatio(st)>0.35)
                stringsCGRatio.add(st);
            highestLength = Math.max(highestLength,st.length());
        }
        System.out.println("Strings longer than 60 Characters: ");
        for(String s: stringsLongerThanNine.data())
            System.out.println(s);
        System.out.println("\nNo. of strings that are longer than 60 Characters: "+stringsLongerThanNine.size());
        System.out.println("\nStrings whose C-G ratio is higher than 0.35: ");
        for(String s: stringsCGRatio.data())
            System.out.println(s);
        System.out.println("\nNo.of strings whose C-G-ratio is higher than 0.35: "+stringsCGRatio.size());
        System.out.println("\nLength of the longest string: "+highestLength);
    }
    public void testProcessGenes()
    {
        FileResource fr = new FileResource("brca1line.fa");
        String dna = fr.asString();
        StorageResource sr = new StorageResource();
        sr.add(dna);
        processGenes(sr);
    }
    public static void main(String args[])
    {
        Part3 obj = new Part3();
        obj.testProcessGenes();
    }
}
