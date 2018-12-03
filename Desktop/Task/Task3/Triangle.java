/**
 * 基本課題3.2 Triangle
 * 三角形のオブジェクト
 */

public class Triangle {
	
	private Point[] point = new Point[3];
	
	Triangle(double x1, double y1, double x2, double y2, double x3, double y3){
		point[0] = new Point(x1, y1);	//	座標Aの設定
		point[1] = new Point(x2, y2);	//	座標Bの設定
		point[2] = new Point(x3, y3);	//	座標Cの設定	
	}
	
	public void translate(double dx, double dy) {	//	座標を移動する
		for(int i = 0;i < point.length;i++) {
			point[i].translate(dx, dy);
		}
	}
	
	public String show() {		//	座標を返す
		return "A" + point[0].toString() + ", B" + point[1].toString() + ", C" + point[2].toString();
	}
}
