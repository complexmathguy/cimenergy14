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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.synchronousmachinedynamics.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class SynchronousMachineSimplifiedValidator {

  /** default constructor */
  protected SynchronousMachineSimplifiedValidator() {}

  /** factory method */
  public static SynchronousMachineSimplifiedValidator getInstance() {
    return new SynchronousMachineSimplifiedValidator();
  }

  /** handles creation validation for a SynchronousMachineSimplified */
  public void validate(CreateSynchronousMachineSimplifiedCommand synchronousMachineSimplified)
      throws Exception {
    Assert.notNull(
        synchronousMachineSimplified,
        "CreateSynchronousMachineSimplifiedCommand should not be null");
    //		Assert.isNull( synchronousMachineSimplified.getSynchronousMachineSimplifiedId(),
    // "CreateSynchronousMachineSimplifiedCommand identifier should be null" );
  }

  /** handles update validation for a SynchronousMachineSimplified */
  public void validate(UpdateSynchronousMachineSimplifiedCommand synchronousMachineSimplified)
      throws Exception {
    Assert.notNull(
        synchronousMachineSimplified,
        "UpdateSynchronousMachineSimplifiedCommand should not be null");
    Assert.notNull(
        synchronousMachineSimplified.getSynchronousMachineSimplifiedId(),
        "UpdateSynchronousMachineSimplifiedCommand identifier should not be null");
  }

  /** handles delete validation for a SynchronousMachineSimplified */
  public void validate(DeleteSynchronousMachineSimplifiedCommand synchronousMachineSimplified)
      throws Exception {
    Assert.notNull(synchronousMachineSimplified, "{commandAlias} should not be null");
    Assert.notNull(
        synchronousMachineSimplified.getSynchronousMachineSimplifiedId(),
        "DeleteSynchronousMachineSimplifiedCommand identifier should not be null");
  }

  /** handles fetchOne validation for a SynchronousMachineSimplified */
  public void validate(SynchronousMachineSimplifiedFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "SynchronousMachineSimplifiedFetchOneSummary should not be null");
    Assert.notNull(
        summary.getSynchronousMachineSimplifiedId(),
        "SynchronousMachineSimplifiedFetchOneSummary identifier should not be null");
  }
}
