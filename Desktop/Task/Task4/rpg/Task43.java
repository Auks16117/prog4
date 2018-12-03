/**
 * 基本課題4.3 Task43
 * モンスターをランダムに発生させて，各モンスターがランダムに戦うが逃げるようなプログラム
 */

// rpgパッケージに所属させる（消さないこと！）
package rpg;

// 必要なクラスをインポート
import java.util.Random;
import rpg.monsters.*;
/**
 * 基本課題4.3（雛形）
 */
public class Task43 {

	public static void main(String[] args) {
		// 発生させるモンスターの数を2〜5の範囲で生成する
		Random random = new Random();
		int r = random.nextInt(4) + 2;

		// 生成するモンスターを格納する配列を作成
		Monster[] monster = new Monster[r];
		// モンスターをランダムに生成
		char goblinSuffix = 'A';
		char warWolfSuffix = 'A';
		char deathBatSuffix = 'A';

		for(int i = 0;i < monster.length;i++) {
			int monsterNumber = random.nextInt(3);
			if(monsterNumber == 0) {
				monster[i] = new Goblin(goblinSuffix);
				goblinSuffix++;
			}
			if(monsterNumber == 1) {
				monster[i] = new WarWolf(warWolfSuffix);
				warWolfSuffix++;
			}
			if(monsterNumber == 2) {
				monster[i] = new DeathBat(deathBatSuffix);
				deathBatSuffix++;
			}
		}
		// 生成したモンスターを表示
		showMonsters(monster);

		// モンスターがランダムに行動
		int nullNumber = 0;	//	nullにした数
		while(nullNumber != monster.length) {	//	全部nullになるまで繰り返す
			for(int i = 0;i < monster.length;i++) {
				if(monster[i] != null) {	//	既にnullでないかを確認する
					boolean f = random.nextBoolean();
					if(f == true) {
						System.out.print(monster[i].toString());
						monster[i].attack();
					}else {
						System.out.print(monster[i].toString());
						monster[i].run();
						monster[i] = null;
						nullNumber++;	//	nullである数の合計を増やす
					}
				}
			}
		}

		// 全てのモンスターが逃げ出したら表示
		System.out.println("\nモンスターは全て逃げ出した！");
	}

	/**
	 * モンスターの一覧を表示するクラスメソッド
	 * @param XXX	モンスターを管理している配列（型と引き数名を設定すること）
	 */
	private static void showMonsters(Monster[] monster) {
		for(int i = 0;i < monster.length;i++) {
			System.out.print(monster[i] + " ");
		}
		System.out.println("が現れた！\n");
	}
}
