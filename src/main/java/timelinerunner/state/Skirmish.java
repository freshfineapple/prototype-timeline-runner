package timelinerunner.state;

import java.time.Instant;
import java.util.Collections;
import java.util.Set;

import TheOutsideWorld.GameConfig;
import TheOutsideWorld.TileId;
import lombok.Value;
import timelinerunner.occurrence.Occurrence;
import timelinerunner.occurrence.SkirmishDespawns;

@Value
public class Skirmish implements CausesOccurrences {
    Instant startTime;
    TileId tileId;

    @Override public Set<Occurrence> getOccurrences() {
        Instant despawnTime = startTime.plus(GameConfig.SKIRMISH_TTL);
        return Collections.singleton(new SkirmishDespawns(despawnTime, this));
    }
}
