package accounts;

import dataSets.UserDataSet;
import dbService.DBException;
import dbService.DBService;
import org.eclipse.jetty.server.session.JDBCSessionManager;

import java.util.HashMap;
import java.util.Map;

public class AccountService {
    private final DBService service;

    public AccountService(){
        service = new DBService();
    }

    public void addUser(UserDataSet userProfile) throws DBException {
        service.addUser(userProfile.getUserName(),userProfile.getPassword());
    }

    //public void addSession(String sessionId, UserProfile userProfile){
   //     sessionIdToProfile.put(sessionId,userProfile);
   // }

    //public UserProfile getUserBySession(String sessionId){
    //    return sessionIdToProfile.get(sessionId);
    //}

    public UserDataSet getUserByLogin(String login) throws DBException {
        return service.getUserByName(login);
    }

    //public void deleteUser(String login){
   //     loginToProfile.remove(login);
   // }

    //public void deleteSession(String sessionId){
       // sessionIdToProfile.remove(sessionId);
   // }




 }
