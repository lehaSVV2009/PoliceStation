package com.kadet.java.policeStation.database;

import com.kadet.java.policeStation.entity.Resume;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 24.11.13
 * Time: 11:16
 * To change this template use File | Settings | File Templates.
 */
public class ResumeDatabase {

    private final static ResumeDatabase instance = new ResumeDatabase();

    public static final ResumeDatabase getInstance () {
        return instance;
    }

    private List<Resume> resumes;

    public ResumeDatabase() {
        this.resumes = new ArrayList<Resume>();
    }

    public void addResume (Resume resume) {
        resumes.add(resume);
    }

    public List<Resume> getResumes() {
        return resumes;
    }

    public boolean removeResume (Resume resume) {
        return resumes.remove(resume);
    }

    public int getResumesNumber () {
        return resumes.size();
    }

    public List<Resume> subList (int firstIndex, int lastIndex) {
        if (firstIndex < 0 || lastIndex < 1 || firstIndex >= lastIndex || firstIndex > resumes.size()) {
            throw new RuntimeException("Bad parameters error!");
        }
        List<Resume> subResumes
                = new ArrayList<Resume>();
        for (int resumeIndex = firstIndex; resumeIndex < lastIndex && resumeIndex < resumes.size(); ++resumeIndex) {
            subResumes.add(
                    resumes.get(resumeIndex)
            );
        }
        return subResumes;
    }
}
