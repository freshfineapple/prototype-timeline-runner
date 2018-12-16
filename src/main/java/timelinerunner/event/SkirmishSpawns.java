package timelinerunner.event;

import lombok.Value;
import timelinerunner.state.Town;

import java.time.Instant;

@Value
public class SkirmishSpawns implements TimelineEvent{
    private final Instant timeOfOccurrence;


    @Override
    public Town happenToTown(Town town) {
        // TODO
        return town;
    }
}
