package kr.or.ddit.utiles;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.HttpSession;

public class CryptoGenerator {
	
	// 암, 복호화 : 공개키 + 비밀키 (생성시 동반 생성, 1회 활용하고 폐기)
	
	// 반환값 : 공개키(가수부, 지수부 구분)
	
	public static Map<String, String> generatePairKey(HttpSession session) {
		// 공개키 + 비밀키 생성
		KeyPairGenerator keyGenerator = null;
		
		// 생성된 공개키 + 비밀키
		KeyPair keyPair = null;
		
		//공개키
		PublicKey publicKey = null;
		
		//비밀키
		PrivateKey privateKey = null;
		
		// 공개키 = 가수부 + 지수부
		KeyFactory keyFactory = null;
		
		Map<String, String> publicKeyMap = new HashMap<String, String>();
		
		try{
			keyGenerator = KeyPairGenerator.getInstance("RSA");
			// 공개키, 비밀키 생성시 사이즈 설정 : byte 단위
			// 사이즈를 결정하는데 반드시 짝수이어야 함
			keyGenerator.initialize(2048);
			
			//생성된 공개키, 비밀키 취득
			keyPair = keyGenerator.generateKeyPair();
			
			//공개키 취득
			publicKey = keyPair.getPublic();
			
			//비밀키 취득
			privateKey = keyPair.getPrivate();
			
			session.setAttribute("privateKey", privateKey);
			
			// 공개키를 가수부와 지수부로 나눠야함
			// 공개키(Double Type) : 가수부 + 지수부 => 클라이언트에 제공
			// ex) -143.12344556
			// float(32bit 단정도 소수) : 부호비트 1bit(양수 0 | 음수 1) + 지수 8bit(소숫점 자리수) + 가수 23bit(실수 표현) 
			// double(64bit 배정도 소수) : 부호비트 1bit(양수 0 | 음수 1) + 지수 11bit(소숫점 자리수) + 가수 52bit(실수 표현)
			
			// 공개키가 어떤 알고리즘으로 되어있는지 설정
			keyFactory = KeyFactory.getInstance("RSA");
			
			RSAPublicKeySpec publicKeySpec = (RSAPublicKeySpec)keyFactory.getKeySpec(publicKey, RSAPublicKeySpec.class);
			
			
			// 공개키 가수부
			String publicModulus = publicKeySpec.getModulus().toString(16);
			
			// 공개키 지수부
			String publicExponent = publicKeySpec.getPublicExponent().toString(16);
			
			publicKeyMap.put("publicModulus", publicModulus);
			publicKeyMap.put("publicExponent", publicExponent);
					
			
			
		}catch(NoSuchAlgorithmException e1){
			e1.printStackTrace();
		}catch(InvalidKeySpecException e2){
			e2.printStackTrace();
		}
		return publicKeyMap;
	}
	
	//암호문을 평문으로 복호화
	public static String decryptRSA(HttpSession session, String secureValue){
		
		String returnValue = "";
		PrivateKey privateKey = (PrivateKey) session.getAttribute("privateKey");
		try{
			// 평문으로 바꿀 때?
			Cipher cipher = Cipher.getInstance("RSA"); //암호문이 어떤 암호화 방식으로 전달되었는지
			cipher.init(Cipher.DECRYPT_MODE, privateKey);
		
			// 암호문은 짝수 단위로 바이너리 코드로 존재
			// hextoByteArray라는 메소드는 직접 만들어야함
			byte[] targetByte = hextoByteArray(secureValue);
			
			byte[] beforeString = cipher.doFinal(targetByte);
			
			returnValue = new String(beforeString, "UTF-8");
			
		  } catch (NoSuchAlgorithmException e) {
		         e.printStackTrace();
		      } catch (NoSuchPaddingException e) {
		         e.printStackTrace();
		      } catch (InvalidKeyException e) {
		         e.printStackTrace();
		      } catch (IllegalBlockSizeException e) {
		         e.printStackTrace();
		      } catch (BadPaddingException e) {
		         e.printStackTrace();
		      } catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		return returnValue;
	}

	private static byte[] hextoByteArray(String secureValue) {
		
		// 암호문이 null이거나 짝수가 아니면 암호문이 암호화 에러.
		if(secureValue == null || secureValue.length()%2 != 0){
			return new byte[]{};
		}
		
		byte[] bytes = new byte[secureValue.length()/2];
		
		for(int i = 0; i < secureValue.length(); i+=2){
			byte value = (byte)Integer.parseInt(secureValue.substring(i,i+2), 16);
			bytes[(int)Math.floor(i/2)] = value;
			
		}
		return bytes;
	}

}
