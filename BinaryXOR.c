/* Program to demonstrate time taken by function fun() */
#include <stdio.h> 
#include <time.h> 
#include <string.h>
#include <stdint.h>	/* for uint64 definition */
#include <stdlib.h>	/* for exit() definition */

#define BILLION 1000000000L

int main() 
{ 
	FILE *fp;
	fp = fopen ("exampleXORc.txt", "w+");
	
	char zero[] = "0";
	char one[] = "1";
	
	char s1[]="0110110111001100100001001010110100101101101011101110110101101101010101010110101101110100110101000010101001010011010110101010110100101001000100010101110111010100111101011011010101110010111101010001011010100101011010011100110000001100101110101010101010100111010101010110101110001001000101011101010110100001010111001011011100110010010010101011100010100010011110110100100101010101001010001101010011011011010101101010100010110101010001001010010001010010101111101010101011001110111010100010100110001001101110110110011001001000101110100110101101011110101110011101110101010101010001001101100101010110011010110101000001011110010110011001010101010011101010100011010100100110100010100111100100011001010110101100110100100010100101010100101101000010110001001010110110100101101110101010110111010100011011010001001100101010100101000010100101011010010010110111100011010101010100001011010011010000000110000100011001000100011010110110110101100101000101100010110101001001101010001010101001100000011110010101010101110100101010101001010011100100110010110001111010110011001010101";
	
	struct timespec start, end;
	int jump =0;
	uint64_t diff;

	clock_gettime(CLOCK_MONOTONIC, &start);	
	//create two halves
	char s2[strlen(s1)/2];
	memcpy (s2, s1+0, strlen(s1)/2);
	char s3[strlen(s1)/2];
	memcpy (s3, s1+strlen(s1)/2+1, strlen(s1));
	
	
	while (jump <=strlen(s2)){
	char s4[1];
	memcpy (s4, s2+jump, jump+1);
	char s5[1];
	memcpy (s5, s3+jump, jump+1);
	
	
		if ((strcmp(s4,zero) == 0) && (strcmp(s5,zero) == 0)) {
			fputs("0", fp);
		}
		else if ((strcmp(s4,one) == 0) && (strcmp(s5,one) == 0)) { 
			fputs("0", fp); 
		}
		else if ((strcmp(s4,one) == 0) && (strcmp(s5,zero) == 0)) {
			fputs("1", fp);
			
		}
		else if  ((strcmp(s4,zero) == 0) && (strcmp(s5,one) == 0)){
			fputs("1", fp);	
		}
		else {};
	
	jump = jump+1;
	
} // end of while
	clock_gettime(CLOCK_MONOTONIC, &end);	
	
	diff = BILLION * (end.tv_sec - start.tv_sec) + end.tv_nsec - start.tv_nsec;
	printf("elapsed time = %llu nanoseconds\n", (long long unsigned int) diff);
	printf("Length of bitstring : %d", strlen(s1)/2);
	fclose (fp);
    return 0; 
}