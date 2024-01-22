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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.core.subscriber;

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
 * Subscriber for RegularTimePoint related events. .
 *
 * @author your_name_here
 */
@Component("regularTimePoint-subscriber")
public class RegularTimePointSubscriber extends BaseSubscriber {

  public RegularTimePointSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<RegularTimePoint>, RegularTimePoint>
      regularTimePointSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllRegularTimePointQuery(),
        ResponseTypes.multipleInstancesOf(RegularTimePoint.class),
        ResponseTypes.instanceOf(RegularTimePoint.class));
  }

  public SubscriptionQueryResult<RegularTimePoint, RegularTimePoint> regularTimePointSubscribe(
      @DestinationVariable UUID regularTimePointId) {
    return queryGateway.subscriptionQuery(
        new FindRegularTimePointQuery(new LoadRegularTimePointFilter(regularTimePointId)),
        ResponseTypes.instanceOf(RegularTimePoint.class),
        ResponseTypes.instanceOf(RegularTimePoint.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
