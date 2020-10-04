In this exercise you'll be working with savings accounts. Each year, the balance of your savings account is updated based on its interest rate. The interest rate your bank gives you depends on the amount of money in your account (its balance):

- -3.213% for a negative balance.
- 0.5% for a positive balance less than `1000` dollars.
- 1.621% for a positive balance greater or equal than `1000` dollars and less than `5000` dollars.
- 2.475% for a positive balance greater or equal than `5000` dollars.

Each year the government allows you to donate a percentage of your money to charity, tax free. Because you're a nice person, if your balance is positive at the end of the year, you donate twice this amount to charities, rounded down to the nearest whole dollar.

You have three tasks, each of which will deal with your balance and its interest rate.

## 1. Calculate the interest rate

Implement the `interest-rate` function to calculate the interest rate based on the specified balance:

```clojure
(interest-rate 200.75M)
;;=> 0.5
```

Note that the value returned is a `Double`.

## 2. Calculate the annual balance update

Implement the `annual-balance-update` function to calculate the annual balance update, taking into account the interest rate:

```clojure
(annual-balance-update 200.75M)
;;=> 201.75375M
```

Note that the value returned is a `BigDecimal`.

## 3. Calculate how much money to donate

Implement the `amount-to-donate` function to calculate how much money to donate to charities based on the balance and the tax-free percentage that the government allows:

```clojure
(def balance 550.5M)
(def tax-free-percentage 2.5)

(amount-to-donate balance tax-free-percentage)
;;=> 27
```

Note that the value returned is an `int`.
