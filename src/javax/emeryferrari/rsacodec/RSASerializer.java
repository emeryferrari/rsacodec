package javax.emeryferrari.rsacodec;
import java.io.*;
import java.math.*;
import java.nio.file.*;
import java.security.*;
import java.security.spec.*;
import java.security.interfaces.*;
public class RSASerializer {
	public static final void savePublicKey(PublicKey key, String path) throws IOException {
		RSAPublicKey pk = (RSAPublicKey) key;
		String decodedKey = pk.getModulus().toString() + "|" + pk.getPublicExponent().toString();
		Files.deleteIfExists(Paths.get(path));
		Files.write(Paths.get(path), decodedKey.getBytes());
	}
	public static final PublicKey loadPublicKey(String path) throws IOException, InvalidKeySpecException, NoSuchAlgorithmException {
		StringBuilder sb = new StringBuilder();
		BufferedReader reader = Files.newBufferedReader(Paths.get(path));
		String line;
		while ((line = reader.readLine()) != null) {
			sb.append(line).append("\n");
		}
		String decodedKey = sb.toString();
		String[] parts = decodedKey.split("\\|");
		RSAPublicKeySpec spec = new RSAPublicKeySpec(new BigInteger(parts[0]), new BigInteger(parts[1]));
		return KeyFactory.getInstance("RSA").generatePublic(spec);
	}
	public static final void savePrivateKey(PrivateKey key, String path) throws IOException {
		RSAPrivateKey prk = (RSAPrivateKey) key;
		String decodedKey = prk.getModulus().toString() + "|" + prk.getPrivateExponent().toString();
		Files.deleteIfExists(Paths.get("path"));
		Files.write(Paths.get(path), decodedKey.getBytes());
	}
	public static final PrivateKey loadPrivateKey(String path) throws IOException, InvalidKeySpecException, NoSuchAlgorithmException {
		StringBuilder sb = new StringBuilder();
		BufferedReader reader = Files.newBufferedReader(Paths.get(path));
		String line;
		while ((line = reader.readLine()) != null) {
			sb.append(line).append("\n");
		}
		String decodedKey = sb.toString();
		String[] parts = decodedKey.split("\\|");
		RSAPrivateKeySpec spec = new RSAPrivateKeySpec(new BigInteger(parts[0]), new BigInteger(parts[1]));
		return KeyFactory.getInstance("RSA").generatePrivate(spec);
	}
}