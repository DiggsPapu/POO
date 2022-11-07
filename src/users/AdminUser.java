package users;

import java.util.ArrayList;

import device.Device;
public class AdminUser implements User {
    private Device device;
    private String name;
    private int id;
    private boolean micro = false;
    private boolean camera = false;
    private boolean in_meeting = false;
    private ArrayList<String> inbox = new ArrayList<>();
    /** This are the overrides from the interface */
    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return name;
    }

    @Override
    public void setName(String name) {
        // TODO Auto-generated method stub
        this.name = name;
    }

    @Override
    public int getId() {
        // TODO Auto-generated method stub
        return id;
    }

    @Override
    public void setId(int value) {
        // TODO Auto-generated method stub
        this.id = value;
    }

    @Override
    public Device getDevice() {
        // TODO Auto-generated method stub
        return device;
    }

    @Override
    public void setDevice(Device value) {
        // TODO Auto-generated method stub
        this.device = value;
    }

    @Override
    public boolean getCamera() {
        // TODO Auto-generated method stub
        return camera;
    }

    @Override
    public void setCamera(boolean value) {
        // TODO Auto-generated method stub
        camera = value;
    }

    @Override
    public boolean getMicro() {
        // TODO Auto-generated method stub
        return micro;
    }

    @Override
    public void setMicro(boolean value) {
        // TODO Auto-generated method stub
        micro = value;
    }

    @Override
    public boolean isInMeeting() {
        // TODO Auto-generated method stub
        return in_meeting;
    }

    @Override
    public void setInMeeting(boolean value) {
        // TODO Auto-generated method stub
        in_meeting = value;
    }

    @Override
    public ArrayList<String> getInbox() {
        // TODO Auto-generated method stub
        return inbox;
    }

    @Override
    public void setInbox(ArrayList<String> inbox) {
        // TODO Auto-generated method stub
        this.inbox = inbox;
    }
}
