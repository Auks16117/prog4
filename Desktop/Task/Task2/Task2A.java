/**
 * 応用課題2.A Task2A
 * 四角形，三角形，円のオブジェクトを作成して，それぞれの面積，周囲の長さを求めるプログラム
 */

import figure.*;

public class Task2A {
	public static void main(String[] args) {
		Square square = new Square();	//	長方形のインスタンスを生成する
		square.setWidth(Double.parseDouble(args[0]));	//	幅を設定する
		square.setHeight(Double.parseDouble(args[1]));	//	高さを設定する
		System.out.print("四角形の幅と高さ= ");
		System.out.println(square.getWidth() + " " + square.getHeight());
		//	幅と高さの表示
		
		Triangle triangle = new Triangle();	//	三角形のインスタンスを生成する
		triangle.setWidth(Double.parseDouble(args[2]));	//	底辺を設定する
		triangle.setHeight(Double.parseDouble(args[3]));	//	高さを設定する
		System.out.print("三角形の底辺と高さ= ");
		System.out.println(triangle.getWidth() + " " + triangle.getHeight());
		//	底辺と高さの表示
		
		Circle circle = new Circle();	//	円のインスタンスを生成する
		circle.setRadius(Double.parseDouble(args[4]));	//	半径を設定する
		System.out.print("円の半径= ");
		System.out.println(circle.getRadius());	//	半径の表示
		System.out.println();
		
		System.out.println(square.toString());	//	長方形の面積と周囲の長さを表示する
		System.out.println(triangle.toString());	//	三角形の面積と周囲の長さを表示する
		System.out.println(circle.toString());	//	円の面積と周囲の長さを表示する
	}
}
