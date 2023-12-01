package com.app.oneplace.domain.mapper

// This mapper interface defines the method to map the Product and Products class from dto data layer to
// Product Entity and Detailed Product Entity in the domain layer
// we are doing this because

interface ProductBaseMapper<I,O> {
    fun map(input:I):O
}