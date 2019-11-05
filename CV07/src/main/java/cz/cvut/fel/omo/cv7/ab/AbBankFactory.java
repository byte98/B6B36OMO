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

import cz.cvut.fel.omo.cv7.AbstractBankFactory;
import cz.cvut.fel.omo.cv7.Account;
import cz.cvut.fel.omo.cv7.BankOffice;
import cz.cvut.fel.omo.cv7.Loan;

/**
 *
 * @author Jiri Skoda <skodaji4@fel.cvut.cz>
 */
public class AbBankFactory extends AbstractBankFactory
{
    public BankOffice createBankOffice()
    {
        return new AbBankOffice("Ab Banka", "Náměstí 2, Praha 1", "420-2-777-777-777");
    }
    public Account createAccount()
    {
        return new AbAccount();
    }
    public Loan createLoan(MonetaryAmount amount, int months, double recommendedInterestRate)
    {
        return new AbLoan();
    }
}
