package timelinerunner.event;

import lombok.Value;
import timelinerunner.state.Skirmish;
import timelinerunner.state.Town;

import java.time.Instant;

@Value
public class SkirmishDespawns implements TimelineEvent {
    private final Instant timeOfOccurrence;
    private final Skirmish skirmish;
    private final Town town;

    @Override
    public void occur() {
        town.despawnSkirmish(timeOfOccurrence, skirmish);
    }
}
