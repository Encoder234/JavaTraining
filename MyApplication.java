package module2.activity4;

//public class MyApplication {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		
//		Executable excel = new MSExcel();
//		Executable word = new MSWord();
//		
//		runProgram(excel);
//		runProgram(word);
//		
//		stopProgram(excel);
//		stopProgram(word);	
//	}
//	
//	private static void runProgram(Executable executableProgram) {
//		executableProgram.run();
//	}
//	
//	private static void stopProgram(Executable executableProgram) {
//		executableProgram.stop();
//	}
//
//}



public class MyApplication {

	public static void main(String[] args) {
		Program excel = new MSExcel("MS Excel");
		Program word = new MSWord("MS Word");
		
		runProgram(excel);
		runProgram(word);
		
		checkProgramStatus(excel);
		checkProgramStatus(word);
		
		stopProgram(excel);
		stopProgram(word);
		
		checkProgramStatus(excel);
		checkProgramStatus(word);
		
	}
	
	private static void runProgram(Program executableProgram) {
		
		executableProgram.run();
		
	}
	
	private static void stopProgram(Program executableProgram) {
		
		executableProgram.stop();
	}
	
	private static void checkProgramStatus(Program executableProgram) {
		
		if(executableProgram.getIsRunning() ) {
			
			System.out.println("Program " + executableProgram.getName() + " is running. ");
			
		} else {
			
			System.out.println("Program " + executableProgram.getName() + " is stopped. ");
		}
		
	}


}