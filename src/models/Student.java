package models;

import java.util.ArrayList;

public class Student extends Person{

    
    // Attributes
    private static int numOfStudents = 0;
    private int degree;
    private final int ID;
    private ArrayList<Subject> registeredSubjects ;
    

    // Constructor
    public Student(String username, String password) {
        super(username, password, "student");   
        this.ID = ++numOfStudents;
        this.registeredSubjects = new ArrayList<>();
        registeredSubjects.add(new Subject("Ai","Ai-201"));
        registeredSubjects.add(new Subject("Is","Is-201"));
        registeredSubjects.add(new Subject("IT","IT-201"));

    }



    // Setters 
    public void setDegree(int degree) {
        this.degree = degree;
    }

    public void setIsExamed () {
        // To do implementation
    }



    public boolean addSubject(Subject subj) {
        if (this.registeredSubjects.contains(subj)){ // not add the sub to the array
            return false;
        }
        else{
            this.registeredSubjects.add(subj);
            return true;
        }
    }



    public boolean delSubject(Subject subj) {
        if (this.registeredSubjects.contains(subj)){
            this.registeredSubjects.remove(subj);
            return true;
        }
        else{
            return false;
        }
    }
    

    // Getters
    public int getDegree() {
        return this.degree;
    }

    public boolean getIsExamed() {
        // To do implementation
        return true;
    }

    public ArrayList<Subject> getSubjects() {
        return registeredSubjects;
    }

    public String getSubjectsAsString() {
        String subjects = "";
        for(int i = 0; i < registeredSubjects.size();i++)
        {
            subjects += registeredSubjects.get(i).getSubjectName();

            if(i != registeredSubjects.size() -1)
            {
                subjects += ", ";

            }
        }
        return subjects;
    }

    public int findSubjIndex(int id) {

        for (int i = 0; i < registeredSubjects.size(); i++) { // loop on the list of subjects
            if (registeredSubjects.get(i).getSubjID() == id) // if the id of the subject equals the id we entered
                return i; // returns the index of the subject (index not id)
        }
        return -1; // else it returns -1
    }

    public Subject getSubject(int index) { // check that index is not -1
            return registeredSubjects.get(index);
    }


    public void enterExam() {
        // for (Subject subject : registeredSubjects) {
        //     System.out.println("Your accessable Exams: ");
        //     // loop for accessable exams for std
        // }
    }

    public int getID() {
        return this.ID;
    }
}

