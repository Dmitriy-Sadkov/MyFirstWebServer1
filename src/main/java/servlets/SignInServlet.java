package servlets;

import accounts.AccountService;
import accounts.UserProfile;
import dataSets.UserDataSet;
import dbService.DBException;
import dbService.DBService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignInServlet extends HttpServlet {
    private final AccountService service;

    public SignInServlet(AccountService accountService) {
     this.service = accountService;
     }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("login");
        String password = req.getParameter("password");
        UserDataSet userDataSet = null;
        try {
            userDataSet = service.getUserByLogin(userName);
        } catch (DBException e) {
            resp.setContentType("text/html;charset=utf-8");
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            resp.getWriter().println("Unauthorized");
        }
        //проверяем правильность ввода логина и пароля
        if(userDataSet!=null&&userDataSet.getPassword().equals(password)){
            //если все ОК возвращаем статус ОК
            resp.setContentType("text/html;charset=utf-8");
            resp.setStatus(HttpServletResponse.SC_OK);
            resp.getWriter().println("Authorized: " + userName);
        }else {
            //Если неправильно введены данные возвращаем код ошибки 401
            resp.setContentType("text/html;charset=utf-8");
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            resp.getWriter().println("Unauthorized");
        }

    }
}