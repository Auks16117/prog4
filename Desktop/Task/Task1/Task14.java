/**
 *  基本課題1.4 Task14
 *	指定した値未満の最大素数を求めるプログラム
 */

public class Task14 {
	public static void main(String[] args) {
		if(args.length == 0) {	//	コマンドライン引数が入力されていないとき
			System.out.print("コマンドライン引数に数値が指定されていません.");
			System.out.println("プログラムを終了します.");
			System.exit(1);	//	プログラムを終了する
		}
		int value = Integer.parseInt(args[0]);	/*	引数の数を入れる	*/
		if(value < 1) {	/*	1未満の数が入力されたとき	*/
			System.out.print("コマンドライン引数に不正な値が指定されました.");
			System.out.println("プログラムを終了します.");
			System.exit(1);	//	プログラムを終了する
		}
		boolean[] number = new boolean[value];
		//	エラトステネスのふるいで使用する変数を宣言する
		for(int i = 2; i < value; i++) {
			number[i] = true;	//	trueで初期化を行う
		}
		int primeNumber = 0;	//	最大素数を入れる変数を0で初期化する
		for(int i = 2; i < value; i++) {
			if(number[i] == true) {	//	trueであったとき
				for(int j = i * 2; j < value; j += i) {
					number[j] = false;	//	jの倍数の配列の中身をfalseにする
				}
				primeNumber = i;	//	iを最大素数とする
			}
		}
		if(primeNumber == 0) {	//	最大素数が見つからなかったとき
			System.out.println(value + "未満の素数はありません.");
			System.exit(1);	//	プログラムを終了する
		}
		System.out.println(value + "未満の最大素数は" +primeNumber);
		//	最大素数を表示する
	}
}
