package dataSets;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users")
public class UserDataSet implements Serializable {
    private static final long serialVersionUID = 10101;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "userName", unique = true, updatable = false)
    private String userName;

    @Column(name = "password", updatable = false)
    private String password;

    public UserDataSet(String userName, String password) {
        this.id = -1;
        this.userName = userName;
        this.password = password;
    }

    public UserDataSet() {
    }

    public UserDataSet(long id,String userName, String password ){
        this.id = id;
        this.userName = userName;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "UserDataSet{" +
                "id=" + id +
                ", name='" + userName + '\'' +
                ", password = '" + password + '\''+
                '}';
    }


}
