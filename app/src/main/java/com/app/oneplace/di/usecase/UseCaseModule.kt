package com.app.oneplace.di.usecase

import com.app.oneplace.domain.usecase.cart.CartUseCase
import com.app.oneplace.domain.usecase.cart.CartUseCaseImpl
import com.app.oneplace.domain.usecase.cart.DeleteUserCartUseCase
import com.app.oneplace.domain.usecase.cart.DeleteUserCartUseCaseImpl
import com.app.oneplace.domain.usecase.cart.UpdateUserCartUseCase
import com.app.oneplace.domain.usecase.cart.UpdateUserCartUseCaseImpl
import com.app.oneplace.domain.usecase.cart.badge.UserCartBadgeUseCase
import com.app.oneplace.domain.usecase.cart.badge.UserCartBadgeUseCaseImpl
import com.app.oneplace.domain.usecase.category.CategoryUseCase
import com.app.oneplace.domain.usecase.category.CategoryUseCaseImpl
import com.app.oneplace.domain.usecase.favorite.DeleteUserCartFavoriteUseCase
import com.app.oneplace.domain.usecase.favorite.FavoriteProductUseCase
import com.app.oneplace.domain.usecase.favorite.FavoriteProductUseCaseImpl
import com.app.oneplace.domain.usecase.product.GetAllProductsUseCaseImpl
import com.app.oneplace.domain.usecase.product.GetProductListBySearchUseCase
import com.app.oneplace.domain.usecase.product.GetProductListBySearchUseCaseImpl
import com.app.oneplace.domain.usecase.product.GetSingleProductUseCase
import com.app.oneplace.domain.usecase.product.GetSingleProductUseCaseImpl
import com.app.oneplace.domain.usecase.user.ForgetPasswordFirebaseUseCase
import com.app.oneplace.domain.usecase.user.ForgetPasswordFirebaseUseCaseImpl
import com.app.oneplace.domain.usecase.user.ReadFirebaseUserInfoUseCase
import com.app.oneplace.domain.usecase.user.ReadFirebaseUserInfoUseCaseImpl
import com.app.oneplace.domain.usecase.user.SignInFirebaseUseCase
import com.app.oneplace.domain.usecase.user.SignInFirebaseUseCaseImpl
import com.app.oneplace.domain.usecase.user.SignUpFirebaseUseCase
import com.app.oneplace.domain.usecase.user.SignUpFirebaseUseCaseImpl
import com.app.oneplace.domain.usecase.user.WriteFireBaseUserInfoUseCaseImpl
import com.app.oneplace.domain.usecase.user.WriteFirebaseUserInfoUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class UseCaseModule {
    @Binds
    @ViewModelScoped
    abstract fun bindUserCartBadgeUseCase(
        userCartBadgeUseCaseImpl: UserCartBadgeUseCaseImpl
    ): UserCartBadgeUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindUserCartUseCase(
        cartUseCaseImpl: CartUseCaseImpl
    ): CartUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindDeleteUserCartUseCase(
        deleteUserCartUseCaseImpl: DeleteUserCartUseCaseImpl
    ): DeleteUserCartUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindUpdateUserCartUseCase(
        updateUserCartUseCaseImpl: UpdateUserCartUseCaseImpl
    ): UpdateUserCartUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindCategoryUseCase(
        categoryUseCaseImpl: CategoryUseCaseImpl
    ):CategoryUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindFavoriteUseCase(
        favoriteProductUseCaseImpl: FavoriteProductUseCaseImpl
    ):FavoriteProductUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindDeleteFavoriteUseCase(
        deleteUserCartFavoriteUseCase: DeleteUserCartFavoriteUseCase
    ):DeleteUserCartFavoriteUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindGetAllProductsUseCase(
        getAllProductsUseCaseImpl: GetAllProductsUseCaseImpl
    ):GetAllProductsUseCaseImpl

    @Binds
    @ViewModelScoped
    abstract fun bindSingleProductUseCase(
        getSingleProductUseCaseImpl: GetSingleProductUseCaseImpl
    ):GetSingleProductUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindGetProductBySearchUseCase(
        getProductListBySearchUseCaseImpl: GetProductListBySearchUseCaseImpl
    ):GetProductListBySearchUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindForgetPasswordFirebaseUseCase(
        forgetPasswordFirebaseUseCaseImpl: ForgetPasswordFirebaseUseCaseImpl
    ):ForgetPasswordFirebaseUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindReadFirebaseUserInfoUseCase(
        readFirebaseUserInfoUseCaseImpl: ReadFirebaseUserInfoUseCaseImpl
    ):ReadFirebaseUserInfoUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindSignInFirebaseUseCase(
        signInFirebaseUseCaseImpl: SignInFirebaseUseCaseImpl
    ):SignInFirebaseUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindSignUpFirebaseUseCase(
        signUpFirebaseUseCaseImpl: SignUpFirebaseUseCaseImpl
    ):SignUpFirebaseUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindWriteFirebaseUserInfoUseCase(
        writeFirebaseUserInfoUseCaseImpl:WriteFireBaseUserInfoUseCaseImpl
    ):WriteFirebaseUserInfoUseCase
}