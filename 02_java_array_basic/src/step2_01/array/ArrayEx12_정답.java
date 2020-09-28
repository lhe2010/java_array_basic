// 0928월 3:42-3:50
package step2_01.array;

import java.util.Scanner;

/*
 * # 값 교체하기[2단계] 
 */

public class ArrayEx12_정답 {

	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);
		
		int[] arr = {10,20,30,40,50};
		int getIndex1 , getIndex2;
		int getValue1 , getValue2;
		int temp = 0;
		
		// 문제 1) 인덱스 2개를 입력받아 값 교체하기
		// 예    1) 인덱스1 입력 : 1
		//		   인덱스2 입력 : 3
		//		  {10, 40, 30, 20, 50}
		
		System.out.print("인덱스1 입력 : ");
		getIndex1 = scan.nextInt();
		System.out.print("인덱스2 입력 : ");
		getIndex2 = scan.nextInt();
		
		temp = arr[getIndex1];
		arr[getIndex1] = arr[getIndex2];
		arr[getIndex2] = temp;
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
		// 문제 2) 값 2개를 입력받아 값 교체하기
		// 예    2) 값1 입력 : 40
		//        값2 입력 : 20
		//		  {10, 20, 30, 40, 50}
		
		System.out.print("\n값1 입력 : ");
		getValue1 = scan.nextInt();
		System.out.print("값2 입력 : ");
		getValue2 = scan.nextInt();
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == getValue1)
				getIndex1 = i;
			if(arr[i] == getValue2)
				getIndex2 = i;
		}
		temp = arr[getIndex1];
		arr[getIndex1] = arr[getIndex2];
		arr[getIndex2] = temp;
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();		
		
		// 문제 3) 학번 2개를 입력받아 성적 교체하기
		// 예    3) 학번1 입력 : 1002
		//        학번2 입력 : 1003
		//		 {87, 45, 11, 98, 23}
		
		int[] hakbuns = {1001, 1002, 1003, 1004, 1005};
		int[] scores  = {  87,   11,   45,   98,   23};
		
		System.out.print("\n학번1 입력 : ");
		getValue1 = scan.nextInt();
		System.out.print("학번2 입력 : ");
		getValue2 = scan.nextInt();
		
		for (int i = 0; i < hakbuns.length; i++) {
			if(hakbuns[i] == getValue1)
				getIndex1 = i;
			if(hakbuns[i] == getValue2)
				getIndex2 = i;
		}
		temp = scores[getIndex1];
		scores[getIndex1] = scores[getIndex2];
		scores[getIndex2] = temp;
		
		for (int i = 0; i < hakbuns.length; i++) {
			System.out.print(hakbuns[i] + " ");
		}
		System.out.println();		
		for (int i = 0; i < scores.length; i++) {
			System.out.print(scores[i] + " ");
		}
		System.out.println();		
	}
	
}
