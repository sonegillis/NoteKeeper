package com.example.android.firstapp;

import java.util.ArrayList;
import java.util.List;

public class DataManager {

    private static List<CourseInfo> mCourses;
    private static List<NoteInfo> mNotes = new ArrayList<>();
    private static DataManager instance;
    public static DataManager getInstance() {
        if (instance == null) {
            instance = new DataManager();
            DataManager.instantiateCourses();
            DataManager.instantiateNotes();
            return instance;
        }
        return instance;
    }

    public String getCurrentUserName() {
        return "Sone Gillis";
    }

    public String getCurrentUserEmail() {
        return "sone_gillis@yahoo.com";
    }

    public List<NoteInfo> getNotes() {
        return mNotes;
    }

    private static int createNewNote(String id, CourseInfo courseInfo, String title, String text) {
        NoteInfo noteInfo = new NoteInfo(id, courseInfo, title, text);
        mNotes.add(noteInfo);
        return mNotes.size() - 1;
    }

    public int findNote(NoteInfo noteInfo) {
        for (int i = 0; i < mNotes.size(); i++) {
            if (noteInfo.getNoteId() == noteInfo.getNoteId()) {
                return i;
            }
        }
        return -1;
    }

    public void removeNote(int index) {
        mNotes.remove(index);
    }

    public List<CourseInfo> getCourses() {
        return mCourses;
    }

    public CourseInfo getCourse(String courseId) {
        for(CourseInfo course: mCourses) {
            if (course.getCourseId().equals(courseId)) {
                return course;
            }
        }
        return null;
    }

    private static void instantiateCourses() {
        mCourses = new ArrayList<>();
        mCourses.add(new CourseInfo("1", "Android Programming with intents", null));
        mCourses.add(new CourseInfo("2", "Android async programming and services", null));
        mCourses.add(new CourseInfo("3", "Java Programming: The fundamentals", null));
    }

    private static void instantiateNotes() {
        mNotes = new ArrayList<>();
        createNewNote("1", mCourses.get(0), "Hello", "world");
    }
}
