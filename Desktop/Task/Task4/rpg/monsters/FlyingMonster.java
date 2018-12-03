/**
 * 基本課題4.2 FlyingMonster
 * 飛ぶモンスターの抽象クラス
 */
package rpg.monsters;

public abstract class FlyingMonster extends Monster {
	@Override
	public void run() {	//	逃げ方を確定する
		System.out.println("はバザバサ飛んで逃げた!");
	}
}
