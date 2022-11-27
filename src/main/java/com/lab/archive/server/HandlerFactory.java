package com.lab.archive.server;

import com.lab.archive.entity.User;
import com.lab.archive.server.handlers.AdminHandler;
import com.lab.archive.server.handlers.ClientHandler;

import java.net.Socket;

public class HandlerFactory {

    public Runnable getHandler(User user, Socket socket) {
        return switch (user.getRole()) {
            case USER -> new ClientHandler(socket, user);
            case ADMIN -> new AdminHandler(socket, user);
        };
    }
}
