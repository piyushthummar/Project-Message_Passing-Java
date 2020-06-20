/**
 * 
 */
//package ca.concordia.comp6411.MessagePassing;

import java.util.List;

/**
 * @author PIYUSH
 *
 */
public class Exchange {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(System.getProperty("user.dir"));
		List<CallsData> callRecords = ReadCallsData.readCallLogs("src/calls.txt");
		MasterThread masterProcess = new MasterThread(callRecords);
		masterProcess.start();
	}

}
