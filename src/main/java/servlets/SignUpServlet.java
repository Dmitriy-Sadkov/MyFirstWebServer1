package servlets;

import accounts.AccountService;
import accounts.UserProfile;
import dataSets.UserDataSet;
import dbService.DBException;
import dbService.DBService;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignUpServlet extends HttpServlet {
    private final AccountService service;

    public SignUpServlet(AccountService accountService) {
        this.service = accountService;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("login");
        String password = req.getParameter("password");
        try {
            service.addUser(new UserDataSet(userName,password));
        } catch (DBException e) {
            resp.setContentType("text/html;charset=utf-8");
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            resp.getWriter().println("ERROR");
        }
        resp.setContentType("text/html;charset=utf-8");
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.getWriter().println("OK");
    }
}
