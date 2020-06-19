/**
 * 
 */
package ca.concordia.comp6411.MessagePassing;

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
		List<CallsData> callRecords = ReadCallsData.readCallLogs("src/ca/concordia/comp6411/MessagePassing/calls.txt");
		for(CallsData call : callRecords){
			System.out.println(call.toString());
		}
	}

}
