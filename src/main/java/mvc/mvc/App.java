package mvc.mvc;

import mvc.mvc.controller.ExpertController;
import mvc.mvc.model.dto.Expert;
import mvc.mvc.model.table.CreateTable;

public class App 
{
    public static void main( String[] args )
    {
        ExpertController con=new ExpertController();
        //con.updateExpertView();
        
        //con.updateAllExperts();
        
        CreateTable.createExpertTable(new Expert());
    }
}
