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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardinterconnections.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class UnresolvednameValidator {

  /** default constructor */
  protected UnresolvednameValidator() {}

  /** factory method */
  public static UnresolvednameValidator getInstance() {
    return new UnresolvednameValidator();
  }

  /** handles creation validation for a Unresolvedname */
  public void validate(CreateUnresolvednameCommand unresolvedname) throws Exception {
    Assert.notNull(unresolvedname, "CreateUnresolvednameCommand should not be null");
    //		Assert.isNull( unresolvedname.getUnresolvednameId(), "CreateUnresolvednameCommand identifier
    // should be null" );
  }

  /** handles update validation for a Unresolvedname */
  public void validate(UpdateUnresolvednameCommand unresolvedname) throws Exception {
    Assert.notNull(unresolvedname, "UpdateUnresolvednameCommand should not be null");
    Assert.notNull(
        unresolvedname.getUnresolvednameId(),
        "UpdateUnresolvednameCommand identifier should not be null");
  }

  /** handles delete validation for a Unresolvedname */
  public void validate(DeleteUnresolvednameCommand unresolvedname) throws Exception {
    Assert.notNull(unresolvedname, "{commandAlias} should not be null");
    Assert.notNull(
        unresolvedname.getUnresolvednameId(),
        "DeleteUnresolvednameCommand identifier should not be null");
  }

  /** handles fetchOne validation for a Unresolvedname */
  public void validate(UnresolvednameFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "UnresolvednameFetchOneSummary should not be null");
    Assert.notNull(
        summary.getUnresolvednameId(),
        "UnresolvednameFetchOneSummary identifier should not be null");
  }
}
