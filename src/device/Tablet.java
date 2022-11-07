package device;

public class Tablet implements Device{
    private boolean on_off;
    private boolean running_apps;
    /**
     * Get if apps are running
     * @return
     */
    public boolean getRunningApps(){
        return running_apps;
    }
    /**
     * Set if apps are running
     * @param running_apps
     */
    public void setRunningApps(boolean running_apps){
        this.running_apps = running_apps;
    }   
    /**
     * Get if is on or off
     */
    @Override
    public boolean getOnOff() {
        // TODO Auto-generated method stub
        return this.on_off;
    }
    /**
     * Set if on or off
     */
    @Override
    public void setOnOff(boolean val) {
        // TODO Auto-generated method stub
        this.on_off = val;
    }
}
