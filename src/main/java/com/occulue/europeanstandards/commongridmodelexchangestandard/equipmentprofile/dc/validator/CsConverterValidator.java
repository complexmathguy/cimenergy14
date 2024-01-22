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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class CsConverterValidator {

  /** default constructor */
  protected CsConverterValidator() {}

  /** factory method */
  public static CsConverterValidator getInstance() {
    return new CsConverterValidator();
  }

  /** handles creation validation for a CsConverter */
  public void validate(CreateCsConverterCommand csConverter) throws Exception {
    Assert.notNull(csConverter, "CreateCsConverterCommand should not be null");
    //		Assert.isNull( csConverter.getCsConverterId(), "CreateCsConverterCommand identifier should
    // be null" );
  }

  /** handles update validation for a CsConverter */
  public void validate(UpdateCsConverterCommand csConverter) throws Exception {
    Assert.notNull(csConverter, "UpdateCsConverterCommand should not be null");
    Assert.notNull(
        csConverter.getCsConverterId(), "UpdateCsConverterCommand identifier should not be null");
  }

  /** handles delete validation for a CsConverter */
  public void validate(DeleteCsConverterCommand csConverter) throws Exception {
    Assert.notNull(csConverter, "{commandAlias} should not be null");
    Assert.notNull(
        csConverter.getCsConverterId(), "DeleteCsConverterCommand identifier should not be null");
  }

  /** handles fetchOne validation for a CsConverter */
  public void validate(CsConverterFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "CsConverterFetchOneSummary should not be null");
    Assert.notNull(
        summary.getCsConverterId(), "CsConverterFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign MaxAlpha validation for a CsConverter
   *
   * @param command AssignMaxAlphaToCsConverterCommand
   */
  public void validate(AssignMaxAlphaToCsConverterCommand command) throws Exception {
    Assert.notNull(command, "AssignMaxAlphaToCsConverterCommand should not be null");
    Assert.notNull(
        command.getCsConverterId(),
        "AssignMaxAlphaToCsConverterCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignMaxAlphaToCsConverterCommand assignment should not be null");
  }

  /**
   * handles unassign MaxAlpha validation for a CsConverter
   *
   * @param command UnAssignMaxAlphaFromCsConverterCommand
   */
  public void validate(UnAssignMaxAlphaFromCsConverterCommand command) throws Exception {
    Assert.notNull(command, "UnAssignMaxAlphaFromCsConverterCommand should not be null");
    Assert.notNull(
        command.getCsConverterId(),
        "UnAssignMaxAlphaFromCsConverterCommand identifier should not be null");
  }
  /**
   * handles assign MaxGamma validation for a CsConverter
   *
   * @param command AssignMaxGammaToCsConverterCommand
   */
  public void validate(AssignMaxGammaToCsConverterCommand command) throws Exception {
    Assert.notNull(command, "AssignMaxGammaToCsConverterCommand should not be null");
    Assert.notNull(
        command.getCsConverterId(),
        "AssignMaxGammaToCsConverterCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignMaxGammaToCsConverterCommand assignment should not be null");
  }

  /**
   * handles unassign MaxGamma validation for a CsConverter
   *
   * @param command UnAssignMaxGammaFromCsConverterCommand
   */
  public void validate(UnAssignMaxGammaFromCsConverterCommand command) throws Exception {
    Assert.notNull(command, "UnAssignMaxGammaFromCsConverterCommand should not be null");
    Assert.notNull(
        command.getCsConverterId(),
        "UnAssignMaxGammaFromCsConverterCommand identifier should not be null");
  }
  /**
   * handles assign MaxIdc validation for a CsConverter
   *
   * @param command AssignMaxIdcToCsConverterCommand
   */
  public void validate(AssignMaxIdcToCsConverterCommand command) throws Exception {
    Assert.notNull(command, "AssignMaxIdcToCsConverterCommand should not be null");
    Assert.notNull(
        command.getCsConverterId(),
        "AssignMaxIdcToCsConverterCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignMaxIdcToCsConverterCommand assignment should not be null");
  }

  /**
   * handles unassign MaxIdc validation for a CsConverter
   *
   * @param command UnAssignMaxIdcFromCsConverterCommand
   */
  public void validate(UnAssignMaxIdcFromCsConverterCommand command) throws Exception {
    Assert.notNull(command, "UnAssignMaxIdcFromCsConverterCommand should not be null");
    Assert.notNull(
        command.getCsConverterId(),
        "UnAssignMaxIdcFromCsConverterCommand identifier should not be null");
  }
  /**
   * handles assign MinAlpha validation for a CsConverter
   *
   * @param command AssignMinAlphaToCsConverterCommand
   */
  public void validate(AssignMinAlphaToCsConverterCommand command) throws Exception {
    Assert.notNull(command, "AssignMinAlphaToCsConverterCommand should not be null");
    Assert.notNull(
        command.getCsConverterId(),
        "AssignMinAlphaToCsConverterCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignMinAlphaToCsConverterCommand assignment should not be null");
  }

  /**
   * handles unassign MinAlpha validation for a CsConverter
   *
   * @param command UnAssignMinAlphaFromCsConverterCommand
   */
  public void validate(UnAssignMinAlphaFromCsConverterCommand command) throws Exception {
    Assert.notNull(command, "UnAssignMinAlphaFromCsConverterCommand should not be null");
    Assert.notNull(
        command.getCsConverterId(),
        "UnAssignMinAlphaFromCsConverterCommand identifier should not be null");
  }
  /**
   * handles assign MinGamma validation for a CsConverter
   *
   * @param command AssignMinGammaToCsConverterCommand
   */
  public void validate(AssignMinGammaToCsConverterCommand command) throws Exception {
    Assert.notNull(command, "AssignMinGammaToCsConverterCommand should not be null");
    Assert.notNull(
        command.getCsConverterId(),
        "AssignMinGammaToCsConverterCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignMinGammaToCsConverterCommand assignment should not be null");
  }

  /**
   * handles unassign MinGamma validation for a CsConverter
   *
   * @param command UnAssignMinGammaFromCsConverterCommand
   */
  public void validate(UnAssignMinGammaFromCsConverterCommand command) throws Exception {
    Assert.notNull(command, "UnAssignMinGammaFromCsConverterCommand should not be null");
    Assert.notNull(
        command.getCsConverterId(),
        "UnAssignMinGammaFromCsConverterCommand identifier should not be null");
  }
  /**
   * handles assign MinIdc validation for a CsConverter
   *
   * @param command AssignMinIdcToCsConverterCommand
   */
  public void validate(AssignMinIdcToCsConverterCommand command) throws Exception {
    Assert.notNull(command, "AssignMinIdcToCsConverterCommand should not be null");
    Assert.notNull(
        command.getCsConverterId(),
        "AssignMinIdcToCsConverterCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignMinIdcToCsConverterCommand assignment should not be null");
  }

  /**
   * handles unassign MinIdc validation for a CsConverter
   *
   * @param command UnAssignMinIdcFromCsConverterCommand
   */
  public void validate(UnAssignMinIdcFromCsConverterCommand command) throws Exception {
    Assert.notNull(command, "UnAssignMinIdcFromCsConverterCommand should not be null");
    Assert.notNull(
        command.getCsConverterId(),
        "UnAssignMinIdcFromCsConverterCommand identifier should not be null");
  }
  /**
   * handles assign RatedIdc validation for a CsConverter
   *
   * @param command AssignRatedIdcToCsConverterCommand
   */
  public void validate(AssignRatedIdcToCsConverterCommand command) throws Exception {
    Assert.notNull(command, "AssignRatedIdcToCsConverterCommand should not be null");
    Assert.notNull(
        command.getCsConverterId(),
        "AssignRatedIdcToCsConverterCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignRatedIdcToCsConverterCommand assignment should not be null");
  }

  /**
   * handles unassign RatedIdc validation for a CsConverter
   *
   * @param command UnAssignRatedIdcFromCsConverterCommand
   */
  public void validate(UnAssignRatedIdcFromCsConverterCommand command) throws Exception {
    Assert.notNull(command, "UnAssignRatedIdcFromCsConverterCommand should not be null");
    Assert.notNull(
        command.getCsConverterId(),
        "UnAssignRatedIdcFromCsConverterCommand identifier should not be null");
  }
}
