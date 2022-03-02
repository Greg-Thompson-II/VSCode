// CMPS390
// ArrayPointer.c
// C Arrays and Pointers
#include <stdio.h>
// a: array pointer, m: # of rows, n: # of columns
void printMatrixRowMajor(int *a, int m, int n) {					//Thompson
// ADD YOUR CODE HERE
	printf("Array in Row Major format: \n");
	
	for (m = 0; m < 3; m++){							//Traverses array by row
		for (n = 0; n < 4; n++){						//Traverses row by column
			printf("%d ", *(a + (m*4)+n));				//Prints row column by column
		}
		printf("\n");									//Print new line after each row is done printing
	}	
	printf("\n");										//Printing new line after displaying array
}
// a: array pointer, m: # of rows, n: # of columns
void printMatrixColMajor(int *a, int m, int n) {					//Thompson
// ADD YOUR CODE HERE
	printf("Array in Column Major format: \n");

	for (n=0; n<4; n++){								//Traverses array by column
		for(m=0; m<3; m++){								//Traverses column by row
			printf("%d ", *(a + (m*4)));				//Prints column row by row
		}
		a++;
		printf("\n");
	}
	printf("\n");										//Printing new line after displaying array
}
main( ) {															//Thompson
// ADD YOUR CODE HERE
	int m, n;
	int array[3][4], *a;								//Initializing array
	
	a = &(array[0][0]);									//A points to the contents of the array
	
	for (m=0; m<3; m++){								//m is the number of rows
		for (n=0; n<4; n++){							//n is the number of columns
			array[m][n] = (m*4)+n;						//Fills each row column by column
		}
	}
	
	a = &(array[0][0]);
	
	printMatrixRowMajor(&(array[0][0]), 0, 0); 			//Prints each row in a column by column fashion
	printMatrixColMajor(&(array[0][0]), 0, 0);			//Prints each column in a row by row fashion
							//End of Program
}