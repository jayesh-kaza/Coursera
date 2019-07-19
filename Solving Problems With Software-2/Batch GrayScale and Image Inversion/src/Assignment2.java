import edu.duke.DirectoryResource;
import edu.duke.ImageResource;
import edu.duke.Pixel;

import java.io.File;

public class Assignment2 {

    public ImageResource makeInversion(ImageResource image)
    {
        ImageResource newImage = new ImageResource(image.getWidth(),image.getHeight());
        for(Pixel pixel: newImage.pixels())
        {
            Pixel inPixel = image.getPixel(pixel.getX(),pixel.getY());
            pixel.setBlue(255-inPixel.getBlue());
            pixel.setGreen(255-inPixel.getGreen());
            pixel.setRed(255-inPixel.getRed());
        }
        return newImage;
    }
    public void selectAndConvert()
    {
        DirectoryResource dir = new DirectoryResource();
        for(File f:dir.selectedFiles())
        {
            ImageResource image = new ImageResource(f);
            ImageResource newImage = makeInversion(image);
            String newName = "inverted-"+image.getFileName();
            newImage.setFileName(newName);
            newImage.save();
            newImage.draw();
        }
    }
    public static void main(String args[])
    {
        Assignment2 obj = new Assignment2();
        obj.selectAndConvert();
    }
}
