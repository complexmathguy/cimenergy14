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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.production.subscriber;

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
 * Subscriber for HydroPump related events. .
 *
 * @author your_name_here
 */
@Component("hydroPump-subscriber")
public class HydroPumpSubscriber extends BaseSubscriber {

  public HydroPumpSubscriber() {
    queryGateway = applicationContext.getBean(QueryGateway.class);
  }

  public SubscriptionQueryResult<List<HydroPump>, HydroPump> hydroPumpSubscribe() {
    return queryGateway.subscriptionQuery(
        new FindAllHydroPumpQuery(),
        ResponseTypes.multipleInstancesOf(HydroPump.class),
        ResponseTypes.instanceOf(HydroPump.class));
  }

  public SubscriptionQueryResult<HydroPump, HydroPump> hydroPumpSubscribe(
      @DestinationVariable UUID hydroPumpId) {
    return queryGateway.subscriptionQuery(
        new FindHydroPumpQuery(new LoadHydroPumpFilter(hydroPumpId)),
        ResponseTypes.instanceOf(HydroPump.class),
        ResponseTypes.instanceOf(HydroPump.class));
  }

  // -------------------------------------------------
  // attributes
  // -------------------------------------------------
  @Autowired private final QueryGateway queryGateway;
}
