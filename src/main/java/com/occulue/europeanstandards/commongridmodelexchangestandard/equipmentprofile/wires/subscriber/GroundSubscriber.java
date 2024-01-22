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
 * Subscriber for Ground related events. .
 *
 * @author your_name_here
 */
@Component("ground-subscriber")
public class GroundSubscriber extends BaseSubscriber {

  public GroundSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<Ground>, Ground> groundSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllGroundQuery(),
        ResponseTypes.multipleInstancesOf(Ground.class),
        ResponseTypes.instanceOf(Ground.class));
  }

  public SubscriptionQueryResult<Ground, Ground> groundSubscribe(
      @DestinationVariable UUID groundId) {
    return queryGateway.subscriptionQuery(
        new FindGroundQuery(new LoadGroundFilter(groundId)),
        ResponseTypes.instanceOf(Ground.class),
        ResponseTypes.instanceOf(Ground.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
