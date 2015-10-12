package com.example.YuvApps.MyTurn.DataTypes;

import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuval on 29/09/15.
 */
public class UserDetails {
    private String name;
    private String groupName;
    private String password;
    private String phoneNumber;
    private boolean status;
    private int permissions;
    private List<TaskDetails> tasksAsDrainer = new ArrayList<TaskDetails>();
    private List<TaskDetails> tasksAsFiller = new ArrayList<TaskDetails>();

    public static List<UserDetails> getAllUser(String groupName) {
        if(groupName == null) {

            //todo add alert

            return null;

        } else {

            List<UserDetails> usersList = new ArrayList<UserDetails>();

            //todo get all of the user of this current group

            return usersList;

        }
    }

    public String getName() {
        return this.name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public void setGroupName(String newGroupName) {
        this.groupName = newGroupName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String newPassword) {
        this.password = newPassword;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String newPhoneNumber) {
        this.phoneNumber = newPhoneNumber;
    }

    public boolean getStatus() { return this.status; }

    public void setStatus(boolean newStatus) { this.status = newStatus; }

    public int getPermissions() {
        return this.permissions;
    }

    private void setPermissions(int newPermission) {
        this.permissions = newPermission;
    }

    public List<TaskDetails> getTasksAsDrainer() { return this.tasksAsDrainer; }

    public void addTaskAsDrainer(TaskDetails newTask) { this.tasksAsDrainer.add(newTask); }

    public void removeTaskAsDrainer(TaskDetails oldTask) {

        if(this.tasksAsDrainer.contains(oldTask)) {

            this.tasksAsDrainer.remove(oldTask);

        }

    }

    public List<TaskDetails> getTasksAsFiller() { return this.tasksAsFiller; }

    public void addTaskAsFiller(TaskDetails newTask) { this.tasksAsFiller.add(newTask); }

    public void removeTaskAsFiller(TaskDetails oldTask) {

        if(this.tasksAsFiller.contains(oldTask)) {

            this.tasksAsFiller.remove(oldTask);

        }

    }

    public UserDetails(String newName, String newGroupName, String newPassword, String newPhoneNumber) {
        this.setName(newName);
        this.setGroupName(newGroupName);
        this.setPassword(newPassword);
        this.setPhoneNumber(newPhoneNumber);
        this.setPermissions(2);
    }

    public UserDetails createUser(String newName, String newPhoneNumber) {
        if(this.getPermissions() < 2) {

            return null;

        } else {

            if(1!=1) {

                /*Checks if name is already exists*/
                return null;

            } else {

                UserDetails newUser = new UserDetails(newName, this.getGroupName(), "1234", newPhoneNumber);
                newUser.setPermissions(1);

                return newUser;
            }

        }
    }
}
