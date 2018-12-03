/**
 * 基本課題2.3 Task23
 * ICスマートカードを作るプログラム
 */

import java.util.Scanner;

public class Task23 {
	public static void main(String[] args) {
		/* 1. キーボードで入力した氏名と電話番号を用いてスマートカードを作成 */
		System.out.println("スマートカードを作成します．");
		// スマートカードを作成
		SmartCard smartCard = new SmartCard();
		// スマートカードに氏名，電話番号，初期残高を設定
		System.out.print("所有者名を入力してください>");
		Scanner scanner = new Scanner(System.in);		
		smartCard.setName(scanner.nextLine());		
		System.out.print("電話番号を入力してください>");
		smartCard.setPhoneNumber(scanner.nextLine());
		smartCard.setlnitialBalance();
		
		System.out.println("スマートカードを作成しました．初期残高は" + smartCard.getBalance() +"円です．");
		
		/* 2. 2000円を支払おうとするが残高不足のため，チャージして支払う */
		while (true) {
			// もし2000円を支払えたらループを脱出
			if(smartCard.pay(smartCard.getBalance())) {
				break;
			}
			System.out.println("残高が不足しているため支払いができません.");
			System.out.print("チャージ金額を入力してください>");
			
			// 支払えない場合はチャージする（チャージ金額はキーボードで入力）
			smartCard.charge(scanner.nextInt());
		}
		
		System.out.println("2000円支払いました.");	
		System.out.println("スマートカードの情報を表示します.");
		System.out.println(smartCard.toString());
	}
}