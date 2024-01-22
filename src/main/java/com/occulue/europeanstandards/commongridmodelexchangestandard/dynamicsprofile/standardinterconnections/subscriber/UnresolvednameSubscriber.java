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
 * Subscriber for Unresolvedname related events. .
 *
 * @author your_name_here
 */
@Component("unresolvedname-subscriber")
public class UnresolvednameSubscriber extends BaseSubscriber {

  public UnresolvednameSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<Unresolvedname>, Unresolvedname> unresolvednameSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllUnresolvednameQuery(),
        ResponseTypes.multipleInstancesOf(Unresolvedname.class),
        ResponseTypes.instanceOf(Unresolvedname.class));
  }

  public SubscriptionQueryResult<Unresolvedname, Unresolvedname> unresolvednameSubscribe(
      @DestinationVariable UUID unresolvednameId) {
    return queryGateway.subscriptionQuery(
        new FindUnresolvednameQuery(new LoadUnresolvednameFilter(unresolvednameId)),
        ResponseTypes.instanceOf(Unresolvedname.class),
        ResponseTypes.instanceOf(Unresolvedname.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
