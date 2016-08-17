
public class Driver {

	public static void main(String[] args) {
		// Prints Usage if missing arguments
		if (args.length < 3) {
			System.out.println("Usage: -e (encrypt) | -d (decrypt) <INPUT> <OUTPUT> <OFFSET>");
			System.out.println("Example: -e important.txt secret.txt 5");
			System.exit(0);
		}

		CaesarCipher cipher = new CaesarCipher();
		String operation = args[0].replaceAll("-", "");
		cipher.generateCipherFile(operation, args[1], args[2], Integer.valueOf(args[3]));
	}

}
