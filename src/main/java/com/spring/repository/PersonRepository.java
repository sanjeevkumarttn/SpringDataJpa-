package com.spring.repository;

import com.spring.entity.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Integer> {


    // Question 4
    List<Person> findByFirstName(String name);

    List<Person> findByLastName(String name);

    List<Person> findById(int id);

    //Question 6
    @Query("SELECT firstName from Person where age=:age")
    List<String> findByAge(@Param("age") Integer age);

    //Question 7
    @Query("select firstName, lastName from Person where age=:age")
    List<Object[]> findFullNameByAge(@Param("age") Integer age);

    //Question 8
    @Query("select p from Person p where p.age=:age")
    List<Person> getInfoByAge(@Param("age") Integer age);

    //Question 9
    @Query("select count(p) from Person p where p.firstName=:name")
    Integer countByPersonFirstName(@Param("name") String name);


    // Question 10

    Integer countByFirstName(String name);

    List<Person> findDistinctByFirstName(String name);

    List<Person> findByAgeOrFirstName(Integer age, String name);

    List<Person> findByAgeAndFirstName(Integer age, String name);

    List<Person> findByAgeBetween(int min, int max);

    List<Person> findByAgeLessThan(int age);

    List<Person> findByAgeGreaterThan(int age);

    List<Person> findByFirstNameLike(String name);

    List<Person> findByFirstNameNot(String name);

    List<Person> findByAgeIn(List<Integer> ageList);

    List<Person> findByFirstNameIgnoreCase(String name);

    // Question 11

    List<Person> findByAgeGreaterThanOrderByIdDesc(int age);

    // Question 12
    @Query("select p from Person p where p.age>:age")
    List<Person> findAll(@Param("age") Integer age, Sort sor);

    //Question 13
    Page<Person> findAll(Pageable pageable);


}
