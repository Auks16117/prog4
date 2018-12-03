/**
 * 基本課題4.2 Task42
 * ゴブリン，ウォーウルフ，デスバットを作成して，それぞれが攻撃を
 * 行ったあと，逃げ出すプログラム
 */
package rpg;
import rpg.monsters.*;

public class Task42 {
	public static void main(String[] args) {
		//		モンスターを5体生成する
		Monster[] monster = new Monster[5];
		monster[0] = new Goblin('A');
		monster[1] = new WarWolf('A');
		monster[2] = new DeathBat('A');
		monster[3] = new Goblin('B');
		monster[4] = new DeathBat('B');

		for(int i = 0;i < monster.length;i++) {	//	モンスターが攻撃する
			System.out.print(monster[i].toString());
			monster[i].attack();
		}

		for(int i = 0;i < monster.length;i++) {	//	モンスターが逃げる
			System.out.print(monster[i].toString());
			monster[i].run();
		}
	}
}
