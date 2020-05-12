
public class Parcel implements Runnable{
	
	String name;
	String courier;
	int time;
	String status;
	
	
	public Parcel(String name, String courier, int time) {
		super();
		this.name = name;
		this.courier = courier;
		this.time = time;
		this.status = "delivering.....";
	}

	@Override
	public void run() {
		while(true) {
			if(time > 0) {
				time--;
			}else {
				status = "DONE!";
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
