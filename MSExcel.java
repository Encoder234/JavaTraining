package module2.activity4;

//public class MSExcel implements Executable {
//
//	@Override
//	public void run() {
//		// TODO Auto-generated method stub
//		System.out.println("Opening MS Excel...");
//	}
//
//	@Override
//	public void stop() {
//		// TODO Auto-generated method stub
//		System.out.println("Stopping MS Excel...");
//	}
//
//	
//	
//}


public class MSExcel extends Program {
	
	public MSExcel(String name) {
//		<fill>
		super.setName(name);
	}
	
	@Override
	public void run() {
		String message = "Opening MS Excel...";
      //<fill>
		super.setRunning(true);
		
		System.out.println(message);
	}
	
	@Override
	public void stop() {
		String message = "Stopping MS Excel...";
    //  <fill>
		super.setRunning(false);
		System.out.println(message);
	}
}
