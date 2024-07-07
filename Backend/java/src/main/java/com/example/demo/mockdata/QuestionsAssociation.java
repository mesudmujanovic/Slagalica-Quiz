package com.example.demo.mockdata;

import com.example.demo.Enitity.AssociationEntity;

import java.util.ArrayList;
import java.util.List;

public class QuestionsAssociation {
    public static AssociationEntity getMockAssociation() {
        List<String> columnA = new ArrayList<>();
        columnA.add("vatra");
        columnA.add("cigarete");
        columnA.add("gust");
        columnA.add("signal");

        List<String> columnB = new ArrayList<>();
        columnB.add("maska");
        columnB.add("metal");
        columnB.add("staro");
        columnB.add("krv");

        List<String> columnC = new ArrayList<>();
        columnC.add("djakuzi");
        columnC.add("kupka");
        columnC.add("malter");
        columnC.add("korito");

        List<String> columnD = new ArrayList<>();
        columnD.add("snizavanje");
        columnD.add("pritisak");
        columnD.add("rampa");
        columnD.add("tobogan");

        AssociationEntity entity = new AssociationEntity();
        entity.setColumnA(columnA);
        entity.setColumnB(columnB);
        entity.setColumnC(columnC);
        entity.setColumnD(columnD);

        entity.addSolutionToColumn("ColumnA", "dim");
        entity.addSolutionToColumn("columnB", "gvozdje");
        entity.addSolutionToColumn("columnC", "kada");
        entity.addSolutionToColumn("columnD", "spustanje");
        entity.addFinalSolution("zavesa");

        return entity;
    }

    public static AssociationEntity getMockAssociation2() {
        List<String> columnA = new ArrayList<>();
        columnA.add("festival");
        columnA.add("fotro-aparat");
        columnA.add("horor");
        columnA.add("televizor");

        List<String> columnB = new ArrayList<>();
        columnB.add("odelo");
        columnB.add("navika");
        columnB.add("naporan");
        columnB.add("honorar");

        List<String> columnC = new ArrayList<>();
        columnC.add("odgovor");
        columnC.add("alergija");
        columnC.add("akcija");
        columnC.add("hemija");

        List<String> columnD = new ArrayList<>();
        columnD.add("pesak");
        columnD.add("fifa");
        columnD.add("uefa");
        columnD.add("stadion");

        AssociationEntity entity = new AssociationEntity();
        entity.setColumnA(columnA);
        entity.setColumnB(columnB);
        entity.setColumnC(columnC);
        entity.setColumnD(columnD);

        entity.addSolutionToColumn("columnA", "film");
        entity.addSolutionToColumn("columnB", "rad");
        entity.addSolutionToColumn("columnC", "reakcija");
        entity.addSolutionToColumn("columnD", "fudbal");
        entity.addFinalSolution("akcija");

        return entity;
    }
}
