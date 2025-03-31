package com.bina.home.utils

interface Mapper <S,T>{
    fun map(source: S): T
}