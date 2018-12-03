/**
 * 基本課題2.2 Task22
 * 指定した点クラスを作成して，座標や距離などを表示するプログラム
 */
import java.util.Scanner;

import id.Point;

public class Task22 {
	/**
	 * メインメソッド
	 * @param args	X座標とY座標
	 */
	public static void main(String[] args) {
		// 点P1を作成してコマンドライン引数で指定した座標を設定
		
		Point p1 = new Point();
		p1.setX(Integer.parseInt(args[0]));
		p1.setY(Integer.parseInt(args[1]));
		
		// 情報の表示
		System.out.println("点P1" + p1.toString() + "を生成しました．");
		System.out.println("X座標=" + p1.getX() + ", Y座標=" + p1.getY());
		
		// 原点とP1間の距離を表示
		System.out.println("原点からP1までの距離=" + p1.getDistance());

		// 点P2を作成してキーボードで指定した座標を設定
		
		Point p2 = new Point();	
		System.out.print("P2の座標を入力してください> ");	
		Scanner scanner = new Scanner(System.in);
		p2.setXY(scanner.nextInt(), scanner.nextInt());

		// P1-P2間の距離を表示
		System.out.println("P1-P2間の距離=" + p2.getDistance(p1.x, p1.y));
	}

}
