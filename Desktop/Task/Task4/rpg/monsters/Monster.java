/**
 * 基本課題4.2 Monster
 * モンスターの抽象クラス
 */
package rpg.monsters;

public abstract class Monster {
	int hp;
	int mp;
	String name;
	char suffix;

	public abstract void attack();	//	攻撃方法の抽象メソッド

	public abstract void run(); 	//	逃げ方の抽象メソッド

	public String toString() {	//	モンスター名とサッフィクスを返す
		return name + suffix;
	}
}
