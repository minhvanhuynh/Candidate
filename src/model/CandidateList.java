/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.Calendar;
import view.Validation;

/**
 *
 * @author This PC
 */
public class CandidateList {
    private static ArrayList<Candidate> list;
    private static ArrayList<Experience> listExperience;
    private static ArrayList<Fresher> listFresher;
    private static ArrayList<Intern> listIntern;
    private Validation validation;
    
    
    public CandidateList(){
        this.list= new ArrayList<>();
        this.listExperience= new ArrayList<>();
        this.listFresher= new ArrayList<>();
        this.listIntern= new ArrayList<>();
        this.validation= new Validation();
    }
    
    public static void createCandidate(int type){
        while(true){
            System.out.println("Enter id: ");
            String id= Validation.checkInputString();
            if(!Validation.checkIdExist(list, id)){
                return;
            }
            System.out.println("Enter first name: ");
            String firstName= Validation.checkInputString();
            System.out.println("Enter last name: ");
            String lastName= Validation.checkInputString();
            System.out.println("Enter birth date: ");
            int birthDate= Validation.checkInputIntLimit(1990, Calendar.getInstance().get(Calendar.YEAR));
            System.out.println("Enter address: ");
            String address= Validation.checkInputString();
            System.out.println("Enter phone: ");
            String phone= Validation.checkPhone();
            System.out.println("Enter email: ");
            String email= Validation.checkEmail();
            Candidate candidate= new Candidate(id, firstName, lastName, birthDate, address, phone, email, type);
            switch (type) {
                case 0:
                    createExperience(candidate);
                    break;
                case 1:
                    createFresher(candidate);
                    break;
                case 2:
                    createIntern(candidate);
                    break;
            }
            System.out.println("Do you want to continue (Y/N): ");
            if(!Validation.checkInputYesNo()){
                return;
            }
        }
    }
    
    public static void createExperience(Candidate candidate) {
        System.out.println("Enter year of experience: ");
        int yearExperience = Validation.checkInputExperience(candidate.getBirthDate());
        System.out.println("Enter professional skill: ");
        String professionalSkill = Validation.checkInputString();
        list.add(candidate);
        Experience experience= new Experience(candidate.getId(), candidate.getFirstName(), candidate.getLastName(),
                candidate.getBirthDate(), candidate.getAddress(),
                candidate.getPhone(), candidate.getEmail(), candidate.getTypeCandidate(), yearExperience, professionalSkill);
        listExperience.add(experience);
    }
    
    public static void createFresher(Candidate candidate) {
        System.out.println("Enter graduation date: ");
        int graduationDate = Validation.checkInputGraduationDate(candidate.getBirthDate());
        System.out.println("Enter graduation rank: ");
        String graduationRank = Validation.checkRankOfGraduation();
        System.out.println("Enter university graduation: ");
        String nameUniversity= Validation.checkInputString();
        list.add(candidate);
        Fresher fresher= new Fresher(candidate.getId(), candidate.getFirstName(), candidate.getLastName(),
                candidate.getBirthDate(), candidate.getAddress(),
                candidate.getPhone(), candidate.getEmail(), candidate.getTypeCandidate(), graduationDate, graduationRank, nameUniversity);
        listFresher.add(fresher);
    }
    
     public static void createIntern(Candidate candidate) {
        System.out.print("Enter major: ");
        String major = Validation.checkInputString();
        System.out.print("Enter semester: ");
        String semester = Validation.checkInputString();
        System.out.print("Enter university: ");
        String university = Validation.checkInputString();
        list.add(candidate);
        Intern intern= new Intern(candidate.getId(), candidate.getFirstName(), candidate.getLastName(),
                candidate.getBirthDate(), candidate.getAddress(),
                candidate.getPhone(), candidate.getEmail(), candidate.getTypeCandidate(),major, semester, university);
        listIntern.add(intern);
    }
    
    public static void printListCandidate(){
        System.out.println("List of candidate:");
        System.out.println("===========EXPERIENCE CANDIDATE============");
        if (!listExperience.isEmpty()) {          
            for (Experience experience : listExperience) {
                System.out.println(experience.getFirstName() + " " + experience.getLastName());
            }
        }else System.out.println("Empty! No Candidate!");
        
        System.out.println("===========FRESHER CANDIDATE===============");
        if (!listFresher.isEmpty()) {     
            for (Fresher fresher : listFresher) {
                System.out.println(fresher.getFirstName() + " " + fresher.getLastName());
            }
        }else System.out.println("Empty! No Candidate!");
        
        System.out.println("===========INTERN CANDIDATE================");
        if (!listIntern.isEmpty()) {           
            for (Intern intern : listIntern) {
                System.out.println(intern.getFirstName() + " " + intern.getLastName());
            }
        }else System.out.println("Empty! No Candidate!");
    
    } 
    
    public static void searchCandidate(){       
        int count=0;
        printListCandidate();
        System.out.print("Enter andidate name (First name or Last name): ");
        String nameSearch = Validation.checkInputString();
        System.out.print("Enter type of candidate: ");          
        int typeCandidate = Validation.checkInputIntLimit(0, 2);
        System.out.println();
        System.out.println("The candidates found: ");
        for(Candidate candidate: list){
            if(candidate.getTypeCandidate()==typeCandidate &&
                    (candidate.getFirstName().contains(nameSearch)||candidate.getLastName().contains(nameSearch))){
                System.out.println(candidate.toString());
                count++;               
            }
        }
        if(count==0) System.out.println("No Found Information Candidate!");    
    }

}
