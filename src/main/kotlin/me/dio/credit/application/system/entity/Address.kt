package me.dio.credit.application.system.entity

import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@Embeddable //anotacao para quando nao quero criar uma tabela para essa classe, vou fazer um embedd na tabela de Customer
data class Address(
    @Column(nullable = false) var zipCode: String = "",
    @Column(nullable = false) var street: String= ""
)
