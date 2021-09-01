package com.programmers.designpattern.begavioral.template.network;

public abstract class Network {
    String userName;
    String password;

    /**
     * Publish the data to whatever network.
     * 템플릿 메서드
     */
    public boolean post(String message) {
        // Authenticate before posting. Every network uses a different
        // authentication method.
        if (logIn(this.userName, this.password)) {
            // Send the post data.
            boolean result = sendData(message.getBytes());
            logOut();
            return result;
        }
        return false;
    }

    abstract boolean logIn(String userName, String password);

    abstract boolean sendData(byte[] data);

    abstract void logOut();
}