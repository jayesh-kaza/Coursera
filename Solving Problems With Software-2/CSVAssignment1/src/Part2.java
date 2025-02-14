import edu.duke.DirectoryResource;
import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;

public class Part2 {

    public CSVRecord coldestHourInFile(CSVParser parser)
    {
        CSVRecord coldestSoFar = null;
        for(CSVRecord record: parser)
        {
            double thisRecordTemp = Double.parseDouble(record.get(1));
            if(coldestSoFar==null && thisRecordTemp!=-9999)
                coldestSoFar = record;

            if(thisRecordTemp < Double.parseDouble(coldestSoFar.get(1)) && thisRecordTemp!=-9999)
                coldestSoFar = record;
        }
        return coldestSoFar;
    }
    public void testColdestHourInFile()
    {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord coldestRecord = coldestHourInFile(parser);
        System.out.println(coldestRecord.get(0)+" "+coldestRecord.get(1));
    }

    public String fileWithColdestTemperature()
    {
        DirectoryResource dir = new DirectoryResource();
        CSVRecord coldestSoFar = null;
        File coldestFile = null;
        for(File f: dir.selectedFiles())
        {
            FileResource fr = new FileResource(f);
            CSVRecord current = coldestHourInFile(fr.getCSVParser());
            if(coldestSoFar==null) {
                coldestSoFar = current;
                coldestFile = f;
            }
            else
            {
                double currentTemp = Double.parseDouble(current.get(1));
                if(currentTemp < Double.parseDouble(coldestSoFar.get(1)) && currentTemp!=-9999) {
                    coldestSoFar = current;
                    coldestFile = f;
                }
            }
        }
        return coldestFile.getName();
    }

    public void testFileWithColdestTemperature()
    {
        String file = fileWithColdestTemperature();
        System.out.println("Coldest day was in the file: "+file);
        FileResource fr = new FileResource("nc_weather/2014/"+file);
        CSVParser parser = fr.getCSVParser();
        System.out.println("Coldest temperature on that day was: "+coldestHourInFile(parser).get(1));
        parser = fr.getCSVParser();
        System.out.println("All the temperatures on the coldest day were:");
        for(CSVRecord record: parser)
        {
            System.out.println(record.get(13)+" "+record.get(1));
        }
    }

    public CSVRecord lowestHumidityInFile(CSVParser parser)
    {
        CSVRecord lowestSoFar = null;
        for(CSVRecord record: parser)
        {
            if(record.get(3).equals("N/A"))
                continue;
            int thisRecordHumidity = Integer.parseInt(record.get(3));
            if(lowestSoFar==null)
                lowestSoFar = record;
            if(thisRecordHumidity < Integer.parseInt(lowestSoFar.get(3)))
                lowestSoFar = record;
        }
        return lowestSoFar;
    }

    public void testLowestHumidityInFile()
    {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord csv = lowestHumidityInFile(parser);
        System.out.println("Lowest Humidity was "+csv.get(3)+" at "+csv.get(13));
    }

    public CSVRecord lowestHumidityInManyFiles()
    {
        DirectoryResource dir = new DirectoryResource();
        CSVRecord lowestSoFar = null;
        for(File f: dir.selectedFiles())
        {
            FileResource fr = new FileResource(f);
            CSVRecord current = lowestHumidityInFile(fr.getCSVParser());
            if(current.get(3).equals("N/A"))
                continue;
            if(lowestSoFar==null)
                lowestSoFar = current;
            else
            {
                int thisRecordHumidity = Integer.parseInt(current.get(3));
                if(thisRecordHumidity < Integer.parseInt(lowestSoFar.get(3)))
                    lowestSoFar = current;
            }
        }
        return lowestSoFar;
    }

    public void testLowestHumidityInManyFiles()
    {
        CSVRecord csv = lowestHumidityInManyFiles();
        System.out.println("Lowest Humidity was "+csv.get(3)+" at "+csv.get(13));
    }

    public double averageTemperatureInFile(CSVParser parser)
    {
        double sum = 0;
        double count = 0;
        for(CSVRecord record: parser)
        {
            sum += Double.parseDouble(record.get(1));
            count++;
        }
        return sum/count;
    }
    public void testAverageTemperatureInFile()
    {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        System.out.println("Average temperature in file is "+averageTemperatureInFile(parser));
    }

    public double averageTemperatureWithHighHumidityInFile(CSVParser parser,int value)
    {
        double sum = 0;
        double count = 1;
        for(CSVRecord record: parser)
        {
            if(record.get(3).equals("N/A") || Integer.parseInt(record.get(3))<value)
                continue;
            sum += Double.parseDouble(record.get(1));
            count++;
        }
        if(count==1)
            return 0.0;
        return sum/(count-1);
    }

    public void testAverageTemperatureWithHighHumidityInFile()
    {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        double average = averageTemperatureWithHighHumidityInFile(parser,80);
        if(average==0)
            System.out.println("No temperatures with that humidity");
        else
            System.out.println("Average Temp when high Humidity is "+average);
    }
    public static void main(String args[])
    {
        Part2 obj = new Part2();
        obj.testAverageTemperatureWithHighHumidityInFile();
    }
}
