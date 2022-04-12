package com.demoqa;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;


public class PhoneNumberHelper {
    public static String extractPhoneWithoutCountryCode(String phone) {
        PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
        String number;
        try {
            Phonenumber.PhoneNumber numberProto =
                    phoneUtil.parse(phone, "");
            number = Long.toString(numberProto.getNationalNumber());
        } catch (NumberParseException e) {


            return "";
        }
        return number;
    }
}