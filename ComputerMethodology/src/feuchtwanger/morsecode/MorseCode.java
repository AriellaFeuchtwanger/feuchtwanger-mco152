package feuchtwanger.morsecode;

public class MorseCode {

	private String[][] code;

	public MorseCode() {
		code = new String[36][2];

		// Put everything in a two dimensional array - The first
		// column will contain the letters while the second will
		// contain the code for each letter
		code[0][0] = "A";
		code[1][0] = "B";
		code[2][0] = "C";
		code[3][0] = "D";
		code[4][0] = "E";
		code[5][0] = "F";
		code[6][0] = "G";
		code[7][0] = "H";
		code[8][0] = "I";
		code[9][0] = "J";
		code[10][0] = "K";
		code[11][0] = "L";
		code[12][0] = "M";
		code[13][0] = "N";
		code[14][0] = "O";
		code[15][0] = "P";
		code[16][0] = "Q";
		code[17][0] = "R";
		code[18][0] = "S";
		code[19][0] = "T";
		code[20][0] = "U";
		code[21][0] = "V";
		code[22][0] = "W";
		code[23][0] = "X";
		code[24][0] = "Y";
		code[25][0] = "Z";
		code[26][0] = "1";
		code[27][0] = "2";
		code[28][0] = "3";
		code[29][0] = "4";
		code[30][0] = "5";
		code[31][0] = "6";
		code[32][0] = "7";
		code[33][0] = "8";
		code[34][0] = "9";
		code[35][0] = "0";

		code[0][1] = ".-";
		code[1][1] = "-...";
		code[2][1] = "-.-.";
		code[3][1] = "-..";
		code[4][1] = ".";
		code[5][1] = "..-.";
		code[6][1] = "--.";
		code[7][1] = "....";
		code[8][1] = "..";
		code[9][1] = ".---";
		code[10][1] = "-.-";
		code[11][1] = ".-..";
		code[12][1] = "--";
		code[13][1] = "-.";
		code[14][1] = "---";
		code[15][1] = ".--.";
		code[16][1] = "--.-";
		code[17][1] = ".-.";
		code[18][1] = "...";
		code[19][1] = "-";
		code[20][1] = "..-";
		code[21][1] = "...-";
		code[22][1] = ".--";
		code[23][1] = "-..-";
		code[24][1] = "-.--";
		code[25][1] = "--..";
		code[26][1] = ".----";
		code[27][1] = "..---";
		code[28][1] = "...--";
		code[29][1] = "....-";
		code[30][1] = ".....";
		code[31][1] = "-....";
		code[32][1] = "--...";
		code[33][1] = "---..";
		code[34][1] = "----.";
		code[35][1] = "-----";
	}

	public String encode(String message) {
		String[] tokens = message.split(" ");
		String[][] symbols = new String[tokens.length][];

		for (int i = 0; i < tokens.length; i++) {
			symbols[i] = tokens[i].split("");
			for (int j = 0; j < symbols[i].length; j++) {
				for (int k = 0; k < 36; k++) {
					if (this.code[k][0].equalsIgnoreCase(symbols[i][j])) {
						symbols[i][j] = String.valueOf(this.code[k][1]);
						break;
					}
				}
			}
		}
		
		String code = "";
		for (int i = 0; i < symbols.length; i++) {
			for (int j = 0; j < symbols[i].length; j++) {
				code = code + symbols[i][j] + " ";
			}
			code += "   ";
		}
		return code;
	}

	public String decode(String code) {
		String[] words = code.split("   ");
		String[][] letters = new String[words.length][];

		for (int i = 0; i < words.length; i++) {
			letters[i] = words[i].split(" ");
			for (int j = 0; j < letters[i].length; j++) {
				for (int k = 0; k < 36; k++) {
					if (this.code[k][1].equalsIgnoreCase(letters[i][j])) {
						letters[i][j] = String.valueOf(this.code[k][0]);
						break;
					}
				}
			}
		}
		
		String message = "";
		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j < letters[i].length; j++) {
				message += letters[i][j];
			}
			message += " ";
		}
		return message;
	}
}
