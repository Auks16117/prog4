/**
 *  基本課題1.3 Task13
 *	行と列を入れ替えるプログラム
 */

public class Task13 {
	public static void main(String[] args) {
		String[][] table = {
				{"日付", "平均気温", "最高気温","最低気温", "平均湿度", "降水量"},
				{"9/1", "24.5", "26.9", "23.4", "85", "14.5"},
				{"9/2", "25.6", "30.6", "22.4", "72", "1.5"},
				{"9/3", "26.7", "32.3", "22.8", "68", "3.0"},
				};

		System.out.println("元の表:");

		showTable(table);	/*	元の表の表示	*/

		table = transpose(table);	/*	表の入れ替えを行う	*/

		System.out.println();
		System.out.println("入れ替え後の表:");

		showTable(table);	/*	入れ替えた後の表を表示する		*/
	}

	public static void showTable(String[][] table) {
		for(String []line : table) {	/*	縦の移動	*/
			for(String row : line) {		/*	横の移動	*/
				System.out.print(row + "\t");	/*	配列の中身を表示する	*/
			}
			System.out.println();	/*	改行を行う	*/
		}
	}

	public static String[][] transpose(String[][] oldTable) {
		String[][] newTable = new String[6][4];	/*	新しい表を作るための配列を宣言する	*/
		for(int i = 0; i < oldTable.length ; i++) {
			for(int j = 0; j < oldTable[0].length; j++) {
				newTable[j][i] = oldTable[i][j];	/*	行と列を入れ替えて新しい表に入れる	*/
			}
		}
		return newTable;	/*	新しい表を返す	*/
	}
}
