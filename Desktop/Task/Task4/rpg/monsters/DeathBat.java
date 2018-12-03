/**
 * 基本課題4.2 DeathBat
 * デスバットを生成するオブジェクト
 */
package rpg.monsters;

public class DeathBat extends FlyingMonster {
	public DeathBat(char suffix){
		super.hp = 10;
		super.mp = 15;
		super.name = "デスバット";
		super.suffix = suffix;
	}

	@Override
	public void attack() {	//	攻撃方法を確定する
		System.out.println("は突っついた!");
	}
}
