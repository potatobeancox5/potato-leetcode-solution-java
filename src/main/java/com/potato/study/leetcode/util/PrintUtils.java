package com.potato.study.leetcode.util;

/**
 * 输出工具类，输出一些好玩的东西
 */
public class PrintUtils {
    /**
     * 输出一尊大佛
     */
    private static void printSuccessAndNeverBug() {
        StringBuilder builder = new StringBuilder();
        builder.append("\n");
        builder.append("                   _ooOoo_  \n");
        builder.append("                  o8888888o\n");
        builder.append("                  88\" . \"88\n");
        builder.append("                  (| -_- |)\n");
        builder.append("                  O\\  =  /O\n");
        builder.append("               ____/`---'\\____\n");
        builder.append("             .'  \\\\|     |//  `.\n");
        builder.append("            /  \\\\|||  :  |||//  \\ \n");
        builder.append("           /  _||||| -:- |||||-  \\ \n");
        builder.append("           |   | \\\\\\  -  /// |   |\n");
        builder.append("           | \\_|  ''\\---/''  |   |\n");
        builder.append("           \\  .-\\__  `-`  ___/-. /\n");
        builder.append("         ___`. .'  /--.--\\  `. . __\n");
        builder.append("      .\"\" '<  `.___\\_<|>_/___.'  >'\"\".\n");
        builder.append("     | | :  `- \\`.;`\\ _ /`;.`/ - ` : | |\n");
        builder.append("     \\  \\ `-.   \\_ __\\ /__ _/   .-` /  /\n");
        builder.append("======`-.____`-.___\\_____/___.-`____.-'======\n");
        builder.append("                   `=---='\n");
        builder.append("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n");
        builder.append("             佛祖保佑       永无BUG\n");
        System.out.println(builder.toString());
    }

    public static void main(String[] args) {
        printSuccessAndNeverBug();
    }
}
