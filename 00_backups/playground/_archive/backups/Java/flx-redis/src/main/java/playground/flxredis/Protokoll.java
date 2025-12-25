package playground.flxredis;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("protokoll")
public class Protokoll {

    @Id
    private String protokoll;
    private String port;

    public String getProtokoll() {
        return protokoll;
    }

    public void setProtokoll(String protokoll) {
        this.protokoll = protokoll;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
}
