package com.ventura.util;

public interface ConsoleEffect {

//	Text Format:
	String reset = "\u001B[0m";
	String bold = "\u001B[1m";
	String underline = "\u001B[4m";

//	Text Colors:
	String black = "\u001B[30m";
	String red = "\u001B[31m";
	String green = "\u001B[32m";
	String yellow = "\u001B[33m";
	String blue = "\u001B[34m";
	String magenta = " \u001B[35m";
	String cyan = "\u001B[36m";
	String white = "\u001B[37m";

//	Bright Text Colors:
	String bblack = "\u001B[90m";
	String bred = "\u001B[91m";
	String bgreen = "\u001B[92m";
	String byellow = "\u001B[93m";
	String bblue = "\u001B[94m";
	String bmagenta = "\u001B[95m";
	String bcyan = "\u001B[96m";
	String bwhite = "\u001B[97m";

//	Background colors
	String blackBg = "\u001B[40m";
	String redBg = "\u001B[41m";
	String greenBg = "\u001B[42m";
	String yellowBg = "\u001B[43m";
	String blueBg = "\u001B[44m";
	String magentaBg = "\u001B[45m";
	String cyanBg = "\u001B[46m";
	String whiteBg = "\u001B[47m";

//	Bright Background colors
	String bblackBg = "\u001B[100m";
	String bredBg = "\u001B[101m";
	String bgreenBg = "\u001B[102m";
	String byellowBg = "\u001B[103m";
	String bblueBg = "\u001B[104m";
	String bmagentaBg = "\u001B[105m";
	String bcyanBg = "\u001B[106m";
	String bwhiteBg = "\u001B[107m";

}