package timelinerunner.occurrence;

import java.time.Instant;
import java.util.Set;
import java.util.stream.Collectors;

import lombok.Value;
import timelinerunner.state.Skirmish;
import timelinerunner.state.Town;

@Value
public class SkirmishDespawns implements Occurrence {
    private final Instant whenToOccur;
    private final Skirmish toDespawn;

    @Override public Town occur(Town town) {
        Set<Skirmish> skirmishesMinusDespawned = town.getSkirmishes().stream()
                .filter(skirmish -> !skirmish.equals(toDespawn))
                .collect(Collectors.toSet());

        return town.withSkirmishes(skirmishesMinusDespawned);
    }

}
