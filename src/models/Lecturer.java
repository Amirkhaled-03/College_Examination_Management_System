package models;

import java.util.ArrayList;

public class Lecturer extends Person {

    static int numOfLecturer = 0;
    private final int ID;
    private ArrayList<Subject> subjects;
    public StudentManagement studentManager = new StudentManagement();


    public Lecturer(String userName, String password, String email, String phone) {
        super(userName, password, "lecturer", email, phone);
        this.ID = ++numOfLecturer;
        this.subjects = new ArrayList<>();
    }

    public Lecturer(int ID, String userName, String password, String email, String phone) {
        super(userName, password, "lecturer", email, phone);
        this.ID = ID;
        this.subjects = new ArrayList<>();
    }


    public int getID() {
        return ID;
    }

    public boolean addSubject(Subject subject) {
        if (this.subjects.contains(subject)) {
            return false;
        }
        this.subjects.add(subject);
        return true;
    }

    public ArrayList<Subject> getLecturerSubjects() {
        return this.subjects;
    }


    public boolean delSubject(Subject subject) {
        if (this.subjects.contains(subject)) {
            this.subjects.remove(subject);
            return true;
        }
        return false;
    }

    public int findSubjIndex(int id) {

        for (int i = 0; i < this.subjects.size(); i++) { // loop on the list of subjects
            if (this.subjects.get(i).getSubjID() == id) // if the id of the subject equals the id we entered
                return i; // returns the index of the subject (index not id)
        }
        return -1; // else it returns -1
    }

    public Subject getSubject(int index) { // check that index is not -1
        return this.subjects.get(index);
    }

    public boolean deleteExam(Subject subject) {
        if (subject.getExam() != null) {
            subject.setExam(null);
            subject.setIsExamCreated(false);
            return true;
        }
        return false;
    }


    public boolean addExam(Exam exam, Subject subject) {
        if (subject.getExam() == null) {
            subject.setExam(exam);
            subject.setIsExamCreated(true);
            return true;
        }
        return false;
    }

    //returns subjects like:
    // 1=> subject1
    // 2=> subject2
    public String getSubjectstoChooseFrom(){ 
        String subjectsString = "";
        if(subjects.size() == 0)
            return "\nNo Assigned Subjects";
        int subjectsLength = subjects.size();
        for (int i = 0; i < subjectsLength; i++) {
            subjectsString += subjects.get(i).getSubjID()+"=> "+ subjects.get(i).getSubjectName()+"\n";
        }
        return subjectsString;
    }

    //returns subjects like:
    // subject1, subject2
    public String getSubjectsAsString() {
        String subjectsString = "";
        if(subjects.size() == 0)
            return "No Assigned Subjects";
        int subjectsLength = subjects.size();
        for (int i = 0; i < subjectsLength; i++) {
            subjectsString += subjects.get(i).getSubjectName();
            if (i != subjectsLength - 1) {
                subjectsString += ", ";
            }
        }
        return subjectsString;
    }

    // returns subjects that has exams
    public String getSubjectsWithExams(){
        String subjects = "";
        for (Subject subject1 : getLecturerSubjects()) {
            if (subject1.isExamCreated()) {
                subjects +=  subject1.getSubjID() + "=> " + subject1.getSubjectName() + "\n";
            }
        }
        if (subjects.isEmpty())
            subjects += "No exams\n";
        return subjects;
    }



    public static void setNumOfLecturer(int numOfLecturer) {
        Lecturer.numOfLecturer = numOfLecturer;
    }


    // override the original setUserName of class Person to check if the username is already taken or no and if it's empty or no
    @Override
    public int setUserName(String userName) { 
        if(userName.equals("empty")){ // if the username is empty return -1
            return -1;
        }
        for(Lecturer lecturer : LecturerManagement.getLecturersArr()) { // loop on the array of Lecturers
            if(lecturer.getUserName().equals(userName)) // check if the username is already taken
                return -2; // if yes return -2
        }
            super.setUserName(userName); // if no call the original setUserName method in class Person and set the username
            return 1;
    }

    @Override
    public String toString() {
        return "Lecturer{" +
                "ID=" + this.ID +
                ", userName='" + this.getUserName() + '\'' +
                ", password='" + this.getPassword() + '\'' +
                ", email='" + this.getEmailToString() + '\'' +
                ", phone='" + this.getPhoneToString() + '\'' +
                ", subjects=" + getSubjectsAsString() +
                '}';
    }
}

