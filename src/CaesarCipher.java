import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class CaesarCipher {
	private final char[] alphabet = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
			'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

	/**
	 * encrypt(String plainText, int key)
	 * 
	 * @param plainText
	 *            - Text to be encrypted
	 * @param key
	 *            - Offset key for encryption
	 * @return Encrypted text
	 */
	private String encrypt(String plainText, int key) {
		plainText = plainText.toLowerCase();
		return generateCipher(plainText, key);
	}

	/**
	 * decrypt(String cipherText, int key)
	 * 
	 * @param cipherText
	 *            - Text to be decrypted
	 * @param key
	 *            - Offset key for decryption. Cipher called with the negative
	 *            value to decrypt
	 * @return Decrypted cipherText
	 */
	private String decrypt(String cipherText, int key) {
		return generateCipher(cipherText, -key);
	}

	/**
	 * generateCipher(String text, int key)
	 * 
	 * @param text
	 *            - Text to be encrypted/decrypted
	 * @param key
	 *            - Offset key for encryption/decryption
	 * @return Cipher text after applied offset
	 */
	private String generateCipher(String text, int key) {
		StringBuilder result = new StringBuilder();

		for (char c : text.toCharArray()) {
			// Only apply cipher offset to letter characters
			if (Character.isLetter(c)) {
				result.append(alphabet[getIndex(c, key)]);
			} else {
				result.append(c);
			}
		}

		return result.toString();
	}

	/**
	 * generateCipherFile(String operation, String inputFile, String outputFile,
	 * int key)
	 * 
	 * @param operation
	 *            - Specifies encryption/decryption (e | d)
	 * @param inputFile
	 *            - File to be encrypted/decrypted
	 * @param outputFile
	 *            - Output location
	 * @param key
	 *            - Integer offset for encryption/decryption
	 */
	public void generateCipherFile(String operation, String inputFile, String outputFile, int key) {
		switch (operation) {
		case "e":
			System.out.println("Encrypting File " + inputFile + " --> " + outputFile + "...");
			break;
		case "d":
			System.out.println("Decrypting File " + inputFile + " --> " + outputFile + "...");
			break;
		}

		try {
			BufferedReader reader = new BufferedReader(new FileReader(inputFile));
			PrintWriter pw = new PrintWriter(outputFile);

			String line = null;
			while ((line = reader.readLine()) != null) {
				// System.out.println(line);
				if (operation.equals("e")) {
					pw.println(encrypt(line, key));
				} else if (operation.equals("d")) {
					pw.println(decrypt(line, key));
				}
			}

			pw.flush();
			reader.close();
			System.out.println("Conversion successful. Written to " + outputFile);
		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		}
	}

	/**
	 * getIndex(char c, int key)
	 * 
	 * @param c
	 *            - Character to convert
	 * @param key
	 *            - Offset value
	 * @return Proper index (0 - 25) for provided character
	 */
	private int getIndex(char c, int key) {
		// Translate ASCII value to index value in alphabet
		int index = c - 97;

		// Apply offset and return proper index
		index = (index + key) % 26;

		// Adjust offset index if out of range
		if (index < 0) {
			index += 26;
		} else if (index > 25) {
			index -= 26;
		}

		return index;
	}

}
