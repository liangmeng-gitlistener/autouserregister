package com.gtzz.autouserregister.utils;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: create by zhaopan
 * @version: v1.0
 * @description: cn.cncommdata.authorization.utils
 * @date:2019/5/6
 **/
public class AuthStringUtil {

    /**
     * @param args args
     */
    public static void main(String[] args) {

        String numRandom = AuthStringUtil.getNumRandom("6");
        Boolean phoneBoolean = AuthStringUtil.checkPhoneFromat("13188888888");
        Boolean emailBoolean = AuthStringUtil.checkEmailFormat("sdfafa32123@gmail.com");

        System.out.println(numRandom);
        System.out.println(phoneBoolean);
        System.out.println(emailBoolean);
    }

    /**
     * 获取随机生成字符串
     *
     * @param length 长度
     * @return String
     * @author zhaopan
     */
    public static final String getStringRandom(String length) {

        int i = Integer.parseInt(length);

        return getStringRandom(i);
    }

    /**
     * 生成随机用户名，数字和字母组成
     *
     * @param length 长度
     * @return String
     * @author zhaopan
     */
    public static final String getStringRandom(int length) {

        String val = "";
        Random random = new Random();

        //参数length，表示生成几位随机数
        for (int i = 0; i < length; i++) {

            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            //输出字母还是数字
            if ("char".equalsIgnoreCase(charOrNum)) {
                //输出是大写字母还是小写字母
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val += (char) (random.nextInt(26) + temp);
            } else if ("num".equalsIgnoreCase(charOrNum)) {
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }

    /**
     * 获取随机数字
     *
     * @param length 长度
     * @return string
     * @author zhaopan
     */
    public static String getNumRandom(String length) {

        // 生成随机6位码
        String num = "";

        while (num.length() < Integer.parseInt(length)) {
            num += (int) (Math.random() * 10);
        }

        return num;
    }


    /**
     * 检查邮箱格式
     *
     * @param email 邮箱
     * @return Boolean
     * @author zhaopan
     */
    public static final Boolean checkEmailFormat(String email) {

        String check = "^[A-Za-z\\d]+([-_.][A-Za-z\\d]+)*@([A-Za-z\\d]+[-.])+[A-Za-z\\d]{2,4}$";
        Pattern regex = Pattern.compile(check);
        Matcher matcher = regex.matcher(email);
        boolean isMatched = matcher.matches();

        return isMatched;
    }

    /**
     * 检查手机格式
     *
     * @param phone 手机号
     * @return Boolean
     * @author zhaopan
     */
    public static final Boolean checkPhoneFromat(String phone) {

        /*
         * 正则：手机号（精确）
         * <p>移动：134(0-8)、135、136、137、138、139、147、150、151、152、157、158、159、178、182、183、184、187、188、198</p>
         * <p>联通：130、131、132、145、155、156、175、176、185、186、166</p>
         * <p>电信：133、153、173、177、180、181、189、199</p>
         * <p>全球星：1349</p>
         * <p>虚拟运营商：170</p>
         */
        String check = "^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\\d{8}$";
        Pattern regex = Pattern.compile(check);
        Matcher matcher = regex.matcher(phone);
        boolean isMatched = matcher.matches();

        return isMatched;
    }
}
