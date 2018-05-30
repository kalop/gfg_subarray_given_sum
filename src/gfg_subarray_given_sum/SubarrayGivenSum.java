package gfg_subarray_given_sum;

import java.util.Scanner;

/*
 * Given an unsorted array of non-negative integers, find a continuous sub-array which adds to a given number.

Input:

The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. 
Each test case consists of two lines. The first line of each test case is N and S, where N is the size of 
array and S is the sum. The second line of each test case contains N space separated integers denoting the 
array elements.

Output:

Corresponding to each test case, in a new line, print the starting and ending positions of first such occuring 
subarray if sum equals to subarray, else print -1.

Note: Position of 1st element of the array should be considered as 1.

Expected Time Complexity: O(n)

Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 100
1 ≤ an array element ≤ 200

Example:

Input:
2
5 12
1 2 3 7 5
10 15
1 2 3 4 5 6 7 8 9 10

Output:
2 4
1 5

in:

1
42 468
135 101 170 125 79 159 163 65 106 146 82 28 162 92 196 143 28 37 192 5 103 154 93 183 22 117 119 96 48 127 172 139 70 113 68 100 36 95 104 12 123 134

out:
38 42

in:
1
74 665
142 112 54 69 148 45 63 158 38 60 124 142 130 179 117 36 191 43 89 107 41 143 65 49 47 6 91 130 171 151 7 102 194 149 30 24 85 155 157 41 167 177 132 109 145 40 27 124 138 139 119 83 130 142 34 116 40 59 105 131 178 107 74 187 22 146 125 73 71 30 178 174 98 113

out: 
-1

Explanation : 
In first test case, sum of elements from 2nd position to 4th position is 12
In second test case, sum of elements from 1st position to 5th position is 15


 */

public class SubarrayGivenSum {

	public static void main(String[] args) {
		
		int[] arr = new int[100];
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
			int n = sc.nextInt();
			int sumResult = sc.nextInt();
			
			int sum = 0;
			int leftIndex = 0;
			int rightIndex = 0;
	
			for(int i=0; i<n; i++) {
				arr[i] = sc.nextInt();
			}
			
			for(int i=0; i<n; i++) {		
				sum += arr[i];		
				if(sum == sumResult) {
					rightIndex = i+1;
					System.out.println(leftIndex+1 + " " + rightIndex);
					break;
				}else if (sum > sumResult) {					
					while(sum > sumResult) {
						sum -= arr[leftIndex];
						leftIndex++;
					}					
					if(sum == sumResult) {
						rightIndex = i+1;
						System.out.println(leftIndex+1 + " " + rightIndex);
						break;						
					}					
				} 
				if(i==n-1) {
					System.out.println("-1");
				}
				
			}
			
			t--;
		}
	}

}
