package users;

import java.util.ArrayList;

import device.Device;

public interface User {
    public String getName();
    public void setName(String name);
    public int getId();
    public void setId(int value);
    public Device getDevice();
    public void setDevice(Device value);
    public boolean getCamera();
    public void setCamera(boolean value);
    public boolean getMicro();
    public void setMicro(boolean value);
    public boolean isInMeeting();
    public void setInMeeting(boolean value);
    public ArrayList<String> getInbox();
    public void setInbox(ArrayList<String> inbox);    
}
