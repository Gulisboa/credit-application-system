package me.dio.credit.application.system.entity

import jakarta.persistence.*

@Entity //fala que essa classe é um tabela no banco de dados
@Table(name = "Customer") //permite colocar outro nome na tabela
data class Customer(
    @Column(nullable = false) var firstName: String, //a anotação Column permite configurar algumas propriedades do dominino da coluna, como nao aceitar null e ser único na tabela
    @Column(nullable = false) var lastName: String,
    @Column(nullable = false, unique = true) val cpf: String,
    @Column(nullable = false, unique = true) var email: String = "",
    @Column(nullable = false) var password: String = "",
    @Column(nullable = false) @Embedded var address: Address = Address(),
    @Column(nullable = false) @OneToMany(fetch = FetchType.LAZY, //OneToMany explicita o relacionamento dessa classe/tabela com a outra classe/tabela
        cascade = arrayOf(CascadeType.REMOVE, CascadeType.PERSIST),
        mappedBy = "customer") //qual o campo que está relacionado com a tabela/classe Credits
    var credits: List<Credit> = mutableListOf(), //também permite algumas configurações, como lazy para nao trazer tudo e cascade para quando alterar algo nessa tabela reflita na outra
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null //@ID - fala que é PK e @GeneratedValue - gera o id automacticamente
)
