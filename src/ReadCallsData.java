/**
 * 
 */
//package ca.concordia.comp6411.MessagePassing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * @author PIYUSH
 *
 */
public class ReadCallsData {
	public static CallsData decipherRecord(String record){
		record = record.trim().replace(".", "").replace("{", "").replace("}", "");
		String[] splittedRecord = record.split(",");
		String sender = splittedRecord[0];
		String[] receivers = new String[splittedRecord.length - 1];
		for(int index = 1; index < splittedRecord.length; index++){
			String purifiedRecord = splittedRecord[index].trim().replace("[", "").replace("]", "");
			receivers[index-1] = purifiedRecord;
		}
		CallsData data = new CallsData(sender, receivers);
		return data;
	}
	
	public static List<CallsData> readCallLogs(String fileName){
		List<CallsData> callRecords = new ArrayList<>();
		BufferedReader file = null;
		try {
			file = new BufferedReader(new FileReader(new File(fileName)));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String record = null;
		try {
			while((record = file.readLine()) != null){
				if(record.trim().length() == 0){
					continue;
				}
				callRecords.add(decipherRecord(record));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return callRecords;
	}
}
