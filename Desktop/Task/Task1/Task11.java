/**
 * 基本課題1.1　Task11
 *ファイルとスループットをキーボードから入力して，
 *ダウンロード時間を表示するプログラム
 */

import java.util.Scanner;

public class Task11 {
	public static void main(String[] args) {

		System.out.print("ファイルサイズ(GB):");		//　ファイルのサイズを入力する
		Scanner scanner = new Scanner(System.in);
		int fileSize= scanner.nextInt();

		System.out.print("スループット(Mbps):");	//	スループットを入力する
		double throughPut = scanner.nextDouble();

		System.out.print("予想ダウンロード時間:");
		System.out.print(getDownloadTime(fileSize, throughPut));	//	関数を使って予想ダウンロード時間を計算して表示する
	}

	public static String getDownloadTime(int fileSize, double throughPut) {	//	予想ダウンロード時間を計算する関数

		double hour, minute, second, downloadTime;
		//	時間,分,秒,秒だけのダウンロード時間

		downloadTime = (fileSize * 1024 * 8) / throughPut;	// ダウンロード時間を秒で計算する
		hour = downloadTime  / (60 * 60);	// 何時間かを求める
		minute = (downloadTime - (60 * 60 * (int)hour)) / 60;	// 何分であるかを求める
		second = downloadTime - ((60 * 60 * (int)hour) + (60 * (int)minute));	// 何秒であるかを求める

		if((int)minute == 0 && (int)hour <= 1) {	//　分,時間が0と1より小さい時
				return (int)second + "秒";			// 秒だけを表示する
		}else if((int)minute != 0 && (int)hour <= 1){	// 時間が1より小さい時
			return (int)minute + "分" + (int)second + "秒";	//	分と時間を表示する
		}else{
			if(minute == 0) {	//	分が0の時
				return (int)hour + "時間" + (int)second + "秒";	// 時間と秒を表示する
			}else {	//	時間,分,秒が全て0でない時
				return (int)hour + "時間" + (int)minute + "分" +  (int)second + "秒";
			}
		}
	}
}
