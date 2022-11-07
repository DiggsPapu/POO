package device;

public class Cel implements Device {
    private boolean on_off;
    private boolean calling;
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
    /**
     * Set if is calling
     * @param calling
     */
    public void setCalling(boolean calling) {
        this.calling = calling;
    }
    /**
     * Get if is calling
     * @return
     */
    public boolean getCalling(){
        return this.calling;
    }
}