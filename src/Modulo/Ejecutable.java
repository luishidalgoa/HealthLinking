package Modulo;

public class Ejecutable {
    public static void main(String[] args) {
        Menus menus=new Menus();
        for(boolean End=false;!End;){
            End=menus.Index();
        }
    }
}