package com.willow.common.util;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.Random;

/**
 * @ClassName: GenerateUtil
 * @Description: 生成字符串工具类
 * @author Eric
 * @date 2015年6月2日 下午4:41:06
 */
public class GenerateUtil {

    public static final String RANDOM_STRING  = new String("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ");

    public static final String CHARS          = new String("0123456789abcdefg");

    public static final String MOBILE_CAPTCHA = new String("0123456789");


    /**
     * 生成位数为size的随机字符串
     *
     * @return
     */
    public static String creatRandom(int size) {
        if (size <= 0) {
            size = 1;
        }
        StringBuffer buffer = new StringBuffer(RANDOM_STRING);
        StringBuffer sb = new StringBuffer();
        Random r = new Random();
        int range = buffer.length();
        for (int i = 0; i < size; i++) {
            sb.append(buffer.charAt(r.nextInt(range)));
        }
        return sb.toString();
    }

    /**
     * 生成cmcustomer的apikey字段
     *
     * @param length
     * @return
     */
    public static String getRandKey(int length) {
        if (length <= 0) {
            length = 1;
        }
        StringBuffer buffer = new StringBuffer(CHARS);
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        int range = buffer.length();
        for (int i = 0; i < length; i++) {
            sb.append(buffer.charAt(random.nextInt(range)));
        }
        return sb.toString();
    }
    
    /**
     * 得到验证码
     *
     * @param length
     * @return
     */
    public static String getcaptcha(int length) {
        if (length <= 0) {
            length = 1;
        }
        StringBuffer buffer = new StringBuffer(MOBILE_CAPTCHA);
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        int range = buffer.length();
        for (int i = 0; i < length; i++) {
            sb.append(buffer.charAt(random.nextInt(range)));
        }
        return sb.toString();
    }
    
    /**
     * 加密/解密用户名的登陆密码和支付密码
     *
     * @return
     */
    public static String genMd5Pass(String password,String username){
        return DigestUtils.md5Hex(password + username);
    }
    
    public static void main(String[] args) {
		System.out.println(genMd5Pass("123qwe", "jialj"));
	}
}
