// 20201006 15:30-17:00
package step2_01.array;

import java.util.Scanner;

/*
 * # ATM[3단계]
 * 1. 가입
 *  - 계좌번호와 비밀번호를 입력받아 가입
 *  - 계좌번호 중복검사
 * 2. 탈퇴
 *  -  계좌번호를 입력받아 탈퇴
 */

public class ArrayEx23_정답 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int[] accs = {1001, 1002, 0, 0, 0};
		int[] pws  = {1111, 2222, 0, 0, 0};
		
		int accsCnt = 2;
		int selectMenu = 0;
		boolean isRun = true;
		
		int acc = -1;
		int pw = -1;
		boolean bCheck; // true면 유효한것
		
		while (isRun) {
			
			System.out.println("\n[1] 가입");
			System.out.println("[2] 탈퇴");
			System.out.println("[3] 종료");
			System.out.println("[4] 전체 회원정보 열람");
			
			System.out.print("메뉴 선택 : ");
			selectMenu = scan.nextInt();
			
			if (selectMenu == 1) {
				
				if (accsCnt == accs.length) {
					System.out.println("[Error] 더이상 가입할 수 없습니다.");
					continue;
				}
				
				// do-while을 안쓰는경우 : 다시 계좌번호 입력화면으로 돌아가지는 못함.
				// 처음에는 check를 이용해서 해봄. /**/밑에.
				/*
				System.out.print("[가입] 계좌번호 입력 : ");
				acc = scan.nextInt();
				
				// 이미 가입된 계좌번호인지 체크합니다. 
				for (int i = 0; i < accs.length; i++) {
					// 이미 가입된 계좌번호라면
					if(accs[i] == acc) {
						System.out.println("[Error] 이미 가입되어있는 계좌번호입니다. ");
						continue;
						// 메뉴선택 화면으로 가기: break; || continue;
						// 프로그램 아예 종료시켜서 while문 밖으로 나가기: isRun = false;break;
						// ******다시 계좌번호 입력 화면으로 가서 다시 한번 더 입력받기: (do-)while해야함(밑에)
					}
				}*/
				
				bCheck = true;
				// false는 유효x true면 유효
				while(bCheck){ 
					System.out.print("\n[가입] 계좌번호 입력 : ");
					acc = scan.nextInt();
					
					// *****같은게 있는지 찾는거니까 같은게 있을때만 체크해주면된다. 
					for (int i = 0; i < accsCnt; i++) { 
						if(accs[i] == acc) { // 같은계좌번호가 있다. 유효X
							bCheck = false;
							System.out.println("[Error] 이미 가입되어있는 계좌번호입니다. 다시 입력하세요!");
							System.out.printf("[log] i=%d, bCheck=%b, 같은계좌번호입니다. \n", i, bCheck);
//							break;
						} 
					} // for문검사끝
					
					// 다돌았지만 같은것을 발견하지 못함 -> 유효 -> 비번입력받기
					if(bCheck) {
						System.out.print("[가입] 비밀번호 입력 : ");
						pw = scan.nextInt();
						
						accs[accsCnt] = acc;
						pws[accsCnt] = pw;
						accsCnt++;
						System.out.printf("[가입완료] acc: %d, pw: %d\n", acc, pw);
						break;
					} else {
						bCheck = true;
						continue; // while안에 bCheck를 넣으면 밖에 while(메뉴선택)으로 돌아간다. 
					}
				}
			}
			else if(selectMenu == 2) {
				bCheck = true;
				int idx = 0;
				
				while(bCheck) {
					System.out.print("\n[탈퇴] 계좌번호 입력 : ");
					acc = scan.nextInt();
					
					for (int i = 0; i < accsCnt; i++) {
						if(accs[i] == acc) {
							bCheck = false; // 찾았으므로 유효
							idx = i;
						}
					}
					
					// 찾았다면/유효하다면/탈퇴가능
					if(bCheck == false) {
						System.out.print("[탈퇴] 비밀번호 입력 : ");
						pw = scan.nextInt();
						
						if(pw == pws[idx]) {
							System.out.println("삭제진행중");
							for (int i = idx; i < accsCnt; i++) {
								accs[i] = accs[i+1];
								pws[i] = pws[i+1];
							}
							accsCnt--;							
						} else {
							System.out.println("[Error] 올바르지 않은 비밀번호입니다. 삭제불가");
						}
					} else {
						bCheck = true;
						System.out.println("[Error] 존재하지않는 계좌번호입니다. 다시 입력하세요.");
						continue;
					}
					
				}
				
				
				/*
				
				if (nCheck == -1) {
					System.out.println("해당계좌번호는 존재하지 않습니다.");
				}
				else {
					for (int i=nCheck; i<accsCnt-1; i++) {
						accs[i] = accs[i + 1];
						pws[i] = pws[i + 1];
					}
                    accs[accsCnt] = 0;
                    pws[accsCnt]  = 0;
                    accsCnt--;
				}
				*/
			} else if(selectMenu == 3) {
				isRun = false;
			} else if(selectMenu == 4) {
				System.out.println("[ 고객 계좌 열람 ]");
				for (int i = 0; i < accsCnt; i++) {
					System.out.printf("[%d] 계좌번호: %d 비밀번호: %d\n", i, accs[i], pws[i]);
				}
				
			} else {
				System.out.println("[Error] 유효한 메뉴를 클릭하세요!");
			}
			
		}
		
		System.out.println("[ 프로그램 종료 ]");
		scan.close();
		
	}
}
