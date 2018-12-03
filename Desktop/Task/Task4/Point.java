/**
 * 基本課題4.1 Point
 * 2次元の点を作るオブジェクト
 */

public class Point {
	protected double x;
	protected double y;

	public Point() {
		setX(0.0);
		setY(0.0);
	}

	public Point(double x, double y) {
		setX(x);
		setY(y);
	}

	public double getX() {	//	x座標を取得する
		return this.x;
	}

	public double getY() {	//	y座標を取得する
		return this.y;
	}

	public void setX(double x) {	//	x座標を設定する
		this.x = x;
	}

	public void setY(double y) {	//	y座標を設定する
		this.y = y;
	}

	public void translate(double dx, double dy) {	//	x座標とy座標をずらす
		this.x += dx;
		this.y += dy;
	}

	public String toString() {
		return "(" + this.x + ", " + this.y + ")";
	}
}
