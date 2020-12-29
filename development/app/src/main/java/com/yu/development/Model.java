package com.yu.development;

public class Model {
    private int ID;
    private String Text ;


    public Model (){

    }
    public Model (String text){
        this.Text=text;

    }
    public int getID(){
        return ID;
    }
    public String getText(){
        return  Text;
    }
    public void setID(int ID){
        this.ID=ID;
    }
    public void setText(String text){
        Text = text ;

    }
}
