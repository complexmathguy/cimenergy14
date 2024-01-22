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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.subscriber;

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
 * Subscriber for RotatingMachineDynamics related events. .
 *
 * @author your_name_here
 */
@Component("rotatingMachineDynamics-subscriber")
public class RotatingMachineDynamicsSubscriber extends BaseSubscriber {

  public RotatingMachineDynamicsSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<RotatingMachineDynamics>, RotatingMachineDynamics>
      rotatingMachineDynamicsSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllRotatingMachineDynamicsQuery(),
        ResponseTypes.multipleInstancesOf(RotatingMachineDynamics.class),
        ResponseTypes.instanceOf(RotatingMachineDynamics.class));
  }

  public SubscriptionQueryResult<RotatingMachineDynamics, RotatingMachineDynamics>
      rotatingMachineDynamicsSubscribe(@DestinationVariable UUID rotatingMachineDynamicsId) {
    return queryGateway.subscriptionQuery(
        new FindRotatingMachineDynamicsQuery(
            new LoadRotatingMachineDynamicsFilter(rotatingMachineDynamicsId)),
        ResponseTypes.instanceOf(RotatingMachineDynamics.class),
        ResponseTypes.instanceOf(RotatingMachineDynamics.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
