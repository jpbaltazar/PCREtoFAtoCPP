package CodeGenerator.Options;

public class DecoderOptions {
    public boolean functionDecoder = true;
    public boolean preDisambiguationDecoder = true;
    public boolean functionSwitchDecoder = true; //false for if-else chain
    public boolean setBitScheme = false; //horrible performance, no resource gain DO NOT USE
}
