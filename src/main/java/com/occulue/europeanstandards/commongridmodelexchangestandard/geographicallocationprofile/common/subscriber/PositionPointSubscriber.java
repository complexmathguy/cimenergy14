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
package com.occulue.europeanstandards.commongridmodelexchangestandard.geographicallocationprofile.common.subscriber;

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
 * Subscriber for PositionPoint related events. .
 *
 * @author your_name_here
 */
@Component("positionPoint-subscriber")
public class PositionPointSubscriber extends BaseSubscriber {

  public PositionPointSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<PositionPoint>, PositionPoint> positionPointSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllPositionPointQuery(),
        ResponseTypes.multipleInstancesOf(PositionPoint.class),
        ResponseTypes.instanceOf(PositionPoint.class));
  }

  public SubscriptionQueryResult<PositionPoint, PositionPoint> positionPointSubscribe(
      @DestinationVariable UUID positionPointId) {
    return queryGateway.subscriptionQuery(
        new FindPositionPointQuery(new LoadPositionPointFilter(positionPointId)),
        ResponseTypes.instanceOf(PositionPoint.class),
        ResponseTypes.instanceOf(PositionPoint.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
