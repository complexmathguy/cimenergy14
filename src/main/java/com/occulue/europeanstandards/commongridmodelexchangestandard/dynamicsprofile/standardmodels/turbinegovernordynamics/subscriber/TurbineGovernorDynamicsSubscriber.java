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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.turbinegovernordynamics.subscriber;

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
 * Subscriber for TurbineGovernorDynamics related events. .
 *
 * @author your_name_here
 */
@Component("turbineGovernorDynamics-subscriber")
public class TurbineGovernorDynamicsSubscriber extends BaseSubscriber {

  public TurbineGovernorDynamicsSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<TurbineGovernorDynamics>, TurbineGovernorDynamics>
      turbineGovernorDynamicsSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllTurbineGovernorDynamicsQuery(),
        ResponseTypes.multipleInstancesOf(TurbineGovernorDynamics.class),
        ResponseTypes.instanceOf(TurbineGovernorDynamics.class));
  }

  public SubscriptionQueryResult<TurbineGovernorDynamics, TurbineGovernorDynamics>
      turbineGovernorDynamicsSubscribe(@DestinationVariable UUID turbineGovernorDynamicsId) {
    return queryGateway.subscriptionQuery(
        new FindTurbineGovernorDynamicsQuery(
            new LoadTurbineGovernorDynamicsFilter(turbineGovernorDynamicsId)),
        ResponseTypes.instanceOf(TurbineGovernorDynamics.class),
        ResponseTypes.instanceOf(TurbineGovernorDynamics.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
