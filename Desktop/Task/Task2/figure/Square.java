/**
 * 応用課題2.A Square
 * Task2Aに使用．正方形のオブジェクト．
 */

package figure;

public class Square {
	double width;
	double height;
	
	public void setWidth(double width) {
		this.width = width;	//	幅を設定する
	}
	
	public double getWidth() {
		return this.width;	//	幅を取得する
	}
	
	public void setHeight(double height) {
		this.height = height;	//	高さを設定する
	}
	
	public double getHeight() {
		return this.height;	//	高さを取得する
	}
	
	public double getArea() {
		return this.height * this.width;	//	面積を計算する
	}
	
	public double getAround() {
		return this.height * 2 + this.width * 2;	//	周囲の長さを計算する
	}
	
	public String toString() {
		return "四角形:面積 = " + getArea() + ", 周囲の長さ = " + getAround();	
		// 面積と周囲の長さを出力する
	}
}
