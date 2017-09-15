package csvReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Reader
{
    public static final String csvPath = System.getProperty("user.dir") + "\\csv\\";

	public static List<String[]> readInFile(String filenameInCsvFolder)
	{
		String csvFile = csvPath + filenameInCsvFolder;
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";

		List<String[]> returnList = new ArrayList<>();

		try
		{
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {

				// use comma as separator
				returnList.add(line.split(cvsSplitBy));
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (br != null)
			{
				try
				{
					br.close();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}

		return returnList;
	}

	public static void main(String[] args)
	{
		for (String[] line : readInFile("exercises.csv"))
		{
			System.out.println(Arrays.asList(line));
		}
	}
}
