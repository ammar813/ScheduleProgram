package SchedulePackage;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Course {
    static final String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday"};
    String courseName;
    int numOfSec;
    int hours;
    public List<Section> SecList = new ArrayList<>();
    
    
    public Course(String name, int num, int hours)
    {
        this.courseName = name;
        this.numOfSec = num;
        this.hours = hours;
        
//        Scanner s = new Scanner(System.in);
//        for (int i = 0; i < numOfSec; i++)
//        {
//            int[] tmpPeriods = new int[hours * 5]; // fix this
//            for (int j = 0; j < 5; j++)
//            {
//                System.out.println("enter all the periods for " + days[j] + "| enter zero if no class");
//                // first ask what day then ask about periods
//                for (int k = 0; k < hours; k++)
//                {
//                    System.out.println("enter " + (k + 1) + " period for " + this.courseName + " Section num: " + (i + 1));
//                    int tmp = s.nextInt();
//                    if (tmp == 0)
//                    {
//                        continue;
//                    }
//                    tmpPeriods[((k + 1) * (j + 1)) - 1] = tmp + (100 * (j + 1)); // 0 means no classes
//                }
//                
//            
//            }
//            
//            Section tmp = new Section(i + 1, RemoveZeros(tmpPeriods), this.courseName);
//            SecList.add(tmp);
//        }
        
    }
    
    int[] RemoveZeros(int[] array)
    {
        int targetIndex = 0;
        for (int sourceIndex = 0; sourceIndex < array.length; sourceIndex++) {
            if (array[sourceIndex] != 0) {
                array[targetIndex++] = array[sourceIndex];
            }
        }
        int[] newArray = new int[targetIndex];
        System.arraycopy(array, 0, newArray, 0, targetIndex);
        return newArray;
    }
    
    void printCourse()
    {
        System.out.println("Course name: " + this.courseName);
        for (int i = 0; i < this.SecList.size(); i++)
        {
            SecList.get(i).printSection();
        }
    }
}
