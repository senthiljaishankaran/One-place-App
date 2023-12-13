package com.app.oneplace.ui.mapper

import com.app.oneplace.domain.entity.user.UserInformationEntity
import com.app.oneplace.domain.mapper.ProductBaseMapper
import com.app.oneplace.ui.uiData.UserInformationUiData
import javax.inject.Inject

// this class maps the UserInformationEntity with the UserInformationUiData that is used to display info on View
// we are using product base mapper because user we are displaying single use info and not list of user info
class UserInfoEntityToUiDataMapper @Inject constructor():ProductBaseMapper<UserInformationEntity,UserInformationUiData>{
    override fun map(input: UserInformationEntity): UserInformationUiData {
        return UserInformationUiData(
            id=input.id,
            name=input.name,
            surname=input.surname,
            email=input.email,
            phone=input.phone,
            image = input.image,
            password = input.password,
            token=input.token
        )
    }
}

// this class maps the UserInformationUiData with the UserInformationEntity that is used to update the UserInfo at backend
// we are using product base mapper because user we are updating single use info and not list of user info
class UserInfoUiDataToUserInfoEntity @Inject constructor():ProductBaseMapper<UserInformationUiData,UserInformationEntity>{
    override fun map(input: UserInformationUiData): UserInformationEntity {
        return UserInformationEntity(
            id=input.id,
            name=input.name,
            surname=input.surname,
            email=input.email,
            phone=input.phone,
            image = input.image,
            password = input.password,
            token=input.token
        )
    }
}
