package main;

import accounts.AccountService;
import dbService.DBService;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.GetServlet;
import servlets.SignInServlet;
import servlets.SignUpServlet;
import servlets.WebSocketChatServlet;

import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) throws Exception {
        //создаем сервлет для обработки  get запроса
        GetServlet getServlet = new GetServlet();
        //создаем аккаунт сервис для хранения аккаунтов пользователей и их сессий
        AccountService service = new AccountService();
        //создаем два сервлета для обработки запросов
        SignInServlet signInServlet = new SignInServlet(service);
        SignUpServlet signUpServlet = new SignUpServlet(service);
        //создаем хандлер для перехвата запроса и передаем в него сервлет
        ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        WebSocketChatServlet webSocketChatServlet = new WebSocketChatServlet();
        handler.addServlet(new ServletHolder(getServlet),"/mirror");
        handler.addServlet(new ServletHolder(signInServlet),"/signin");
        handler.addServlet(new ServletHolder(signUpServlet),"/signup");
        handler.addServlet(new ServletHolder(webSocketChatServlet),"/chat");
        //создаем хандлер ресурсов для подгрузки html формы
        ResourceHandler resource_handler = new ResourceHandler();
        resource_handler.setResourceBase("public_html");
        //создаем список хандлеров для установки в сервер
        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[]{resource_handler, handler});

        //создаем сервер из джетти на порту 8080 и устанавливаем для него хандлер
        Server server = new Server(8080);
        server.setHandler(handlers);
        server.start();
        Logger.getGlobal().info("Server started");
        server.join();

    }
}
