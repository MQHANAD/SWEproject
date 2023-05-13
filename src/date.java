import java.time.LocalDate;
import java.util.ArrayList;

public class date {
    private String date;
    private int day;
    private int month;
    private int year;
    private LocalDate date1;
    String[] daysList ;


    public date(LocalDate date1){
        this.date1=date1;
        date = date1.toString();
        String[] daysList = date.split("/"); 
    }
    

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String addDays(int days){
        int foo;
        int month;
        try {
            foo = Integer.parseInt(daysList[0]);
            month= Integer.parseInt(daysList[1]);
         }
         catch (NumberFormatException e) {
            foo = 0;
            month=0;
         }
         
         if (month==1){
            if (days+foo>31){
                foo = (days+foo)-31;
                month++;
            }
            else{
                foo = days+foo;
            }

         }
         else if(month == 2){
            if (days+foo>28){
                foo = (days+foo)-31;
                month++;
            }
            else{
                foo = days+foo;
            }
         }
         else if(month == 3){
            if (days+foo>31){
                foo = (days+foo)-31;
                month++;
            }
            else{
                foo = days+foo;
            }
         }
         else if(month == 4){
            if (days+foo>30){
                foo = (days+foo)-31;
                month++;
            }
            else{
                foo = days+foo;
            }
         }
         else if(month == 5){
            if (days+foo>31){
                foo = (days+foo)-31;
                month++;
            }
            else{
                foo = days+foo;
            }
         }
         else if(month == 6){
            if (days+foo>30){
                foo = (days+foo)-31;
                month++;
            }
            else{
                foo = days+foo;
            }
         }
         else if(month == 7){
            if (days+foo>31){
                foo = (days+foo)-31;
                month++;
            }
            else{
                foo = days+foo;
            }
         }
         else if(month == 8){
            if (days+foo>31){
                foo = (days+foo)-31;
                month++;
            }
            else{
                foo = days+foo;
            }
         }
         else if(month == 9){
            if (days+foo>30){
                foo = (days+foo)-31;
                month++;
            }
            else{
                foo = days+foo;
            }
         }
         else if(month == 10){
            if (days+foo>31){
                foo = (days+foo)-31;
                month++;
            }
            else{
                foo = days+foo;
            }
         }
         else if(month == 11){
            if (days+foo>30){
                foo = (days+foo)-31;
                month++;
            }
            else{
                foo = days+foo;
            }
         }
         else if(month == 12){
            if (days+foo>31){
                foo = (days+foo)-31;
                month++;
            }
            else{
                foo = days+foo;
            }
         }
         
         return foo+"/"+month+"/"+daysList[3];
         

    }
}
