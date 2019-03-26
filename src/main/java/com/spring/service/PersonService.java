package com.spring.service;

import com.spring.entity.Person;
import com.spring.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    // Question 3

    public void insert(Person person) {
        personRepository.save(person);
        System.out.println("Record inserted..");
    }


    public void read() {
        Iterable<Person> iterable = personRepository.findAll();
        Iterator<Person> iterator = iterable.iterator();
        System.out.println("Fetching records..");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("------------------------------------------");
    }

    public void isExist(Integer id) {
        System.out.println("\nRecord exist of id " + id + ": " + personRepository.exists(id));
    }


    public void delete(int id) {
        System.out.println("\nRecord deleted of id: " + id);
        personRepository.delete(id);
    }

    public void count() {
        System.out.println("\nNumber of total records are: " + personRepository.count());
    }

    public void findOne(Integer id) {
        System.out.println("\nExecuting findOne for id " + id + ": ");
        System.out.println(personRepository.findOne(id));
    }

    // Question 5
    public List getByFirstName(String name) {
        return personRepository.findByFirstName(name);
    }

    public List getByLastName(String name) {
        return personRepository.findByLastName(name);
    }

    public List getById(int id) {
        return personRepository.findById(id);
    }


    //Question6
    public void firstNameByAge(int age){
        System.out.println(personRepository.findByAge(age));
    }

    //Question 7
    public void getFnameAndLnameByAge(int age){
        List<Object[]> list=personRepository.findFullNameByAge(25);
        Iterator<Object[]> iterator=list.iterator();
        while (iterator.hasNext()){
            Object[] objects=iterator.next();
            System.out.println(objects[0] +" "+objects[1]);
        }
    }

    //Question 8
    public void getPersonInfo(int age){
        List<Person> personList = personRepository.getInfoByAge(age);
        System.out.println(personList);
    }

    //Question 9
    public void countPersonByName(String name){
        System.out.println(personRepository.countByPersonFirstName(name));
    }

    //Question 10

    public void countPersonByFirstName(String name){
        System.out.println("\nTotal number of person of name "+name+": "+personRepository.countByFirstName(name));
    }

    public void getDistinctPersonByFirstName(String name){
        System.out.println("\nDistinct by FirstName: "+personRepository.findDistinctByFirstName(name));
    }

    public void getPersonByOrOperation(Integer age, String name){
       List<Person> personList = personRepository.findByAgeOrFirstName(age,name);
       Iterator<Person> iterator = personList.iterator();
        System.out.println("\nDetail using Or: ");
       while (iterator.hasNext()){
           System.out.println(iterator.next());
       }
    }

    public void getPersonByAndOperation(Integer age, String name){
        List<Person> personList = personRepository.findByAgeAndFirstName(age,name);
        Iterator<Person> iterator = personList.iterator();
        System.out.println("\nDetail using And: ");
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    public void getPersonByAgeBetween(int min, int max){
        List<Person> personList = personRepository.findByAgeBetween(min,max);
        Iterator<Person> iterator = personList.iterator();
        System.out.println("\nRecords between age "+min+" and "+max+" are: ");
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    public void getPersonByAgeLessThan(int age){
        List<Person> personList = personRepository.findByAgeLessThan(age);
        Iterator<Person> iterator = personList.iterator();
        System.out.println("\nRecords Less than age "+age+" are: ");
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    public void getPersonByAgeGreaterThan(int age){
        List<Person> personList = personRepository.findByAgeGreaterThan(age);
        Iterator<Person> iterator = personList.iterator();
        System.out.println("\nRecords Greater than age "+age+" are: ");
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    public void getPersonByNameLike(String name){
        List<Person> personList = personRepository.findByFirstNameLike(name);
        Iterator<Person> iterator = personList.iterator();
        System.out.println("\nRecords of name like "+name+" are: ");
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    public void getPersonByNameNot(String name){
        List<Person> personList = personRepository.findByFirstNameNot(name);
        Iterator<Person> iterator = personList.iterator();
        System.out.println("\nRecords of name except "+name+" are: ");
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    public void getPersonByAgeIn(List<Integer> ageList){
        List<Person> personList = personRepository.findByAgeIn(ageList);
        Iterator<Person> iterator = personList.iterator();
        System.out.println("\nRecords in ageList "+ageList+" are: ");
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    public void getPersonByIgnoringCase(String name){
        List<Person> personList = personRepository.findByFirstNameIgnoreCase(name);
        Iterator<Person> iterator = personList.iterator();
        System.out.println("\nRecords of name "+name+" by ignoring case are: ");
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }


    // Question 11
    public void getPersonBySorting(int age){
        List<Person> personList = personRepository.findByAgeGreaterThanOrderByIdDesc(age);
        Iterator<Person> iterator = personList.iterator();
        System.out.println("\nRecords of greater than age "+age+" and sorting by id are: ");
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    //Question 12
    public void getPersonBySortClass(int age, Sort sort){
        List<Person> personList = personRepository.findAll(age, sort);
        Iterator<Person> iterator = personList.iterator();
        System.out.println("\nRecords of greater than age "+age+" and sorting by id using sort class : ");
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    //Question 13
    public void getPageContent(Pageable pageable){
        Page<Person> page = personRepository.findAll(pageable);
        List<Person> personList = page.getContent();
        Iterator<Person> iterator = personList.iterator();
        System.out.println("Page of size 3:");
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

}


