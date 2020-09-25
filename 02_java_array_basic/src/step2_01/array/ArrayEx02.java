// 0925 1교시 설명
package step2_01.array;

public class ArrayEx02 {

	public static void main(String[] args) {
		
		// 방법 1
		int[] arr1 = new int[3];
		
		arr1[0] = 10;
		arr1[1] = 20;
		arr1[2] = 30;
		
		// 방법 2: 축약형 (배열을 처음 생성할 때만 가능)
		int[] arr2 = {10, 20, 30};
//		arr2 = {40, 50, 60}; // error!
		
		// 방법 3 (for문과 조합)
		int[] arr3 = new int[3];
		for (int i = 0; i < arr3.length; i++) {	// 배열명.length : 배열의 크기를 자동으로 구할 수 있다. 
			arr3[i] = (i+1) * 10;
		}

	}

}
