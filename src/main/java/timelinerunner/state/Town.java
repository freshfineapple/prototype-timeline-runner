package timelinerunner.state;

import java.time.Duration;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import lombok.Value;
import lombok.experimental.Wither;
import timelinerunner.occurrence.Occurrence;
import timelinerunner.occurrence.SkirmishSpawns;

@Value
@Wither
public class Town implements CausesOccurrences {
    private final Set<Skirmish> skirmishes;
    private final Instant lastSkirmishSpawned;
    private final Duration skirmishSpawnCooldown;

    @Override
    public Set<Occurrence> getOccurrences() {
        Set<Occurrence> occurrences = new HashSet<>();

        occurrences.add(nextSkirmishSpawns());

        for (Skirmish skirmish : skirmishes) {
            occurrences.addAll(skirmish.getOccurrences());
        }

        return occurrences;
    }

    private Occurrence nextSkirmishSpawns() {
        return new SkirmishSpawns(lastSkirmishSpawned.plus(skirmishSpawnCooldown));
    }

}
