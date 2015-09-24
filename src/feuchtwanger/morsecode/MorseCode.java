package feuchtwanger.morsecode;

import java.util.HashMap;

public class MorseCode {

	private final HashMap<String, String> code;

	public MorseCode() {
		final String letters[] = new String[36];
		final String symbols[] = new String[36];
		final HashMap<String, String> code = new HashMap<String, String>();

		// Put everything in a two dimensional array - The first
		// column will contain the letters while the second will
		// contain the code for each letter
		letters[0] = "A";
		letters[1] = "B";
		letters[2] = "C";
		letters[3] = "D";
		letters[4] = "E";
		letters[5] = "F";
		letters[6] = "G";
		letters[7] = "H";
		letters[8] = "I";
		letters[9] = "J";
		letters[10] = "K";
		letters[11] = "L";
		letters[12] = "M";
		letters[13] = "N";
		letters[14] = "O";
		letters[15] = "P";
		letters[16] = "Q";
		letters[17] = "R";
		letters[18] = "S";
		letters[19] = "T";
		letters[20] = "U";
		letters[21] = "V";
		letters[22] = "W";
		letters[23] = "X";
		letters[24] = "Y";
		letters[25] = "Z";
		letters[26] = "1";
		letters[27] = "2";
		letters[28] = "3";
		letters[29] = "4";
		letters[30] = "5";
		letters[31] = "6";
		letters[32] = "7";
		letters[33] = "8";
		letters[34] = "9";
		letters[35] = "0";

		symbols[0] = ".-";
		symbols[1] = "-...";
		symbols[2] = "-.-.";
		symbols[3] = "-..";
		symbols[4] = ".";
		symbols[5] = "..-.";
		symbols[6] = "--.";
		symbols[7] = "....";
		symbols[8] = "..";
		symbols[9] = ".---";
		symbols[10] = "-.-";
		symbols[11] = ".-..";
		symbols[12] = "--";
		symbols[13] = "-.";
		symbols[14] = "---";
		symbols[15] = ".--.";
		symbols[16] = "--.-";
		symbols[17] = ".-.";
		symbols[18] = "...";
		symbols[19] = "-";
		symbols[20] = "..-";
		symbols[21] = "...-";
		symbols[22] = ".--";
		symbols[23] = "-..-";
		symbols[24] = "-.--";
		symbols[25] = "--..";
		symbols[26] = ".----";
		symbols[27] = "..---";
		symbols[28] = "...--";
		symbols[29] = "....-";
		symbols[30] = ".....";
		symbols[31] = "-....";
		symbols[32] = "--...";
		symbols[33] = "---..";
		symbols[34] = "----.";
		symbols[35] = "-----";

		for (int i = 0; i < 36; i++) {
			code.put(letters[i], symbols[i]);
			code.put(symbols[i], letters[i]);
		}
		this.code = code;
	}

	public String decode(String message) {
		final String[] words = message.split("   ");
		final String[][] letters = new String[words.length][];

		for (int i = 0; i < words.length; i++) {
			letters[i] = words[i].split(" ");
			for (int j = 0; j < letters[i].length; j++) {
				if (code.containsKey(letters[i][j])) {
					letters[i][j] = code.get(letters[i][j]);
				}
			}
		}

		final StringBuilder builder = new StringBuilder();
		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j < letters[i].length; j++) {
				builder.append(letters[i][j]);
			}
			builder.append(" ");
		}
		return builder.toString().trim();
	}

	public String encode(String message) {
		message.toUpperCase();
		final String[] tokens = message.split(" ");
		final String[][] symbols = new String[tokens.length][];

		for (int i = 0; i < tokens.length; i++) {
			symbols[i] = tokens[i].split("");
			for (int j = 0; j < symbols[i].length; j++) {
				symbols[i][j] = code.get(symbols[i][j]);
			}
		}

		final StringBuilder builder = new StringBuilder();
		for (int i = 0; i < symbols.length; i++) {
			for (int j = 0; j < symbols[i].length; j++) {
				builder.append(symbols[i][j]);
				builder.append(" ");
			}
			builder.append("   ");
		}

		return builder.toString().trim();
	}
}
