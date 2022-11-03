import java.util.Random;
import java.util.Scanner;

import device.Car;
import device.Cel;
import device.Device;
import device.Tablet;
import users.NomalUser;
import users.User;
public class Main {
    private static Scanner scan = new Scanner(System.in);
    private static Random random = new Random();
    private static Controller control = new Controller();
    private static int actual_meeting = 0;
    private static int printMenuPrincipalAdmin(){
        System.out.println("1- Init conference\n2- Device menu\n3- Close program\n");
        return enterInteger();
    }
    private static int printMenuPrincipalUser(){
        System.out.println("1- Log into conference\n2- Device menu\n3- Close program\n");
        return enterInteger();
    }
    private static int enterInteger(){
        while (true){
            System.out.println("Enter a valid integer: ");
            try {
                int option = Integer.parseInt(scan.nextLine());
                return option;
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("An invalid value was entered.");
            }
        }
    }
    private static int printMenuDevice(User user){
        if (user.getDevice().getClass()==Car.class){
            System.out.println("1- Turn on car\n2- Turn off car\n3- Start driving\n4- Stop driving");
            return enterInteger();
        }
        else if (user.getDevice().getClass()==Cel.class){
            System.out.println("1- Turn on car\n2- Turn off car\n3- Start a call\n4- Stop call");
            return enterInteger();
        }
        else{
            System.out.println("1- Turn on car\n2- Turn off car\n3- Start an app\n4- Stop an app");
            return enterInteger();
        }
    }
    private static void handleDevice(int option, User user){
        if (user.getDevice().getClass() == Car.class){
            Car car = (Car) user.getDevice();
            switch (option) {
                case 1:
                System.out.println("The car is turned in");
                car.setOnOff(true);
                break;
                case 2:
                System.out.println("The car is turn off");
                car.setOnOff(false);
                break;
                case 3:
                System.out.println("The car is moving");
                car.setDriving(true);
                break;
                case 4:
                System.out.println("The car is parked");
                car.setDriving(false);
                break;
                default:
                System.out.println("The option selected is invalid");
                    break;
            }
        }
        else if (user.getDevice().getClass() == Tablet.class){
            Tablet Tablet = (Tablet) user.getDevice();
            switch (option) {
                case 1:
                System.out.println("The Tablet is turned in");
                Tablet.setOnOff(true);
                break;
                case 2:
                System.out.println("The Tablet is turn off");
                Tablet.setOnOff(false);
                break;
                case 3:
                System.out.println("The Tablet is running and app");
                Tablet.setRunningApps(true);
                break;
                case 4:
                System.out.println("The Tablet closed an app");
                Tablet.setRunningApps(false);
                break;
                default:
                System.out.println("The option selected is invalid");
                    break;
            }
        }
        else if (user.getDevice().getClass() == Cel.class){
            Cel Cel = (Cel) user.getDevice();
            switch (option) {
                case 1:
                System.out.println("The Cel is turned in");
                Cel.setOnOff(true);
                break;
                case 2:
                System.out.println("The Cel is turn off");
                Cel.setOnOff(false);
                break;
                case 3:
                System.out.println("The Cel is calling");
                Cel.setCalling(true);
                break;
                case 4:
                System.out.println("The Cel stoped calling");
                Cel.setCalling(false);
                break;
                default:
                System.out.println("The option selected is invalid");
                    break;
            }
        }
    }
    private static int printMenuMeetingAdmin(User user){
        System.out.println("Select between:\n1- Close the meeting\n2- Mute\n3- Unmute\n4- Deactivate camera\n5- Activate camera\n6- Unmute other user\n7- Mute other user\n8- Activate camera other user\n9- Deactivate camera other user\n10- Close program\n11- Send a message in the principal text\n12- Send a private message\n13- Check inbox\n");
        return enterInteger();
    }
    private static boolean adminTurn(User user){
        if (!user.isInMeeting()){
            switch (printMenuPrincipalAdmin()) {
                case 1:
                if (control.initMeeting(user)){
                    System.out.println("The meeting was succesfully initialized by "+user.getName());
                    user.setInMeeting(true);
                }
                else{
                    System.out.println("The meeting couldn't be initialized by "+user.getName());
                }
                    return true;
                case 2:
                    handleDevice(printMenuDevice(user), user);
                    return true;
                case 3:
                    return false;
                default:
                    return true;
            }
        }
        else{
            actual_meeting = control.getActualMeeting(user);
            switch(printMenuMeetingAdmin(user)){
                case 1: 
                if (control.closeMeeting(user)){
                    System.out.println("The meeting was succesfully closed by "+user.getName());
                    user.setInMeeting(false);
                }
                else{
                    System.out.println("The meeting couldn't be closed by "+user.getName());
                }
                return true;
                case 2:System.out.println(control.userMuting(user));return true;
                case 3:System.out.println(control.userUnmuting(user));return true;
                case 4:System.out.println(control.deactivateCamera(user));return true;
                case 5:System.out.println(control.activateCamera(user));return true;
                case 6:System.out.println(control.showIndividualsMeeting(user));
                System.out.println(control.adminCommands(enterInteger(), 1));return true;
                case 7:System.out.println(control.showIndividualsMeeting(user));
                System.out.println(control.adminCommands(enterInteger(), 2));return true;
                case 8:System.out.println(control.showIndividualsMeeting(user));
                System.out.println(control.adminCommands(enterInteger(), 3));return true;
                case 9:System.out.print(control.showIndividualsMeeting(user));
                System.out.println(control.adminCommands(enterInteger(), 4));return true;
                case 10: return false;
                case 11:System.out.println("Enter message: ");
                System.out.println(control.sendPublicMessage(scan.nextLine(), actual_meeting)); return true;
                case 12:System.out.println(control.showIndividualsMeeting(user));System.out.println("Enter message: ");
                System.out.println(control.sendPrivateMessages(control.getUsers().get(enterInteger()), scan.nextLine()+"\nSent by: "+user.getName()));
                return true;
                case 13:System.out.println(control.checkUserMessages(user)); return true;
                default:return true;
            }
        }
    }
    private static int printMenuMeetingUser(User user){
        System.out.println("Select between:\n1- Close the meeting\n2- Mute\n3- Unmute\n4- Deactivate camera\n5- Activate camera\n6- Close program\n7- Send a message in the principal text\n8- Send a private message\n");
        return enterInteger();
    }
    private static boolean userTurn(User user){
        if (!user.isInMeeting()){
            switch (printMenuPrincipalUser()) {
                case 1:
                System.out.println(control.showMeetings());
                System.out.println("Enter the id and then the password.");
                if (control.enterMeeting(user, enterInteger(), enterInteger())){
                    System.out.println("The user "+user.getName()+" entered at the meeting succefully");
                    user.setInMeeting(true);
                }
                else{
                    System.out.println("The user "+user.getName()+" couldn't entered at the meeting");
                }
                    return true;
                case 2:
                    handleDevice(printMenuDevice(user), user);
                    return true;
                case 3:
                    return false;
                default:
                    return true;
            }
        }
        else{
            actual_meeting = control.getActualMeeting(user);
            switch(printMenuMeetingUser(user)){
                case 1: 
                if (control.logOutMeeting(user)){
                    System.out.println("The user got out from the was succesfully closed by "+user.getName());
                    user.setInMeeting(false);
                }
                else{
                    System.out.println("The meeting couldn't be closed by "+user.getName());
                }
                return true;
                case 2:System.out.println(control.userMuting(user));return true;
                case 3:System.out.println(control.userUnmuting(user));return true;
                case 4:System.out.println(control.deactivateCamera(user));return true;
                case 5:System.out.println(control.activateCamera(user));return true;
                case 6:System.out.println("Enter message: ");
                System.out.println(control.sendPublicMessage(scan.nextLine(), actual_meeting)); return true;
                case 7:System.out.println(control.showIndividualsMeeting(user));
                System.out.println(control.sendPrivateMessages(control.getUsers().get(enterInteger()), scan.nextLine()+"\nSent by: "+user.getName()));
                return true;
                case 8:System.out.println(control.checkUserMessages(user)); return true;
                default:return true;
            }
        }
    }
    
    public static void main(String[] args) {
        control.createUsers();
        boolean bool = true;
        while (bool){
            for (int k = 0 ; k < control.getUsers().size(); k++ ){
                User user = control.getUsers().get(k);
                if ( user.getClass() == NomalUser.class ){
                    if (userTurn(user)){
                    }
                    else{
                        bool = false;
                    }
                }
                else{
                    if (adminTurn(user)){
                    }
                    else{
                        bool = false;
                    }
                }
            }
        }
        System.out.println("Thanks for using our app");
    }
}
