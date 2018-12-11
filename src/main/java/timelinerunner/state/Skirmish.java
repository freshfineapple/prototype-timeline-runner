package timelinerunner.state;

import lombok.Value;
import timelinerunner.TimelineConfig;
import timelinerunner.event.SkirmishDespawns;
import timelinerunner.event.TimelineEvent;

import java.time.Instant;
import java.util.Collections;
import java.util.List;

@Value
public class Skirmish implements EvolvesWithTime{
    Town town; // TODO: This is actually awful. It's a circular dependency. I need a totally different approach.
    Instant startTime;
    int tileId;


    @Override
    public List<TimelineEvent> getDestiny() {
        Instant despawnTime = startTime.plus(TimelineConfig.SKIRMISH_TTL);
        return Collections.singletonList(new SkirmishDespawns(despawnTime, this, town));
    }
}
