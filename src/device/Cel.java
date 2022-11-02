package device;

public class Cel implements Device {
    private boolean on_off;
    private boolean calling;
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
    public void setCalling(boolean calling) {
        this.calling = calling;
    }
    public boolean getCalling(){
        return this.calling;
    }
}