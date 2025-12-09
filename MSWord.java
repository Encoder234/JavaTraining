package module2.activity4;

//public class MSWord implements Executable{
//
//	@Override
//	public void run() {
//		// TODO Auto-generated method stub
//		System.out.println("Opening MS Word...");
//	}
//
//	@Override
//	public void stop() {
//		// TODO Auto-generated method stub
//		System.out.println("Stopping MS Word...");
//	}
//
//}


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
