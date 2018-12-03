/**
 * 応用課題2.A Circle
 * Task2Aに使用．円のオブジェクト．
 */

package figure;
import java.lang.Math;

public class Circle {
	double radius;

	public void setRadius(double radius) {
		this.radius = radius;	//	半径を設定する
	}
	
	public double getRadius() {
		return this.radius;	//	半径を取得する
	}
	
	public double getArea() {
		return Math.PI * this.radius * this.radius;	//	円の面積の計算
	}
	
	public double getAround() {
		return Math.PI * this.radius * 2;	//	円の周囲の長さの計算
	}
	
	public String toString() {
		return "円　　:面積 = " + getArea() + ", 周囲の長さ = " + getAround();
		//	円の面積と周囲の長さを出力する
	}
}
