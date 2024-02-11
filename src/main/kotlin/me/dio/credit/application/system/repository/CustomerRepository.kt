package me.dio.credit.application.system.repository

import me.dio.credit.application.system.entity.Customer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

//as classes de repository ficam responsáveis pelo CRUD, a interface JpaRepository
//espera o tipo da tabela do banco de dados e o tipo da PK
@Repository
interface CustomerRepository: JpaRepository<Customer, Long>{
}