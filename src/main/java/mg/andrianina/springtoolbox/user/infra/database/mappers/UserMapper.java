package mg.andrianina.springtoolbox.user.infra.database.mappers;

import mg.andrianina.springtoolbox.user.domain.models.User;
import mg.andrianina.springtoolbox.user.infra.database.entities.UserEntity;

public class UserMapper {
    public static User entityToDomain(UserEntity entity) {
        return new User(entity.username, entity.email, "");
    }
}
