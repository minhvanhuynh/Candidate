/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import model.Candidate;

/**
 *
 * @author This PC
 */
public class Validation {
    private final static Scanner sc= new Scanner(System.in);
    
    public static int checkInputIntLimit(int min, int max){
        while(true){
            try{
                int birthDate= Integer.parseInt(sc.nextLine().trim());
                if(birthDate < min || birthDate > max)
                    throw new Exception();
                else return birthDate;             
            }catch(Exception e){
                System.out.println("Please input number in range ["+min+", "+max+"]!");
                System.out.println("Enter again: ");
            }
        }
    }
    
    public static String checkInputString() {
        while (true) {
            String string = sc.nextLine().trim();
            if (string.isEmpty()) {
                System.out.println("Not allowed empty!");
                System.out.println("Enter again; ");
            } else {
                return string;
            }
        }
    }

    public static String checkPhone() {
        while (true) {
            String phone = checkInputString();
            String format = "^\\d{10}\\d*";
            if (phone.matches(format)) {
                return phone;
            } else {
                System.out.println("Phone is number with minimum 10 characters!");
                System.out.println("Enter again: ");
            }
        }
    }
    public static String checkEmail(){
        while(true){
            String email= checkInputString();
            String format="^[A-Za-z0-9.+-_%]+@[A-Za-z.-]+\\.[A-Za-z]{2,4}$";
            if(email.matches(format)){
                return email;
            }else{
                System.out.println("Email with format <account name>@<domain>");
                System.out.println("Enter again: ");
            }
        }
    }
    
    public static String checkRankOfGraduation() {
        while (true) {
            String rankOfGraduation = checkInputString();
            if (rankOfGraduation.equalsIgnoreCase("Exellence")
                    || rankOfGraduation.equalsIgnoreCase("Good")
                    || rankOfGraduation.equalsIgnoreCase("Fair")
                    || rankOfGraduation.equalsIgnoreCase("Poor")) {
                return rankOfGraduation;
            }else{
                System.out.println("Please input string: Excellence, Good, Fair, Poor");
                System.out.println("Enter again: ");
            }
        }
    }
    
    public static boolean checkInputYesNo(){
        while(true){
            String result= checkInputString();
            if(result.equalsIgnoreCase("Y")){
                return true;
            }else if(result.equalsIgnoreCase("N")){
                return false;
            }
            System.out.println("Please input y/Y or n/N.");
            System.out.println("Enter again: ");
        }   
    }
    
    public static boolean checkIdExist(ArrayList<Candidate> list, String id){
        for (Candidate candidate : list) {
            if(candidate.getId().equalsIgnoreCase(id)){
                System.out.println("Id exist in list!");
                return false;
            }
        }
        return true;
    }
    
    public static int checkInputExperience(int birthDate){
        int yearCurrent= Calendar.getInstance().get(Calendar.YEAR);
        int age= yearCurrent - birthDate;
        while(true){
            int yearExperience= checkInputIntLimit(0, 100);
            if(yearExperience > age){
                System.out.println("Invalid! Because year experience more than age");
            }else{
                return yearExperience;
            }
        }
        
    }       

    public static int checkInt() {
        while (true) {
            try {
                String year = checkInputString();
                int result = Integer.parseInt(year);
                if(result>1900){
                    return result;
                }else{
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Just enter year>1900!");
                System.out.println("Enter again: ");
                continue;
            }
        }

    }

    
    public static int checkInputGraduationDate(int birthDate) {
        while (true) {
            int graduationDate = checkInt();
            if (graduationDate >= (18 + birthDate + 4)) {
                return graduationDate;
            }else{
                System.out.println("Invalid! Enter again: ");
                continue;
            }
        }

    }
}