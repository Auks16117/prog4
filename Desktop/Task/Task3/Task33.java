/**
 * 基本課題3.3 Task33
 * モンテカルロ法で円周率πを求めるプログラム
 */
import java.util.Scanner;

public class Task33 {
	static public void main(String[] args) {
		System.out.print("演算回数の入力>");
		int NumberOfOperations;
		Scanner scanner = new Scanner(System.in);
		NumberOfOperations = scanner.nextInt();	// 演算回数を入力する
		System.out.print("演算回数" + NumberOfOperations +"で円周率を演算開始.... ");
		PiCalculator piCalculator = new PiCalculator(NumberOfOperations);
		System.out.println("演算終了");
		System.out.println();
		System.out.println("処理時間=" + piCalculator.getComputingTime() + "ms");		//	処理時間の表示
		System.out.println("演算結果=" + piCalculator.getCalculationResult());	//	演算結果の表示
		System.out.println("誤差=" + piCalculator.getError());	//	誤差の表示
	}
}
