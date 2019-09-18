package com.jslsolucoes.tagria.formatter.v4;

import java.util.Locale;

public interface Formatter {

    public String format(String type,String value,Locale locale);
    
    public Boolean accepts(String type);
}
