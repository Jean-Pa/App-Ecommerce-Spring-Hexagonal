package com.ecommerce.ecommerce.infrastructure.mapper;

import com.ecommerce.ecommerce.domain.User;
import com.ecommerce.ecommerce.infrastructure.entity.UserEntity;
import java.util.ArrayList;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-05T20:19:44-0500",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.9 (Amazon.com Inc.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toUser(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        User user = new User();

        user.setId( userEntity.getId() );
        user.setUsername( userEntity.getUsername() );
        user.setFirstName( userEntity.getFirstName() );
        user.setLastName( userEntity.getLastName() );
        user.setEmail( userEntity.getEmail() );
        user.setAddress( userEntity.getAddress() );
        user.setCellphone( userEntity.getCellphone() );
        user.setPassword( userEntity.getPassword() );
        user.setUserType( userEntity.getUserType() );
        user.setDateCreated( userEntity.getDateCreated() );

        return user;
    }

    @Override
    public Iterable<User> toUsers(Iterable<UserEntity> userEntities) {
        if ( userEntities == null ) {
            return null;
        }

        ArrayList<User> iterable = new ArrayList<User>();
        for ( UserEntity userEntity : userEntities ) {
            iterable.add( toUser( userEntity ) );
        }

        return iterable;
    }

    @Override
    public UserEntity toUserEntity(User user) {
        if ( user == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setId( user.getId() );
        userEntity.setUsername( user.getUsername() );
        userEntity.setFirstName( user.getFirstName() );
        userEntity.setLastName( user.getLastName() );
        userEntity.setEmail( user.getEmail() );
        userEntity.setAddress( user.getAddress() );
        userEntity.setCellphone( user.getCellphone() );
        userEntity.setPassword( user.getPassword() );
        userEntity.setUserType( user.getUserType() );
        userEntity.setDateCreated( user.getDateCreated() );

        return userEntity;
    }
}
