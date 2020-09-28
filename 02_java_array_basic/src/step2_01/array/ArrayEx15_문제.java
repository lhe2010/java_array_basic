package step2_01.array;

import java.util.Random;
import java.util.Scanner;

/*
 * # 기억력 게임
 * 1. 같은 숫자의 위치를 2개 입력해 정답을 맞추는 게임이다.
 * 2. 정답을 맞추면 back에 해당 숫자를 저장해,
 *    back에 모든 수가 채워지면 게임은 종료된다.
 * 예)
 * front = [1, 1, 2, 2, 3, 3, 4, 4, 5, 5]
 * back  = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
 * 입력1 : 0
 * 입력2 : 1
 * 
 * front = [1, 1, 2, 2, 3, 3, 4, 4, 5, 5]
 * back  = [1, 1, 0, 0, 0, 0, 0, 0, 0, 0]
 */

public class ArrayEx15_문제 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();
		
		int[] front = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
		int[] back = new int[10];
		int temp = 0;
		int tempRan = 0;
		int cnt  = 0;
		
		// 셔플 구현(Shuffle)
		while (cnt < 1000) {			
			tempRan = ran.nextInt(9);
			temp = front[0]; 
			front[0] = front[tempRan];
			front[tempRan] = temp;
			cnt++;
		}
			
		for(int j=0; j<10; j++) {
			System.out.print(front[j] + " ");
		}
		System.out.println();
			
			
	}
	
}
