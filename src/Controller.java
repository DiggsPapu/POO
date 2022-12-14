import java.util.ArrayList;
import java.util.Random;

import device.Car;
import device.Cel;
import device.Device;
import device.Tablet;
import users.AdminUser;
import users.NomalUser;
import users.User;

public class Controller {
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Meeting> meetings = new ArrayList<>();
    private Random random = new Random();
    /**
     * To get the meetings
     * @return
     */
    public ArrayList<Meeting> getMeetings() {
        return meetings;
    }
    /**
     * To get the users
     */
    public ArrayList<User> getUsers() {
        return users;
    }
    /**
     * To set the meetings
     */
    public void setMeetings(ArrayList<Meeting> meetings) {
        this.meetings = meetings;
    }
    /**
     * To set the users
     * @param users
     */
    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }
    /**
     * To create an id
     */
    private int createId(){
        while (true){
            int id = random.nextInt(1000000000)+1; 
            if (!getUsers().contains(id)){
                return id;
            }
        }
    }
    /**
     * To create a device
     * @param newUser
     * @return
     */
    private Device createDevice(User newUser){
        if (newUser.getId()<=333333333){
            Car car = new Car();
            car.setOnOff(random.nextBoolean());
            if (car.getOnOff()){
                car.setDriving(random.nextBoolean());
            }
            else{
                car.setDriving(false);
            }
            return car;
        }
        else if (newUser.getId()>333333333 && newUser.getId()<=2*333333333){
            Cel Cel = new Cel();
            Cel.setOnOff(random.nextBoolean());
            if (Cel.getOnOff()){
                Cel.setCalling(random.nextBoolean());
            }
            else{
                Cel.setCalling(false);
            }
            return Cel;
        }
        else if (newUser.getId()>2*333333333 && newUser.getId()<=1000000000){
            Tablet Tablet = new Tablet();
            Tablet.setOnOff(random.nextBoolean());
            if (Tablet.getOnOff()){
                Tablet.setRunningApps(random.nextBoolean());
            }
            else{
                Tablet.setRunningApps(false);
            }
            return Tablet;
        }
        return null;
    }
    /**
     * To init users
     */
    public void createUsers(){
        for (int k = 0 ; k < 10 ; k++ ){
            User newUser = new NomalUser();
            newUser.setName("User"+String.valueOf(k));
            newUser.setId(createId());
            newUser.setDevice(createDevice(newUser));
            users.add(newUser);
        }
        for (int k = 0 ; k < random.nextInt(5) + 1 ; k++ ){
            User newUser = new AdminUser();
            newUser.setId(createId());
            newUser.setName("Admin"+String.valueOf(k));
            newUser.setInMeeting(true);
            users.add(newUser);
            Meeting newMeeting = new Meeting();
            newMeeting.setId(k);
            newMeeting.setPassword(k);
            newMeeting.setId(newUser.getId());
            newMeeting.setHost_id(newUser.getId());
            getMeetings().add(newMeeting);
        }
    }
    /**
     * To close a meeting
     * @param user
     * @return
     */
    public boolean closeMeeting(User user){
        for (int k = 0 ; k < meetings.size() ; k++  ){
            if (meetings.get(k).getHost_id()== user.getId()){
                meetings.get(k).setActive(false);
                user.setInMeeting(false);
                return true;
            }
        }
        return false;
    }
    /**
     * To init a meeting
     * @param user
     * @return
     */
    public boolean initMeeting(User user){
        for (int k = 0 ; k < meetings.size() ; k++  ){
            if (meetings.get(k).getHost_id()== user.getId()){
                meetings.get(k).setActive(true);
                return true;
            }
        }
        return false;
    }
    private int searchMeeting(User admin){
        for (int k = 0 ; k < meetings.size() ; k++  ){
            if (meetings.get(k).getHost_id()== admin.getId()){
                return k;
            }
        }
        return -1;
    }
    /**
     * To show a device
     */
    public String showDevice(Device device){
        String s_device ="";
        if (device.getClass() == Car.class){
            Car car = (Car) device;
            s_device += "The device is a car\nThe device is in ";
            if (car.getDriving()){
                s_device+="driving mode\n";
            }else{
                s_device+="stopped mode\n";
            }
        } 
        else if (device.getClass() == Cel.class){
            Cel car = (Cel) device;
            s_device += "The device is a Cel\nThe device is in ";
            if (car.getCalling()){
                s_device+="calling\n";
            }else{
                s_device+="not calling\n";
            }
        } 
        else if (device.getClass() ==Tablet.class){
           Tablet car = (Tablet) device;
            s_device += "The device is a Tablet\nThe device is in ";
            if (car.getRunningApps()){
                s_device+="running an app\n";
            }else{
                s_device+="not running an app\n";
            }
        } 
        return s_device;
    }
    /**
     * To show the individuals in the meeting
     */
    public String showIndividualsMeeting(User admin){
        int index = searchMeeting(admin);
        String s_return = "";
        if (index!=-1){
            for (int k = 0 ; k < meetings.get(index).getUsers_id().size() ; k++ ){
                User user = users.get(meetings.get(index).getUsers_id().get(k));
                Device device = user.getDevice();
                if (user.isInMeeting()){
                    s_return += "User id: "+user.getId()+"\n";
                    s_return += "Usename: "+user.getName()+"\n";
                    if (user.getCamera()){
                        s_return += "User has the camera activated\n";
                    }
                    else{
                        s_return += "User has the camera deactivated\n";
                    }if (user.getMicro()){
                        s_return += "User has the micro activated\n";
                    }
                    else{
                        s_return += "User has the micro deactivated\n";
                    }
                    s_return+=showDevice(device);
                }
            }
            return s_return;
        }
        else{
            s_return ="The meeting doesn't exist\n"; return s_return;
        }
    }
    /**
     * To activate a camera
     */
    public String activateCamera(User user){
        user.setCamera(false);return ("The user "+user.getName()+" has open camera");
    }
    /**
     * To deactivate a camera
     * @param user
     * @return
     */
    public String deactivateCamera(User user){
        user.setCamera(false);return ("The user "+user.getName()+" has closed camera");
    }
    /**
     * To unmute
     * @param user
     * @return
     */
    public String userUnmuting(User user){
        user.setMicro(true);return ("The user "+user.getName()+" is unmuted");
    }
    /**
     * To mute
     * @param user
     * @return
     */
    public String userMuting(User user){
        user.setMicro(false);return ("The user "+user.getName()+" is muted");
    }
    /**
     * To use commands of admin
     */
    public String adminCommands(int index, int option){
        try {
            User user_to = users.get(index);
            if (option ==  1){
                return userUnmuting(user_to);
            }
            else if (option == 2){
                return userMuting(user_to);
            } 
            else if (option == 3){
                return deactivateCamera(user_to);
            }
            else{
                return activateCamera(user_to);
            }
        } catch (Exception e) {
            // TODO: handle exception
            return "The user entered doesn't exist\n";
        }
    }
    /**
     * To print private messagess
     * @param user
     * @return
     */
    public String checkUserMessages(User user){
        String messages = "PRIVATE MESSAGES\n";
        for (int k = 0 ; k < user.getInbox().size() ; k++){
            messages += user.getInbox().get(k)+"\n";
        }
        return messages;
    }
    /**
     * To send private messages
     */
    public String sendPrivateMessages(User user, String message){
        try {
            user.getInbox().add(message);
            return "The message was succesfully sent";
        } catch (Exception e) {
            // TODO: handle exception
            return "The message couldn't be sent";
        }
    }
    /**
     * To send public messages
     * @param message
     * @param meetingId
     * @return
     */
    public String sendPublicMessage(String message, int meetingId){
        for (int k = 0 ; k < this.meetings.size() ; k++ ){
            if (this.meetings.get(k).getId()==meetingId){
                this.meetings.get(k).getPublicMessages().add(message);
                return "The message was succesfully added to the general chat\n";
            }
        }
        return "The message couldn't be sent to the general chat\n";
    }
    /**
     * To enter a meeting
     * @param user
     * @param meetingId
     * @param meetingPassword
     * @return
     */
    public boolean enterMeeting(User user, int meetingId, int meetingPassword){
        for (int k = 0 ; k < meetings.size() ; k ++ ){
            if (meetings.get(k).getId()==meetingId && meetings.get(k).getPassword()==meetingPassword){
                user.setInMeeting(true);
                return true;
            }
        }
        return false;
    }
    /**
     * To show the meetings
     */
    public String showMeetings(){
        String s_return = "THE MEETINGS ARE\n";
        for (int k = 0 ; k < meetings.size(); k++ ){
            s_return += "\nMeeting id: "+meetings.get(k).getId();
            s_return += "\nMeeting host id: "+meetings.get(k).getHost_id();
            s_return += "\nPassword: "+meetings.get(k).getPassword();
        }
        return s_return;
    }
    /**
     * To log out from a meeting
     * @param user
     * @return
     */
    public boolean logOutMeeting(User user){
        for (int k = 0 ; k < meetings.size() ; k++  ){
            user.setInMeeting(false);
            if (meetings.get(k).getUsers_id().contains(user.getId())){
                meetings.get(k).getUsers_id().remove(user.getId());
                return true;
            }
        }
        return false;
    }
    /**
     * To get the actual meeting
     * @param user
     * @return
     */
    public int getActualMeeting(User user){
        for (int k = 0 ;  k < meetings.size() ; k++ ){
            if (this.meetings.get(k).getUsers_id().contains(user.getId())){
                return this.meetings.get(k).getId();
            }
        }
        return 0;
    }
    /**
     * To show the public messages
     */
    public String showPublicMessages(int meetingId){
        String messages = "PUBLIC MESSAGES\n";
        for ( int k = 0 ; k < this.meetings.size() ; k++ ){
            if ( this.meetings.get(k).getId()==meetingId){
                messages += "Meeting id: "+this.meetings.get(k).getId()+"\nHost id: "+this.meetings.get(k).getHost_id()+"\n";
                for (int j = 0 ; j < this.meetings.get(k).getPublicMessages().size() ; j++ ){
                    messages += String.valueOf(k)+" "+this.meetings.get(k).getPublicMessages().get(j)+"\n";
                }
            }
        }
        return messages;
    }
    /**
     * To print a user
     */
    public String printUser(User user){
        String string = "id: "+user.getId()+"\nname: "+user.getName();
        if (user.getMicro()){
            string+="\nmicrophone: on";
        }
        else{
            string+="\nmicrophone: off";
        }
        if (user.getCamera()){
            string+="\ncamera: on";
        }
        else{
            string+="\ncamera: off";
        }
        return string;
    }
}
