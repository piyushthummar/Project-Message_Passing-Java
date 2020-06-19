/**
 * 
 */
package ca.concordia.comp6411.MessagePassing;

import java.util.Arrays;

/**
 * @author PIYUSH
 *
 */
public class CallsData {
	private String sender;
	private String[] receivers;
	/**
	 * @param sender
	 * @param receivers
	 */
	public CallsData(String sender, String[] receivers) {
		super();
		this.sender = sender;
		this.receivers = receivers;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String[] getReceivers() {
		return receivers;
	}
	public void setReceivers(String[] receivers) {
		this.receivers = receivers;
	}
	@Override
	public String toString() {
		return sender + ": " + Arrays.toString(receivers);
	}
	
}
