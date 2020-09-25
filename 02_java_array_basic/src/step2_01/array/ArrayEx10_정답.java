package step2_01.array;

import java.util.Scanner;

/*
 * # 즉석복권
 * 1. 숫자 7이 '연속으로' 3번 등장하면, 당첨복권이다.
 * 2. 메뉴를 선택해서 1번 2번 3번이 당첨인지 확인한다.
 * 3. 0번은 반복문을 종료한다.
 * 
 */


public class ArrayEx10_정답 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int[] lotto1 = {0, 0, 7, 7, 7, 0, 0, 0};
		int[] lotto2 = {7, 0, 7, 7, 0, 0, 0, 0};
		int[] lotto3 = {7, 0, 7, 7, 7, 0, 7, 0};
		int sel      = 1;
		int cnt = 0;
		int[] checkLotto = null;
		
		while (sel != 0) {
					
			System.out.println("\n[1]번복권 결과확인");
			System.out.println("[2]번복권 결과확인");
			System.out.println("[3]번복권 결과확인");
			System.out.println("[0]종료");
			System.out.print("메뉴 선택 : ");
			sel = scan.nextInt();
			
			switch(sel) {
			case 1: 
				checkLotto = lotto1;
			case 2:
				checkLotto = lotto2;
			case 3:
				checkLotto = lotto3;
			}
			
			for(int i = 0; i<lotto1.length; i++) {
				if(checkLotto[i] == 7)
					cnt++;
			}
			if(cnt >= 3)
				System.out.println(sel+"번 로또는 당첨입니다!!");
		}
		
		
	}
}
