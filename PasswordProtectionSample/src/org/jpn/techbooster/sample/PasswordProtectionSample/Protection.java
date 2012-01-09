package org.jpn.techbooster.sample.PasswordProtectionSample;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import android.content.Context;
import android.content.ContextWrapper;

public class Protection extends ContextWrapper {
	public Protection(Context base) {
		super(base);
	}

	private byte[] _key_byte = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,
			14, 15 };

	/**
	 * カギを作成する
	 * 
	 * @return 鍵オブジェクト
	 */
	public SecretKeySpec createKey() {
		SecretKeySpec key = new SecretKeySpec(_key_byte, "AES");
		return key;
	}

	/**
	 * @param pStr
	 *            暗号化対象文字列
	 * @param key
	 *            暗号化用鍵
	 * @return 暗号化された文字列
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws InvalidKeyException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 * @throws IOException
	 */
	public byte[] protect(String pStr, SecretKeySpec key)
			throws NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidKeyException, IllegalBlockSizeException,
			BadPaddingException, IOException {
		// AESアルゴリズムでCipherオブジェクトを作成
		Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
		// Cipherオブジェクトに秘密鍵を設定
		c.init(Cipher.ENCRYPT_MODE, key);
		// 暗号化
		byte[] protectedStr = c.doFinal(pStr.getBytes());
		// IVをファイルとして保存
		FileOutputStream out = openFileOutput("IV", MODE_PRIVATE);
		out.write(c.getIV());
		return protectedStr;
	}

	public String decrypt(byte[] dStr, SecretKeySpec key)
			throws NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidKeyException, IllegalBlockSizeException,
			BadPaddingException, InvalidAlgorithmParameterException,
			IOException {
		Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
		// IVの読み込み
		byte[] iv = null;
		FileInputStream in = openFileInput("IV");
		iv = new byte[in.available()];
		in.read(iv);
		// 読み込んだバイトを使用できる形に変換
		IvParameterSpec ips = new IvParameterSpec(iv);
		// 秘密鍵を複合化モードで初期化
		c.init(Cipher.DECRYPT_MODE, key, ips);
		// 復号化
		byte[] decryptStr = c.doFinal(dStr);
		return new String(decryptStr);
	}
}
