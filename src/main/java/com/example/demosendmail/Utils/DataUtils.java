package com.example.demosendmail.Utils;

import java.util.UUID;

public class DataUtils {

    public static Object generateTempPwd(int i) {
        return UUID.randomUUID();
    }
}
