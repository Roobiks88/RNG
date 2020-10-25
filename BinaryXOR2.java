import java.io.FileWriter;
import java.io.IOException;

public class BinaryXOR2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		// write file
		FileWriter writer = new FileWriter("C:\\Users\\olivi\\Desktop\\FFHS\\11 Semester\\RNG\\Whitening\\randomorgXOR2.txt", true);
		
		String s2 = "0110110111001100100001001010110100";
		String s3 = "0111011101101011011010101010101101";
		
		// combine
		int jump = 0;

		long start2 = System.nanoTime();

		while(jump < s2.length()) {
		String s4 = s2.substring(0+jump,1+jump);
		String s5= s3.substring(0+jump,1+jump);
	
		if ((s4.equals("0")) && (s5.equals("0"))) {
			writer.write("0"); 
		}
		else if ((s4.equals("1")) && (s5.equals("1"))) { 
			writer.write("0"); 
		}
		else if ((s4.equals("1")) && (s5.equals("0"))) {
			writer.write("1"); 
			
		}
		else if  ((s4.equals("0")) && (s5.equals("1"))){
			writer.write("1"); 		
		}
		else {};
			jump = jump+1;
		}
		long end2 = System.nanoTime();
		long nanoseconds = (end2 - start2);
		System.out.println("Elapsed time in nanoseconds : "+ nanoseconds +" ns");
		System.out.println("Length of bitstring : " + s2.length());
		writer.close();
		
	}

}
