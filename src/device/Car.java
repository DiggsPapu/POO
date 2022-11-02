package device;

public class Car implements Device {
    private boolean on_off;
    private boolean driving;
    public boolean getDriving(){
        return driving;
    }
    public void setDriving(boolean driving){
        this.driving = driving;
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
