package com.example.YuvApps.MyTurn.DataTypes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuval on 29/09/15.
 */
public class TaskDetails {
    private String name;
    private String groupName;
    private boolean needDrainer;
    private boolean status;
    private List<UserDetails> Drainers = new ArrayList<UserDetails>();
    private List<UserDetails> Fillers =  new ArrayList<UserDetails>();
    private UserDetails currentDrainer;

    public static List<TaskDetails> getAllTask(String groupName) {

        List<TaskDetails> taskDetailses = new ArrayList<TaskDetails>();

        //// TODO: 29/09/15 get tasks from db for the current group

        return taskDetailses;
    }

    public String getName() { return this.name; }

    public void setName(String newName) { this.name = newName; }

    public String getGroupName() {
        return this.groupName;
    }

    public void setGroupName(String newGroupName) {
        this.groupName = newGroupName;
    }

    public boolean getNeedDrainer() {
        return this.needDrainer;
    }

    public void setNeedDrainer(boolean newNeed) {
        this.needDrainer = newNeed;
    }

    public boolean getStatus() { return this.status; }

    public void setStatus(boolean newStatus) { this.status = newStatus; }

    public List<UserDetails> getDrainersList() { return this.Drainers; }

    public void addDrainer(UserDetails newDrainer) {

        this.Drainers.add(newDrainer);

        newDrainer.addTaskAsDrainer(this);

    }

    public void removeDrainer(UserDetails oldDrainer) {

        if(this.Drainers.contains(oldDrainer)) {

            this.Drainers.remove(oldDrainer);

            oldDrainer.removeTaskAsDrainer(this);

        }

    }

    public List<UserDetails> getFillersList() { return this.Fillers; }

    private void setFillersList() { this.Fillers = new ArrayList<UserDetails>(); }

    public void addFiller(UserDetails newFiller) {

        this.Fillers.add(newFiller);

        newFiller.addTaskAsFiller(this);

    }

    public void removeFiller(UserDetails oldFiller) {

        if(this.Fillers.contains(oldFiller)) {

            this.Fillers.remove(oldFiller);

            oldFiller.removeTaskAsFiller(this);

        }

    }

    public UserDetails getCurrentDrainer() { return this.currentDrainer; }

    public void setCurrentDrainer(UserDetails nextDrainer) { this.currentDrainer = nextDrainer; }

    public TaskDetails(String newName, String newGroupName, boolean newNeedDrainer) {
        this.setName(newName);
        this.setGroupName(newGroupName);
        this.setNeedDrainer(newNeedDrainer);
    }

}