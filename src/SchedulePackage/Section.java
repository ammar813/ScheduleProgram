package SchedulePackage;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Section {
     int SecId;
     String CourseId;
    public List<Integer> Periods = new ArrayList<>();
    // 1   7:15 - 8:05
    // 2   8:15 - 9:05
    // 3   9:15 - 10:05
    // 4   10:15 - 11:05
    // 5   11:15 - 12:05
    // 6   12:15 - 13:05
    // 7   13:15 - 14:05
    // 8   14:15 - 15:05
    // 9   15:15 - 16:05
    // 10  16:15 - 17:05
    public void AddPeriod(int a)
    {
        if (!Periods.contains(a))
        {
            Periods.add(a);
            Collections.sort(Periods);
        }
        
    }
    public Section(int id, int[] periods, String Course)
    {
        
        this.SecId = id;
        this.CourseId = Course;
        
        for (int i = 0; i < periods.length; i++)
        {
        //Console.WriteLine("d");
            Periods.add(periods[i]);  
        }
        
    }
    
    public Section(String SectionNumber, String Course)
    {
        this.SecId = Integer.parseInt(SectionNumber);
        this.CourseId = Course;
    }
    
    
    public static boolean Testfunc(List<Section> list)
    {
        
        List<Integer> intList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).Periods.size(); j++) {
                intList.add(list.get(i).Periods.get(j));
            }
            
        }
        
        Set<Integer> set = new HashSet<Integer>(intList);

        if (set.size() < intList.size()) {
            return true;
        }
        //Collections.sort(intList);
        //for (int i = 0; i < intList.size() - 1; i++) { 
        //    if (intList.get(i) == intList.get(i + 1))
        //    {   
        //        return true;
        //    }
        //}
        
        
        return false;
    }
    
    //void PrintSecPeriods()
    //{
    //    for (int i = 0; i < this.Periods.size(); i++)
    //    {
    //        System.out.println("period " + i + ": " + Periods.get(i));
    //    }
    //}
    
    void printSection()
    {
        System.out.println("--------");
        System.out.println("Section Course: " + this.CourseId);
        System.out.println("Section id: " + this.SecId);
        for (int i = 0; i < this.Periods.size(); i++)
        {
            System.out.println("period " + i + ": " + GetDayAndTime(Periods.get(i)));
        }
        System.out.println("--------");
    }
    
    public static String GetDayAndTime(int a)
    {
        if (a > 500)
        {
            return "Thursday " + GetPeriodTime(a - 500);
        }
        else if (a > 400)
        {
            return "Wedensday " + GetPeriodTime(a - 400);
        }
        else if (a > 300)
        {
            return "Tuesday " + GetPeriodTime(a - 300);
        }
        else if (a > 200)
        {
            return "Monday " + GetPeriodTime(a - 200);
        }
        else if (a > 100)
        {
            return "Sunday " + GetPeriodTime(a - 100);
        }
        return "nothing";
    }
    public static String GetPeriodTime(int a)
    {
        switch (a)
        {
            case 1:
                return "7:15 - 8:05";
            case 2:
                return "8:15 - 9:05";
            case 3:
                return "9:15 - 10:05";
            case 4:
                return "10:15 - 11:05";
            case 5:
                return "11:15 - 12:05";
            case 6:
                return "12:15 - 13:05";
            case 7:
                return "13:15 - 14:05";
            case 8:
                return "14:15 - 15:05";
            case 9:
                return "15:15 - 16:05";
            case 10:
                return "16:15 - 17:05";
            case 11:
                return "17:15 - 18:05";
            default:
                return "0 or higher than 2";
        }
    }
}
