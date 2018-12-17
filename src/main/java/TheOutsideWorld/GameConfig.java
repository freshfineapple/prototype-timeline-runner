package TheOutsideWorld;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.google.common.collect.ImmutableMap;

import lombok.experimental.UtilityClass;

@UtilityClass
public class GameConfig {

    public static final Duration SKIRMISH_TTL = Duration.ofHours(2);

    public static final List<TileId> SKIRMIH_ELIGIBLE_TILES = Arrays.asList(TileId.values());

    public static final Map<Integer, Duration> SKIRMISH_SPAWN_COOLDOWNS_BY_NUMBER_OF_SKIRMISHES_IN_TOWN = ImmutableMap.of(
            0, Duration.ofMinutes(2),
            1, Duration.ofMinutes(10),
            2, Duration.ofMinutes(12),
            3, Duration.ofMinutes(20));

}
