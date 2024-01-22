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
package com.occulue.europeanstandards.commongridmodelexchangestandard.domainprofile.subscriber;

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
 * Subscriber for Capacitance related events. .
 *
 * @author your_name_here
 */
@Component("capacitance-subscriber")
public class CapacitanceSubscriber extends BaseSubscriber {

  public CapacitanceSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<Capacitance>, Capacitance> capacitanceSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllCapacitanceQuery(),
        ResponseTypes.multipleInstancesOf(Capacitance.class),
        ResponseTypes.instanceOf(Capacitance.class));
  }

  public SubscriptionQueryResult<Capacitance, Capacitance> capacitanceSubscribe(
      @DestinationVariable UUID capacitanceId) {
    return queryGateway.subscriptionQuery(
        new FindCapacitanceQuery(new LoadCapacitanceFilter(capacitanceId)),
        ResponseTypes.instanceOf(Capacitance.class),
        ResponseTypes.instanceOf(Capacitance.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
