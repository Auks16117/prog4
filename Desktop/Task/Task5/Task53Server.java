/**
 * 基本課題5.3 Task53Server
 * モンテカルロ法で円周率を求めるためのプログラム(サーバ側)
 */
import java.io.*;
import java.net.*;

public class Task53Server {
	private static final int MAX_CONNECTION = 100;
	private static ServerSocket serverSocket;

	public static void main(String[] args) {
		int port = Integer.parseInt(args[0]);
		Socket socket = null;

		try {
			serverSocket = new ServerSocket();
			serverSocket.setReuseAddress(true);
			// 指定ポート番号にバインド
			serverSocket.bind(new InetSocketAddress(port), MAX_CONNECTION);
			System.out.println("ポート" + port + "番をリッスン中...");

			while (true) {
				// クライアントからの接続要求を待機（クライアント接続するまでブロッキング）
				socket = serverSocket.accept();

				// 接続されたソケットの入力ストリームを取得し，データ入力ストリームを連結
				InputStream is = socket.getInputStream();
				DataInputStream dis = new DataInputStream(is);

				// 接続したクライアントの情報を表示
				showClientInformation(socket);

				System.out.println("クライアントへ演算を開始することを通知します.");

				// 接続されたソケットの出力ストリームを取得し，データ出力ストリームを連結
				OutputStream os = socket.getOutputStream();
				DataOutputStream dos = new DataOutputStream(os);

				// クライアントへ送信するメッセージの作成
				String message = createMessage(socket);

				dos.writeUTF(message);	//	メッセージを送信する
				dos.flush();

				long NumberOfOperations = dis.readLong();	//	演算回数を受信する

				System.out.print("演算回数" + NumberOfOperations +"で円周率を演算開始... ");
				PiCalculator piCalculator = new PiCalculator(NumberOfOperations);
				System.out.println("演算終了");

				System.out.println("クライアントへ演算結果[" + piCalculator.getComputingTime() + "ms " + piCalculator.getCalculationResult() + "]を送信します．");

				dos.writeLong(piCalculator.getComputingTime());	//	処理時間を送信する
				dos.writeDouble(piCalculator.getCalculationResult());	//	演算結果を送信する
				dos.flush();
			}
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

	private static void showClientInformation(Socket socket) throws IOException {
		// クライアントのIPアドレスを取得
		InetAddress address = socket.getInetAddress();
		// クライアントのポート番号を取得
		int port = socket.getPort();

		System.out.println("クライアント[" + address.toString() + ":" + port + "] が接続しました．");
	}

	private static String createMessage(Socket socket) {
		// サーバのホスト名（またはIPアドレス）を取得
		String hostName = socket.getLocalAddress().getHostName();

		String message = "サーバ" + hostName + "が演算を開始しました．";
		return message;
	}

}
