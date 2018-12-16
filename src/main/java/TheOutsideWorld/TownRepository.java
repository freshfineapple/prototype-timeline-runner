package TheOutsideWorld;

import timelinerunner.state.Town;

import java.time.Instant;

public class TownRepository {
    public Town getTown(String playerId) {
        // It is a very old town.
        return new Town(Instant.EPOCH);
    }
}
