/**
 * 基本課題3.3 PiCalculator
 * モンテカルロ法を行うオブジェクト
 */
import java.util.Random;
import java.lang.Math;

public class PiCalculator {
	private int numberOfOperations;	//	演算回数
	private double calculationResult;	//	演算結果
	private double error;	//	実際の円周率との誤差
	private double computingTime;	//	演算時間
	
	PiCalculator(int numberOfOperations){
		this.setNumberOfOperations(numberOfOperations);	
		this.arithmeticProcessingOfPi();	//	演算を行う
	}
	
	private void setNumberOfOperations(int numberOfOperations) {	//	演算回数を設定する
		this.numberOfOperations = numberOfOperations;
	}
	
	public double getCalculationResult() {	//	演算結果を返す
		return this.calculationResult;
	}
	
	public double getError() {	//	誤差を返す
		return this.error;
	}
	
	public double getComputingTime() {	//	演算時間を返す
		return this.computingTime;
	}
	
	private void arithmeticProcessingOfPi() {	//	演算の処理を行う	
		double startTime, stopTime;
		int m = 0;	
		startTime = System.currentTimeMillis();	//	処理開始の時刻
		Random rnd = new Random();	
		for(int i = 0; i < this.numberOfOperations; i++) {	//	xとyを乱数で生成する
			double x = rnd.nextDouble();
			double y = rnd.nextDouble();
			if(x * x + y * y <= 1) {
				m++;
			}
		}
		this.calculationResult = (4.0 * m) / this.numberOfOperations;	//	円周率を出す
		this.error = Math.abs(3.14159265358979323846 - this.calculationResult);	//	誤差を出す
		stopTime = System.currentTimeMillis();	//	処理終了後の時刻
		this.computingTime = stopTime - startTime;	//	処理時間を計算する
	}	
}
	