package com.example.YuvApps.MyTurn.DataTypes;

/**
 * Created by yuval on 29/09/15.
 */
public class GroupDetails {
    private String name;
    private String usersTableName;
    private String tasksTasleName;

    public static GroupDetails getGroupLineByName(String groupName) {
        //// TODO: 29/09/15
        return null;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public String getUsersTableName() {
        return this.usersTableName;
    }

    public void setUsersTableName(String newName) {
        this.usersTableName = newName;
    }

    public String getTasksTasleName() {
        return this.tasksTasleName;
    }

    public void setTasksTasleName(String newName) {
        this.tasksTasleName = newName;
    }

    public GroupDetails(String groupName) {
        this.setName(groupName);
        String fixName = groupName.replaceAll(" ","");
        this.setUsersTableName(fixName + "Users");
        this.setTasksTasleName(fixName + "Tasks");
    }

    public boolean createTables() {

        if(1 != 1/*Taken*/) {
            //// TODO: 29/09/15   
            return false;

        } else {
            //// TODO: 29/09/15
            /*Create tables*/
            return true;
        }
    }
}
