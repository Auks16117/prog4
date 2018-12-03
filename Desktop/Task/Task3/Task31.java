/**
 * 基本課題3.1 Task31
 * Task22のPointクラスを拡張して動作を増やしたプログラム
 */

import java.util.Scanner;
public class Task31 {
	public static void main(String[] args) {
		Point p1 = new Point();	//	P1を生成	
		
		System.out.println("点P1" + p1.toString() +"を生成しました.");
		System.out.print("点P2の座標を入力してください[x y]:");
		Scanner scanner = new Scanner(System.in);
		
		Point p2 = new Point(scanner.nextDouble(), scanner.nextDouble());	//	P2を生成
		System.out.println("点P2" + p2.toString() +"を生成しました.");	
		System.out.println("P1とP2間の距離d1 = " + p2.getDistance(p1.getX(), p1.getY()));
		
		System.out.print("点P1の移動先座標を入力してください [x y]:");
		p1.move(scanner.nextDouble(), scanner.nextDouble());	// p1の座標を移動する		
		System.out.println("移動後の点P1の座標 = " + p1.toString());
		System.out.println("P1とP2間の距離d2 = " + p1.getDistance(p2));
		
		System.out.print("点P2の移動量を入力してください[x y]");
		p2.translate(scanner.nextDouble(), scanner.nextDouble());		//	p2の座標を移動する	
		System.out.println("移動後の点P2の座標 = " + p2.toString());
		System.out.println("P1とP2間の距離d3 = " + p2.getDistance(p1, p2));
		System.out.println("原点とP2間の距離d4 = " + p2.getDistance());
	}
}
