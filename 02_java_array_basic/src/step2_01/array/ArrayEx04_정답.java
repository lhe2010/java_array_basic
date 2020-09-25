// 0925 1교시 예제연습4 3분
package step2_01.array;

import java.util.Random;

/*
 * # 학생성적관리 프로그램[1단계] : 학생점수
 */


public class ArrayEx04_정답 {

	public static void main(String[] args) {
		
		Random ran = new Random();
		
		int[] arr = new int[5];

		// 문제1) arr배열에 1~100점 사이의 랜덤 정수를 5개 저장
		// 예   1) 87, 11, 92, 14, 47
		for(int i = 0; i<5;i++) {
			arr[i] = ran.nextInt(100)+1;
		}
		for(int i = 0; i<5;i++) {
			System.out.print(arr[i] + " "); // ***위에랑 중복. 굳이 두번 안해도됨
		}
		System.out.println();
		
		// 문제2) 전교생의 총점과 평균 출력
		// 예   2) 총점(251) 평균(50.2)
		int sum = 0;
		double avg = 0;	// double avg = 0.0;
		for (int i = 0; i<5; i++) {
			sum += arr[i];
		}
		avg = sum/arr.length;
		System.out.println("총점("+sum+") 평균(" +avg +")");
		
		// 문제3) 성적이 60점 이상이면 합격. 합격생 수 출력
		// 예   3) 2명
		int passCnt = 0;
		for(int i = 0; i< 5; i++) {
			if(arr[i] >= 60)
				passCnt++;
		}
		System.out.println(passCnt+"명");

	}
	
}
