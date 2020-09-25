// 0925 day10 3교시 10분
package step2_01.array;

import java.util.Scanner;

/*
 * # 영화관 좌석예매
 * 1. 사용자로부터 좌석번호(index)를 입력받아 예매하는 시스템이다.
 * 2. 예매가 완료되면 해당 좌석 값을 1로 변경한다.
 * 3. 이미 예매가 완료된 좌석은 재구매할 수 없다.
 * 4. 한 좌석당 예매 가격은 12000원이다.
 * 5. 프로그램 종료 후, 해당 영화관의 총 매출액을 출력한다.
 * 예)
 * seat = [X] [X] [X] [X] [X] [X] [X]
 * 
 * 좌석선택 : 1
 * seat = [X] [O] [X] [X] [X] [X] [X]
 * 
 * 좌석선택 : 3
 * seat = [X] [O] [X] [O] [X] [X] [X]
 * 
 * 좌석선택 : 3
 * seat = [X] [O] [X] [O] [X] [X] [X]
 * ----------------------
 * 매출액 : 24000원
 */



public class ArrayEx09_정답 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		char seat[] = {'X','X','X','X','X','X','X'};
		// X가 예매 가능한 자리 O는 이미 예매된자리 
		
		int nCheck = 1;
		int choice = -1;
		int cnt = 0;
		
		for(int i = 0; i<seat.length; i++)
			System.out.print("["+ seat[i] + "] ");
		System.out.println();
		
		while(nCheck == 1) {
			
			System.out.print("\n좌석선택 : ");
			choice = scan.nextInt();
			if(seat[choice] == 'O') { // 이미 예매가 된자리면?
				System.out.println("이미 예매가 된 좌석입니다. ");
				nCheck = -1;
			} else {
				seat[choice] = 'O'; // 예매완료
				cnt++;
			}
			for(int i = 0; i<seat.length; i++)
				System.out.print("["+ seat[i] + "] ");
			System.out.println();
		}
		System.out.println("---------------------\n매출액 : "+ 12000*cnt + "원");
	}
	
}
