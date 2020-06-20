import java.util.List;

import sun.swing.plaf.synth.SynthFileChooserUIImpl;

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
	
	public void shutDownProcess(){
		processComplete = true;
	}
	
	int processCounter = 0;
	int count = 0;
	public void terminateMaster(String masterProcessName){
		synchronized (callsData) {
			this.waitAndNotifyProcess();
			this.shutDownProcess();
			System.out.println("\nProcess " + masterProcessName + " has received no calls for 5 second, ending...");
			count++;
			if(count == processCounter){
				try {
					callsData.wait(10 * 1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("\nMaster has received no replies for 10 seconds, ending...");
			}
		}
	}
	
	private void waitAndNotifyProcess(){
		
			if(processCounter < callsData.size() - 1){
				processCounter++;
				try {
					callsData.wait(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				callsData.notifyAll();
			}
		
	}
	
	public void printMessage(String message, long timeStamp){
		System.out.println(message + " [" + timeStamp + "]");
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
