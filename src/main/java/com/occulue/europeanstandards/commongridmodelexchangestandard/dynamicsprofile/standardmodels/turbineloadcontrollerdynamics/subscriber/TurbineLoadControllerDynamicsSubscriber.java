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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.turbineloadcontrollerdynamics.subscriber;

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
 * Subscriber for TurbineLoadControllerDynamics related events. .
 *
 * @author your_name_here
 */
@Component("turbineLoadControllerDynamics-subscriber")
public class TurbineLoadControllerDynamicsSubscriber extends BaseSubscriber {

  public TurbineLoadControllerDynamicsSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<TurbineLoadControllerDynamics>, TurbineLoadControllerDynamics>
      turbineLoadControllerDynamicsSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllTurbineLoadControllerDynamicsQuery(),
        ResponseTypes.multipleInstancesOf(TurbineLoadControllerDynamics.class),
        ResponseTypes.instanceOf(TurbineLoadControllerDynamics.class));
  }

  public SubscriptionQueryResult<TurbineLoadControllerDynamics, TurbineLoadControllerDynamics>
      turbineLoadControllerDynamicsSubscribe(
          @DestinationVariable UUID turbineLoadControllerDynamicsId) {
    return queryGateway.subscriptionQuery(
        new FindTurbineLoadControllerDynamicsQuery(
            new LoadTurbineLoadControllerDynamicsFilter(turbineLoadControllerDynamicsId)),
        ResponseTypes.instanceOf(TurbineLoadControllerDynamics.class),
        ResponseTypes.instanceOf(TurbineLoadControllerDynamics.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
