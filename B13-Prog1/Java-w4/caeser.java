public class caeser {
	public static char encryptCharacter(char c, int offset) {
		if (!isLetter(c)) return c;

		int normalisedOffset = offset % 26;
		int encryptedChar = c + normalisedOffset;

		if (c >= 65 && c <= 90) {
			if (encryptedChar < 65) encryptedChar += 26;
			if (encryptedChar > 90) encryptedChar -= 26;
		}

		if (c >= 97 && c <= 122) {
			if (encryptedChar < 97) encryptedChar += 26;
			if (encryptedChar > 122) encryptedChar -= 26;
		}

		return (char)encryptedChar;
	}
	
	public static char decryptCharacter(char c, int offset) {
		return encryptCharacter(c, -offset);
	}
	
	public static boolean isLetter(char c) {
        return Character.isLetter(c);
	}

	public static boolean isLowerCase(char c) {
		if (!isLetter(c)) return false;
		return c == (Character.toLowerCase(c));
	}

	public static boolean isUpperCase(char c) {
		if (!isLetter(c)) return false;
		return c == (Character.toUpperCase(c));
	}

	public static void main(String[] args) {
		
	}
}
