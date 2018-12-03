/**
 * 基本課題4.2 WalkingMonster
 * 歩くモンスターの抽象クラス
 */
package rpg.monsters;

public abstract class WalkingMonster extends Monster {
	@Override
	public void run() {	// 逃げ方を確定する
		System.out.println("はトコトコ走って逃げた!");
	}
}
