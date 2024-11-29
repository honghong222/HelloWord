package com.yedam.reference;

import java.util.Scanner;

import javax.swing.event.TreeWillExpandListener;

//은행 프로그램 1.0
//작성자: 김태홍
//작성일시: 2024.11.29
public class ArrayExe2 {
	public static void main(String[] args) {
		//변수 초기화. 10만원 초과 불가. 90000원 20000원 입금 실패 -잔고도 X
		boolean run = true;
		int balance = 0;
		int maxbalance = 100000; //최대금액
		Scanner scn = new Scanner(System.in);
		
		while(run){
			System.out.println("--------------------------------");
			System.out.println("1.예금 2.출금 3.잔고 4.종료");
			System.out.println("--------------------------------");
			System.out.print("선택>>");
			int menu = Integer.parseInt (scn.nextLine());
			
			switch(menu) {
			
			case 1:
				
				System.out.print("예금액>");
				int inbalance = Integer.parseInt(scn.nextLine());
				if(balance+inbalance<=maxbalance) {
				balance += inbalance;
				}else{
					System.out.println("100000원이 넘어요");
				}break;
			case 2:
				System.out.print("출금액>");
				inbalance = Integer.parseInt(scn.nextLine());
				if(balance-inbalance>0) {
				balance -= inbalance;
				}else{
					System.out.println("출금불가");
				}break;
			case 3:
				System.out.print("잔고>" + balance);
				break;
			case 4:
				run = false;
			}
		}
		System.out.println("프로그램 종료");
	}
}
