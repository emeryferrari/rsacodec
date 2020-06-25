package com.emeryferrari.rsacodec;
import java.io.*;
import java.nio.file.*;
import java.security.*;
import java.security.interfaces.*;
public class RSASerializer {
	public static final void savePublicKey(PublicKey key, String path) throws IOException {
		RSAPublicKey pk = (RSAPublicKey) key;
		Files.deleteIfExists(Paths.get(path));
		FileOutputStream fos = new FileOutputStream(path);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(pk);
		oos.flush();
		fos.flush();
		oos.close();
		fos.close();
	}
	public static final PublicKey loadPublicKey(String path) throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream(path);
		ObjectInputStream ois = new ObjectInputStream(fis);
		RSAPublicKey pk = (RSAPublicKey) ois.readObject();
		ois.close();
		fis.close();
		return pk;
	}
	public static final void savePrivateKey(PrivateKey key, String path) throws IOException {
		RSAPrivateKey prk = (RSAPrivateKey) key;
		Files.deleteIfExists(Paths.get("path"));
		FileOutputStream fos = new FileOutputStream(path);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(prk);
		oos.flush();
		fos.flush();
		oos.close();
		fos.close();
	}
	public static final PrivateKey loadPrivateKey(String path) throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream(path);
		ObjectInputStream ois = new ObjectInputStream(fis);
		RSAPrivateKey prk = (RSAPrivateKey) ois.readObject();
		ois.close();
		fis.close();
		return prk;
	}
}