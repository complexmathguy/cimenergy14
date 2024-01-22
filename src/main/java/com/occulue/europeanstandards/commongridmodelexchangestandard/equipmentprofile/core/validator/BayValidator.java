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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.core.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class BayValidator {

  /** default constructor */
  protected BayValidator() {}

  /** factory method */
  public static BayValidator getInstance() {
    return new BayValidator();
  }

  /** handles creation validation for a Bay */
  public void validate(CreateBayCommand bay) throws Exception {
    Assert.notNull(bay, "CreateBayCommand should not be null");
    //		Assert.isNull( bay.getBayId(), "CreateBayCommand identifier should be null" );
  }

  /** handles update validation for a Bay */
  public void validate(UpdateBayCommand bay) throws Exception {
    Assert.notNull(bay, "UpdateBayCommand should not be null");
    Assert.notNull(bay.getBayId(), "UpdateBayCommand identifier should not be null");
  }

  /** handles delete validation for a Bay */
  public void validate(DeleteBayCommand bay) throws Exception {
    Assert.notNull(bay, "{commandAlias} should not be null");
    Assert.notNull(bay.getBayId(), "DeleteBayCommand identifier should not be null");
  }

  /** handles fetchOne validation for a Bay */
  public void validate(BayFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "BayFetchOneSummary should not be null");
    Assert.notNull(summary.getBayId(), "BayFetchOneSummary identifier should not be null");
  }

  /**
   * handles add to Bays validation for a Bay
   *
   * @param command AssignBaysToBayCommand
   */
  public void validate(AssignBaysToBayCommand command) throws Exception {
    Assert.notNull(command, "AssignBaysToBayCommand should not be null");
    Assert.notNull(command.getBayId(), "AssignBaysToBayCommand identifier should not be null");
    Assert.notNull(command.getAddTo(), "AssignBaysToBayCommand addTo attribute should not be null");
  }

  /**
   * handles remove from Bays validation for a Bay
   *
   * @param command RemoveBaysFromBayCommand
   */
  public void validate(RemoveBaysFromBayCommand command) throws Exception {
    Assert.notNull(command, "RemoveBaysFromBayCommand should not be null");
    Assert.notNull(command.getBayId(), "RemoveBaysFromBayCommand identifier should not be null");
    Assert.notNull(
        command.getRemoveFrom(),
        "RemoveBaysFromBayCommand removeFrom attribute should not be null");
    Assert.notNull(
        command.getRemoveFrom().getBayId(),
        "RemoveBaysFromBayCommand removeFrom attribubte identifier should not be null");
  }
}
