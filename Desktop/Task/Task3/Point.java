/**
 * 基本課題3.1 Point
 * 点のオブジェクト
 */

import java.lang.Math;

public class Point {
	private double x;
	private double y;
	
	Point(double x, double y){
		setLocation(x, y);
	}
	
	Point(){
		this(0.0, 0.0);
	}
	
	public double getX(){
		return this.x;	//	xを取得する
	}
		
	public double getY() {
		return this.y;	//	yを取得する
	}
	
	public void setX(double x) {
		this.x = x;	//	xを設定する
	}
	
	public void setY(double y) {
		this.y = y;	//	yを設定する
	}
	
	public void setLocation(double x, double y) {	//	xとyを設定する
		this.setX(x);
		this.setY(y);
	}
	
	public void move(double x, double y) {	//	xとyの座標を動かす
		this.setX(x);
		this.setY(y);
	}
	
	public void translate(double dx, double dy) {
		this.setX(getX() + dx);	// xをx+dxに移動
		this.setY(getY() + dy);	// yをy+dyに移動
	}
	
	public String toString() {	//	xとyの値を返す
		return "(" + getX() + ", " +getY() + ")";
	}

	public double getDistance() {
		return Math.sqrt(Math.pow(this.getX(), 2) + Math.pow(this.getY(), 2));
		// インスタンスから原点までの距離を返す
	}
	
	public double getDistance(double x, double y) {	
		return Math.sqrt(Math.pow((this.getX() - x), 2) + Math.pow((this.getY()) - y, 2));
		// P1とP2間の距離d1を返す
	}
	
	public double getDistance(Point p) {	//	pの座標とインスタンスの距離を返す
		return Math.sqrt(Math.pow((this.getX() - p.getX()), 2) + Math.pow((this.getY()) - p.getY(), 2));
	}
	
	static double getDistance(Point p1, Point p2) {	//	p1とp2の距離を返す
		return Math.sqrt(Math.pow((p1.getX() - p2.getX()), 2) + Math.pow(p1.getY() - p2.getY(), 2));
	}
}
