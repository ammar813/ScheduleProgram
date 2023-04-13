package SchedulePackage;


import java.util.ArrayList;
import java.util.List;
import java.util.*;


public class Schedule {
    
    public static int[] restrainedDays = new int[5]; 
    // 1 == sunday
    // 2 == monday
    // 3 == tuesday
    // 4 == wednesday
    // 5 == thursday

    public List<Course> CoursesList = new ArrayList<>();

    public void addCourse(Course c) {
        CoursesList.add(c);
    }
    
    public static List<List<Section>> checkForRestrains(List<List<Section>> list)
    {
        List<List<Section>> AllTestList = new ArrayList<>();
        
        for (int i = 0; i < list.size(); i++) 
        {
            boolean IsThereRestrains = false;
            //System.out.println("###############");
            List<Section> Testlist = new ArrayList<>();
            for (int j = 0; j < list.get(i).size(); j++) {
                Testlist.add(list.get(i).get(j));
                //list.get(i).get(j).printSection();
            }
        
            for (int k = 0; k < Testlist.size(); k++) 
            {
                for (int s = 0; s < Testlist.get(k).Periods.size(); s++) 
                {
                    for (int element : restrainedDays)
                    {
                        if (element == ((Testlist.get(k).Periods.get(s) / 100) % 10))
                        {
                            IsThereRestrains = true;
                            break;
                        }
                    }
                }        
            }
            
            if (!IsThereRestrains)
            {
                AllTestList.add(Testlist);
            }
        }
        
        return AllTestList;
    }

    public static String ToString(List<List<Section>> Sections) {
        String output = ""; 

        for (int i = 0; i < Sections.size(); i++) {
            output = output.concat("#####################\n");
            for (int j = 0; j < Sections.get(i).size(); j++) {
                Section tmp = Sections.get(i).get(j);

                output = output.concat("--------\n");
                output = output.concat("Section Course: " + tmp.CourseId + "\n");
                output = output.concat("Section id: " + tmp.SecId + "\n");
                for (int k = 0; k < tmp.Periods.size(); k++) {
                    output = output.concat("period " + k + ": " + Section.GetDayAndTime(tmp.Periods.get(k)) + "\n");
                }
                output = output.concat("--------\n");

            }
            output = output.concat("#####################\n");
        }
        
        return output;
    }

    public static List<List<Section>> GetfirstValidCombo(List<List<Section>> list) {
        List<List<Section>> AllTestList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            //System.out.println("###############");
            List<Section> Testlist = new ArrayList<>();
            for (int j = 0; j < list.get(i).size(); j++) {
                Testlist.add(list.get(i).get(j));
                //list.get(i).get(j).printSection();
            }

            if (Section.Testfunc(Testlist)) {
                //System.out.println("clash");

            } else {
                System.out.println("no clash");
                AllTestList.add(Testlist);

            }

        }
        return AllTestList;
    }

    public static List<List<Section>> allcomb(List<Course> coureses) {
        int sizeArray[] = new int[coureses.size()];

        int counterArray[] = new int[coureses.size()];

        int totalCombinationCount = 1;

        for (int i = 0; i < coureses.size(); ++i) {
            sizeArray[i] = coureses.get(i).SecList.size();
            totalCombinationCount *= coureses.get(i).SecList.size();
        }

        List<List<Section>> combinationList = new ArrayList<>(totalCombinationCount);
        Section[] tmp = new Section[coureses.size()];

        for (int countdown = totalCombinationCount; countdown > 0; --countdown) {

            for (int i = 0; i < coureses.size(); ++i) {
                tmp[i] = coureses.get(i).SecList.get(counterArray[i]);
            }
            List<Section> list = new ArrayList<>();

            for (Section i : tmp) {
                list.add(i);
            }
            combinationList.add(list);

            // add new combination to list
            // Now we need to increment the counterArray so that the next
            // combination is taken on the next iteration of this loop.
            for (int incIndex = coureses.size() - 1; incIndex >= 0; --incIndex) {
                if (counterArray[incIndex] + 1 < sizeArray[incIndex]) {
                    ++counterArray[incIndex];
                    // None of the indices of higher significance need to be
                    // incremented, so jump out of this for loop at this point.
                    break;
                }
                // The index at this position is at its max value, so zero it
                // and continue this loop to increment the index which is more
                // significant than this one.
                counterArray[incIndex] = 0;
            }

        }

        return combinationList;

    }

}
