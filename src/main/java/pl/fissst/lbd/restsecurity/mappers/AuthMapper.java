package pl.fissst.lbd.restsecurity.mappers;

import org.mapstruct.*;
import pl.fissst.lbd.restsecurity.dtos.AuthorityDto;
import pl.fissst.lbd.restsecurity.dtos.UserDto;
import pl.fissst.lbd.restsecurity.entities.Authority;
import pl.fissst.lbd.restsecurity.entities.User;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface AuthMapper {

    @Named("baseUserToDto")
    @Mappings(value = {
            @Mapping(target = "authorities",
                    source = "authorities",
                    qualifiedByName = "baseAuthoritySetToDtoSet"
            )
    })
    UserDto mapUserToUserDto(User source);

    @IterableMapping(qualifiedByName = "baseUserToDto")
    @Named("baseUserSetToDtoSet")
    Set<UserDto> mapUserSetToUserDtoSet(Set<User> source);

    @Named("baseDtoToUser")
    @Mappings(value = {
            @Mapping(target = "authorities",
                    source = "authorities",
                    qualifiedByName = "baseDtoSetToAuthoritySet"
            )
    })
    User mapUserDtoToUser(UserDto source);

    @IterableMapping(qualifiedByName = "baseDtoToUser")
    @Named("baseDtoSetToUserSet")
    Set<User> mapUserDtoSetToUserSet(Set<UserDto> source);



    @Named("baseAuthorityToDto")
    AuthorityDto mapAuthorityToAuthorityDto(Authority source);

    @IterableMapping(qualifiedByName = "baseAuthorityToDto")
    @Named("baseAuthoritySetToDtoSet")
    Set<AuthorityDto> mapAuthoritySetToAuthorityDtoSet(Set<Authority> source);

    @Named("baseDtoToAuthority")
    Authority mapAuthorityDtoToAuthority(AuthorityDto source);

    @IterableMapping(qualifiedByName = "baseDtoToAuthority")
    @Named("baseDtoSetToAuthoritySet")
    Set<Authority> mapAuthorityDtoSetToAuthoritySet(Set<AuthorityDto> source);



}
