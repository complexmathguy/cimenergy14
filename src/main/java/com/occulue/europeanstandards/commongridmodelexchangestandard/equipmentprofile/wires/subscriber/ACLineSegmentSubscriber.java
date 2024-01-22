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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.wires.subscriber;

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
 * Subscriber for ACLineSegment related events. .
 *
 * @author your_name_here
 */
@Component("aCLineSegment-subscriber")
public class ACLineSegmentSubscriber extends BaseSubscriber {

  public ACLineSegmentSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<ACLineSegment>, ACLineSegment> aCLineSegmentSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllACLineSegmentQuery(),
        ResponseTypes.multipleInstancesOf(ACLineSegment.class),
        ResponseTypes.instanceOf(ACLineSegment.class));
  }

  public SubscriptionQueryResult<ACLineSegment, ACLineSegment> aCLineSegmentSubscribe(
      @DestinationVariable UUID aCLineSegmentId) {
    return queryGateway.subscriptionQuery(
        new FindACLineSegmentQuery(new LoadACLineSegmentFilter(aCLineSegmentId)),
        ResponseTypes.instanceOf(ACLineSegment.class),
        ResponseTypes.instanceOf(ACLineSegment.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
