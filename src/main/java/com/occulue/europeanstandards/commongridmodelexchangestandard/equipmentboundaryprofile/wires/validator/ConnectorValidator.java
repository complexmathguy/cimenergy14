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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentboundaryprofile.wires.validator;

import com.occulue.api.*;
import org.springframework.util.Assert;

public class ConnectorValidator {

  /** default constructor */
  protected ConnectorValidator() {}

  /** factory method */
  public static ConnectorValidator getInstance() {
    return new ConnectorValidator();
  }

  /** handles creation validation for a Connector */
  public void validate(CreateConnectorCommand connector) throws Exception {
    Assert.notNull(connector, "CreateConnectorCommand should not be null");
    //		Assert.isNull( connector.getConnectorId(), "CreateConnectorCommand identifier should be
    // null" );
  }

  /** handles update validation for a Connector */
  public void validate(UpdateConnectorCommand connector) throws Exception {
    Assert.notNull(connector, "UpdateConnectorCommand should not be null");
    Assert.notNull(
        connector.getConnectorId(), "UpdateConnectorCommand identifier should not be null");
  }

  /** handles delete validation for a Connector */
  public void validate(DeleteConnectorCommand connector) throws Exception {
    Assert.notNull(connector, "{commandAlias} should not be null");
    Assert.notNull(
        connector.getConnectorId(), "DeleteConnectorCommand identifier should not be null");
  }

  /** handles fetchOne validation for a Connector */
  public void validate(ConnectorFetchOneSummary summary) throws Exception {
    Assert.notNull(summary, "ConnectorFetchOneSummary should not be null");
    Assert.notNull(
        summary.getConnectorId(), "ConnectorFetchOneSummary identifier should not be null");
  }
}
