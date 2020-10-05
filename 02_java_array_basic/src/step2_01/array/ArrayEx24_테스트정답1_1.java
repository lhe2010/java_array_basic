package step2_01.array;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayEx24_테스트정답1_1 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int[] a = { 10, 4, 5, 3, 1 };
		
		// 문제 1) 위 배열를 이용해서 전체 요소의 합출력
		
		int sum = 0; 
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		System.out.println("[1] 전체요소의 합: " + sum);
		
		// 문제 2) 값을 입력하면 인덱스 출력
		// 예) 5 ==> 2  ,  1 ==> 4
		
		System.out.print("[2] 궁금한 인덱스의 값: ");
		int request = scan.nextInt();
		int result = 0;
		for (int i = 0; i < a.length; i++) {
			if(request == a[i])
				result = i;
		}
		System.out.printf("궁금해했던 값 %d의 인덱스는 %d입니다.\n", request, result);
		
		// 문제 3)  인덱스를 입력하면 값 출력
		// 예) 2 ==> 5  , 4 ==> 1
		System.out.print("[3] 인덱스를 입력하면 해당 인덱스의 값이 출력됩니다: ");
		request = scan.nextInt();
		System.out.printf("인덱스 %d의 값은 %d입니다.\n", request, a[request]);

		// 문제 4) 위 배열중 가장 큰 값 출력 
		// 예) 10
		int max = 0;
		for(int i = 0; i < a.length; i++) {
			if(max < a[i]) {
				max = a[i];
			}
		}
		System.out.printf("[4] 위 배열중 가장 큰값은 %d\n", max);

		// 문제 5) 위 배열중 홀수의 개수 출력 
		// 예) 홀수의 개수 : 3
		int cnt = 0;
		for (int i = 0; i < a.length; i++) {
			if(a[i]%2 == 1) 
				cnt++;
		}
		System.out.printf("[5] 홀수의 개수: %d\n", cnt);
			
		// 문제 6) a의 값중 홀수만 b에 저장 (저장위치는 a와 b의 동일한 위치에 저장)
		// 예) b => {0, 0, 5, 3, 1}
		int[] b = {0, 0, 0, 0, 0};
		for (int i = 0; i < a.length; i++) {
			if(a[i]%2 == 1) {
				b[i] = a[i];				
			}
		}
		System.out.println(Arrays.toString(b));
		
		// 문제 7) 다음 리스트를 이용해서 a의 값중 홀수만 c에 저장(저장위치는 앞에서부터  저장 , 3번 문제와 다름)
		// 예) b => {5, 3, 1, 0, 0}
		int[] c = { 0,0,0,0,0 };
		int idx = 0;
		for (int i = 0; i < a.length; i++) {
			if(a[i]%2 == 1) {
				c[idx] = a[i];
				idx++;
			}
		}
		System.out.println(Arrays.toString(c));
	}
}
