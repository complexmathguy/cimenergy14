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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.excitationsystemdynamics.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class ExcAVR5Validator {

  /** default constructor */
  protected ExcAVR5Validator() {}

  /** factory method */
  public static ExcAVR5Validator getInstance() {
    return new ExcAVR5Validator();
  }

  /** handles creation validation for a ExcAVR5 */
  public void validate(CreateExcAVR5Command excAVR5) throws Exception {
    Assert.notNull(excAVR5, "CreateExcAVR5Command should not be null");
    //		Assert.isNull( excAVR5.getExcAVR5Id(), "CreateExcAVR5Command identifier should be null" );
  }

  /** handles update validation for a ExcAVR5 */
  public void validate(UpdateExcAVR5Command excAVR5) throws Exception {
    Assert.notNull(excAVR5, "UpdateExcAVR5Command should not be null");
    Assert.notNull(excAVR5.getExcAVR5Id(), "UpdateExcAVR5Command identifier should not be null");
  }

  /** handles delete validation for a ExcAVR5 */
  public void validate(DeleteExcAVR5Command excAVR5) throws Exception {
    Assert.notNull(excAVR5, "{commandAlias} should not be null");
    Assert.notNull(excAVR5.getExcAVR5Id(), "DeleteExcAVR5Command identifier should not be null");
  }

  /** handles fetchOne validation for a ExcAVR5 */
  public void validate(ExcAVR5FetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "ExcAVR5FetchOneSummary should not be null");
    Assert.notNull(summary.getExcAVR5Id(), "ExcAVR5FetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Ka validation for a ExcAVR5
   *
   * @param command AssignKaToExcAVR5Command
   */
  public void validate(AssignKaToExcAVR5Command command) throws Exception {
    Assert.notNull(command, "AssignKaToExcAVR5Command should not be null");
    Assert.notNull(
        command.getExcAVR5Id(), "AssignKaToExcAVR5Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKaToExcAVR5Command assignment should not be null");
  }

  /**
   * handles unassign Ka validation for a ExcAVR5
   *
   * @param command UnAssignKaFromExcAVR5Command
   */
  public void validate(UnAssignKaFromExcAVR5Command command) throws Exception {
    Assert.notNull(command, "UnAssignKaFromExcAVR5Command should not be null");
    Assert.notNull(
        command.getExcAVR5Id(), "UnAssignKaFromExcAVR5Command identifier should not be null");
  }
  /**
   * handles assign Rex validation for a ExcAVR5
   *
   * @param command AssignRexToExcAVR5Command
   */
  public void validate(AssignRexToExcAVR5Command command) throws Exception {
    Assert.notNull(command, "AssignRexToExcAVR5Command should not be null");
    Assert.notNull(
        command.getExcAVR5Id(), "AssignRexToExcAVR5Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignRexToExcAVR5Command assignment should not be null");
  }

  /**
   * handles unassign Rex validation for a ExcAVR5
   *
   * @param command UnAssignRexFromExcAVR5Command
   */
  public void validate(UnAssignRexFromExcAVR5Command command) throws Exception {
    Assert.notNull(command, "UnAssignRexFromExcAVR5Command should not be null");
    Assert.notNull(
        command.getExcAVR5Id(), "UnAssignRexFromExcAVR5Command identifier should not be null");
  }
  /**
   * handles assign Ta validation for a ExcAVR5
   *
   * @param command AssignTaToExcAVR5Command
   */
  public void validate(AssignTaToExcAVR5Command command) throws Exception {
    Assert.notNull(command, "AssignTaToExcAVR5Command should not be null");
    Assert.notNull(
        command.getExcAVR5Id(), "AssignTaToExcAVR5Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTaToExcAVR5Command assignment should not be null");
  }

  /**
   * handles unassign Ta validation for a ExcAVR5
   *
   * @param command UnAssignTaFromExcAVR5Command
   */
  public void validate(UnAssignTaFromExcAVR5Command command) throws Exception {
    Assert.notNull(command, "UnAssignTaFromExcAVR5Command should not be null");
    Assert.notNull(
        command.getExcAVR5Id(), "UnAssignTaFromExcAVR5Command identifier should not be null");
  }
}
