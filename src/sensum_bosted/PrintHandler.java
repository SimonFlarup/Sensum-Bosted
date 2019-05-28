/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sensum_bosted;

/**
 *
 * @author Simon Holland Flarup
 */
public class PrintHandler {

    private static boolean allow = true;

    public static void print(String output, boolean override) {
        if (allow || override) {
            System.out.print("[" + override + "] " + output);
        }
    }

    public static void println(String output, boolean override) {
        if (allow || override) {
            System.out.println("[" + override + "] " + output);
        }
    }

    public static void print(String output) {
        print(output, false);
    }

    public static void println(String output) {
        println(output, false);
    }

    public static <T> void print(T output) {
        print(output.toString());
    }

    public static <T> void println(T output) {
        println(output.toString());
    }
}
