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
package com.occulue.europeanstandards.extension.subscriber;

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
 * Subscriber for BoundaryExtensions related events. .
 *
 * @author your_name_here
 */
@Component("boundaryExtensions-subscriber")
public class BoundaryExtensionsSubscriber extends BaseSubscriber {

  public BoundaryExtensionsSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<BoundaryExtensions>, BoundaryExtensions>
      boundaryExtensionsSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllBoundaryExtensionsQuery(),
        ResponseTypes.multipleInstancesOf(BoundaryExtensions.class),
        ResponseTypes.instanceOf(BoundaryExtensions.class));
  }

  public SubscriptionQueryResult<BoundaryExtensions, BoundaryExtensions>
      boundaryExtensionsSubscribe(@DestinationVariable UUID boundaryExtensionsId) {
    return queryGateway.subscriptionQuery(
        new FindBoundaryExtensionsQuery(new LoadBoundaryExtensionsFilter(boundaryExtensionsId)),
        ResponseTypes.instanceOf(BoundaryExtensions.class),
        ResponseTypes.instanceOf(BoundaryExtensions.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
