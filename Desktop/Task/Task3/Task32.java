/**
 * 基本課題3.2 Task32
 * 三角形のオブジェクトを作り，三角形の移動をするプログラム
 */
import java.util.Scanner;

public class Task32 {
	public static void main(String[] args) {
			
		Triangle triangle = new Triangle(Double.parseDouble(args[0]) , Double.parseDouble(args[1]), Double.parseDouble(args[2]), Double.parseDouble(args[3]), Double.parseDouble(args[4]), Double.parseDouble(args[5]));
		//	三角形のオブジェクトを生成
		System.out.println("三角形の頂点座標:" + triangle.show());	
		System.out.print("三角形の移動量を入力して下さい [dx dy]:");
		Scanner scanner = new Scanner(System.in);
		triangle.translate(scanner.nextDouble(), scanner.nextDouble());	//	三角形の座標の移動量を入力する
		System.out.println("三角形の頂点座標:" + triangle.show());
	}
}
