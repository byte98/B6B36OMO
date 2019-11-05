/*
 * Copyright 2019 Jiri Skoda <skodaji4@fel.cvut.cz>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cz.cvut.fel.omo.cv7.ab;

import cz.cvut.fel.omo.cv7.Account;
import javax.money.MonetaryAmount;
import org.javamoney.moneta.Money;

/**
 *
 * @author Jiri Skoda <skodaji4@fel.cvut.cz>
 */
public class AbAccount implements Account
{
    private MonetaryAmount balance;
    private MonetaryAmount withrdawLimit;
    
    private final double wihdrawFee = 0.5;
    private final double depositBonus = 0.25;
    
    private int withdraws = 0;
    private int deposits = 0;

    public AbAccount(int withdrawLimit)
    {
        this.balance = Money.of(0, "EUR");
        this.withrdawLimit = Money.of(withdrawLimit, "EUR");
    }
    
    
    public MonetaryAmount getBalance()
    {
        return this.balance;
    }
    
    public MonetaryAmount getWithdrawLimit()
    {
        return this.withrdawLimit;
    }
    
    public MonetaryAmount getMonthlyFee()
    {
        return Money.of(this.wihdrawFee, "EUR")
                .multiply(this.withdraws).
                add(Money
                        .of(this.depositBonus, "EUR")
                        .multiply(this.deposits)
                        .multiply(-1));
    }
    public void withdraw(MonetaryAmount amount)
    {
        this.balance.add(amount.multiply(-1));
        this.withdraws++;
    }
    public void deposit(MonetaryAmount amount)
    {
        this.balance.add(amount);
        this.deposits++;
    }
}
