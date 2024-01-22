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
 * Subscriber for BooleanProxy related events. .
 *
 * @author your_name_here
 */
@Component("booleanProxy-subscriber")
public class BooleanProxySubscriber extends BaseSubscriber {

  public BooleanProxySubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<BooleanProxy>, BooleanProxy> booleanProxySubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllBooleanProxyQuery(),
        ResponseTypes.multipleInstancesOf(BooleanProxy.class),
        ResponseTypes.instanceOf(BooleanProxy.class));
  }

  public SubscriptionQueryResult<BooleanProxy, BooleanProxy> booleanProxySubscribe(
      @DestinationVariable UUID booleanProxyId) {
    return queryGateway.subscriptionQuery(
        new FindBooleanProxyQuery(new LoadBooleanProxyFilter(booleanProxyId)),
        ResponseTypes.instanceOf(BooleanProxy.class),
        ResponseTypes.instanceOf(BooleanProxy.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
