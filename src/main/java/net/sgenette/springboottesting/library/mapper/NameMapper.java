package net.sgenette.springboottesting.library.mapper;

import net.sgenette.springboottesting.library.core.model.Name;
import org.springframework.stereotype.Component;

@Component
public class NameMapper {

    public String nameToString(Name name) {
        return name.getName();
    }

    public Name stringToName(String name) {
        return new Name(name);
    }
}
