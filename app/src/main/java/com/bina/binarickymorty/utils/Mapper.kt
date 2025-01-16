package com.bina.binarickymorty.utils

interface Mapper <S,T>{
    fun map(source: S): T
}