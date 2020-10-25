import java.io.FileWriter;
import java.io.IOException;

public class Baskets {

	public static void main(String[] args) throws IOException {
		
		// write file
				 FileWriter writer = new FileWriter("C:\\Users\\olivi\\Desktop\\FFHS\\11 Semester\\RNG\\Whitening\\basket.txt", true);
		
		// split length with comma delimiter into array
		String str = "148,136,272,160,154,254,177,182,226,193,206,202,211,238,184,226,283,153,242,318,121,259,346,100,275,371,86,292,402,76,310,423,65,460,424,65,476,417,72,492,406,82,509,378,96,526,340,121,543,301,142,559,249,166,575,203,187,592,130,219,761,168,219,776,203,202,793,273,167,809,325,142,825,381,107,843,423,79,859,448,62,942,431,65,959,417,75,975,371,114,991,284,173,009,238,205,026,200,226,042,158,254";
	      String pixel[] = str.split(",");
	      for(String token : pixel) {
	         System.out.println(token);
	}
	      // prepare baskets
	      int[] intArray = new int[360000]; 
	      int jump;
	      
	      // for loop to go populating baskets by 1
	      for (int i=0; i<=pixel.length-1; i++) {
	    	  jump= Integer.parseInt(pixel[i]);
	    	  
	    	  intArray[jump]++;
	    	 
	      }
	      
	      // print out array
	      for (int i=0; i<=360000-1; i++) {
	    	  //System.out.print(intArray[i]);
	    	  writer.write(String.valueOf(intArray[i]));
	    	  writer.write("");
	    	  
	      }
	      writer.close();

} // end of main
	
}
