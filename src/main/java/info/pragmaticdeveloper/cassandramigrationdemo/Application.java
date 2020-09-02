package info.pragmaticdeveloper.cassandramigrationdemo;

import com.datastax.oss.driver.api.core.CqlSession;
import info.pragmaticdeveloper.cassandramigrationdemo.domain.ConnectedDevices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.core.query.Criteria;
import org.springframework.data.cassandra.core.query.Query;

import java.util.UUID;

@SpringBootApplication
public class Application implements CommandLineRunner {
    @Autowired
    private CqlSession cqlSession;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        CassandraOperations template = new CassandraTemplate(cqlSession);
        ConnectedDevices devices = new ConnectedDevices();
        devices.setId(UUID.randomUUID());
        devices.setProtocol("H02");
        devices.setTotal(10);
        ConnectedDevices savedDevices = template.insert(devices);
        System.out.println(template.selectOne(Query.query(Criteria.where("id").is(savedDevices.getId())), ConnectedDevices.class).getId());
    }
}
