package info.pragmaticdeveloper.cassandramigrationdemo.domain;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Table("connected_devices")
public class ConnectedDevices {
    @PrimaryKey
    private UUID id;
    private String protocol;
    private Integer total;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
