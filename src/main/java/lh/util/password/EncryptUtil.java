package lh.util.password;


import lh.util.MD5Code;

public class EncryptUtil {

	public static String getPwd(String password) { 
		return new MD5Code().getMD5ofStr(password );
	}
}
