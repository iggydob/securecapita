package com.example.securecapita.utils;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import static com.twilio.rest.api.v2010.account.Message.creator;


public class SmsUtils {
    public static final String FROM_NUMBER = "+14255878574";
    public static final String ACCOUNT_SID = "VA2028f89535ac2ac4771cc205c173ee5f";
    public static final String AUTH_TOKEN = "2b269e065fb9087b8ab8d93b7012eca8";


    public static void sendSMS(String to, String messageBody){
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = creator(new PhoneNumber("+359889896673"), new PhoneNumber(FROM_NUMBER), messageBody).create();
        System.out.println(message.getSid());
    }
}
