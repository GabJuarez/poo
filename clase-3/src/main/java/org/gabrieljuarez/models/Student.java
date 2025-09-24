package org.gabrieljuarez.models;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

public class Student {
    private String name;
    private String carrer;
    private String id;

    public Student(String name, String carrer, String id) {
        setId(id);
        setName(name);
        setCarrer(carrer);
    }

    public void setId(String id) {
        try{
            if (id.length() <= 7 || id.isEmpty() == true){
                throw new IllegalArgumentException();
            }
            else{
                this.id = id;
            }

        }catch (IllegalArgumentException e){
            System.out.println("La longitud del id deber ser mayor a 7");
        }
    }


    public void setName(String name) {
        this.name = String.valueOf(name.charAt(0)).toUpperCase() + name.substring(1,name.length()).toLowerCase();
    }

    public void setCarrer(String carrer) {
        try{
            CharacterIterator it = new StringCharacterIterator(carrer);
            while(it.current() != CharacterIterator.DONE){
                if(Character.isDigit(it.current()) == true) {
                    throw new IllegalArgumentException();
                }else{
                    it.next();
                }

            }
        }catch (IllegalArgumentException e){
            System.out.println("El nombre de la carrera solo acepta valores alfabeticos");
        }
    }


    public String getName() {
        return "Nombre: " + name;
    }

    public String getCarrer() {
        return "Carrera: " + carrer;
    }

    public String getId() {
        return "ID: " + id;
    }

    @Override
    public String toString() {
        String datos = String.format("%s, %s, %s\n", getId(), getName(), getCarrer());
        return datos;
    }
}

