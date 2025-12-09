package module2.activity5;


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
