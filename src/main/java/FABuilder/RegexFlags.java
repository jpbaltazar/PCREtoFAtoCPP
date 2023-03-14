package FABuilder;

public class RegexFlags {
    //DIRECTIVES
    //perl
    public boolean i = false, s = false, m = false, x = false;

    //pcre
    public boolean A = false, E = false, G = false;

    //SNORT
    public boolean R = false, U = false, I = false, P = false;

    public boolean H = false;

    public boolean D = false, M = false, C = false, K = false, S = false, Y = false, B = false, O = false;

    //OTHER FLAGS
    public boolean startOfString = false;

    public RegexFlags(String str) {
        //perl
        if (str.contains("i"))
            i = true;
        if (str.contains("s"))
            s = true;
        if (str.contains("m"))
            m = true;
        if (str.contains("x")) //doesn't happen
            x = true;

        //pcre
        if (str.contains("A"))
            A = true;
        if (str.contains("E"))
            E = true;
        if (str.contains("G"))
            G = true;

        //SNORT
        if (str.contains("R"))
            R = true;
        if (str.contains("U"))
            U = true;
        if (str.contains("I"))
            I = true;
        if (str.contains("P"))
            P = true;

        if(str.contains("H"))
            H = true;

        if(str.contains("D"))
            D = true;
        if(str.contains("M"))
            M = true;
        if(str.contains("C"))
            C = true;
        if(str.contains("K"))
            K = true;
        if(str.contains("S"))
            S = true;
        if(str.contains("Y"))
            Y = true;
        if(str.contains("B"))
            B = true;
        if(str.contains("O"))
            O = true;
    }
}
