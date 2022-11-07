package users;

import java.util.ArrayList;

import device.Device;

public interface User {
    /**
     * To get name
     * @return
     */
    public String getName();
    /**
     * To set the name
     * @param name
     */
    public void setName(String name);
    /**
     * To get the id
     * @return
     */
    public int getId();
    /**
     * To set the id
     * @param value
     */
    public void setId(int value);
    /**
     * To get the device
     * @return
     */
    public Device getDevice();
    /**
     * To set the device
     * @param value
     */
    public void setDevice(Device value);
    /**
     * To get if the camera is active
     * @return
     */
    public boolean getCamera();
    /**
     * To set the activation of camera
     * @param value
     */
    public void setCamera(boolean value);
    /**
     * To get if the microphone is active
     * @return
     */
    public boolean getMicro();
    /**
     * To set the activation of the microphone
     * @param value
     */
    public void setMicro(boolean value);
    /**
     * To get if is in a meeting
     * @return
     */
    public boolean isInMeeting();
    /**
     * Set if meeting status
     * @param value
     */
    public void setInMeeting(boolean value);
    /**
     * To get the inbox
     * @return
     */
    public ArrayList<String> getInbox();
    /**
     * To set the inbox
     * @param inbox
     */
    public void setInbox(ArrayList<String> inbox);    
}
