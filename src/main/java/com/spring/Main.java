package com.spring;

import com.spring.entity.Person;
import com.spring.service.PersonService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext("com.spring");
        PersonService personService = ctx.getBean(PersonService.class);


        //Question 3

        /*Person vishal = new Person("Vishal","Aggarwal", 22, 15000);
        Person rehan = new Person("Rehan","Khan",25,20000);
        Person anoop = new Person("Anoop","Kumar",32,35000);
        Person aman = new Person("Aman","Choudhary",25,30000);

        personService.insert(vishal);
        personService.insert(rehan);
        personService.insert(anoop);
        personService.insert(aman);

        personService.read();

        personService.count();

        personService.findOne(2);

        personService.isExist(1);

        personService.delete(1);*/


        //Question 4

        /*System.out.println(personService.getByFirstName("Rehan"));
        System.out.println(personService.getByLastName("Khan"));
        System.out.println(personService.getById(2));*/

        //Question 6
        //personService.firstNameByAge(25);

        //Question 7
        //personService.getFnameAndLnameByAge(25);

        //Question 8
        //personService.getPersonInfo(25);

        //Question 9
        //personService.countPersonByName("Peter");

        //Question 10
        /*personService.countPersonByFirstName("Peter");
        personService.getDistinctPersonByFirstName("Peter");
        personService.getPersonByOrOperation(90,"Peter");
        personService.getPersonByAndOperation(20,"Peter");
        personService.getPersonByAgeBetween(20,28);
        personService.getPersonByAgeLessThan(27);
        personService.getPersonByAgeGreaterThan(25);
        personService.getPersonByNameLike("A%");
        personService.getPersonByNameNot("Peter");
        personService.getPersonByAgeIn(Arrays.asList(20,27,25));
        personService.getPersonByIgnoringCase("peTer");*/

        //Question 11
        //personService.getPersonBySorting(25);

        //Question 12
        //personService.getPersonBySortClass(25, new Sort(Sort.Direction.DESC,"id"));

        //Question 13
        personService.getPageContent(new PageRequest(0,3));

    }
}
