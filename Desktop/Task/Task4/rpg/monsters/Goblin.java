/**
 * 基本課題4.2 Goblin
 * ゴブリンのオブジェクト
 */
package rpg.monsters;

public class Goblin extends WalkingMonster {
	public Goblin(char suffix){
		super.hp = 10;
		super.mp = 10;
		super.name = "ゴブリン";
		super.suffix = suffix;
	}

	@Override
	public void attack() {	//	攻撃方法を確定する
		System.out.println("はナイフで斬りつけた!");
	}
}
