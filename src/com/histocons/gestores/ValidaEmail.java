package com.histocons.gestores;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ValidaEmail {
	private static boolean valido;
public static boolean esEmailCorrecto(String email) {
        
        Pattern patronEmail = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
    
        Matcher mEmail = patronEmail.matcher(email.toLowerCase());
        if (mEmail.matches())
        {
        	valido = true;
        	return valido;
        }
        else
        {
        	valido = false;
        	return valido;
        }
    }
}
