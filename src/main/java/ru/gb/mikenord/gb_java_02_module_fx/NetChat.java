package ru.gb.mikenord.gb_java_02_module_fx;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class NetChat {
    private final Map<LocalDateTime, String> msgArray = new HashMap<>();
    private final String userName;

    public String getUserName() {
        return userName;
    }

    public NetChat(String userName) {
        this.userName = userName;
    }

    public void addMessage(LocalDateTime msgTime, String msg) {
        msgArray.put(msgTime, msg);
    }

    public int getMessagesCount() {
        return msgArray.size();
    }
}
