package pl.grzeslowski.jsuplaservermock.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import static java.lang.String.format;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public final class EntityNotFoundException extends RuntimeException {
    private final Class<?> clazz;
    private final int id;

    public EntityNotFoundException(final Class<?> clazz, final int id) {
        super(format("Entity `%s` with ID `%s` was not found!", clazz.getSimpleName(), id));
        this.clazz = clazz;
        this.id = id;
    }

    @Override
    public String toString() {
        return "EntityNotFoundException{" +
                       "clazz=" + clazz +
                       ", id=" + id +
                       "} " + super.toString();
    }
}
