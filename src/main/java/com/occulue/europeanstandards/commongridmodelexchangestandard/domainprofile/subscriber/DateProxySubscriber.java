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
 * Subscriber for DateProxy related events. .
 *
 * @author your_name_here
 */
@Component("dateProxy-subscriber")
public class DateProxySubscriber extends BaseSubscriber {

  public DateProxySubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<DateProxy>, DateProxy> dateProxySubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllDateProxyQuery(),
        ResponseTypes.multipleInstancesOf(DateProxy.class),
        ResponseTypes.instanceOf(DateProxy.class));
  }

  public SubscriptionQueryResult<DateProxy, DateProxy> dateProxySubscribe(
      @DestinationVariable UUID dateProxyId) {
    return queryGateway.subscriptionQuery(
        new FindDateProxyQuery(new LoadDateProxyFilter(dateProxyId)),
        ResponseTypes.instanceOf(DateProxy.class),
        ResponseTypes.instanceOf(DateProxy.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
