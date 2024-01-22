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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.topology.subscriber;

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
 * Subscriber for BusNameMarker related events. .
 *
 * @author your_name_here
 */
@Component("busNameMarker-subscriber")
public class BusNameMarkerSubscriber extends BaseSubscriber {

  public BusNameMarkerSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<BusNameMarker>, BusNameMarker> busNameMarkerSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllBusNameMarkerQuery(),
        ResponseTypes.multipleInstancesOf(BusNameMarker.class),
        ResponseTypes.instanceOf(BusNameMarker.class));
  }

  public SubscriptionQueryResult<BusNameMarker, BusNameMarker> busNameMarkerSubscribe(
      @DestinationVariable UUID busNameMarkerId) {
    return queryGateway.subscriptionQuery(
        new FindBusNameMarkerQuery(new LoadBusNameMarkerFilter(busNameMarkerId)),
        ResponseTypes.instanceOf(BusNameMarker.class),
        ResponseTypes.instanceOf(BusNameMarker.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
