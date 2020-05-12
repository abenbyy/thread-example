import java.util.Scanner;
import java.util.Vector;

public class Main {
	Scanner scan = new Scanner(System.in);
	
	Vector<Parcel> parcels = new Vector<Parcel>();
	
	public void deliverParcel() {
		String name;
		String courier;
		int time = 0;
		
		//Validate input must be 2 words
		do {
			System.out.print("Input parcel name: ");
			name = scan.nextLine();
			name = name.trim();
			if(name.contains(" ")) {
				break;
			}
		}while(true);
		
		//Validate input must be JNE or Tiki
		do {
			System.out.print("Input courier [JNE|Tiki]:");
			courier = scan.nextLine();
			if(courier.equals("JNE") || courier.equals("Tiki")) break;
			
		}while(true);
		
		if(courier.equals("JNE")) time = 15;
		else if(courier.equals("Tiki")) time = 5;
		
		Parcel p = new Parcel(name, courier, time);
		
		Thread thread = new Thread(p);
		
		thread.start();
		parcels.add(p);
		
	}
	public void viewParcel() {
		System.out.println();
		for (Parcel parcel : parcels) {
			System.out.println(parcel.name+" "+parcel.time+" "+parcel.status);
		}
		System.out.println();
	}
	
	
	public Main() {
		int inp = -1;
		do {
			System.out.println("1. Deliver Parcel");
			System.out.println("2. View Parcels");
			System.out.print(">>");
			inp = scan.nextInt();
			scan.nextLine();
			
			switch (inp) {
			case 1:
				deliverParcel();
				break;
			case 2:
				viewParcel();
				break;
			default:
				break;
			}
		}while(true);
		
	}

	public static void main(String[] args) {
		
		new Main();
	}

}
