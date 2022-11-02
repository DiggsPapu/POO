import java.util.ArrayList;

public class Meeting {
    public int id;
    private int password;
    private int host_id;
    private ArrayList<Integer> users_id;
    public int getHost_id() {
        return host_id;
    }
    public void setHost_id(int host_id) {
        this.host_id = host_id;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getPassword() {
        return password;
    }
    public void setPassword(int password) {
        this.password = password;
    }
    public ArrayList<Integer> getUsers_id() {
        return users_id;
    }
    public void setUsers_id(ArrayList<Integer> users_id) {
        this.users_id = users_id;
    }
}
