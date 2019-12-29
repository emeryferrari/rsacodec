package javax.emeryferrari.rsacodec;
import java.security.*;
public class Generator {
	public static final KeyPair generateKeyPair(int keysize) throws NoSuchAlgorithmException {
		KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
		kpg.initialize(keysize);
		return kpg.generateKeyPair();
	}
}