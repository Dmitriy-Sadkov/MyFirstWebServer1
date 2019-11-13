package main;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.GetServlet;

import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) throws Exception {
        //создаем сервлет для обработки запроса
        GetServlet getServlet = new GetServlet();
        //создаем хандлер для перехвата запроса и передаем в него сервлет
        ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        handler.addServlet(new ServletHolder(getServlet),"/mirror");
        //создаем сервер из джетти на порту 8080 и устанавливаем для него хандлер
        Server server = new Server(8080);
        server.setHandler(handler);
        server.start();
        Logger.getGlobal().info("Server started");
        server.join();

    }
}