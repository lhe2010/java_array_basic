// 0928월 16:43-16:50, 17:03-17:40
package step2_01.array;

import java.util.Random;
import java.util.Scanner;

/*
 * # 1 to 50[1단계] : 1 to 4
 * 1. arr배열에 1~4 사이의 숫자를 중복없이 저장한다.
 * 2. 사용자는 가장 작은수 1부터(다음은 2) 순서대로 해당 위치 값을 입력한다.
 * 3. 정답을 맞추면 해당 값은 9로 변경되어 모든 값이 9가 되면 게임은 종료된다.
 
 * 예)
 * [ 4 2 3 1 ]
 * 
 * 입력 : 3  (가장 작은수 1이 3번째에 위치 )
 * 4 2 3 9
 * 입력 : 1  ( 그 다음으로 작은 수 2가 1번째에 위치 )
 * 4 9 3 9
 * 입력 : 2  ( 그 다음으로 작은 수 3이 2번째에 위치 )
 * 4 9 9 9
 * 입력 : 0  ( 그 다음으로 작은 수 4가 0번째에 위치 )
 * 9 9 9 9
 * 
 * 코드 종료
 */


public class ArrayEx16_정답 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();
		
		int[] arr = new int[4];
		int[] check = { 0,0,0,0};
		
		int nRan;
		int i = 0;
		// *****중복되지 않게 한다. 11번 연습문제 응용이니 참고!!!!
		while(i<4) {
			nRan = ran.nextInt(4); // 0,1,2,3
			if(check[nRan] == 0) { // 아직 사용되지 않은 수일경우 
				arr[i] = nRan+1; // 1,2,3,4
				check[nRan] = 1;
				i++;
			}
		}
		
		System.out.print("게임전 arr : ");
		for (int j = 0; j < arr.length; j++) {
			System.out.print(arr[j] + " ");
		}
		System.out.print("\n게임전 check : ");
		for (int j = 0; j < arr.length; j++) {
			System.out.print(check[j] + " ");
		}
		System.out.println();
		
		// 게임 시작
		int cnt = 0;
		int usrNum = 0;
		while (cnt < 4) {
			System.out.print("[ ");
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[j] + " ");
			}
			System.out.println("]");
			
			System.out.print("입력: ");
			usrNum = scan.nextInt();
			
			if(arr[usrNum] == cnt+1) { // 현재 수에서 가장 작은 수를 맞춘경우 
				arr[usrNum] = 9;
				cnt++;
			} else if(arr[usrNum] == 9) { // 이미 맞춘 위치면
				System.out.println("땡! 이미 맞춘 위치입니다. 다른 수를 입력하세요.");
			} else {	// 틀린경우
				System.out.println("땡!!!");
			}
		}
		System.out.println("===== 게임 종료 =====");
	}
}

