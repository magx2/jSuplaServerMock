package pl.grzeslowski.jsuplaservermock;

import org.springframework.boot.CommandLineRunner;

public class DatabaseInitializer implements CommandLineRunner {
    private final Database database;

    public DatabaseInitializer(final Database database) {
        this.database = database;
    }

    @Override
    public void run(final String... strings) throws Exception {
        // TODO initialize
    }
}
