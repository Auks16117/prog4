/**
 * 応用課題2.A Triangle
 * Task2Aに使用．三角形のオブジェクト．
 */

package figure;
import java.lang.Math;

public class Triangle {
	public double width;
	public double height;
	
	public void setWidth(double width) {
		this.width = width;	//	底辺を設定する
	}
	
	public double getWidth() {
		return this.width;	//	底辺を取得する
	}
	
	public void setHeight(double height) {
		this.height = height;	//	高さを設定する
	}
	
	public double getHeight() {
		return this.height;	//	高さを取得する
	}
	
	public double getArea() {
		return (this.width * this.height) / 2;	//	面積を計算する
	}
	
	public double getAround() {
		double hypotenuse = Math.sqrt(Math.pow(this.width, 2) + Math.pow(this.height, 2));
		//	斜辺の長さを計算する
		return this.width + this.height + hypotenuse;
		//	周囲の長さを計算する
	}
	
	public String toString() {
		return "三角形:面積 = " + getArea() + ", 周囲の長さ = " + getAround();
		//	面積と周囲の長さを取得する
	}
}
