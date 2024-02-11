package me.dio.credit.application.system.service.impl

import me.dio.credit.application.system.entity.Credit
import me.dio.credit.application.system.entity.Customer
import me.dio.credit.application.system.repository.CreditRepository
import me.dio.credit.application.system.service.ICreditService
import org.springframework.stereotype.Service
import java.lang.RuntimeException
import java.util.*

@Service
class CreditService(
    private val creditRepository: CreditRepository
): ICreditService {

    override fun save(credit: Credit): Credit {
        if (credit.customer == null) {
            throw IllegalArgumentException("Customer cannot be null")
        }
        return creditRepository.save(credit)
    }

    override fun findAllByCustomer(customerId: Long): List<Credit> =
        this.creditRepository.findAllByCustomer(customerId)

    override fun findByCreditCode(custemerId: Long, creditCode: UUID): Credit {
        val credit: Credit = this.creditRepository.findByCreditCode(creditCode)
            ?: throw IllegalArgumentException("CreditCode not found")
        return if (credit.customer?.id == custemerId) credit else throw RuntimeException("Contact Admin")
    }

}