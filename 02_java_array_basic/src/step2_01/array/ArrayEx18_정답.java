// 0929화요일 2-3교시 16:30-16:50 + 17:00-17:30 = 총 50분
package step2_01.array;

import java.util.Arrays;
import java.util.Scanner;

/*
 * # 미니마블
 * 1. 플레이어는 p1과 p2 2명이다.
 * 2. 번갈아가며 1~3 사이의 숫자를 입력해 이동한다.
 * 3. 이동하다가 다음 플레이어와 같은 위치에 놓이게 되면,
 *    상대 플레이어는 잡히게 되어 원점으로 되돌아간다.
 * 4. 먼저 3바퀴를 돌면 이긴다.
 *    
 *  1 2 3 4 5 6 7 8  
 *  1 0 0 0 0 0 0 0  [0바퀴]
 *  2 0 0 0 0 0 0 0  [0바퀴]
 *  [p1사용자]1~3 입력 : 3 
 *
 *  1 2 3 4 5 6 7 8  
 *  0 0 0 1 0 0 0 0  [0바퀴]
 *  2 0 0 0 0 0 0 0  [0바퀴]
 *  [p2컴퓨터] : 3
 *  [p2컴퓨터]가 p1을 잡았다! 
 *  
 *  1 2 3 4 5 6 7 8 
 *  1 0 0 0 0 0 0 0  [0바퀴]
 *  0 0 0 2 0 0 0 0  [0바퀴]
 * [p1사용자]1~3 입력 : 
 */

// 따라잡았다면 상대turn 말을 원점으로 이동 
public class ArrayEx18_정답 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int[] game = {1, 2, 3, 4, 5, 6, 7, 8};
//		int[] game = {0, 1, 2, 3, 4, 5, 6, 7}; // 인덱스 헷갈려서 일단은
		int[] p1   = {0, 0, 0, 0, 0, 0, 0, 0};
		int[] p2   = {0, 0, 0, 0, 0, 0, 0, 0};
		
		int turn = 1; // turn 이 1이면 p1, 2면 p2의 차례
		int move;

		// 각각 말의 초기 위치 설정
		int idx1 = 0;	
		int idx2 = 0; 
		
		// 각각 말의 위치에 놓기
		p1[idx1] = 1;	
		p2[idx2] = 2; 
		
		// 각자 이긴 바퀴수
		int win1 = 0;	
		int win2 = 0;	
		
		System.out.println("친구와 함께하는 미니마블!");
		
		do {
			// 프린트하기
			System.out.println(Arrays.toString(game));
			System.out.println(Arrays.toString(p1) + "["+win1+"바퀴]");
			System.out.println(Arrays.toString(p2) + "["+win2+"바퀴]");
			
			// 몇칸을 이동할까요? 입력받기
			System.out.print("[p" + turn + "] 1~3 입력 : ");
			move = scan.nextInt();
			
			if(move > 3 || move <= 0) {
				System.out.println("1~3 사이의 값만 입력하십시오!\n");
				continue;
			} 
			System.out.println();
			
			// 일단 이동시키기
			if(turn == 1) { // 1의 말이이동하는데 따라잡지 않으면 (이동만)
				p1[idx1] = 0; 			// 원래 말 위치에 0으로 값바꾸고 
				idx1 += move;			// 말 이동
				if(idx1/8 >= 1) {// %8해서 한바퀴돌면 win1++시키고 (인덱스 0-7주의)
					win1++;	
					if(win1 == 3) break;
				}
				idx1 = idx1%8;
				p1[idx1] = 1; 		// 말 이동해서 찍어주기
				
				turn = 2; 				// 순서교체
				
				if(idx1 == idx2) { // 1p가 2p를 따라잡은경우 - 2p의 말을 원점으로 
					p2[idx2] = 0;
					idx2 = 0;
					p2[idx2] = 2;
					System.out.println("p1이 p2를 따라잡음!");
					continue;
				}
				
			} else if(turn == 2) {
				p2[idx2] = 0;
				idx2 += move; 			// 말이동
				if(idx2/8 >= 1) {
					win2++;
					if(win2 == 3) break;
				}
				idx2 = idx2%8;
				p2[idx2] = 2;
				
				turn = 1;				// 순서교체
				
				if(idx1 == idx2) { // 2p가 1p를 따라잡은경우 - 1p의 말을 원점으로 
					p1[idx1] = 0;
					idx1 = 0;
					p1[idx1] = 1;
					System.out.println("p2가 p1를 따라잡음!");
					continue;
				}
				
			}
			

		} while(win1 < 3 || win2 < 3);
		
		if(win1 ==3) 
			System.out.println("[p1]의 승리입니다!");
		else if(win2 == 3)
			System.out.println("[p2]의 승리입니다!");
		else 
			System.out.print("비정상적인 ");
			
		System.out.println(" 게임종료!!!\n");
		scan.close();
	}
}
