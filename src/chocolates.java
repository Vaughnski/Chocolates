public class chocolates {

public static void main(String[] args) {
int [][] myArray = {
{0,0,0,0,0,0,0},
{0,6,8,9,7,4,0},
{0,0,0,8,0,5,0},
{0,5,7,4,5,10,0},
{0,4,2,0,6,9,0},
{0,0,0,0,0,0,0},
};

int count = countChocolates(myArray);
System.out.println("The child will eat " + count + " chocolates");

}

public static int countChocolates(int[][] arr)
{
boolean gameOver = false;

int max;
int maxR = 0, maxC = 0;
	
int rowL = arr.length;
int columnsL = arr[0].length;

int rCenter = rowL/2, cCenter = columnsL/2;
int count = 0;

//if no center
if(!(rowL % 2 == 1 && columnsL % 2 == 1))
{

	for(int a = rCenter-1; a <= rCenter+1; a++)
		for(int b = cCenter-1; b <= cCenter+1; b++)
{
			if(a >=0 && b >= 0 && a < rowL && b < columnsL)
{
				if(arr[a][b] > arr[rCenter][cCenter])
{

					rCenter = a;
					cCenter = b;
}
}
}
}


while(!gameOver)
{
count += arr[rCenter][cCenter];

arr[rCenter][cCenter] = 0;

//find the next location to move
max = 0;

//check left
if(cCenter >= 1 && arr[rCenter][cCenter-1] > max) 
{
maxR = rCenter;
maxC = cCenter-1;
max = arr[maxR][maxC];
}

//check right
if(cCenter < columnsL-1 && arr[rCenter][cCenter+1] > max) 
{
maxR = rCenter;
maxC = cCenter+1;
max = arr[maxR][maxC];
}

//check above
if(rCenter >= 1 && arr[rCenter-1][cCenter] > max) 
{
maxR = rCenter-1;
maxC = cCenter;
max = arr[maxR][maxC];
}

//check below
if(rCenter < rowL-1 && arr[rCenter+1][cCenter] > max) 
{
maxR = rCenter+1;
maxC = cCenter;
max = arr[maxR][maxC];
}

//gameOver bc no more chocolates
if(max == 0) 
gameOver = true;
else
{
rCenter = maxR;
cCenter = maxC;
}

}

return count;


}
}