package me.nimkoes;

import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class PersonFormatter implements Formatter<Person> {

    @Override
    public Person parse(String text, Locale locale) throws ParseException {
        Person person = new Person();
        person.setName(text);
        return person;
    }

    // 현재 사용하고 있지 않지만 임시로 toString 을 반환하도록 구현
    @Override
    public String print(Person object, Locale locale) {
        return object.toString();
    }
}
