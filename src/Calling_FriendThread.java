import java.util.List;

/**
 * 
 */

/**
 * @author PIYUSH
 *
 */
public class Calling_FriendThread extends Thread{
	String[] receivers = null;
	MasterThread master;
	/**
	 * @param receivers
	 * @param master
	 */
	public Calling_FriendThread(String[] receivers, MasterThread master) {
		super();
		this.receivers = receivers;
		this.master = master;
	}
	
	public void run(){
//		Processing each message from sender to receiver and vice versa.
		for(String receiver : receivers){
			long currentTime = System.currentTimeMillis();
			sendIntroMessage(this.getName(), receiver, currentTime);
		}
		
		master.terminateMaster(this.getName());
	}
	
	private synchronized void sendIntroMessage(String sender, String receiver, long timeStamp){
		try {
//			Before sending a intro message, thread will randomly sleep between 0 to 100 milliseconds
			Thread.sleep((long) (Math.random() * 1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		String sendMessage = receiver + " received intro message from " + sender;
		master.printMessage(sendMessage, timeStamp);
		
		String replyMessage = sendReplyMessage(sender, receiver, timeStamp);
		master.printMessage(replyMessage, timeStamp);
	}
	
	private synchronized String sendReplyMessage(String sender, String receiver, long timeStamp){
		try {
//			Before sending a reply message, thread will randomly sleep between 0 to 100 milliseconds
			Thread.sleep((long) (Math.random() * 1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		String replyMessage = sender + " received reply message from " + receiver;
		return replyMessage;
	}
}
