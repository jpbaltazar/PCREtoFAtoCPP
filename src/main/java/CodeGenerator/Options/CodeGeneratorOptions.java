package CodeGenerator.Options;

import CodeGenerator.CodeGenerator;

public class CodeGeneratorOptions {
    public String filename;
    public int payloadSize = 1; //default is 1?
    public boolean softwareCompile = false; //default false
    //public int counterBitSize = 12; // default 0-4095 values

    public boolean createDecoder = true; //default true
    public DecoderOptions decoderOptions = new DecoderOptions();


    public boolean functionStateAction = true; //false generates table
    public StateActionOptions stateActionOptions = new StateActionOptions();

    public boolean createDefaultTestbench = false; //not created by default
    public TestbenchSettings testbenchSettings = new TestbenchSettings();

    public boolean ifElseORSwitch = true; //default is ifElse (true)
    public DFAOptions dfaOptions = new DFAOptions();

    // memory <-512b-> stagingIn <-8b-> processing <-outWidth-> stagingOut <-512b-> memory
    public int stagingBufferBitWidth = 512;

    public CodeGeneratorOptions(String filename){
        this.filename = filename;
    }
}
