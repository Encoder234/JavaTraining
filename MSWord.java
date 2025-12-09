package module2.activity5;


public class MSWord extends Program {
	
	public MSWord(String name) {
//		this.setName(name);
		super.setName(name);
	}
	
	@Override
	public void run() {
		System.out.println("Opening MS Word...");
		super.setRunning(true);
	}
	
	@Override
	public void stop() {
		System.out.println("Stopping MS Word...");
//      <fill>
		super.setRunning(false);
	}
}
