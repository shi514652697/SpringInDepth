package com.negi.spring.converter;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class CipherInitializer {
	
	private static final String CIPHER_INSTANCE_NAME = "AES/CBC/PKCS5Padding";
	private static final String SECRET_KEY_ALGORITHM= "AES";
	
	public Cipher prepareAndInitCipher(int encryptionMode, String key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException
	{
		Cipher cipher = Cipher.getInstance(CIPHER_INSTANCE_NAME);
		Key secretKey = new SecretKeySpec(key.getBytes(), SECRET_KEY_ALGORITHM);
		
		AlgorithmParameterSpec algoPrams= getAlgoParamsSpec(cipher);
		callCipherInit(cipher,encryptionMode,secretKey,algoPrams);
		return cipher;
	}

	private void callCipherInit(Cipher cipher, int encryptionMode, Key secretKey, AlgorithmParameterSpec algoPrams) throws InvalidKeyException, InvalidAlgorithmParameterException {
        cipher.init(encryptionMode, secretKey, algoPrams);		
	}

	private AlgorithmParameterSpec getAlgoParamsSpec(Cipher cipher) {
		byte[] iv = new byte[getCipherBlockSize(cipher)];
		return new IvParameterSpec(iv);
	}

	private int getCipherBlockSize(Cipher cipher) {
		
		return cipher.getBlockSize();
	}

}
