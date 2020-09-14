package com.negi.spring.converter;

import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class StringCryptoConverter implements AttributeConverter<String, String> {
	private static String DATABASE_ENCRYPTION_KEY = "Xap13ncrpt10nYZ";
	
	private CipherInitializer cipherInitaitor;

	@Override
	public String convertToDatabaseColumn(String attribute) {
		if(DATABASE_ENCRYPTION_KEY != null
				&& !DATABASE_ENCRYPTION_KEY.equals("")
				&& attribute != null
				&& !attribute.trim().equals(""))
		{
			try
			{
				Cipher cipher = cipherInitaitor.prepareAndInitCipher(Cipher.ENCRYPT_MODE, DATABASE_ENCRYPTION_KEY);
				return encrypt(cipher,attribute);
			}
			catch (Exception e) {
			}
		}
		
		return null;
	}

	private String encrypt(Cipher cipher, String attribute) throws IllegalBlockSizeException, BadPaddingException {
		
		byte[] bytesToEncrpt = attribute.getBytes();
		byte[] encryptedBytes= callCipherDoFinal(cipher,bytesToEncrpt);
		return Base64.getEncoder().encodeToString(encryptedBytes);
	}

	private byte[] callCipherDoFinal(Cipher cipher, byte[] bytesToEncrpt) throws IllegalBlockSizeException, BadPaddingException {
		return cipher.doFinal(bytesToEncrpt);
	}

	@Override
	public String convertToEntityAttribute(String dbData) {
		if(DATABASE_ENCRYPTION_KEY != null
				&& !DATABASE_ENCRYPTION_KEY.equals("")
				&& dbData != null
				&& !dbData.trim().equals(""))
		{
			try
			{
				Cipher cipher = cipherInitaitor.prepareAndInitCipher(Cipher.DECRYPT_MODE, DATABASE_ENCRYPTION_KEY);
				return decrypt(cipher,dbData);
			}
			catch (Exception e) {
			}
		}
		
		return null;
	}

	private String decrypt(Cipher cipher, String dbData) throws IllegalBlockSizeException, BadPaddingException {
		
		byte[] encryptedBytes= Base64.getDecoder().decode(dbData);
		byte[] decryptedBytes= callCipherDoFinal(cipher, encryptedBytes);
		return new String(decryptedBytes);
		
	}

}
