package pl.grzeslowski.jsuplaservermock.service;

import static java.lang.String.format;

public final class EntityNotFoundException extends RuntimeException {
    private final Class<?> clazz;
    private final int id;

    public EntityNotFoundException(final Class<?> clazz, final int id) {
        super(format("Entity with ID `%s.%s` was not found!", clazz.getSimpleName(), id));
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
