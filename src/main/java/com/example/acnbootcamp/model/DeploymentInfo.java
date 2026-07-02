package com.example.acnbootcamp.model;

public class DeploymentInfo {
    private String branch;
    private String commitHash;
    private String timestamp;

    public DeploymentInfo(String branch, String commitHash, String timestamp) {
        this.branch = branch;
        this.commitHash = commitHash;
        this.timestamp = timestamp;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getCommitHash() {
        return commitHash;
    }

    public void setCommitHash(String commitHash) {
        this.commitHash = commitHash;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
