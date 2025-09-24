package com.gj.run;

import com.gj.dao.VisitDao;
import com.gj.models.Visit;
import com.gj.utils.DBConnection;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        VisitDao dao = new VisitDao();
        //dao.createVisit(new Visit(1, "Gabriel Juarez", "12345678", "gajuarez@ejemplo.com", "Ingeniero Mejia", "Reunion de trabajo"));
        //dao.createVisit(new Visit(2, "Ana Perez", "87654321", null, "Lic. Gomez", "Entrevista laboral"));
        //dao.createVisit(new Visit(3, "Luis Martinez", "11223344", "luismartinz@ejemplo.com", "Dr. Sanchez", "Consulta medica"));
        System.out.println("Todos los registros");
        for(Visit v : dao.listall()) {
            System.out.println(v);
        }
        System.out.println();
        System.out.println("Cerrando visita ID 38");
        dao.closeVisit(38);
        System.out.println("Todos los registros");
        for(Visit v : dao.listall()) {
            System.out.println(v);
        }
        System.out.println();
        System.out.println("Citas de hoy");
        for (Visit v: dao.listToday()){
            System.out.println(v);
        }
        System.out.println();
        System.out.println("Visitas abiertas" );
        for (Visit v: dao.listActive()){
            System.out.println(v);
        }



    }
}
