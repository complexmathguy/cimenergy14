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

public class ExcIEEEST5BValidator {

  /** default constructor */
  protected ExcIEEEST5BValidator() {}

  /** factory method */
  public static ExcIEEEST5BValidator getInstance() {
    return new ExcIEEEST5BValidator();
  }

  /** handles creation validation for a ExcIEEEST5B */
  public void validate(CreateExcIEEEST5BCommand excIEEEST5B) throws Exception {
    Assert.notNull(excIEEEST5B, "CreateExcIEEEST5BCommand should not be null");
    //		Assert.isNull( excIEEEST5B.getExcIEEEST5BId(), "CreateExcIEEEST5BCommand identifier should
    // be null" );
  }

  /** handles update validation for a ExcIEEEST5B */
  public void validate(UpdateExcIEEEST5BCommand excIEEEST5B) throws Exception {
    Assert.notNull(excIEEEST5B, "UpdateExcIEEEST5BCommand should not be null");
    Assert.notNull(
        excIEEEST5B.getExcIEEEST5BId(), "UpdateExcIEEEST5BCommand identifier should not be null");
  }

  /** handles delete validation for a ExcIEEEST5B */
  public void validate(DeleteExcIEEEST5BCommand excIEEEST5B) throws Exception {
    Assert.notNull(excIEEEST5B, "{commandAlias} should not be null");
    Assert.notNull(
        excIEEEST5B.getExcIEEEST5BId(), "DeleteExcIEEEST5BCommand identifier should not be null");
  }

