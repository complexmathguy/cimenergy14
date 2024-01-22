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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.winddynamics.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class WindContPType3IECValidator {

  /** default constructor */
  protected WindContPType3IECValidator() {}

  /** factory method */
  public static WindContPType3IECValidator getInstance() {
    return new WindContPType3IECValidator();
  }

  /** handles creation validation for a WindContPType3IEC */
  public void validate(CreateWindContPType3IECCommand windContPType3IEC) throws Exception {
    Assert.notNull(windContPType3IEC, "CreateWindContPType3IECCommand should not be null");
    //		Assert.isNull( windContPType3IEC.getWindContPType3IECId(), "CreateWindContPType3IECCommand
    // identifier should be null" );
  }

  /** handles update validation for a WindContPType3IEC */
  public void validate(UpdateWindContPType3IECCommand windContPType3IEC) throws Exception {
    Assert.notNull(windContPType3IEC, "UpdateWindContPType3IECCommand should not be null");
    Assert.notNull(
        windContPType3IEC.getWindContPType3IECId(),
        "UpdateWindContPType3IECCommand identifier should not be null");
  }

  /** handles delete validation for a WindContPType3IEC */
  public void validate(DeleteWindContPType3IECCommand windContPType3IEC) throws Exception {
    Assert.notNull(windContPType3IEC, "{commandAlias} should not be null");
    Assert.notNull(
        windContPType3IEC.getWindContPType3IECId(),
        "DeleteWindContPType3IECCommand identifier should not be null");
  }

  /** handles fetchOne validation for a WindContPType3IEC */
  public void validate(WindContPType3IECFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "WindContPType3IECFetchOneSummary should not be null");
    Assert.notNull(
        summary.getWindContPType3IECId(),
        "WindContPType3IECFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign Dpmax validation for a WindContPType3IEC
   *
   * @param command AssignDpmaxToWindContPType3IECCommand
   */
  public void validate(AssignDpmaxToWindContPType3IECCommand command) throws Exception {
    Assert.notNull(command, "AssignDpmaxToWindContPType3IECCommand should not be null");
    Assert.notNull(
        command.getWindContPType3IECId(),
        "AssignDpmaxToWindContPType3IECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignDpmaxToWindContPType3IECCommand assignment should not be null");
  }

  /**
   * handles unassign Dpmax validation for a WindContPType3IEC
   *
   * @param command UnAssignDpmaxFromWindContPType3IECCommand
   */
  public void validate(UnAssignDpmaxFromWindContPType3IECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignDpmaxFromWindContPType3IECCommand should not be null");
    Assert.notNull(
        command.getWindContPType3IECId(),
        "UnAssignDpmaxFromWindContPType3IECCommand identifier should not be null");
  }
  /**
   * handles assign Dtrisemaxlvrt validation for a WindContPType3IEC
   *
   * @param command AssignDtrisemaxlvrtToWindContPType3IECCommand
   */
  public void validate(AssignDtrisemaxlvrtToWindContPType3IECCommand command) throws Exception {
    Assert.notNull(command, "AssignDtrisemaxlvrtToWindContPType3IECCommand should not be null");
    Assert.notNull(
        command.getWindContPType3IECId(),
        "AssignDtrisemaxlvrtToWindContPType3IECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignDtrisemaxlvrtToWindContPType3IECCommand assignment should not be null");
  }

  /**
   * handles unassign Dtrisemaxlvrt validation for a WindContPType3IEC
   *
   * @param command UnAssignDtrisemaxlvrtFromWindContPType3IECCommand
   */
  public void validate(UnAssignDtrisemaxlvrtFromWindContPType3IECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignDtrisemaxlvrtFromWindContPType3IECCommand should not be null");
    Assert.notNull(
        command.getWindContPType3IECId(),
        "UnAssignDtrisemaxlvrtFromWindContPType3IECCommand identifier should not be null");
  }
  /**
   * handles assign Kdtd validation for a WindContPType3IEC
   *
   * @param command AssignKdtdToWindContPType3IECCommand
   */
  public void validate(AssignKdtdToWindContPType3IECCommand command) throws Exception {
    Assert.notNull(command, "AssignKdtdToWindContPType3IECCommand should not be null");
    Assert.notNull(
        command.getWindContPType3IECId(),
        "AssignKdtdToWindContPType3IECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignKdtdToWindContPType3IECCommand assignment should not be null");
  }

  /**
   * handles unassign Kdtd validation for a WindContPType3IEC
   *
   * @param command UnAssignKdtdFromWindContPType3IECCommand
   */
  public void validate(UnAssignKdtdFromWindContPType3IECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKdtdFromWindContPType3IECCommand should not be null");
    Assert.notNull(
        command.getWindContPType3IECId(),
        "UnAssignKdtdFromWindContPType3IECCommand identifier should not be null");
  }
  /**
   * handles assign Kip validation for a WindContPType3IEC
   *
   * @param command AssignKipToWindContPType3IECCommand
   */
  public void validate(AssignKipToWindContPType3IECCommand command) throws Exception {
    Assert.notNull(command, "AssignKipToWindContPType3IECCommand should not be null");
    Assert.notNull(
        command.getWindContPType3IECId(),
        "AssignKipToWindContPType3IECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignKipToWindContPType3IECCommand assignment should not be null");
  }

  /**
   * handles unassign Kip validation for a WindContPType3IEC
   *
   * @param command UnAssignKipFromWindContPType3IECCommand
   */
  public void validate(UnAssignKipFromWindContPType3IECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKipFromWindContPType3IECCommand should not be null");
    Assert.notNull(
        command.getWindContPType3IECId(),
        "UnAssignKipFromWindContPType3IECCommand identifier should not be null");
  }
  /**
   * handles assign Kpp validation for a WindContPType3IEC
   *
   * @param command AssignKppToWindContPType3IECCommand
   */
  public void validate(AssignKppToWindContPType3IECCommand command) throws Exception {
    Assert.notNull(command, "AssignKppToWindContPType3IECCommand should not be null");
    Assert.notNull(
        command.getWindContPType3IECId(),
        "AssignKppToWindContPType3IECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignKppToWindContPType3IECCommand assignment should not be null");
  }

  /**
   * handles unassign Kpp validation for a WindContPType3IEC
   *
   * @param command UnAssignKppFromWindContPType3IECCommand
   */
  public void validate(UnAssignKppFromWindContPType3IECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignKppFromWindContPType3IECCommand should not be null");
    Assert.notNull(
        command.getWindContPType3IECId(),
        "UnAssignKppFromWindContPType3IECCommand identifier should not be null");
  }
  /**
   * handles assign Mplvrt validation for a WindContPType3IEC
   *
   * @param command AssignMplvrtToWindContPType3IECCommand
   */
  public void validate(AssignMplvrtToWindContPType3IECCommand command) throws Exception {
    Assert.notNull(command, "AssignMplvrtToWindContPType3IECCommand should not be null");
    Assert.notNull(
        command.getWindContPType3IECId(),
        "AssignMplvrtToWindContPType3IECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignMplvrtToWindContPType3IECCommand assignment should not be null");
  }

  /**
   * handles unassign Mplvrt validation for a WindContPType3IEC
   *
   * @param command UnAssignMplvrtFromWindContPType3IECCommand
   */
  public void validate(UnAssignMplvrtFromWindContPType3IECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignMplvrtFromWindContPType3IECCommand should not be null");
    Assert.notNull(
        command.getWindContPType3IECId(),
        "UnAssignMplvrtFromWindContPType3IECCommand identifier should not be null");
  }
  /**
   * handles assign Omegaoffset validation for a WindContPType3IEC
   *
   * @param command AssignOmegaoffsetToWindContPType3IECCommand
   */
  public void validate(AssignOmegaoffsetToWindContPType3IECCommand command) throws Exception {
    Assert.notNull(command, "AssignOmegaoffsetToWindContPType3IECCommand should not be null");
    Assert.notNull(
        command.getWindContPType3IECId(),
        "AssignOmegaoffsetToWindContPType3IECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignOmegaoffsetToWindContPType3IECCommand assignment should not be null");
  }

  /**
   * handles unassign Omegaoffset validation for a WindContPType3IEC
   *
   * @param command UnAssignOmegaoffsetFromWindContPType3IECCommand
   */
  public void validate(UnAssignOmegaoffsetFromWindContPType3IECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignOmegaoffsetFromWindContPType3IECCommand should not be null");
    Assert.notNull(
        command.getWindContPType3IECId(),
        "UnAssignOmegaoffsetFromWindContPType3IECCommand identifier should not be null");
  }
  /**
   * handles assign Pdtdmax validation for a WindContPType3IEC
   *
   * @param command AssignPdtdmaxToWindContPType3IECCommand
   */
  public void validate(AssignPdtdmaxToWindContPType3IECCommand command) throws Exception {
    Assert.notNull(command, "AssignPdtdmaxToWindContPType3IECCommand should not be null");
    Assert.notNull(
        command.getWindContPType3IECId(),
        "AssignPdtdmaxToWindContPType3IECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignPdtdmaxToWindContPType3IECCommand assignment should not be null");
  }

  /**
   * handles unassign Pdtdmax validation for a WindContPType3IEC
   *
   * @param command UnAssignPdtdmaxFromWindContPType3IECCommand
   */
  public void validate(UnAssignPdtdmaxFromWindContPType3IECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignPdtdmaxFromWindContPType3IECCommand should not be null");
    Assert.notNull(
        command.getWindContPType3IECId(),
        "UnAssignPdtdmaxFromWindContPType3IECCommand identifier should not be null");
  }
  /**
   * handles assign Rramp validation for a WindContPType3IEC
   *
   * @param command AssignRrampToWindContPType3IECCommand
   */
  public void validate(AssignRrampToWindContPType3IECCommand command) throws Exception {
    Assert.notNull(command, "AssignRrampToWindContPType3IECCommand should not be null");
    Assert.notNull(
        command.getWindContPType3IECId(),
        "AssignRrampToWindContPType3IECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignRrampToWindContPType3IECCommand assignment should not be null");
  }

  /**
   * handles unassign Rramp validation for a WindContPType3IEC
   *
   * @param command UnAssignRrampFromWindContPType3IECCommand
   */
  public void validate(UnAssignRrampFromWindContPType3IECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignRrampFromWindContPType3IECCommand should not be null");
    Assert.notNull(
        command.getWindContPType3IECId(),
        "UnAssignRrampFromWindContPType3IECCommand identifier should not be null");
  }
  /**
   * handles assign Tdvs validation for a WindContPType3IEC
   *
   * @param command AssignTdvsToWindContPType3IECCommand
   */
  public void validate(AssignTdvsToWindContPType3IECCommand command) throws Exception {
    Assert.notNull(command, "AssignTdvsToWindContPType3IECCommand should not be null");
    Assert.notNull(
        command.getWindContPType3IECId(),
        "AssignTdvsToWindContPType3IECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignTdvsToWindContPType3IECCommand assignment should not be null");
  }

  /**
   * handles unassign Tdvs validation for a WindContPType3IEC
   *
   * @param command UnAssignTdvsFromWindContPType3IECCommand
   */
  public void validate(UnAssignTdvsFromWindContPType3IECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTdvsFromWindContPType3IECCommand should not be null");
    Assert.notNull(
        command.getWindContPType3IECId(),
        "UnAssignTdvsFromWindContPType3IECCommand identifier should not be null");
  }
  /**
   * handles assign Temin validation for a WindContPType3IEC
   *
   * @param command AssignTeminToWindContPType3IECCommand
   */
  public void validate(AssignTeminToWindContPType3IECCommand command) throws Exception {
    Assert.notNull(command, "AssignTeminToWindContPType3IECCommand should not be null");
    Assert.notNull(
        command.getWindContPType3IECId(),
        "AssignTeminToWindContPType3IECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignTeminToWindContPType3IECCommand assignment should not be null");
  }

  /**
   * handles unassign Temin validation for a WindContPType3IEC
   *
   * @param command UnAssignTeminFromWindContPType3IECCommand
   */
  public void validate(UnAssignTeminFromWindContPType3IECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTeminFromWindContPType3IECCommand should not be null");
    Assert.notNull(
        command.getWindContPType3IECId(),
        "UnAssignTeminFromWindContPType3IECCommand identifier should not be null");
  }
  /**
   * handles assign Tomegafilt validation for a WindContPType3IEC
   *
   * @param command AssignTomegafiltToWindContPType3IECCommand
   */
  public void validate(AssignTomegafiltToWindContPType3IECCommand command) throws Exception {
    Assert.notNull(command, "AssignTomegafiltToWindContPType3IECCommand should not be null");
    Assert.notNull(
        command.getWindContPType3IECId(),
        "AssignTomegafiltToWindContPType3IECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignTomegafiltToWindContPType3IECCommand assignment should not be null");
  }

  /**
   * handles unassign Tomegafilt validation for a WindContPType3IEC
   *
   * @param command UnAssignTomegafiltFromWindContPType3IECCommand
   */
  public void validate(UnAssignTomegafiltFromWindContPType3IECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTomegafiltFromWindContPType3IECCommand should not be null");
    Assert.notNull(
        command.getWindContPType3IECId(),
        "UnAssignTomegafiltFromWindContPType3IECCommand identifier should not be null");
  }
  /**
   * handles assign Tpfilt validation for a WindContPType3IEC
   *
   * @param command AssignTpfiltToWindContPType3IECCommand
   */
  public void validate(AssignTpfiltToWindContPType3IECCommand command) throws Exception {
    Assert.notNull(command, "AssignTpfiltToWindContPType3IECCommand should not be null");
    Assert.notNull(
        command.getWindContPType3IECId(),
        "AssignTpfiltToWindContPType3IECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignTpfiltToWindContPType3IECCommand assignment should not be null");
  }

  /**
   * handles unassign Tpfilt validation for a WindContPType3IEC
   *
   * @param command UnAssignTpfiltFromWindContPType3IECCommand
   */
  public void validate(UnAssignTpfiltFromWindContPType3IECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTpfiltFromWindContPType3IECCommand should not be null");
    Assert.notNull(
        command.getWindContPType3IECId(),
        "UnAssignTpfiltFromWindContPType3IECCommand identifier should not be null");
  }
  /**
   * handles assign Tpord validation for a WindContPType3IEC
   *
   * @param command AssignTpordToWindContPType3IECCommand
   */
  public void validate(AssignTpordToWindContPType3IECCommand command) throws Exception {
    Assert.notNull(command, "AssignTpordToWindContPType3IECCommand should not be null");
    Assert.notNull(
        command.getWindContPType3IECId(),
        "AssignTpordToWindContPType3IECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignTpordToWindContPType3IECCommand assignment should not be null");
  }

  /**
   * handles unassign Tpord validation for a WindContPType3IEC
   *
   * @param command UnAssignTpordFromWindContPType3IECCommand
   */
  public void validate(UnAssignTpordFromWindContPType3IECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTpordFromWindContPType3IECCommand should not be null");
    Assert.notNull(
        command.getWindContPType3IECId(),
        "UnAssignTpordFromWindContPType3IECCommand identifier should not be null");
  }
  /**
   * handles assign Tufilt validation for a WindContPType3IEC
   *
   * @param command AssignTufiltToWindContPType3IECCommand
   */
  public void validate(AssignTufiltToWindContPType3IECCommand command) throws Exception {
    Assert.notNull(command, "AssignTufiltToWindContPType3IECCommand should not be null");
    Assert.notNull(
        command.getWindContPType3IECId(),
        "AssignTufiltToWindContPType3IECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignTufiltToWindContPType3IECCommand assignment should not be null");
  }

  /**
   * handles unassign Tufilt validation for a WindContPType3IEC
   *
   * @param command UnAssignTufiltFromWindContPType3IECCommand
   */
  public void validate(UnAssignTufiltFromWindContPType3IECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTufiltFromWindContPType3IECCommand should not be null");
    Assert.notNull(
        command.getWindContPType3IECId(),
        "UnAssignTufiltFromWindContPType3IECCommand identifier should not be null");
  }
  /**
   * handles assign Tuscale validation for a WindContPType3IEC
   *
   * @param command AssignTuscaleToWindContPType3IECCommand
   */
  public void validate(AssignTuscaleToWindContPType3IECCommand command) throws Exception {
    Assert.notNull(command, "AssignTuscaleToWindContPType3IECCommand should not be null");
    Assert.notNull(
        command.getWindContPType3IECId(),
        "AssignTuscaleToWindContPType3IECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignTuscaleToWindContPType3IECCommand assignment should not be null");
  }

  /**
   * handles unassign Tuscale validation for a WindContPType3IEC
   *
   * @param command UnAssignTuscaleFromWindContPType3IECCommand
   */
  public void validate(UnAssignTuscaleFromWindContPType3IECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTuscaleFromWindContPType3IECCommand should not be null");
    Assert.notNull(
        command.getWindContPType3IECId(),
        "UnAssignTuscaleFromWindContPType3IECCommand identifier should not be null");
  }
  /**
   * handles assign Twref validation for a WindContPType3IEC
   *
   * @param command AssignTwrefToWindContPType3IECCommand
   */
  public void validate(AssignTwrefToWindContPType3IECCommand command) throws Exception {
    Assert.notNull(command, "AssignTwrefToWindContPType3IECCommand should not be null");
    Assert.notNull(
        command.getWindContPType3IECId(),
        "AssignTwrefToWindContPType3IECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignTwrefToWindContPType3IECCommand assignment should not be null");
  }

  /**
   * handles unassign Twref validation for a WindContPType3IEC
   *
   * @param command UnAssignTwrefFromWindContPType3IECCommand
   */
  public void validate(UnAssignTwrefFromWindContPType3IECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignTwrefFromWindContPType3IECCommand should not be null");
    Assert.notNull(
        command.getWindContPType3IECId(),
        "UnAssignTwrefFromWindContPType3IECCommand identifier should not be null");
  }
  /**
   * handles assign Udvs validation for a WindContPType3IEC
   *
   * @param command AssignUdvsToWindContPType3IECCommand
   */
  public void validate(AssignUdvsToWindContPType3IECCommand command) throws Exception {
    Assert.notNull(command, "AssignUdvsToWindContPType3IECCommand should not be null");
    Assert.notNull(
        command.getWindContPType3IECId(),
        "AssignUdvsToWindContPType3IECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignUdvsToWindContPType3IECCommand assignment should not be null");
  }

  /**
   * handles unassign Udvs validation for a WindContPType3IEC
   *
   * @param command UnAssignUdvsFromWindContPType3IECCommand
   */
  public void validate(UnAssignUdvsFromWindContPType3IECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignUdvsFromWindContPType3IECCommand should not be null");
    Assert.notNull(
        command.getWindContPType3IECId(),
        "UnAssignUdvsFromWindContPType3IECCommand identifier should not be null");
  }
  /**
   * handles assign Updip validation for a WindContPType3IEC
   *
   * @param command AssignUpdipToWindContPType3IECCommand
   */
  public void validate(AssignUpdipToWindContPType3IECCommand command) throws Exception {
    Assert.notNull(command, "AssignUpdipToWindContPType3IECCommand should not be null");
    Assert.notNull(
        command.getWindContPType3IECId(),
        "AssignUpdipToWindContPType3IECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignUpdipToWindContPType3IECCommand assignment should not be null");
  }

  /**
   * handles unassign Updip validation for a WindContPType3IEC
   *
   * @param command UnAssignUpdipFromWindContPType3IECCommand
   */
  public void validate(UnAssignUpdipFromWindContPType3IECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignUpdipFromWindContPType3IECCommand should not be null");
    Assert.notNull(
        command.getWindContPType3IECId(),
        "UnAssignUpdipFromWindContPType3IECCommand identifier should not be null");
  }
  /**
   * handles assign Wdtd validation for a WindContPType3IEC
   *
   * @param command AssignWdtdToWindContPType3IECCommand
   */
  public void validate(AssignWdtdToWindContPType3IECCommand command) throws Exception {
    Assert.notNull(command, "AssignWdtdToWindContPType3IECCommand should not be null");
    Assert.notNull(
        command.getWindContPType3IECId(),
        "AssignWdtdToWindContPType3IECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignWdtdToWindContPType3IECCommand assignment should not be null");
  }

  /**
   * handles unassign Wdtd validation for a WindContPType3IEC
   *
   * @param command UnAssignWdtdFromWindContPType3IECCommand
   */
  public void validate(UnAssignWdtdFromWindContPType3IECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignWdtdFromWindContPType3IECCommand should not be null");
    Assert.notNull(
        command.getWindContPType3IECId(),
        "UnAssignWdtdFromWindContPType3IECCommand identifier should not be null");
  }
  /**
   * handles assign Zeta validation for a WindContPType3IEC
   *
   * @param command AssignZetaToWindContPType3IECCommand
   */
  public void validate(AssignZetaToWindContPType3IECCommand command) throws Exception {
    Assert.notNull(command, "AssignZetaToWindContPType3IECCommand should not be null");
    Assert.notNull(
        command.getWindContPType3IECId(),
        "AssignZetaToWindContPType3IECCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignZetaToWindContPType3IECCommand assignment should not be null");
  }

  /**
   * handles unassign Zeta validation for a WindContPType3IEC
   *
   * @param command UnAssignZetaFromWindContPType3IECCommand
   */
  public void validate(UnAssignZetaFromWindContPType3IECCommand command) throws Exception {
    Assert.notNull(command, "UnAssignZetaFromWindContPType3IECCommand should not be null");
    Assert.notNull(
        command.getWindContPType3IECId(),
        "UnAssignZetaFromWindContPType3IECCommand identifier should not be null");
  }
}
