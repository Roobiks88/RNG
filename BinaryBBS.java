import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BinaryBBS {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		// write file
		 FileWriter writer = new FileWriter("C:\\Users\\olivi\\Desktop\\FFHS\\11 Semester\\RNG\\Whitening\\randomorgBBS.txt", true);
		 FileWriter writer2 = new FileWriter("C:\\Users\\olivi\\Desktop\\FFHS\\11 Semester\\RNG\\Whitening\\seedsBBS.txt", true);
		 // what bit sequence length
		 Scanner scan = new Scanner(System.in);
		 System.out.print("Enter the length of the bit sequence: ");
		 int length = scan.nextInt();
		 scan.close();
		 //p and q prime numbers
		 int p= 383;
		 int q= 503;
		 long M = p*q;
		 // seed
		 long seed = 101355;
		 // least significant bit
		 long lb;
		 
		 long start2 = System.nanoTime();
		 // modulo
		 // least significant bit
		 for(int i =0; i<length; i++) {
			 writer2.write(String.valueOf(seed)); 
			 writer2.write("\n"); 
			 lb = ((seed*seed)%M)%2;
			 writer.write(String.valueOf(lb)); 
			 seed=(seed*seed)%M;
		 } // end of for
		 long end2 = System.nanoTime();
		 long nanoseconds = (end2 - start2);
		System.out.println("Elapsed time in nanoseconds : "+ nanoseconds +" ns");
		System.out.println("Length of bitstring : " + length);
		 writer.close(); 
		 writer2.close(); 
	}

}
