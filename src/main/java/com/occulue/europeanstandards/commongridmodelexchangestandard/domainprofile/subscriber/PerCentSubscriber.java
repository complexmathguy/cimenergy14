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
 * Subscriber for PerCent related events. .
 *
 * @author your_name_here
 */
@Component("perCent-subscriber")
public class PerCentSubscriber extends BaseSubscriber {

  public PerCentSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<PerCent>, PerCent> perCentSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllPerCentQuery(),
        ResponseTypes.multipleInstancesOf(PerCent.class),
        ResponseTypes.instanceOf(PerCent.class));
  }

  public SubscriptionQueryResult<PerCent, PerCent> perCentSubscribe(
      @DestinationVariable UUID perCentId) {
    return queryGateway.subscriptionQuery(
        new FindPerCentQuery(new LoadPerCentFilter(perCentId)),
        ResponseTypes.instanceOf(PerCent.class),
        ResponseTypes.instanceOf(PerCent.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
