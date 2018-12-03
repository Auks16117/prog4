/**
 * 基本課題4.1 Point3D
 * z方向の位置を付け加えるオブジェクト
 */

public class Point3D extends Point {
	private double z;

	Point3D(double x, double y, double z){
		super(x, y);
		setZ(z);
	}

	Point3D(){
		this(0.0, 0.0, 0.0);
	}

	public double getZ() {	//	z座標を取得する
		return this.z;
	}

	public void setZ(double z) {	//	z座標を設定する
		this.z = z;
	}


	public void translate(double dx, double dy, double dz) {
		super.translate(dx, dy);		//	x座標,y座標をdx,dyずらす
		this.z += dz;		//	z座標をずらす
	}

	@Override
	public String toString() {	//	x,y,z座標を返す
		return "(" + super.x + ", " + super.y + ", " + this.z + ")";
	}
}
