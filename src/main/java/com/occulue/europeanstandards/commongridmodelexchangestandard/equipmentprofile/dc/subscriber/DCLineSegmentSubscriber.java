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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.subscriber;

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
 * Subscriber for DCLineSegment related events. .
 *
 * @author your_name_here
 */
@Component("dCLineSegment-subscriber")
public class DCLineSegmentSubscriber extends BaseSubscriber {

  public DCLineSegmentSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<DCLineSegment>, DCLineSegment> dCLineSegmentSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllDCLineSegmentQuery(),
        ResponseTypes.multipleInstancesOf(DCLineSegment.class),
        ResponseTypes.instanceOf(DCLineSegment.class));
  }

  public SubscriptionQueryResult<DCLineSegment, DCLineSegment> dCLineSegmentSubscribe(
      @DestinationVariable UUID dCLineSegmentId) {
    return queryGateway.subscriptionQuery(
        new FindDCLineSegmentQuery(new LoadDCLineSegmentFilter(dCLineSegmentId)),
        ResponseTypes.instanceOf(DCLineSegment.class),
        ResponseTypes.instanceOf(DCLineSegment.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
