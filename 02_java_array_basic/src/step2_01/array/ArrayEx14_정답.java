//0928월 16:05-16:20
package step2_01.array;

import java.util.Scanner;

/*
 * # 숫자이동[1단계]
 * 1. 숫자2는 캐릭터이다.
 * 2. 숫자1을 입력하면, 캐릭터가 왼쪽으로
 * 	    숫자2를 입력하면, 캐릭터가 오른쪽으로 이동한다.
 * 3. 단, 좌우 끝에 도달했을 때, 예외처리를 해야한다.
 */

public class ArrayEx14_정답 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int[] game = {0, 0, 2, 0, 0, 0, 0};
		int player = 0; // 플레이어의 위치 인덱스
		int getMove;
		
		for(int i=0; i<7; i++) {
			if(game[i] == 2) {
				player = i; // 플레이어의 위치찾기
			}
		}
		
		while(true) {
			// 게임시작!
			for (int i = 0; i < game.length; i++) {
				System.out.print(game[i] + " ");
			}
			
			System.out.print("\n숫자1을 입력하면 캐릭터가 왼쪽으로, 숫자 2를 입력하면 캐릭터가 오른쪽으로 이동합니다. \n숫자를 입력하세요: ");
			getMove = scan.nextInt();
			
			if(getMove == 1) {				// 왼쪽으로 움직인다. 
				game[player] = 0;
				if(player == 0) {
					System.out.println("캐릭터가 맨 왼쪽에 있어 더이상 움직일 수 없어요!");
					break;
				} else {
					game[--player] = 2;
				}
			} else if( getMove == 2) {		// 오른쪽으로 움직인다. 
				game[player] = 0;
				if(player == game.length-1) {
					System.out.println("캐릭터가 맨 오른쪽에 있어 더이상 움직일 수 없어요!");
					break;
				} else {
					game[++player] = 2;
				}
				
			} else {
				System.out.println("1과 2 중에 입력하세요!");
				break;
			}
		}
	}
}
