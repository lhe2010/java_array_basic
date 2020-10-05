package step2_01.array;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayEx24_테스트정답1_2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);		

		// 문제 8) 아래 d에서 scanner로 내가 입력한 값만 빼고 e에 저장 
		int[] d = { 10,20,30,40,50 };
		int[] e = { 0,0,0,0,0 };
		// 예) 30 ==> e = {10,20,40,50,0};
		int idx = 0;
		System.out.print("[8] 입력한 값만 빼고 새 배열에 저장: ");
		int input = scan.nextInt();
		for (int i = 0; i < d.length; i++) {
			if(d[i] == input) 
				continue;
			else 
				e[idx++] = d[i];
		}
		System.out.println(Arrays.toString(e));

		// ****************************************************************** 어렵다 ㅠㅠㅠㅠ
		// 문제 9) 아래 f에서 scanner로 내가 입력한 번호와 값을 빼고 d에 저장 
		int[] f = { 1001, 40, 1002, 65, 1003,  70 };
		int[] g = { 0,0,0,0,0,0 };
		// 예) 1002 ==> {1001, 40, 1003, 70 , 0, 0};
		
		idx = 0;
		boolean passIdx = false; 
		System.out.print("[9] 입력하신 번호와 값을 빼고 저장합니다: ");
		input = scan.nextInt();
		for (int i = 0; i < f.length; i++) { 	// F배열의 모든 값 순회
			if(f[i] == input && i%2 == 0 && passIdx == false) {		// 학번이면서 그 학번이 input과 같으면 
//				g[i] = 0;						
//				g[++i] = 0;
				passIdx = true;					// 패스해라
				continue;						// 빼고저장해야하므로 continue;
			} else if(passIdx == true ) {
//			else if(f[i-1] == input && i%2 == 1) {	// 점수이면서 그 점수의 학생이 input과 같다면
				passIdx = false; 				// 다시 false처리해주고 
				continue;						// 빼고저장해야하므로 continue;
			}
			else {								// 입력한 학번이랑 다른 사람의 학번과 점수는 저장한다. 
				g[idx++] = f[i];
			}
		}
		System.out.println(Arrays.toString(g));
		
		
		// 문제 10) 숫자를 하나 입력받고 아래 배열을 앞으로 하나씩 밀어낸후 맨뒤에 저장
		int[] h = 		{10,20,30,40,50 };
		// 예)60 ==> 	{20,30,40,50,60};
		System.out.print("[10] 맨 뒤에 저장하고 싶은 값(값이 앞으로 당겨짐): ");
		input = scan.nextInt();
		for (int i = 0; i < h.length-1; i++) {
			h[i] = h[i+1];
		}
		h[h.length-1] = input;
		System.out.println(Arrays.toString(h));
		
		// #################다시해보기: 오류: 앞에서부터 바꾸니까 모든값이 10으로 바뀜.
		// 문제 11) 숫자를 하나 입력받고 아래 배열을 뒤로 하나씩 밀어낸후 맨 앞에 저장 
		int[] i = { 10,20,30,40,50 };
		// 예) 60 ==> {60,10,20,30,40};
		System.out.print("[11] 맨 앞에 저장하고 싶은 값(값이 뒤로 하나씩 밀림): ");
		input = scan.nextInt();
		for (int j = i.length-1; j > 0; j--) {
			i[j] = i[j-1]; 
		}
		i[0] = input;
		System.out.println(Arrays.toString(i));
		
		// 문제 12) 아래배열을 거꾸로 저장 
		int[] j = { 1,2,3,4,5 };
		int[] k = { 0,0,0,0,0 };
		//예) k => {5,4,3,2,1};
		for (int ii = 0; ii < k.length; ii++) {
			k[4-ii] = j[ii];
		}
		System.out.println(Arrays.toString(k));
	}
}
