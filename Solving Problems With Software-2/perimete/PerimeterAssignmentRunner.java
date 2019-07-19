import edu.duke.*;
import java.io.File;
import java.util.Iterator;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        Iterable<Point> it = s.getPoints();
        int ans  = 0;
        for(Point x:it)
            ans+=1;
        return ans;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        return getPerimeter(s)/getNumPoints(s);
    }

    public double getLargestSide(Shape s) {
        // Put code here
        double largestSide = 0.0;
        Point lastPoint = s.getLastPoint();
        for(Point currPoint : s.getPoints())
        {
            double currDist = lastPoint.distance(currPoint);
            largestSide = Math.max(largestSide,currDist);
            lastPoint =currPoint;
        }
        return largestSide;
    }

    public double getLargestX(Shape s) {
        // Put code here
        double largestX = s.getLastPoint().getX();
        for(Point p:s.getPoints())
        {
            largestX = Math.max(largestX,p.getX());
        }
        return largestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        DirectoryResource dr = new DirectoryResource();
        double largestPerimeter = 0.0;
        for(File f: dr.selectedFiles())
        {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            largestPerimeter = Math.max(largestPerimeter,getPerimeter(s));
        }
        return largestPerimeter;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        DirectoryResource dr = new DirectoryResource();
        double largestPerimeter = 0.0;
        File fileWithLargestPerimeter = null;
        for(File f: dr.selectedFiles())
        {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double currPerimeter = getPerimeter(s);
            if(largestPerimeter<currPerimeter)
            {
                largestPerimeter = currPerimeter;
                fileWithLargestPerimeter = f;
            }
        }
        return fileWithLargestPerimeter.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        int numberOfPoints = getNumPoints(s);
        System.out.println("no. of points = "+numberOfPoints);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        double avgLength = getAverageLength(s);
        System.out.println("average length = " + avgLength);
        double largestSide = getLargestSide(s);
        System.out.println("largest side = "+largestSide);
        double largestX = getLargestX(s);
        System.out.println("largest x = "+largestX);
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
        System.out.println("Largest perimeter among selected files : "+getLargestPerimeterMultipleFiles());
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
        System.out.println("File with largest perimeter is : "+getFileWithLargestPerimeter());
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
        pr.testFileWithLargestPerimeter();
        pr.testPerimeterMultipleFiles();
    }
}
