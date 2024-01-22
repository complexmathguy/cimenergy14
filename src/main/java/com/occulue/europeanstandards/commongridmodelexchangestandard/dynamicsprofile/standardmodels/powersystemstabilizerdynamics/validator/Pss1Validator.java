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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.powersystemstabilizerdynamics.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class Pss1Validator {

  /** default constructor */
  protected Pss1Validator() {}

  /** factory method */
  public static Pss1Validator getInstance() {
    return new Pss1Validator();
  }

  /** handles creation validation for a Pss1 */
  public void validate(CreatePss1Command pss1) throws Exception {
    Assert.notNull(pss1, "CreatePss1Command should not be null");
    //		Assert.isNull( pss1.getPss1Id(), "CreatePss1Command identifier should be null" );
  }

  /** handles update validation for a Pss1 */
  public void validate(UpdatePss1Command pss1) throws Exception {
    Assert.notNull(pss1, "UpdatePss1Command should not be null");
    Assert.notNull(pss1.getPss1Id(), "UpdatePss1Command identifier should not be null");
  }

  /** handles delete validation for a Pss1 */
  public void validate(DeletePss1Command pss1) throws Exception {
    Assert.notNull(pss1, "{commandAlias} should not be null");
    Assert.notNull(pss1.getPss1Id(), "DeletePss1Command identifier should not be null");
  }

  /** handles fetchOne validation for a Pss1 */
  public void validate(Pss1FetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "Pss1FetchOneSummary should not be null");
    Assert.notNull(summary.getPss1Id(), "Pss1FetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Kf validation for a Pss1
   *
   * @param command AssignKfToPss1Command
   */
  public void validate(AssignKfToPss1Command command) throws Exception {
    Assert.notNull(command, "AssignKfToPss1Command should not be null");
    Assert.notNull(command.getPss1Id(), "AssignKfToPss1Command identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignKfToPss1Command assignment should not be null");
  }

  /**
   * handles unassign Kf validation for a Pss1
   *
   * @param command UnAssignKfFromPss1Command
   */
  public void validate(UnAssignKfFromPss1Command command) throws Exception {
    Assert.notNull(command, "UnAssignKfFromPss1Command should not be null");
    Assert.notNull(command.getPss1Id(), "UnAssignKfFromPss1Command identifier should not be null");
  }
  /**
   * handles assign Kpe validation for a Pss1
   *
   * @param command AssignKpeToPss1Command
   */
  public void validate(AssignKpeToPss1Command command) throws Exception {
    Assert.notNull(command, "AssignKpeToPss1Command should not be null");
    Assert.notNull(command.getPss1Id(), "AssignKpeToPss1Command identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignKpeToPss1Command assignment should not be null");
  }

  /**
   * handles unassign Kpe validation for a Pss1
   *
   * @param command UnAssignKpeFromPss1Command
   */
  public void validate(UnAssignKpeFromPss1Command command) throws Exception {
    Assert.notNull(command, "UnAssignKpeFromPss1Command should not be null");
    Assert.notNull(command.getPss1Id(), "UnAssignKpeFromPss1Command identifier should not be null");
  }
  /**
   * handles assign Ks validation for a Pss1
   *
   * @param command AssignKsToPss1Command
   */
  public void validate(AssignKsToPss1Command command) throws Exception {
    Assert.notNull(command, "AssignKsToPss1Command should not be null");
    Assert.notNull(command.getPss1Id(), "AssignKsToPss1Command identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignKsToPss1Command assignment should not be null");
  }

  /**
   * handles unassign Ks validation for a Pss1
   *
   * @param command UnAssignKsFromPss1Command
   */
  public void validate(UnAssignKsFromPss1Command command) throws Exception {
    Assert.notNull(command, "UnAssignKsFromPss1Command should not be null");
    Assert.notNull(command.getPss1Id(), "UnAssignKsFromPss1Command identifier should not be null");
  }
  /**
   * handles assign Kw validation for a Pss1
   *
   * @param command AssignKwToPss1Command
   */
  public void validate(AssignKwToPss1Command command) throws Exception {
    Assert.notNull(command, "AssignKwToPss1Command should not be null");
    Assert.notNull(command.getPss1Id(), "AssignKwToPss1Command identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignKwToPss1Command assignment should not be null");
  }

  /**
   * handles unassign Kw validation for a Pss1
   *
   * @param command UnAssignKwFromPss1Command
   */
  public void validate(UnAssignKwFromPss1Command command) throws Exception {
    Assert.notNull(command, "UnAssignKwFromPss1Command should not be null");
    Assert.notNull(command.getPss1Id(), "UnAssignKwFromPss1Command identifier should not be null");
  }
  /**
   * handles assign Pmin validation for a Pss1
   *
   * @param command AssignPminToPss1Command
   */
  public void validate(AssignPminToPss1Command command) throws Exception {
    Assert.notNull(command, "AssignPminToPss1Command should not be null");
    Assert.notNull(command.getPss1Id(), "AssignPminToPss1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignPminToPss1Command assignment should not be null");
  }

  /**
   * handles unassign Pmin validation for a Pss1
   *
   * @param command UnAssignPminFromPss1Command
   */
  public void validate(UnAssignPminFromPss1Command command) throws Exception {
    Assert.notNull(command, "UnAssignPminFromPss1Command should not be null");
    Assert.notNull(
        command.getPss1Id(), "UnAssignPminFromPss1Command identifier should not be null");
  }
  /**
   * handles assign T10 validation for a Pss1
   *
   * @param command AssignT10ToPss1Command
   */
  public void validate(AssignT10ToPss1Command command) throws Exception {
    Assert.notNull(command, "AssignT10ToPss1Command should not be null");
    Assert.notNull(command.getPss1Id(), "AssignT10ToPss1Command identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignT10ToPss1Command assignment should not be null");
  }

  /**
   * handles unassign T10 validation for a Pss1
   *
   * @param command UnAssignT10FromPss1Command
   */
  public void validate(UnAssignT10FromPss1Command command) throws Exception {
    Assert.notNull(command, "UnAssignT10FromPss1Command should not be null");
    Assert.notNull(command.getPss1Id(), "UnAssignT10FromPss1Command identifier should not be null");
  }
  /**
   * handles assign T5 validation for a Pss1
   *
   * @param command AssignT5ToPss1Command
   */
  public void validate(AssignT5ToPss1Command command) throws Exception {
    Assert.notNull(command, "AssignT5ToPss1Command should not be null");
    Assert.notNull(command.getPss1Id(), "AssignT5ToPss1Command identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignT5ToPss1Command assignment should not be null");
  }

  /**
   * handles unassign T5 validation for a Pss1
   *
   * @param command UnAssignT5FromPss1Command
   */
  public void validate(UnAssignT5FromPss1Command command) throws Exception {
    Assert.notNull(command, "UnAssignT5FromPss1Command should not be null");
    Assert.notNull(command.getPss1Id(), "UnAssignT5FromPss1Command identifier should not be null");
  }
  /**
   * handles assign T6 validation for a Pss1
   *
   * @param command AssignT6ToPss1Command
   */
  public void validate(AssignT6ToPss1Command command) throws Exception {
    Assert.notNull(command, "AssignT6ToPss1Command should not be null");
    Assert.notNull(command.getPss1Id(), "AssignT6ToPss1Command identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignT6ToPss1Command assignment should not be null");
  }

  /**
   * handles unassign T6 validation for a Pss1
   *
   * @param command UnAssignT6FromPss1Command
   */
  public void validate(UnAssignT6FromPss1Command command) throws Exception {
    Assert.notNull(command, "UnAssignT6FromPss1Command should not be null");
    Assert.notNull(command.getPss1Id(), "UnAssignT6FromPss1Command identifier should not be null");
  }
  /**
   * handles assign T7 validation for a Pss1
   *
   * @param command AssignT7ToPss1Command
   */
  public void validate(AssignT7ToPss1Command command) throws Exception {
    Assert.notNull(command, "AssignT7ToPss1Command should not be null");
    Assert.notNull(command.getPss1Id(), "AssignT7ToPss1Command identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignT7ToPss1Command assignment should not be null");
  }

  /**
   * handles unassign T7 validation for a Pss1
   *
   * @param command UnAssignT7FromPss1Command
   */
  public void validate(UnAssignT7FromPss1Command command) throws Exception {
    Assert.notNull(command, "UnAssignT7FromPss1Command should not be null");
    Assert.notNull(command.getPss1Id(), "UnAssignT7FromPss1Command identifier should not be null");
  }
  /**
   * handles assign T8 validation for a Pss1
   *
   * @param command AssignT8ToPss1Command
   */
  public void validate(AssignT8ToPss1Command command) throws Exception {
    Assert.notNull(command, "AssignT8ToPss1Command should not be null");
    Assert.notNull(command.getPss1Id(), "AssignT8ToPss1Command identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignT8ToPss1Command assignment should not be null");
  }

  /**
   * handles unassign T8 validation for a Pss1
   *
   * @param command UnAssignT8FromPss1Command
   */
  public void validate(UnAssignT8FromPss1Command command) throws Exception {
    Assert.notNull(command, "UnAssignT8FromPss1Command should not be null");
    Assert.notNull(command.getPss1Id(), "UnAssignT8FromPss1Command identifier should not be null");
  }
  /**
   * handles assign T9 validation for a Pss1
   *
   * @param command AssignT9ToPss1Command
   */
  public void validate(AssignT9ToPss1Command command) throws Exception {
    Assert.notNull(command, "AssignT9ToPss1Command should not be null");
    Assert.notNull(command.getPss1Id(), "AssignT9ToPss1Command identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignT9ToPss1Command assignment should not be null");
  }

  /**
   * handles unassign T9 validation for a Pss1
   *
   * @param command UnAssignT9FromPss1Command
   */
  public void validate(UnAssignT9FromPss1Command command) throws Exception {
    Assert.notNull(command, "UnAssignT9FromPss1Command should not be null");
    Assert.notNull(command.getPss1Id(), "UnAssignT9FromPss1Command identifier should not be null");
  }
  /**
   * handles assign Tpe validation for a Pss1
   *
   * @param command AssignTpeToPss1Command
   */
  public void validate(AssignTpeToPss1Command command) throws Exception {
    Assert.notNull(command, "AssignTpeToPss1Command should not be null");
    Assert.notNull(command.getPss1Id(), "AssignTpeToPss1Command identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignTpeToPss1Command assignment should not be null");
  }

  /**
   * handles unassign Tpe validation for a Pss1
   *
   * @param command UnAssignTpeFromPss1Command
   */
  public void validate(UnAssignTpeFromPss1Command command) throws Exception {
    Assert.notNull(command, "UnAssignTpeFromPss1Command should not be null");
    Assert.notNull(command.getPss1Id(), "UnAssignTpeFromPss1Command identifier should not be null");
  }
  /**
   * handles assign Vadat validation for a Pss1
   *
   * @param command AssignVadatToPss1Command
   */
  public void validate(AssignVadatToPss1Command command) throws Exception {
    Assert.notNull(command, "AssignVadatToPss1Command should not be null");
    Assert.notNull(command.getPss1Id(), "AssignVadatToPss1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVadatToPss1Command assignment should not be null");
  }

  /**
   * handles unassign Vadat validation for a Pss1
   *
   * @param command UnAssignVadatFromPss1Command
   */
  public void validate(UnAssignVadatFromPss1Command command) throws Exception {
    Assert.notNull(command, "UnAssignVadatFromPss1Command should not be null");
    Assert.notNull(
        command.getPss1Id(), "UnAssignVadatFromPss1Command identifier should not be null");
  }
  /**
   * handles assign Vsmn validation for a Pss1
   *
   * @param command AssignVsmnToPss1Command
   */
  public void validate(AssignVsmnToPss1Command command) throws Exception {
    Assert.notNull(command, "AssignVsmnToPss1Command should not be null");
    Assert.notNull(command.getPss1Id(), "AssignVsmnToPss1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVsmnToPss1Command assignment should not be null");
  }

  /**
   * handles unassign Vsmn validation for a Pss1
   *
   * @param command UnAssignVsmnFromPss1Command
   */
  public void validate(UnAssignVsmnFromPss1Command command) throws Exception {
    Assert.notNull(command, "UnAssignVsmnFromPss1Command should not be null");
    Assert.notNull(
        command.getPss1Id(), "UnAssignVsmnFromPss1Command identifier should not be null");
  }
  /**
   * handles assign Vsmx validation for a Pss1
   *
   * @param command AssignVsmxToPss1Command
   */
  public void validate(AssignVsmxToPss1Command command) throws Exception {
    Assert.notNull(command, "AssignVsmxToPss1Command should not be null");
    Assert.notNull(command.getPss1Id(), "AssignVsmxToPss1Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVsmxToPss1Command assignment should not be null");
  }

  /**
   * handles unassign Vsmx validation for a Pss1
   *
   * @param command UnAssignVsmxFromPss1Command
   */
  public void validate(UnAssignVsmxFromPss1Command command) throws Exception {
    Assert.notNull(command, "UnAssignVsmxFromPss1Command should not be null");
    Assert.notNull(
        command.getPss1Id(), "UnAssignVsmxFromPss1Command identifier should not be null");
  }
}
