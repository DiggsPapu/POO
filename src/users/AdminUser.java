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
    /**
     * To get name
     * @return
     */
    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return name;
    }
    /**
     * To set the name
     * @param name
     */
    @Override
    public void setName(String name) {
        // TODO Auto-generated method stub
        this.name = name;
    }
    /**
     * To get the id
     * @return
     */
    @Override
    public int getId() {
        // TODO Auto-generated method stub
        return id;
    }
    /**
     * To set the id
     * @param value
     */
    @Override
    public void setId(int value) {
        // TODO Auto-generated method stub
        this.id = value;
    }
    /**
     * To get the device
     * @return
     */
    @Override
    public Device getDevice() {
        // TODO Auto-generated method stub
        return device;
    }
    /**
     * To set the device
     * @param value
     */
    @Override
    public void setDevice(Device value) {
        // TODO Auto-generated method stub
        this.device = value;
    }
    /**
     * To get if the camera is active
     * @return
     */
    @Override
    public boolean getCamera() {
        // TODO Auto-generated method stub
        return camera;
    }
    /**
     * To set the activation of camera
     * @param value
     */
    @Override
    public void setCamera(boolean value) {
        // TODO Auto-generated method stub
        camera = value;
    }
    /**
     * To get if the microphone is active
     * @return
     */
    @Override
    public boolean getMicro() {
        // TODO Auto-generated method stub
        return micro;
    }
    /**
     * To set the activation of the microphone
     * @param value
     */
    @Override
    public void setMicro(boolean value) {
        // TODO Auto-generated method stub
        micro = value;
    }
    /**
     * To get if is in a meeting
     * @return
     */
    @Override
    public boolean isInMeeting() {
        // TODO Auto-generated method stub
        return in_meeting;
    }
    /**
     * Set if meeting status
     * @param value
     */
    @Override
    public void setInMeeting(boolean value) {
        // TODO Auto-generated method stub
        in_meeting = value;
    }
    /**
     * To get the inbox
     * @return
     */
    @Override
    public ArrayList<String> getInbox() {
        // TODO Auto-generated method stub
        return inbox;
    }
    /**
     * To set the inbox
     * @param inbox
     */
    @Override
    public void setInbox(ArrayList<String> inbox) {
        // TODO Auto-generated method stub
        this.inbox = inbox;
    }
}
