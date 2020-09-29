// 0928월 3교시 17:41-17:50 + 0929화 1교시 15:06-15:50 + 2교시 16:00-16:29
// 82분
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

public class ArrayEx17_정답 {
	
	static void printArray(int[] array) { // 오목판 프린트
//		  인덱스 : 승리하는 경우의 수 : 012/345/678 / 036/147/258 / 048/246
//		  [0][1][2]
//		  [3][4][5]
//		  [6][7][8]
		System.out.println("=== 틱택토게임중~ ===");
		for (int i = 0; i < 9; i++) {
			
			if(array[i] == 1) System.out.print("[O");
			else if(array[i] == 2) System.out.print("[X");
			else if(array[i] == 0) System.out.print("[ ");
			System.out.print("] ");
			
			if(i%3==2) 
				System.out.println();
		}
	}
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int[] game = new int[9]; // 배열안의 값에서 1P는 1 2P는 2 빈부분0 
		int turn = 1;
		int usrChoice;
		
		while(true) {
			
			printArray(game);
			// 선택하기
			System.out.print("[p"+turn+"] 인덱스 입력 : ");
			usrChoice = scan.nextInt();
		
			if(game[usrChoice] == 0) { 	// 아무도 선택하지 않은 빈 블럭을 선택했다면
				game[usrChoice] = turn; // 그사람이 선택했다고 표시
				if(turn == 1) 			// 1p였으면 2p로 순서 바꿔주기
					turn = 2;
				else 					// 2p였으면 1p로 순서 바꿔주기
					turn = 1;
			} else {
				System.out.println("이미 선택된 블럭입니다. 다시 고르세요.\n");
				continue; // 승리여부를 판단하기 전에 while문의 맨앞으로 이동
			}
/*
		// 승리한 인덱스조합을 %3 한 값 : 012/012/012 / 000/111/222 / 012/210
		
		// 기타 경우의 수 	%3이 0인 경우 : 036 
							%3이 1인 경우 : 147 
							%3이 2인 경우 : 258
		
		// 예를들어 %3해서 012값이 같은 경우 - 036중하나 147중하나 258중하나
		// 012 015 018 042 045 048 072 075 078  
		// 312 315 318 342 345 348 372 375 378  
		// 612 615 618 642 645 648 672 675 678  가 같으면 다 승리로 침(나머지로 판단하면)안됨
*/
			
			// 승리했는지 판별하기
			// 승리하는 경우의 인덱스. 밑의 세 인덱스가 같은 수이면 그 p가 승리  
			// 012/345/678 / 036/147/258 / 048/246
			if((game[0] == game[4] && game [0] == game[8] && game[0] != 0) // 048, 246, 345, 147
					|| (game[2] == game[4] && game [2] == game[6] && game[2] != 0)
					|| (game[3] == game[4] && game [3] == game[5] && game[3] != 0)
					|| (game[1] == game[4] && game [1] == game[7] && game[1] != 0)) {
				printArray(game);
				System.out.println("["+ game[4] + "p]가 승리하였습니다!!!!!!!!!!! ");
				break;				
			} 
			if((game[0] == game[1] && game [0] == game[2] && game[0] != 0) // 012, 036
					||(game[0] == game[3] && game [0] == game[6] && game[0] != 0)) {
				printArray(game);
				System.out.println("["+game[0] + "p]가 승리하였습니다!!!!!!!!!!! ");
				break;				
			}
			if((game[8] == game[7] && game [8] == game[6] && game[8] != 0) // 678, 258
					||(game[8] == game[2] && game [8] == game[5] && game[8] != 0)) {
				printArray(game);
				System.out.println("["+game[8] + "p]가 승리하였습니다!!!!!!!!!!! ");
				break;				
			}	
		}
		scan.close();
	}
}

/*
 * 
가로 for문 한개
 if ( 0 > 3개 ) 1p win
 if (1 > 3개 ) 2p win

세로 for문 한개
 1p,2p

대각선
 1p,2p

*/