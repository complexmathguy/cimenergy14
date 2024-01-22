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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.equivalents.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class EquivalentBranchValidator {

  /** default constructor */
  protected EquivalentBranchValidator() {}

  /** factory method */
  public static EquivalentBranchValidator getInstance() {
    return new EquivalentBranchValidator();
  }

  /** handles creation validation for a EquivalentBranch */
  public void validate(CreateEquivalentBranchCommand equivalentBranch) throws Exception {
    Assert.notNull(equivalentBranch, "CreateEquivalentBranchCommand should not be null");
    //		Assert.isNull( equivalentBranch.getEquivalentBranchId(), "CreateEquivalentBranchCommand
    // identifier should be null" );
  }

  /** handles update validation for a EquivalentBranch */
  public void validate(UpdateEquivalentBranchCommand equivalentBranch) throws Exception {
    Assert.notNull(equivalentBranch, "UpdateEquivalentBranchCommand should not be null");
    Assert.notNull(
        equivalentBranch.getEquivalentBranchId(),
        "UpdateEquivalentBranchCommand identifier should not be null");
  }

  /** handles delete validation for a EquivalentBranch */
  public void validate(DeleteEquivalentBranchCommand equivalentBranch) throws Exception {
    Assert.notNull(equivalentBranch, "{commandAlias} should not be null");
    Assert.notNull(
        equivalentBranch.getEquivalentBranchId(),
        "DeleteEquivalentBranchCommand identifier should not be null");
  }

  /** handles fetchOne validation for a EquivalentBranch */
  public void validate(EquivalentBranchFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "EquivalentBranchFetchOneSummary should not be null");
    Assert.notNull(
        summary.getEquivalentBranchId(),
        "EquivalentBranchFetchOneSummary identifier should not be null");
  }

  /**
   * handles assign NegativeR12 validation for a EquivalentBranch
   *
   * @param command AssignNegativeR12ToEquivalentBranchCommand
   */
  public void validate(AssignNegativeR12ToEquivalentBranchCommand command) throws Exception {
    Assert.notNull(command, "AssignNegativeR12ToEquivalentBranchCommand should not be null");
    Assert.notNull(
        command.getEquivalentBranchId(),
        "AssignNegativeR12ToEquivalentBranchCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignNegativeR12ToEquivalentBranchCommand assignment should not be null");
  }

  /**
   * handles unassign NegativeR12 validation for a EquivalentBranch
   *
   * @param command UnAssignNegativeR12FromEquivalentBranchCommand
   */
  public void validate(UnAssignNegativeR12FromEquivalentBranchCommand command) throws Exception {
    Assert.notNull(command, "UnAssignNegativeR12FromEquivalentBranchCommand should not be null");
    Assert.notNull(
        command.getEquivalentBranchId(),
        "UnAssignNegativeR12FromEquivalentBranchCommand identifier should not be null");
  }
  /**
   * handles assign NegativeR21 validation for a EquivalentBranch
   *
   * @param command AssignNegativeR21ToEquivalentBranchCommand
   */
  public void validate(AssignNegativeR21ToEquivalentBranchCommand command) throws Exception {
    Assert.notNull(command, "AssignNegativeR21ToEquivalentBranchCommand should not be null");
    Assert.notNull(
        command.getEquivalentBranchId(),
        "AssignNegativeR21ToEquivalentBranchCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignNegativeR21ToEquivalentBranchCommand assignment should not be null");
  }

  /**
   * handles unassign NegativeR21 validation for a EquivalentBranch
   *
   * @param command UnAssignNegativeR21FromEquivalentBranchCommand
   */
  public void validate(UnAssignNegativeR21FromEquivalentBranchCommand command) throws Exception {
    Assert.notNull(command, "UnAssignNegativeR21FromEquivalentBranchCommand should not be null");
    Assert.notNull(
        command.getEquivalentBranchId(),
        "UnAssignNegativeR21FromEquivalentBranchCommand identifier should not be null");
  }
  /**
   * handles assign NegativeX12 validation for a EquivalentBranch
   *
   * @param command AssignNegativeX12ToEquivalentBranchCommand
   */
  public void validate(AssignNegativeX12ToEquivalentBranchCommand command) throws Exception {
    Assert.notNull(command, "AssignNegativeX12ToEquivalentBranchCommand should not be null");
    Assert.notNull(
        command.getEquivalentBranchId(),
        "AssignNegativeX12ToEquivalentBranchCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignNegativeX12ToEquivalentBranchCommand assignment should not be null");
  }

  /**
   * handles unassign NegativeX12 validation for a EquivalentBranch
   *
   * @param command UnAssignNegativeX12FromEquivalentBranchCommand
   */
  public void validate(UnAssignNegativeX12FromEquivalentBranchCommand command) throws Exception {
    Assert.notNull(command, "UnAssignNegativeX12FromEquivalentBranchCommand should not be null");
    Assert.notNull(
        command.getEquivalentBranchId(),
        "UnAssignNegativeX12FromEquivalentBranchCommand identifier should not be null");
  }
  /**
   * handles assign NegativeX21 validation for a EquivalentBranch
   *
   * @param command AssignNegativeX21ToEquivalentBranchCommand
   */
  public void validate(AssignNegativeX21ToEquivalentBranchCommand command) throws Exception {
    Assert.notNull(command, "AssignNegativeX21ToEquivalentBranchCommand should not be null");
    Assert.notNull(
        command.getEquivalentBranchId(),
        "AssignNegativeX21ToEquivalentBranchCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignNegativeX21ToEquivalentBranchCommand assignment should not be null");
  }

  /**
   * handles unassign NegativeX21 validation for a EquivalentBranch
   *
   * @param command UnAssignNegativeX21FromEquivalentBranchCommand
   */
  public void validate(UnAssignNegativeX21FromEquivalentBranchCommand command) throws Exception {
    Assert.notNull(command, "UnAssignNegativeX21FromEquivalentBranchCommand should not be null");
    Assert.notNull(
        command.getEquivalentBranchId(),
        "UnAssignNegativeX21FromEquivalentBranchCommand identifier should not be null");
  }
  /**
   * handles assign PositiveR12 validation for a EquivalentBranch
   *
   * @param command AssignPositiveR12ToEquivalentBranchCommand
   */
  public void validate(AssignPositiveR12ToEquivalentBranchCommand command) throws Exception {
    Assert.notNull(command, "AssignPositiveR12ToEquivalentBranchCommand should not be null");
    Assert.notNull(
        command.getEquivalentBranchId(),
        "AssignPositiveR12ToEquivalentBranchCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignPositiveR12ToEquivalentBranchCommand assignment should not be null");
  }

  /**
   * handles unassign PositiveR12 validation for a EquivalentBranch
   *
   * @param command UnAssignPositiveR12FromEquivalentBranchCommand
   */
  public void validate(UnAssignPositiveR12FromEquivalentBranchCommand command) throws Exception {
    Assert.notNull(command, "UnAssignPositiveR12FromEquivalentBranchCommand should not be null");
    Assert.notNull(
        command.getEquivalentBranchId(),
        "UnAssignPositiveR12FromEquivalentBranchCommand identifier should not be null");
  }
  /**
   * handles assign PositiveR21 validation for a EquivalentBranch
   *
   * @param command AssignPositiveR21ToEquivalentBranchCommand
   */
  public void validate(AssignPositiveR21ToEquivalentBranchCommand command) throws Exception {
    Assert.notNull(command, "AssignPositiveR21ToEquivalentBranchCommand should not be null");
    Assert.notNull(
        command.getEquivalentBranchId(),
        "AssignPositiveR21ToEquivalentBranchCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignPositiveR21ToEquivalentBranchCommand assignment should not be null");
  }

  /**
   * handles unassign PositiveR21 validation for a EquivalentBranch
   *
   * @param command UnAssignPositiveR21FromEquivalentBranchCommand
   */
  public void validate(UnAssignPositiveR21FromEquivalentBranchCommand command) throws Exception {
    Assert.notNull(command, "UnAssignPositiveR21FromEquivalentBranchCommand should not be null");
    Assert.notNull(
        command.getEquivalentBranchId(),
        "UnAssignPositiveR21FromEquivalentBranchCommand identifier should not be null");
  }
  /**
   * handles assign PositiveX12 validation for a EquivalentBranch
   *
   * @param command AssignPositiveX12ToEquivalentBranchCommand
   */
  public void validate(AssignPositiveX12ToEquivalentBranchCommand command) throws Exception {
    Assert.notNull(command, "AssignPositiveX12ToEquivalentBranchCommand should not be null");
    Assert.notNull(
        command.getEquivalentBranchId(),
        "AssignPositiveX12ToEquivalentBranchCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignPositiveX12ToEquivalentBranchCommand assignment should not be null");
  }

  /**
   * handles unassign PositiveX12 validation for a EquivalentBranch
   *
   * @param command UnAssignPositiveX12FromEquivalentBranchCommand
   */
  public void validate(UnAssignPositiveX12FromEquivalentBranchCommand command) throws Exception {
    Assert.notNull(command, "UnAssignPositiveX12FromEquivalentBranchCommand should not be null");
    Assert.notNull(
        command.getEquivalentBranchId(),
        "UnAssignPositiveX12FromEquivalentBranchCommand identifier should not be null");
  }
  /**
   * handles assign PositiveX21 validation for a EquivalentBranch
   *
   * @param command AssignPositiveX21ToEquivalentBranchCommand
   */
  public void validate(AssignPositiveX21ToEquivalentBranchCommand command) throws Exception {
    Assert.notNull(command, "AssignPositiveX21ToEquivalentBranchCommand should not be null");
    Assert.notNull(
        command.getEquivalentBranchId(),
        "AssignPositiveX21ToEquivalentBranchCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignPositiveX21ToEquivalentBranchCommand assignment should not be null");
  }

  /**
   * handles unassign PositiveX21 validation for a EquivalentBranch
   *
   * @param command UnAssignPositiveX21FromEquivalentBranchCommand
   */
  public void validate(UnAssignPositiveX21FromEquivalentBranchCommand command) throws Exception {
    Assert.notNull(command, "UnAssignPositiveX21FromEquivalentBranchCommand should not be null");
    Assert.notNull(
        command.getEquivalentBranchId(),
        "UnAssignPositiveX21FromEquivalentBranchCommand identifier should not be null");
  }
  /**
   * handles assign R validation for a EquivalentBranch
   *
   * @param command AssignRToEquivalentBranchCommand
   */
  public void validate(AssignRToEquivalentBranchCommand command) throws Exception {
    Assert.notNull(command, "AssignRToEquivalentBranchCommand should not be null");
    Assert.notNull(
        command.getEquivalentBranchId(),
        "AssignRToEquivalentBranchCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignRToEquivalentBranchCommand assignment should not be null");
  }

  /**
   * handles unassign R validation for a EquivalentBranch
   *
   * @param command UnAssignRFromEquivalentBranchCommand
   */
  public void validate(UnAssignRFromEquivalentBranchCommand command) throws Exception {
    Assert.notNull(command, "UnAssignRFromEquivalentBranchCommand should not be null");
    Assert.notNull(
        command.getEquivalentBranchId(),
        "UnAssignRFromEquivalentBranchCommand identifier should not be null");
  }
  /**
   * handles assign R21 validation for a EquivalentBranch
   *
   * @param command AssignR21ToEquivalentBranchCommand
   */
  public void validate(AssignR21ToEquivalentBranchCommand command) throws Exception {
    Assert.notNull(command, "AssignR21ToEquivalentBranchCommand should not be null");
    Assert.notNull(
        command.getEquivalentBranchId(),
        "AssignR21ToEquivalentBranchCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignR21ToEquivalentBranchCommand assignment should not be null");
  }

  /**
   * handles unassign R21 validation for a EquivalentBranch
   *
   * @param command UnAssignR21FromEquivalentBranchCommand
   */
  public void validate(UnAssignR21FromEquivalentBranchCommand command) throws Exception {
    Assert.notNull(command, "UnAssignR21FromEquivalentBranchCommand should not be null");
    Assert.notNull(
        command.getEquivalentBranchId(),
        "UnAssignR21FromEquivalentBranchCommand identifier should not be null");
  }
  /**
   * handles assign X validation for a EquivalentBranch
   *
   * @param command AssignXToEquivalentBranchCommand
   */
  public void validate(AssignXToEquivalentBranchCommand command) throws Exception {
    Assert.notNull(command, "AssignXToEquivalentBranchCommand should not be null");
    Assert.notNull(
        command.getEquivalentBranchId(),
        "AssignXToEquivalentBranchCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(), "AssignXToEquivalentBranchCommand assignment should not be null");
  }

  /**
   * handles unassign X validation for a EquivalentBranch
   *
   * @param command UnAssignXFromEquivalentBranchCommand
   */
  public void validate(UnAssignXFromEquivalentBranchCommand command) throws Exception {
    Assert.notNull(command, "UnAssignXFromEquivalentBranchCommand should not be null");
    Assert.notNull(
        command.getEquivalentBranchId(),
        "UnAssignXFromEquivalentBranchCommand identifier should not be null");
  }
  /**
   * handles assign X21 validation for a EquivalentBranch
   *
   * @param command AssignX21ToEquivalentBranchCommand
   */
  public void validate(AssignX21ToEquivalentBranchCommand command) throws Exception {
    Assert.notNull(command, "AssignX21ToEquivalentBranchCommand should not be null");
    Assert.notNull(
        command.getEquivalentBranchId(),
        "AssignX21ToEquivalentBranchCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignX21ToEquivalentBranchCommand assignment should not be null");
  }

  /**
   * handles unassign X21 validation for a EquivalentBranch
   *
   * @param command UnAssignX21FromEquivalentBranchCommand
   */
  public void validate(UnAssignX21FromEquivalentBranchCommand command) throws Exception {
    Assert.notNull(command, "UnAssignX21FromEquivalentBranchCommand should not be null");
    Assert.notNull(
        command.getEquivalentBranchId(),
        "UnAssignX21FromEquivalentBranchCommand identifier should not be null");
  }
  /**
   * handles assign ZeroR12 validation for a EquivalentBranch
   *
   * @param command AssignZeroR12ToEquivalentBranchCommand
   */
  public void validate(AssignZeroR12ToEquivalentBranchCommand command) throws Exception {
    Assert.notNull(command, "AssignZeroR12ToEquivalentBranchCommand should not be null");
    Assert.notNull(
        command.getEquivalentBranchId(),
        "AssignZeroR12ToEquivalentBranchCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignZeroR12ToEquivalentBranchCommand assignment should not be null");
  }

  /**
   * handles unassign ZeroR12 validation for a EquivalentBranch
   *
   * @param command UnAssignZeroR12FromEquivalentBranchCommand
   */
  public void validate(UnAssignZeroR12FromEquivalentBranchCommand command) throws Exception {
    Assert.notNull(command, "UnAssignZeroR12FromEquivalentBranchCommand should not be null");
    Assert.notNull(
        command.getEquivalentBranchId(),
        "UnAssignZeroR12FromEquivalentBranchCommand identifier should not be null");
  }
  /**
   * handles assign ZeroR21 validation for a EquivalentBranch
   *
   * @param command AssignZeroR21ToEquivalentBranchCommand
   */
  public void validate(AssignZeroR21ToEquivalentBranchCommand command) throws Exception {
    Assert.notNull(command, "AssignZeroR21ToEquivalentBranchCommand should not be null");
    Assert.notNull(
        command.getEquivalentBranchId(),
        "AssignZeroR21ToEquivalentBranchCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignZeroR21ToEquivalentBranchCommand assignment should not be null");
  }

  /**
   * handles unassign ZeroR21 validation for a EquivalentBranch
   *
   * @param command UnAssignZeroR21FromEquivalentBranchCommand
   */
  public void validate(UnAssignZeroR21FromEquivalentBranchCommand command) throws Exception {
    Assert.notNull(command, "UnAssignZeroR21FromEquivalentBranchCommand should not be null");
    Assert.notNull(
        command.getEquivalentBranchId(),
        "UnAssignZeroR21FromEquivalentBranchCommand identifier should not be null");
  }
  /**
   * handles assign ZeroX12 validation for a EquivalentBranch
   *
   * @param command AssignZeroX12ToEquivalentBranchCommand
   */
  public void validate(AssignZeroX12ToEquivalentBranchCommand command) throws Exception {
    Assert.notNull(command, "AssignZeroX12ToEquivalentBranchCommand should not be null");
    Assert.notNull(
        command.getEquivalentBranchId(),
        "AssignZeroX12ToEquivalentBranchCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignZeroX12ToEquivalentBranchCommand assignment should not be null");
  }

  /**
   * handles unassign ZeroX12 validation for a EquivalentBranch
   *
   * @param command UnAssignZeroX12FromEquivalentBranchCommand
   */
  public void validate(UnAssignZeroX12FromEquivalentBranchCommand command) throws Exception {
    Assert.notNull(command, "UnAssignZeroX12FromEquivalentBranchCommand should not be null");
    Assert.notNull(
        command.getEquivalentBranchId(),
        "UnAssignZeroX12FromEquivalentBranchCommand identifier should not be null");
  }
  /**
   * handles assign ZeroX21 validation for a EquivalentBranch
   *
   * @param command AssignZeroX21ToEquivalentBranchCommand
   */
  public void validate(AssignZeroX21ToEquivalentBranchCommand command) throws Exception {
    Assert.notNull(command, "AssignZeroX21ToEquivalentBranchCommand should not be null");
    Assert.notNull(
        command.getEquivalentBranchId(),
        "AssignZeroX21ToEquivalentBranchCommand identifier should not be null");
    Assert.notNull(
        command.getAssignment(),
        "AssignZeroX21ToEquivalentBranchCommand assignment should not be null");
  }

  /**
   * handles unassign ZeroX21 validation for a EquivalentBranch
   *
   * @param command UnAssignZeroX21FromEquivalentBranchCommand
   */
  public void validate(UnAssignZeroX21FromEquivalentBranchCommand command) throws Exception {
    Assert.notNull(command, "UnAssignZeroX21FromEquivalentBranchCommand should not be null");
    Assert.notNull(
        command.getEquivalentBranchId(),
        "UnAssignZeroX21FromEquivalentBranchCommand identifier should not be null");
  }
}
