package step2_01.array;

import java.util.Scanner;

/*
 * # 배열 컨트롤러[1단계] : 삭제
 * 
 * 소스를 이해하고 동작해본뒤 정답에 코드를 작성해보자.
 * 
 */



public class ArrayEx20_정답 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int[] arr = {10, 20, 30, 40, 50};
		int elementCnt = 5;
		int selectMenu = 0;
		
		while (true) {
			
			for (int i=0; i<elementCnt; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();

			System.out.println("[2]삭제");
			
			System.out.print("메뉴 선택 : ");
			selectMenu = scan.nextInt();

			if (selectMenu == 2) {
				
				System.out.print("삭제할 값 입력 : ");
				int data = scan.nextInt();
				
				int delIdx = -1;
				for (int i=0; i<elementCnt; i++) {
					if (arr[i] == data) {
						delIdx = i;
					}
				}
				
				if (delIdx == -1) {
					System.out.println("입력하신 값은 존재하지 않습니다.");
				} 
				else {
					for(int i=delIdx; i<elementCnt-1; i++) {
						arr[i] = arr[i+1];
					}
					elementCnt--;
				}
				
			}

		}
		
	}

}
