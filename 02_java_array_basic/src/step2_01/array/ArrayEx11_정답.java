// 0928월 1교시 3:27-3:41
// 처음에 문제를 이해못해서 오래걸림. 
package step2_01.array;

import java.util.Random;

/* 힌트. for 5번, 
 * # 중복숫자 금지[1단계]
 * 1. 0~4 사이의 숫자를 arr배열에 저장한다.
 * 2. 단, 중복되는 숫자는 없어야 한다.
 * 힌트) 랜덤 숫자를 check배열의 인덱스로 활용한다.
 * 
 * 예)
 * 랜덤숫자 : 1
 * check = {0, 1, 0, 0, 0}
 * arr   = {1, 0, 0, 0, 0}
 * 랜덤숫자 : 3
 * check = {0, 1, 0, 1, 0}
 * arr   = {1, 3, 0, 0, 0}
 * 랜덤숫자 : 2
 * check = {0, 1, 1, 1, 0}
 * arr   = {1, 3, 2, 0, 0}
 */

public class ArrayEx11_정답 {

	public static void main(String[] args) {
	
		Random ran  = new Random(); 
		
		int[] check = new int[5];
		int[] arr   = new int[5];
		int nRand = -1;
		
		for(int i = 0; i < arr.length; i++) {
			
			do{
				nRand = ran.nextInt(5); // 5미만 랜덤숫자 뽑기
			} while (check[nRand] == 1); // nRand가 이미나온숫자일때까지 랜덤 돌린다. while조건: nRand가 이미나온숫자
			// 이제 check[nRand]가 1이 아니면 즉, 처음나온숫자가 드디어 뽑혓다면 루프나와서 진행
			
			check[nRand] = 1; 
			arr[i] = nRand;
		}
		
		// arr과 check 배열을 프린트해서 확인하기
		System.out.println("check");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(check[i] + " ");
		}
		System.out.println("\narr");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
					
	}
	
}
