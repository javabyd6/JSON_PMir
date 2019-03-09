package com.sda.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Person person = new Person("Jan", "Kowalski", 44);
        Person person1 = new Person("Paweł", "Mirgos",31);

        ObjectMapper mapper = new ObjectMapper();
        try {
            String personStr = mapper.writeValueAsString(person);
            System.out.println(personStr);
            Files.write(Paths.get("person.json"),personStr.getBytes());
            mapper.writeValue(new File("person1.json"),person);
        } catch (IOException e) {
            //e.printStackTrace();
        }


        List<Person> personList = new ArrayList<>();
        personList.add(person);
        personList.add(person1);
        personList.add(new Person("Marek","M.",65));
        personList.add(new Person("Michał","M.",39));

        ObjectMapper personL = new ObjectMapper();
        try {
            String persony = mapper.writeValueAsString(personList);
            Files.write(Paths.get("personlista.json"),persony.getBytes());
        } catch (IOException e) {
            //e.printStackTrace();
        }

    }

}
