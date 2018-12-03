/**
 * 基本課題4.2 WarWolf
 * ウォーウルフのオブジェクト
 */
package rpg.monsters;

public class WarWolf extends WalkingMonster {
	public WarWolf(char suffix){
		super.hp = 20;
		super.mp = 15;
		super.name = "ウォーウルフ";
		super.suffix = suffix;
	}

	@Override
	public void attack() {	//	攻撃方法を確定する
		System.out.println("はかみついた!");
	}
}
