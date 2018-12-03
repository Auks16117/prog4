/**
 * 基本課題2.2 Point
 * Task22に使用．点のオブジェクト．
 */
package id;
import java.lang.Math;

public class Point {
	public int x;
	public int y;
	
	public int getX(){
		return this.x;	//	xを取得する
	}
	
	public void setX(int x) {
		this.x = x;	//	xを設定する
	}
	
	public int getY() {
		return this.y;	//	yを取得する
	}
	
	public void setY(int y) {
		this.y = y;	//	yを設定する
	}
	
	public String toString() {
		String str = String.format("(%d, %d)", getX(), getY());
		return str;	//	(x, y)という書式で出力する
	}
	
	public void setXY(int x, int y) {
		this.x = x;		//	xとｙを設定する
		this.y = y;
	}
	
	public int[] getXY() {
		int[] suti = new int [2];
		suti[0] = this.x;
		suti[1] = this.y;
		return suti;	//	配列を取得する
	}
	
	public double getDistance(int x, int y) {	
		return Math.sqrt(Math.pow((getXY()[0] - x), 2) + Math.pow((getXY()[1] - y), 2));
		// インスタンスからX,Yの距離を返す
	}
	
	public double getDistance() {
		return Math.sqrt(Math.pow(getX(), 2) + Math.pow(getY(), 2));
		// インスタンスから原点までの距離を返す
	}
}
