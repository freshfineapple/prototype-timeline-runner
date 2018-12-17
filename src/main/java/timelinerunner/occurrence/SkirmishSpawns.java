package timelinerunner.occurrence;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import TheOutsideWorld.GameConfig;
import TheOutsideWorld.TileId;
import lombok.Value;
import timelinerunner.state.Skirmish;
import timelinerunner.state.Town;

@Value
public class SkirmishSpawns implements Occurrence {
    private final Instant whenToOccur;

    @Override public Town occur(Town town) {
        Skirmish spawned = spawnNewSkirmish(town);
        Set<Skirmish> skirmishesPlusSpawned = new HashSet<>(town.getSkirmishes());
        skirmishesPlusSpawned.add(spawned);

        return town
                .withSkirmishes(skirmishesPlusSpawned)
                .withLastSkirmishSpawned(this.whenToOccur)
                .withSkirmishSpawnCooldown(GameConfig.SKIRMISH_SPAWN_COOLDOWNS_BY_NUMBER_OF_SKIRMISHES_IN_TOWN.get(skirmishesPlusSpawned.size()));
    }

    private Skirmish spawnNewSkirmish(Town town) {
        return new Skirmish(
                whenToOccur,
                randomUnoccupiedTileId(town));
    }

    private TileId randomUnoccupiedTileId(Town town) {
        return GameConfig.SKIRMIH_ELIGIBLE_TILES.stream()
                .filter(tileId ->
                        town.getSkirmishes().stream()
                                .noneMatch(skirmish -> skirmish.getTileId().equals(tileId)))
                .findFirst()
                .orElseThrow(() -> new RuntimeException(
                        "Shouldn't be possible, because we won't try to"
                        + "spawn if there are no unoccupied tiles"));
    }
}
