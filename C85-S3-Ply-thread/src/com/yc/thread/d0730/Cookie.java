package com.yc.thread.d0730;

public class Cookie {

	private String name;
	private String value;

	public Cookie(String name, String value) {
		this.name = name;
		this.value = value;
	}

	public String toString() {
		String s = "Set-Cookie: %s=%s;\n";
		s = String.format(s, name, value);
		return s;
	}

}
