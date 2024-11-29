package com.yedam.reference;

public class TodoExe1 {
	public static void main(String[] args) {
		// 정수를 담는 배열 크기는 5개로
		// Math.random() 활용 => 50~100 사이의 점수를 저장
		int[] intAry = new int[5];
		for (int i = 0; i < intAry.length; i++) {
			int temp = (int) (Math.random() * 5) + 50;
			// 2번쨰-1번째,3번째--2번째까지,4번째-3번째까지 비교
			boolean exists = false;
			for (int j = 0; j <= i - 1; j++)
				
			{
				if (intAry[j] == temp) {
					exists = true; // 같은값이 존재
				}
			}
			// 같은값이 존재하면 i값 증가 X
			if (exists) {
				continue;
			}
			intAry[i] = temp;
			i++;
		}
		for (int num : intAry) {
			System.out.println(num);
		}
		System.out.println("end of prog");
	}
}
