package export;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVWriter;

public class CSV {

	public static void exportStringListToCSV (List<String[]> stringToExport, String fileName) throws IOException {
		 CSVWriter csvWriter = new CSVWriter(new FileWriter(fileName + ".csv"));
		 csvWriter.writeAll(stringToExport);
		 csvWriter.close();
	}
}
