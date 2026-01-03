package com.example.worder.starter

import java.time.LocalDateTime

enum class WordType {
    N,
    Adj,
    Adv,
    Prep,
    PhrV,
    Idm,
    Expr
}

data class Word (
    val item: String,
    val translation: String,
    val type: WordType=WordType.N,
    var numOfTries: Int=0,
    var numOfFailures: Int=0,
    var lastTry: LocalDateTime?
)

class Vocab {

}