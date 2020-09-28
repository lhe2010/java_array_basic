// 0928월 16:22-16:43
package step2_01.array;

import java.util.Random;
import java.util.Scanner;

/*
 * # 기억력 게임
 * 1. 같은 숫자의 위치를 2개 입력해 정답을 맞추는 게임이다.
 * 2. 정답을 맞추면 back에 해당 숫자를 저장해,
 *    back에 모든 수가 채워지면 게임은 종료된다.
 * 예)
 * front = [5, 4, 1, 3, 1, 2, 4, 2, 3, 5]
 * back  = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
 * 입력1 : 2
 * 입력2 : 4
 * 
 * front = [5, 4, 1, 3, 1, 2, 4, 2, 3, 5]
 * back  = [0, 0, 1, 0, 1, 0, 0, 0, 0, 0]
 * 
 * 입력1 : 5
 * 입력2 : 7
 * 
 * front = [5, 4, 1, 3, 1, 2, 4, 2, 3, 5]
 * back  = [0, 0, 1, 0, 1, 2, 0, 2, 0, 0]
 * 
 */

public class ArrayEx15_정답 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();
		
		int[] front = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5}; // front의 idx : 0-9
		int[] back = new int[10];
		int temp = 0;
		int tempRan = 0;
		int cnt  = 0;
		int inputIdx1, inputIdx2;
		int gameIdx = 1;
		
		// 셔플 구현(Shuffle) : 배열의 요소들을 무작위로 섞음
		while (cnt < 1000) {			
			tempRan = ran.nextInt(9); // 0-8중에 랜덤숫자를 뽑아 tempRan에 저장
			
			// tempRan이랑 front[0]의 값을 바꾼다. 
			temp = front[0]; 
			front[0] = front[tempRan];
			front[tempRan] = temp;
			
			cnt++;
		}
			
		// 게임시작
		while(gameIdx == 1) { 
			System.out.println("front");
			for (int i = 0; i < front.length; i++) {
				System.out.print(front[i] + " ");
			}
			System.out.println("\nback");
			for (int i = 0; i < back.length; i++) {
				System.out.print(back[i] + " ");
			}
			
			System.out.print("\n입력1: ");
			inputIdx1 = scan.nextInt();
			System.out.print("입력2: ");
			inputIdx2 = scan.nextInt();
			
			if(front[inputIdx1] == front[inputIdx2]) { // 같은 숫자의 위치가 정답인경우
				// back에 해당 숫자를 저장한다. 
				back[inputIdx1] = front[inputIdx1];
				back[inputIdx2] = front[inputIdx1];
				System.out.println("===== 정답! =====\n");
			} else { // 입력한 수가 정답이 아닌경우 -> 다시 입력받아야함
				System.out.println("===== 땡! =====\n");
				continue;
			}
			
			cnt = 0; // cnt 재사용
			for (int i = 0; i < front.length; i++) {
				if(front[i] == back[i]) cnt++;
				if(cnt ==front.length) {// 아예 똑같으면 게임중단
					gameIdx = -1;
					System.out.println("===== 게임종료합니다. =====");
				}
			}
		}
	}
}
