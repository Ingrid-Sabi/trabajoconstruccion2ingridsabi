package app.infrastructure.persistence.mapper;


import app.domain.model.Person;
import app.infrastructure.persistence.entities.PersonEntity;


public class PersonMapper {

    public static PersonEntity toEntity(Person person) {
        if (person == null) {
            return null;
        }

        PersonEntity entity = new PersonEntity();
        entity.setId(person.getId());
        entity.setName(person.getName());
        entity.setDocument(person.getDocument());
        entity.setEmail(person.getEmail());
        entity.setPhoneNumber(person.getPhoneNumber());
        entity.setAge(person.getAge());
        entity.setAddress(person.getAddress());
        entity.setRole(person.getRole());
        return entity;
    }

    public static Person toDomain(PersonEntity entity) {
        if (entity == null) {
            return null;
        }

        Person person = new Person();
        person.setId(entity.getId());
        person.setName(entity.getName());
        person.setDocument(entity.getDocument());
        person.setEmail(entity.getEmail());
        person.setPhoneNumber(entity.getPhoneNumber());
        person.setAge(entity.getAge());
        person.setAddress(entity.getAddress());
        person.setRole(entity.getRole());
        return person;
    }
}
