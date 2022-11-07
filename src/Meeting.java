import java.util.ArrayList;

public class Meeting {
    public boolean active;
    public int id;
    private int password;
    private int host_id;
    private ArrayList<Integer> users_id = new ArrayList<>();
    private ArrayList<String> publicMessages = new ArrayList<>();
    /**
     * Get the public messages
     * @return
     */
    public ArrayList<String> getPublicMessages() {
        return publicMessages;
    }
    /**
     * To show if it's active
     * @return
     */
    public boolean isActive(){
        return active;
    }
    /**
     * To set if it's active
     * @param active
     */
    public void setActive(boolean active) {
        this.active = active;
    }
    /**
     * To get the host id
     * @return
     */
    public int getHost_id() {
        return host_id;
    }
    /**
     * set the host id
     * @param host_id
     */
    public void setHost_id(int host_id) {
        this.host_id = host_id;
    }
    /**
     * Get the id
     * @return
     */
    public int getId() {
        return id;
    }
    /**
     * Set the id
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * Get the password
     */
    public int getPassword() {
        return password;
    }
    /**
     * Set the password
     * @param password
     */
    public void setPassword(int password) {
        this.password = password;
    }
    /**
     * Get the id from users
     * @return
     */
    public ArrayList<Integer> getUsers_id() {
        return users_id;
    }
    /**
     * Set the users id
     * @param users_id
     */
    public void setUsers_id(ArrayList<Integer> users_id) {
        this.users_id = users_id;
    }
}
