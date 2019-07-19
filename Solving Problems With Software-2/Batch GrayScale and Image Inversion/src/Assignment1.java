import edu.duke.DirectoryResource;
import edu.duke.ImageResource;
import edu.duke.Pixel;

import javax.print.DocFlavor;
import java.io.File;

public class Assignment1 {

    public ImageResource makeGrey(ImageResource image)
    {
        ImageResource newImage = new ImageResource(image.getWidth(),image.getHeight());
        for(Pixel pixel: newImage.pixels())
        {
            Pixel inPixel = image.getPixel(pixel.getX(),pixel.getY());
            int average = (inPixel.getRed()+inPixel.getBlue()+inPixel.getGreen())/3;
            pixel.setBlue(average);
            pixel.setGreen(average);
            pixel.setRed(average);
        }
        return newImage;
    }

    public void selectAndConvert()
    {
        DirectoryResource dir = new DirectoryResource();
        for(File f:dir.selectedFiles())
        {
            ImageResource image = new ImageResource(f);
            ImageResource newImage = makeGrey(image);
            String newName = "grey-"+image.getFileName();
            newImage.setFileName(newName);
            newImage.save();
            newImage.draw();
        }
    }
    public static void main(String args[])
    {
        Assignment1 obj = new Assignment1();
        obj.selectAndConvert();
    }

}
