package leetode50;

import java.util.LinkedList;
import java.util.List;

/*
Given a matrix of m ✕n elements (m rows, n columns), return all elements of the matrix in spiral order.
For example, given the following matrix:
[
  [ 1, 2, 3 ],
  [ 4, 5, 6 ],
  [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].
 */
public class SpiralMatrix {
	
	public List<Integer> printSpiralMatrix(int[][] ar){
		int m = ar.length;
		int n = ar[0].length;
		List<Integer> list = new LinkedList<Integer>();
		if(m==0 || n==0) return list;
		//System.out.println("row m="+m+" col n="+n);
		int row=0,col=0;
		while(true){//m >= 1 && n >= 1){ //--works both ways cos actual checks are don inside for m & n
			for(int i= 0; i<n; i++){
				
				list.add(ar[row][col++]);
			}
			m--;
			row++;
			col--;
			if(m<=0) break; //if no more row is left, break printing
			for(int i= 0; i<m; i++){
				
				list.add(ar[row++][col]);
			}
			n--;
			col--;
			row--;
			if(n<=0) break; //if no more column is left, break printing
			for(int i= 0; i<n; i++){
				
				list.add(ar[row][col--]);
			}
			m--;
			row--;
			col++;
			if(m<=0) break; //if no more row is left, break printing
			for(int i= 0; i<m; i++){
				
				list.add(ar[row--][col]);
			}
			n--;
			row++;
			col++;
			if(n<=0) break;//if no more column is left, break printing
					
		}
		return list;
	}
	
	public static void main(String ar[]){
		int[][] arr = {{1,2,3,4,33},{5,6,7,8,44},{9,10,11,12,55}};
		//int[][] arr = {{1}};
		SpiralMatrix sm = new SpiralMatrix();
		List<Integer> list = sm.printSpiralMatrix(arr);
		for(Integer x : list){
			System.out.print(x+"->");
		}
	}

}
