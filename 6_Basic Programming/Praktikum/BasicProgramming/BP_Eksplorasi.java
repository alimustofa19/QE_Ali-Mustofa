package BasicProgramming;
public class BP_Eksplorasi {
    public static void main(String[] args) {

        String sepulsa = "SEPULSA OKE";
        String alta = "ALTERRA ACADEMY";
        String indo = "INDONESIA";
        String go = "GOLANG";
        String programmer = "PROGRAMMER";
        int key = 10;
        String[] huruf = new String[30];

        for (char c ='A'; c <= 'Z'; c++)
            huruf[c - 65] = String.valueOf(c);

        System.out.println("Plain Text : " + sepulsa);

        String cipher = "";
        loop1:
        for (int a = 0; a <sepulsa.length(); a++){
            int index_plain = -1;
            for (int b = 0; b < huruf.length; b++){
                index_plain = (String.valueOf(sepulsa.charAt(a)).equals(huruf[b])) ? b :-1;
                if (index_plain != -1){
                    cipher += huruf [(index_plain + key) % 26];
                    continue loop1;
                }
            }
            cipher += sepulsa.charAt(a);
        }
        System.out.println("Cipher Text : " + cipher);

        System.out.println("Plain Text : " + alta);
        String cip = "";
        loop1:
        for (int a = 0; a <alta.length(); a++){
            int index_plain = -1;
            for (int b = 0; b < huruf.length; b++){
                index_plain = (String.valueOf(alta.charAt(a)).equals(huruf[b])) ? b :-1;
                if (index_plain != -1){
                    cip += huruf [(index_plain + key) % 26];
                    continue loop1;
                }
            }
            cip += alta.charAt(a);
        }
        System.out.println("Cipher Text : " + cip);

        System.out.println("Plain Text : " + indo);
        String cpr = "";
        loop1:
        for (int a = 0; a <indo.length(); a++){
            int index_plain = -1;
            for (int b = 0; b < huruf.length; b++){
                index_plain = (String.valueOf(indo.charAt(a)).equals(huruf[b])) ? b :-1;
                if (index_plain != -1){
                    cpr += huruf [(index_plain + key) % 26];
                    continue loop1;
                }
            }
            cpr += indo.charAt(a);
        }
        System.out.println("Cipher Text : " + cpr);

        System.out.println("Plain Text : " + go);
        String ci = "";
        loop1:
        for (int a = 0; a <go.length(); a++){
            int index_plain = -1;
            for (int b = 0; b < huruf.length; b++){
                index_plain = (String.valueOf(go.charAt(a)).equals(huruf[b])) ? b :-1;
                if (index_plain != -1){
                    ci += huruf [(index_plain + key) % 26];
                    continue loop1;
                }
            }
            ci += go.charAt(a);
        }
        System.out.println("Cipher Text : " + ci);

        System.out.println("Plain Text : " + programmer);
        String chiper = "";
        loop1:
        for (int a = 0; a <programmer.length(); a++){
            int index_plain = -1;
            for (int b = 0; b < huruf.length; b++){
                index_plain = (String.valueOf(programmer.charAt(a)).equals(huruf[b])) ? b :-1;
                if (index_plain != -1){
                    chiper += huruf [(index_plain + key) % 26];
                    continue loop1;
                }
            }
            chiper += programmer.charAt(a);
        }
        System.out.println("Cipher Text : " + chiper);
    }
}
