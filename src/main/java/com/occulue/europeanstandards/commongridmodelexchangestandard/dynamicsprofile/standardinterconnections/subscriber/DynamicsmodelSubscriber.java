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
package com.occulue.europeanstandards.commongridmodelexchangestandard.dynamicsprofile.standardinterconnections.subscriber;

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
 * Subscriber for Dynamicsmodel related events. .
 *
 * @author your_name_here
 */
@Component("dynamicsmodel-subscriber")
public class DynamicsmodelSubscriber extends BaseSubscriber {

  public DynamicsmodelSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<Dynamicsmodel>, Dynamicsmodel> dynamicsmodelSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllDynamicsmodelQuery(),
        ResponseTypes.multipleInstancesOf(Dynamicsmodel.class),
        ResponseTypes.instanceOf(Dynamicsmodel.class));
  }

  public SubscriptionQueryResult<Dynamicsmodel, Dynamicsmodel> dynamicsmodelSubscribe(
      @DestinationVariable UUID dynamicsmodelId) {
    return queryGateway.subscriptionQuery(
        new FindDynamicsmodelQuery(new LoadDynamicsmodelFilter(dynamicsmodelId)),
        ResponseTypes.instanceOf(Dynamicsmodel.class),
        ResponseTypes.instanceOf(Dynamicsmodel.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
