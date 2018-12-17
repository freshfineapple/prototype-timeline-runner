package TheOutsideWorld;

import lombok.experimental.UtilityClass;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

@UtilityClass
public class TimelineConfig {

    public static final Duration SKIRMISH_TTL = Duration.ofHours(2);

    public static final List<TileId> ALL_TILES = Arrays.asList(TileId.values());

}
