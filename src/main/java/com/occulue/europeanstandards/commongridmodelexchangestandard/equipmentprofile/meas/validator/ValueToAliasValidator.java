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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.meas.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class ValueToAliasValidator {

  /** default constructor */
  protected ValueToAliasValidator() {}

  /** factory method */
  public static ValueToAliasValidator getInstance() {
    return new ValueToAliasValidator();
  }

  /** handles creation validation for a ValueToAlias */
  public void validate(CreateValueToAliasCommand valueToAlias) throws Exception {
    Assert.notNull(valueToAlias, "CreateValueToAliasCommand should not be null");
    //		Assert.isNull( valueToAlias.getValueToAliasId(), "CreateValueToAliasCommand identifier
    // should be null" );
  }

  /** handles update validation for a ValueToAlias */
  public void validate(UpdateValueToAliasCommand valueToAlias) throws Exception {
    Assert.notNull(valueToAlias, "UpdateValueToAliasCommand should not be null");
    Assert.notNull(
        valueToAlias.getValueToAliasId(),
        "UpdateValueToAliasCommand identifier should not be null");
  }

  /** handles delete validation for a ValueToAlias */
  public void validate(DeleteValueToAliasCommand valueToAlias) throws Exception {
    Assert.notNull(valueToAlias, "{commandAlias} should not be null");
    Assert.notNull(
        valueToAlias.getValueToAliasId(),
        "DeleteValueToAliasCommand identifier should not be null");
  }

  /** handles fetchOne validation for a ValueToAlias */
  public void validate(ValueToAliasFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "ValueToAliasFetchOneSummary should not be null");
    Assert.notNull(
        summary.getValueToAliasId(), "ValueToAliasFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Value validation for a ValueToAlias
   *
   * @param command AssignValueToValueToAliasCommand
   */
  public void validate(AssignValueToValueToAliasCommand command) throws Exception {
    Assert.notNull(command, "AssignValueToValueToAliasCommand should not be null");
    Assert.notNull(
        command.getValueToAliasId(),
        "AssignValueToValueToAliasCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignValueToValueToAliasCommand assignment should not be null");
  }

  /**
   * handles unassign Value validation for a ValueToAlias
   *
   * @param command UnAssignValueFromValueToAliasCommand
   */
  public void validate(UnAssignValueFromValueToAliasCommand command) throws Exception {
    Assert.notNull(command, "UnAssignValueFromValueToAliasCommand should not be null");
    Assert.notNull(
        command.getValueToAliasId(),
        "UnAssignValueFromValueToAliasCommand identifier should not be null");
  }

  /**
   * handles add to Values validation for a ValueToAlias
   *
   * @param command AssignValuesToValueToAliasCommand
   */
  public void validate(AssignValuesToValueToAliasCommand command) throws Exception {
    Assert.notNull(command, "AssignValuesToValueToAliasCommand should not be null");
    Assert.notNull(
        command.getValueToAliasId(),
        "AssignValuesToValueToAliasCommand identifier should not be null");
    Assert.notNull(
        command.getAddTo(), "AssignValuesToValueToAliasCommand addTo attribute should not be null");
  }

  /**
   * handles remove from Values validation for a ValueToAlias
   *
   * @param command RemoveValuesFromValueToAliasCommand
   */
  public void validate(RemoveValuesFromValueToAliasCommand command) throws Exception {
    Assert.notNull(command, "RemoveValuesFromValueToAliasCommand should not be null");
    Assert.notNull(
        command.getValueToAliasId(),
        "RemoveValuesFromValueToAliasCommand identifier should not be null");
    Assert.notNull(
        command.getRemoveFrom(),
        "RemoveValuesFromValueToAliasCommand removeFrom attribute should not be null");
    Assert.notNull(
        command.getRemoveFrom().getValueToAliasId(),
        "RemoveValuesFromValueToAliasCommand removeFrom attribubte identifier should not be null");
  }
}
