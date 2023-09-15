/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.CandidateList;
import view.Menu;

/**
 *
 * @author This PC
 */
public class ManagerCandidate extends Menu<String>{
    
    
    CandidateList candidateList= new CandidateList();   
    public ManagerCandidate(String title, String[] s){
        super(title, s);
    }
    
    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                CandidateList.createCandidate(0);
                break;
            case 2:
                CandidateList.createCandidate(1);
                break;
            case 3:
                CandidateList.createCandidate(2);
                break;
            case 4:
                CandidateList.searchCandidate();
                break;
            case 5:
                return;
        }
    }
    public static void main(String[] args) {
        String title= "PROGRAMING MANAGEMENT CANDIDATE";
        String[] s= new String[] {"Experience", "Fresher", "Intern", "Searching", "Exit"};
        //new ManagerCandidate(title, args).run();
        Menu<String> menu= new ManagerCandidate(title, s);
        menu.run();
    }
    
}
