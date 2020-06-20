import java.util.List;

/**
 * 
 */

/**
 * @author PIYUSH
 *
 */
public class MasterThread extends Thread{
	private volatile boolean processComplete = false;
	private List<CallsData> callsData = null;
	/**
	 * @param callsData
	 */
	public MasterThread(List<CallsData> callsData) {
		super();
		this.callsData = callsData;
	}
	
	public void terminateMaster(){
		processComplete = true;
	}
	
	public void run() {
		System.out.println("** Calls to be made **");
		for (CallsData call : callsData) {
			System.out.println(call.toString());
		}
		System.out.println("");
		
//		Creating friend threads...
		for (CallsData call : callsData) {
			Calling_FriendThread friend = new Calling_FriendThread(call.getReceivers(), this);
			friend.setName(call.getSender());
			friend.start();
		}
		
	}
}