  /** handles fetchOne validation for a ExcIEEEST5B */
  public void validate(ExcIEEEST5BFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "ExcIEEEST5BFetchOneSummary should not be null");
    Assert.notNull(
        summary.getExcIEEEST5BId(), "ExcIEEEST5BFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Kc validation for a ExcIEEEST5B
   *
   * @param command AssignKcToExcIEEEST5BCommand
   */
  public void validate(AssignKcToExcIEEEST5BCommand command) throws Exception {
    Assert.notNull(command, "AssignKcToExcIEEEST5BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST5BId(), "AssignKcToExcIEEEST5BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKcToExcIEEEST5BCommand assignment should not be null");
  }

  /**
   * handles unassign Kc validation for a ExcIEEEST5B
   *
   * @param command UnAssignKcFromExcIEEEST5BCommand
   */
  public void validate(UnAssignKcFromExcIEEEST5BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKcFromExcIEEEST5BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST5BId(),
        "UnAssignKcFromExcIEEEST5BCommand identifier should not be null");
  }
  /**
   * handles assign Kr validation for a ExcIEEEST5B
   *
   * @param command AssignKrToExcIEEEST5BCommand
   */
  public void validate(AssignKrToExcIEEEST5BCommand command) throws Exception {
    Assert.notNull(command, "AssignKrToExcIEEEST5BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST5BId(), "AssignKrToExcIEEEST5BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignKrToExcIEEEST5BCommand assignment should not be null");
  }

  /**
   * handles unassign Kr validation for a ExcIEEEST5B
   *
   * @param command UnAssignKrFromExcIEEEST5BCommand
   */
  public void validate(UnAssignKrFromExcIEEEST5BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKrFromExcIEEEST5BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST5BId(),
        "UnAssignKrFromExcIEEEST5BCommand identifier should not be null");
  }
  /**
   * handles assign T1 validation for a ExcIEEEST5B
   *
   * @param command AssignT1ToExcIEEEST5BCommand
   */
  public void validate(AssignT1ToExcIEEEST5BCommand command) throws Exception {
    Assert.notNull(command, "AssignT1ToExcIEEEST5BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST5BId(), "AssignT1ToExcIEEEST5BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignT1ToExcIEEEST5BCommand assignment should not be null");
  }

  /**
   * handles unassign T1 validation for a ExcIEEEST5B
   *
   * @param command UnAssignT1FromExcIEEEST5BCommand
   */
  public void validate(UnAssignT1FromExcIEEEST5BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignT1FromExcIEEEST5BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST5BId(),
        "UnAssignT1FromExcIEEEST5BCommand identifier should not be null");
  }
  /**
   * handles assign Tb1 validation for a ExcIEEEST5B
   *
   * @param command AssignTb1ToExcIEEEST5BCommand
   */
  public void validate(AssignTb1ToExcIEEEST5BCommand command) throws Exception {
    Assert.notNull(command, "AssignTb1ToExcIEEEST5BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST5BId(), "AssignTb1ToExcIEEEST5BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTb1ToExcIEEEST5BCommand assignment should not be null");
  }

  /**
   * handles unassign Tb1 validation for a ExcIEEEST5B
   *
   * @param command UnAssignTb1FromExcIEEEST5BCommand
   */
  public void validate(UnAssignTb1FromExcIEEEST5BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTb1FromExcIEEEST5BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST5BId(),
        "UnAssignTb1FromExcIEEEST5BCommand identifier should not be null");
  }
  /**
   * handles assign Tb2 validation for a ExcIEEEST5B
   *
   * @param command AssignTb2ToExcIEEEST5BCommand
   */
  public void validate(AssignTb2ToExcIEEEST5BCommand command) throws Exception {
    Assert.notNull(command, "AssignTb2ToExcIEEEST5BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST5BId(), "AssignTb2ToExcIEEEST5BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTb2ToExcIEEEST5BCommand assignment should not be null");
  }

  /**
   * handles unassign Tb2 validation for a ExcIEEEST5B
   *
   * @param command UnAssignTb2FromExcIEEEST5BCommand
   */
  public void validate(UnAssignTb2FromExcIEEEST5BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTb2FromExcIEEEST5BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST5BId(),
        "UnAssignTb2FromExcIEEEST5BCommand identifier should not be null");
  }
  /**
   * handles assign Tc1 validation for a ExcIEEEST5B
   *
   * @param command AssignTc1ToExcIEEEST5BCommand
   */
  public void validate(AssignTc1ToExcIEEEST5BCommand command) throws Exception {
    Assert.notNull(command, "AssignTc1ToExcIEEEST5BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST5BId(), "AssignTc1ToExcIEEEST5BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTc1ToExcIEEEST5BCommand assignment should not be null");
  }

  /**
   * handles unassign Tc1 validation for a ExcIEEEST5B
   *
   * @param command UnAssignTc1FromExcIEEEST5BCommand
   */
  public void validate(UnAssignTc1FromExcIEEEST5BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTc1FromExcIEEEST5BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST5BId(),
        "UnAssignTc1FromExcIEEEST5BCommand identifier should not be null");
  }
  /**
   * handles assign Tc2 validation for a ExcIEEEST5B
   *
   * @param command AssignTc2ToExcIEEEST5BCommand
   */
  public void validate(AssignTc2ToExcIEEEST5BCommand command) throws Exception {
    Assert.notNull(command, "AssignTc2ToExcIEEEST5BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST5BId(), "AssignTc2ToExcIEEEST5BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTc2ToExcIEEEST5BCommand assignment should not be null");
  }

  /**
   * handles unassign Tc2 validation for a ExcIEEEST5B
   *
   * @param command UnAssignTc2FromExcIEEEST5BCommand
   */
  public void validate(UnAssignTc2FromExcIEEEST5BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTc2FromExcIEEEST5BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST5BId(),
        "UnAssignTc2FromExcIEEEST5BCommand identifier should not be null");
  }
  /**
   * handles assign Tob1 validation for a ExcIEEEST5B
   *
   * @param command AssignTob1ToExcIEEEST5BCommand
   */
  public void validate(AssignTob1ToExcIEEEST5BCommand command) throws Exception {
    Assert.notNull(command, "AssignTob1ToExcIEEEST5BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST5BId(), "AssignTob1ToExcIEEEST5BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTob1ToExcIEEEST5BCommand assignment should not be null");
  }

  /**
   * handles unassign Tob1 validation for a ExcIEEEST5B
   *
   * @param command UnAssignTob1FromExcIEEEST5BCommand
   */
  public void validate(UnAssignTob1FromExcIEEEST5BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTob1FromExcIEEEST5BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST5BId(),
        "UnAssignTob1FromExcIEEEST5BCommand identifier should not be null");
  }
  /**
   * handles assign Tob2 validation for a ExcIEEEST5B
   *
   * @param command AssignTob2ToExcIEEEST5BCommand
   */
  public void validate(AssignTob2ToExcIEEEST5BCommand command) throws Exception {
    Assert.notNull(command, "AssignTob2ToExcIEEEST5BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST5BId(), "AssignTob2ToExcIEEEST5BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTob2ToExcIEEEST5BCommand assignment should not be null");
  }

  /**
   * handles unassign Tob2 validation for a ExcIEEEST5B
   *
   * @param command UnAssignTob2FromExcIEEEST5BCommand
   */
  public void validate(UnAssignTob2FromExcIEEEST5BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTob2FromExcIEEEST5BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST5BId(),
        "UnAssignTob2FromExcIEEEST5BCommand identifier should not be null");
  }
  /**
   * handles assign Toc1 validation for a ExcIEEEST5B
   *
   * @param command AssignToc1ToExcIEEEST5BCommand
   */
  public void validate(AssignToc1ToExcIEEEST5BCommand command) throws Exception {
    Assert.notNull(command, "AssignToc1ToExcIEEEST5BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST5BId(), "AssignToc1ToExcIEEEST5BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignToc1ToExcIEEEST5BCommand assignment should not be null");
  }

  /**
   * handles unassign Toc1 validation for a ExcIEEEST5B
   *
   * @param command UnAssignToc1FromExcIEEEST5BCommand
   */
  public void validate(UnAssignToc1FromExcIEEEST5BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignToc1FromExcIEEEST5BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST5BId(),
        "UnAssignToc1FromExcIEEEST5BCommand identifier should not be null");
  }
  /**
   * handles assign Toc2 validation for a ExcIEEEST5B
   *
   * @param command AssignToc2ToExcIEEEST5BCommand
   */
  public void validate(AssignToc2ToExcIEEEST5BCommand command) throws Exception {
    Assert.notNull(command, "AssignToc2ToExcIEEEST5BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST5BId(), "AssignToc2ToExcIEEEST5BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignToc2ToExcIEEEST5BCommand assignment should not be null");
  }

  /**
   * handles unassign Toc2 validation for a ExcIEEEST5B
   *
   * @param command UnAssignToc2FromExcIEEEST5BCommand
   */
  public void validate(UnAssignToc2FromExcIEEEST5BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignToc2FromExcIEEEST5BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST5BId(),
        "UnAssignToc2FromExcIEEEST5BCommand identifier should not be null");
  }
  /**
   * handles assign Tub1 validation for a ExcIEEEST5B
   *
   * @param command AssignTub1ToExcIEEEST5BCommand
   */
  public void validate(AssignTub1ToExcIEEEST5BCommand command) throws Exception {
    Assert.notNull(command, "AssignTub1ToExcIEEEST5BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST5BId(), "AssignTub1ToExcIEEEST5BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTub1ToExcIEEEST5BCommand assignment should not be null");
  }

  /**
   * handles unassign Tub1 validation for a ExcIEEEST5B
   *
   * @param command UnAssignTub1FromExcIEEEST5BCommand
   */
  public void validate(UnAssignTub1FromExcIEEEST5BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTub1FromExcIEEEST5BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST5BId(),
        "UnAssignTub1FromExcIEEEST5BCommand identifier should not be null");
  }
  /**
   * handles assign Tub2 validation for a ExcIEEEST5B
   *
   * @param command AssignTub2ToExcIEEEST5BCommand
   */
  public void validate(AssignTub2ToExcIEEEST5BCommand command) throws Exception {
    Assert.notNull(command, "AssignTub2ToExcIEEEST5BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST5BId(), "AssignTub2ToExcIEEEST5BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTub2ToExcIEEEST5BCommand assignment should not be null");
  }

  /**
   * handles unassign Tub2 validation for a ExcIEEEST5B
   *
   * @param command UnAssignTub2FromExcIEEEST5BCommand
   */
  public void validate(UnAssignTub2FromExcIEEEST5BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTub2FromExcIEEEST5BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST5BId(),
        "UnAssignTub2FromExcIEEEST5BCommand identifier should not be null");
  }
  /**
   * handles assign Tuc1 validation for a ExcIEEEST5B
   *
   * @param command AssignTuc1ToExcIEEEST5BCommand
   */
  public void validate(AssignTuc1ToExcIEEEST5BCommand command) throws Exception {
    Assert.notNull(command, "AssignTuc1ToExcIEEEST5BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST5BId(), "AssignTuc1ToExcIEEEST5BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTuc1ToExcIEEEST5BCommand assignment should not be null");
  }

  /**
   * handles unassign Tuc1 validation for a ExcIEEEST5B
   *
   * @param command UnAssignTuc1FromExcIEEEST5BCommand
   */
  public void validate(UnAssignTuc1FromExcIEEEST5BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTuc1FromExcIEEEST5BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST5BId(),
        "UnAssignTuc1FromExcIEEEST5BCommand identifier should not be null");
  }
  /**
   * handles assign Tuc2 validation for a ExcIEEEST5B
   *
   * @param command AssignTuc2ToExcIEEEST5BCommand
   */
  public void validate(AssignTuc2ToExcIEEEST5BCommand command) throws Exception {
    Assert.notNull(command, "AssignTuc2ToExcIEEEST5BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST5BId(), "AssignTuc2ToExcIEEEST5BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignTuc2ToExcIEEEST5BCommand assignment should not be null");
  }

  /**
   * handles unassign Tuc2 validation for a ExcIEEEST5B
   *
   * @param command UnAssignTuc2FromExcIEEEST5BCommand
   */
  public void validate(UnAssignTuc2FromExcIEEEST5BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTuc2FromExcIEEEST5BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST5BId(),
        "UnAssignTuc2FromExcIEEEST5BCommand identifier should not be null");
  }
  /**
   * handles assign Vrmax validation for a ExcIEEEST5B
   *
   * @param command AssignVrmaxToExcIEEEST5BCommand
   */
  public void validate(AssignVrmaxToExcIEEEST5BCommand command) throws Exception {
    Assert.notNull(command, "AssignVrmaxToExcIEEEST5BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST5BId(),
        "AssignVrmaxToExcIEEEST5BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrmaxToExcIEEEST5BCommand assignment should not be null");
  }

  /**
   * handles unassign Vrmax validation for a ExcIEEEST5B
   *
   * @param command UnAssignVrmaxFromExcIEEEST5BCommand
   */
  public void validate(UnAssignVrmaxFromExcIEEEST5BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVrmaxFromExcIEEEST5BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST5BId(),
        "UnAssignVrmaxFromExcIEEEST5BCommand identifier should not be null");
  }
  /**
   * handles assign Vrmin validation for a ExcIEEEST5B
   *
   * @param command AssignVrminToExcIEEEST5BCommand
   */
  public void validate(AssignVrminToExcIEEEST5BCommand command) throws Exception {
    Assert.notNull(command, "AssignVrminToExcIEEEST5BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST5BId(),
        "AssignVrminToExcIEEEST5BCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignVrminToExcIEEEST5BCommand assignment should not be null");
  }

  /**
   * handles unassign Vrmin validation for a ExcIEEEST5B
   *
   * @param command UnAssignVrminFromExcIEEEST5BCommand
   */
  public void validate(UnAssignVrminFromExcIEEEST5BCommand command) throws Exception {
    Assert.notNull(command, "UnAssignVrminFromExcIEEEST5BCommand should not be null");
    Assert.notNull(
        command.getExcIEEEST5BId(),
        "UnAssignVrminFromExcIEEEST5BCommand identifier should not be null");
  }
}
