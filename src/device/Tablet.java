package device;

public class Tablet implements Device{
    private boolean on_off;
    private boolean running_apps;
    public boolean getRunningApps(){
        return running_apps;
    }
    public void setRunningApps(boolean running_apps){
        this.running_apps = running_apps;
    }   
    @Override
    public boolean getOnOff() {
        // TODO Auto-generated method stub
        return this.on_off;
    }
    @Override
    public void setOnOff(boolean val) {
        // TODO Auto-generated method stub
        this.on_off = val;
    }
    
}
