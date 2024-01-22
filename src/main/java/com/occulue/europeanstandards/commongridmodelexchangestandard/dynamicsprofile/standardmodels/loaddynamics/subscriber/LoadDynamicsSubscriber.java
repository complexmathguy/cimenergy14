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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardmodels.loaddynamics.subscriber;

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
 * Subscriber for LoadDynamics related events. .
 *
 * @author your_name_here
 */
@Component("loadDynamics-subscriber")
public class LoadDynamicsSubscriber extends BaseSubscriber {

  public LoadDynamicsSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<LoadDynamics>, LoadDynamics> loadDynamicsSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllLoadDynamicsQuery(),
        ResponseTypes.multipleInstancesOf(LoadDynamics.class),
        ResponseTypes.instanceOf(LoadDynamics.class));
  }

  public SubscriptionQueryResult<LoadDynamics, LoadDynamics> loadDynamicsSubscribe(
      @DestinationVariable UUID loadDynamicsId) {
    return queryGateway.subscriptionQuery(
        new FindLoadDynamicsQuery(new LoadLoadDynamicsFilter(loadDynamicsId)),
        ResponseTypes.instanceOf(LoadDynamics.class),
        ResponseTypes.instanceOf(LoadDynamics.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
