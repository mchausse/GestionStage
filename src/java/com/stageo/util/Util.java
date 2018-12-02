/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stageo.util;

import java.io.File;
import javax.servlet.http.Part;

/**
 *
 * @author moumene
 */
public class Util {
    public static String getFileName(final Part part) {
    String[] t = part.getHeader("content-disposition").split(";");
    for (String content : t) {
        if (content.trim().startsWith("filename")) {
            String s = content.substring(content.indexOf('=') + 1).trim();
            return s.substring(s.lastIndexOf(File.separator) + 1).replace("\"","");
        }
    }
    return null;
}
}
