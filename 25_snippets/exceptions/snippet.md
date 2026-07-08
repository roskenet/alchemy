# Exception as flow control?

```kotlin
class BankAccount {
    var balance = 0.0
        private set

    fun deposit(depositAmount: Double) {
        balance += depositAmount
    }

    @Throws(InsufficientFunds::class)
    fun withdraw(withdrawAmount: Double) {
        if (balance < withdrawAmount) {
            throw InsufficientFunds()
        }
        balance -= withdrawAmount
    }
}

class InsufficientFunds : Exception()
```

## Analysis: Why This Is Problematic

**The Issue:** Using exceptions for a *normal, expected* condition is poor practice because:

1. **Performance** — Exception creation and stack unwinding are expensive, especially if this happens frequently
2. **Clarity** — Exceptions signal "something went wrong," but insufficient funds is a predictable, normal case
3. **Caller burden** — Callers must catch a checked exception for what should be straightforward control flow
4. **Not exceptional** — Exceptions are for unexpected/error conditions, not business logic outcomes

## Better Approaches

### Option 1: Return a Result Type (Most Idiomatic)
```kotlin
sealed class WithdrawalResult {
    data class Success(val newBalance: Double) : WithdrawalResult()
    data class InsufficientFunds(val balance: Double, val requested: Double) : WithdrawalResult()
}

class BankAccount {
    var balance = 0.0
        private set

    fun deposit(depositAmount: Double) {
        balance += depositAmount
    }

    fun withdraw(withdrawAmount: Double): WithdrawalResult {
        return if (balance < withdrawAmount) {
            WithdrawalResult.InsufficientFunds(balance, withdrawAmount)
        } else {
            balance -= withdrawAmount
            WithdrawalResult.Success(balance)
        }
    }
}

// Caller code is explicit:
when (val result = account.withdraw(100.0)) {
    is WithdrawalResult.Success -> println("New balance: ${result.newBalance}")
    is WithdrawalResult.InsufficientFunds -> println("Cannot withdraw ${result.requested}, only have ${result.balance}")
}
```

### Option 2: Simple Boolean
```kotlin
fun withdraw(withdrawAmount: Double): Boolean {
    if (balance < withdrawAmount) return false
    balance -= withdrawAmount
    return true
}

// Caller: if (account.withdraw(100.0)) { ... } else { ... }
```

### Option 3: Return Nullable Balance
```kotlin
fun withdraw(withdrawAmount: Double): Double? {
    return if (balance < withdrawAmount) {
        null
    } else {
        balance -= withdrawAmount
        balance
    }
}

// Caller: val newBalance = account.withdraw(100.0) ?: return
```

## When Exceptions ARE Appropriate
Reserve exceptions for truly exceptional cases:
- Corrupted account state (invariant violation)
- Database connection failure
- Negative withdrawal amount (programmer error)
```


