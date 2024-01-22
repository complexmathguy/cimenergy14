/**
 * ***************************************************************************** Turnstone Biologics
 * Confidential
 *
 * <p>2018 Turnstone Biologics All Rights Reserved.
 *
 * <p>This file is subject to the terms and conditions defined in file 'license.txt', which is part
 * of this source code package.
 *
 * <p>Contributors : Turnstone Biologics - General Release
 * ****************************************************************************
 */
package com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class MoneyValidator {

  /** default constructor */
  protected MoneyValidator() {}

  /** factory method */
  public static MoneyValidator getInstance() {
    return new MoneyValidator();
  }

  /** handles creation validation for a Money */
  public void validate(CreateMoneyCommand money) throws Exception {
    Assert.notNull(money, "CreateMoneyCommand should not be null");
    //		Assert.isNull( money.getMoneyId(), "CreateMoneyCommand identifier should be null" );
  }

  /** handles update validation for a Money */
  public void validate(UpdateMoneyCommand money) throws Exception {
    Assert.notNull(money, "UpdateMoneyCommand should not be null");
    Assert.notNull(money.getMoneyId(), "UpdateMoneyCommand identifier should not be null");
  }

  /** handles delete validation for a Money */
  public void validate(DeleteMoneyCommand money) throws Exception {
    Assert.notNull(money, "{commandAlias} should not be null");
    Assert.notNull(money.getMoneyId(), "DeleteMoneyCommand identifier should not be null");
  }

  /** handles fetchOne validation for a Money */
  public void validate(MoneyFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "MoneyFetchOneSummary should not be null");
    Assert.notNull(summary.getMoneyId(), "MoneyFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Value validation for a Money
   *
   * @param command AssignValueToMoneyCommand
   */
  public void validate(AssignValueToMoneyCommand command) throws Exception {
    Assert.notNull(command, "AssignValueToMoneyCommand should not be null");
    Assert.notNull(command.getMoneyId(), "AssignValueToMoneyCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignValueToMoneyCommand assignment should not be null");
  }

  /**
   * handles unassign Value validation for a Money
   *
   * @param command UnAssignValueFromMoneyCommand
   */
  public void validate(UnAssignValueFromMoneyCommand command) throws Exception {
    Assert.notNull(command, "UnAssignValueFromMoneyCommand should not be null");
    Assert.notNull(
        command.getMoneyId(), "UnAssignValueFromMoneyCommand identifier should not be null");
  }
}
