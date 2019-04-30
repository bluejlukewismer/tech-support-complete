import java.util.ArrayList;
import java.lang.Math;
/**
 * Write a description of class Parser here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Parser
{
    // instance variables - replace the example below with your own
    private ArrayList <String> list;

    /**
     * Constructor for objects of class Parser
     */
    public Parser()
    {
        // initialise instance variables
        list = new ArrayList <String>();
    }

    public ArrayList <String> listMaker(String str)
    {
        int size =(int)  Math.pow(2,str.length()/2); 
        int length = str.length();
        ArrayList <String> strings = new ArrayList <String>();
        for (int i = 0; i < size; i++)
        {
            String tempStr="";
            for (int j=0; j<length/2; j++)
            {
                int k = (int) Math.pow(2,j);
                boolean shift = ((i & k) == 0);
                if (!shift)
                {
                    tempStr = tempStr + str.substring(2*j+1,2*j+2);
                }
                else
                {
                    tempStr = tempStr + str.substring(2*j,2*j + 1);
                }
            }
            strings.add(tempStr);
        }
        return strings;
    }
    
    public ArrayList<String> cross(String str1, String str2)
    {
        ArrayList <String> list1 = listMaker(str1);
        ArrayList <String> list2 = listMaker(str2);
        ArrayList <String> cross = new ArrayList<String>();
        for (String stringA: list1)
        {
            for(String stringB: list2)
            {
                cross.add(merge(stringA, stringB));
            }
        }
        return cross;
    }
    
    public String merge(String str1, String str2)
    {
        String str ="";
        for(int i = 0; i < str1.length(); i++)
        {
            if(str1.substring(i,i+1).toUpperCase().equals(str1.substring(i,i+1)))
            {
                str += str1.substring(i,i+1);
                str += str2.substring(i,i+1);
                
            }
            else
            {
                str += str2.substring(i,i+1);
                str += str1.substring(i,i+1);
            }
        }
        return str;
    }
}
