package com.example.android.firstapp;

import android.os.Parcel;
import android.os.Parcelable;
import android.provider.ContactsContract;

import java.util.List;
import java.util.zip.CheckedOutputStream;

public class CourseInfo implements Parcelable {
    private final String mCourseId;
    private final String mTitle;
    private final List<ModuleInfo> mModuleInfo;

    private CourseInfo (Parcel source) {
        mCourseId = source.readString();
        mTitle = source.readString();
        mModuleInfo = source.
    }

    public CourseInfo(String courseId, String title, List<ModuleInfo> moduleInfo) {
        mCourseId = courseId;
        mTitle = title;
        mModuleInfo = moduleInfo;
    }

    public String getCourseId() {
        return mCourseId;
    }

    public String getTitle() {
        return mTitle;
    }

    public List<ModuleInfo> getModules() {
        return mModuleInfo;
    }

    public boolean[] getModuleCompletionStatus() {
        boolean[] status = new boolean[mModuleInfo.size()];
        for(int i = 0; i < mModuleInfo.size(); i++) {
            if (mModuleInfo.get(i).isComplete()) {
                status[i] = true;
            } else {
                status[i] = false;
            }
        }
        return status;
    }

    public void setModuleCompletionStatus(boolean[] status) {
        for(int i = 0; i < mModuleInfo.size(); i++) {
            mModuleInfo.get(i).setComplete(status[i]);
        }
    }

    public ModuleInfo getModuleInfo(String moduleId) {
        for (ModuleInfo moduleInfo: mModuleInfo) {
            if (moduleInfo.getModuleId().equals(moduleId)) {
                return moduleInfo;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return mTitle;
    }

    public boolean equals(CourseInfo courseInfo) {
        if (this == courseInfo) return true;
        if (courseInfo == null || courseInfo.getClass() != this.getClass()) {
            return false;
        }
        return this.mTitle.equals(courseInfo.mTitle);
    }

    @Override
    public int describeContents() { return 0; }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mTitle);
        dest.writeString(mCourseId);
        dest.writeParcelable(mModuleInfo, 0);
    }

    public static final Parcelable.Creator<ModuleInfo> CREATOR = new Parcelable.Creator() {
        @Override
        public CourseInfo createFromParcel(Parcel source) {
            return new CourseInfo(source);
        }
    }
}
