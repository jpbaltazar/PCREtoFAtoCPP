package SnortParser;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class SnortParser {
    public SnortParser(String snortPath, String rulesetFile) throws IOException {
        FileWriter ruleFile = new FileWriter(rulesetFile);
        int i = 0;
        for (String line : Files.readAllLines(Path.of(snortPath))){
            i++;

            if(!line.contains("alert"))
                continue;

            String[] ruleFields = line.substring(line.indexOf("(")+1, line.length()-1).split(";");

            Map<String, String> fields = new HashMap<>();

            for (String ruleField : ruleFields){
                int colonIndex = ruleField.indexOf(":");

                if(colonIndex == -1)
                    break;
                String fieldName = ruleField.substring(1, colonIndex);
                String fieldContent = ruleField.substring(colonIndex+1);

                fields.put(fieldName, fieldContent);
            }

            System.out.printf("%d\n", i);

            if(fields.containsKey("pcre")){
                int pcreStart = fields.get("pcre").indexOf("\"");
                if(pcreStart != -1){
                    int pcreStop = fields.get("pcre").substring(pcreStart+1).indexOf("\"");
                    ruleFile.write(fields.get("pcre").substring(pcreStart+1, pcreStop+1) + "\n");
                }
            }

        }

        ruleFile.close();

    }
}
