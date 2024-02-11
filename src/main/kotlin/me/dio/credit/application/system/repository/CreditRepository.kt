package me.dio.credit.application.system.repository

import me.dio.credit.application.system.entity.Credit
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository //bean gerenciado pelo spring
interface CreditRepository: JpaRepository<Credit, Long> { //passa o tipo da sua entidade e o tipo da PK

    //podemos usar native queries para escrever a query SQL explicita
    @Query(value = "SELECT * FROM CREDIT WHERE CUSTOMER_ID = ?1", nativeQuery = true)
    fun findAllByCustomer(customerId: Long): List<Credit>

    //quando precisamos criar queries especificas, podemos usar named query e usando o padrão da documentação (findByxxx, o JPA já monta a query
    fun findByCreditCode(creditCode: UUID): Credit?
}