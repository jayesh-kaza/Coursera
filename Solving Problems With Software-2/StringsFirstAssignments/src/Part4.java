import edu.duke.URLResource;

public class Part4 {
    public static void main(String args[])
    {
        URLResource ur = new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
        for(String word:ur.words())
        {
            if(word.contains("youtube.com"))
            {
                int firstIdx = word.indexOf("\"");
                int lastIdx = word.indexOf("\"",firstIdx+1);
                System.out.println(word.substring(firstIdx,lastIdx+1));
            }
        }
    }
}
