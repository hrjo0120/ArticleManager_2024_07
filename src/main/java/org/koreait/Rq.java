package org.koreait;

import java.util.HashMap;
import java.util.Map;

public class Rq {
    private String actionMethod;
    private Map<String, String> params;

    public Rq(String cmd) {

        String[] cmdBits = cmd.split(" ",2);    //cmdBits[0]: article, cmdBits[1]: write
        actionMethod = cmdBits[1];

        params = new HashMap<>();

        if(cmdBits.length == 1) {
            return;
        }

        for(String paramBits : cmdBits) {
            String[] paramStr = paramBits.split(" ", 2);

            String key = paramStr[0];
            String value = paramStr[1];
        }
    }

    public String getActionMethod() {
        return actionMethod;
    }
}
