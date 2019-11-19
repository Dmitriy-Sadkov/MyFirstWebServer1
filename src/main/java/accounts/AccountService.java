package accounts;

import org.eclipse.jetty.server.session.JDBCSessionManager;

import java.util.HashMap;
import java.util.Map;

public class AccountService {
    private Map<String,UserProfile> loginToProfile;
    private Map<String,UserProfile> sessionIdToProfile;

    public AccountService(){
        loginToProfile = new HashMap<>();
        sessionIdToProfile = new HashMap<>();
    }

    public void addUser(UserProfile userProfile){
        loginToProfile.put(userProfile.getUserName(),userProfile);
    }

    public void addSession(String sessionId, UserProfile userProfile){
        sessionIdToProfile.put(sessionId,userProfile);
    }

    public UserProfile getUserBySession(String sessionId){
        return sessionIdToProfile.get(sessionId);
    }

    public UserProfile getUserByLogin(String login){
        return loginToProfile.get(login);
    }

    public void deleteUser(String login){
        loginToProfile.remove(login);
    }

    public void deleteSession(String sessionId){
        sessionIdToProfile.remove(sessionId);
    }




 }
