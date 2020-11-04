package Api.dev.contract;

import Api.dev.dto.PolityDto;
import Api.dev.entities.Polity;

import java.util.List;

public interface PolityContract {

    List<PolityDto> getAll();
}
