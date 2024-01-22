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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.voltageadjusterdynamics.subscriber;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.exception.*;
import com.occulue.subscriber.*;
import java.util.*;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.SubscriptionQueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.stereotype.Component;

/**
 * Subscriber for VoltageAdjusterDynamics related events. .
 *
 * @author your_name_here
 */
@Component("voltageAdjusterDynamics-subscriber")
public class VoltageAdjusterDynamicsSubscriber extends BaseSubscriber {

  public VoltageAdjusterDynamicsSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<VoltageAdjusterDynamics>, VoltageAdjusterDynamics>
      voltageAdjusterDynamicsSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllVoltageAdjusterDynamicsQuery(),
        ResponseTypes.multipleInstancesOf(VoltageAdjusterDynamics.class),
        ResponseTypes.instanceOf(VoltageAdjusterDynamics.class));
  }

  public SubscriptionQueryResult<VoltageAdjusterDynamics, VoltageAdjusterDynamics>
      voltageAdjusterDynamicsSubscribe(@DestinationVariable UUID voltageAdjusterDynamicsId) {
    return queryGateway.subscriptionQuery(
        new FindVoltageAdjusterDynamicsQuery(
            new LoadVoltageAdjusterDynamicsFilter(voltageAdjusterDynamicsId)),
        ResponseTypes.instanceOf(VoltageAdjusterDynamics.class),
        ResponseTypes.instanceOf(VoltageAdjusterDynamics.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
