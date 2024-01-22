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

public class Pss5Validator {

  /** default constructor */
  protected Pss5Validator() {}

  /** factory method */
  public static Pss5Validator getInstance() {
    return new Pss5Validator();
  }

  /** handles creation validation for a Pss5 */
  public void validate(CreatePss5Command pss5) throws Exception {
    Assert.notNull(pss5, "CreatePss5Command should not be null");
    //		Assert.isNull( pss5.getPss5Id(), "CreatePss5Command identifier should be null" );
  }

  /** handles update validation for a Pss5 */
  public void validate(UpdatePss5Command pss5) throws Exception {
    Assert.notNull(pss5, "UpdatePss5Command should not be null");
    Assert.notNull(pss5.getPss5Id(), "UpdatePss5Command identifier should not be null");
  }

  /** handles delete validation for a Pss5 */
  public void validate(DeletePss5Command pss5) throws Exception {
    Assert.notNull(pss5, "{commandAlias} should not be null");
    Assert.notNull(pss5.getPss5Id(), "DeletePss5Command identifier should not be null");
  }

  /** handles fetchOne validation for a Pss5 */
  public void validate(Pss5FetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "Pss5FetchOneSummary should not be null");
    Assert.notNull(summary.getPss5Id(), "Pss5FetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Ctw2 validation for a Pss5
   *
   * @param command AssignCtw2ToPss5Command
   */
  public void validate(AssignCtw2ToPss5Command command) throws Exception {
    Assert.notNull(command, "AssignCtw2ToPss5Command should not be null");
    Assert.notNull(command.getPss5Id(), "AssignCtw2ToPss5Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignCtw2ToPss5Command assignment should not be null");
  }

  /**
   * handles unassign Ctw2 validation for a Pss5
   *
   * @param command UnAssignCtw2FromPss5Command
   */
  public void validate(UnAssignCtw2FromPss5Command command) throws Exception {
    Assert.notNull(command, "UnAssignCtw2FromPss5Command should not be null");
    Assert.notNull(
        command.getPss5Id(), "UnAssignCtw2FromPss5Command identifier should not be null");
  }
  /**
   * handles assign Deadband validation for a Pss5
   *
   * @param command AssignDeadbandToPss5Command
   */
  public void validate(AssignDeadbandToPss5Command command) throws Exception {
    Assert.notNull(command, "AssignDeadbandToPss5Command should not be null");
    Assert.notNull(
        command.getPss5Id(), "AssignDeadbandToPss5Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignDeadbandToPss5Command assignment should not be null");
  }

  /**
   * handles unassign Deadband validation for a Pss5
   *
   * @param command UnAssignDeadbandFromPss5Command
   */
  public void validate(UnAssignDeadbandFromPss5Command command) throws Exception {
    Assert.notNull(command, "UnAssignDeadbandFromPss5Command should not be null");
    Assert.notNull(
        command.getPss5Id(), "UnAssignDeadbandFromPss5Command identifier should not be null");
  }
  /**
   * handles assign Isfreq validation for a Pss5
   *
   * @param command AssignIsfreqToPss5Command
   */
  public void validate(AssignIsfreqToPss5Command command) throws Exception {
    Assert.notNull(command, "AssignIsfreqToPss5Command should not be null");
    Assert.notNull(command.getPss5Id(), "AssignIsfreqToPss5Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignIsfreqToPss5Command assignment should not be null");
  }

  /**
   * handles unassign Isfreq validation for a Pss5
   *
   * @param command UnAssignIsfreqFromPss5Command
   */
  public void validate(UnAssignIsfreqFromPss5Command command) throws Exception {
    Assert.notNull(command, "UnAssignIsfreqFromPss5Command should not be null");
    Assert.notNull(
        command.getPss5Id(), "UnAssignIsfreqFromPss5Command identifier should not be null");
  }
  /**
   * handles assign Kf validation for a Pss5
   *
   * @param command AssignKfToPss5Command
   */
  public void validate(AssignKfToPss5Command command) throws Exception {
    Assert.notNull(command, "AssignKfToPss5Command should not be null");
    Assert.notNull(command.getPss5Id(), "AssignKfToPss5Command identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignKfToPss5Command assignment should not be null");
  }

  /**
   * handles unassign Kf validation for a Pss5
   *
   * @param command UnAssignKfFromPss5Command
   */
  public void validate(UnAssignKfFromPss5Command command) throws Exception {
    Assert.notNull(command, "UnAssignKfFromPss5Command should not be null");
    Assert.notNull(command.getPss5Id(), "UnAssignKfFromPss5Command identifier should not be null");
  }
  /**
   * handles assign Kpe validation for a Pss5
   *
   * @param command AssignKpeToPss5Command
   */
  public void validate(AssignKpeToPss5Command command) throws Exception {
    Assert.notNull(command, "AssignKpeToPss5Command should not be null");
    Assert.notNull(command.getPss5Id(), "AssignKpeToPss5Command identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignKpeToPss5Command assignment should not be null");
  }

  /**
   * handles unassign Kpe validation for a Pss5
   *
   * @param command UnAssignKpeFromPss5Command
   */
  public void validate(UnAssignKpeFromPss5Command command) throws Exception {
    Assert.notNull(command, "UnAssignKpeFromPss5Command should not be null");
    Assert.notNull(command.getPss5Id(), "UnAssignKpeFromPss5Command identifier should not be null");
  }
  /**
   * handles assign Kpss validation for a Pss5
   *
   * @param command AssignKpssToPss5Command
   */
  public void validate(AssignKpssToPss5Command command) throws Exception {
    Assert.notNull(command, "AssignKpssToPss5Command should not be null");
    Assert.notNull(command.getPss5Id(), "AssignKpssToPss5Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKpssToPss5Command assignment should not be null");
  }

  /**
   * handles unassign Kpss validation for a Pss5
   *
   * @param command UnAssignKpssFromPss5Command
   */
  public void validate(UnAssignKpssFromPss5Command command) throws Exception {
    Assert.notNull(command, "UnAssignKpssFromPss5Command should not be null");
    Assert.notNull(
        command.getPss5Id(), "UnAssignKpssFromPss5Command identifier should not be null");
  }
  /**
   * handles assign Pmm validation for a Pss5
   *
   * @param command AssignPmmToPss5Command
   */
  public void validate(AssignPmmToPss5Command command) throws Exception {
    Assert.notNull(command, "AssignPmmToPss5Command should not be null");
    Assert.notNull(command.getPss5Id(), "AssignPmmToPss5Command identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignPmmToPss5Command assignment should not be null");
  }

  /**
   * handles unassign Pmm validation for a Pss5
   *
   * @param command UnAssignPmmFromPss5Command
   */
  public void validate(UnAssignPmmFromPss5Command command) throws Exception {
    Assert.notNull(command, "UnAssignPmmFromPss5Command should not be null");
    Assert.notNull(command.getPss5Id(), "UnAssignPmmFromPss5Command identifier should not be null");
  }
  /**
   * handles assign Tl1 validation for a Pss5
   *
   * @param command AssignTl1ToPss5Command
   */
  public void validate(AssignTl1ToPss5Command command) throws Exception {
    Assert.notNull(command, "AssignTl1ToPss5Command should not be null");
    Assert.notNull(command.getPss5Id(), "AssignTl1ToPss5Command identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignTl1ToPss5Command assignment should not be null");
  }

  /**
   * handles unassign Tl1 validation for a Pss5
   *
   * @param command UnAssignTl1FromPss5Command
   */
  public void validate(UnAssignTl1FromPss5Command command) throws Exception {
    Assert.notNull(command, "UnAssignTl1FromPss5Command should not be null");
    Assert.notNull(command.getPss5Id(), "UnAssignTl1FromPss5Command identifier should not be null");
  }
  /**
   * handles assign Tl2 validation for a Pss5
   *
   * @param command AssignTl2ToPss5Command
   */
  public void validate(AssignTl2ToPss5Command command) throws Exception {
    Assert.notNull(command, "AssignTl2ToPss5Command should not be null");
    Assert.notNull(command.getPss5Id(), "AssignTl2ToPss5Command identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignTl2ToPss5Command assignment should not be null");
  }

  /**
   * handles unassign Tl2 validation for a Pss5
   *
   * @param command UnAssignTl2FromPss5Command
   */
  public void validate(UnAssignTl2FromPss5Command command) throws Exception {
    Assert.notNull(command, "UnAssignTl2FromPss5Command should not be null");
    Assert.notNull(command.getPss5Id(), "UnAssignTl2FromPss5Command identifier should not be null");
  }
  /**
   * handles assign Tl3 validation for a Pss5
   *
   * @param command AssignTl3ToPss5Command
   */
  public void validate(AssignTl3ToPss5Command command) throws Exception {
    Assert.notNull(command, "AssignTl3ToPss5Command should not be null");
    Assert.notNull(command.getPss5Id(), "AssignTl3ToPss5Command identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignTl3ToPss5Command assignment should not be null");
  }

  /**
   * handles unassign Tl3 validation for a Pss5
   *
   * @param command UnAssignTl3FromPss5Command
   */
  public void validate(UnAssignTl3FromPss5Command command) throws Exception {
    Assert.notNull(command, "UnAssignTl3FromPss5Command should not be null");
    Assert.notNull(command.getPss5Id(), "UnAssignTl3FromPss5Command identifier should not be null");
  }
  /**
   * handles assign Tl4 validation for a Pss5
   *
   * @param command AssignTl4ToPss5Command
   */
  public void validate(AssignTl4ToPss5Command command) throws Exception {
    Assert.notNull(command, "AssignTl4ToPss5Command should not be null");
    Assert.notNull(command.getPss5Id(), "AssignTl4ToPss5Command identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignTl4ToPss5Command assignment should not be null");
  }

  /**
   * handles unassign Tl4 validation for a Pss5
   *
   * @param command UnAssignTl4FromPss5Command
   */
  public void validate(UnAssignTl4FromPss5Command command) throws Exception {
    Assert.notNull(command, "UnAssignTl4FromPss5Command should not be null");
    Assert.notNull(command.getPss5Id(), "UnAssignTl4FromPss5Command identifier should not be null");
  }
  /**
   * handles assign Tpe validation for a Pss5
   *
   * @param command AssignTpeToPss5Command
   */
  public void validate(AssignTpeToPss5Command command) throws Exception {
    Assert.notNull(command, "AssignTpeToPss5Command should not be null");
    Assert.notNull(command.getPss5Id(), "AssignTpeToPss5Command identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignTpeToPss5Command assignment should not be null");
  }

  /**
   * handles unassign Tpe validation for a Pss5
   *
   * @param command UnAssignTpeFromPss5Command
   */
  public void validate(UnAssignTpeFromPss5Command command) throws Exception {
    Assert.notNull(command, "UnAssignTpeFromPss5Command should not be null");
    Assert.notNull(command.getPss5Id(), "UnAssignTpeFromPss5Command identifier should not be null");
  }
  /**
   * handles assign Tw1 validation for a Pss5
   *
   * @param command AssignTw1ToPss5Command
   */
  public void validate(AssignTw1ToPss5Command command) throws Exception {
    Assert.notNull(command, "AssignTw1ToPss5Command should not be null");
    Assert.notNull(command.getPss5Id(), "AssignTw1ToPss5Command identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignTw1ToPss5Command assignment should not be null");
  }

  /**
   * handles unassign Tw1 validation for a Pss5
   *
   * @param command UnAssignTw1FromPss5Command
   */
  public void validate(UnAssignTw1FromPss5Command command) throws Exception {
    Assert.notNull(command, "UnAssignTw1FromPss5Command should not be null");
    Assert.notNull(command.getPss5Id(), "UnAssignTw1FromPss5Command identifier should not be null");
  }
  /**
   * handles assign Tw2 validation for a Pss5
   *
   * @param command AssignTw2ToPss5Command
   */
  public void validate(AssignTw2ToPss5Command command) throws Exception {
    Assert.notNull(command, "AssignTw2ToPss5Command should not be null");
    Assert.notNull(command.getPss5Id(), "AssignTw2ToPss5Command identifier should not be null");
    Assert.notNull(command.getAssignment(), "AssignTw2ToPss5Command assignment should not be null");
  }

  /**
   * handles unassign Tw2 validation for a Pss5
   *
   * @param command UnAssignTw2FromPss5Command
   */
  public void validate(UnAssignTw2FromPss5Command command) throws Exception {
    Assert.notNull(command, "UnAssignTw2FromPss5Command should not be null");
    Assert.notNull(command.getPss5Id(), "UnAssignTw2FromPss5Command identifier should not be null");
  }
  /**
   * handles assign Vadat validation for a Pss5
   *
   * @param command AssignVadatToPss5Command
   */
  public void validate(AssignVadatToPss5Command command) throws Exception {
    Assert.notNull(command, "AssignVadatToPss5Command should not be null");
    Assert.notNull(command.getPss5Id(), "AssignVadatToPss5Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVadatToPss5Command assignment should not be null");
  }

  /**
   * handles unassign Vadat validation for a Pss5
   *
   * @param command UnAssignVadatFromPss5Command
   */
  public void validate(UnAssignVadatFromPss5Command command) throws Exception {
    Assert.notNull(command, "UnAssignVadatFromPss5Command should not be null");
    Assert.notNull(
        command.getPss5Id(), "UnAssignVadatFromPss5Command identifier should not be null");
  }
  /**
   * handles assign Vsmn validation for a Pss5
   *
   * @param command AssignVsmnToPss5Command
   */
  public void validate(AssignVsmnToPss5Command command) throws Exception {
    Assert.notNull(command, "AssignVsmnToPss5Command should not be null");
    Assert.notNull(command.getPss5Id(), "AssignVsmnToPss5Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVsmnToPss5Command assignment should not be null");
  }

  /**
   * handles unassign Vsmn validation for a Pss5
   *
   * @param command UnAssignVsmnFromPss5Command
   */
  public void validate(UnAssignVsmnFromPss5Command command) throws Exception {
    Assert.notNull(command, "UnAssignVsmnFromPss5Command should not be null");
    Assert.notNull(
        command.getPss5Id(), "UnAssignVsmnFromPss5Command identifier should not be null");
  }
  /**
   * handles assign Vsmx validation for a Pss5
   *
   * @param command AssignVsmxToPss5Command
   */
  public void validate(AssignVsmxToPss5Command command) throws Exception {
    Assert.notNull(command, "AssignVsmxToPss5Command should not be null");
    Assert.notNull(command.getPss5Id(), "AssignVsmxToPss5Command identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVsmxToPss5Command assignment should not be null");
  }

  /**
   * handles unassign Vsmx validation for a Pss5
   *
   * @param command UnAssignVsmxFromPss5Command
   */
  public void validate(UnAssignVsmxFromPss5Command command) throws Exception {
    Assert.notNull(command, "UnAssignVsmxFromPss5Command should not be null");
    Assert.notNull(
        command.getPss5Id(), "UnAssignVsmxFromPss5Command identifier should not be null");
  }
}
