// 20201005 수업후 
package step2_01.array;

import java.util.Arrays;
import java.util.Scanner;

/*
 * # 배열 컨트롤러[1단계] : 최종
 * 
 *  20번 21번 22번의 문제를 한 코드로 병합하여 보자.
 * 
 * 1) 추가
 * 2) 삭제
 * 3) 삽입
 * 
 *  정답 없음
 */


public class ArrayEx22_정답 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int[] arr = {10,20,0,0,0};
		int elementCnt = 2; // 빈 인덱스의 시작 번호
		int selectMenu = 0;
		int input = 0;
		int idx = -1;
		
		while (true) {
			
			System.out.println("\n[1] 추가");
			System.out.println("[2] 삭제");
			System.out.println("[3] 삽입");
			System.out.println("[4] 종료\n");
			System.out.print("[ 메뉴선택 ] 입력 : ");
			selectMenu = scan.nextInt();
		
			if(selectMenu == 1) {
				// 추가메뉴 선택
				if(elementCnt == 5) {
					System.out.println("[Error!] 배열이 꽉찼습니다. 초기메뉴로 돌아갑니다. "); 
//					break; 		// 배열이 찬경우 프로그램 종료
					continue;	// break말고 continue해주면? -> 초기메뉴로 돌아감
				} else {
					System.out.print("추가하고 싶은 값을 입력하세요: ");
					input = scan.nextInt();
					
					arr[elementCnt++] = input;
					System.out.println("[결과] " + Arrays.toString(arr));
				}
			} else if (selectMenu == 2) {
				// 삭제메뉴 선택
				System.out.print("삭제하고 싶은 값을 입력하세요: ");
				input = scan.nextInt();
				idx = -1;
				
				for (int i = 0; i < arr.length; i++) {
					if(arr[i] == input) {
						arr[i] = 0;
						idx = i;
						break;
					} 
				}
				if(idx == -1) {
					System.out.println("[Error!] 배열에 없는 값이므로 삭제 불가. 초기메뉴로 돌아갑니다. ");
					continue;
				}
				for (; idx < arr.length-1; idx++) {
					arr[idx] = arr[idx+1];
				}
				// ****************************************
//				arr[idx] = 0; // Arrays.toString() 이 아닌 for문을 이용해서 cnt만큼만 프린트한다********
				// Arrays를 이용할 경우 - 삭제되어 비게된 마지막 요소를 따로 0으로 초기화해줘야한다. 

				elementCnt--;
//				System.out.println("[결과] " + Arrays.toString(arr)); 
				System.out.print("[결과] ");
				for (int i = 0; i < elementCnt; i++) {
					System.out.print(arr[i]+" "); 
				}
			} else if(selectMenu == 3) {
				// 삽입메뉴 선택
				System.out.print("삽입하고싶은 위치의 인덱스: ");
				idx = scan.nextInt();
				if(elementCnt == 5) {
					System.out.println("[Error!] 배열이 꽉찼으므로 삽입불가! 초기메뉴로 돌아갑니다. ");
					continue;
				} else if(idx < 0 || idx > 4) {
					System.out.println("[Error!] 인덱스 값이 잘못되었습니다. 초기메뉴로 돌아갑니다. ");
					continue;
				}
				System.out.print("arr["+idx+"]에 삽입하고싶은 값: ");
				input = scan.nextInt();
				
				// **********************************
				// 인덱스i랑 elementCnt랑 idx랑 for문안에 배열 인덱스값이랑 엉켜서 값이 계속 오류났음!!!!!
				// 하나씩 뒤로 밀어서 저장한다. 
				for(int i = elementCnt;i > idx; i--) {
					arr[i] = arr[i-1];
				}
				
				arr[idx] = input;
				elementCnt++;
				
				System.out.print("[결과] ");
				for (int i = 0; i < elementCnt; i++) {
					System.out.print(arr[i]+" "); 
				}
				
			} else if(selectMenu == 4) {
				// 종료메뉴 선택
				break;
			} else
				System.out.println("[Error!] 유효한 메뉴를 선택하시오!");
		}
		
		System.out.println("[ 프로그램 종료 ] ");
		
	}
	
}
