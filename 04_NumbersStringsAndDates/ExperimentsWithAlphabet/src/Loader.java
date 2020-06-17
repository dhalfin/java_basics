import java.util.SortedMap;

public class Loader {
    public static void main(String[] args) {

        String engAlphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        //String rusAlphabet = "абвгдеёжзиклмнопрстуфхцчшщъьэюяАБВГДЕЁЖЗИКЛМНОПРСТУФХЦЧШЩЪЬЭЮЯ";

        char a = engAlphabet.charAt(0); int code0 = (int) a;    char A = engAlphabet.charAt(26); int code26 = (int) A;
        char b = engAlphabet.charAt(1); int code1 = (int) b;    char B = engAlphabet.charAt(27); int code27 = (int) B;
        char c = engAlphabet.charAt(2); int code2 = (int) c;    char C = engAlphabet.charAt(28); int code28 = (int) C;
        char d = engAlphabet.charAt(3); int code3 = (int) d;    char D = engAlphabet.charAt(29); int code29 = (int) D;
        char e = engAlphabet.charAt(4); int code4 = (int) e;    char E = engAlphabet.charAt(30); int code30 = (int) E;
        char f = engAlphabet.charAt(5); int code5 = (int) f;    char F = engAlphabet.charAt(31); int code31 = (int) F;
        char g = engAlphabet.charAt(6); int code6 = (int) g;    char G = engAlphabet.charAt(32); int code32 = (int) G;
        char h = engAlphabet.charAt(7); int code7 = (int) h;    char H = engAlphabet.charAt(33); int code33 = (int) H;
        char i = engAlphabet.charAt(8); int code8 = (int) i;    char I = engAlphabet.charAt(34); int code34 = (int) I;
        char j = engAlphabet.charAt(9); int code9 = (int) j;    char J = engAlphabet.charAt(35); int code35 = (int) J;
        char k = engAlphabet.charAt(10); int code10 = (int) k;  char K = engAlphabet.charAt(36); int code36 = (int) K;
        char l = engAlphabet.charAt(11); int code11 = (int) l;  char L = engAlphabet.charAt(37); int code37 = (int) L;
        char m = engAlphabet.charAt(12); int code12 = (int) m;  char M = engAlphabet.charAt(38); int code38 = (int) M;
        char n = engAlphabet.charAt(13); int code13 = (int) n;  char N = engAlphabet.charAt(39); int code39 = (int) N;
        char o = engAlphabet.charAt(14); int code14 = (int) o;  char O = engAlphabet.charAt(40); int code40 = (int) O;
        char p = engAlphabet.charAt(15); int code15 = (int) p;  char P = engAlphabet.charAt(41); int code41 = (int) P;
        char q = engAlphabet.charAt(16); int code16 = (int) q;  char Q = engAlphabet.charAt(42); int code42 = (int) Q;
        char r = engAlphabet.charAt(17); int code17 = (int) r;  char R = engAlphabet.charAt(43); int code43 = (int) R;
        char s = engAlphabet.charAt(18); int code18 = (int) s;  char S = engAlphabet.charAt(44); int code44 = (int) S;
        char t = engAlphabet.charAt(19); int code19 = (int) t;  char T = engAlphabet.charAt(45); int code45 = (int) T;
        char u = engAlphabet.charAt(20); int code20 = (int) u;  char U = engAlphabet.charAt(46); int code46 = (int) U;
        char v = engAlphabet.charAt(21); int code21 = (int) v;  char V = engAlphabet.charAt(47); int code47 = (int) V;
        char w = engAlphabet.charAt(22); int code22 = (int) w;  char W = engAlphabet.charAt(48); int code48 = (int) W;
        char x = engAlphabet.charAt(23); int code23 = (int) x;  char X = engAlphabet.charAt(49); int code49 = (int) X;
        char y = engAlphabet.charAt(24); int code24 = (int) y;  char Y = engAlphabet.charAt(50); int code50 = (int) Y;
        char z = engAlphabet.charAt(25); int code25 = (int) z;  char Z = engAlphabet.charAt(51); int code51 = (int) Z;


        System.out.println(a + " " + code0 + "\n" + b + " " + code1 + "\n" + c + " " + code2 + "\n" + d + " " + code3 + "\n"
                + e + " " + code4 + "\n" + f + " " + code5 + "\n" + g + " " + code6 + "\n" + h + " " + code7 + "\n" + i + " " + code8 + "\n" + g + " " + code9 + "\n"
                + k + " " + code10 + "\n" + l + " " + code11 + "\n" + m + " " + code12 + "\n" + n + " " + code13 + "\n" + o + " " + code14 + "\n" + p + " " + code15 + "\n"
                + q + " " + code16 + "\n" + r + " " + code17 + "\n" + s + " " + code18 + "\n" + t + " " + code19 + "\n" + u + " " + code20 + "\n" + v + " " + code21 + "\n"
                + w + " " + code22 + "\n" + x + " " + code23 + "\n" + y + " " + code24 + "\n" + z + " " + code25 + "\n" + A + " " + code26 + "\n" + B + " " + code27 + "\n"
                + C + " " + code28 + "\n" + D + " " + code29 + "\n" + E + " " + code30 + "\n" + F + " " + code31 + "\n" + G + " " + code32 + "\n" + H + " " + code33 + "\n"
                + I + " " + code34 + "\n" + J + " " + code35 + "\n" + K + " " + code36 + "\n" + L + " " + code37 + "\n" + M + " " + code38 + "\n" + N + " " + code39 + "\n"
                + O + " " + code40 + "\n" + P + " " + code41 + "\n" + Q + " " + code42 + "\n" + R + " " + code43 + "\n" + S + " " + code44 + "\n" + T + " " + code45 + "\n"
                + U + " " + code46 + "\n" + V + " " + code47 + "\n" + W + " " + code48 + "\n" + X + " " + code49 + "\n" + Y + " " + code50 + "\n" + Z + " " + code51);
    }
}
