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

public class Quality61850Validator {

  /** default constructor */
  protected Quality61850Validator() {}

  /** factory method */
  public static Quality61850Validator getInstance() {
    return new Quality61850Validator();
  }

  /** handles creation validation for a Quality61850 */
  public void validate(CreateQuality61850Command quality61850) throws Exception {
    Assert.notNull(quality61850, "CreateQuality61850Command should not be null");
    //		Assert.isNull( quality61850.getQuality61850Id(), "CreateQuality61850Command identifier
    // should be null" );
  }

  /** handles update validation for a Quality61850 */
  public void validate(UpdateQuality61850Command quality61850) throws Exception {
    Assert.notNull(quality61850, "UpdateQuality61850Command should not be null");
    Assert.notNull(
        quality61850.getQuality61850Id(),
        "UpdateQuality61850Command identifier should not be null");
  }

  /** handles delete validation for a Quality61850 */
  public void validate(DeleteQuality61850Command quality61850) throws Exception {
    Assert.notNull(quality61850, "{commandAlias} should not be null");
    Assert.notNull(
        quality61850.getQuality61850Id(),
        "DeleteQuality61850Command identifier should not be null");
  }

  /** handles fetchOne validation for a Quality61850 */
  public void validate(Quality61850FetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "Quality61850FetchOneSummary should not be null");
    Assert.notNull(
        summary.getQuality61850Id(), "Quality61850FetchOneSummary identifier should not be null");
  }

  /**
   * handles assign BadReference validation for a Quality61850
   *
   * @param command AssignBadReferenceToQuality61850Command
   */
  public void validate(AssignBadReferenceToQuality61850Command command) throws Exception {
    Assert.notNull(command, "AssignBadReferenceToQuality61850Command should not be null");
    Assert.notNull(
        command.getQuality61850Id(),
        "AssignBadReferenceToQuality61850Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignBadReferenceToQuality61850Command assignment should not be null");
  }

  /**
   * handles unassign BadReference validation for a Quality61850
   *
   * @param command UnAssignBadReferenceFromQuality61850Command
   */
  public void validate(UnAssignBadReferenceFromQuality61850Command command) throws Exception {
    Assert.notNull(command, "UnAssignBadReferenceFromQuality61850Command should not be null");
    Assert.notNull(
        command.getQuality61850Id(),
        "UnAssignBadReferenceFromQuality61850Command identifier should not be null");
  }
  /**
   * handles assign EstimatorReplaced validation for a Quality61850
   *
   * @param command AssignEstimatorReplacedToQuality61850Command
   */
  public void validate(AssignEstimatorReplacedToQuality61850Command command) throws Exception {
    Assert.notNull(command, "AssignEstimatorReplacedToQuality61850Command should not be null");
    Assert.notNull(
        command.getQuality61850Id(),
        "AssignEstimatorReplacedToQuality61850Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignEstimatorReplacedToQuality61850Command assignment should not be null");
  }

  /**
   * handles unassign EstimatorReplaced validation for a Quality61850
   *
   * @param command UnAssignEstimatorReplacedFromQuality61850Command
   */
  public void validate(UnAssignEstimatorReplacedFromQuality61850Command command) throws Exception {
    Assert.notNull(command, "UnAssignEstimatorReplacedFromQuality61850Command should not be null");
    Assert.notNull(
        command.getQuality61850Id(),
        "UnAssignEstimatorReplacedFromQuality61850Command identifier should not be null");
  }
  /**
   * handles assign Failure validation for a Quality61850
   *
   * @param command AssignFailureToQuality61850Command
   */
  public void validate(AssignFailureToQuality61850Command command) throws Exception {
    Assert.notNull(command, "AssignFailureToQuality61850Command should not be null");
    Assert.notNull(
        command.getQuality61850Id(),
        "AssignFailureToQuality61850Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignFailureToQuality61850Command assignment should not be null");
  }

  /**
   * handles unassign Failure validation for a Quality61850
   *
   * @param command UnAssignFailureFromQuality61850Command
   */
  public void validate(UnAssignFailureFromQuality61850Command command) throws Exception {
    Assert.notNull(command, "UnAssignFailureFromQuality61850Command should not be null");
    Assert.notNull(
        command.getQuality61850Id(),
        "UnAssignFailureFromQuality61850Command identifier should not be null");
  }
  /**
   * handles assign OldData validation for a Quality61850
   *
   * @param command AssignOldDataToQuality61850Command
   */
  public void validate(AssignOldDataToQuality61850Command command) throws Exception {
    Assert.notNull(command, "AssignOldDataToQuality61850Command should not be null");
    Assert.notNull(
        command.getQuality61850Id(),
        "AssignOldDataToQuality61850Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignOldDataToQuality61850Command assignment should not be null");
  }

  /**
   * handles unassign OldData validation for a Quality61850
   *
   * @param command UnAssignOldDataFromQuality61850Command
   */
  public void validate(UnAssignOldDataFromQuality61850Command command) throws Exception {
    Assert.notNull(command, "UnAssignOldDataFromQuality61850Command should not be null");
    Assert.notNull(
        command.getQuality61850Id(),
        "UnAssignOldDataFromQuality61850Command identifier should not be null");
  }
  /**
   * handles assign OperatorBlocked validation for a Quality61850
   *
   * @param command AssignOperatorBlockedToQuality61850Command
   */
  public void validate(AssignOperatorBlockedToQuality61850Command command) throws Exception {
    Assert.notNull(command, "AssignOperatorBlockedToQuality61850Command should not be null");
    Assert.notNull(
        command.getQuality61850Id(),
        "AssignOperatorBlockedToQuality61850Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignOperatorBlockedToQuality61850Command assignment should not be null");
  }

  /**
   * handles unassign OperatorBlocked validation for a Quality61850
   *
   * @param command UnAssignOperatorBlockedFromQuality61850Command
   */
  public void validate(UnAssignOperatorBlockedFromQuality61850Command command) throws Exception {
    Assert.notNull(command, "UnAssignOperatorBlockedFromQuality61850Command should not be null");
    Assert.notNull(
        command.getQuality61850Id(),
        "UnAssignOperatorBlockedFromQuality61850Command identifier should not be null");
  }
  /**
   * handles assign Oscillatory validation for a Quality61850
   *
   * @param command AssignOscillatoryToQuality61850Command
   */
  public void validate(AssignOscillatoryToQuality61850Command command) throws Exception {
    Assert.notNull(command, "AssignOscillatoryToQuality61850Command should not be null");
    Assert.notNull(
        command.getQuality61850Id(),
        "AssignOscillatoryToQuality61850Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignOscillatoryToQuality61850Command assignment should not be null");
  }

  /**
   * handles unassign Oscillatory validation for a Quality61850
   *
   * @param command UnAssignOscillatoryFromQuality61850Command
   */
  public void validate(UnAssignOscillatoryFromQuality61850Command command) throws Exception {
    Assert.notNull(command, "UnAssignOscillatoryFromQuality61850Command should not be null");
    Assert.notNull(
        command.getQuality61850Id(),
        "UnAssignOscillatoryFromQuality61850Command identifier should not be null");
  }
  /**
   * handles assign OutOfRange validation for a Quality61850
   *
   * @param command AssignOutOfRangeToQuality61850Command
   */
  public void validate(AssignOutOfRangeToQuality61850Command command) throws Exception {
    Assert.notNull(command, "AssignOutOfRangeToQuality61850Command should not be null");
    Assert.notNull(
        command.getQuality61850Id(),
        "AssignOutOfRangeToQuality61850Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignOutOfRangeToQuality61850Command assignment should not be null");
  }

  /**
   * handles unassign OutOfRange validation for a Quality61850
   *
   * @param command UnAssignOutOfRangeFromQuality61850Command
   */
  public void validate(UnAssignOutOfRangeFromQuality61850Command command) throws Exception {
    Assert.notNull(command, "UnAssignOutOfRangeFromQuality61850Command should not be null");
    Assert.notNull(
        command.getQuality61850Id(),
        "UnAssignOutOfRangeFromQuality61850Command identifier should not be null");
  }
  /**
   * handles assign OverFlow validation for a Quality61850
   *
   * @param command AssignOverFlowToQuality61850Command
   */
  public void validate(AssignOverFlowToQuality61850Command command) throws Exception {
    Assert.notNull(command, "AssignOverFlowToQuality61850Command should not be null");
    Assert.notNull(
        command.getQuality61850Id(),
        "AssignOverFlowToQuality61850Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignOverFlowToQuality61850Command assignment should not be null");
  }

  /**
   * handles unassign OverFlow validation for a Quality61850
   *
   * @param command UnAssignOverFlowFromQuality61850Command
   */
  public void validate(UnAssignOverFlowFromQuality61850Command command) throws Exception {
    Assert.notNull(command, "UnAssignOverFlowFromQuality61850Command should not be null");
    Assert.notNull(
        command.getQuality61850Id(),
        "UnAssignOverFlowFromQuality61850Command identifier should not be null");
  }
  /**
   * handles assign Suspect validation for a Quality61850
   *
   * @param command AssignSuspectToQuality61850Command
   */
  public void validate(AssignSuspectToQuality61850Command command) throws Exception {
    Assert.notNull(command, "AssignSuspectToQuality61850Command should not be null");
    Assert.notNull(
        command.getQuality61850Id(),
        "AssignSuspectToQuality61850Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignSuspectToQuality61850Command assignment should not be null");
  }

  /**
   * handles unassign Suspect validation for a Quality61850
   *
   * @param command UnAssignSuspectFromQuality61850Command
   */
  public void validate(UnAssignSuspectFromQuality61850Command command) throws Exception {
    Assert.notNull(command, "UnAssignSuspectFromQuality61850Command should not be null");
    Assert.notNull(
        command.getQuality61850Id(),
        "UnAssignSuspectFromQuality61850Command identifier should not be null");
  }
  /**
   * handles assign Test validation for a Quality61850
   *
   * @param command AssignTestToQuality61850Command
   */
  public void validate(AssignTestToQuality61850Command command) throws Exception {
    Assert.notNull(command, "AssignTestToQuality61850Command should not be null");
    Assert.notNull(
        command.getQuality61850Id(),
        "AssignTestToQuality61850Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTestToQuality61850Command assignment should not be null");
  }

  /**
   * handles unassign Test validation for a Quality61850
   *
   * @param command UnAssignTestFromQuality61850Command
   */
  public void validate(UnAssignTestFromQuality61850Command command) throws Exception {
    Assert.notNull(command, "UnAssignTestFromQuality61850Command should not be null");
    Assert.notNull(
        command.getQuality61850Id(),
        "UnAssignTestFromQuality61850Command identifier should not be null");
  }
}
