package uk.co.cemerson.hack24.bigcrane.BigCrane.RobotArmInterfaces;

import android.util.Log;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;

import uk.co.cemerson.hack24.bigcrane.BigCrane.RobotArmInterface;

public class SocketRobotArmInterface implements RobotArmInterface{
    WebSocketClient mWebSocketClient;

    private final static String url = "ws://192.168.252.134:8080";

    public SocketRobotArmInterface() {
        URI uri;

        try {
            uri = new URI(url);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        mWebSocketClient = new WebSocketClient(uri) {
            @Override
            public void onOpen(ServerHandshake handshakedata) {
            }

            @Override
            public void onMessage(String message) {

            }

            @Override
            public void onClose(int code, String reason, boolean remote) {

            }

            @Override
            public void onError(Exception ex) {
                Log.e("Websocket", "Error", ex);
            }
        };

        mWebSocketClient.connect();
    }

    @Override
    public void moveLeft() {
        sendMessage("lt");
    }

    @Override
    public void moveRight() {
        sendMessage("rt");
    }

    @Override
    public void moveDown(int stackSize) {
        sendMessage("dn" + stackSize);
    }

    @Override
    public void moveUp() {
        sendMessage("up");
    }

    @Override
    public void grab() {
        sendMessage("gb");
    }

    @Override
    public void release() {
        sendMessage("rl");
    }

    @Override
    public void win() {
    }

    @Override
    public void lose() {
    }

    private void sendMessage(String message)
    {
        mWebSocketClient.send(message);
    }
}
