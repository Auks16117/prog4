/**
 * 基本課題4.1 Task41
 * Pointクラスを継承したPoint3Dクラスを使ったプログラム
 */
import java.util.Scanner;

public class Task41 {

	public static void main(String[] args) {
		// 原点に点P1を生成
		Point3D p1 = new Point3D();
		System.out.println("点P1" + p1.toString() + "を生成しました．");

		// キーボードで指定した座標に点P2を生成
		System.out.print("点P2の座標を入力して下さい[x y z]: ");
		Scanner scanner = new Scanner(System.in);
		Point3D p2 = new Point3D(scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble());
		System.out.println("点P2" + p2.toString() + "を生成しました．");

		// キーボードで点P2の移動量を入力して移動させる
		System.out.print("点P2の移動量を入力して下さい[dx dy dz]: ");
		p2.translate(scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble());
		System.out.println("移動後の点P2の座標 = " + p2.toString());
	}

}
