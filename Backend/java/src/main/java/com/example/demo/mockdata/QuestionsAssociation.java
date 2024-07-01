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

        AssociationEntity entity = AssociationEntity.builder()
                .columnA(columnA)
                .columnB(columnB)
                .columnC(columnC)
                .columnD(columnD)
                .build();

        entity.addSolution("columnA_solution dim");
        entity.addSolution("columnB_solution gvozdje");
        entity.addSolution("columnC_solution kada");
        entity.addSolution("columnD_solution spustanje");
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


        AssociationEntity entity = AssociationEntity.builder()
                .columnA(columnA)
                .columnB(columnB)
                .columnC(columnC)
                .columnD(columnD)
                .build();

        entity.addSolution("columnA_solution film");
        entity.addSolution("columnB_solution rad");
        entity.addSolution("columnC_solution reakcija");
        entity.addSolution("columnD_solution fudbal");
        entity.addFinalSolution("akcija");
        return entity;
    }

}

