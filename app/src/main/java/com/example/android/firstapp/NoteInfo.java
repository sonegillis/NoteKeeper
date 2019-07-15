package com.example.android.firstapp;

import android.os.Parcel;
import android.os.Parcelable;

public class NoteInfo implements Parcelable{
    private String mNoteId;
    private CourseInfo mCourse;
    private String mTitle;
    private String mText;

    private NoteInfo(Parcel source) {
        mText = source.readString();
        mTitle = source.readString();
        mCourse = source.readParcelable(CourseInfo.class.getClassLoader());
    }

    public NoteInfo (String noteId, CourseInfo course, String title, String text) {
        mNoteId = noteId;
        mCourse = course;
        mTitle = title;
        mText = text;
    }

    public CourseInfo getCourse() { return mCourse; }

    public void setCourse(CourseInfo course) { mCourse = course; }

    public String getTitle() { return mTitle; }

    public String getNoteId() {
        return mNoteId;
    }

    public void setTitle(String title) { mTitle = title; }

    public String getText() { return mText; }

    public void setText(String text) { mText = text; }

    public String getCompareKey() { return mCourse.getCourseId() + "|" + mTitle + "|" + mText; }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        NoteInfo noteInfo = (NoteInfo) obj;
        if (noteInfo.getCompareKey() == this.getCompareKey()) return true;
        return false;
    }

    @Override
    public int hashCode() { return this.getCompareKey().hashCode(); }

    @Override
    public String toString() { return this.getCompareKey(); }

    @Override
    public int describeContents() { return 0; }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mText);
        dest.writeString(mTitle);
        dest.writeParcelable(mCourse, 0);
    }

    public final static Parcelable.Creator<NoteInfo> CREATOR = new Parcelable.Creator() {
        @Override
        public NoteInfo createFromParcel(Parcel source) {
            return new NoteInfo(source);
        }

        @Override
        public NoteInfo[] newArray(int size) {
            return new NoteInfo[size];
        }
    };
}
