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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.voltagecompensatordynamics.subscriber;

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
 * Subscriber for VoltageCompensatorDynamics related events. .
 *
 * @author your_name_here
 */
@Component("voltageCompensatorDynamics-subscriber")
public class VoltageCompensatorDynamicsSubscriber extends BaseSubscriber {

  public VoltageCompensatorDynamicsSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<VoltageCompensatorDynamics>, VoltageCompensatorDynamics>
      voltageCompensatorDynamicsSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllVoltageCompensatorDynamicsQuery(),
        ResponseTypes.multipleInstancesOf(VoltageCompensatorDynamics.class),
        ResponseTypes.instanceOf(VoltageCompensatorDynamics.class));
  }

  public SubscriptionQueryResult<VoltageCompensatorDynamics, VoltageCompensatorDynamics>
      voltageCompensatorDynamicsSubscribe(@DestinationVariable UUID voltageCompensatorDynamicsId) {
    return queryGateway.subscriptionQuery(
        new FindVoltageCompensatorDynamicsQuery(
            new LoadVoltageCompensatorDynamicsFilter(voltageCompensatorDynamicsId)),
        ResponseTypes.instanceOf(VoltageCompensatorDynamics.class),
        ResponseTypes.instanceOf(VoltageCompensatorDynamics.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
