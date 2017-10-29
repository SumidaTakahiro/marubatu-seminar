package marubatu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class marubatugame {

	static char[] board = new char[9];

	/*
	 * 各メソッドを呼び出す
	 */

	public static void main(String[] args) throws IOException {

		番号の表示();

		char board[] = 初期ボードの設定();

		ボードを表示(board);

		String 先攻 = 順番を決める();

		System.out.println(先攻 + "から書いてください");

		board = ゲームを実行(board, 先攻);

		結果表示(board);

	}

	/*
	 * ゲームを実行させる
	 */
	static char[] ゲームを実行(char[] board, String 先攻) throws IOException {

		int i = 1;

		if (先攻.equals("マル")) {

			while (i > 0) {

				board = マルを書く(board);

				if (判定(board) == true)
					break;

				バツを書く(board);

				if (判定(board) == true)
					break;

			}

		}

		else {

			while (i > 0) {

				バツを書く(board);

				if (判定(board) == true)
					break;

				マルを書く(board);

				if (判定(board) == true)
					break;

			}

		}
		return board;

	}

	/*
	 * 盤面に振り分けられた番号を表示させる
	 */
	static void 番号の表示() {

		System.out.println("盤面の番号は以下の通りです");

		int[] number = new int[9];

		for (int i = 0; i < 9; i++) {

			System.out.print(i + 1 + " ");

			if (i == 2 || i == 5 || i == 8) {

				System.out.println();

			}

		}

		System.out.println();

	}

	/*
	 * ボードを初期化する
	 */
	static char[] 初期ボードの設定() {

		for (int i = 0; i < 9; i++) {

			board[i] = '□';

		}
		return board;

	}

	/*
	 * 現在の盤面の状況を表示する
	 */
	static void ボードを表示(char[] board) {

		for (int i = 0; i < 9; i++) {

			System.out.print(board[i]);

			if (i == 2 || i == 5 || i == 8) {

				System.out.println();

			}

		}

	}

	/*
	 * どちらが先攻かを決める
	 */
	static String 順番を決める() {

		Random r = new Random();

		int a = r.nextInt(2);

		if (a == 0)
			return "マル";

		else
			return "バツ";

	}

	/*
	 * 盤面に〇を書き、盤面の状況を表示
	 */
	static char[] マルを書く(char[] board) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("空白のマスの中で〇を書きたい場所を選んでください");

		ボードを表示(board);

		int num = Integer.parseInt(br.readLine());

		if (board[num - 1] == '□') {

			board[num - 1] = '〇';

		} else {

			System.out.println("ほかのところを選んでください");

		}
		return board;

	}

	/*
	 * 盤面に×を書き、盤面の状況を表示
	 */
	static char[] バツを書く(char[] board) throws IOException {

		System.out.println("空白のマスの中で×を書きたい場所を選んでください");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		ボードを表示(board);

		int num = Integer.parseInt(br.readLine());

		if (board[num - 1] == '□') {

			board[num - 1] = '×';

		} else {

			System.out.println("ほかのところを選んでください");

		}
		return board;

	}

	/*
	 * 勝敗がついたか、引き分けになったかの判定を行う
	 */
	static boolean 判定(char board[]) {

		if (board[0] == '〇' && board[1] == '〇' && board[2] == '〇' ||

				board[3] == '〇' && board[4] == '〇' && board[5] == '〇' ||

				board[6] == '〇' && board[7] == '〇' && board[8] == '〇' ||

				board[0] == '〇' && board[4] == '〇' && board[8] == '〇' ||

				board[2] == '〇' && board[4] == '〇' && board[6] == '〇' ||

				board[0] == '〇' && board[3] == '〇' && board[6] == '〇' ||

				board[1] == '〇' && board[4] == '〇' && board[7] == '〇' ||

				board[2] == '〇' && board[5] == '〇' && board[8] == '〇')

			return true;

		if (board[0] == '×' && board[1] == '×' && board[2] == '×' ||

				board[3] == '×' && board[4] == '×' && board[5] == '×' ||

				board[6] == '×' && board[7] == '×' && board[8] == '×' ||

				board[0] == '×' && board[4] == '×' && board[8] == '×' ||

				board[2] == '×' && board[4] == '×' && board[6] == '×' ||

				board[0] == '×' && board[3] == '×' && board[6] == '×' ||

				board[1] == '×' && board[4] == '×' && board[7] == '×' ||

				board[2] == '×' && board[5] == '×' && board[8] == '×')

			return true;

		else {

			for (int i = 0; i < 9; i++) {

				if (board[i] == '□') {

					return false;

				}

			}
			return true;

		}

	}

	/*
	 * ゲームの結果を表示する
	 */
	static void 結果表示(char[] board) {

		if (board[0] == '〇' && board[1] == '〇' && board[2] == '〇' ||

				board[3] == '〇' && board[4] == '〇' && board[5] == '〇' ||

				board[6] == '〇' && board[7] == '〇' && board[8] == '〇' ||

				board[0] == '〇' && board[4] == '〇' && board[8] == '〇' ||

				board[2] == '〇' && board[4] == '〇' && board[6] == '〇' ||

				board[0] == '〇' && board[3] == '〇' && board[6] == '〇' ||

				board[1] == '〇' && board[4] == '〇' && board[7] == '〇' ||

				board[2] == '〇' && board[5] == '〇' && board[8] == '〇') {

			System.out.println();

			System.out.println("〇の勝ちです");

		}

		else if (board[0] == '×' && board[1] == '×' && board[2] == '×' ||

				board[3] == '×' && board[4] == '×' && board[5] == '×' ||

				board[6] == '×' && board[7] == '×' && board[8] == '×' ||

				board[0] == '×' && board[4] == '×' && board[8] == '×' ||

				board[2] == '×' && board[4] == '×' && board[6] == '×' ||

				board[0] == '×' && board[3] == '×' && board[6] == '×' ||

				board[1] == '×' && board[4] == '×' && board[7] == '×' ||

				board[2] == '×' && board[5] == '×' && board[8] == '×') {

			System.out.println();

			System.out.println("×の勝ちです");

		}

		else {

			System.out.println();

			System.out.println("引き分けです");

		}

		System.out.println();

		System.out.println("最終盤面はこうなりました");

		ボードを表示(board);

	}

}