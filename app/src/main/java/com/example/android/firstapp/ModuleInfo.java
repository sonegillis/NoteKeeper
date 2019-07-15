package com.example.android.firstapp;

public class ModuleInfo {
    private final String mModuleId;
    private boolean mComplete;

    public ModuleInfo(String moduleId) {
        mModuleId = moduleId;
    }

    public boolean isComplete() {
        return mComplete;
    }

    public void setComplete(boolean complete) {
        mComplete = complete;
    }

    public String getModuleId() {
        return mModuleId;
    }
}
