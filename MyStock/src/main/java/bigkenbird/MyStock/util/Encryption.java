package bigkenbird.MyStock.util;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

@SuppressWarnings("restriction")
public class Encryption {
	
	private static KeyGenerator keygen; //提供對稱金鑰生成器，支援各種演算法
	
	private static SecretKey deskey;//儲存對稱金鑰
	
	private static Cipher c;//該位元陣列負責儲存加密過的值
	
	private static byte[] cipherByte; //儲存加密結果
	
	static { //初始化金鑰
		Security.addProvider(new com.sun.crypto.provider.SunJCE());//例項化支援DES演算法的金鑰生成器(演算法名稱命名需按規定，否則丟擲異常)
		try {
			keygen = KeyGenerator.getInstance("DES");//生成金鑰
			deskey = keygen.generateKey();
			c = Cipher.getInstance("DES");
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//加密
	public byte[] Encrytor(String password) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		c.init(Cipher.ENCRYPT_MODE,deskey);
		byte[] src=password.getBytes();
		cipherByte=c.doFinal(src);
		return cipherByte;
	}
	
	//解密
	public byte[] Decryptor(byte[] buff) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		// 根據金鑰，對Cipher物件進行初始化，DECRYPT_MODE表示加密模式
		c.init(Cipher.DECRYPT_MODE, deskey);
		cipherByte = c.doFinal(buff);
		return cipherByte;
	}
	
	
	
	

}
