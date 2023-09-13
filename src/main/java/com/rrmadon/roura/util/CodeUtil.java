package com.rrmadon.roura.util;

import net.bytebuddy.utility.RandomString;

import java.io.Serializable;

public class CodeUtil implements Serializable {

	public static String generate() {
		return RandomString.make(10).toUpperCase();
	}
}
