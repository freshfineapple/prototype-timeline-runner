package timelinerunner.state;

import lombok.Value;

import java.time.Instant;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Value
public class Town {
    private Random random = new Random();
    private Set<Skirmish> skirmishes = new HashSet<>();

    public void despawnSkirmish(Instant now, Skirmish skirmish) {
        skirmishes.remove(skirmish);
    }

    public void spawnNewSkirmish(Instant now) {
        Skirmish created = makeASkirmish(now);
        skirmishes.add(created);
    }

    private Skirmish makeASkirmish(Instant now) {
        return new Skirmish(now, random.nextInt(100));
    }
}
