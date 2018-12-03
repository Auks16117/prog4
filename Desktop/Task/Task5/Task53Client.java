/**
 * 基本課題5.3 Task53Client
 * モンテカルロ法で円周率を求めるためのプログラム(クライアント側)
 */
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Task53Client {
	public static void main(String[] args) {
		// コマンドライン引数から接続先サーバのホスト名またはIPアドレスを取得
		String server = args[0];
		// コマンドライン引数からポート番号を取得
		int port = Integer.parseInt(args[1]);

		Socket socket = null;

		try {
			System.out.print("サーバ[" + server + ":" + port +"]に接続中...");
			// ソケットを作成
			socket = new Socket();
			// 指定されたホスト名（IPアドレス）とポート番号でサーバに接続する
			socket.connect(new InetSocketAddress(server, port));

			System.out.println("接続完了");
			System.out.println();

			System.out.print("演算回数を入力> ");
			Scanner scanner = new Scanner(System.in);
			Long numberOfOperations = scanner.nextLong();

			// 接続されたソケットの出力ストリームを取得し，データ出力ストリームを連結
			OutputStream os = socket.getOutputStream();
			DataOutputStream dos = new DataOutputStream(os);

			System.out.println("演算回数を送信中...");
			dos.writeLong(numberOfOperations);
			dos.flush();
			System.out.println();

			// 接続されたソケットの入力ストリームを取得し，データ入力ストリームを連結
			InputStream is = socket.getInputStream();
			DataInputStream dis = new DataInputStream(is);

			// メッセージの受信
			String message = dis.readUTF();

			// 受信したメッセージを表示
			System.out.println(message);

			long computingTime = dis.readLong();	//	処理時間を受信
			double calculationResult = dis.readDouble();	//	演算結果を受信

			System.out.println("サーバが演算を終了しました．");
			System.out.println();

			System.out.println("処理時間=" + computingTime + "ms 演算結果=" + calculationResult);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// ソケットをクローズする
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {}
			}
		}
	}
}
