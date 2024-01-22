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
 * Subscriber for CoordinateSystem related events. .
 *
 * @author your_name_here
 */
@Component("coordinateSystem-subscriber")
public class CoordinateSystemSubscriber extends BaseSubscriber {

  public CoordinateSystemSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<CoordinateSystem>, CoordinateSystem>
      coordinateSystemSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllCoordinateSystemQuery(),
        ResponseTypes.multipleInstancesOf(CoordinateSystem.class),
        ResponseTypes.instanceOf(CoordinateSystem.class));
  }

  public SubscriptionQueryResult<CoordinateSystem, CoordinateSystem> coordinateSystemSubscribe(
      @DestinationVariable UUID coordinateSystemId) {
    return queryGateway.subscriptionQuery(
        new FindCoordinateSystemQuery(new LoadCoordinateSystemFilter(coordinateSystemId)),
        ResponseTypes.instanceOf(CoordinateSystem.class),
        ResponseTypes.instanceOf(CoordinateSystem.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
