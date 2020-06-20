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
		
	}
}
