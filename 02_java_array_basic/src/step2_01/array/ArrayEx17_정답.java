// 0928월 3교시 17:41-
package step2_01.array;

import java.util.Scanner;

/* 
 * # 틱택토
 * 
 * 1. 구글에 검색해보면 실제로 게임을 진행해볼 수 있음
 * 2. 미니 오목처럼 1p 혹은 2p가 먼저 가로로 3줄 , 세로로 3줄, 대각선 3줄을 선택한 플레이어가 승리하는 게임
 * 3. 1p가 입력한 부분은 화면에 O표시 , 2p가 입력한 부분은 화면에 X표시
 * 
 * === 틱택토 ===
 * [X][X][O]
 * [ ][O][ ]
 * [ ][ ][ ]
 * [p1]인덱스 입력 : 6
 * === 틱택토 ===
 * [X][X][O]
 * [ ][O][ ]
 * [O][ ][ ]
 * [p1]승리
 * 
 */
/*
 * 인덱스
 * [0][1][2]
 * [3][4][5]
 * [6][7][8]
 */

public class ArrayEx17_정답 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int[] game = new int[9]; // 1P는 1 2P는 2 빈부분0 
		int turn = 1;
		int usrChoice;
		
		while(true) {
			System.out.print("[p"+turn+"] 인덱스 입력 : ");
		
		usrChoice = scan.nextInt();
		
		if(turn == 1 && game[usrChoice] == 1)
			System.out.println("이미 선택한 블럭입니다.");
		}
		
	}
		
}
