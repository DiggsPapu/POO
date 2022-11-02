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
    private ArrayList<User> users;
    private ArrayList<Meeting> meetings;
    private Random random = new Random();
    public ArrayList<Meeting> getMeetings() {
        return meetings;
    }
    public ArrayList<User> getUsers() {
        return users;
    }
    public void setMeetings(ArrayList<Meeting> meetings) {
        this.meetings = meetings;
    }
    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }
    private int createId(){
        while (true){
            int id = random.nextInt(1000000000)+1; 
            if (!getUsers().contains(id)){
                return id;
            }
        }
    }
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
    public void createUsers(){
        for (int k = 0 ; k < 50 ; k++ ){
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
}
