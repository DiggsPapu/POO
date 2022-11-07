package device;

public class Car implements Device {
    private boolean on_off;
    private boolean driving;
    /**
     * Get the if driving
     * @return
     */
    public boolean getDriving(){
        return driving;
    }
    /**
     * Set if driving
     * @param driving
     */
    public void setDriving(boolean driving){
        this.driving = driving;
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
