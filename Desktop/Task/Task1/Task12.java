/**
 *  基本課題1.2 Task12
 *	じゃんけんゲームのプログラム
 */

import java.util.Scanner;
import java.util.Random;

public class Task12 {
	public static void main(String[] args) {
		System.out.println("###じゃんゲーム###");
		System.out.println("じゃんけん ");

		int myHand, opponentHand;	/*	出す手の変数	*/

		do {
			System.out.print("(0:グー, 1:チョキ, 2:パー) > ");
			Scanner scanner = new Scanner(System.in);
			myHand = scanner.nextInt();	/*	自分の出す手を選択する	*/

			while(myHand != 0 && myHand != 1 && myHand != 2) {	/*	0,1,2以外であったとき	*/
				System.out.print("(0:グー, 1:チョキ, 2:パー) > ");
				myHand = scanner.nextInt();
			}

			Random rnd = new Random();	/*	0から2までの乱数を生成する	*/
			opponentHand = rnd.nextInt(3);

			System.out.print("ポン! ");
			System.out.print("あなた ");

			switch(myHand) {	/*	自分の出した手を表示する	*/
			case 0:
				System.out.print("「グー」, ");
				break;
			case 1:
				System.out.print("「チョキ」, ");
				break;
			case 2:
				System.out.print("「パー」, ");
				break;
			}

			System.out.print("相手 ");

			switch(opponentHand) {	/*	相手の出した手を表示する	*/
			case 0:
				System.out.print("「グー」  ");
				break;
			case 1:
				System.out.print("「チョキ」  ");
				break;
			case 2:
				System.out.print("「パー」  ");
				break;
			}

			switch((myHand - opponentHand) % 3) {	/*	じゃんけんの結果を表示する	*/
			case 0:
				System.out.println("あいこで");
				break;
			case -1:
				System.out.print("勝ち");
				break;
			case -2:
				System.out.print("負け");
				break;
			case 1:
				System.out.print("負け");
				break;
			case 2:
				System.out.print("勝ち");
				break;
			}
		}while(myHand == opponentHand);	/*	自分と相手の手が同じ場合繰り返す	*/
	}
}
